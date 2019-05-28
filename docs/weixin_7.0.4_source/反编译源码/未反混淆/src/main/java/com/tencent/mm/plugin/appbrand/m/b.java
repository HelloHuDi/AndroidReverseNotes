package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.a.a;
import com.tencent.mm.plugin.appbrand.m.c.c;
import com.tencent.mm.plugin.appbrand.m.c.d;
import com.tencent.mm.plugin.appbrand.m.c.e;
import com.tencent.mm.plugin.appbrand.m.c.f;
import com.tencent.mm.plugin.appbrand.m.c.g;
import com.tencent.mm.plugin.appbrand.m.c.h;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static final Map<Integer, a> ipQ = new HashMap();

    static {
        AppMethodBeat.i(102170);
        a(new com.tencent.mm.plugin.appbrand.m.c.a());
        a(new d());
        a(new f());
        a(new h());
        a(new g());
        a(new c());
        a(new com.tencent.mm.plugin.appbrand.m.c.b());
        a(new e());
        AppMethodBeat.o(102170);
    }

    public static a pp(int i) {
        AppMethodBeat.i(102168);
        a aVar = (a) ipQ.get(Integer.valueOf(i));
        AppMethodBeat.o(102168);
        return aVar;
    }

    private static void a(a aVar) {
        AppMethodBeat.i(102169);
        ipQ.put(Integer.valueOf(aVar.aIT()), aVar);
        AppMethodBeat.o(102169);
    }
}
