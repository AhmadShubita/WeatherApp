package com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadshubita.weatherapp.R;
import com.ahmadshubita.weatherapp.data.network.model.Country;
import com.ahmadshubita.weatherapp.data.network.model.Weather;
import com.ahmadshubita.weatherapp.data.network.model.WeatherResponse;
import com.ahmadshubita.weatherapp.di.component.ActivityComponent;
import com.ahmadshubita.weatherapp.ui.base.BaseFragment;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.weatherfragment.WeatherFragment;
import com.ahmadshubita.weatherapp.utils.AppConstants;
import com.ahmadshubita.weatherapp.utils.AppLogger;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CountryDetailsFragment extends BaseFragment implements CountryDetailsMvpView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    @BindView(R.id.countryImg)
    ImageView countryImg;

    @BindView(R.id.nameTxt)
    TextView countryNameTxt;

    @BindView(R.id.regionTxt)
    TextView regionTxt;

    @BindView(R.id.populationTxt)
    TextView populationTxt;

    @BindView(R.id.captialTxt)
    TextView capitalTxt;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Inject
    CountryDetailsMvpPresenter<CountryDetailsMvpView, CountryDetailsMvpInteractor> mPresenter;

    Country country;

    WeatherResponse weatherResponse;

    TabClicked mCallback;

    private static final String COUNTRY_KEY = "country_key";

    public interface TabClicked{
        public void sendObjectWeather(Weather weather, int position);
    }

    public CountryDetailsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CountryDetailsFragment newInstance(Country country) {
        CountryDetailsFragment fragment = new CountryDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(COUNTRY_KEY, country);
        fragment.setArguments(args);
        return fragment;
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
        View view =  inflater.inflate(R.layout.fragment_country_details, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);

        }
        country = (Country) getArguments().getSerializable(COUNTRY_KEY);
        mPresenter.fetchWeatherData();

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected void setUp(View view) {
        setCountryDetails();
        bindViewPagerAdapter();
        bindViewPagerTabs();

    }

    private void bindViewPagerAdapter() {
        final WeatherPagerAdapter adapter = new WeatherPagerAdapter(viewPager.getContext(), getChildFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);

        try {
            mCallback = (TabClicked)adapter ;
        } catch (ClassCastException e) {
            throw new ClassCastException(adapter.toString()
                    + " must implement TextClicked");
        }
    }

    private void bindViewPagerTabs() {
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
            public void onTabSelected(TabLayout.Tab tab) {
               if(weatherResponse!= null) {
                   switch (viewPager.getCurrentItem()) {
                       case 0: {
                           mCallback.sendObjectWeather(weatherResponse.getWeatherList().get(0), viewPager.getCurrentItem());
                           break;
                       }
                       case 1: {
                           mCallback.sendObjectWeather(weatherResponse.getWeatherList().get(1), viewPager.getCurrentItem());
                           break;
                       }
                   }
               }

            }
           @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
           @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public void setCountryDetails() {
        if(country.getName()!=null){
            countryNameTxt.setText(country.getName());
        }
        if(country.getRegion()!=null){
            regionTxt.setText(country.getRegion());
        }
        if(country.getCapital()!=null){
            capitalTxt.setText(country.getCapital());
        }
        if(country.getPopulation()!=null){
            populationTxt.setText(country.getPopulation()+"");
        }
        if(country.getCountryCode()!=null){
            Picasso.get().load(AppConstants.FLAG_URL+country.getCountryCode()+".png").fit().into(countryImg);
        }
    }

    @Override
    public void updateWeather(WeatherResponse weatherResponse) {
        this.weatherResponse = weatherResponse;
        if(weatherResponse.getWeatherList().get(0) != null) {
            mCallback.sendObjectWeather(weatherResponse.getWeatherList().get(0), 0);
        }
        if(weatherResponse.getWeatherList().get(1) != null) {
            mCallback.sendObjectWeather(weatherResponse.getWeatherList().get(1), 1);
        }

    }

    @OnClick(R.id.closeDetailsBtn)
    public void onCloseClick(){
        getActivity().onBackPressed();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
