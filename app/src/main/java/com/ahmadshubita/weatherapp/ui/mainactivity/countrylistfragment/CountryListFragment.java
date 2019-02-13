package com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmadshubita.weatherapp.R;
import com.ahmadshubita.weatherapp.data.network.model.Country;
import com.ahmadshubita.weatherapp.di.component.ActivityComponent;
import com.ahmadshubita.weatherapp.ui.base.BaseFragment;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.CountryDetailsFragment;
import com.ahmadshubita.weatherapp.utils.ActivityUtils;
import com.ahmadshubita.weatherapp.utils.AppLogger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CountryListFragment extends BaseFragment implements CountryListMvpView , CountryAdapter.Callback, CountryAdapter.RecyclerViewClickListener{





    @BindView(R.id.countryList)
    RecyclerView countryList;

    @BindView(R.id.mainToolbar)
    Toolbar mToolbar;


//    @Inject
    CountryAdapter adapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @Inject
    CountryListMvpPresenter<CountryListMvpView, CountryListMvpInteractor> mPresenter;




    public CountryListFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppLogger.d(getString(R.string.fragmentCreated));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_country_list, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            adapter = new CountryAdapter();
            adapter.setListener(this);

        }

        mPresenter.fetchCountries();

        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    protected void setUp(View view) {
        mToolbar.setTitle(R.string.app_name);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        countryList.setLayoutManager(mLayoutManager);
        countryList.setAdapter(adapter);
    }


    @Override
    public void updateCountryList(List<Country> countryList) {
        if(countryList.size()>0) {
            adapter.addItems(countryList);
        }
    }

    @Override
    public void onRepoEmptyViewRetryClick() {

    }

    @Override
    public void onClick(View view, int position,Country country, boolean flag) {

        ActivityUtils.addFragmentToActivityAndBackSackWithAnim(getActivity().getSupportFragmentManager(), new CountryDetailsFragment().newInstance(country), R.id.mainContainer, R.anim.animation_enter, R.anim.animation_leave, "CountryDetailsFragment");

    }


}
