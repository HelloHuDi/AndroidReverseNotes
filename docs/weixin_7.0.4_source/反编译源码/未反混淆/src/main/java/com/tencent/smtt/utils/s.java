package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;

public class s {
    private static String a = null;
    private static String b = "GA";
    private static String c = "GE";
    private static String d = "9422";
    private static String e = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private static String f = "";
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;

    private static String a() {
        AppMethodBeat.i(65297);
        String str = " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
        AppMethodBeat.o(65297);
        return str;
    }

    public static String a(Context context) {
        AppMethodBeat.i(65291);
        String a;
        if (TextUtils.isEmpty(a)) {
            a = a(context, String.valueOf(WebView.getTbsSDKVersion(context)), AppEventsConstants.EVENT_PARAM_VALUE_NO, b, c, d, e, f, g);
            a = a;
            AppMethodBeat.o(65291);
            return a;
        }
        a = a;
        AppMethodBeat.o(65291);
        return a;
    }

    private static String a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        CharSequence str8;
        Object str82;
        AppMethodBeat.i(65292);
        String str9 = "";
        String str10 = "";
        String str11 = "PHONE";
        StringBuilder stringBuilder = new StringBuilder();
        String str12 = b(context) + "*" + c(context);
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getApplicationInfo();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
            str9 = applicationInfo.packageName;
            if (TextUtils.isEmpty(str7)) {
                str7 = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            str7 = str10;
        }
        String a = a(str9);
        if ("QB".equals(a)) {
            if (z) {
                str10 = "PAD";
            }
            str10 = str11;
        } else {
            if (d(context)) {
                str10 = "PAD";
            }
            str10 = str11;
        }
        stringBuilder.append("QV=3");
        a(stringBuilder, "PL", "ADR");
        a(stringBuilder, "PR", a);
        a(stringBuilder, "PP", str9);
        a(stringBuilder, "PPVN", str7);
        if (!TextUtils.isEmpty(str)) {
            a(stringBuilder, "TBSVC", str);
        }
        a(stringBuilder, "CO", "SYS");
        if (!TextUtils.isEmpty(str2)) {
            a(stringBuilder, "COVC", str2);
        }
        a(stringBuilder, "PB", str4);
        a(stringBuilder, "VE", str3);
        a(stringBuilder, "DE", str10);
        str10 = "CHID";
        if (TextUtils.isEmpty(str6)) {
            str6 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        a(stringBuilder, str10, str6);
        a(stringBuilder, "LCID", str5);
        str9 = a();
        try {
            str82 = new String(str9.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e2) {
            str82 = str9;
        }
        if (!TextUtils.isEmpty(str82)) {
            a(stringBuilder, "MO", str82);
        }
        a(stringBuilder, "RL", str12);
        str9 = VERSION.RELEASE;
        try {
            str82 = new String(str9.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e3) {
            str82 = str9;
        }
        if (!TextUtils.isEmpty(str82)) {
            a(stringBuilder, "OS", str82);
        }
        a(stringBuilder, "API", VERSION.SDK_INT);
        str10 = stringBuilder.toString();
        AppMethodBeat.o(65292);
        return str10;
    }

    private static String a(String str) {
        AppMethodBeat.i(65294);
        String str2;
        if ("com.tencent.mm".equals(str)) {
            str2 = "WX";
            AppMethodBeat.o(65294);
            return str2;
        } else if (TbsConfig.APP_QQ.equals(str)) {
            str2 = "QQ";
            AppMethodBeat.o(65294);
            return str2;
        } else if (TbsConfig.APP_QZONE.equals(str)) {
            str2 = "QZ";
            AppMethodBeat.o(65294);
            return str2;
        } else if (TbsConfig.APP_QB.equals(str)) {
            str2 = "QB";
            AppMethodBeat.o(65294);
            return str2;
        } else {
            str2 = "TRD";
            AppMethodBeat.o(65294);
            return str2;
        }
    }

    private static void a(StringBuilder stringBuilder, String str, String str2) {
        AppMethodBeat.i(65293);
        stringBuilder.append("&").append(str).append("=").append(str2);
        AppMethodBeat.o(65293);
    }

    private static int b(Context context) {
        AppMethodBeat.i(65295);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            int width = defaultDisplay.getWidth();
            AppMethodBeat.o(65295);
            return width;
        }
        AppMethodBeat.o(65295);
        return -1;
    }

    private static int c(Context context) {
        AppMethodBeat.i(65296);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            int height = defaultDisplay.getHeight();
            AppMethodBeat.o(65296);
            return height;
        }
        AppMethodBeat.o(65296);
        return -1;
    }

    private static boolean d(Context context) {
        boolean z = true;
        AppMethodBeat.i(65298);
        boolean z2;
        if (h) {
            z2 = i;
            AppMethodBeat.o(65298);
            return z2;
        }
        try {
            if ((Math.min(b(context), c(context)) * 160) / e(context) < 700) {
                z = false;
            }
            i = z;
            h = true;
            z2 = i;
            AppMethodBeat.o(65298);
            return z2;
        } catch (Throwable th) {
            AppMethodBeat.o(65298);
            return false;
        }
    }

    private static int e(Context context) {
        AppMethodBeat.i(65299);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getMetrics(displayMetrics);
            int i = displayMetrics.densityDpi;
            AppMethodBeat.o(65299);
            return i;
        }
        AppMethodBeat.o(65299);
        return 160;
    }
}
