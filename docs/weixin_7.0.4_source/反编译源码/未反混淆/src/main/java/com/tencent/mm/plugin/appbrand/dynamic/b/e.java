package com.tencent.mm.plugin.appbrand.dynamic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {
    private static volatile e hmz;
    private Map<String, SoftReference<WxaPkgWrappingInfo>> eGu = new ConcurrentHashMap();

    private static e azP() {
        AppMethodBeat.i(10788);
        if (hmz == null) {
            synchronized (e.class) {
                try {
                    if (hmz == null) {
                        hmz = new e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(10788);
                    }
                }
            }
        }
        e eVar = hmz;
        AppMethodBeat.o(10788);
        return eVar;
    }

    private e() {
        AppMethodBeat.i(10789);
        AppMethodBeat.o(10789);
    }

    public static boolean a(String str, WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        AppMethodBeat.i(10790);
        if (str == null || str.length() == 0 || wxaPkgWrappingInfo == null) {
            AppMethodBeat.o(10790);
            return false;
        }
        azP().eGu.put(str, new SoftReference(wxaPkgWrappingInfo));
        AppMethodBeat.o(10790);
        return true;
    }

    public static WxaPkgWrappingInfo Ac(String str) {
        AppMethodBeat.i(10791);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(10791);
            return null;
        }
        SoftReference softReference = (SoftReference) azP().eGu.get(str);
        if (softReference != null) {
            WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) softReference.get();
            AppMethodBeat.o(10791);
            return wxaPkgWrappingInfo;
        }
        AppMethodBeat.o(10791);
        return null;
    }

    public static void removeAll() {
        AppMethodBeat.i(10792);
        azP().eGu.clear();
        AppMethodBeat.o(10792);
    }
}
