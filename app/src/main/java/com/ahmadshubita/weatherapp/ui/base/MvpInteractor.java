
package com.ahmadshubita.weatherapp.ui.base;


import com.ahmadshubita.weatherapp.data.network.APIInterface;
import com.ahmadshubita.weatherapp.data.prefs.PreferencesHelper;

/**
 * Created by AhmadShubita on 12/2/19.
 */

public interface MvpInteractor {

    APIInterface getApiInterface();

    PreferencesHelper getPreferencesHelper();

}
