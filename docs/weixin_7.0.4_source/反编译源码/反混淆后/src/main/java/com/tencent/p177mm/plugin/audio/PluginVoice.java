package com.tencent.p177mm.plugin.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.modelvoice.C26500m;
import com.tencent.p177mm.plugin.audio.p1474a.C33658a;

/* renamed from: com.tencent.mm.plugin.audio.PluginVoice */
public class PluginVoice extends C7597f implements C33658a {
    public String name() {
        return "plugin-voice";
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(116801);
        if (c1681g.mo5181SG()) {
            pin(new C7485q(C26500m.class));
        }
        AppMethodBeat.m2505o(116801);
    }
}
