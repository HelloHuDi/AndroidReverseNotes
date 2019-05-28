package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.r;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public final class CacheManager {
    @Deprecated
    public static boolean cacheDisabled() {
        AppMethodBeat.i(63859);
        bv a = bv.a();
        boolean booleanValue;
        if (a == null || !a.b()) {
            Object a2 = r.a("android.webkit.CacheManager", "cacheDisabled");
            if (a2 == null) {
                AppMethodBeat.o(63859);
                return false;
            }
            booleanValue = ((Boolean) a2).booleanValue();
            AppMethodBeat.o(63859);
            return booleanValue;
        }
        booleanValue = ((Boolean) a.c().c()).booleanValue();
        AppMethodBeat.o(63859);
        return booleanValue;
    }

    public static InputStream getCacheFile(String str, boolean z) {
        AppMethodBeat.i(63861);
        bv a = bv.a();
        if (a == null || !a.b()) {
            AppMethodBeat.o(63861);
            return null;
        }
        InputStream a2 = a.c().a(str, z);
        AppMethodBeat.o(63861);
        return a2;
    }

    public static Object getCacheFile(String str, Map<String, String> map) {
        AppMethodBeat.i(63860);
        bv a = bv.a();
        Object a2;
        if (a == null || !a.b()) {
            try {
                a2 = r.a(Class.forName("android.webkit.CacheManager"), "getCacheFile", new Class[]{String.class, Map.class}, str, map);
                AppMethodBeat.o(63860);
                return a2;
            } catch (Exception e) {
                AppMethodBeat.o(63860);
                return null;
            }
        }
        a2 = a.c().g();
        AppMethodBeat.o(63860);
        return a2;
    }

    @Deprecated
    public static File getCacheFileBaseDir() {
        AppMethodBeat.i(63858);
        bv a = bv.a();
        File file;
        if (a == null || !a.b()) {
            file = (File) r.a("android.webkit.CacheManager", "getCacheFileBaseDir");
            AppMethodBeat.o(63858);
            return file;
        }
        file = (File) a.c().g();
        AppMethodBeat.o(63858);
        return file;
    }
}
