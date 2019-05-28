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

/* renamed from: com.tencent.smtt.utils.s */
public class C16160s {
    /* renamed from: a */
    private static String f3057a = null;
    /* renamed from: b */
    private static String f3058b = "GA";
    /* renamed from: c */
    private static String f3059c = "GE";
    /* renamed from: d */
    private static String f3060d = "9422";
    /* renamed from: e */
    private static String f3061e = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    /* renamed from: f */
    private static String f3062f = "";
    /* renamed from: g */
    private static boolean f3063g = false;
    /* renamed from: h */
    private static boolean f3064h = false;
    /* renamed from: i */
    private static boolean f3065i = false;

    /* renamed from: a */
    private static String m24516a() {
        AppMethodBeat.m2504i(65297);
        String str = " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
        AppMethodBeat.m2505o(65297);
        return str;
    }

    /* renamed from: a */
    public static String m24517a(Context context) {
        AppMethodBeat.m2504i(65291);
        String a;
        if (TextUtils.isEmpty(f3057a)) {
            a = C16160s.m24518a(context, String.valueOf(WebView.getTbsSDKVersion(context)), AppEventsConstants.EVENT_PARAM_VALUE_NO, f3058b, f3059c, f3060d, f3061e, f3062f, f3063g);
            f3057a = a;
            AppMethodBeat.m2505o(65291);
            return a;
        }
        a = f3057a;
        AppMethodBeat.m2505o(65291);
        return a;
    }

    /* renamed from: a */
    private static String m24518a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        CharSequence str8;
        Object str82;
        AppMethodBeat.m2504i(65292);
        String str9 = "";
        String str10 = "";
        String str11 = "PHONE";
        StringBuilder stringBuilder = new StringBuilder();
        String str12 = C16160s.m24521b(context) + "*" + C16160s.m24522c(context);
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
        String a = C16160s.m24519a(str9);
        if ("QB".equals(a)) {
            if (z) {
                str10 = "PAD";
            }
            str10 = str11;
        } else {
            if (C16160s.m24523d(context)) {
                str10 = "PAD";
            }
            str10 = str11;
        }
        stringBuilder.append("QV=3");
        C16160s.m24520a(stringBuilder, "PL", "ADR");
        C16160s.m24520a(stringBuilder, "PR", a);
        C16160s.m24520a(stringBuilder, "PP", str9);
        C16160s.m24520a(stringBuilder, "PPVN", str7);
        if (!TextUtils.isEmpty(str)) {
            C16160s.m24520a(stringBuilder, "TBSVC", str);
        }
        C16160s.m24520a(stringBuilder, "CO", "SYS");
        if (!TextUtils.isEmpty(str2)) {
            C16160s.m24520a(stringBuilder, "COVC", str2);
        }
        C16160s.m24520a(stringBuilder, "PB", str4);
        C16160s.m24520a(stringBuilder, "VE", str3);
        C16160s.m24520a(stringBuilder, "DE", str10);
        str10 = "CHID";
        if (TextUtils.isEmpty(str6)) {
            str6 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        C16160s.m24520a(stringBuilder, str10, str6);
        C16160s.m24520a(stringBuilder, "LCID", str5);
        str9 = C16160s.m24516a();
        try {
            str82 = new String(str9.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e2) {
            str82 = str9;
        }
        if (!TextUtils.isEmpty(str82)) {
            C16160s.m24520a(stringBuilder, "MO", str82);
        }
        C16160s.m24520a(stringBuilder, "RL", str12);
        str9 = VERSION.RELEASE;
        try {
            str82 = new String(str9.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e3) {
            str82 = str9;
        }
        if (!TextUtils.isEmpty(str82)) {
            C16160s.m24520a(stringBuilder, "OS", str82);
        }
        C16160s.m24520a(stringBuilder, "API", VERSION.SDK_INT);
        str10 = stringBuilder.toString();
        AppMethodBeat.m2505o(65292);
        return str10;
    }

    /* renamed from: a */
    private static String m24519a(String str) {
        AppMethodBeat.m2504i(65294);
        String str2;
        if ("com.tencent.mm".equals(str)) {
            str2 = "WX";
            AppMethodBeat.m2505o(65294);
            return str2;
        } else if (TbsConfig.APP_QQ.equals(str)) {
            str2 = "QQ";
            AppMethodBeat.m2505o(65294);
            return str2;
        } else if (TbsConfig.APP_QZONE.equals(str)) {
            str2 = "QZ";
            AppMethodBeat.m2505o(65294);
            return str2;
        } else if (TbsConfig.APP_QB.equals(str)) {
            str2 = "QB";
            AppMethodBeat.m2505o(65294);
            return str2;
        } else {
            str2 = "TRD";
            AppMethodBeat.m2505o(65294);
            return str2;
        }
    }

    /* renamed from: a */
    private static void m24520a(StringBuilder stringBuilder, String str, String str2) {
        AppMethodBeat.m2504i(65293);
        stringBuilder.append("&").append(str).append("=").append(str2);
        AppMethodBeat.m2505o(65293);
    }

    /* renamed from: b */
    private static int m24521b(Context context) {
        AppMethodBeat.m2504i(65295);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            int width = defaultDisplay.getWidth();
            AppMethodBeat.m2505o(65295);
            return width;
        }
        AppMethodBeat.m2505o(65295);
        return -1;
    }

    /* renamed from: c */
    private static int m24522c(Context context) {
        AppMethodBeat.m2504i(65296);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            int height = defaultDisplay.getHeight();
            AppMethodBeat.m2505o(65296);
            return height;
        }
        AppMethodBeat.m2505o(65296);
        return -1;
    }

    /* renamed from: d */
    private static boolean m24523d(Context context) {
        boolean z = true;
        AppMethodBeat.m2504i(65298);
        boolean z2;
        if (f3064h) {
            z2 = f3065i;
            AppMethodBeat.m2505o(65298);
            return z2;
        }
        try {
            if ((Math.min(C16160s.m24521b(context), C16160s.m24522c(context)) * 160) / C16160s.m24524e(context) < 700) {
                z = false;
            }
            f3065i = z;
            f3064h = true;
            z2 = f3065i;
            AppMethodBeat.m2505o(65298);
            return z2;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(65298);
            return false;
        }
    }

    /* renamed from: e */
    private static int m24524e(Context context) {
        AppMethodBeat.m2504i(65299);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getMetrics(displayMetrics);
            int i = displayMetrics.densityDpi;
            AppMethodBeat.m2505o(65299);
            return i;
        }
        AppMethodBeat.m2505o(65299);
        return 160;
    }
}
