package com.tencent.mm.plugin.appbrand.t.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.b.a.b;
import com.tencent.mm.plugin.appbrand.t.e.a;

public class c extends b {
    public final b c(a aVar) {
        AppMethodBeat.i(73246);
        b bVar;
        if (b.g(aVar) == 13) {
            bVar = b.MATCHED;
            AppMethodBeat.o(73246);
            return bVar;
        }
        bVar = b.NOT_MATCHED;
        AppMethodBeat.o(73246);
        return bVar;
    }

    public final com.tencent.mm.plugin.appbrand.t.e.b a(com.tencent.mm.plugin.appbrand.t.e.b bVar) {
        AppMethodBeat.i(73247);
        super.a(bVar);
        bVar.put("Sec-WebSocket-Version", "13");
        AppMethodBeat.o(73247);
        return bVar;
    }

    public a aOm() {
        AppMethodBeat.i(73248);
        c cVar = new c();
        AppMethodBeat.o(73248);
        return cVar;
    }
}
