package com.tinkerboots.sdk.p1355b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tinkerboots.sdk.b.a */
public final class C24572a {
    private static ConnectivityManager AUg = null;

    public static boolean isConnected(Context context) {
        boolean z = false;
        AppMethodBeat.m2504i(65552);
        if (AUg == null) {
            AUg = (ConnectivityManager) context.getSystemService("connectivity");
        }
        if (AUg == null) {
            AppMethodBeat.m2505o(65552);
        } else {
            boolean z2;
            NetworkInfo activeNetworkInfo = AUg.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                try {
                    if (activeNetworkInfo.isConnected()) {
                        z2 = true;
                        z = z2;
                        AppMethodBeat.m2505o(65552);
                    }
                } catch (Exception e) {
                }
            }
            z2 = false;
            z = z2;
            AppMethodBeat.m2505o(65552);
        }
        return z;
    }

    public static boolean isWifi(Context context) {
        AppMethodBeat.m2504i(65553);
        if (AUg == null) {
            AUg = (ConnectivityManager) context.getSystemService("connectivity");
        }
        if (AUg == null) {
            AppMethodBeat.m2505o(65553);
            return false;
        }
        NetworkInfo activeNetworkInfo = AUg.getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            AppMethodBeat.m2505o(65553);
            return false;
        }
        AppMethodBeat.m2505o(65553);
        return true;
    }
}
