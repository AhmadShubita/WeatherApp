package com.ahmadshubita.weatherapp.ui.base;


import com.ahmadshubita.weatherapp.data.network.APIInterface;
import com.ahmadshubita.weatherapp.data.prefs.PreferencesHelper;

import javax.inject.Inject;

/**
 * Created by AhmadShubita on 12/2/19.
 */

public class BaseInteractor implements MvpInteractor {

    private final PreferencesHelper mPreferencesHelper;
    private final APIInterface mApiInterface;

    @Inject
    public BaseInteractor(PreferencesHelper preferencesHelper,
                          APIInterface apiInterface) {
        mPreferencesHelper = preferencesHelper;
        mApiInterface = apiInterface;
    }

    @Override
    public APIInterface getApiInterface() {
        return mApiInterface;
    }

    @Override
    public PreferencesHelper getPreferencesHelper() {
        return mPreferencesHelper;
    }


}
