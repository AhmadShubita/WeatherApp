package com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.weatherfragment;

import com.ahmadshubita.weatherapp.data.network.model.Country;
import com.ahmadshubita.weatherapp.data.network.model.Weather;
import com.ahmadshubita.weatherapp.data.network.model.WeatherResponse;
import com.ahmadshubita.weatherapp.ui.base.MvpView;

import java.util.List;

/**
 * Created by AhmadShubita on 12/2/19.
 */

public interface WeatherMvpView extends MvpView {

  void updateWeather(Weather weather);


}
