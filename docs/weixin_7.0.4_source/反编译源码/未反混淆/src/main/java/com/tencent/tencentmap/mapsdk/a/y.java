package com.tencent.tencentmap.mapsdk.a;

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

public class y {
    public static String a = "TencentMapSDK";
    private static String b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static float i = 1.0f;

    public static void a(Context context) {
        String b;
        AppMethodBeat.i(101236);
        if (b == null) {
            b = b(context);
            b = b;
            b = a(b);
        }
        if (c == null) {
            b = c(context);
            c = b;
            c = a(b);
        }
        if (d == null) {
            b = Build.MODEL;
            d = b;
            d = a(b);
        }
        if (e == null) {
            e = VERSION.RELEASE;
        }
        if (f == null) {
            b = d(context);
            f = b;
            f = a(b);
        }
        if (g == null) {
            b = context.getPackageName();
            g = b;
            g = a(b);
        }
        if (h == null) {
            b = e(context);
            h = b;
            h = a(b);
        }
        i = context.getResources().getDisplayMetrics().density;
        AppMethodBeat.o(101236);
    }

    public static String a() {
        return c;
    }

    public static String b() {
        return d;
    }

    public static String c() {
        return e;
    }

    public static String d() {
        return f;
    }

    public static String e() {
        return g;
    }

    public static String f() {
        return h;
    }

    public static float g() {
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String b(Context context) {
        String str;
        AppMethodBeat.i(101237);
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
        AppMethodBeat.o(101237);
        return str;
    }

    private static String c(Context context) {
        AppMethodBeat.i(101238);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.o(101238);
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            str = "";
            AppMethodBeat.o(101238);
            return str;
        }
        if (VERSION.SDK_INT <= 22) {
            str = telephonyManager.getDeviceId();
        } else if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            str = "no permission";
        } else {
            str = telephonyManager.getDeviceId();
        }
        AppMethodBeat.o(101238);
        return str;
    }

    private static String d(Context context) {
        AppMethodBeat.i(101239);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.o(101239);
            return str;
        }
        PackageManager packageManager = context.getPackageManager();
        CharSequence charSequence = "unknown";
        try {
            charSequence = packageManager.getApplicationInfo(context.getPackageName(), 128).loadLabel(packageManager);
        } catch (NameNotFoundException e) {
            dy.b(Log.getStackTraceString(e));
        }
        str = charSequence.toString();
        AppMethodBeat.o(101239);
        return str;
    }

    private static String e(Context context) {
        AppMethodBeat.i(101240);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.o(101240);
            return str;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (NameNotFoundException e) {
        }
        if (applicationInfo == null) {
            str = "";
            AppMethodBeat.o(101240);
            return str;
        } else if (applicationInfo.metaData == null) {
            str = "";
            AppMethodBeat.o(101240);
            return str;
        } else {
            str = applicationInfo.metaData.getString(a);
            AppMethodBeat.o(101240);
            return str;
        }
    }

    private static String a(String str) {
        AppMethodBeat.i(101241);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(101241);
            return str2;
        }
        str2 = str.replace("&", "").replace("#", "").replace("?", "");
        AppMethodBeat.o(101241);
        return str2;
    }
}
