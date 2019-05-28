package com.tencent.mm.plugin.wxpaysdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.wxpaysdk.a.a;

public class PluginWxPaySdk extends f implements a {
    public String name() {
        return "plugin-wxpaysdk";
    }

    public void installed() {
        AppMethodBeat.i(56663);
        alias(PluginWxPaySdk.class);
        AppMethodBeat.o(56663);
    }

    public void dependency() {
    }

    public void configure(g gVar) {
        AppMethodBeat.i(56664);
        gVar.SG();
        AppMethodBeat.o(56664);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(56665);
        gVar.SG();
        AppMethodBeat.o(56665);
    }
}
