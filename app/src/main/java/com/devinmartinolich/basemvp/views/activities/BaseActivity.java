package com.devinmartinolich.basemvp.views.activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.devinmartinolich.basemvp.BaseMVPApplication;
import com.devinmartinolich.basemvp.R;
import com.devinmartinolich.basemvp.framework.utils.AESHelper;
import com.devinmartinolich.basemvp.framework.utils.AppLog;
import com.devinmartinolich.basemvp.framework.utils.network.NetworkRetryCallback;
import com.devinmartinolich.basemvp.mvp.views.MvpView;
import com.devinmartinolich.basemvp.mvp.interfaces.DialogListener;

/**
 * Name : BaseActivity
 * Created by devin on 1/24/18.
 * Modified by
 * Purpose : This class is extended by all activities to achieve common features of
 * all the activity methods.
 */

public class BaseActivity extends AppCompatActivity implements MvpView
{
    private static final String TAG = BaseActivity.class.getName();
    private Dialog progressDialog = null;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        AppLog.d(TAG, getClass().getSimpleName() + ": onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
    }

    public BaseMVPApplication getAppInstance(){
        return BaseMVPApplication.getAppInstance();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        AppLog.d(TAG, getClass().getSimpleName() + ": onPostCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
    }

    @Override
    protected void onPostResume()
    {
        super.onPostResume();
        AppLog.d(TAG, getClass().getSimpleName() + ": onPostResume() called");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        AppLog.d(TAG, getClass().getSimpleName() + ": onDestroy() called");
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState)
    {
        super.onPostCreate(savedInstanceState, persistentState);
        AppLog.d(TAG, getClass().getSimpleName() + ": onPostCreate() called with: savedInstanceState = [" + savedInstanceState + "], persistentState = [" + persistentState + "]");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        AppLog.d(TAG, getClass().getSimpleName() + ": onRestart() called");
    }

    @Override
    public void onTrimMemory(int level)
    {
        super.onTrimMemory(level);
        AppLog.d(TAG, getClass().getSimpleName() + ": onTrimMemory() called with: level = [" + level + "]");
    }

    @Override
    public void onAttachFragment(Fragment fragment)
    {
        super.onAttachFragment(fragment);
        AppLog.d(TAG, getClass().getSimpleName() + ": onAttachFragment() called with: fragment = [" + fragment + "]");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        AppLog.d(TAG, getClass().getSimpleName() + ": onBackPressed() called");
    }

    @Override
    public void onLowMemory()
    {
        super.onLowMemory();
        AppLog.d(TAG, getClass().getSimpleName() + ": onLowMemory() called");
    }

    @Override
    public void onPause()
    {
        AppLog.d(TAG, getClass().getSimpleName() + ": onPause() called unRegisterBus()");
        super.onPause();
    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        AppLog.d(TAG, getClass().getSimpleName() + ": onNewIntent() called with: intent = [" + intent + "]");

    }

    @Override
    public void onResume()
    {
        super.onResume();
        AppLog.d(TAG, getClass().getSimpleName() + ": onResume() called registerBus()");
    }

    @Override
    protected void onResumeFragments()
    {
        super.onResumeFragments();
        AppLog.d(TAG, getClass().getSimpleName() + ": onResumeFragments() called");
    }

    @Override
    public void onAttachFragment(androidx.fragment.app.Fragment fragment)
    {
        super.onAttachFragment(fragment);
        AppLog.d(TAG, getClass().getSimpleName() + ": onAttachFragment() called with: fragment = [" + fragment + "]");
    }

    /**
     * Name : hideSoftKeyboard
     * Created by devin on 1/1/2018
     * Modified by devin on 1/1/2018
     * Purpose : To hide soft keyboard
     */
    public void hideSoftKeyboard()
    {
        View view = this.getCurrentFocus();
        if (view != null)
        {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * Name : showSoftKeyboard
     * Created by devin on 1/1/2018
     * Modified by devin on 1/1/2018
     * Purpose : To show soft keyboard
     */
    public void showSoftKeyboard()
    {
        View view = this.getCurrentFocus();
        if (view != null)
        {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInputFromInputMethod(view.getWindowToken(), 0);
        }
    }

    /**
     * Name : showDialog
     * Created by devin on 1/4/2018
     * Modified by devin on 1/4/2018
     * Purpose : Display dialog for show error or warning
     * @param mContext
     * @param sMessage
     * @param mDialogListener
     */
    public void showDialog(Context mContext, String sMessage, final DialogListener mDialogListener)
    {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(mContext)
                .setMessage(sMessage)
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton(R.string.lbl_ok, new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        dialog.dismiss();
                        if (mDialogListener != null)
                        {
                            mDialogListener.onDismiss();
                        }
                    }
                });

        AlertDialog errorDialog = mBuilder.create();
        errorDialog.setCancelable(false);
        errorDialog.show();
        errorDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
        doKeepDialog(errorDialog);
    }

    /**
     * Name : doKeepDialog
     * Created by devin on 1/4/2018
     * Modified by devin on 1/4/2018
     * Purpose : Keep dialog display when screen is rotating
     * @param dialog
     */
    private void doKeepDialog(Dialog dialog)
    {
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);
    }

