package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33262c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.g */
public final class C26935g extends C10296a {
    private static final int CTRL_INDEX = 183;
    private static final String NAME = "getBLEDeviceCharacteristics";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(94186);
        C42484c.m75254kT(151);
        HashMap hashMap;
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "getBLEDeviceCharacteristics data is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10013));
            c2241c.mo6107M(i, mo73394j("fail:invalid data", hashMap));
            C42484c.m75253cZ(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, JsApiMakeVoIPCall.CTRL_INDEX);
            AppMethodBeat.m2505o(94186);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "appId:%s getBLEDeviceCharacteristics data %s", c2241c.getAppId(), jSONObject.toString());
        C44696b AT = C42483a.m75250AT(c2241c.getAppId());
        if (AT == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            c2241c.mo6107M(i, mo73394j("fail:not init", hashMap));
            C42484c.m75253cZ(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 156);
            AppMethodBeat.m2505o(94186);
        } else if (C38283b.aCZ()) {
            List<C33262c> ca = AT.mo71734ca(jSONObject.optString("deviceId"), jSONObject.optString("serviceId"));
            HashMap hashMap2 = new HashMap();
            if (ca == null || ca.size() <= 0) {
                C4990ab.m7412e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "not found characteristic");
                hashMap2.put("errCode", Integer.valueOf(10005));
                c2241c.mo6107M(i, mo73394j("fail:no characteristic", hashMap2));
                C42484c.m75253cZ(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, JsApiGetBackgroundAudioState.CTRL_INDEX);
                AppMethodBeat.m2505o(94186);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (C33262c c33262c : ca) {
                try {
                    if (c33262c.jsonObject == null) {
                        c33262c.jsonObject = new JSONObject();
                        c33262c.jsonObject.put("uuid", c33262c.eCq);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("read", c33262c.hEC);
                        String str = "write";
                        boolean z = c33262c.hED || c33262c.hEE;
                        jSONObject2.put(str, z);
                        jSONObject2.put("notify", c33262c.flq);
                        jSONObject2.put("indicate", c33262c.hEF);
                        c33262c.jsonObject.put("properties", jSONObject2);
                    }
                    jSONArray.put(c33262c.jsonObject);
                } catch (JSONException e) {
                    C4990ab.m7413e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "JSONException %s", e.getMessage());
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("errMsg", getName() + ":ok");
                jSONObject3.put("characteristics", jSONArray);
                jSONObject3.put("errCode", 0);
            } catch (JSONException e2) {
                C4990ab.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceCharacteristics", e2, "", new Object[0]);
            }
            C4990ab.m7417i("MicroMsg.JsApiGetBLEDeviceCharacteristics", "retJson %s", jSONObject3.toString());
            c2241c.mo6107M(i, jSONObject3.toString());
            C42484c.m75254kT(152);
            AppMethodBeat.m2505o(94186);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiGetBLEDeviceCharacteristics", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            c2241c.mo6107M(i, mo73394j("fail:not available", hashMap));
            C42484c.m75253cZ(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 158);
            AppMethodBeat.m2505o(94186);
        }
    }
}
