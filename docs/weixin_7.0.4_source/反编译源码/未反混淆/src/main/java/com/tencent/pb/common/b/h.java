package com.tencent.pb.common.b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;

public final class h {
    public static boolean Amm = true;
    private static long Amn = -1;
    public static a Amo = a.NOT_CONNECTED;
    private static a Amp = a.NOT_CONNECTED;

    public enum a {
        NOT_CONNECTED,
        CONNECTED,
        CONNECTING
    }

    private static NetworkInfo dPy() {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) d.sZj.getSystemService("connectivity");
        } catch (Exception e) {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            c.w("getSystemService(Context.CONNECTIVITY_SERVICE) null", new Object[0]);
            return null;
        }
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th) {
            c.w("getActiveNetworkInfo exception:", th);
            activeNetworkInfo = null;
        }
        return activeNetworkInfo;
    }

    public static boolean isNetworkConnected() {
        try {
            NetworkInfo dPy = dPy();
            if (dPy == null) {
                return false;
            }
            return dPy.isConnected();
        } catch (Exception e) {
            return true;
        }
    }
}
