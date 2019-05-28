package com.tencent.p177mm.plugin.favorite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p238a.p240b.C1654a;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p842bp.C9204c;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;

/* renamed from: com.tencent.mm.plugin.favorite.a */
public final class C45940a extends C7485q implements C1655b {
    public C45940a() {
        super(C9204c.akt("favorite"));
        AppMethodBeat.m2504i(20496);
        AppMethodBeat.m2505o(20496);
    }

    public final void parallelsDependency() {
        AppMethodBeat.m2504i(20497);
        C1654a.m3349a(this, C1671c.class).mo5129aJ(C1720g.m3530M(C12029n.class));
        C1654a.m3349a(this, C1671c.class).mo5129aJ(C1720g.m3530M(C7604ae.class));
        AppMethodBeat.m2505o(20497);
    }
}
