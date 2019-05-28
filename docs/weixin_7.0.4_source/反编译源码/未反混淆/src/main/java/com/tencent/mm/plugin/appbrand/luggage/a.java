package com.tencent.mm.plugin.appbrand.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.m;
import com.tencent.mm.plugin.appbrand.l.o;
import com.tencent.mm.plugin.appbrand.luggage.a.c;

public final class a extends com.tencent.luggage.bridge.impl.a {
    private static e hmp = new c();

    static {
        AppMethodBeat.i(132090);
        AppMethodBeat.o(132090);
    }

    public final void a(com.tencent.luggage.bridge.a.a.c cVar) {
        AppMethodBeat.i(132088);
        super.a(cVar);
        cVar.a(e.class, hmp);
        cVar.a(o.class, new com.tencent.mm.plugin.appbrand.luggage.c.c());
        cVar.a(com.tencent.mm.plugin.appbrand.s.b.a.class, new m());
        AppMethodBeat.o(132088);
    }

    public final void a(com.tencent.luggage.bridge.a.a.a aVar) {
        AppMethodBeat.i(132089);
        super.a(aVar);
        AppMethodBeat.o(132089);
    }
}
