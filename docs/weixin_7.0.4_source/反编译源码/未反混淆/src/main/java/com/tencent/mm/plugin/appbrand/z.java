package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;

final class z implements f {
    z() {
    }

    public final e c(c cVar) {
        AppMethodBeat.i(86790);
        e eVar;
        if (cVar instanceof e) {
            eVar = (e) cVar;
            AppMethodBeat.o(86790);
            return eVar;
        } else if (cVar instanceof q) {
            eVar = ((q) cVar).getCurrentPageView();
            AppMethodBeat.o(86790);
            return eVar;
        } else {
            AppMethodBeat.o(86790);
            return null;
        }
    }
}
