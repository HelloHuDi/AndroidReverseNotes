package com.tencent.magicbrush;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class c {
    private static String bSy = "";
    private static String bSz = null;

    public static void b(Closeable closeable) {
        AppMethodBeat.i(115849);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                AppMethodBeat.o(115849);
                return;
            }
        }
        AppMethodBeat.o(115849);
    }

    public static boolean isNullOrNil(String str) {
        AppMethodBeat.i(115850);
        if (str == null || "".equals(str)) {
            AppMethodBeat.o(115850);
            return true;
        }
        AppMethodBeat.o(115850);
        return false;
    }

    public static void loadLibrary(String str) {
        AppMethodBeat.i(115851);
        String str2 = null;
        if (bSz != null) {
            str2 = bSz + "/lib" + str + ".so";
        }
        if (str2 == null || !new File(str2).exists()) {
            com.tencent.magicbrush.a.c.c.d("MagicBrush.Utils", "System.loadLibrary(%s)", str);
            System.loadLibrary(str);
            AppMethodBeat.o(115851);
            return;
        }
        com.tencent.magicbrush.a.c.c.d("MagicBrush.Utils", "System.load(%s)", str2);
        try {
            ClassLoader classLoader = c.class.getClassLoader();
            Runtime runtime = Runtime.getRuntime();
            Method declaredMethod = runtime.getClass().getDeclaredMethod("load", new Class[]{String.class, ClassLoader.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(runtime, new Object[]{str2, classLoader});
            AppMethodBeat.o(115851);
        } catch (Exception e) {
            com.tencent.magicbrush.a.c.c.e("MagicBrush.Utils", "loadLibrary Exception", e);
            AppMethodBeat.o(115851);
        }
    }

    public static long yz() {
        AppMethodBeat.i(115852);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AppMethodBeat.o(115852);
        return elapsedRealtime;
    }

    public static long az(long j) {
        AppMethodBeat.i(115853);
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        AppMethodBeat.o(115853);
        return elapsedRealtime;
    }
}
