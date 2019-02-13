package com.ahmadshubita.weatherapp.di.module;

import android.app.Application;
import android.content.Context;


import com.ahmadshubita.weatherapp.data.prefs.AppPreferencesHelper;
import com.ahmadshubita.weatherapp.data.prefs.PreferencesHelper;
import com.ahmadshubita.weatherapp.di.qualifier.ApplicationContext;
import com.ahmadshubita.weatherapp.di.qualifier.PreferenceInfo;
import com.ahmadshubita.weatherapp.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AhmadShubita on 12/2/19.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }


    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }




}
