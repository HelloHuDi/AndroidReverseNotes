package com.tencent.mm.plugin.kitchen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.kitchen.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.p;

public class PluginKitchen extends f implements a {
    public void installed() {
        AppMethodBeat.i(114436);
        alias(a.class);
        AppMethodBeat.o(114436);
    }

    public void dependency() {
        AppMethodBeat.i(114437);
        dependsOn(p.class);
        AppMethodBeat.o(114437);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(114438);
        com.tencent.mm.kernel.g.a(a.class, new com.tencent.mm.plugin.kitchen.b.a());
        AppMethodBeat.o(114438);
    }

    public String toString() {
        return "plugin-kitchen";
    }
}
