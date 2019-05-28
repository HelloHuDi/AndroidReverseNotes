package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;

@SuppressLint({"DefaultLocale"})
public class aq extends a {
    public static String aq(String str, int i) {
        AppMethodBeat.i(59510);
        String str2 = ap.avY() + String.format("_%d_%d.wxapkg", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i)});
        AppMethodBeat.o(59510);
        return str2;
    }

    static String xz(String str) {
        AppMethodBeat.i(59511);
        String str2 = ap.avY() + String.format("_%s.wxapkg", new Object[]{str});
        AppMethodBeat.o(59511);
        return str2;
    }

    aq(String str, int i, int i2, String str2) {
        this(String.format("WxaPkg_%s_%d", new Object[]{str, Integer.valueOf(i2)}), aq(str, i2), str2, str, i2, i);
        AppMethodBeat.i(59512);
        AppMethodBeat.o(59512);
    }

    private aq(String str, String str2, String str3, String str4, int i, int i2) {
        super(str, str2, str3, str4, i, i2);
    }
}
