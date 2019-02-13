package com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment;


import com.ahmadshubita.weatherapp.ui.base.MvpPresenter;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpView;

/**
 * Created by AhmadShubita on 12/2/19.
 */

public interface CountryDetailsMvpPresenter<V extends CountryDetailsMvpView,
        I extends CountryDetailsMvpInteractor> extends MvpPresenter<V, I> {

    void fetchWeatherData();

}
