package com.androidapp.bitoasis.bitoasis.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Ahmad  awad on 07/11/2018.
 */
public class NetworkUtils {

    private static NetworkUtils networkUtils;

    public static NetworkUtils getInstance() {
        if (networkUtils == null) {
            networkUtils = new NetworkUtils();
        }

        return networkUtils;
    }


    public static boolean isInternetConnected(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            return connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED;
        } else {
            return false;
        }
    }
}
