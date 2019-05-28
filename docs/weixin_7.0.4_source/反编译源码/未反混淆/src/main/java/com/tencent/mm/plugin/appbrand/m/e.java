package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.a.e.a;
import com.tencent.mm.plugin.appbrand.m.d.b;
import com.tencent.mm.plugin.appbrand.m.d.c;
import com.tencent.mm.plugin.appbrand.q;
import java.util.HashMap;
import java.util.Map;

public final class e {
    private static final Map<Integer, com.tencent.mm.plugin.appbrand.m.a.e> ipX = new HashMap();

    static {
        AppMethodBeat.i(102184);
        AppMethodBeat.o(102184);
    }

    protected static void a(a aVar, q qVar) {
        AppMethodBeat.i(102181);
        a(new com.tencent.mm.plugin.appbrand.m.d.a(aVar, qVar));
        a(new c(aVar, qVar));
        a(new b(aVar, qVar));
        AppMethodBeat.o(102181);
    }

    public static com.tencent.mm.plugin.appbrand.m.a.e pq(int i) {
        AppMethodBeat.i(102182);
        com.tencent.mm.plugin.appbrand.m.a.e eVar = (com.tencent.mm.plugin.appbrand.m.a.e) ipX.get(Integer.valueOf(i));
        AppMethodBeat.o(102182);
        return eVar;
    }

    private static final void a(com.tencent.mm.plugin.appbrand.m.a.e eVar) {
        AppMethodBeat.i(102183);
        ipX.put(Integer.valueOf(eVar.getType()), eVar);
        AppMethodBeat.o(102183);
    }
}
