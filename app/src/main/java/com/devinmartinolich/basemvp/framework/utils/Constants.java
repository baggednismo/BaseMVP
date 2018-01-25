package com.devinmartinolich.basemvp.framework.utils;

/**
 * Name : Constants
 * Created by devin on 1/24/18.
 * Modified by
 * Purpose : Contains all constants used in Application.
 */
public class Constants
{
//    public interface API
//    {
//        String BASE = "api/v1/";
//        String LOGIN = BASE + "customer/auth/login";
//        String REGISTER = BASE + "customer/auth/register";
//        String REGISTER_VERIFY_USERNAME = BASE + "customer/auth/verify-username";
//        String CUSTOMER_DETAIL = BASE + "customer/details";
//        String CUSTOMER_ALL_STORE = BASE + "customer/stores";
//        String CUSTOMER_MY_STORE = CUSTOMER_ALL_STORE +"/my-stores";
//        String CUSTOMER_STORE_TEAM = CUSTOMER_ALL_STORE +"/{id}/team";
//        String CUSTOMER_COUPONS = BASE + "customer/coupons";
//        String CUSTOMER_STORE_COUPONS = CUSTOMER_COUPONS + "/{storeId}";
//        String CUSTOMER_CAMPAIGNS = BASE + "customer/campaigns";
//        String CUSTOMER_COMPLETED_CAMPAIGNS = CUSTOMER_CAMPAIGNS + "/completed";
//        String CUSTOMER_RECEIPTS = BASE + "customer/receipts";
//        String CUSTOMER_SINGAL_RECEIPT = CUSTOMER_RECEIPTS + "/{id}";
//        String CUSTOMER_SINGAL_RECEIPT_IMAGE = CUSTOMER_SINGAL_RECEIPT + "/image";
//    }

//    public interface SharedPrefName
//    {
//        String USER = "pref_user";
//    }

//    public interface PrefKeys
//    {
//        String USER_NAME = "key_userName";
//        String USER_SETTING_DATA = "key_settingsData";
//        String USER_FACEBOOK = "key_settingsData";
//    }

//    public static class ApiCodes
//    {
//        public static final int API_LOGIN = 800;
//        public static final int AUTH_USER = 801;
//        public static final int API_CUST_DETAIL = 802;
//        public static final int API_ALL_STORE = 803;
//        public static final int API_MY_STORE = 804;
//        public static final int API_STORE_TEAM = 805;
//        public static final int API_COUPANS = 806;
//        public static final int API_STORE_COUPANS = 807;
//        public static final int API_CAMPAIGNS = 808;
//        public static final int API_COMPLETED_CAMPAIGNS = 809;
//        public static final int API_RECEIPTS = 810;
//        public static final int API_REGISTER = 811;
//        public static final int API_VERIFY_USERNAME = 812;
//    }

    public static class ApiError
    {

        public static final String INVALID_EMAIL = "INVALID_EMAIL";
        public static final String INVALID_PASSWORD = "INVALID_PASSWORD";
        public static final String HTTP_ERRORS = "HTTP_ERROR_CODES";
        public static final String HTTP_AUTH_UNAUTHORIZED = "AUTH_UNAUTHORIZED_REQUEST";

        public static final String HTTP_ERROR_DEVICE_FETCH = "ERROR_DEVICE_FETCH";
        public static final String HTTP_UNKNOWN_HOST = "UNKNOWN_HOST";
        public static final String HTTP_AUTH_FAIL = "HTTP_AUTH_FAIL";
        public static final String HTTP_NO_ERROR = "HTTP_NO_ERROR";
        public static final String HTTP_DISPLAY_AUTH_FAIL = "HTTP_DISPLAY_AUTH_FAIL";
        public static final String HTTP_DISPLAY_AUTH_SUCCESS = "HTTP_DISPLAY_AUTH_SUCCESS";

        public static final String HTTP_NO_APP_UPDATE = "HTTP_NO_APP_UPDATE";
        public static final String HTTP_DOWNLOAD_APK_ERROR = "HTTP_DOWNLOAD_APK_ERROR";
        public static final String HTTP_GET_LATEST_APK_ERROR = "HTTP_NO_APP_UPDATE";

        public static final String AUTH_FAIL_LOGIN = "AUTH_FAIL_LOGIN";
        public static final String AUTH_USER_NOT_FOUND = "AUTH_USER_NOT_FOUND";
        public static final String NO_ITEMS = "NO_ITEMS";

        private String mErrorCode;
        private String mErrorMessage;
        private int mApiCode;

        public ApiError(int aApiCode, String aErrorCode, String aErrorMessage)
        {
            mApiCode = aApiCode;
            mErrorCode = aErrorCode;
            mErrorMessage = aErrorMessage;
        }

        public int getApiCode()
        {
            return mApiCode;
        }

        public String getErrorCode()
        {
            return mErrorCode;
        }

        public void setErrorCode(String aErrorCode)
        {
            mErrorCode = aErrorCode;
        }

        public String getErrorMessage()
        {
            return mErrorMessage;
        }

        public void setErrorMessage(String aErrorMessage)
        {
            mErrorMessage = aErrorMessage;
        }
    }

    public interface DateFormat
    {
        String DATEFORMAT_MM_DD_YYYY_HH_MM_SS = "MM/dd/yyyy HH:mm:ss";
        String DATEFORMAT_MM_DD_YYYY_HH_MM_SS_A = "MM/dd/yyyy hh:mm:ss a";
        String DATEFORMAT_M_D_YYYY_HH_MM_SS_A = "M/d/yyyy hh:mm:ss a";
        String DATEFORMAT_DD_MMM_YYYY = "dd MMM yyyy";
        String DATEFORMAT_DD_MM_YYYY = "dd-MM-yyyy";
        String DATEFORMAT_MM_DD_YYYY = "MM/dd/yyyy";
        String DATEFORMAT_YYYY_MM_DD = "yyyy-MM-dd";
        String DATEFORMAT_DD_MMM_YYYY_HH_MM_SS_A = "dd MMM yyyy hh:mm:ss a";
        String DATEFORMAT_DD_MMM_YYYY_HH_MM_SS = "dd MMM yyyy  HH:mm:ss";
    }

//    public interface ACTIVITY_RESULT_CODE
//    {
//        int RC_SIGN_IN = 9001;
//    }

//    public interface SIGNUP_STEPS
//    {
//        int EMAIL = 1;
//        int PASSWORD = 2;
//        int USER_NAME = 3;
//        int FIRST_NAME = 4;
//        int LAST_NAME = 5;
//        int ADDRESS = 6;
//        int CITY = 7;
//        int STATE = 8;
//        int ZIP = 9;
//        int PHONE = 10;
//        int DOB = 11;
//        int SEX = 12;
//    }

//    public interface FIREBASE_DB_KEY
//    {
//        String KEY_USERDATA = "UserData";
//        String KEY_STORELIST = "StoreList";
//        String KEY_CAMPAIGNLIST = "CampaignList";
//    }

//    public interface FIREBASE_PROVIDERS
//    {
//        String KEY_PROVIDER_TWITTER = "twitter.com";
//        String KEY_PROVIDER_FACEBOOK = "facebook.com";
//        String KEY_PROVIDER_GOOGLE = "google.com";
//    }
}