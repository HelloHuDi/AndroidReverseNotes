package com.tencent.mm.plugin.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.audio.a.a;

public class PluginVoice extends f implements a {
    public String name() {
        return "plugin-voice";
    }

    public void execute(g gVar) {
        AppMethodBeat.i(116801);
        if (gVar.SG()) {
            pin(new q(m.class));
        }
        AppMethodBeat.o(116801);
    }
}
