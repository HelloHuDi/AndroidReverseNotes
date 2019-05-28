package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.i.f;
import com.tencent.mm.plugin.appbrand.l.k;
import java.util.HashMap;
import java.util.Map;

public final class bp {
    static final Map<String, a> hzA = new HashMap();

    static {
        AppMethodBeat.i(86970);
        AppMethodBeat.o(86970);
    }

    public static void aCp() {
        AppMethodBeat.i(86969);
        f.a(new k.a() {
            public final void d(final c cVar, final String str) {
                AppMethodBeat.i(86967);
                AnonymousClass1 anonymousClass1 = new a() {
                    public final void a(String str, b bVar) {
                        AppMethodBeat.i(86966);
                        f.a(cVar, str, bVar, str);
                        AppMethodBeat.o(86966);
                    }
                };
                bp.hzA.put(str, anonymousClass1);
                ((h) cVar).getRuntime().gNN.a(anonymousClass1);
                AppMethodBeat.o(86967);
            }

            public final void e(c cVar, String str) {
                AppMethodBeat.i(86968);
                a aVar = (a) bp.hzA.get(str);
                if (aVar != null) {
                    i runtime = ((h) cVar).getRuntime();
                    if (runtime != null) {
                        runtime.gNN.b(aVar);
                    }
                }
                AppMethodBeat.o(86968);
            }
        });
        AppMethodBeat.o(86969);
    }
}
