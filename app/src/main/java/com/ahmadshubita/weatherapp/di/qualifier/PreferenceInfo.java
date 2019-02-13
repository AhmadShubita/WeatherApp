package com.ahmadshubita.weatherapp.di.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by AhmadShubita on 2/09/19.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface PreferenceInfo {

}
