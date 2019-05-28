package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.Locale;

public final class bb extends a {
    private static String b(String str, String str2, int i, int i2) {
        AppMethodBeat.i(59546);
        String format = String.format(Locale.US, "WxaPage_%s_%d_%d_%d", new Object[]{str2, Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(str.hashCode())});
        AppMethodBeat.o(59546);
        return format;
    }

    bb(String str, String str2, int i, int i2) {
        super(b(str, str2, i, i2), aq.xz(b(str, str2, i, i2)), str, str2, i, i2);
        AppMethodBeat.i(59547);
        AppMethodBeat.o(59547);
    }
}
