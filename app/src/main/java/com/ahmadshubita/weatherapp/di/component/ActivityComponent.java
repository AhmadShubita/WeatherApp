package com.ahmadshubita.weatherapp.di.component;

import com.ahmadshubita.weatherapp.di.module.ActivityModule;
import com.ahmadshubita.weatherapp.di.scops.PerActivity;
import com.ahmadshubita.weatherapp.ui.mainactivity.MainActivity;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.CountryDetailsFragment;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.weatherfragment.WeatherFragment;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListFragment;

import dagger.Component;

/**
 * Created by AhmadShubita on 12/2/19.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(CountryListFragment countryListFragment);

    void inject(CountryDetailsFragment countryDetailsFragment);

    void inject(WeatherFragment weatherFragment);


}
