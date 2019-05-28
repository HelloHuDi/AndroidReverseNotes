package com.tencent.p177mm.plugin.bbom;

import com.google.firebase.analytics.FirebaseAnalytics.C8740a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p238a.p240b.C1654a;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p842bp.C9204c;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;

/* renamed from: com.tencent.mm.plugin.bbom.f */
public final class C42782f extends C7485q implements C1655b {
    public C42782f() {
        super(C9204c.akt(C8740a.SEARCH));
        AppMethodBeat.m2504i(18254);
        AppMethodBeat.m2505o(18254);
    }

    public final void parallelsDependency() {
        AppMethodBeat.m2504i(18255);
        C1654a.m3349a(this, C1671c.class).mo5129aJ(C1720g.m3530M(C12029n.class));
        AppMethodBeat.m2505o(18255);
    }
}
