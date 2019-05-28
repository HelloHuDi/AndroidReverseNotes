package com.tencent.mm.plugin.bbom;

import com.google.firebase.analytics.FirebaseAnalytics.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.c;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fts.a.n;

public final class f extends q implements b {
    public f() {
        super(c.akt(a.SEARCH));
        AppMethodBeat.i(18254);
        AppMethodBeat.o(18254);
    }

    public final void parallelsDependency() {
        AppMethodBeat.i(18255);
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).aJ(g.M(n.class));
        AppMethodBeat.o(18255);
    }
}
