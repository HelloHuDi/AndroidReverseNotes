package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 353;
    public static final String NAME = "stopHCE";

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(137882);
        a(new a() {
            public final void T(int i, String str) {
                AppMethodBeat.i(137881);
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i));
                if (i == 0) {
                    e eVar = e.this;
                    c cVar = cVar;
                    int i2 = i;
                    HCEEventLogic.BF(cVar.getAppId());
                    HCEEventLogic.a(cVar.getAppId(), 13, null);
                    HashMap hashMap2 = new HashMap(2);
                    hashMap2.put("errCode", Integer.valueOf(0));
                    e.a(cVar, i2, eVar.j("ok", hashMap2));
                    AppMethodBeat.o(137881);
                    return;
                }
                e.a(cVar, i, e.this.j("fail: ".concat(String.valueOf(str)), hashMap));
                AppMethodBeat.o(137881);
            }
        });
        AppMethodBeat.o(137882);
    }

    static void a(c cVar, int i, String str) {
        AppMethodBeat.i(137883);
        ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo stopHCE callback result: %s", str);
        if (cVar != null) {
            cVar.M(i, str);
        }
        AppMethodBeat.o(137883);
    }
}
