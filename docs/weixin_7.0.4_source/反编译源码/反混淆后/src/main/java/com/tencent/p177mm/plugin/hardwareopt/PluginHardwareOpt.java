package com.tencent.p177mm.plugin.hardwareopt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.plugin.hardwareopt.p981a.C21049b;
import com.tencent.p177mm.plugin.hardwareopt.p981a.C31371a;
import com.tencent.p177mm.plugin.hardwareopt.p981a.p1404a.C28284a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt */
public class PluginHardwareOpt extends C7597f implements C9562c, C21049b {
    public void installed() {
        AppMethodBeat.m2504i(59264);
        alias(C21049b.class);
        AppMethodBeat.m2505o(59264);
    }

    public void dependency() {
        AppMethodBeat.m2504i(59265);
        dependsOn(C6983p.class);
        AppMethodBeat.m2505o(59265);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(59266);
        if (c1681g.mo5181SG()) {
            C4990ab.m7418v("MicroMsg.PluginHardwareOpt", "hy: on config");
            C1720g.m3542a(C28284a.class, new C31371a());
            AppMethodBeat.m2505o(59266);
            return;
        }
        AppMethodBeat.m2505o(59266);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(59267);
        if (c1681g.mo5181SG()) {
            C4990ab.m7416i("MicroMsg.PluginHardwareOpt", "hy: on execute. ");
        }
        AppMethodBeat.m2505o(59267);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(59268);
        C4990ab.m7418v("MicroMsg.PluginHardwareOpt", "hy: on onAccountInitialized");
        ((C28284a) C1720g.m3528K(C28284a.class)).mo46215hX(false);
        AppMethodBeat.m2505o(59268);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(59269);
        C4990ab.m7418v("MicroMsg.PluginHardwareOpt", "hy: on onAccountRelease");
        AppMethodBeat.m2505o(59269);
    }
}
