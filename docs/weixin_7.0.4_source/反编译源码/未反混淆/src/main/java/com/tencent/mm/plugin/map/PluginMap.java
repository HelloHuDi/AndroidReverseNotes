package com.tencent.mm.plugin.map;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.map.a.a;

public class PluginMap extends f implements a {
    public String name() {
        return "plugin-map";
    }

    public void installed() {
        AppMethodBeat.i(113775);
        alias(a.class);
        AppMethodBeat.o(113775);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(113776);
        if (gVar.SG()) {
            pin(new q(l.class));
        }
        AppMethodBeat.o(113776);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(113777);
        if (gVar.SG()) {
            c.aks(b.LOCATION);
        }
        AppMethodBeat.o(113777);
    }
}
