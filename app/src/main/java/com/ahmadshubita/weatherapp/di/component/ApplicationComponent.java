package com.ahmadshubita.weatherapp.di.component;

import android.app.Application;
import android.content.Context;

import com.ahmadshubita.weatherapp.MvpApp;
import com.ahmadshubita.weatherapp.data.network.APIInterface;
import com.ahmadshubita.weatherapp.data.prefs.PreferencesHelper;
import com.ahmadshubita.weatherapp.di.module.ApplicationModule;
import com.ahmadshubita.weatherapp.di.module.RetrofitModule;
import com.ahmadshubita.weatherapp.di.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by AhmadShubita on 12/2/19.
 */

@Singleton
@Component(modules ={ ApplicationModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    void inject(MvpApp app);

    @ApplicationContext
    Context context();

    Application application();

    APIInterface getApiInterface();

    PreferencesHelper preferencesHelper();



}