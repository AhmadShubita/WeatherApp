package com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment;

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

public class CountryDetailsPresenter<V extends CountryDetailsMvpView, I extends CountryDetailsMvpInteractor> extends BasePresenter<V, I> implements CountryDetailsMvpPresenter<V, I> {

    private static final String TAG = "CountryDetailsPresenter";

    @Inject
    public CountryDetailsPresenter(I mvpInteractor,
                                   SchedulerProvider schedulerProvider,
                                   CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }


    @Override
    public void fetchWeatherData() {
        if (NetworkUtils.isNetworkConnected(AppConstants.userContext)) {
            getCompositeDisposable().add(getInteractor().fetchWeatherData()
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<WeatherResponse>() {
                        @Override
                        public void accept(WeatherResponse weatherResponse) throws Exception {
                            getMvpView().updateWeather(weatherResponse);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {

                        }
                    }));
        }else{
            getMvpView().showMessage("No internet Connection");
        }
    }
}
