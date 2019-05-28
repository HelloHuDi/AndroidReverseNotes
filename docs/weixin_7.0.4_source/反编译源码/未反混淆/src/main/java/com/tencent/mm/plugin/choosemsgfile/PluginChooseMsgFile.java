package com.tencent.mm.plugin.choosemsgfile;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.choosemsgfile.a.a;

public class PluginChooseMsgFile extends f implements a {
    public void installed() {
        AppMethodBeat.i(54246);
        d.d("MicroMsg.PluginChooseMsgFile", "installed");
        alias(a.class);
        AppMethodBeat.o(54246);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(54247);
        d.d("MicroMsg.PluginChooseMsgFile", "execute");
        com.tencent.mm.kernel.g.a(com.tencent.mm.choosemsgfile.compat.a.class, new com.tencent.mm.plugin.choosemsgfile.b.a());
        AppMethodBeat.o(54247);
    }

    public void dependency() {
        AppMethodBeat.i(54248);
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
        AppMethodBeat.o(54248);
    }

    public String name() {
        return "plugin-choosemsgfile";
    }
}
