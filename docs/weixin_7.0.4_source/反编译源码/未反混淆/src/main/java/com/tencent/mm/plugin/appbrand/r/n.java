package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;

public final class n {
    public static String bE(Object obj) {
        AppMethodBeat.i(93778);
        String str = "Token@" + (obj != null ? Integer.valueOf(obj.hashCode()) : BuildConfig.COMMAND);
        AppMethodBeat.o(93778);
        return str;
    }

    public static String gv(long j) {
        AppMethodBeat.i(93779);
        String concat = "Token@".concat(String.valueOf(j));
        AppMethodBeat.o(93779);
        return concat;
    }
}
