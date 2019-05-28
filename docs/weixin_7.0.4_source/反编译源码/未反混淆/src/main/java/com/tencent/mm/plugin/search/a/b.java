package com.tencent.mm.plugin.search.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.search.b.a.a.a;
import java.util.HashMap;

public final class b implements at {
    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(24404);
        ((n) g.M(n.class)).unregisterItemClickHandler(3);
        ((n) g.M(n.class)).unregisterItemClickHandler(6);
        AppMethodBeat.o(24404);
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(24403);
        ((n) g.M(n.class)).registerItemClickHandler(3, new a());
        ((n) g.M(n.class)).registerItemClickHandler(6, new com.tencent.mm.plugin.search.b.a.a.b());
        AppMethodBeat.o(24403);
    }
}
