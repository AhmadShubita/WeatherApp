package com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.weatherfragment;

import android.content.Context;

import com.ahmadshubita.weatherapp.data.network.APIInterface;
import com.ahmadshubita.weatherapp.data.network.model.WeatherResponse;
import com.ahmadshubita.weatherapp.data.prefs.PreferencesHelper;
import com.ahmadshubita.weatherapp.di.qualifier.ApplicationContext;
import com.ahmadshubita.weatherapp.ui.base.BaseInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.CountryDetailsMvpInteractor;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by AhmadShubita on 12/2/19.
 **/

public class WeatherInteractor extends BaseInteractor implements WeatherMvpInteractor {

    private Context mContext;

    @Inject
    public WeatherInteractor(@ApplicationContext Context context, PreferencesHelper preferencesHelper, APIInterface apiInterface) {
        super(preferencesHelper,apiInterface);
        mContext = context;
    }

}
