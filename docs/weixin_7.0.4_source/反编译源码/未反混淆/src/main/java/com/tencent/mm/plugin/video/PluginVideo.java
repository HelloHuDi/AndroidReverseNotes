package com.tencent.mm.plugin.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.video.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginVideo extends f implements a {
    public String name() {
        return "plugin-video";
    }

    public void execute(g gVar) {
        AppMethodBeat.i(50969);
        ab.i("MicroMsg.PluginVideo", "plugin video execute");
        if (gVar.SG()) {
            pin(new q(o.class));
            pin(new q(d.class));
            pin(new q(n.class));
        }
        AppMethodBeat.o(50969);
    }
}
