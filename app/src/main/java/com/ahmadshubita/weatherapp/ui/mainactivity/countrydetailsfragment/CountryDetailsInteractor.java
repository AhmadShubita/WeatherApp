package com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment;

import android.content.Context;

import com.ahmadshubita.weatherapp.data.network.APIInterface;
import com.ahmadshubita.weatherapp.data.network.model.Country;
import com.ahmadshubita.weatherapp.data.network.model.WeatherResponse;
import com.ahmadshubita.weatherapp.data.prefs.PreferencesHelper;
import com.ahmadshubita.weatherapp.di.qualifier.ApplicationContext;
import com.ahmadshubita.weatherapp.ui.base.BaseInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by AhmadShubita on 12/2/19.
 **/

public class CountryDetailsInteractor extends BaseInteractor implements CountryDetailsMvpInteractor {

    private Context mContext;

    @Inject
    public CountryDetailsInteractor(@ApplicationContext Context context, PreferencesHelper preferencesHelper, APIInterface apiInterface) {
        super(preferencesHelper,apiInterface);
        mContext = context;
    }


    @Override
    public Observable<WeatherResponse> fetchWeatherData() {
        return getApiInterface().getWeatherData();
    }
}
