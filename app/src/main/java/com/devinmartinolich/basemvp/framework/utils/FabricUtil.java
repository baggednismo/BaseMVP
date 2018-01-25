package com.devinmartinolich.basemvp.framework.utils;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.ContentViewEvent;
import com.crashlytics.android.answers.LoginEvent;
import com.devinmartinolich.basemvp.BaseMVPApplication;
import com.devinmartinolich.basemvp.framework.utils.AppLog;

public class FabricUtil
{
    private static final String TAG = "FabricUtil";

    /**
     * Name : FabricUtil fabricException
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : To send exception to Fabric, it will display as non fatal exception
     *
     * @param mClass
     * @param mException
     */
    public static void fabricException(Class mClass, Exception mException)
    {
        // TODO: Use the current user's information
        AppLog.d(TAG, "fabricException() called");
        if (BaseMVPApplication.getAppInstance().getCrashlytics() != null)
        {
            Crashlytics.logException(mException);
        }
    }

    /**
     * Name : FabricUtil fabricException
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : To send throwable exception to Fabric
     *
     * @param mClass
     * @param mException Throwable exception
     */
    public static void fabricException(Class mClass, Throwable mException)
    {
        // TODO: Use the current user's information
        AppLog.d(TAG, "fabricException() called");
        if (BaseMVPApplication.getAppInstance().getCrashlytics() != null)
        {
            Crashlytics.logException(mException);
        }
    }

    /**
     * Name : FabricUtil fabricLoginEvent
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : To send custom login event to Fabric.
     *
     * @param aUsername
     */
    public static void fabricLoginEvent(String aUsername)
    {
        AppLog.d(TAG, "fabricLogin() called");
        if (BaseMVPApplication.getAppInstance().getCrashlytics() != null)
        {
            Answers.getInstance().logLogin(new LoginEvent()
                    .putCustomAttribute("Username", aUsername)
            );
        }
    }

    /**
     * Name : FabricUtil fabricContentViewEvent
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : To send content view event to fabric.
     */
    protected static void fabricContentViewEvent()
    {
        if (BaseMVPApplication.getAppInstance().getCrashlytics() != null)
        {
            Answers.getInstance().logContentView(new ContentViewEvent()
                    .putContentName("Answers setup process super easy!")
                    .putContentType("Technical documentation")
                    .putContentId("article-350")
                    .putCustomAttribute("", "")
            );
        }
    }

    /**
     * Name : FabricUtil fabricExceptionWithMessage
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : To send throwable exception to Fabric
     *
     * @param mClass
     * @param mException Throwable exception
     */
    public static void fabricExceptionWithMessage(Class mClass, Throwable mException, String sMsg)
    {
        // TODO: Use the current user's information
        AppLog.d(TAG, "fabricException() called");
        if (BaseMVPApplication.getAppInstance().getCrashlytics() != null)
        {
            Crashlytics.log(sMsg);
            Crashlytics.logException(mException);
        }
    }
}
