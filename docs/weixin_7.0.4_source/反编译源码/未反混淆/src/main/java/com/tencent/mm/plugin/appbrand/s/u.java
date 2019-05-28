package com.tencent.mm.plugin.appbrand.s;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;

public final class u {
    public static void a(i iVar, com.tencent.mm.plugin.appbrand.h.i iVar2) {
        AppMethodBeat.i(133596);
        ab.i("MicroMsg.SourceMapUtil", "hy: injecting sourcemap.js");
        if (iVar == null) {
            ab.w("MicroMsg.SourceMapUtil", "hy: not valid runtime");
            AppMethodBeat.o(133596);
        } else if (a.np(iVar.ye().hhd.gVt)) {
            ab.i("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
            AppMethodBeat.o(133596);
        } else {
            n.a(iVar2, WxaCommLibRuntimeReader.xu("WASourceMap.js"), new n.a() {
                public final void onSuccess(String str) {
                    AppMethodBeat.i(133594);
                    ab.i("MicroMsg.SourceMapUtil", "hy: Inject '%s' Script Success: %s", "WASourceMap.js", str);
                    AppMethodBeat.o(133594);
                }

                public final void lo(String str) {
                    AppMethodBeat.i(133595);
                    ab.e("MicroMsg.SourceMapUtil", "hy: Inject '%s' Script Failed: %s", "WASourceMap.js", str);
                    AppMethodBeat.o(133595);
                }
            });
            iVar2.evaluateJavascript(getSysInfo(), null);
            AppMethodBeat.o(133596);
        }
    }

    public static String a(i iVar, String str, String str2) {
        AppMethodBeat.i(133597);
        ab.i("MicroMsg.SourceMapUtil", "hy: getting sourcemap %s, %s", str, str2);
        String str3;
        if (iVar == null || str == null || str.length() == 0) {
            ab.w("MicroMsg.SourceMapUtil", "runtime or jsRuntime or filePath is null.");
            str3 = "";
            AppMethodBeat.o(133597);
            return str3;
        } else if (a.np(iVar.ye().hhd.gVt)) {
            ab.i("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
            str3 = "";
            AppMethodBeat.o(133597);
            return str3;
        } else {
            str3 = aw.a(iVar, str + ".map");
            if (str3 == null || str3.length() == 0) {
                ab.i("MicroMsg.SourceMapUtil", "sourceMap of the script(%s) is null or nil.", str);
                str3 = "";
                AppMethodBeat.o(133597);
                return str3;
            }
            str3 = String.format("typeof __wxSourceMap !== 'undefined' && (__wxSourceMap['%s'] = %s)", new Object[]{str2 + str, str3});
            AppMethodBeat.o(133597);
            return str3;
        }
    }

    @SuppressLint({"DefaultLocal"})
    public static String getSysInfo() {
        AppMethodBeat.i(133598);
        String format = String.format("typeof __wxSourceMap !== 'undefined' && (__wxSourceMap.__system = 'Android %s')", new Object[]{VERSION.RELEASE});
        AppMethodBeat.o(133598);
        return format;
    }
}
