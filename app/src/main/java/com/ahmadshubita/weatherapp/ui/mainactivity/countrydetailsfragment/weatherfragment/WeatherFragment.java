package com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.weatherfragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ahmadshubita.weatherapp.R;
import com.ahmadshubita.weatherapp.data.network.model.Weather;
import com.ahmadshubita.weatherapp.data.network.model.WeatherResponse;
import com.ahmadshubita.weatherapp.di.component.ActivityComponent;
import com.ahmadshubita.weatherapp.ui.base.BaseFragment;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.CountryDetailsMvpInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.CountryDetailsMvpPresenter;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.CountryDetailsMvpView;
import com.ahmadshubita.weatherapp.utils.AppLogger;
import com.ahmadshubita.weatherapp.utils.CommonUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WeatherFragment extends BaseFragment implements WeatherMvpView {


    @BindView(R.id.dateTxt)
    TextView dateTxt;

    @BindView(R.id.minMaxTxt)
    TextView minMaxTxt;

    @BindView(R.id.pressureTxt)
    TextView pressureTxt;

    @Inject
    WeatherMvpPresenter<WeatherMvpView, WeatherMvpInteractor> mPresenter;


    public WeatherFragment() {
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
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }
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

    }


    @Override
    public void updateWeather(Weather weather) {
        setWeatherInfo(weather);
    }

    private void setWeatherInfo(Weather weatherInfo) {
        dateTxt.setText(CommonUtils.setDateText(weatherInfo.getDate()));
        minMaxTxt.setText(weatherInfo.getMain().getTempMin()+" - "+ weatherInfo.getMain().getTempMax());
        pressureTxt.setText(weatherInfo.getMain().getPressure()+"");
    }


}
