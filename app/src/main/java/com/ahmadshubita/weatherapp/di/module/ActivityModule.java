package com.ahmadshubita.weatherapp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.ahmadshubita.weatherapp.data.network.model.Country;
import com.ahmadshubita.weatherapp.data.network.model.Weather;
import com.ahmadshubita.weatherapp.di.qualifier.ActivityContext;
import com.ahmadshubita.weatherapp.di.scops.PerActivity;
import com.ahmadshubita.weatherapp.rx.AppSchedulerProvider;
import com.ahmadshubita.weatherapp.rx.SchedulerProvider;
import com.ahmadshubita.weatherapp.ui.mainactivity.MainInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.MainMvpInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.MainMvpPresenter;
import com.ahmadshubita.weatherapp.ui.mainactivity.MainMvpView;
import com.ahmadshubita.weatherapp.ui.mainactivity.MainPresenter;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.CountryDetailsInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.CountryDetailsMvpInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.CountryDetailsMvpPresenter;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.CountryDetailsMvpView;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.CountryDetailsPresenter;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.weatherfragment.WeatherInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.weatherfragment.WeatherMvpInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.weatherfragment.WeatherMvpPresenter;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.weatherfragment.WeatherMvpView;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.weatherfragment.WeatherPresenter;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryAdapter;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpPresenter;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpView;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListPresenter;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by AhmadShubita on 12/2/19.
 */


@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context prvoideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDiaposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    @PerActivity
    CountryListMvpPresenter<CountryListMvpView,
            CountryListMvpInteractor> provideCountryListPresenter(CountryListPresenter<CountryListMvpView, CountryListMvpInteractor> presenter) {
        return presenter;
    }


    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView, MainMvpInteractor> provideMainPresenter(
            MainPresenter<MainMvpView, MainMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    CountryDetailsMvpPresenter<CountryDetailsMvpView, CountryDetailsMvpInteractor> provideCountryDetailsPresenter(
            CountryDetailsPresenter<CountryDetailsMvpView, CountryDetailsMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    WeatherMvpPresenter<WeatherMvpView, WeatherMvpInteractor> provideWeatherPresenter(
            WeatherPresenter<WeatherMvpView, WeatherMvpInteractor> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    WeatherMvpInteractor provideWeatherMvpInteractor(WeatherInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    CountryDetailsMvpInteractor provideCountryDetailsMvpInteractor(CountryDetailsInteractor interactor) {
        return interactor;
    }

    @Provides
    @PerActivity
    MainMvpInteractor provideMainMvpInteractor(MainInteractor interactor) {
        return interactor;
    }


    @Provides
    @PerActivity
    CountryListMvpInteractor provideCountryListMvpInteractor(CountryListInteractor interactor) {
        return interactor;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }


//    @Provides
//    CountryAdapter provideCountryAdapter() {
//        return new CountryAdapter(new ArrayList<Country>());
//    }




}
