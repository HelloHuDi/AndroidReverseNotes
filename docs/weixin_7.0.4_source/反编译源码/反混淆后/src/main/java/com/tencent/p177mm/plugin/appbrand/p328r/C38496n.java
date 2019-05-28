package com.tencent.p177mm.plugin.appbrand.p328r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;

/* renamed from: com.tencent.mm.plugin.appbrand.r.n */
public final class C38496n {
    /* renamed from: bE */
    public static String m65148bE(Object obj) {
        AppMethodBeat.m2504i(93778);
        String str = "Token@" + (obj != null ? Integer.valueOf(obj.hashCode()) : BuildConfig.COMMAND);
        AppMethodBeat.m2505o(93778);
        return str;
    }

    /* renamed from: gv */
    public static String m65149gv(long j) {
        AppMethodBeat.m2504i(93779);
        String concat = "Token@".concat(String.valueOf(j));
        AppMethodBeat.m2505o(93779);
        return concat;
    }
}
