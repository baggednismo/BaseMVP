package com.devinmartinolich.basemvp.framework.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;

/**
 * Name : SharedPrefUtils
 * Created by devin on 1/24/18.
 * Modified by
 * Purpose : This class will contains all the methods related to shared preferences.
 */
public class SharedPrefUtils
{
    private static SharedPreferences mSharedPreferences;
    private static String mPrefName;

    public static String getString(Context aContext, String aSharedPrefName, String aKey, String aDefaultValue)
    {
        return getSharedPreferences(aContext, aSharedPrefName).getString(aKey, aDefaultValue);
    }

    public static SharedPreferences getSharedPreferences(Context aContext, String aSharedPrefName)
    {
        if (mSharedPreferences == null || mPrefName != aSharedPrefName)
            mSharedPreferences = aContext.getSharedPreferences(aSharedPrefName, Context.MODE_PRIVATE);

        return mSharedPreferences;
    }

    public static long getLong(Context aContext, String aSharedPrefName, String aKey, long aDefaultValue)
    {
        return getSharedPreferences(aContext, aSharedPrefName).getLong(aKey, aDefaultValue);
    }

    public static boolean getBool(Context aContext, String aSharedPrefName, String aKey, boolean aDefaultValue)
    {
        return getSharedPreferences(aContext, aSharedPrefName).getBoolean(aKey, aDefaultValue);
    }

    public static void setString(Context aContext, String aSharedPrefName, String aKey, String aValue)
    {
        getSharedPreferences(aContext, aSharedPrefName).edit().putString(aKey, aValue).apply();
    }

    public static void setLong(Context aContext, String aSharedPrefName, String aKey, long aValue)
    {
        getSharedPreferences(aContext, aSharedPrefName).edit().putLong(aKey, aValue).apply();
    }

    public static void setBool(Context aContext, String aSharedPrefName, String aKey, boolean aValue)
    {
        getSharedPreferences(aContext, aSharedPrefName).edit().putBoolean(aKey, aValue).apply();
    }


    public static void setInt(Context aContext, String aSharedPrefName, String aKey, int aValue)
    {
        getSharedPreferences(aContext, aSharedPrefName).edit().putInt(aKey, aValue).apply();
    }

    public static int getInt(Context aContext, String aSharedPrefName, String aKey, int aDefaultValue)
    {
        return getSharedPreferences(aContext, aSharedPrefName).getInt(aKey, aDefaultValue);
    }

    public static void setModelObject(Context aContext, String aSharedPrefName, String aKey, Object mObjectValue)
    {

        Editor prefsEditor = getSharedPreferences(aContext, aSharedPrefName).edit();
        Gson gson = new Gson();
        String json = gson.toJson(mObjectValue);
        prefsEditor.putString(aKey, json);
        prefsEditor.apply();
    }


    public static Object getUserSettingsModel(Context aContext, String aSharedPrefName, String aKey, Class modelClass) throws NullPointerException
    {
        Object mModelData;

        Gson gson = new Gson();
        String json = getSharedPreferences(aContext, aSharedPrefName).getString(aKey, "");
        mModelData = gson.fromJson(json, modelClass);

        return mModelData != null ? mModelData : null;
    }
}