package com.tencent.mm.plugin.trafficmonitor;

import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.trafficmonitor.a.a;

public class PluginTrafficMonitor extends f implements a {
    public void installed() {
        AppMethodBeat.i(114758);
        super.installed();
        alias(a.class);
        AppMethodBeat.o(114758);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(114759);
        if (gVar.SG() && VERSION.SDK_INT < 28 && VERSION.SDK_INT > 19) {
            gVar.cc.registerReceiver(new TrafficClickFlowReceiver(), new IntentFilter("com.tencent.mm.Intent.ACTION_NET_STATS"));
            e.cHE();
            e.cHF();
        }
        AppMethodBeat.o(114759);
    }

    public String name() {
        return "plugin-trafficmonitor";
    }
}
