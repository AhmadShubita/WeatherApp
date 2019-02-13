package com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment;

import com.ahmadshubita.weatherapp.data.network.model.Country;
import com.ahmadshubita.weatherapp.ui.base.MvpView;

import java.util.List;

/**
 * Created by AhmadShubita on 12/2/19.
 */

public interface CountryListMvpView extends MvpView {

  void updateCountryList(List<Country> countryList);

}
