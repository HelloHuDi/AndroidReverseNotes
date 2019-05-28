package com.tencent.p177mm.plugin.map;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p842bp.C9204c;
import com.tencent.p177mm.plugin.location.model.C39287l;
import com.tencent.p177mm.plugin.map.p1615a.C43292a;

/* renamed from: com.tencent.mm.plugin.map.PluginMap */
public class PluginMap extends C7597f implements C43292a {
    public String name() {
        return "plugin-map";
    }

    public void installed() {
        AppMethodBeat.m2504i(113775);
        alias(C43292a.class);
        AppMethodBeat.m2505o(113775);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(113776);
        if (c1681g.mo5181SG()) {
            pin(new C7485q(C39287l.class));
        }
        AppMethodBeat.m2505o(113776);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(113777);
        if (c1681g.mo5181SG()) {
            C9204c.aks(C8741b.LOCATION);
        }
        AppMethodBeat.m2505o(113777);
    }
}