    /**
     * Name : showSnackBarWithOK
     * Created by devin on 1/4/2018
     * Modified by devin on 1/4/2018
     * Purpose : Display snackbar with one action button
     * @param view
     * @param message
     * @param time
     */
    public void showSnackBarWithOK(View view, final String message, final int time)
    {
        final Snackbar snackBar = Snackbar.make(view, message, time);
        snackBar.setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackBar.dismiss();
            }
        });
        snackBar.show();
    }

    /**
     * Name : showSnackBarWithOneActionButton
     * Created by devin on 1/4/2018
     * Modified by devin on 1/4/2018
     * Purpose : Display snackbar with one action button and title
     * @param view
     * @param message
     * @param time
     * @param actionTitle
     * @param actionClickListener
     */
    public void showSnackBarWithOneActionButton(View view, String message, int time, String actionTitle, View.OnClickListener actionClickListener)
    {
        Snackbar snackbar = Snackbar
                .make(view, message, time)
                .setAction(actionTitle, actionClickListener);
        snackbar.show();
    }

    /**
     * Name : showProgressDialog
     * Created by devin on 1/4/2018
     * Modified by devin on 1/4/2018
     * Purpose : To show progress dialog
     * @param context
     */
    public void showProgressDialog(Context context)
    {
        String message = "";
        if (context != null && !((Activity) context).isFinishing())
        {
            if (progressDialog == null || !progressDialog.isShowing())
            {
                progressDialog = new Dialog(context);
                progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                try
                {
                    int dividerId = progressDialog.getContext().getResources().getIdentifier("android:id/titleDivider", null, null);
                    View divider = progressDialog.findViewById(dividerId);
                    if (divider != null)
                        divider.setBackgroundColor(context.getResources().getColor(R.color.transparent));
                }
                catch (Exception e) {e.printStackTrace();}

                try
                {
                    TextView mTitle = (TextView) progressDialog.findViewById(android.R.id.title);
                    if (mTitle != null)
                        mTitle.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);

                    int x = Resources.getSystem().getIdentifier("titleDivider", "id", "android");

                    View titleDivider = progressDialog.findViewById(x);
                    if (titleDivider != null)
                        titleDivider.setBackgroundColor(context.getResources().getColor(R.color.transparent));

                }
                catch (Exception e) {e.printStackTrace();}

                progressDialog.setContentView(R.layout.dialog_custom_progressbar);
                TextView tvMessage = (TextView) progressDialog.findViewById(R.id.txtMessage);

                if (!message.equals(""))
                    tvMessage.setText(message);

                progressDialog.setCancelable(true);

                if (!((Activity) context).isFinishing())
                    progressDialog.show();
            }
        }
        else
            AppLog.e("", context.toString() + " Context Null");
    }

    /**
     * Name : hideProgressDialog
     * Created by devin on 1/4/2018
     * Modified by devin on 1/4/2018
     * Purpose : To hide progress dialog
     */
    public void hideProgressDialog()
    {
        try
        {
            if (progressDialog != null && progressDialog.isShowing())
                progressDialog.dismiss();
        }
        catch (Throwable throwable)
        {
            AppLog.e("", "hideProgressDialog");
        }

        finally
        {
            progressDialog = null;
        }
    }

    /**
     * Name : changeViewVisibility
     * Created by devin on 1/1/2018
     * Modified by devin on 1/3/2018
     * Purpose : To change visibility of multiple views
     * @param visibility
     * @param aViews
     */
    public void changeViewVisibility(int visibility , View... aViews)
    {
        for (View mView : aViews)
        {
            if (mView != null)
                mView.setVisibility(visibility);
        }
    }

    /**
     * Name : getEdittextValue
     * Created by devin on 1/4/2018
     * Modified by devin on 1/4/2018
     * Purpose : To get editText value
     * @param mEditText
     * @return
     */
    public String getEdittextValue(EditText mEditText)
    {
        return mEditText.getText().toString().trim();
    }

    /**
     * Name : validateEditText
     * Created by devin on 1/2/2018
     * Modified by devin on 1/3/2018
     * Purpose : To validate editText value
     * @param mEditText
     * @return
     */
    public boolean validateEditText(EditText mEditText)
    {
        if (mEditText != null && !TextUtils.isEmpty(mEditText.getText().toString()))
            return true;
        else
            return false;
    }

    @Override
    public Context getCurrentContext()
    {
        return null;
    }

    @Override
    public void showLoader(String aMessage)
    {
        showProgressDialog(this);
    }

    @Override
    public void hideLoader()
    {
        hideProgressDialog();
    }

    @Override
    public void noInternetConnection(NetworkRetryCallback mRetryCallback) {}

    public String encryptionAES(String strNormalText)
    {
        AppLog.d(TAG, "encryptionAES() called with: strNormalText = [" + strNormalText + "]");
        String seedValue = "YourSecKey";
        String normalTextEnc = "";

        try
        {
            normalTextEnc = AESHelper.encrypt(seedValue, strNormalText);
        }
        catch (Exception e) {e.printStackTrace();}

        return normalTextEnc;
    }

    public String decryptionAES(String strEncryptedText)
    {
        AppLog.d(TAG, "decryptionAES() called with: strEncryptedText = [" + strEncryptedText + "]");
        String seedValue = "YourSecKey";
        String strDecryptedText = "";

        try
        {
            strDecryptedText = AESHelper.decrypt(seedValue, strEncryptedText);
        }
        catch (Exception e) {e.printStackTrace();}

        return strDecryptedText;
    }
}