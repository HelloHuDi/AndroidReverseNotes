package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C10088g;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C7600h;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.protocal.protobuf.cxp;
import com.tencent.p177mm.protocal.protobuf.cxx;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.b.h */
public final class C42352h extends C38108a<Boolean, cxx> {
    /* renamed from: b */
    public final /* synthetic */ Object mo21442b(String str, String str2, Object obj) {
        boolean z;
        int i;
        AppMethodBeat.m2504i(129476);
        cxx cxx = (cxx) obj;
        C7600h c7600h = (C7600h) C42340f.m74878E(C7600h.class);
        int i2 = cxx.xtr;
        int i3 = cxx.xsZ.xsX;
        if (C5046bo.isNullOrNil(str)) {
            z = false;
        } else {
            C10088g c10088g = new C10088g();
            c10088g.field_username = str;
            boolean b = c7600h.mo10102b((C4925c) c10088g, new String[0]);
            c10088g.field_appVersion = i2;
            c10088g.field_reportId = i3;
            z = b ? c7600h.mo10103c(c10088g, new String[0]) : c7600h.mo10101b((C4925c) c10088g);
        }
        C4990ab.m7417i("MicroMsg.AppBrand.Predownload.CmdUpdateVersion", "call, username %s, version %d, reportId %d, update %b", str, Integer.valueOf(cxx.xtr), Integer.valueOf(cxx.xsZ.xsX), Boolean.valueOf(z));
        C19050a c19050a = C19050a.gWl;
        i2 = cxx.xsZ.xsX;
        if (z) {
            i = 155;
        } else {
            i = 156;
        }
        C19050a.m29623z((long) i2, (long) i);
        Boolean valueOf = Boolean.valueOf(z);
        AppMethodBeat.m2505o(129476);
        return valueOf;
    }

    /* Access modifiers changed, original: final|bridge|synthetic */
    /* renamed from: bm */
    public final /* bridge */ /* synthetic */ cxp mo21443bm(Object obj) {
        return ((cxx) obj).xsZ;
    }

    /* Access modifiers changed, original: final */
    public final String awu() {
        return "CmdUpdateVersion";
    }
}
