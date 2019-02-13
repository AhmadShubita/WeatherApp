package com.ahmadshubita.weatherapp.di.scops;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by AhmadShubita on 12/2/19.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerApplication {
}

