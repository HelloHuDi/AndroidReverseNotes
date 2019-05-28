package com.tencent.p177mm.plugin.misc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.misc.p764b.C34535a;
import com.tencent.p177mm.plugin.misc.p764b.C39374b;
import com.tencent.p177mm.plugin.misc.p994a.C12534a;

/* renamed from: com.tencent.mm.plugin.misc.PluginMisc */
public class PluginMisc extends C7597f implements C46073a {
    public void installed() {
        AppMethodBeat.m2504i(50501);
        alias(C46073a.class);
        AppMethodBeat.m2505o(50501);
    }

    public void dependency() {
        AppMethodBeat.m2504i(50502);
        dependsOn(C6983p.class);
        AppMethodBeat.m2505o(50502);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(50503);
        C1720g.m3542a(C12534a.class, new C39374b());
        pin(C34535a.bOM());
        AppMethodBeat.m2505o(50503);
    }

    public String toString() {
        return "plugin-misc";
    }
}
