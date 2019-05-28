package com.tencent.p177mm.plugin.appbrand.p297h;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p224d.p225a.C32488l;
import com.tencent.p177mm.p224d.p225a.C45301c;

/* renamed from: com.tencent.mm.plugin.appbrand.h.f */
final class C33210f extends C31294d {
    private final C45301c chO;
    private final C32488l ifb;
    private final int ifc;

    public C33210f(C32488l c32488l, int i) {
        this.chO = c32488l.chO;
        this.ifb = c32488l;
        this.ifc = i;
    }

    public final boolean aGS() {
        return false;
    }

    public final int aGT() {
        return this.ifc;
    }

    /* Access modifiers changed, original: protected|final */
    public final C45301c aGQ() {
        return this.chO;
    }

    /* Access modifiers changed, original: protected|final */
    public final C32488l aGR() {
        return this.ifb;
    }

    public final void pause() {
        AppMethodBeat.m2504i(113942);
        C45124d.m82933w("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not pause");
        AppMethodBeat.m2505o(113942);
    }

    public final void resume() {
        AppMethodBeat.m2504i(113943);
        C45124d.m82933w("MicroMsg.AppBrandJ2V8SubContext", "AppBrandJ2V8SubContext can not resume");
        AppMethodBeat.m2505o(113943);
    }

    public final void setJsExceptionHandler(C33211h c33211h) {
        AppMethodBeat.m2504i(113941);
        this.ifb.mo53120a(this.ifc, c33211h);
        AppMethodBeat.m2505o(113941);
    }
}
