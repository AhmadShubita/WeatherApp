package com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.weatherfragment;

import com.ahmadshubita.weatherapp.data.network.model.Country;
import com.ahmadshubita.weatherapp.data.network.model.WeatherResponse;
import com.ahmadshubita.weatherapp.rx.SchedulerProvider;
import com.ahmadshubita.weatherapp.ui.base.BasePresenter;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpPresenter;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpView;
import com.ahmadshubita.weatherapp.utils.AppConstants;
import com.ahmadshubita.weatherapp.utils.NetworkUtils;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by AhmadShubita on 12/2/19.
 */

public class WeatherPresenter<V extends WeatherMvpView, I extends WeatherMvpInteractor> extends BasePresenter<V, I> implements WeatherMvpPresenter<V, I> {

    private static final String TAG = "CountryListPresenter";

    @Inject
    public WeatherPresenter(I mvpInteractor,
                            SchedulerProvider schedulerProvider,
                            CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }


}
