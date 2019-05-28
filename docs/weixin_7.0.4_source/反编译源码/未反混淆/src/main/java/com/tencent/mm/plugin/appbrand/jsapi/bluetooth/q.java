package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import org.json.JSONObject;

@TargetApi(18)
public final class q extends a {
    private static final int CTRL_INDEX = 184;
    private static final String NAME = "writeBLECharacteristicValue";

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(94215);
        c.kT(56);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiWriteBLECharacteristicValue", "JsApiWriteBLECharacteristicValue data is null");
            cVar.M(i, j("fail:invalid data", null));
            c.cZ(58, 59);
            AppMethodBeat.o(94215);
            return;
        }
        ab.i("MicroMsg.JsApiWriteBLECharacteristicValue", "appId:%s writeBLECharacteristicValue data %s", cVar.getAppId(), jSONObject.toString());
        b AT = a.AT(cVar.getAppId());
        HashMap hashMap;
        if (AT == null) {
            ab.e("MicroMsg.JsApiWriteBLECharacteristicValue", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            cVar.M(i, j("fail:not init", hashMap));
            c.cZ(58, 61);
            AppMethodBeat.o(94215);
        } else if (b.aCZ()) {
            String optString = jSONObject.optString("deviceId");
            String optString2 = jSONObject.optString("serviceId");
            String optString3 = jSONObject.optString("characteristicId");
            String optString4 = jSONObject.optString("value");
            boolean optBoolean = jSONObject.optBoolean("debug", false);
            boolean optBoolean2 = jSONObject.optBoolean("serial", true);
            f fVar = new f(optString2, optString3, optString4);
            fVar.aJe = optBoolean;
            fVar.hDP = false;
            fVar.hDR = optBoolean2;
            AT.a(optString, fVar, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b() {
                public final void a(j jVar) {
                    AppMethodBeat.i(94214);
                    HashMap hashMap;
                    switch (jVar.errCode) {
                        case 0:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(0));
                            cVar.M(i, q.this.j("ok", hashMap));
                            c.kT(58);
                            AppMethodBeat.o(94214);
                            return;
                        default:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(jVar.errCode));
                            cVar.M(i, q.this.j(jVar.aIm, hashMap));
                            c.kT(58);
                            AppMethodBeat.o(94214);
                            return;
                    }
                }
            });
            AppMethodBeat.o(94215);
        } else {
            ab.e("MicroMsg.JsApiWriteBLECharacteristicValue", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            cVar.M(i, j("fail:not available", hashMap));
            c.cZ(58, 63);
            AppMethodBeat.o(94215);
        }
    }
}
