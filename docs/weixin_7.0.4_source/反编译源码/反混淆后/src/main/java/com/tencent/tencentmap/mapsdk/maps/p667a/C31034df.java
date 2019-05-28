package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.df */
public final class C31034df {
    /* renamed from: a */
    public static String f14098a = "";
    /* renamed from: b */
    public static String f14099b = "";
    /* renamed from: c */
    public static String f14100c = "";
    /* renamed from: d */
    public static String f14101d = "";

    /* renamed from: a */
    private static String m49864a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            return BuildConfig.COMMAND;
        }
    }

    /* renamed from: b */
    private static String m49866b() {
        try {
            return VERSION.RELEASE;
        } catch (Throwable th) {
            return BuildConfig.COMMAND;
        }
    }

    /* renamed from: b */
    private static String m49867b(Context context) {
        AppMethodBeat.m2504i(98700);
        String valueOf;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str = packageInfo.versionName;
            int i = packageInfo.versionCode;
            if (str == null || str.trim().length() <= 0) {
                valueOf = String.valueOf(i);
                AppMethodBeat.m2505o(98700);
                return valueOf;
            }
            str = str.trim().replace(10, ' ').replace(13, ' ').replace("|", "%7C");
            char[] toCharArray = str.toCharArray();
            int i2 = 0;
            for (char c : toCharArray) {
                if (c == '.') {
                    i2++;
                }
            }
            valueOf = i2 < 3 ? str + "." + i : str;
            AppMethodBeat.m2505o(98700);
            return valueOf;
        } catch (Throwable th) {
            valueOf = "";
            AppMethodBeat.m2505o(98700);
            return valueOf;
        }
    }

    /* renamed from: c */
    private static String m49868c() {
        try {
            return VERSION.SDK;
        } catch (Throwable th) {
            return BuildConfig.COMMAND;
        }
    }

    /* renamed from: d */
    private static String m49869d() {
        String str = null;
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            return str;
        }
    }

    /* renamed from: a */
    public static void m49865a(Context context) {
        AppMethodBeat.m2504i(98699);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(C31034df.m49864a());
        stringBuffer.append(";Android ");
        stringBuffer.append(C31034df.m49866b());
        stringBuffer.append(",level ");
        stringBuffer.append(C31034df.m49868c());
        f14098a = stringBuffer.toString();
        f14099b = C31034df.m49867b(context);
        context.getPackageName();
        f14100c = C31034df.m49869d();
        f14101d = C31034df.m49864a();
        AppMethodBeat.m2505o(98699);
    }
}
