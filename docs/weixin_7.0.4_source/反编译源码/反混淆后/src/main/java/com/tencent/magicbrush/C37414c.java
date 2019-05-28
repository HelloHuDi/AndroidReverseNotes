package com.tencent.magicbrush;

import android.os.SystemClock;
import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

/* renamed from: com.tencent.magicbrush.c */
public class C37414c {
    private static String bSy = "";
    private static String bSz = null;

    /* renamed from: b */
    public static void m63042b(Closeable closeable) {
        AppMethodBeat.m2504i(115849);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                AppMethodBeat.m2505o(115849);
                return;
            }
        }
        AppMethodBeat.m2505o(115849);
    }

    public static boolean isNullOrNil(String str) {
        AppMethodBeat.m2504i(115850);
        if (str == null || "".equals(str)) {
            AppMethodBeat.m2505o(115850);
            return true;
        }
        AppMethodBeat.m2505o(115850);
        return false;
    }

    public static void loadLibrary(String str) {
        AppMethodBeat.m2504i(115851);
        String str2 = null;
        if (bSz != null) {
            str2 = bSz + "/lib" + str + ".so";
        }
        if (str2 == null || !new File(str2).exists()) {
            C17837c.m27914d("MagicBrush.Utils", "System.loadLibrary(%s)", str);
            System.loadLibrary(str);
            AppMethodBeat.m2505o(115851);
            return;
        }
        C17837c.m27914d("MagicBrush.Utils", "System.load(%s)", str2);
        try {
            ClassLoader classLoader = C37414c.class.getClassLoader();
            Runtime runtime = Runtime.getRuntime();
            Method declaredMethod = runtime.getClass().getDeclaredMethod("load", new Class[]{String.class, ClassLoader.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(runtime, new Object[]{str2, classLoader});
            AppMethodBeat.m2505o(115851);
        } catch (Exception e) {
            C17837c.m27915e("MagicBrush.Utils", "loadLibrary Exception", e);
            AppMethodBeat.m2505o(115851);
        }
    }

    /* renamed from: yz */
    public static long m63043yz() {
        AppMethodBeat.m2504i(115852);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AppMethodBeat.m2505o(115852);
        return elapsedRealtime;
    }

    /* renamed from: az */
    public static long m63041az(long j) {
        AppMethodBeat.m2504i(115853);
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        AppMethodBeat.m2505o(115853);
        return elapsedRealtime;
    }
}
