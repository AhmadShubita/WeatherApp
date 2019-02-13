package com.ahmadshubita.weatherapp.ui.mainactivity;

import com.ahmadshubita.weatherapp.data.network.model.Country;
import com.ahmadshubita.weatherapp.rx.SchedulerProvider;
import com.ahmadshubita.weatherapp.ui.base.BasePresenter;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpInteractor;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpPresenter;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListMvpView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by AhmadShubita on 12/2/19.
 */

public class MainPresenter<V extends MainMvpView, I extends MainMvpInteractor> extends BasePresenter<V, I> implements MainMvpPresenter<V, I> {

    private static final String TAG = "MatchDetailPresenter";

    @Inject
    public MainPresenter(I mvpInteractor,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }

    @Override
    public void openFragment() {

    }
}
