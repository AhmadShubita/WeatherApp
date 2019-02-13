package com.ahmadshubita.weatherapp.ui.mainactivity;

import android.os.Bundle;

import com.ahmadshubita.weatherapp.R;
import com.ahmadshubita.weatherapp.di.component.ActivityComponent;
import com.ahmadshubita.weatherapp.ui.base.BaseActivity;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrylistfragment.CountryListFragment;
import com.ahmadshubita.weatherapp.utils.ActivityUtils;
import com.ahmadshubita.weatherapp.utils.AppConstants;
import com.ahmadshubita.weatherapp.utils.AppLogger;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView, MainMvpInteractor> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppLogger.d(getString(R.string.fragmentCreated));
        AppConstants.userContext = getApplicationContext();
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this));
            mPresenter.onAttach(this);
        }
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), new CountryListFragment(), R.id.mainContainer, "CountryListFragment");

    }

    @Override
    protected void setUp() {

    }

    @Override
    public void openCountryFragment() {

    }
}
