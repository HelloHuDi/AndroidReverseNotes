package com.tencent.p177mm.plugin.wxpaysdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.plugin.wxpaysdk.p1625a.C44033a;

/* renamed from: com.tencent.mm.plugin.wxpaysdk.PluginWxPaySdk */
public class PluginWxPaySdk extends C7597f implements C44033a {
    public String name() {
        return "plugin-wxpaysdk";
    }

    public void installed() {
        AppMethodBeat.m2504i(56663);
        alias(PluginWxPaySdk.class);
        AppMethodBeat.m2505o(56663);
    }

    public void dependency() {
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(56664);
        c1681g.mo5181SG();
        AppMethodBeat.m2505o(56664);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(56665);
        c1681g.mo5181SG();
        AppMethodBeat.m2505o(56665);
    }
}
