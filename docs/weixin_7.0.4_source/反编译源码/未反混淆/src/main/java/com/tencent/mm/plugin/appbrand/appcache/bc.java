package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.a.a;

class bc extends a {
    final az.a gTR;
    final int gVu;

    public bc(String str, String str2, int i, int i2, az.a aVar) {
        String format = String.format("WxaPkgZstd_%s_%d", new Object[]{str2, Integer.valueOf(i)});
        String str3 = ap.avY() + String.format("_%d_%d.wxapkg.zstd", new Object[]{Integer.valueOf(str2.hashCode()), Integer.valueOf(i)});
        super(format, str3, str, str2, i, i2);
        AppMethodBeat.i(59548);
        this.gVu = i;
        this.gTR = aVar;
        AppMethodBeat.o(59548);
    }

    public final String aws() {
        AppMethodBeat.i(59549);
        String aq = aq.aq(this.appId, this.gVu);
        AppMethodBeat.o(59549);
        return aq;
    }
}
