package com.tencent.mm.plugin.card;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.c.b;
import com.tencent.mm.plugin.card.model.am;

public class PluginCard extends f implements a {
    public void installed() {
        AppMethodBeat.i(87613);
        super.installed();
        alias(a.class);
        AppMethodBeat.o(87613);
    }

    public am getCore() {
        AppMethodBeat.i(87614);
        am amVar = (am) q.Y(am.class);
        AppMethodBeat.o(87614);
        return amVar;
    }

    public void execute(g gVar) {
        AppMethodBeat.i(87615);
        if (gVar.SG()) {
            com.tencent.mm.kernel.g.a(b.class, new e(new com.tencent.mm.plugin.card.c.a()));
        }
        AppMethodBeat.o(87615);
    }

    public void dependency() {
        AppMethodBeat.i(87616);
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
        dependsOn(com.tencent.mm.plugin.card.compat.a.b.class);
        AppMethodBeat.o(87616);
    }

    public String name() {
        return "plugin-card";
    }
}
