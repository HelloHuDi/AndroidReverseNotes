package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s;
import org.json.JSONObject;

final class b extends a<s> {
    public static final int CTRL_INDEX = 395;
    public static final String NAME = "setDeviceOrientation";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(130192);
        final s sVar = (s) cVar;
        if (jSONObject == null) {
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(130192);
            return;
        }
        com.tencent.mm.plugin.appbrand.config.a.a.b yV = com.tencent.mm.plugin.appbrand.config.a.a.yV(jSONObject.optString("value", null));
        if (yV == null) {
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(130192);
        } else if (sVar.getRuntime() == null || sVar.getRuntime().atM() == null) {
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(130192);
        } else {
            com.tencent.mm.plugin.appbrand.config.a.a.t(sVar.getRuntime().atM()).a(yV, new com.tencent.mm.plugin.appbrand.config.a.a.a() {
                public final void a(com.tencent.mm.plugin.appbrand.config.a.a.b bVar, boolean z) {
                    String str;
                    AppMethodBeat.i(130191);
                    s sVar = sVar;
                    int i = i;
                    b bVar2 = b.this;
                    if (z) {
                        str = "ok";
                    } else {
                        str = "fail";
                    }
                    sVar.M(i, bVar2.j(str, null));
                    AppMethodBeat.o(130191);
                }
            });
            AppMethodBeat.o(130192);
        }
    }

    b() {
    }
}
