package com.tencent.mm.plugin.appbrand.luggage;

import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.bridge.impl.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.luggage.b.p;

public final class b extends a {
    private final f ikb = new p();

    public b() {
        AppMethodBeat.i(11122);
        AppMethodBeat.o(11122);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(11123);
        super.a(cVar);
        cVar.a(f.class, this.ikb);
        cVar.a(e.class, com.tencent.mm.plugin.appbrand.dynamic.b.b.azO());
        AppMethodBeat.o(11123);
    }

    public final void a(com.tencent.luggage.bridge.a.a.a aVar) {
        AppMethodBeat.i(11124);
        super.a(aVar);
        aVar.a(f.class, (com.tencent.luggage.a.b) this.ikb);
        AppMethodBeat.o(11124);
    }
}
