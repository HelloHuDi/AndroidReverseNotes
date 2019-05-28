package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.c;

public final class i implements a {
    public static i hVW = new i();
    private a hVX = new a() {
        public final int aEN() {
            return 20;
        }

        public final int aEO() {
            return 200;
        }

        public final boolean a(c cVar, ah ahVar) {
            return true;
        }
    };

    public i() {
        AppMethodBeat.i(126391);
        AppMethodBeat.o(126391);
    }

    static {
        AppMethodBeat.i(126396);
        AppMethodBeat.o(126396);
    }

    private a aEQ() {
        AppMethodBeat.i(126392);
        a aVar;
        if (e.B(a.class) != null) {
            aVar = (a) e.B(a.class);
            AppMethodBeat.o(126392);
            return aVar;
        }
        aVar = this.hVX;
        AppMethodBeat.o(126392);
        return aVar;
    }

    public final int aEN() {
        AppMethodBeat.i(126393);
        int aEN = aEQ().aEN();
        AppMethodBeat.o(126393);
        return aEN;
    }

    public final int aEO() {
        AppMethodBeat.i(126394);
        int aEO = aEQ().aEO();
        AppMethodBeat.o(126394);
        return aEO;
    }

    public final boolean a(c cVar, ah ahVar) {
        AppMethodBeat.i(126395);
        boolean a = aEQ().a(cVar, ahVar);
        AppMethodBeat.o(126395);
        return a;
    }
}
