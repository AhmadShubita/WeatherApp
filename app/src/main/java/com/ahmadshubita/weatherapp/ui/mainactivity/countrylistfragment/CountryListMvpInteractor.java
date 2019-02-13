
package com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment;


import com.ahmadshubita.weatherapp.data.network.model.Country;
import com.ahmadshubita.weatherapp.ui.base.MvpInteractor;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by AhmadShubita on 12/2/19.
 */

public interface CountryListMvpInteractor extends MvpInteractor {

    Observable<List<Country>> fetchCountries();
}
