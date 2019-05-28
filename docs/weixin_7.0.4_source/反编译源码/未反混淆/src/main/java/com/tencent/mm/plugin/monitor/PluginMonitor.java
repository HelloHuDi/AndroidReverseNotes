package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.monitor.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginMonitor extends f implements a {
    public void dependency() {
    }

    public void installed() {
        AppMethodBeat.i(84515);
        super.installed();
        alias(a.class);
        AppMethodBeat.o(84515);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(84516);
        if (gVar.SG()) {
            ab.i("MicroMsg.PluginMonitor", "PluginMonitor execute PluginMonitor new SubCoreBaseMonitor");
            pin(new q(b.class));
        }
        AppMethodBeat.o(84516);
    }

    public String name() {
        return "plugin-monitor";
    }
}
