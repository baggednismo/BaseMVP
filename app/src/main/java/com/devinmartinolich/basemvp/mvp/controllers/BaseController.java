package com.devinmartinolich.basemvp.mvp.controllers;

import org.greenrobot.eventbus.EventBus;

import static com.devinmartinolich.basemvp.BaseMVPApplication.getAppInstance;

/**
 * Name : BaseController
 * Created by devin on 1/24/18.
 * Modified by
 * Purpose : This class is extended by all the controllers to achieve common features of
 * all the controller methods.
 */
public abstract class BaseController
{
    public EventBus mEventBus;

    public BaseController()
    {
        mEventBus = getAppInstance().getEventBus();
    }
}
