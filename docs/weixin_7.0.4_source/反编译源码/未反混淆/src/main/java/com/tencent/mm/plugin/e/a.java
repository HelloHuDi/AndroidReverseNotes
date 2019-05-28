package com.tencent.mm.plugin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;

public final class a extends com.tencent.mm.kernel.a.c.a {
    public final void execute(g gVar) {
        AppMethodBeat.i(18521);
        if (!com.tencent.mm.kernel.a.QT()) {
            com.tencent.mm.kernel.g.RN().eIT = true;
            com.tencent.mm.kernel.g.RN().initialize();
            com.tencent.mm.kernel.g.RN().eIT = false;
        }
        AppMethodBeat.o(18521);
    }
}
