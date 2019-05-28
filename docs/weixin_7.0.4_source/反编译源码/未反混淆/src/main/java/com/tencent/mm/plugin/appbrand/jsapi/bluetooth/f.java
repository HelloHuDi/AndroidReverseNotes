package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import org.json.JSONObject;

@TargetApi(18)
public final class f extends a {
    private static final int CTRL_INDEX = 180;
    private static final String NAME = "createBLEConnection";

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(94185);
        c.kT(25);
        HashMap hashMap;
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiCreateBLEConnection", "createBLEConnection data is null, err");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10013));
            cVar.M(i, j("fail:invalid data", hashMap));
            AppMethodBeat.o(94185);
            return;
        }
        final String appId = cVar.getAppId();
        ab.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection data %s", appId, jSONObject.toString());
        b AT = a.AT(cVar.getAppId());
        if (AT == null) {
            ab.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            cVar.M(i, j("fail:not init", hashMap));
            c.cZ(27, 30);
            AppMethodBeat.o(94185);
        } else if (b.aCZ()) {
            boolean optBoolean = jSONObject.optBoolean("debug", false);
            boolean optBoolean2 = jSONObject.optBoolean("mainThread", true);
            boolean optBoolean3 = jSONObject.optBoolean("serial", true);
            long optLong = jSONObject.optLong("timeout", 20000);
            boolean optBoolean4 = jSONObject.optBoolean("autoConnect", false);
            String optString = jSONObject.optString("transport", "LE");
            String optString2 = jSONObject.optString("deviceId");
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b bVar = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.b(optString2);
            bVar.aJe = optBoolean;
            bVar.hDP = optBoolean2;
            bVar.hDR = optBoolean3;
            bVar.hEx = optLong;
            bVar.hEo = optBoolean4;
            bVar.hEp = optString;
            AT.a(optString2, bVar, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b() {
                public final void a(j jVar) {
                    AppMethodBeat.i(94184);
                    ab.i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection result:%s", appId, jVar);
                    HashMap hashMap;
                    switch (jVar.errCode) {
                        case 0:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(0));
                            cVar.M(i, f.this.j("ok", hashMap));
                            c.kT(26);
                            AppMethodBeat.o(94184);
                            return;
                        default:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(jVar.errCode));
                            cVar.M(i, f.this.j(jVar.aIm, hashMap));
                            c.kT(27);
                            AppMethodBeat.o(94184);
                            return;
                    }
                }
            });
            AppMethodBeat.o(94185);
        } else {
            ab.e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is disable, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            cVar.M(i, j("fail:not available", hashMap));
            c.cZ(27, 32);
            AppMethodBeat.o(94185);
        }
    }
}
