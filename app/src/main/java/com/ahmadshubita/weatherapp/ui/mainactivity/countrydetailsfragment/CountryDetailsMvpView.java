package com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment;

import com.ahmadshubita.weatherapp.data.network.model.Country;
import com.ahmadshubita.weatherapp.data.network.model.WeatherResponse;
import com.ahmadshubita.weatherapp.ui.base.MvpView;

import java.util.List;

/**
 * Created by AhmadShubita on 12/2/19.
 */

public interface CountryDetailsMvpView extends MvpView {

  void setCountryDetails();

  void updateWeather(WeatherResponse weatherResponse);


}
