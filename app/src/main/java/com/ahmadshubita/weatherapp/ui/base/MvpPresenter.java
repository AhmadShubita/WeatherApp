

package com.ahmadshubita.weatherapp.ui.base;

/**
 * Created by AhmadShubita on 12/2/19.
 */


/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */

public interface MvpPresenter<V extends MvpView, I extends MvpInteractor> {

    void onAttach(V mvpView);

    void onDetach();

    V getMvpView();

    I getInteractor();

    boolean isViewAttached();

    void checkViewAttached() throws BasePresenter.MvpViewNotAttachedException;


}
