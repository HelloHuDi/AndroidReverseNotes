package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import java.util.Locale;

final class al extends a {
    final int gTP;
    final int gTQ;
    final az.a gTR;

    static String t(String str, int i, int i2) {
        AppMethodBeat.i(59477);
        String format = String.format(Locale.US, "WxaPkgDiff_%s_%d_%d", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
        AppMethodBeat.o(59477);
        return format;
    }

    al(String str, int i, int i2, String str2, az.a aVar) {
        boolean z = false;
        String t = t(str, i, i2);
        String str3 = ap.avY() + String.format(Locale.US, "_%s_%d_%d.wxapkg.diff", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
        super(t, str3, str2, str, 0, i2);
        AppMethodBeat.i(59478);
        this.gTP = i;
        this.gTQ = i2;
        this.gTR = aVar;
        if (!"@LibraryAppId".equals(str)) {
            z = true;
        }
        this.gVz = z;
        AppMethodBeat.o(59478);
    }

    public final String avR() {
        AppMethodBeat.i(59479);
        String aq = aq.aq(this.appId, this.gTQ);
        AppMethodBeat.o(59479);
        return aq;
    }
}
