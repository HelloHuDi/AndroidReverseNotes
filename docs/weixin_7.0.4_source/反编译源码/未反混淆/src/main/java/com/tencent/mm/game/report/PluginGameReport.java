package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.a.a;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.game.report.api.c;
import com.tencent.mm.game.report.api.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;

public class PluginGameReport extends f implements e {
    public void configure(g gVar) {
    }

    public void execute(g gVar) {
        AppMethodBeat.i(59584);
        if (gVar.SG() || gVar.lQ(":tools")) {
            c.eBG = new b();
            b.eBF = new a();
            com.tencent.mm.kernel.g.a(com.tencent.mm.game.report.a.b.class, new a());
        }
        AppMethodBeat.o(59584);
    }
}
