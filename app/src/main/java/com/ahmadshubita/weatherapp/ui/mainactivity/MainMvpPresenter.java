package com.ahmadshubita.weatherapp.ui.mainactivity;


import com.ahmadshubita.weatherapp.ui.base.MvpPresenter;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpView;

/**
 * Created by AhmadShubita on 12/2/19.
 */

public interface MainMvpPresenter<V extends MainMvpView,
        I extends MainMvpInteractor> extends MvpPresenter<V, I> {

    void openFragment();
}
