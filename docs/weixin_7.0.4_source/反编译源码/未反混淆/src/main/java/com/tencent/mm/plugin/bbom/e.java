package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.fts.a.n;

public final class e extends q implements b {
    public e() {
        super(a.class);
    }

    public final void parallelsDependency() {
        AppMethodBeat.i(18253);
        com.tencent.mm.kernel.a.b.a.a(this, c.class).aJ(g.M(n.class));
        AppMethodBeat.o(18253);
    }
}
