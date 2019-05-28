package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ah {
    private static String ceO = "com.tencent.mm";
    private static Context context = null;
    private static volatile Resources mResources = null;
    private static String processName = ceO;
    private static String xza = "com.tencent.mm";
    private static String xzb = "com.tencent.mm.ui.LauncherUI";
    private static boolean xzc = false;
    public static boolean xzd = false;
    private static ActivityManager xze = null;

    public static void ph(boolean z) {
        xzc = z;
    }

    public static boolean dox() {
        return xzc;
    }

    public static String doy() {
        return xzb;
    }

    public static void setContext(Context context) {
        AppMethodBeat.i(115236);
        context = context;
        ceO = context.getPackageName();
        ab.d("MicroMsg.MMApplicationContext", "setup application context for package: " + ceO);
        AppMethodBeat.o(115236);
    }

    public static Context getContext() {
        return context;
    }

    public static String getPackageName() {
        return ceO;
    }

    public static String doz() {
        return xza;
    }

    public static String doA() {
        AppMethodBeat.i(115237);
        String str = ceO + "_preferences";
        AppMethodBeat.o(115237);
        return str;
    }

    public static SharedPreferences doB() {
        AppMethodBeat.i(115238);
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(doA(), 0);
            AppMethodBeat.o(115238);
            return sharedPreferences;
        }
        AppMethodBeat.o(115238);
        return null;
    }

    public static SharedPreferences doC() {
        AppMethodBeat.i(115239);
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(ceO + "_preferences_tools", 0);
            AppMethodBeat.o(115239);
            return sharedPreferences;
        }
        AppMethodBeat.o(115239);
        return null;
    }

    public static String doD() {
        AppMethodBeat.i(115240);
        String str = ceO + "_tmp_preferences";
        AppMethodBeat.o(115240);
        return str;
    }

    public static String getProcessName() {
        return processName;
    }

    public static void ce(String str) {
        processName = str;
    }

    public static boolean doI() {
        AppMethodBeat.i(115247);
        boolean amz = amz(ceO);
        AppMethodBeat.o(115247);
        return amz;
    }

    public static boolean amz(String str) {
        AppMethodBeat.i(115248);
        if (context == null || ceO == null) {
            AppMethodBeat.o(115248);
            return false;
        }
        if (xze == null) {
            xze = (ActivityManager) context.getSystemService("activity");
        }
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : xze.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    AppMethodBeat.o(115248);
                    return true;
                }
            }
            AppMethodBeat.o(115248);
            return false;
        } catch (Exception e) {
            ab.e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + e.toString());
            AppMethodBeat.o(115248);
            return false;
        } catch (Error e2) {
            ab.e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + e2.toString());
            AppMethodBeat.o(115248);
            return false;
        }
    }

    public static Resources getResources() {
        return mResources;
    }

    public static void f(Resources resources) {
        mResources = resources;
    }

    public static boolean bqo() {
        AppMethodBeat.i(115241);
        Object obj = processName;
        if (obj == null || obj.length() == 0) {
            obj = ceO;
        }
        boolean equals = ceO.equals(obj);
        AppMethodBeat.o(115241);
        return equals;
    }

    public static boolean isAppBrandProcess() {
        AppMethodBeat.i(115242);
        String str = processName;
        if (str == null || str.length() == 0) {
            str = ceO;
        }
        boolean startsWith = str.startsWith(ceO + ":appbrand");
        AppMethodBeat.o(115242);
        return startsWith;
    }

    public static boolean doE() {
        AppMethodBeat.i(115243);
        String str = processName;
        if (str == null || str.length() == 0) {
            str = ceO;
        }
        boolean equalsIgnoreCase = "com.tencent.mm:push".equalsIgnoreCase(str);
        AppMethodBeat.o(115243);
        return equalsIgnoreCase;
    }

    public static boolean doF() {
        AppMethodBeat.i(115244);
        String str = processName;
        if (str == null || str.length() == 0) {
            str = ceO;
        }
        boolean equalsIgnoreCase = "com.tencent.mm:tools".equalsIgnoreCase(str);
        AppMethodBeat.o(115244);
        return equalsIgnoreCase;
    }

    public static boolean doG() {
        AppMethodBeat.i(115245);
        String str = processName;
        if (str == null || str.length() == 0) {
            str = ceO;
        }
        boolean equalsIgnoreCase = "com.tencent.mm:toolsmp".equalsIgnoreCase(str);
        AppMethodBeat.o(115245);
        return equalsIgnoreCase;
    }

    public static boolean doH() {
        AppMethodBeat.i(115246);
        String str = processName;
        if (str == null || str.length() == 0) {
            str = ceO;
        }
        boolean equalsIgnoreCase = "com.tencent.mm:exdevice".equalsIgnoreCase(str);
        AppMethodBeat.o(115246);
        return equalsIgnoreCase;
    }
}
