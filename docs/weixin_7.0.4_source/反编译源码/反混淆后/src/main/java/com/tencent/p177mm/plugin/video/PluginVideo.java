package com.tencent.p177mm.plugin.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C45459n;
import com.tencent.p177mm.plugin.video.p1507a.C35337a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.video.PluginVideo */
public class PluginVideo extends C7597f implements C35337a {
    public String name() {
        return "plugin-video";
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(50969);
        C4990ab.m7416i("MicroMsg.PluginVideo", "plugin video execute");
        if (c1681g.mo5181SG()) {
            pin(new C7485q(C37961o.class));
            pin(new C7485q(C42204d.class));
            pin(new C7485q(C45459n.class));
        }
        AppMethodBeat.m2505o(50969);
    }
}
