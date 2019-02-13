package com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment;

import com.ahmadshubita.weatherapp.data.network.model.Country;
import com.ahmadshubita.weatherapp.rx.SchedulerProvider;
import com.ahmadshubita.weatherapp.ui.base.BasePresenter;
import com.ahmadshubita.weatherapp.utils.AppConstants;
import com.ahmadshubita.weatherapp.utils.NetworkUtils;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by AhmadShubita on 12/2/19.
 */

public class CountryListPresenter<V extends CountryListMvpView, I extends CountryListMvpInteractor> extends BasePresenter<V, I> implements CountryListMvpPresenter<V, I> {

    private static final String TAG = "CountryListPresenter";

    @Inject
    public CountryListPresenter(I mvpInteractor,
                                SchedulerProvider schedulerProvider,
                                CompositeDisposable compositeDisposable) {
        super(mvpInteractor, schedulerProvider, compositeDisposable);
    }


    @Override
    public void fetchCountries() {
        getMvpView().showLoading();
        if (NetworkUtils.isNetworkConnected(AppConstants.userContext)) {
            getCompositeDisposable().add(getInteractor().fetchCountries()
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<List<Country>>() {
                        @Override
                        public void accept(List<Country> countryList) throws Exception {
                            getMvpView().hideLoading();

                            getMvpView().updateCountryList(countryList);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            getMvpView().hideLoading();

                        }
                    }));
        }else{
            getMvpView().hideLoading();
            getMvpView().showMessage("No internet Connection");
        }
    }
}
