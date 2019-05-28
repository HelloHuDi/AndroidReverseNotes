package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

@TargetApi(18)
public final class g extends a {
    private static final int CTRL_INDEX = 183;
    private static final String NAME = "getBLEDeviceCharacteristics";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(94186);
        c.kT(151);
        HashMap hashMap;
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "getBLEDeviceCharacteristics data is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10013));
            cVar.M(i, j("fail:invalid data", hashMap));
            c.cZ(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, JsApiMakeVoIPCall.CTRL_INDEX);
            AppMethodBeat.o(94186);
            return;
        }
        ab.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "appId:%s getBLEDeviceCharacteristics data %s", cVar.getAppId(), jSONObject.toString());
        b AT = a.AT(cVar.getAppId());
        if (AT == null) {
            ab.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            cVar.M(i, j("fail:not init", hashMap));
            c.cZ(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 156);
            AppMethodBeat.o(94186);
        } else if (b.aCZ()) {
            List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c> ca = AT.ca(jSONObject.optString("deviceId"), jSONObject.optString("serviceId"));
            HashMap hashMap2 = new HashMap();
            if (ca == null || ca.size() <= 0) {
                ab.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "not found characteristic");
                hashMap2.put("errCode", Integer.valueOf(10005));
                cVar.M(i, j("fail:no characteristic", hashMap2));
                c.cZ(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, JsApiGetBackgroundAudioState.CTRL_INDEX);
                AppMethodBeat.o(94186);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c cVar2 : ca) {
                try {
                    if (cVar2.jsonObject == null) {
                        cVar2.jsonObject = new JSONObject();
                        cVar2.jsonObject.put("uuid", cVar2.eCq);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("read", cVar2.hEC);
                        String str = "write";
                        boolean z = cVar2.hED || cVar2.hEE;
                        jSONObject2.put(str, z);
                        jSONObject2.put("notify", cVar2.flq);
                        jSONObject2.put("indicate", cVar2.hEF);
                        cVar2.jsonObject.put("properties", jSONObject2);
                    }
                    jSONArray.put(cVar2.jsonObject);
                } catch (JSONException e) {
                    ab.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "JSONException %s", e.getMessage());
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("errMsg", getName() + ":ok");
                jSONObject3.put("characteristics", jSONArray);
                jSONObject3.put("errCode", 0);
            } catch (JSONException e2) {
                ab.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceCharacteristics", e2, "", new Object[0]);
            }
            ab.i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "retJson %s", jSONObject3.toString());
            cVar.M(i, jSONObject3.toString());
            c.kT(152);
            AppMethodBeat.o(94186);
        } else {
            ab.e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            cVar.M(i, j("fail:not available", hashMap));
            c.cZ(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 158);
            AppMethodBeat.o(94186);
        }
    }
}
