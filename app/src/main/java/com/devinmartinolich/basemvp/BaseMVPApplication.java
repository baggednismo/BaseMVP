package com.devinmartinolich.basemvp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.crashlytics.android.Crashlytics;
import com.devinmartinolich.basemvp.framework.utils.AppLog;
import com.squareup.leakcanary.LeakCanary;

import org.greenrobot.eventbus.EventBus;

/**
 * Name : BaseMVPApplication
 * Created by devin on 1/24/18.
 * Modified by
 * Purpose : Application class to initialize application level library and store application level information.
 */
public class BaseMVPApplication extends AppCompatActivity
{
    private static final String TAG = "BaseMVPApplication";
    private static BaseMVPApplication mAppInstance;
    private Crashlytics crashlytics;
    private EventBus mEventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        AppLog.d(TAG, "onCreate() called");
        mAppInstance = this;

        if (LeakCanary.isInAnalyzerProcess(this))
        {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }

        if (!BuildConfig.DEBUG)
        {
//            mRefWatcher = LeakCanary.install(this);
//            Fabric.with(this, crashlytics = new Crashlytics());
        }

        setContentView(R.layout.activity_main);
    }

    /**
     * Name : BaseMVPApplication getAppInstance
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : To get app instance for presenter.
     *
     * @return : app instance
     */
    public static BaseMVPApplication getAppInstance()
    {
        return mAppInstance;
    }

    /**
     * Name : BaseMVPApplication getCrashlytics
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : To get crashlytics instance for presenter.
     *
     * @return : crashlytics instance
     */
    public Crashlytics getCrashlytics()
    {
        return crashlytics;
    }

    /**
     * Name : BaseMVPApplication getEventBus
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : To get eventbus instance for presenter.
     *
     * @return : {@link EventBus} object
     */
    public EventBus getEventBus()
    {
        if (mEventBus == null)
            mEventBus = EventBus.getDefault();

        return mEventBus;
    }
}
