package com.tencent.smtt.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Apn {
    public static final int APN_2G = 1;
    public static final int APN_3G = 2;
    public static final int APN_4G = 4;
    public static final int APN_UNKNOWN = 0;
    public static final int APN_WIFI = 3;

    public static String getApnInfo(Context context) {
        String extraInfo;
        AppMethodBeat.m2504i(65169);
        String str = "unknown";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                switch (activeNetworkInfo.getType()) {
                    case 0:
                        extraInfo = activeNetworkInfo.getExtraInfo();
                        break;
                    case 1:
                        extraInfo = "wifi";
                        break;
                }
            }
        } catch (Exception e) {
        }
        extraInfo = str;
        AppMethodBeat.m2505o(65169);
        return extraInfo;
    }

    public static int getApnType(Context context) {
        int i;
        AppMethodBeat.m2504i(65170);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
            switch (activeNetworkInfo.getType()) {
                case 0:
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            i = 1;
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            i = 2;
                            break;
                        case 13:
                            i = 4;
                            break;
                        default:
                            i = 0;
                            break;
                    }
                case 1:
                    i = 3;
                    break;
                default:
                    i = 0;
                    break;
            }
        }
        i = 0;
        AppMethodBeat.m2505o(65170);
        return i;
    }

    public static String getWifiSSID(Context context) {
        AppMethodBeat.m2504i(65172);
        String bssid;
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            bssid = connectionInfo != null ? connectionInfo.getBSSID() : null;
            AppMethodBeat.m2505o(65172);
            return bssid;
        } catch (Throwable th) {
            bssid = "";
            AppMethodBeat.m2505o(65172);
            return bssid;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        AppMethodBeat.m2504i(65171);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.m2505o(65171);
            return false;
        } else if (activeNetworkInfo.isConnected() || activeNetworkInfo.isAvailable()) {
            AppMethodBeat.m2505o(65171);
            return true;
        } else {
            AppMethodBeat.m2505o(65171);
            return false;
        }
    }
}
