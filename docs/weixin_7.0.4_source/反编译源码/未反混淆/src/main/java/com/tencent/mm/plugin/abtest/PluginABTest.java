package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;

public class PluginABTest extends f implements a {
    public void execute(g gVar) {
        AppMethodBeat.i(118194);
        if (gVar.SG()) {
            pin(b.aoM());
            pin(c.aoN());
        }
        AppMethodBeat.o(118194);
    }
}
