package com.tencent.mm.plugin.wxpayapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.wxpayapi.a.a;
import com.tencent.mm.pluginsdk.wallet.b;

public class PluginWxPayApi extends f implements a {
    public String name() {
        return "plugin-wxpayapi";
    }

    public void installed() {
        AppMethodBeat.i(55859);
        alias(PluginWxPayApi.class);
        AppMethodBeat.o(55859);
    }

    public void dependency() {
    }

    public void configure(g gVar) {
        AppMethodBeat.i(55860);
        gVar.SG();
        AppMethodBeat.o(55860);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(55861);
        if (gVar.SG()) {
            com.tencent.mm.kernel.g.a(b.class, new com.tencent.mm.plugin.o.a());
        }
        AppMethodBeat.o(55861);
    }
}
