package com.tencent.mm.plugin.card.compat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.plugin.card.compat.a.a;
import com.tencent.mm.plugin.card.compat.a.b;

public final class PluginCardCompat extends f implements b {
    public final void installed() {
        AppMethodBeat.i(18648);
        super.installed();
        alias(b.class);
        AppMethodBeat.o(18648);
    }

    public final void execute(g gVar) {
        AppMethodBeat.i(18649);
        if (gVar.SG()) {
            com.tencent.mm.kernel.g.a(a.class, new e(new a()));
        }
        AppMethodBeat.o(18649);
    }
}
