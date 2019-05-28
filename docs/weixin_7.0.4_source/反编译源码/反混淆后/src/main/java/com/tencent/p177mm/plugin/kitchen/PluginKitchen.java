package com.tencent.p177mm.plugin.kitchen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.plugin.kitchen.p733a.C6956a;
import com.tencent.p177mm.plugin.kitchen.p763b.C7506a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;

/* renamed from: com.tencent.mm.plugin.kitchen.PluginKitchen */
public class PluginKitchen extends C7597f implements C34401a {
    public void installed() {
        AppMethodBeat.m2504i(114436);
        alias(C34401a.class);
        AppMethodBeat.m2505o(114436);
    }

    public void dependency() {
        AppMethodBeat.m2504i(114437);
        dependsOn(C6983p.class);
        AppMethodBeat.m2505o(114437);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(114438);
        C1720g.m3542a(C6956a.class, new C7506a());
        AppMethodBeat.m2505o(114438);
    }

    public String toString() {
        return "plugin-kitchen";
    }
}
