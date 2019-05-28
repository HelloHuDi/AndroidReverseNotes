package com.tencent.p177mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.appbrand.debugger.C42413n;
import com.tencent.p177mm.plugin.appbrand.p297h.C10258u;
import com.tencent.p177mm.plugin.appbrand.p297h.C17090c;
import com.tencent.p177mm.plugin.appbrand.p297h.C42451v;
import com.tencent.p177mm.plugin.appbrand.p297h.C42452w;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.xweb.C41128i;

/* renamed from: com.tencent.mm.plugin.appbrand.report.a */
public enum C42669a {
    X5,
    MMV8,
    WebViewBased,
    NativeScript,
    NodeJS,
    J2V8,
    Invalid;

    static {
        AppMethodBeat.m2505o(132542);
    }

    /* renamed from: d */
    public static C42669a m75572d(C6747i c6747i) {
        AppMethodBeat.m2504i(132540);
        C42669a c42669a;
        if (c6747i instanceof C17090c) {
            c42669a = J2V8;
            AppMethodBeat.m2505o(132540);
            return c42669a;
        } else if (c6747i instanceof C42452w) {
            c42669a = WebViewBased;
            AppMethodBeat.m2505o(132540);
            return c42669a;
        } else if (c6747i instanceof C42451v) {
            c42669a = NodeJS;
            AppMethodBeat.m2505o(132540);
            return c42669a;
        } else {
            if (c6747i instanceof C10258u) {
                switch (C41128i.dTU()) {
                    case RT_TYPE_X5:
                        c42669a = X5;
                        AppMethodBeat.m2505o(132540);
                        return c42669a;
                    case RT_TYPE_SYS:
                        c42669a = WebViewBased;
                        AppMethodBeat.m2505o(132540);
                        return c42669a;
                    case RT_TYPE_J2V8:
                        c42669a = MMV8;
                        AppMethodBeat.m2505o(132540);
                        return c42669a;
                    case RT_TYPE_MMV8:
                        c42669a = MMV8;
                        AppMethodBeat.m2505o(132540);
                        return c42669a;
                    case RT_TYPE_XWALK:
                        c42669a = MMV8;
                        AppMethodBeat.m2505o(132540);
                        return c42669a;
                    case RT_TYPE_WEB_X5:
                        c42669a = X5;
                        AppMethodBeat.m2505o(132540);
                        return c42669a;
                    case RT_TYPE_NATIVE_SCRIPT:
                        c42669a = NativeScript;
                        AppMethodBeat.m2505o(132540);
                        return c42669a;
                }
            }
            if (c6747i instanceof C42413n) {
                c42669a = Invalid;
                AppMethodBeat.m2505o(132540);
                return c42669a;
            } else if (C5058f.DEBUG) {
                String str = "Unrecognized JsRuntime %s";
                Object[] objArr = new Object[1];
                objArr[0] = c6747i == null ? BuildConfig.COMMAND : c6747i.getClass().getSimpleName();
                IllegalStateException illegalStateException = new IllegalStateException(String.format(str, objArr));
                AppMethodBeat.m2505o(132540);
                throw illegalStateException;
            } else {
                c42669a = Invalid;
                AppMethodBeat.m2505o(132540);
                return c42669a;
            }
        }
    }

    /* renamed from: e */
    public static String m75573e(C6747i c6747i) {
        AppMethodBeat.m2504i(132541);
        String name = C42669a.m75572d(c6747i).name();
        if (c6747i instanceof C42413n) {
            name = name + "(remote_debug)";
        }
        AppMethodBeat.m2505o(132541);
        return name;
    }
}
