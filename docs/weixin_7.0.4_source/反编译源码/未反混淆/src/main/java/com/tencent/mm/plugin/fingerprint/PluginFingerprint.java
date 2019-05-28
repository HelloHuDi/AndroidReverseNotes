package com.tencent.mm.plugin.fingerprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.fingerprint.a.a;

public class PluginFingerprint extends f implements a {
    public String name() {
        return "plugin-fingerprint";
    }

    public void installed() {
        AppMethodBeat.i(3227);
        alias(PluginFingerprint.class);
        AppMethodBeat.o(3227);
    }

    public void dependency() {
    }

    public void configure(g gVar) {
        AppMethodBeat.i(3228);
        gVar.SG();
        AppMethodBeat.o(3228);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(3229);
        gVar.SG();
        AppMethodBeat.o(3229);
    }
}
