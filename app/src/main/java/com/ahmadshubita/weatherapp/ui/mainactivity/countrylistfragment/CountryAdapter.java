package com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadshubita.weatherapp.R;
import com.ahmadshubita.weatherapp.data.network.model.Country;
import com.ahmadshubita.weatherapp.ui.base.BaseViewHolder;
import com.ahmadshubita.weatherapp.utils.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by AhmadShubita on 12/2/19.
 */

public class CountryAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    // Variable
    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;


    private Callback mCallback;
    private RecyclerViewClickListener mListener;
    private List<Country> mCountryList;


    public CountryAdapter() {this.mCountryList = Collections.emptyList();}

    public CountryAdapter(List<Country> mCountryList) {
        this.mCountryList = mCountryList;

    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }


    public void setListener(RecyclerViewClickListener listener) {
        mListener = listener;
    }


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL: {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
                return new ViewHolder(itemView,mListener);
            }
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, final int position) {
        holder.onBind(position);

    }


    @Override
    public int getItemViewType(int position) {
        if (mCountryList != null && mCountryList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }


    @Override
    public int getItemCount() {
        if (mCountryList != null && mCountryList.size() > 0) {
            return mCountryList.size();
        } else {
            return 1;
        }
    }


    public void addItems(List<Country> repoList) {
        mCountryList = new ArrayList<>();
        mCountryList.addAll(repoList);
        notifyDataSetChanged();
    }


    public interface Callback {
        void onRepoEmptyViewRetryClick();
    }


    public interface RecyclerViewClickListener {

        void onClick(View view, int position,Country country, boolean flag);
    }


    public class ViewHolder extends BaseViewHolder implements View.OnClickListener {

        @BindView(R.id.countryImg)
        ImageView countryImg;

        @BindView(R.id.countryTxt)
        TextView countryTxt;

        @BindView(R.id.areaTxt)
        TextView regionTxt;

        private RecyclerViewClickListener mListener;

        public ViewHolder(View itemView, RecyclerViewClickListener listener){
            super(itemView);
            ButterKnife.bind(this,itemView);
            mListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        protected void clear() {
            countryImg.setImageDrawable(null);
            countryTxt.setText("");
            regionTxt.setText("");
        }

        public void onBind( int position) {
            super.onBind(position);
            Country country = mCountryList.get(position);
            Picasso.get().load(AppConstants.FLAG_URL+country.getCountryCode()+".png").fit().into(countryImg);

            if(country.getName()!=null){
                countryTxt.setText(country.getName());
            }
            if(country.getRegion()!=null){
                regionTxt.setText(country.getRegion());
            }

        }

        @Override
        public void onClick(View v) {
            mListener.onClick(v,getAdapterPosition(),mCountryList.get(getAdapterPosition()),true);

        }
    }


    public class EmptyViewHolder extends BaseViewHolder {

        @BindView(R.id.btn_retry)
        Button retryButton;


        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {
        }

        @OnClick(R.id.btn_retry)
        void onRetryClick() {
            if (mCallback != null)
                mCallback.onRepoEmptyViewRetryClick();
        }
    }
}
