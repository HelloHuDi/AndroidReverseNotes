package com.tencent.p177mm.plugin.card;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.plugin.card.compat.p1477a.C33763b;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p1243c.C20129a;
import com.tencent.p177mm.plugin.card.p1243c.C33762b;
import com.tencent.p177mm.plugin.card.p1542a.C38726a;
import com.tencent.p177mm.plugin.comm.p1247a.C27697a;

/* renamed from: com.tencent.mm.plugin.card.PluginCard */
public class PluginCard extends C7597f implements C38726a {
    public void installed() {
        AppMethodBeat.m2504i(87613);
        super.installed();
        alias(C38726a.class);
        AppMethodBeat.m2505o(87613);
    }

    public C42852am getCore() {
        AppMethodBeat.m2504i(87614);
        C42852am c42852am = (C42852am) C7485q.m12925Y(C42852am.class);
        AppMethodBeat.m2505o(87614);
        return c42852am;
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(87615);
        if (c1681g.mo5181SG()) {
            C1720g.m3543a(C33762b.class, new C6625e(new C20129a()));
        }
        AppMethodBeat.m2505o(87615);
    }

    public void dependency() {
        AppMethodBeat.m2504i(87616);
        dependsOn(C27697a.class);
        dependsOn(C33763b.class);
        AppMethodBeat.m2505o(87616);
    }

    public String name() {
        return "plugin-card";
    }
}
