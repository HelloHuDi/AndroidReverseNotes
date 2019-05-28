package com.tencent.mm.plugin.notification.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.c;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fts.a.n;

public final class a extends q implements b {
    public a() {
        super(c.akt("notification"));
        AppMethodBeat.i(23118);
        AppMethodBeat.o(23118);
    }

    public final void parallelsDependency() {
        AppMethodBeat.i(23119);
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).aJ(g.M(n.class));
        AppMethodBeat.o(23119);
    }
}
