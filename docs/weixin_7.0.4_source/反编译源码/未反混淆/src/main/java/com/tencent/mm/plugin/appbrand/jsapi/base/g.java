package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;

public final class g {
    c hCS;
    int hwi;

    public g(c cVar, int i) {
        this.hCS = cVar;
        this.hwi = i;
    }

    public final void AR(String str) {
        AppMethodBeat.i(91048);
        this.hCS.M(this.hwi, str);
        AppMethodBeat.o(91048);
    }
}
