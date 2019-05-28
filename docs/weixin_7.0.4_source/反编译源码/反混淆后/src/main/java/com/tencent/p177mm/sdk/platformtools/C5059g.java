package com.tencent.p177mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.tencent.mm.sdk.platformtools.g */
public final class C5059g {
    public static int cdf = 0;
    public static String cdg = (VERSION.SDK_INT);
    public static int cdh = 0;
    public static int cdl = 0;
    public static int xya = 0;
    public static int xyb = 0;
    public static String xyc = ("market://details?id=" + C4996ah.getPackageName());
    public static boolean xyd = false;
    public static boolean xye = true;
    public static boolean xyf = false;
    public static boolean xyg = false;

    static {
        AppMethodBeat.m2504i(115177);
        AppMethodBeat.m2505o(115177);
    }

    /* renamed from: gj */
    public static void m7674gj(Context context) {
        AppMethodBeat.m2504i(115171);
        try {
            cdf = Integer.parseInt((String) C5066u.amt(C5046bo.convertStreamToString(context.getAssets().open("channel.ini"))).get("CHANNEL"));
            AppMethodBeat.m2505o(115171);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
            C4990ab.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(115171);
        }
    }

    /* renamed from: gk */
    public static void m7675gk(Context context) {
        AppMethodBeat.m2504i(115172);
        try {
            Map amt = C5066u.amt(C5046bo.convertStreamToString(context.getAssets().open("profile.ini")));
            String nullAsNil = C5046bo.nullAsNil((String) amt.get("PROFILE_DEVICE_TYPE"));
            cdg = nullAsNil;
            if (nullAsNil.length() <= 0) {
                cdg = VERSION.SDK_INT;
            }
            cdh = C5059g.parseInt((String) amt.get("UPDATE_MODE"));
            xyb = C5059g.parseInt((String) amt.get("BUILD_REVISION"));
            xyf = C5059g.parseBoolean((String) amt.get("GPRS_ALERT"));
            cdl = C5059g.parseInt((String) amt.get("AUTO_ADD_ACOUNT"));
            xyg = C5059g.parseBoolean((String) amt.get("NOKIA_AOL"));
            C4990ab.m7420w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + cdg);
            C4990ab.m7420w("MicroMsg.SDK.ChannelUtil", "updateMode=" + cdh);
            C4990ab.m7420w("MicroMsg.SDK.ChannelUtil", "shouldShowGprsAlert=" + xyf);
            C4990ab.m7420w("MicroMsg.SDK.ChannelUtil", "autoAddAccount=" + cdl);
            C4990ab.m7420w("MicroMsg.SDK.ChannelUtil", "isNokiaol=" + xyg);
            nullAsNil = (String) amt.get("MARKET_URL");
            if (!(nullAsNil == null || nullAsNil.trim().length() == 0 || Uri.parse(nullAsNil) == null)) {
                xyc = nullAsNil;
            }
            C4990ab.m7420w("MicroMsg.SDK.ChannelUtil", "marketURL=" + xyc);
            AppMethodBeat.m2505o(115172);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
            C4990ab.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(115172);
        }
    }

    private static int parseInt(String str) {
        AppMethodBeat.m2504i(115173);
        try {
            int parseInt = Integer.parseInt(str);
            AppMethodBeat.m2505o(115173);
            return parseInt;
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.SDK.ChannelUtil", e.getMessage());
            AppMethodBeat.m2505o(115173);
            return 0;
        }
    }

    private static boolean parseBoolean(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(115174);
        try {
            z = Boolean.parseBoolean(str);
            AppMethodBeat.m2505o(115174);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[z]);
            C4990ab.m7420w("MicroMsg.SDK.ChannelUtil", e.getMessage());
            AppMethodBeat.m2505o(115174);
        }
        return z;
    }

    /* renamed from: ar */
    public static String m7672ar(Context context, int i) {
        AppMethodBeat.m2504i(115175);
        String d = C5059g.m7673d(context, i, xyd);
        AppMethodBeat.m2505o(115175);
        return d;
    }

    /* renamed from: d */
    public static String m7673d(Context context, int i, boolean z) {
        String str;
        AppMethodBeat.m2504i(115176);
        int i2 = (i >> 8) & 255;
        if (i2 == 0) {
            str = ((i >> 24) & 15) + "." + ((i >> 16) & 255);
        } else {
            str = ((i >> 24) & 15) + "." + ((i >> 16) & 255) + "." + i2;
        }
        C4990ab.m7410d("MicroMsg.SDK.ChannelUtil", "minminor ".concat(String.valueOf(i2)));
        i2 = 268435455 & i;
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
                if (packageInfo != null) {
                    i2 = packageInfo.versionCode;
                    str = packageInfo.versionName;
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SDK.ChannelUtil", e, "", new Object[0]);
            }
        }
        if (z) {
            str = str + "_" + i2;
            C4990ab.m7410d("MicroMsg.SDK.ChannelUtil", "full version: ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(115176);
            return str;
        }
        String[] split = str.split("\\.");
        if (split == null || split.length < 4) {
            AppMethodBeat.m2505o(115176);
            return str;
        }
        str = split[0] + "." + split[1];
        if (split[2].trim().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            AppMethodBeat.m2505o(115176);
            return str;
        }
        str = str + "." + split[2];
        AppMethodBeat.m2505o(115176);
        return str;
    }

    public static boolean dnY() {
        return cdf == 1;
    }

    public static boolean dnZ() {
        return cdf == 1001;
    }
}
