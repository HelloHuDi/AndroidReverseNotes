package com.tencent.p177mm.plugin.wxpayapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.plugin.p1617o.C43352a;
import com.tencent.p177mm.plugin.wxpayapi.p1666a.C46479a;
import com.tencent.p177mm.pluginsdk.wallet.C30158b;

/* renamed from: com.tencent.mm.plugin.wxpayapi.PluginWxPayApi */
public class PluginWxPayApi extends C7597f implements C46479a {
    public String name() {
        return "plugin-wxpayapi";
    }

    public void installed() {
        AppMethodBeat.m2504i(55859);
        alias(PluginWxPayApi.class);
        AppMethodBeat.m2505o(55859);
    }

    public void dependency() {
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(55860);
        c1681g.mo5181SG();
        AppMethodBeat.m2505o(55860);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(55861);
        if (c1681g.mo5181SG()) {
            C1720g.m3542a(C30158b.class, new C43352a());
        }
        AppMethodBeat.m2505o(55861);
    }
}
