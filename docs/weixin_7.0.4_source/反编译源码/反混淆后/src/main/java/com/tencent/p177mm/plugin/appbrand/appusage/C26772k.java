package com.tencent.p177mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.k */
public final class C26772k extends C7563j<C26768b> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C26768b.fjX, "AppBrandAppLaunchUsernameDuplicateRecord")};
    public final C4927e gTC;

    static {
        AppMethodBeat.m2504i(129556);
        AppMethodBeat.m2505o(129556);
    }

    public C26772k(C4927e c4927e) {
        super(c4927e, C26768b.fjX, "AppBrandAppLaunchUsernameDuplicateRecord", C26768b.diI);
        this.gTC = c4927e;
    }

    /* renamed from: x */
    public final boolean mo44544x(String str, long j) {
        AppMethodBeat.m2504i(129555);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129555);
            return false;
        }
        C26768b c26768b = new C26768b();
        c26768b.field_username = str;
        boolean b = mo10102b((C4925c) c26768b, new String[0]);
        c26768b.field_updateTime = j;
        boolean c;
        if (b) {
            c = mo10103c(c26768b, new String[0]);
            AppMethodBeat.m2505o(129555);
            return c;
        }
        c = mo10101b((C4925c) c26768b);
        AppMethodBeat.m2505o(129555);
        return c;
    }
}
