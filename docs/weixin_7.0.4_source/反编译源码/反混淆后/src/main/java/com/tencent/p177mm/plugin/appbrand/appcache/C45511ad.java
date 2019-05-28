package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.ad */
public final class C45511ad extends C7563j<C42345ac> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C42345ac.gSs, "PkgUsageLRURecord")};
    final C4927e bSd;

    public C45511ad(C4927e c4927e) {
        super(c4927e, C42345ac.gSs, "PkgUsageLRURecord", C42345ac.diI);
        this.bSd = c4927e;
    }

    static {
        AppMethodBeat.m2504i(129411);
        AppMethodBeat.m2505o(129411);
    }

    /* renamed from: am */
    public final void mo73320am(String str, int i) {
        AppMethodBeat.m2504i(129410);
        C4925c c42345ac = new C42345ac();
        c42345ac.field_appId = str;
        c42345ac.field_type = i;
        super.mo16760a(c42345ac, C42345ac.gSr);
        AppMethodBeat.m2505o(129410);
    }
}
