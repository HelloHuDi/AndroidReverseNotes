package com.tencent.p659pb.common.p660b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p1102c.C46729d;

/* renamed from: com.tencent.pb.common.b.h */
public final class C44441h {
    public static boolean Amm = true;
    private static long Amn = -1;
    public static C30914a Amo = C30914a.NOT_CONNECTED;
    private static C30914a Amp = C30914a.NOT_CONNECTED;

    /* renamed from: com.tencent.pb.common.b.h$a */
    public enum C30914a {
        NOT_CONNECTED,
        CONNECTED,
        CONNECTING
    }

    private static NetworkInfo dPy() {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) C46729d.sZj.getSystemService("connectivity");
        } catch (Exception e) {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            C44443c.m80392w("getSystemService(Context.CONNECTIVITY_SERVICE) null", new Object[0]);
            return null;
        }
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th) {
            C44443c.m80392w("getActiveNetworkInfo exception:", th);
            activeNetworkInfo = null;
        }
        return activeNetworkInfo;
    }

    public static boolean isNetworkConnected() {
        try {
            NetworkInfo dPy = C44441h.dPy();
            if (dPy == null) {
                return false;
            }
            return dPy.isConnected();
        } catch (Exception e) {
            return true;
        }
    }
}
