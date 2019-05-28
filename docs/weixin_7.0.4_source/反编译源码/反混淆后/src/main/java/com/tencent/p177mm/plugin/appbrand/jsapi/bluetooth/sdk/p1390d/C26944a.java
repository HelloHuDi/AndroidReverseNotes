package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a */
public final class C26944a {
    public static C26943a hGh;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a$a */
    public interface C26943a {
        /* renamed from: d */
        void mo44678d(String str, String str2, Object... objArr);

        /* renamed from: e */
        void mo44679e(String str, String str2, Object... objArr);

        /* renamed from: i */
        void mo44680i(String str, String str2, Object... objArr);

        /* renamed from: w */
        void mo44681w(String str, String str2, Object... objArr);
    }

    /* renamed from: e */
    public static void m42896e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(94341);
        if (hGh != null) {
            String.format(str2, objArr);
            hGh.mo44679e(str, str2, objArr);
        }
        AppMethodBeat.m2505o(94341);
    }

    /* renamed from: w */
    public static void m42898w(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(94342);
        if (hGh != null) {
            String.format(str2, objArr);
            hGh.mo44681w(str, str2, objArr);
        }
        AppMethodBeat.m2505o(94342);
    }

    /* renamed from: i */
    public static void m42897i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(94343);
        if (hGh != null) {
            String.format(str2, objArr);
            hGh.mo44680i(str, str2, objArr);
        }
        AppMethodBeat.m2505o(94343);
    }

    /* renamed from: d */
    public static void m42895d(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(94344);
        if (hGh != null) {
            String.format(str2, objArr);
            hGh.mo44678d(str, str2, objArr);
        }
        AppMethodBeat.m2505o(94344);
    }
}
