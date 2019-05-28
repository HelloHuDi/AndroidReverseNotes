package com.tencent.p177mm.plugin.trafficmonitor;

import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.plugin.trafficmonitor.p1044a.C14009a;

/* renamed from: com.tencent.mm.plugin.trafficmonitor.PluginTrafficMonitor */
public class PluginTrafficMonitor extends C7597f implements C14009a {
    public void installed() {
        AppMethodBeat.m2504i(114758);
        super.installed();
        alias(C14009a.class);
        AppMethodBeat.m2505o(114758);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(114759);
        if (c1681g.mo5181SG() && VERSION.SDK_INT < 28 && VERSION.SDK_INT > 19) {
            c1681g.f1233cc.registerReceiver(new TrafficClickFlowReceiver(), new IntentFilter("com.tencent.mm.Intent.ACTION_NET_STATS"));
            C22442e.cHE();
            C22442e.cHF();
        }
        AppMethodBeat.m2505o(114759);
    }

    public String name() {
        return "plugin-trafficmonitor";
    }
}
