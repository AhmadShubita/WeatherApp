package com.ahmadshubita.weatherapp.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.ahmadshubita.weatherapp.di.qualifier.ApplicationContext;
import com.ahmadshubita.weatherapp.di.qualifier.PreferenceInfo;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by AhmadShubita on 12/2/19.
 */

@Singleton
public class AppPreferencesHelper implements PreferencesHelper {



    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);

    }

}
