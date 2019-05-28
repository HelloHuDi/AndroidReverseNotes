package com.tencent.p177mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p238a.p240b.C1654a;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p842bp.C9204c;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.record.p1016a.C21592a;

/* renamed from: com.tencent.mm.plugin.wenote.model.a */
public final class C23180a extends C7485q implements C1655b {
    public C23180a() {
        super(C9204c.akt("wenote"));
        AppMethodBeat.m2504i(26593);
        AppMethodBeat.m2505o(26593);
    }

    public final void parallelsDependency() {
        AppMethodBeat.m2504i(26594);
        C1654a.m3349a(this, C1671c.class).mo5129aJ(C1720g.m3530M(C7604ae.class));
        C1654a.m3349a(this, C1671c.class).mo5129aJ(C1720g.m3530M(C21592a.class));
        AppMethodBeat.m2505o(26594);
    }
}
