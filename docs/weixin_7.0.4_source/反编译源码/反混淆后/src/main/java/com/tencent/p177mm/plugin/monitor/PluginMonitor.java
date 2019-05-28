package com.tencent.p177mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.plugin.monitor.p1491a.C34561a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.monitor.PluginMonitor */
public class PluginMonitor extends C7597f implements C34561a {
    public void dependency() {
    }

    public void installed() {
        AppMethodBeat.m2504i(84515);
        super.installed();
        alias(C34561a.class);
        AppMethodBeat.m2505o(84515);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(84516);
        if (c1681g.mo5181SG()) {
            C4990ab.m7416i("MicroMsg.PluginMonitor", "PluginMonitor execute PluginMonitor new SubCoreBaseMonitor");
            pin(new C7485q(C46086b.class));
        }
        AppMethodBeat.m2505o(84516);
    }

    public String name() {
        return "plugin-monitor";
    }
}
