package com.devinmartinolich.basemvp.mvp.presenters;

/**
 * Name : MvpPresenter
 * Created by devin on 1/24/18.
 * Modified by
 * Purpose : This interface is used to register EventBus for Activity, Fragment or any UI view
 */
public interface MvpPresenter
{
    /**
     * Name : MvpPresenter registerBus
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : To register Eventbus to trigger callback method once any task is completed.
     * Eventbus should be register in onResume() or onStart() of activity based on the need.
     * In a fragment it should be registered in onCreateView() or onAttach().
     */
    void registerBus();

    /**
     * Name : MvpPresenter unRegisterBus
     * Created by devin on 1/24/18.
     * Modified by
     *
     * Eventbus should be unregistered in Activity's lifecycle method based on when it is registered:
     * 1) onPause() if it is registered in onResume().
     * 2) onStop() if it is registered in onStart() .
     *
     * Fragment's lifecycle method based on when it is registered:
     * 1) onDestroyView() if it is registered in onCreateView().
     * 2) onDetach() if it is registered in onAttach() .
     */
    void unRegisterBus();

    /**
     * Name : MvpPresenter clearReferences
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : To clear reference to avoid memory leaks
     */
    void clearReferences();
}