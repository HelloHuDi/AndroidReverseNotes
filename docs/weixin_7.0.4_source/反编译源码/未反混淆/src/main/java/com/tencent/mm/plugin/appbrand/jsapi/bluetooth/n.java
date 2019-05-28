package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import org.json.JSONObject;

@TargetApi(18)
public final class n extends a {
    private static final int CTRL_INDEX = 185;
    private static final String NAME = "readBLECharacteristicValue";

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(94205);
        c.kT(41);
        HashMap hashMap;
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiReadBLECharacteristicValue", "JsApiReadBLECharacteristicValue data is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10013));
            cVar.M(i, j("fail:invalid data", hashMap));
            c.cZ(43, 44);
            AppMethodBeat.o(94205);
            return;
        }
        ab.i("MicroMsg.JsApiReadBLECharacteristicValue", "appId:%s readBLECharacteristicValue data %s", cVar.getAppId(), jSONObject.toString());
        b AT = a.AT(cVar.getAppId());
        if (AT == null) {
            ab.e("MicroMsg.JsApiReadBLECharacteristicValue", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            cVar.M(i, j("fail:not init", hashMap));
            c.cZ(43, 46);
            AppMethodBeat.o(94205);
        } else if (b.aCZ()) {
            String optString = jSONObject.optString("deviceId");
            String optString2 = jSONObject.optString("serviceId");
            String optString3 = jSONObject.optString("characteristicId");
            boolean optBoolean = jSONObject.optBoolean("debug", false);
            boolean optBoolean2 = jSONObject.optBoolean("serial", true);
            e eVar = new e(optString2, optString3);
            eVar.aJe = optBoolean;
            eVar.hDP = false;
            eVar.hDR = optBoolean2;
            AT.a(optString, eVar, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b() {
                public final void a(j jVar) {
                    AppMethodBeat.i(94204);
                    HashMap hashMap;
                    switch (jVar.errCode) {
                        case 0:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(0));
                            cVar.M(i, n.this.j("ok", hashMap));
                            c.kT(42);
                            AppMethodBeat.o(94204);
                            return;
                        default:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(jVar.errCode));
                            cVar.M(i, n.this.j(jVar.aIm, hashMap));
                            c.kT(43);
                            AppMethodBeat.o(94204);
                            return;
                    }
                }
            });
            AppMethodBeat.o(94205);
        } else {
            ab.e("MicroMsg.JsApiReadBLECharacteristicValue", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            cVar.M(i, j("fail:not available", hashMap));
            c.cZ(43, 48);
            AppMethodBeat.o(94205);
        }
    }
}
