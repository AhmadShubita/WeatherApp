package com.ahmadshubita.weatherapp;

import android.app.Application;
import com.ahmadshubita.weatherapp.di.component.ApplicationComponent;
import com.ahmadshubita.weatherapp.di.component.DaggerApplicationComponent;
import com.ahmadshubita.weatherapp.di.module.ApplicationModule;


/**
 * Created by AhmadShubita on 12/2/19.
 */

public class MvpApp extends Application {


    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);


    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }


}
