package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.C30951r;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public final class CacheManager {
    @Deprecated
    public static boolean cacheDisabled() {
        AppMethodBeat.m2504i(63859);
        C40978bv a = C40978bv.m71073a();
        boolean booleanValue;
        if (a == null || !a.mo64921b()) {
            Object a2 = C30951r.m49579a("android.webkit.CacheManager", "cacheDisabled");
            if (a2 == null) {
                AppMethodBeat.m2505o(63859);
                return false;
            }
            booleanValue = ((Boolean) a2).booleanValue();
            AppMethodBeat.m2505o(63859);
            return booleanValue;
        }
        booleanValue = ((Boolean) a.mo64922c().mo57579c()).booleanValue();
        AppMethodBeat.m2505o(63859);
        return booleanValue;
    }

    public static InputStream getCacheFile(String str, boolean z) {
        AppMethodBeat.m2504i(63861);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            AppMethodBeat.m2505o(63861);
            return null;
        }
        InputStream a2 = a.mo64922c().mo57559a(str, z);
        AppMethodBeat.m2505o(63861);
        return a2;
    }

    public static Object getCacheFile(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(63860);
        C40978bv a = C40978bv.m71073a();
        Object a2;
        if (a == null || !a.mo64921b()) {
            try {
                a2 = C30951r.m49576a(Class.forName("android.webkit.CacheManager"), "getCacheFile", new Class[]{String.class, Map.class}, str, map);
                AppMethodBeat.m2505o(63860);
                return a2;
            } catch (Exception e) {
                AppMethodBeat.m2505o(63860);
                return null;
            }
        }
        a2 = a.mo64922c().mo57592g();
        AppMethodBeat.m2505o(63860);
        return a2;
    }

    @Deprecated
    public static File getCacheFileBaseDir() {
        AppMethodBeat.m2504i(63858);
        C40978bv a = C40978bv.m71073a();
        File file;
        if (a == null || !a.mo64921b()) {
            file = (File) C30951r.m49579a("android.webkit.CacheManager", "getCacheFileBaseDir");
            AppMethodBeat.m2505o(63858);
            return file;
        }
        file = (File) a.mo64922c().mo57592g();
        AppMethodBeat.m2505o(63858);
        return file;
    }
}
