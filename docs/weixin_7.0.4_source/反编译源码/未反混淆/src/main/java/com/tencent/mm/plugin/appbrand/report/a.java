package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.debugger.n;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.plugin.appbrand.h.u;
import com.tencent.mm.plugin.appbrand.h.v;
import com.tencent.mm.plugin.appbrand.h.w;
import com.tencent.mm.sdk.platformtools.f;

public enum a {
    X5,
    MMV8,
    WebViewBased,
    NativeScript,
    NodeJS,
    J2V8,
    Invalid;

    static {
        AppMethodBeat.o(132542);
    }

    public static a d(i iVar) {
        AppMethodBeat.i(132540);
        a aVar;
        if (iVar instanceof c) {
            aVar = J2V8;
            AppMethodBeat.o(132540);
            return aVar;
        } else if (iVar instanceof w) {
            aVar = WebViewBased;
            AppMethodBeat.o(132540);
            return aVar;
        } else if (iVar instanceof v) {
            aVar = NodeJS;
            AppMethodBeat.o(132540);
            return aVar;
        } else {
            if (iVar instanceof u) {
                switch (com.tencent.xweb.i.dTU()) {
                    case RT_TYPE_X5:
                        aVar = X5;
                        AppMethodBeat.o(132540);
                        return aVar;
                    case RT_TYPE_SYS:
                        aVar = WebViewBased;
                        AppMethodBeat.o(132540);
                        return aVar;
                    case RT_TYPE_J2V8:
                        aVar = MMV8;
                        AppMethodBeat.o(132540);
                        return aVar;
                    case RT_TYPE_MMV8:
                        aVar = MMV8;
                        AppMethodBeat.o(132540);
                        return aVar;
                    case RT_TYPE_XWALK:
                        aVar = MMV8;
                        AppMethodBeat.o(132540);
                        return aVar;
                    case RT_TYPE_WEB_X5:
                        aVar = X5;
                        AppMethodBeat.o(132540);
                        return aVar;
                    case RT_TYPE_NATIVE_SCRIPT:
                        aVar = NativeScript;
                        AppMethodBeat.o(132540);
                        return aVar;
                }
            }
            if (iVar instanceof n) {
                aVar = Invalid;
                AppMethodBeat.o(132540);
                return aVar;
            } else if (f.DEBUG) {
                String str = "Unrecognized JsRuntime %s";
                Object[] objArr = new Object[1];
                objArr[0] = iVar == null ? BuildConfig.COMMAND : iVar.getClass().getSimpleName();
                IllegalStateException illegalStateException = new IllegalStateException(String.format(str, objArr));
                AppMethodBeat.o(132540);
                throw illegalStateException;
            } else {
                aVar = Invalid;
                AppMethodBeat.o(132540);
                return aVar;
            }
        }
    }

    public static String e(i iVar) {
        AppMethodBeat.i(132541);
        String name = d(iVar).name();
        if (iVar instanceof n) {
            name = name + "(remote_debug)";
        }
        AppMethodBeat.o(132541);
        return name;
    }
}
