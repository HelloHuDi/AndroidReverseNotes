package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.r;
import com.tencent.mm.insane_statistic.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;

public class PluginInsaneStatistic extends f implements a {
    public void execute(g gVar) {
        AppMethodBeat.i(16183);
        if (gVar.SG()) {
            r.fGF = new b();
            com.tencent.mm.modelstat.r.fUq = new a();
        }
        AppMethodBeat.o(16183);
    }
}
