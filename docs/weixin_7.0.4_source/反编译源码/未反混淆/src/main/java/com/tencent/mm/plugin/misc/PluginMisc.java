package com.tencent.mm.plugin.misc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.misc.b.b;

public class PluginMisc extends f implements a {
    public void installed() {
        AppMethodBeat.i(50501);
        alias(a.class);
        AppMethodBeat.o(50501);
    }

    public void dependency() {
        AppMethodBeat.i(50502);
        dependsOn(p.class);
        AppMethodBeat.o(50502);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(50503);
        com.tencent.mm.kernel.g.a(a.class, new b());
        pin(com.tencent.mm.plugin.misc.b.a.bOM());
        AppMethodBeat.o(50503);
    }

    public String toString() {
        return "plugin-misc";
    }
}
