package com.tencent.p177mm.plugin.appbrand.p297h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.h.t */
public final class C26903t {
    private static boolean ifd = false;

    /* renamed from: oU */
    public static C6747i m42837oU(int i) {
        AppMethodBeat.m2504i(73183);
        C6747i d = C26903t.m42836d(i, null, null);
        AppMethodBeat.m2505o(73183);
        return d;
    }

    /* renamed from: d */
    public static C6747i m42836d(int i, String str, byte[] bArr) {
        C6747i c42451v;
        AppMethodBeat.m2504i(73184);
        if (C42454y.m75197oV(i)) {
            c42451v = new C42451v(str, bArr);
        } else {
            c42451v = new C17090c(str, bArr);
        }
        C26903t.m42835c(c42451v);
        AppMethodBeat.m2505o(73184);
        return c42451v;
    }

    /* renamed from: b */
    public static String m42834b(C6747i c6747i) {
        if (c6747i instanceof C42452w) {
            return "WebView-Package";
        }
        if (c6747i instanceof C10258u) {
            return "XWEB-Package";
        }
        if (c6747i instanceof C17090c) {
            return "J2V8-Package";
        }
        if (c6747i instanceof C42451v) {
            return "NodeJS";
        }
        return "unknown";
    }

    /* renamed from: c */
    private static void m42835c(C6747i c6747i) {
        AppMethodBeat.m2504i(73185);
        if (c6747i instanceof C17090c) {
            C7060h.pYm.mo8378a(434, 5, 1, false);
            C4990ab.m7416i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandJ2V8BasedJsEngine");
        } else if (c6747i instanceof C42451v) {
            C7060h.pYm.mo8378a(434, 6, 1, false);
            C4990ab.m7416i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandNodeJSBasedJsEngine");
        }
        C7060h.pYm.mo8378a(434, 0, 1, false);
        AppMethodBeat.m2505o(73185);
    }
}
