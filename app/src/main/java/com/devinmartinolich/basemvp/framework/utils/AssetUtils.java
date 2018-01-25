package com.devinmartinolich.basemvp.framework.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Name : AssetsUtils
 * Created by devin on 1/24/18.
 * Modified by
 * Purpose : Classed is used for assess util which will transfter asset value to sd card etc.
 */
public class AssetUtils
{
    /**
     * This method is used to copy the FULL directory and its sub
     * directories/files to another location.
     */
    public static boolean copyDirectoryFromAssetToSDCard(InputStream aInputStream, File afDstFile)
    {
        FileOutputStream fileOutputStream = null;
        try
        {
            fileOutputStream = new FileOutputStream(afDstFile);

            // Copy the bits from instream to outstream
            byte[] buf = new byte[2048];
            int len;
            while ((len = aInputStream.read(buf)) > 0)
            {
                fileOutputStream.write(buf, 0, len);
            }

            // Close the streams
            aInputStream.close();
            fileOutputStream.close();

            return true;
        }
        catch (Exception e) {e.printStackTrace();}

        return false;
    }

    /**
     * This method is used to get the list of files from the asset
     * folder from the given directory. In this method, if directory is
     * null then List will be from Direct to Asset Folder.
     * <p/>
     * Here to get all the Files from the Assset Root Folder pass the
     * second paramter as NULL.
     *
     * @param aContext  {@link Context} of the Activity or class from wherer it is
     *                  called.
     * @param asDirName Name of the current Folder. Pass id NUll of Empty String to
     *                  Get the All the Files of the Asset Root Folder.
     */
    public static String[] getAllFileListFromAsset(Context aContext, String asDirName, AssetManager assetManager)
    {
        /**
         * Here if AssetManager is NULL then simply returns from the method with
         * NULL value.
         */
        if (assetManager == null)
            return null;

        try
        {
            if (asDirName == null || asDirName.trim().length() == 0)
                return assetManager.list("");
            else
                return assetManager.list(asDirName);
        }
        catch (Exception e) {e.printStackTrace();}

        return null;
    }
}
