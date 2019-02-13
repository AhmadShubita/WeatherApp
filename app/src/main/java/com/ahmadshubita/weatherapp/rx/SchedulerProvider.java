package com.ahmadshubita.weatherapp.rx;


import io.reactivex.Scheduler;


/**
 * Created by AhmadShubita on 12/2/19.
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}
