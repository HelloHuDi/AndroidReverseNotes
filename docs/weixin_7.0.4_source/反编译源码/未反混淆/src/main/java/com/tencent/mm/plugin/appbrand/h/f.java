package com.tencent.mm.plugin.appbrand.h;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.c;
import com.tencent.mm.d.a.l;

final class f extends d {
    private final c chO;
    private final l ifb;
    private final int ifc;

    public f(l lVar, int i) {
        this.chO = lVar.chO;
        this.ifb = lVar;
        this.ifc = i;
    }

    public final boolean aGS() {
        return false;
    }

    public final int aGT() {
        return this.ifc;
    }

    /* Access modifiers changed, original: protected|final */
    public final c aGQ() {
        return this.chO;
    }

    /* Access modifiers changed, original: protected|final */
    public final l aGR() {
        return this.ifb;
    }

    public final void pause() {
        AppMethodBeat.i(113942);
        d.w("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not pause");
        AppMethodBeat.o(113942);
    }

    public final void resume() {
        AppMethodBeat.i(113943);
        d.w("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not resume");
        AppMethodBeat.o(113943);
    }

    public final void setJsExceptionHandler(h hVar) {
        AppMethodBeat.i(113941);
        this.ifb.a(this.ifc, hVar);
        AppMethodBeat.o(113941);
    }
}
