package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.a.du */
public class C5846du {
    /* renamed from: a */
    public static NetworkInfo m8973a(Context context) {
        AppMethodBeat.m2504i(101111);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            AppMethodBeat.m2505o(101111);
            return activeNetworkInfo;
        } catch (Exception e) {
            AppMethodBeat.m2505o(101111);
            return null;
        }
    }

    /* renamed from: b */
    public static int m8974b(Context context) {
        AppMethodBeat.m2504i(101112);
        int a = C5846du.m8972a(C5846du.m8973a(context));
        AppMethodBeat.m2505o(101112);
        return a;
    }

    /* renamed from: c */
    public static String m8975c(Context context) {
        AppMethodBeat.m2504i(101113);
        String str = "";
        switch (C5846du.m8974b(context)) {
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
        AppMethodBeat.m2505o(101113);
        return str;
    }

    /* renamed from: a */
    private static int m8972a(NetworkInfo networkInfo) {
        AppMethodBeat.m2504i(101114);
        if (networkInfo == null || !networkInfo.isAvailable()) {
            AppMethodBeat.m2505o(101114);
            return 0;
        }
        int type = networkInfo.getType();
        if (type == 1) {
            AppMethodBeat.m2505o(101114);
            return 5;
        } else if (type != 0) {
            AppMethodBeat.m2505o(101114);
            return 6;
        } else {
            String extraInfo = networkInfo.getExtraInfo();
            if (StringUtil.isEmpty(extraInfo)) {
                AppMethodBeat.m2505o(101114);
                return 6;
            } else if (extraInfo.equalsIgnoreCase("cmwap")) {
                AppMethodBeat.m2505o(101114);
                return 1;
            } else if (extraInfo.equalsIgnoreCase("3gwap")) {
                AppMethodBeat.m2505o(101114);
                return 3;
            } else if (extraInfo.equalsIgnoreCase("uniwap")) {
                AppMethodBeat.m2505o(101114);
                return 2;
            } else if (extraInfo.equalsIgnoreCase("ctwap")) {
                AppMethodBeat.m2505o(101114);
                return 4;
            } else {
                AppMethodBeat.m2505o(101114);
                return 3;
            }
        }
    }
}
