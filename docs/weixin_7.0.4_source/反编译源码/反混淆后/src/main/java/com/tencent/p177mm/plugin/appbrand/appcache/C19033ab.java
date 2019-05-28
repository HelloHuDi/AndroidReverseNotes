package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.ab */
public final class C19033ab extends C7563j<C24683aa> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C24683aa.gSs, "PkgUpdateStats")};

    public C19033ab(C4927e c4927e) {
        super(c4927e, C24683aa.gSs, "PkgUpdateStats", C24683aa.diI);
    }

    static {
        AppMethodBeat.m2504i(129408);
        AppMethodBeat.m2505o(129408);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ao */
    public final boolean mo34271ao(String str, int i) {
        AppMethodBeat.m2504i(129407);
        C4925c c24683aa = new C24683aa();
        c24683aa.field_key = str;
        c24683aa.field_version = i;
        boolean a = super.mo16760a(c24683aa, C24683aa.gSr);
        AppMethodBeat.m2505o(129407);
        return a;
    }
}
