package com.tencent.p177mm.plugin.card.compat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.plugin.card.compat.p1477a.C33763b;
import com.tencent.p177mm.plugin.card.compat.p1477a.C38733a;

/* renamed from: com.tencent.mm.plugin.card.compat.PluginCardCompat */
public final class PluginCardCompat extends C7597f implements C33763b {
    public final void installed() {
        AppMethodBeat.m2504i(18648);
        super.installed();
        alias(C33763b.class);
        AppMethodBeat.m2505o(18648);
    }

    public final void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(18649);
        if (c1681g.mo5181SG()) {
            C1720g.m3543a(C38733a.class, new C6625e(new C2755a()));
        }
        AppMethodBeat.m2505o(18649);
    }
}
