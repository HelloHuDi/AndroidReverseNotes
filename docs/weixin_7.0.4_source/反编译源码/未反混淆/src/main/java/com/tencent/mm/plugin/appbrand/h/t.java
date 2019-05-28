package com.tencent.mm.plugin.appbrand.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class t {
    private static boolean ifd = false;

    public static i oU(int i) {
        AppMethodBeat.i(73183);
        i d = d(i, null, null);
        AppMethodBeat.o(73183);
        return d;
    }

    public static i d(int i, String str, byte[] bArr) {
        i vVar;
        AppMethodBeat.i(73184);
        if (y.oV(i)) {
            vVar = new v(str, bArr);
        } else {
            vVar = new c(str, bArr);
        }
        c(vVar);
        AppMethodBeat.o(73184);
        return vVar;
    }

    public static String b(i iVar) {
        if (iVar instanceof w) {
            return "WebView-Package";
        }
        if (iVar instanceof u) {
            return "XWEB-Package";
        }
        if (iVar instanceof c) {
            return "J2V8-Package";
        }
        if (iVar instanceof v) {
            return "NodeJS";
        }
        return "unknown";
    }

    private static void c(i iVar) {
        AppMethodBeat.i(73185);
        if (iVar instanceof c) {
            h.pYm.a(434, 5, 1, false);
            ab.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandJ2V8BasedJsEngine");
        } else if (iVar instanceof v) {
            h.pYm.a(434, 6, 1, false);
            ab.i("MicroMsg.AppBrandJsRuntimeFactory", "Using AppBrandNodeJSBasedJsEngine");
        }
        h.pYm.a(434, 0, 1, false);
        AppMethodBeat.o(73185);
    }
}
