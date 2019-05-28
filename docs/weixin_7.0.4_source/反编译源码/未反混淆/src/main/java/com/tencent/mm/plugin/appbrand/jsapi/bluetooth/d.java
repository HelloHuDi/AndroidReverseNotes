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
public final class d extends a {
    private static final int CTRL_INDEX = 181;
    private static final String NAME = "closeBLEConnection";

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(94182);
        c.kT(91);
        HashMap hashMap;
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiCloseBLEConnection", "JsApiCloseBLEConnection data is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10013));
            cVar.M(i, j("fail:invalid data", hashMap));
            c.cZ(93, 94);
            AppMethodBeat.o(94182);
            return;
        }
        ab.i("MicroMsg.JsApiCloseBLEConnection", "appId:%s closeBLEConnection data %s", cVar.getAppId(), jSONObject.toString());
        b AT = a.AT(cVar.getAppId());
        if (AT == null) {
            ab.e("MicroMsg.JsApiCloseBLEConnection", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            cVar.M(i, j("fail:not init", hashMap));
            c.cZ(93, 96);
            AppMethodBeat.o(94182);
        } else if (b.aCZ()) {
            String optString = jSONObject.optString("deviceId");
            boolean optBoolean = jSONObject.optBoolean("debug", false);
            boolean optBoolean2 = jSONObject.optBoolean("mainThread", true);
            boolean optBoolean3 = jSONObject.optBoolean("serial", true);
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.a();
            aVar.aJe = optBoolean;
            aVar.hDP = optBoolean2;
            aVar.hDR = optBoolean3;
            AT.a(optString, aVar, new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b() {
                public final void a(j jVar) {
                    AppMethodBeat.i(94181);
                    HashMap hashMap;
                    switch (jVar.errCode) {
                        case 0:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(0));
                            cVar.M(i, d.this.j("ok", hashMap));
                            c.kT(92);
                            AppMethodBeat.o(94181);
                            return;
                        default:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(jVar.errCode));
                            cVar.M(i, d.this.j(jVar.aIm, hashMap));
                            c.kT(93);
                            AppMethodBeat.o(94181);
                            return;
                    }
                }
            });
            AppMethodBeat.o(94182);
        } else {
            ab.e("MicroMsg.JsApiCloseBLEConnection", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            cVar.M(i, j("fail:not available", hashMap));
            c.cZ(93, 98);
            AppMethodBeat.o(94182);
        }
    }
}
