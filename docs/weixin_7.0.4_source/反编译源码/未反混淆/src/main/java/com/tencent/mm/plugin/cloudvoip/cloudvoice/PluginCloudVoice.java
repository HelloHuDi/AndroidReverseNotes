package com.tencent.mm.plugin.cloudvoip.cloudvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.a.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginCloudVoice extends f implements c, a {
    private static final String[] kyY = new String[]{"confService", "marsbridgenetwork", "marsbridgexlog"};

    public void execute(g gVar) {
        AppMethodBeat.i(135463);
        ab.i("MicroMsg.OpenVoice.PluginCloudVoice", "hy: PluginCloudVoice execute");
        AppMethodBeat.o(135463);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(135464);
        super.configure(gVar);
        ab.i("MicroMsg.OpenVoice.PluginCloudVoice", "hy: PluginCloudVoice configure");
        AppMethodBeat.o(135464);
    }

    public void onAccountInitialized(e.c cVar) {
    }

    public void onAccountRelease() {
        AppMethodBeat.i(135465);
        ab.i("MicroMsg.OpenVoice.PluginCloudVoice", "hy: account release. uninit openvoice so");
        j jVar = j.kzW;
        jVar.R(jVar.kAy);
        AppMethodBeat.o(135465);
    }
}
