package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;

public final class df {
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";

    private static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            return BuildConfig.COMMAND;
        }
    }

    private static String b() {
        try {
            return VERSION.RELEASE;
        } catch (Throwable th) {
            return BuildConfig.COMMAND;
        }
    }

    private static String b(Context context) {
        AppMethodBeat.i(98700);
        String valueOf;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str = packageInfo.versionName;
            int i = packageInfo.versionCode;
            if (str == null || str.trim().length() <= 0) {
                valueOf = String.valueOf(i);
                AppMethodBeat.o(98700);
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
            AppMethodBeat.o(98700);
            return valueOf;
        } catch (Throwable th) {
            valueOf = "";
            AppMethodBeat.o(98700);
            return valueOf;
        }
    }

    private static String c() {
        try {
            return VERSION.SDK;
        } catch (Throwable th) {
            return BuildConfig.COMMAND;
        }
    }

    private static String d() {
        String str = null;
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            return str;
        }
    }

    public static void a(Context context) {
        AppMethodBeat.i(98699);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a());
        stringBuffer.append(";Android ");
        stringBuffer.append(b());
        stringBuffer.append(",level ");
        stringBuffer.append(c());
        a = stringBuffer.toString();
        b = b(context);
        context.getPackageName();
        c = d();
        d = a();
        AppMethodBeat.o(98699);
    }
}
