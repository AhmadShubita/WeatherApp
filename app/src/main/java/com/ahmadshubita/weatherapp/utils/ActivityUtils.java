package com.ahmadshubita.weatherapp.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by AhmadShubita on 12/2/19.
 */

public class ActivityUtils extends AppCompatActivity {

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void addFragmentToActivity (FragmentManager fragmentManager,
                                              Fragment fragment,
                                              int frameId,
                                              String tag) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment, tag);
        transaction.commitAllowingStateLoss();;
    }


    public static void addFragmentToActivityWithAnim (FragmentManager fragmentManager,
                                                      Fragment fragment,
                                                      int frameId,
                                                      int enter,
                                                      int leave,
                                                      String tag) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(leave,enter).replace(frameId, fragment, tag);
        transaction.commit();
    }
    public static void addFragmentToActivityAndBackSackWithAnim (FragmentManager fragmentManager,
                                                                 Fragment fragment,
                                                                 int frameId,
                                                                 int enter,
                                                                 int leave,
                                                                 String tag) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(leave,enter).add(frameId, fragment, tag).addToBackStack(null);
        transaction.commit();
    }

    public static void addFragmentToActivityAndBackSack (FragmentManager fragmentManager,
                                                         Fragment fragment,
                                                         int frameId,
                                                         String tag) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment, tag).addToBackStack(null);
        transaction.commit();
    }


    public static void popFragment(FragmentManager fragmentManager) {
        fragmentManager.popBackStack();
    }
}
