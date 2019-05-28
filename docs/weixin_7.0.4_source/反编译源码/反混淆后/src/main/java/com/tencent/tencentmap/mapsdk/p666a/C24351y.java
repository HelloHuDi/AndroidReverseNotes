package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.tencent.tencentmap.mapsdk.a.y */
public class C24351y {
    /* renamed from: a */
    public static String f4626a = "TencentMapSDK";
    /* renamed from: b */
    private static String f4627b;
    /* renamed from: c */
    private static String f4628c;
    /* renamed from: d */
    private static String f4629d;
    /* renamed from: e */
    private static String f4630e;
    /* renamed from: f */
    private static String f4631f;
    /* renamed from: g */
    private static String f4632g;
    /* renamed from: h */
    private static String f4633h;
    /* renamed from: i */
    private static float f4634i = 1.0f;

    /* renamed from: a */
    public static void m37628a(Context context) {
        String b;
        AppMethodBeat.m2504i(101236);
        if (f4627b == null) {
            b = C24351y.m37630b(context);
            f4627b = b;
            f4627b = C24351y.m37627a(b);
        }
        if (f4628c == null) {
            b = C24351y.m37632c(context);
            f4628c = b;
            f4628c = C24351y.m37627a(b);
        }
        if (f4629d == null) {
            b = Build.MODEL;
            f4629d = b;
            f4629d = C24351y.m37627a(b);
        }
        if (f4630e == null) {
            f4630e = VERSION.RELEASE;
        }
        if (f4631f == null) {
            b = C24351y.m37634d(context);
            f4631f = b;
            f4631f = C24351y.m37627a(b);
        }
        if (f4632g == null) {
            b = context.getPackageName();
            f4632g = b;
            f4632g = C24351y.m37627a(b);
        }
        if (f4633h == null) {
            b = C24351y.m37636e(context);
            f4633h = b;
            f4633h = C24351y.m37627a(b);
        }
        f4634i = context.getResources().getDisplayMetrics().density;
        AppMethodBeat.m2505o(101236);
    }

    /* renamed from: a */
    public static String m37626a() {
        return f4628c;
    }

    /* renamed from: b */
    public static String m37629b() {
        return f4629d;
    }

    /* renamed from: c */
    public static String m37631c() {
        return f4630e;
    }

    /* renamed from: d */
    public static String m37633d() {
        return f4631f;
    }

    /* renamed from: e */
    public static String m37635e() {
        return f4632g;
    }

    /* renamed from: f */
    public static String m37637f() {
        return f4633h;
    }

    /* renamed from: g */
    public static float m37638g() {
        return f4634i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static String m37630b(Context context) {
        String str;
        AppMethodBeat.m2504i(101237);
        String str2 = "";
        if (VERSION.SDK_INT < 21) {
            str = "armeabi-v7a";
        } else if (VERSION.SDK_INT < 21 || VERSION.SDK_INT >= 23) {
            str = VERSION.SDK_INT >= 23 ? Process.is64Bit() ? Build.SUPPORTED_64_BIT_ABIS[0] : Build.SUPPORTED_32_BIT_ABIS[0] : str2;
        } else {
            try {
                Object invoke = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[]{String.class}).invoke(context.getClassLoader(), new Object[]{"art"});
                if (invoke != null) {
                    str = ((String) invoke).contains("lib64") ? Build.SUPPORTED_64_BIT_ABIS[0] : Build.SUPPORTED_32_BIT_ABIS[0];
                    if (str == null) {
                        str = Build.SUPPORTED_ABIS[0];
                    }
                }
            } catch (NoSuchMethodException e) {
                str = str2;
            } catch (IllegalAccessException e2) {
                str = str2;
            } catch (InvocationTargetException e3) {
                str = str2;
            } catch (NullPointerException e4) {
            }
            str = str2;
            if (str == null) {
            }
        }
        AppMethodBeat.m2505o(101237);
        return str;
    }

    /* renamed from: c */
    private static String m37632c(Context context) {
        AppMethodBeat.m2504i(101238);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.m2505o(101238);
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            str = "";
            AppMethodBeat.m2505o(101238);
            return str;
        }
        if (VERSION.SDK_INT <= 22) {
            str = telephonyManager.getDeviceId();
        } else if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            str = "no permission";
        } else {
            str = telephonyManager.getDeviceId();
        }
        AppMethodBeat.m2505o(101238);
        return str;
    }

    /* renamed from: d */
    private static String m37634d(Context context) {
        AppMethodBeat.m2504i(101239);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.m2505o(101239);
            return str;
        }
        PackageManager packageManager = context.getPackageManager();
        CharSequence charSequence = "unknown";
        try {
            charSequence = packageManager.getApplicationInfo(context.getPackageName(), 128).loadLabel(packageManager);
        } catch (NameNotFoundException e) {
            C36476dy.m60313b(Log.getStackTraceString(e));
        }
        str = charSequence.toString();
        AppMethodBeat.m2505o(101239);
        return str;
    }

    /* renamed from: e */
    private static String m37636e(Context context) {
        AppMethodBeat.m2504i(101240);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.m2505o(101240);
            return str;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (NameNotFoundException e) {
        }
        if (applicationInfo == null) {
            str = "";
            AppMethodBeat.m2505o(101240);
            return str;
        } else if (applicationInfo.metaData == null) {
            str = "";
            AppMethodBeat.m2505o(101240);
            return str;
        } else {
            str = applicationInfo.metaData.getString(f4626a);
            AppMethodBeat.m2505o(101240);
            return str;
        }
    }

    /* renamed from: a */
    private static String m37627a(String str) {
        AppMethodBeat.m2504i(101241);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(101241);
            return str2;
        }
        str2 = str.replace("&", "").replace("#", "").replace("?", "");
        AppMethodBeat.m2505o(101241);
        return str2;
    }
}
