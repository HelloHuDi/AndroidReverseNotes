package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.luggage.sdk.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.plugin.appbrand.h.t;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.ah;

public final class d extends s implements m {
    private volatile l ikr;

    public final l aCc() {
        AppMethodBeat.i(132118);
        l lVar = new l(this);
        this.ikr = lVar;
        AppMethodBeat.o(132118);
        return lVar;
    }

    public final l aHR() {
        return this.ikr;
    }

    public final i aua() {
        AppMethodBeat.i(132119);
        ah.getContext();
        i oU = t.oU(WxaCommLibRuntimeReader.avQ().gVu);
        AppMethodBeat.o(132119);
        return oU;
    }

    public final void wO() {
    }

    public final int a(i iVar, int i) {
        return i;
    }

    public final void M(int i, String str) {
        AppMethodBeat.i(132120);
        ((j) super.getRuntime()).ikA.a(this, i, str);
        AppMethodBeat.o(132120);
    }

    public final /* synthetic */ b xL() {
        AppMethodBeat.i(132122);
        j jVar = (j) super.getRuntime();
        AppMethodBeat.o(132122);
        return jVar;
    }
}
