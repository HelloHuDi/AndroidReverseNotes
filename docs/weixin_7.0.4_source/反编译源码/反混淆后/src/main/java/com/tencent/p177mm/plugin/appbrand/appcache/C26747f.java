package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.f */
public final class C26747f extends C7563j<C33096h> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C33096h.gSs, "CodeLibUsageLRURecord")};
    final C4927e bSd;

    public C26747f(C4927e c4927e) {
        super(c4927e, C33096h.gSs, "CodeLibUsageLRURecord", C33096h.diI);
        this.bSd = c4927e;
    }

    static {
        AppMethodBeat.m2504i(129326);
        AppMethodBeat.m2505o(129326);
    }

    /* renamed from: am */
    public final void mo44526am(String str, int i) {
        AppMethodBeat.m2504i(129325);
        C4925c c33096h = new C33096h();
        c33096h.field_appId = str;
        c33096h.field_version = i;
        super.mo16760a(c33096h, C33096h.gSr);
        AppMethodBeat.m2505o(129325);
    }
}
