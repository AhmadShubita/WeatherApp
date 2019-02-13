package com.ahmadshubita.weatherapp.utils;

import android.content.Context;

/**
 * Created by Ahmad Shubita on 12/2/19.
 **/

public final class AppConstants {
    public static  Context userContext;
    public static final String PREF_NAME = "weather_app_pref";
    public static final  String BASE_URL = "https://restcountries.eu/rest/v1/";
    public static final  String FLAG_URL = "http://www.geognos.com/api/en/countries/flag/";
    public static final  String ENDPOINT_COUNTRY = "all";
    public static final  String ENDPOINT_WEATHER = "http://api.openweathermap.org/data/2.5/forecast?lat=35&lon=139&units=metric&appid=1867722b6af87e1d0388e10c5a94be34";


    private AppConstants() {
        // This utility class is not publicly instantiable
    }

}
