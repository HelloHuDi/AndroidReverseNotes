package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class g {
    public static int cdf = 0;
    public static String cdg = (VERSION.SDK_INT);
    public static int cdh = 0;
    public static int cdl = 0;
    public static int xya = 0;
    public static int xyb = 0;
    public static String xyc = ("market://details?id=" + ah.getPackageName());
    public static boolean xyd = false;
    public static boolean xye = true;
    public static boolean xyf = false;
    public static boolean xyg = false;

    static {
        AppMethodBeat.i(115177);
        AppMethodBeat.o(115177);
    }

    public static void gj(Context context) {
        AppMethodBeat.i(115171);
        try {
            cdf = Integer.parseInt((String) u.amt(bo.convertStreamToString(context.getAssets().open("channel.ini"))).get("CHANNEL"));
            AppMethodBeat.o(115171);
        } catch (Exception e) {
            ab.e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
            ab.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[0]);
            AppMethodBeat.o(115171);
        }
    }

    public static void gk(Context context) {
        AppMethodBeat.i(115172);
        try {
            Map amt = u.amt(bo.convertStreamToString(context.getAssets().open("profile.ini")));
            String nullAsNil = bo.nullAsNil((String) amt.get("PROFILE_DEVICE_TYPE"));
            cdg = nullAsNil;
            if (nullAsNil.length() <= 0) {
                cdg = VERSION.SDK_INT;
            }
            cdh = parseInt((String) amt.get("UPDATE_MODE"));
            xyb = parseInt((String) amt.get("BUILD_REVISION"));
            xyf = parseBoolean((String) amt.get("GPRS_ALERT"));
            cdl = parseInt((String) amt.get("AUTO_ADD_ACOUNT"));
            xyg = parseBoolean((String) amt.get("NOKIA_AOL"));
            ab.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + cdg);
            ab.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + cdh);
            ab.w("MicroMsg.SDK.ChannelUtil", "shouldShowGprsAlert=" + xyf);
            ab.w("MicroMsg.SDK.ChannelUtil", "autoAddAccount=" + cdl);
            ab.w("MicroMsg.SDK.ChannelUtil", "isNokiaol=" + xyg);
            nullAsNil = (String) amt.get("MARKET_URL");
            if (!(nullAsNil == null || nullAsNil.trim().length() == 0 || Uri.parse(nullAsNil) == null)) {
                xyc = nullAsNil;
            }
            ab.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + xyc);
            AppMethodBeat.o(115172);
        } catch (Exception e) {
            ab.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
            ab.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[0]);
            AppMethodBeat.o(115172);
        }
    }

    private static int parseInt(String str) {
        AppMethodBeat.i(115173);
        try {
            int parseInt = Integer.parseInt(str);
            AppMethodBeat.o(115173);
            return parseInt;
        } catch (Exception e) {
            ab.w("MicroMsg.SDK.ChannelUtil", e.getMessage());
            AppMethodBeat.o(115173);
            return 0;
        }
    }

    private static boolean parseBoolean(String str) {
        boolean z = false;
        AppMethodBeat.i(115174);
        try {
            z = Boolean.parseBoolean(str);
            AppMethodBeat.o(115174);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[z]);
            ab.w("MicroMsg.SDK.ChannelUtil", e.getMessage());
            AppMethodBeat.o(115174);
        }
        return z;
    }

    public static String ar(Context context, int i) {
        AppMethodBeat.i(115175);
        String d = d(context, i, xyd);
        AppMethodBeat.o(115175);
        return d;
    }

    public static String d(Context context, int i, boolean z) {
        String str;
        AppMethodBeat.i(115176);
        int i2 = (i >> 8) & 255;
        if (i2 == 0) {
            str = ((i >> 24) & 15) + "." + ((i >> 16) & 255);
        } else {
            str = ((i >> 24) & 15) + "." + ((i >> 16) & 255) + "." + i2;
        }
        ab.d("MicroMsg.SDK.ChannelUtil", "minminor ".concat(String.valueOf(i2)));
        i2 = 268435455 & i;
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
                if (packageInfo != null) {
                    i2 = packageInfo.versionCode;
                    str = packageInfo.versionName;
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[0]);
            }
        }
        if (z) {
            str = str + "_" + i2;
            ab.d("MicroMsg.SDK.ChannelUtil", "full version: ".concat(String.valueOf(str)));
            AppMethodBeat.o(115176);
            return str;
        }
        String[] split = str.split("\\.");
        if (split == null || split.length < 4) {
            AppMethodBeat.o(115176);
            return str;
        }
        str = split[0] + "." + split[1];
        if (split[2].trim().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            AppMethodBeat.o(115176);
            return str;
        }
        str = str + "." + split[2];
        AppMethodBeat.o(115176);
        return str;
    }

    public static boolean dnY() {
        return cdf == 1;
    }

    public static boolean dnZ() {
        return cdf == 1001;
    }
}
