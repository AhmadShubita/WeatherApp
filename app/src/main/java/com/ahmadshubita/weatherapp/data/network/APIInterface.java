package com.ahmadshubita.weatherapp.data.network;


import com.ahmadshubita.weatherapp.data.network.model.Country;
import com.ahmadshubita.weatherapp.data.network.model.Weather;
import com.ahmadshubita.weatherapp.data.network.model.WeatherResponse;
import com.ahmadshubita.weatherapp.utils.AppConstants;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIInterface {

    @GET(AppConstants.ENDPOINT_COUNTRY)
    Observable<List<Country>> getCountries();

    @GET(AppConstants.ENDPOINT_WEATHER)
    Observable<WeatherResponse> getWeatherData();



}
