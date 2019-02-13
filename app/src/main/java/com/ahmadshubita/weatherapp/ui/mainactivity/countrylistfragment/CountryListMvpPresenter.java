package com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment;


import com.ahmadshubita.weatherapp.ui.base.MvpPresenter;

/**
 * Created by AhmadShubita on 12/2/19.
 */

public interface CountryListMvpPresenter<V extends CountryListMvpView,
        I extends CountryListMvpInteractor> extends MvpPresenter<V, I> {

    void fetchCountries();

}
