package com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.weatherfragment;


import com.ahmadshubita.weatherapp.ui.base.MvpPresenter;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpView;

/**
 * Created by AhmadShubita on 12/2/19.
 */

public interface WeatherMvpPresenter<V extends WeatherMvpView,
        I extends WeatherMvpInteractor> extends MvpPresenter<V, I> {


}
