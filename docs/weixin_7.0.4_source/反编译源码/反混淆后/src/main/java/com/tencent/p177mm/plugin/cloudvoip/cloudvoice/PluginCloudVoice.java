package com.tencent.p177mm.plugin.cloudvoip.cloudvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p1645a.C45813a;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c.C33836j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.PluginCloudVoice */
public class PluginCloudVoice extends C7597f implements C9562c, C45813a {
    private static final String[] kyY = new String[]{"confService", "marsbridgenetwork", "marsbridgexlog"};

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(135463);
        C4990ab.m7416i("MicroMsg.OpenVoice.PluginCloudVoice", "hy: PluginCloudVoice execute");
        AppMethodBeat.m2505o(135463);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(135464);
        super.configure(c1681g);
        C4990ab.m7416i("MicroMsg.OpenVoice.PluginCloudVoice", "hy: PluginCloudVoice configure");
        AppMethodBeat.m2505o(135464);
    }

    public void onAccountInitialized(C1705c c1705c) {
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(135465);
        C4990ab.m7416i("MicroMsg.OpenVoice.PluginCloudVoice", "hy: account release. uninit openvoice so");
        C33836j c33836j = C33836j.kzW;
        c33836j.mo54393R(c33836j.kAy);
        AppMethodBeat.m2505o(135465);
    }
}
