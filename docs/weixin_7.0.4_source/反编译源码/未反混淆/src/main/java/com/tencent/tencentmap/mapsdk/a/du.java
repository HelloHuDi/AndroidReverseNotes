package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class du {
    public static NetworkInfo a(Context context) {
        AppMethodBeat.i(101111);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            AppMethodBeat.o(101111);
            return activeNetworkInfo;
        } catch (Exception e) {
            AppMethodBeat.o(101111);
            return null;
        }
    }

    public static int b(Context context) {
        AppMethodBeat.i(101112);
        int a = a(a(context));
        AppMethodBeat.o(101112);
        return a;
    }

    public static String c(Context context) {
        AppMethodBeat.i(101113);
        String str = "";
        switch (b(context)) {
            case 1:
                str = "cmwap";
                break;
            case 2:
                str = "uniwap";
                break;
            case 3:
                str = "3gwap";
                break;
            case 4:
                str = "ctwap";
                break;
            case 5:
                str = "wifi";
                break;
        }
        AppMethodBeat.o(101113);
        return str;
    }

    private static int a(NetworkInfo networkInfo) {
        AppMethodBeat.i(101114);
        if (networkInfo == null || !networkInfo.isAvailable()) {
            AppMethodBeat.o(101114);
            return 0;
        }
        int type = networkInfo.getType();
        if (type == 1) {
            AppMethodBeat.o(101114);
            return 5;
        } else if (type != 0) {
            AppMethodBeat.o(101114);
            return 6;
        } else {
            String extraInfo = networkInfo.getExtraInfo();
            if (StringUtil.isEmpty(extraInfo)) {
                AppMethodBeat.o(101114);
                return 6;
            } else if (extraInfo.equalsIgnoreCase("cmwap")) {
                AppMethodBeat.o(101114);
                return 1;
            } else if (extraInfo.equalsIgnoreCase("3gwap")) {
                AppMethodBeat.o(101114);
                return 3;
            } else if (extraInfo.equalsIgnoreCase("uniwap")) {
                AppMethodBeat.o(101114);
                return 2;
            } else if (extraInfo.equalsIgnoreCase("ctwap")) {
                AppMethodBeat.o(101114);
                return 4;
            } else {
                AppMethodBeat.o(101114);
                return 3;
            }
        }
    }
}
