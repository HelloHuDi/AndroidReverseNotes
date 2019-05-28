package com.tencent.p177mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C37860c;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.game.report.api.C9542e;
import com.tencent.p177mm.game.report.p850a.C26317a;
import com.tencent.p177mm.game.report.p850a.C9541b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;

/* renamed from: com.tencent.mm.game.report.PluginGameReport */
public class PluginGameReport extends C7597f implements C9542e {
    public void configure(C1681g c1681g) {
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(59584);
        if (c1681g.mo5181SG() || c1681g.mo5183lQ(":tools")) {
            C37860c.eBG = new C45407b();
            C45405b.eBF = new C37858a();
            C1720g.m3542a(C9541b.class, new C26317a());
        }
        AppMethodBeat.m2505o(59584);
    }
}
