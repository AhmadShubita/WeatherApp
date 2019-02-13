package com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment;


import com.ahmadshubita.weatherapp.data.network.model.Country;
import com.ahmadshubita.weatherapp.data.network.model.WeatherResponse;
import com.ahmadshubita.weatherapp.ui.base.MvpInteractor;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by AhmadShubita on 12/2/19.
 */

public interface CountryDetailsMvpInteractor extends MvpInteractor {

    Observable<WeatherResponse> fetchWeatherData();

}
