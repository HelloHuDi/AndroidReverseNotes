package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az.C2057a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C10065a;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.bc */
class C26746bc extends C10065a {
    final C2057a gTR;
    final int gVu;

    public C26746bc(String str, String str2, int i, int i2, C2057a c2057a) {
        String format = String.format("WxaPkgZstd_%s_%d", new Object[]{str2, Integer.valueOf(i)});
        String str3 = C10072ap.avY() + String.format("_%d_%d.wxapkg.zstd", new Object[]{Integer.valueOf(str2.hashCode()), Integer.valueOf(i)});
        super(format, str3, str, str2, i, i2);
        AppMethodBeat.m2504i(59548);
        this.gVu = i;
        this.gTR = c2057a;
        AppMethodBeat.m2505o(59548);
    }

    public final String aws() {
        AppMethodBeat.m2504i(59549);
        String aq = C2050aq.m4207aq(this.appId, this.gVu);
        AppMethodBeat.m2505o(59549);
        return aq;
    }
}
