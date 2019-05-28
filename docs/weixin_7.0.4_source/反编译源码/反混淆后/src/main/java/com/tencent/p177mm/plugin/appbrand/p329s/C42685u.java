package com.tencent.p177mm.plugin.appbrand.p329s;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.plugin.appbrand.p329s.C42682n.C42683a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.s.u */
public final class C42685u {

    /* renamed from: com.tencent.mm.plugin.appbrand.s.u$1 */
    static class C426841 implements C42683a {
        C426841() {
        }

        public final void onSuccess(String str) {
            AppMethodBeat.m2504i(133594);
            C4990ab.m7417i("MicroMsg.SourceMapUtil", "hy: Inject '%s' Script Success: %s", "WASourceMap.js", str);
            AppMethodBeat.m2505o(133594);
        }

        /* renamed from: lo */
        public final void mo5987lo(String str) {
            AppMethodBeat.m2504i(133595);
            C4990ab.m7413e("MicroMsg.SourceMapUtil", "hy: Inject '%s' Script Failed: %s", "WASourceMap.js", str);
            AppMethodBeat.m2505o(133595);
        }
    }

    /* renamed from: a */
    public static void m75595a(C6750i c6750i, C6747i c6747i) {
        AppMethodBeat.m2504i(133596);
        C4990ab.m7416i("MicroMsg.SourceMapUtil", "hy: injecting sourcemap.js");
        if (c6750i == null) {
            C4990ab.m7420w("MicroMsg.SourceMapUtil", "hy: not valid runtime");
            AppMethodBeat.m2505o(133596);
        } else if (C33097a.m54090np(c6750i.mo15034ye().hhd.gVt)) {
            C4990ab.m7416i("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
            AppMethodBeat.m2505o(133596);
        } else {
            C42682n.m75589a(c6747i, WxaCommLibRuntimeReader.m42569xu("WASourceMap.js"), new C426841());
            c6747i.evaluateJavascript(C42685u.getSysInfo(), null);
            AppMethodBeat.m2505o(133596);
        }
    }

    /* renamed from: a */
    public static String m75594a(C6750i c6750i, String str, String str2) {
        AppMethodBeat.m2504i(133597);
        C4990ab.m7417i("MicroMsg.SourceMapUtil", "hy: getting sourcemap %s, %s", str, str2);
        String str3;
        if (c6750i == null || str == null || str.length() == 0) {
            C4990ab.m7420w("MicroMsg.SourceMapUtil", "runtime or jsRuntime or filePath is null.");
            str3 = "";
            AppMethodBeat.m2505o(133597);
            return str3;
        } else if (C33097a.m54090np(c6750i.mo15034ye().hhd.gVt)) {
            C4990ab.m7416i("MicroMsg.SourceMapUtil", "current running type is ReleaseType do not need to inject sourceMap.");
            str3 = "";
            AppMethodBeat.m2505o(133597);
            return str3;
        } else {
            str3 = C33082aw.m54068a(c6750i, str + ".map");
            if (str3 == null || str3.length() == 0) {
                C4990ab.m7417i("MicroMsg.SourceMapUtil", "sourceMap of the script(%s) is null or nil.", str);
                str3 = "";
                AppMethodBeat.m2505o(133597);
                return str3;
            }
            str3 = String.format("typeof __wxSourceMap !== 'undefined' && (__wxSourceMap['%s'] = %s)", new Object[]{str2 + str, str3});
            AppMethodBeat.m2505o(133597);
            return str3;
        }
    }

    @SuppressLint({"DefaultLocal"})
    public static String getSysInfo() {
        AppMethodBeat.m2504i(133598);
        String format = String.format("typeof __wxSourceMap !== 'undefined' && (__wxSourceMap.__system = 'Android %s')", new Object[]{VERSION.RELEASE});
        AppMethodBeat.m2505o(133598);
        return format;
    }
}
