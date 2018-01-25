package com.devinmartinolich.basemvp.framework.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Environment;
import android.view.Window;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.Hashtable;

import com.devinmartinolich.basemvp.R;
import com.devinmartinolich.basemvp.framework.utils.network.NetworkRetryCallback;

/**
 * Name : CommonUtils
 * Created by devin on 1/24/18.
 * Modified by
 * Purpose : Contains common Utils
 */

public class CommonUtils
{
    private static final Hashtable<String, Typeface> cache = new Hashtable<>();

    public static void showToast(Context context, String aMessage)
    {
        Toast.makeText(context, aMessage, Toast.LENGTH_SHORT).show();
    }

    /**
     * Name : CommonUtils setErrorDialog
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose :  alert dialog with message. and title as a app name.
     *
     * @param context : Context object.
     * @param message : message of dialog box.
     * @param title   : title of dialog box.
     */
    public static AlertDialog.Builder setErrorDialog(Context context, String title, String message)
    {
        if (title == null)
            title = context.getString(R.string.app_name);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        return alertDialogBuilder;
    }

    /**
     * Name : CommonUtils setMessageDialog
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose :  alert dialog with message. and title as a app name.
     */
    public static void setMessageDialog(Context context, String title, String Message)
    {
        if (title == null)
            title = context.getString(R.string.app_name);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
    }


    /**
     * Name : CommonUtils showNetworkDialog
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose :  This method will be executed when we don't have internet and if we don't have
     * internet then we can retry from this dialog.
     *
     * @param aContext
     * @param aNetworkRetryCallback
     */
    public static void showNetworkDialog(Context aContext, final NetworkRetryCallback aNetworkRetryCallback)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(aContext);
        alertDialogBuilder.setTitle(aContext.getString(R.string.app_name));
        alertDialogBuilder.setMessage(aContext.getString(R.string.error_network_no_internet));
        alertDialogBuilder.create().show();
    }


    /**
     * Name : CommonUtils showProgressDialog
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose :
     *
     * @param mContext
     * @param message
     * @return
     */
    public static Dialog showProgressDialog(Context mContext, String... message)
    {
        Dialog progressDialog = new Dialog(mContext, android.R.style.Theme_Holo_Dialog_NoActionBar);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        return progressDialog;
    }

    /**
     * Name : CommonUtils hideProgressDialog
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose :
     *
     * @param mDialog
     */
    public static void hideProgressDialog(Dialog mDialog)
    {
        if (mDialog != null && mDialog.isShowing())
        {
            mDialog.dismiss();
            mDialog = null;
        }
    }

    /**
     * Name : CommonUtils getTypeFace
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : This method is used to return typeface.
     *
     * @param c         Context
     * @param assetPath it is an absolute path of an asset font.
     */
    public static Typeface getTypeFace(Context c, String assetPath)
    {
        synchronized (cache)
        {
            assetPath = "fonts/" + assetPath;
            if (!cache.containsKey(assetPath))
            {
                try
                {
                    Typeface t = Typeface.createFromAsset(c.getAssets(),
                            assetPath);
                    cache.put(assetPath, t);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    return null;
                }
            }
            return cache.get(assetPath);
        }
    }

    /**
     * Name : CommonUtils exportDatabase
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose :  This method is used to export the internal database of the application to SDCARD.
     *
     * @param aContext     : context object
     * @param databaseName : name of database which we want to export.
     */
    public static void exportDatabse(Context aContext, String databaseName)
    {
        try
        {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite())
            {
                String currentDBPath = "//data//" + aContext.getPackageName() + "//databases//" + databaseName + "";
                String backupDBPath = databaseName;
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists())
                {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }
            }
        }
        catch (Exception e) {e.printStackTrace();}
    }
}
