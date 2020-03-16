package com.devinmartinolich.basemvp.framework.utils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.devinmartinolich.basemvp.R;

/**
 * Name : NetworkUtils
 * Created by devin on 1/24/18.
 * Modified by
 * Purpose : Contains utility classes related to network connections
 */
public class NetworkUtils
{
    /**
     * Name : NetworkUtils isNetworkAvailable
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : This method is used to check internet connectivity of device.
     * This method returns true if connectivity exist else returns
     * false
     */
    public static boolean isNetworkAvailable(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected())
            return true;

        return false;
    }

    /**
     * Name : NetworkUtils getErrorMessageByHttpCode
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : To get error message based on http response code
     *
     * @param aContext  app context.
     * @param aHttpCode Http code to get relevant error message
     */
    public static String getErrorMessageByHttpCode(Context aContext, int aHttpCode)
    {

        if (aHttpCode == 408)
            return aContext.getString(R.string.error_network_connection_timeout);

        else if (aHttpCode == 401 || aHttpCode == 407)
            return aContext.getString(R.string.error_network_unauthorized);

        else if (aHttpCode == 440)
            return aContext.getString(R.string.error_network_session_expire);

        // client error
        else if (aHttpCode > 200 && aHttpCode < 500)
            return aContext.getString(R.string.error_network_client_error);

        else if (aHttpCode == 504 || aHttpCode == 598 || aHttpCode == 599)
            return aContext.getString(R.string.error_network_server_timeout);

        // server error
        else if (aHttpCode >= 500)
            return aContext.getString(R.string.error_network_server_errors);

        else
            return aContext.getString(R.string.error_network_client_error);
    }

    /**
     * Name : getResponseFromJsonURL
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : Testing API's checking if they are not working and return 403 Forbidden
     *
     * @param url
     * @return string response
     */
//    public String getResponseFromJsonURL(String url)
//    {
//        String jsonResponse = null;
//        if (!TextUtils.isEmpty(url))
//        {
//            try
//            {
//                /************** For getting response from HTTP URL start ***************/
//
//                UserSettingModel mUserSettingModel = null;
//                try
//                {
//                    mUserSettingModel = (UserSettingModel) SharedPrefUtils.getUserSettingsModel(Application.getAppInstance(), Constants.SharedPrefName.USER, Constants.PrefKeys.USER_SETTING_DATA, UserSettingModel.class);
//                }
//                catch (NullPointerException e) {e.printStackTrace();}
//
//                URL object = new URL(url);
//
//                CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
//                HttpURLConnection connection = (HttpURLConnection) object.openConnection();
//                connection.setRequestMethod("GET");
//                connection.setReadTimeout(60 * 1000);
//                connection.setConnectTimeout(60 * 1000);
//                connection.addRequestProperty("Accept", "*/*");
//                connection.setRequestProperty("content-type", "application/json");
//                connection.setRequestProperty("Authorization", "Bearer ".concat(mUserSettingModel.getOauthToken()));
//                int responseCode = connection.getResponseCode();
//
//                if (responseCode == 200)
//                {
//                    // Read response
//                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                    StringBuffer jsonString = new StringBuffer();
//                    String line;
//                    while ((line = br.readLine()) != null)
//                    {
//                        jsonString.append(line);
//                    }
//                    br.close();
//                    connection.disconnect();
//                    AppLog.e("TAG", jsonString.toString());
//                }
//                else if (responseCode == 403)
//                {
//                    BufferedReader br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
//                    StringBuffer jsonString = new StringBuffer();
//                    String line;
//                    while ((line = br.readLine()) != null)
//                    {
//                        jsonString.append(line);
//                    }
//                    br.close();
//                    connection.disconnect();
//                    AppLog.e("TAG", jsonString.toString());
//                }
//            }
//            catch (ProtocolException e) {e.printStackTrace();}
//            catch (MalformedURLException e) {e.printStackTrace();}
//            catch (IOException e) {e.printStackTrace();}
//        }
//        return jsonResponse;
//    }
}
