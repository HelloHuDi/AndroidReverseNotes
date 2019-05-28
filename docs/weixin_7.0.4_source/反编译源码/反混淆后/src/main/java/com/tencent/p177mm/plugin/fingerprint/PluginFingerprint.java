package com.tencent.p177mm.plugin.fingerprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.plugin.fingerprint.p972a.C11925a;

/* renamed from: com.tencent.mm.plugin.fingerprint.PluginFingerprint */
public class PluginFingerprint extends C7597f implements C11925a {
    public String name() {
        return "plugin-fingerprint";
    }

    public void installed() {
        AppMethodBeat.m2504i(3227);
        alias(PluginFingerprint.class);
        AppMethodBeat.m2505o(3227);
    }

    public void dependency() {
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(3228);
        c1681g.mo5181SG();
        AppMethodBeat.m2505o(3228);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(3229);
        c1681g.mo5181SG();
        AppMethodBeat.m2505o(3229);
    }
}
