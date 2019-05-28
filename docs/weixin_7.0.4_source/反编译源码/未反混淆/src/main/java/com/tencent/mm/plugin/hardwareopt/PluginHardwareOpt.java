package com.tencent.mm.plugin.hardwareopt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.hardwareopt.a.a.a;
import com.tencent.mm.plugin.hardwareopt.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginHardwareOpt extends f implements c, b {
    public void installed() {
        AppMethodBeat.i(59264);
        alias(b.class);
        AppMethodBeat.o(59264);
    }

    public void dependency() {
        AppMethodBeat.i(59265);
        dependsOn(p.class);
        AppMethodBeat.o(59265);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(59266);
        if (gVar.SG()) {
            ab.v("MicroMsg.PluginHardwareOpt", "hy: on config");
            com.tencent.mm.kernel.g.a(a.class, new com.tencent.mm.plugin.hardwareopt.a.a());
            AppMethodBeat.o(59266);
            return;
        }
        AppMethodBeat.o(59266);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(59267);
        if (gVar.SG()) {
            ab.i("MicroMsg.PluginHardwareOpt", "hy: on execute. ");
        }
        AppMethodBeat.o(59267);
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(59268);
        ab.v("MicroMsg.PluginHardwareOpt", "hy: on onAccountInitialized");
        ((a) com.tencent.mm.kernel.g.K(a.class)).hX(false);
        AppMethodBeat.o(59268);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(59269);
        ab.v("MicroMsg.PluginHardwareOpt", "hy: on onAccountRelease");
        AppMethodBeat.o(59269);
    }
}
