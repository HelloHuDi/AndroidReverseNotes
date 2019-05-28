package com.tencent.p177mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.platformtools.ah */
public final class C4996ah {
    private static String ceO = "com.tencent.mm";
    private static Context context = null;
    private static volatile Resources mResources = null;
    private static String processName = ceO;
    private static String xza = "com.tencent.mm";
    private static String xzb = "com.tencent.mm.ui.LauncherUI";
    private static boolean xzc = false;
    public static boolean xzd = false;
    private static ActivityManager xze = null;

    /* renamed from: ph */
    public static void m7432ph(boolean z) {
        xzc = z;
    }

    public static boolean dox() {
        return xzc;
    }

    public static String doy() {
        return xzb;
    }

    public static void setContext(Context context) {
        AppMethodBeat.m2504i(115236);
        context = context;
        ceO = context.getPackageName();
        C4990ab.m7410d("MicroMsg.MMApplicationContext", "setup application context for package: " + ceO);
        AppMethodBeat.m2505o(115236);
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
        AppMethodBeat.m2504i(115237);
        String str = ceO + "_preferences";
        AppMethodBeat.m2505o(115237);
        return str;
    }

    public static SharedPreferences doB() {
        AppMethodBeat.m2504i(115238);
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(C4996ah.doA(), 0);
            AppMethodBeat.m2505o(115238);
            return sharedPreferences;
        }
        AppMethodBeat.m2505o(115238);
        return null;
    }

    public static SharedPreferences doC() {
        AppMethodBeat.m2504i(115239);
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(ceO + "_preferences_tools", 0);
            AppMethodBeat.m2505o(115239);
            return sharedPreferences;
        }
        AppMethodBeat.m2505o(115239);
        return null;
    }

    public static String doD() {
        AppMethodBeat.m2504i(115240);
        String str = ceO + "_tmp_preferences";
        AppMethodBeat.m2505o(115240);
        return str;
    }

    public static String getProcessName() {
        return processName;
    }

    /* renamed from: ce */
    public static void m7430ce(String str) {
        processName = str;
    }

    public static boolean doI() {
        AppMethodBeat.m2504i(115247);
        boolean amz = C4996ah.amz(ceO);
        AppMethodBeat.m2505o(115247);
        return amz;
    }

    public static boolean amz(String str) {
        AppMethodBeat.m2504i(115248);
        if (context == null || ceO == null) {
            AppMethodBeat.m2505o(115248);
            return false;
        }
        if (xze == null) {
            xze = (ActivityManager) context.getSystemService("activity");
        }
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : xze.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    AppMethodBeat.m2505o(115248);
                    return true;
                }
            }
            AppMethodBeat.m2505o(115248);
            return false;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + e.toString());
            AppMethodBeat.m2505o(115248);
            return false;
        } catch (Error e2) {
            C4990ab.m7412e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + e2.toString());
            AppMethodBeat.m2505o(115248);
            return false;
        }
    }

    public static Resources getResources() {
        return mResources;
    }

    /* renamed from: f */
    public static void m7431f(Resources resources) {
        mResources = resources;
    }

    public static boolean bqo() {
        AppMethodBeat.m2504i(115241);
        Object obj = processName;
        if (obj == null || obj.length() == 0) {
            obj = ceO;
        }
        boolean equals = ceO.equals(obj);
        AppMethodBeat.m2505o(115241);
        return equals;
    }

    public static boolean isAppBrandProcess() {
        AppMethodBeat.m2504i(115242);
        String str = processName;
        if (str == null || str.length() == 0) {
            str = ceO;
        }
        boolean startsWith = str.startsWith(ceO + ":appbrand");
        AppMethodBeat.m2505o(115242);
        return startsWith;
    }

    public static boolean doE() {
        AppMethodBeat.m2504i(115243);
        String str = processName;
        if (str == null || str.length() == 0) {
            str = ceO;
        }
        boolean equalsIgnoreCase = "com.tencent.mm:push".equalsIgnoreCase(str);
        AppMethodBeat.m2505o(115243);
        return equalsIgnoreCase;
    }

    public static boolean doF() {
        AppMethodBeat.m2504i(115244);
        String str = processName;
        if (str == null || str.length() == 0) {
            str = ceO;
        }
        boolean equalsIgnoreCase = "com.tencent.mm:tools".equalsIgnoreCase(str);
        AppMethodBeat.m2505o(115244);
        return equalsIgnoreCase;
    }

    public static boolean doG() {
        AppMethodBeat.m2504i(115245);
        String str = processName;
        if (str == null || str.length() == 0) {
            str = ceO;
        }
        boolean equalsIgnoreCase = "com.tencent.mm:toolsmp".equalsIgnoreCase(str);
        AppMethodBeat.m2505o(115245);
        return equalsIgnoreCase;
    }

    public static boolean doH() {
        AppMethodBeat.m2504i(115246);
        String str = processName;
        if (str == null || str.length() == 0) {
            str = ceO;
        }
        boolean equalsIgnoreCase = "com.tencent.mm:exdevice".equalsIgnoreCase(str);
        AppMethodBeat.m2505o(115246);
        return equalsIgnoreCase;
    }
}
