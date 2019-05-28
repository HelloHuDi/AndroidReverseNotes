package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class h extends a {
    private static final int CTRL_INDEX = 182;
    private static final String NAME = "getBLEDeviceServices";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(94187);
        c.kT(n.CTRL_INDEX);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiGetBLEDeviceServices", "getBLEDeviceServices data is null");
            cVar.M(i, j("fail:invalid data", null));
            c.cZ(138, com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX);
            AppMethodBeat.o(94187);
            return;
        }
        ab.i("MicroMsg.JsApiGetBLEDeviceServices", "appId:%s getBLEDeviceServices data %s", cVar.getAppId(), jSONObject.toString());
        b AT = a.AT(cVar.getAppId());
        HashMap hashMap;
        if (AT == null) {
            ab.e("MicroMsg.JsApiGetBLEDeviceServices", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            cVar.M(i, j("fail:not init", hashMap));
            c.cZ(138, 141);
            AppMethodBeat.o(94187);
        } else if (b.aCZ()) {
            List<e> AV = AT.AV(jSONObject.optString("deviceId"));
            HashMap hashMap2 = new HashMap();
            if (AV == null || AV.size() <= 0) {
                ab.e("MicroMsg.JsApiGetBLEDeviceServices", "not found services");
                hashMap2.put("errCode", Integer.valueOf(10004));
                cVar.M(i, j("fail:no service", hashMap2));
                c.cZ(138, 144);
                AppMethodBeat.o(94187);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (e eVar : AV) {
                if (bo.isNullOrNil(eVar.eCq)) {
                    ab.e("MicroMsg.JsApiGetBLEDeviceServices", "get uuid is null");
                } else {
                    try {
                        if (eVar.jsonObject == null) {
                            eVar.jsonObject = new JSONObject();
                            eVar.jsonObject.put("uuid", eVar.eCq);
                            eVar.jsonObject.put("isPrimary", eVar.hEK);
                        }
                        jSONArray.put(eVar.jsonObject);
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiGetBLEDeviceServices", "JSONException %s", e.getMessage());
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("errMsg", getName() + ":ok");
                jSONObject2.put("services", jSONArray);
                jSONObject2.put("errCode", 0);
            } catch (JSONException e2) {
                ab.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceServices", e2, "", new Object[0]);
            }
            ab.i("MicroMsg.JsApiGetBLEDeviceServices", "retJson %s", jSONObject2.toString());
            cVar.M(i, jSONObject2.toString());
            c.kT(137);
            AppMethodBeat.o(94187);
        } else {
            ab.e("MicroMsg.JsApiGetBLEDeviceServices", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            cVar.M(i, j("fail:not available", hashMap));
            c.cZ(138, 145);
            AppMethodBeat.o(94187);
        }
    }
}
