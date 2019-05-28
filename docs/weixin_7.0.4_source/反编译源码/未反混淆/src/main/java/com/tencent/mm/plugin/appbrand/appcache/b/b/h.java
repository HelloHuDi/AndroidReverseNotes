package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.appcache.b.e.g;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h extends a<Boolean, cxx> {
    public final /* synthetic */ Object b(String str, String str2, Object obj) {
        boolean z;
        int i;
        AppMethodBeat.i(129476);
        cxx cxx = (cxx) obj;
        com.tencent.mm.plugin.appbrand.appcache.b.e.h hVar = (com.tencent.mm.plugin.appbrand.appcache.b.e.h) f.E(com.tencent.mm.plugin.appbrand.appcache.b.e.h.class);
        int i2 = cxx.xtr;
        int i3 = cxx.xsZ.xsX;
        if (bo.isNullOrNil(str)) {
            z = false;
        } else {
            g gVar = new g();
            gVar.field_username = str;
            boolean b = hVar.b((c) gVar, new String[0]);
            gVar.field_appVersion = i2;
            gVar.field_reportId = i3;
            z = b ? hVar.c(gVar, new String[0]) : hVar.b((c) gVar);
        }
        ab.i("MicroMsg.AppBrand.Predownload.CmdUpdateVersion", "call, username %s, version %d, reportId %d, update %b", str, Integer.valueOf(cxx.xtr), Integer.valueOf(cxx.xsZ.xsX), Boolean.valueOf(z));
        a aVar = a.gWl;
        i2 = cxx.xsZ.xsX;
        if (z) {
            i = 155;
        } else {
            i = 156;
        }
        a.z((long) i2, (long) i);
        Boolean valueOf = Boolean.valueOf(z);
        AppMethodBeat.o(129476);
        return valueOf;
    }

    /* Access modifiers changed, original: final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ cxp bm(Object obj) {
        return ((cxx) obj).xsZ;
    }

    /* Access modifiers changed, original: final */
    public final String awu() {
        return "CmdUpdateVersion";
    }
}
