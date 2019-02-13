package com.ahmadshubita.weatherapp.ui.mainactivity;

import android.content.Context;

import com.ahmadshubita.weatherapp.data.network.APIInterface;
import com.ahmadshubita.weatherapp.data.network.model.Country;
import com.ahmadshubita.weatherapp.data.prefs.PreferencesHelper;
import com.ahmadshubita.weatherapp.di.qualifier.ApplicationContext;
import com.ahmadshubita.weatherapp.ui.base.BaseInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by AhmadShubita on 12/2/19.
 **/

public class MainInteractor extends BaseInteractor implements MainMvpInteractor{

    private Context mContext;

    @Inject
    public MainInteractor(@ApplicationContext Context context, PreferencesHelper preferencesHelper, APIInterface apiInterface) {
        super(preferencesHelper,apiInterface);
        mContext = context;
    }





}
