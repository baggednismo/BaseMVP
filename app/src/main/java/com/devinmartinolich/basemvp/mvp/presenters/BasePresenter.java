package com.devinmartinolich.basemvp.mvp.presenters;

import androidx.annotation.Nullable;

import com.devinmartinolich.basemvp.mvp.controllers.BaseController;
import com.devinmartinolich.basemvp.framework.utils.AppLog;
import com.devinmartinolich.basemvp.mvp.views.BaseView;
import com.devinmartinolich.basemvp.mvp.views.MvpView;

import org.greenrobot.eventbus.EventBus;

/**
 * Name : BasePresenter
 * Created by devin on 1/24/18.
 * Modified by
 * Purpose : This class is extended by all the presenters to achieve common features of
 * all the presenter methods.
 */
public abstract class BasePresenter implements MvpPresenter
{

    private static final String TAG = "BasePresenter";
    private BaseController mBaseController;
    private BaseView mBaseView;
    private MvpView mView;

    /**
     * Name : BasePresenter setController
     * <br> Created by 1549 on 12/6/2017
     * <br> Modified by 1549 on 12/6/2017
     * <br> Purpose :  This method will initialize the controller
     *
     * @param aBaseController : Object of controller.
     */
    protected void setController(BaseController aBaseController)
    {
        mBaseController = aBaseController;
    }

    /**
     * Set view
     *
     * @param aBaseView set current view object
     */
    protected void setView(BaseView aBaseView)
    {
        mBaseView = aBaseView;
    }

    /**
     * Name : BasePresenter registerBus
     * <br> Created by 1549 on 12/6/2017
     * <br> Modified by 1549 on 12/6/2017
     * <br> Purpose :
     * This method will be called by the {@link com.devinmartinolich.basemvp.views.fragments.BaseFragment#onPause()} ()}
     * or by the {@link com.devinmartinolich.basemvp.views.activities.BaseActivity#onPause()}
     */
    @Override
    public void registerBus()
    {
        if (!mBaseController.mEventBus.isRegistered(this))
            mBaseController.mEventBus.register(this);
    }

    /**
     * Name : BasePresenter unRegisterBus
     * <br> Created by 1549 on 12/6/2017
     * <br> Modified by 1549 on 12/6/2017
     * <br> Purpose :
     * This method will be called by the {@link com.devinmartinolich.basemvp.views.fragments.BaseFragment#onStop()}
     * or by the {@link com.devinmartinolich.basemvp.views.activities.BaseActivity#onStop()} method.
     */
    @Override
    public void unRegisterBus()
    {
        if (mBaseController.mEventBus.isRegistered(this))
        {
            mBaseController.mEventBus.unregister(this);
        }
    }

    @Override
    public void clearReferences() {}

    /**
     * Name : BasePresenter setView
     * <br> Created by 1549 on 12/6/2017
     * <br> Modified by 1549 on 12/6/2017
     * <br> Purpose : This method is used to attach the view of activity/fragment to base presenter.
     *
     * @param aMvpView : Object of view
     */
    protected void setView(MvpView aMvpView)
    {
        mView = aMvpView;
    }

    /**
     * Name : BasePresenter removeStickyEvent
     * <br> Created by 1549 on 11/8/2017
     * <br> Modified by 1549 on 11/8/2017
     * <br> Purpose : This method is used to remove any StickEvent which is in queue of eventbus.
     *
     * @param aT  : class of event object
     * @param <T> : object of event which we removed.
     * @return
     */
    @Nullable
    protected <T> T removeStickyEvent(Class<T> aT)
    {

        T aMenuSettingModels = EventBus.getDefault().getStickyEvent(aT);
        GenericClass aClass = new GenericClass(aT);

        // Better check that an event was actually posted before
        if (aMenuSettingModels != null)
        {
            // "Consume" the sticky event
            AppLog.d(TAG, "removeStickyEvent() remove :" + aClass.getMyType().getSimpleName());
            EventBus.getDefault().removeStickyEvent(aMenuSettingModels);
            // Now do something with it
        }
        else
        {
            AppLog.d(TAG, "removeStickyEvent() NOT remove :" + aClass.getMyType().getSimpleName());
            // EventBus.getDefault().removeStickyEvent(aClass.getMyType().getSimpleName());
        }
        return aMenuSettingModels;

    }

    /**
     * Name : BasePresenter
     * <br> Created by 1549 on 12/6/2017
     * <br> Modified by 1549 on 12/6/2017
     * <br> Purpose :  Get class name from Generic class
     *
     * @param <T>
     */
    class GenericClass<T>
    {

        private final Class<T> type;

        public GenericClass(Class<T> type)
        {
            this.type = type;
        }

        public Class<T> getMyType()
        {
            return this.type;
        }

    }

    public boolean isArrayOfType(Object[] array, Class<?> aClass) {
        return array.length > 0 && array.getClass().getComponentType().isAssignableFrom(aClass);
    }
}
