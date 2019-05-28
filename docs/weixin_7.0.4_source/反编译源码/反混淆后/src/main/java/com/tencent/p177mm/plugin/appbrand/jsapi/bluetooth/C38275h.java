package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C33264e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.h */
public final class C38275h extends C10296a {
    private static final int CTRL_INDEX = 182;
    private static final String NAME = "getBLEDeviceServices";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(94187);
        C42484c.m75254kT(C19395n.CTRL_INDEX);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetBLEDeviceServices", "getBLEDeviceServices data is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            C42484c.m75253cZ(138, C33333a.CTRL_INDEX);
            AppMethodBeat.m2505o(94187);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiGetBLEDeviceServices", "appId:%s getBLEDeviceServices data %s", c2241c.getAppId(), jSONObject.toString());
        C44696b AT = C42483a.m75250AT(c2241c.getAppId());
        HashMap hashMap;
        if (AT == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetBLEDeviceServices", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            c2241c.mo6107M(i, mo73394j("fail:not init", hashMap));
            C42484c.m75253cZ(138, 141);
            AppMethodBeat.m2505o(94187);
        } else if (C38283b.aCZ()) {
            List<C33264e> AV = AT.mo71731AV(jSONObject.optString("deviceId"));
            HashMap hashMap2 = new HashMap();
            if (AV == null || AV.size() <= 0) {
                C4990ab.m7412e("MicroMsg.JsApiGetBLEDeviceServices", "not found services");
                hashMap2.put("errCode", Integer.valueOf(10004));
                c2241c.mo6107M(i, mo73394j("fail:no service", hashMap2));
                C42484c.m75253cZ(138, 144);
                AppMethodBeat.m2505o(94187);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (C33264e c33264e : AV) {
                if (C5046bo.isNullOrNil(c33264e.eCq)) {
                    C4990ab.m7412e("MicroMsg.JsApiGetBLEDeviceServices", "get uuid is null");
                } else {
                    try {
                        if (c33264e.jsonObject == null) {
                            c33264e.jsonObject = new JSONObject();
                            c33264e.jsonObject.put("uuid", c33264e.eCq);
                            c33264e.jsonObject.put("isPrimary", c33264e.hEK);
                        }
                        jSONArray.put(c33264e.jsonObject);
                    } catch (JSONException e) {
                        C4990ab.m7413e("MicroMsg.JsApiGetBLEDeviceServices", "JSONException %s", e.getMessage());
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("errMsg", getName() + ":ok");
                jSONObject2.put("services", jSONArray);
                jSONObject2.put("errCode", 0);
            } catch (JSONException e2) {
                C4990ab.printErrStackTrace("MicroMsg.JsApiGetBLEDeviceServices", e2, "", new Object[0]);
            }
            C4990ab.m7417i("MicroMsg.JsApiGetBLEDeviceServices", "retJson %s", jSONObject2.toString());
            c2241c.mo6107M(i, jSONObject2.toString());
            C42484c.m75254kT(137);
            AppMethodBeat.m2505o(94187);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiGetBLEDeviceServices", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            c2241c.mo6107M(i, mo73394j("fail:not available", hashMap));
            C42484c.m75253cZ(138, 145);
            AppMethodBeat.m2505o(94187);
        }
    }
}
