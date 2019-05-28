package com.tencent.p177mm.plugin.appbrand.dynamic.p284b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.b.e */
public class C33147e {
    private static volatile C33147e hmz;
    private Map<String, SoftReference<WxaPkgWrappingInfo>> eGu = new ConcurrentHashMap();

    private static C33147e azP() {
        AppMethodBeat.m2504i(10788);
        if (hmz == null) {
            synchronized (C33147e.class) {
                try {
                    if (hmz == null) {
                        hmz = new C33147e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(10788);
                    }
                }
            }
        }
        C33147e c33147e = hmz;
        AppMethodBeat.m2505o(10788);
        return c33147e;
    }

    private C33147e() {
        AppMethodBeat.m2504i(10789);
        AppMethodBeat.m2505o(10789);
    }

    /* renamed from: a */
    public static boolean m54190a(String str, WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        AppMethodBeat.m2504i(10790);
        if (str == null || str.length() == 0 || wxaPkgWrappingInfo == null) {
            AppMethodBeat.m2505o(10790);
            return false;
        }
        C33147e.azP().eGu.put(str, new SoftReference(wxaPkgWrappingInfo));
        AppMethodBeat.m2505o(10790);
        return true;
    }

    /* renamed from: Ac */
    public static WxaPkgWrappingInfo m54189Ac(String str) {
        AppMethodBeat.m2504i(10791);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(10791);
            return null;
        }
        SoftReference softReference = (SoftReference) C33147e.azP().eGu.get(str);
        if (softReference != null) {
            WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) softReference.get();
            AppMethodBeat.m2505o(10791);
            return wxaPkgWrappingInfo;
        }
        AppMethodBeat.m2505o(10791);
        return null;
    }

    public static void removeAll() {
        AppMethodBeat.m2504i(10792);
        C33147e.azP().eGu.clear();
        AppMethodBeat.m2505o(10792);
    }
}
