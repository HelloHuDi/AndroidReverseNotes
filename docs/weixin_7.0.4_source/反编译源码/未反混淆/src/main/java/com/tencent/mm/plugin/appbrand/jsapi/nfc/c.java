package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 354;
    public static final String NAME = "sendHCEMessage";

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, final JSONObject jSONObject, final int i) {
        AppMethodBeat.i(137870);
        a(new a() {
            public final void T(int i, String str) {
                AppMethodBeat.i(137869);
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i));
                if (i == 0) {
                    c cVar = c.this;
                    com.tencent.mm.plugin.appbrand.jsapi.c cVar2 = cVar;
                    int i2 = i;
                    JSONObject jSONObject = jSONObject;
                    HashMap hashMap2 = new HashMap();
                    String optString = jSONObject.optString("data");
                    if (bo.isNullOrNil(optString)) {
                        hashMap2.put("errCode", Integer.valueOf(13005));
                        c.a(cVar2, i2, cVar.j("fail", hashMap2));
                        AppMethodBeat.o(137869);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("key_apdu_command", optString);
                    HCEEventLogic.a(cVar2.getAppId(), 32, bundle);
                    hashMap2.put("errCode", Integer.valueOf(0));
                    cVar2.M(i2, cVar.j("ok", hashMap2));
                    AppMethodBeat.o(137869);
                    return;
                }
                c.a(cVar, i, c.this.j("fail: ".concat(String.valueOf(str)), hashMap));
                AppMethodBeat.o(137869);
            }
        });
        AppMethodBeat.o(137870);
    }

    static void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, int i, String str) {
        AppMethodBeat.i(137871);
        ab.i("MicroMsg.JsApiNFCSendHCEResponseCommand", "alvinluo sendHCEMessage callback json: %s", str);
        if (cVar != null) {
            cVar.M(i, str);
        }
        AppMethodBeat.o(137871);
    }
}
