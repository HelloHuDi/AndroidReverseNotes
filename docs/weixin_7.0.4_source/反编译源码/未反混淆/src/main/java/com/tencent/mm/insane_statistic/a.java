package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.k;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.storage.bi;

public final class a implements com.tencent.mm.modelstat.r.a {
    public final void j(bi biVar) {
        AppMethodBeat.i(16174);
        if (biVar.bAA()) {
            b.fRa.a(biVar, k.k(biVar));
            AppMethodBeat.o(16174);
            return;
        }
        b.fRa.j(biVar);
        AppMethodBeat.o(16174);
    }
}
