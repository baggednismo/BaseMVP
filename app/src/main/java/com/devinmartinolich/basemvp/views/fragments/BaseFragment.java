package com.devinmartinolich.basemvp.views.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.devinmartinolich.basemvp.BaseMVPApplication;
import com.devinmartinolich.basemvp.R;
import com.devinmartinolich.basemvp.framework.utils.CommonUtils;
import com.devinmartinolich.basemvp.mvp.presenters.BasePresenter;
import com.devinmartinolich.basemvp.mvp.views.MvpView;
import com.devinmartinolich.basemvp.views.activities.BaseActivity;
import com.devinmartinolich.basemvp.mvp.interfaces.DialogListener;
import com.devinmartinolich.basemvp.framework.utils.AppLog;
import com.devinmartinolich.basemvp.framework.utils.network.NetworkRetryCallback;

/**
 * Name : BaseFragment
 * <br> Created by devin on 9/14/17.
 * <br> Modified by
 * <br> Purpose :
 */
public class BaseFragment extends Fragment implements MvpView
{
    protected View mView;
    String TAG = "BaseFragment";
    private BasePresenter mBasePresenter;

    /**
     * Name : BaseFragment setPresenter
     * Created by 1549 on 12/6/2017
     * Modified by
     * Purpose : This method is used to assign the presenter to the base view.
     *
     * @param aBasePresenter : Object of {@link BasePresenter}
     */
    protected void setPresenter(BasePresenter aBasePresenter)
    {
        mBasePresenter = aBasePresenter;
    }

    /**
     * Name : BaseFragment getCurrentContext
     *<br> Created by 1549 on 12/6/2017
     *<br> Modified by 1549 on 12/6/2017
     *<br> Purpose :  : This method is used to get current context of the application.
     *
     * @return : {@link Context} of current fragment/activity.
     */
    @Override
    public Context getCurrentContext()
    {
        return getActivity();
    }

    public void showDialog(Context mContext, String sMessage, final DialogListener mDialogListener) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(mContext)
                .setMessage(sMessage)
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton(R.string.lbl_ok, new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        dialog.dismiss();
                        if (mDialogListener != null)
                            mDialogListener.onDismiss();
                    }
                });

        AlertDialog errorDialog = mBuilder.create();
        errorDialog.setCancelable(false);
        errorDialog.show();
        errorDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
        doKeepDialog(errorDialog);
    }

    private void doKeepDialog(Dialog dialog){
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);
    }

    public BaseMVPApplication getAppInstance(){
        return BaseMVPApplication.getAppInstance();
    }

    @Override
    public void showLoader(String aMessage)
    {
        ((BaseActivity)getActivity()).showProgressDialog(getActivity());
    }

    @Override
    public void hideLoader()
    {
        ((BaseActivity)getActivity()).hideProgressDialog();
    }

    @Override
    public void noInternetConnection(NetworkRetryCallback aNetworkRetryCallback)
    {
        CommonUtils.showNetworkDialog(getCurrentContext(), aNetworkRetryCallback);
    }


    @Override
    public void onStart()
    {
        super.onStart();
        AppLog.d(TAG, getClass().getSimpleName() + ": onStart");

        if (mBasePresenter != null)
            mBasePresenter.registerBus();
    }

    @Override
    public void onStop()
    {
        AppLog.d(TAG, getClass().getSimpleName() + ": onStop");

        if (mBasePresenter != null)
            mBasePresenter.unRegisterBus();

        super.onStop();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onDestroyView()
    {
        if (mBasePresenter != null)
            mBasePresenter.clearReferences();

        AppLog.d(TAG, getClass().getSimpleName() + ": onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        AppLog.d(TAG, getClass().getSimpleName() + ": onDestroy");
    }
}