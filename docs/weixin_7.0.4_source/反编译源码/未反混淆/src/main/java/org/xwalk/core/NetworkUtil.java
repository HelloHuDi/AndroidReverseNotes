package org.xwalk.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NetworkUtil {
    private static final int NON_NETWORK = 0;
    private static final int OTHER = 4;
    private static final int WIFI = 1;
    private static final int _3G = 2;
    private static final int _4G = 3;

    public static int getCurrentNetWorkStatus(Context context) {
        AppMethodBeat.i(4191);
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            AppMethodBeat.o(4191);
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.o(4191);
            return 0;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(4191);
            return 0;
        } else if (!activeNetworkInfo.isConnected()) {
            AppMethodBeat.o(4191);
            return 0;
        } else if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.o(4191);
            return 1;
        } else if (activeNetworkInfo.getSubtype() >= 13) {
            AppMethodBeat.o(4191);
            return 3;
        } else if (activeNetworkInfo.getSubtype() < 5 || activeNetworkInfo.getSubtype() >= 13) {
            AppMethodBeat.o(4191);
            return 4;
        } else {
            AppMethodBeat.o(4191);
            return 2;
        }
    }

    public static boolean isNetworkAvailable() {
        AppMethodBeat.i(4192);
        if (getCurrentNetWorkStatus(XWalkEnvironment.getApplicationContext()) == 0) {
            XWalkEnvironment.addXWalkInitializeLog("no network");
            AppMethodBeat.o(4192);
            return false;
        }
        AppMethodBeat.o(4192);
        return true;
    }

    public static boolean isWifiAvailable() {
        AppMethodBeat.i(4193);
        switch (getCurrentNetWorkStatus(XWalkEnvironment.getApplicationContext())) {
            case 1:
                AppMethodBeat.o(4193);
                return true;
            default:
                AppMethodBeat.o(4193);
                return false;
        }
    }
}
