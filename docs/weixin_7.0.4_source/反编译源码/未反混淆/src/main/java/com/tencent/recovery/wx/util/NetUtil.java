package com.tencent.recovery.wx.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.internal.FacebookRequestErrorClassification;

public class NetUtil {
    public static String iF(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return "NOT_NETWORK";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "NOT_NETWORK";
        }
        if (!activeNetworkInfo.isConnected()) {
            return "NOT_NETWORK";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getSubtype() >= 13) {
            return "4G";
        }
        if (activeNetworkInfo.getSubtype() < 5 || activeNetworkInfo.getSubtype() >= 13) {
            return FacebookRequestErrorClassification.KEY_OTHER;
        }
        return "3G";
    }

    public static boolean isConnected(Context context) {
        return !iF(context).equals("NOT_NETWORK");
    }
}
