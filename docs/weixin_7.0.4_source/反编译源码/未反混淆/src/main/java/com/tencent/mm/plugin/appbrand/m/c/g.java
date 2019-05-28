package com.tencent.mm.plugin.appbrand.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.m.a.b;
import com.tencent.mm.plugin.appbrand.m.a.c;
import com.tencent.mm.plugin.appbrand.permission.d;
import java.util.HashMap;

public final class g extends b {
    public final int aIT() {
        return 1;
    }

    public final void a(i iVar, final c cVar) {
        AppMethodBeat.i(102201);
        String optString = iVar.optString("apiName");
        h hVar = cVar.gMN;
        if (d.cK(hVar.getAppId(), optString)) {
            a(cVar, 1);
            AppMethodBeat.o(102201);
            return;
        }
        d.a(hVar, optString, new d.b() {
            public final void aIX() {
                AppMethodBeat.i(102198);
                g.a(cVar, 1);
                AppMethodBeat.o(102198);
            }

            public final void CW(String str) {
                AppMethodBeat.i(102199);
                g.a(cVar, 2);
                AppMethodBeat.o(102199);
            }

            public final void onCancel() {
                AppMethodBeat.i(102200);
                g.a(cVar, 3);
                AppMethodBeat.o(102200);
            }
        });
        AppMethodBeat.o(102201);
    }

    static void a(c cVar, int i) {
        AppMethodBeat.i(102202);
        HashMap hashMap = new HashMap();
        hashMap.put("result", Integer.valueOf(i));
        cVar.B(hashMap);
        AppMethodBeat.o(102202);
    }
}
