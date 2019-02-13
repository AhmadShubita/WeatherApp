package com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ahmadshubita.weatherapp.R;
import com.ahmadshubita.weatherapp.data.network.model.Weather;
import com.ahmadshubita.weatherapp.ui.mainactivity.countrydetailsfragment.weatherfragment.WeatherFragment;



/**
 * Created by Ahmad Shubita on 12/2/19.
 */

public class WeatherPagerAdapter extends FragmentPagerAdapter  implements CountryDetailsFragment.TabClicked {

    private Context mContext;

    WeatherFragment todayFragment;
    WeatherFragment tomorrowFragment;

    public WeatherPagerAdapter(Context context , FragmentManager fm) {
        super(fm);
        mContext = context.getApplicationContext();
    }


    @Override
    public Fragment getItem(int position) {

        return getFragment(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: {
                return mContext.getResources().getString(R.string.today);
            }
            case 1: {
                return mContext.getResources().getString(R.string.tomorrow);
            }


        }
        return null;
    }

    // this function to handel selected tabs fragment depending on the position.
    private Fragment getFragment(int position) {

        switch (position) {
            case 0: {
                todayFragment = new WeatherFragment();
                return todayFragment;
            }
            case 1: {
                 tomorrowFragment = new WeatherFragment();
                return tomorrowFragment;
            }
            default: {
                todayFragment = new WeatherFragment();
                return todayFragment;
            }

        }
    }


    @Override
    public void sendObjectWeather(Weather weather, int position) {
        switch (position){
            case 0:{
                todayFragment.updateWeather(weather);
                break;
            }
            case 1:{
                tomorrowFragment.updateWeather(weather);
                break;
            }
        }
    }
}
