package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C2237b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C26942j;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.p1224a.C19342f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import org.json.JSONObject;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.q */
public final class C38277q extends C10296a {
    private static final int CTRL_INDEX = 184;
    private static final String NAME = "writeBLECharacteristicValue";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(94215);
        C42484c.m75254kT(56);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiWriteBLECharacteristicValue", "JsApiWriteBLECharacteristicValue data is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            C42484c.m75253cZ(58, 59);
            AppMethodBeat.m2505o(94215);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiWriteBLECharacteristicValue", "appId:%s writeBLECharacteristicValue data %s", c2241c.getAppId(), jSONObject.toString());
        C44696b AT = C42483a.m75250AT(c2241c.getAppId());
        HashMap hashMap;
        if (AT == null) {
            C4990ab.m7412e("MicroMsg.JsApiWriteBLECharacteristicValue", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            c2241c.mo6107M(i, mo73394j("fail:not init", hashMap));
            C42484c.m75253cZ(58, 61);
            AppMethodBeat.m2505o(94215);
        } else if (C38283b.aCZ()) {
            String optString = jSONObject.optString("deviceId");
            String optString2 = jSONObject.optString("serviceId");
            String optString3 = jSONObject.optString("characteristicId");
            String optString4 = jSONObject.optString("value");
            boolean optBoolean = jSONObject.optBoolean("debug", false);
            boolean optBoolean2 = jSONObject.optBoolean("serial", true);
            C19342f c19342f = new C19342f(optString2, optString3, optString4);
            c19342f.aJe = optBoolean;
            c19342f.hDP = false;
            c19342f.hDR = optBoolean2;
            AT.mo71732a(optString, c19342f, new C2237b() {
                /* renamed from: a */
                public final void mo6097a(C26942j c26942j) {
                    AppMethodBeat.m2504i(94214);
                    HashMap hashMap;
                    switch (c26942j.errCode) {
                        case 0:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(0));
                            c2241c.mo6107M(i, C38277q.this.mo73394j("ok", hashMap));
                            C42484c.m75254kT(58);
                            AppMethodBeat.m2505o(94214);
                            return;
                        default:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(c26942j.errCode));
                            c2241c.mo6107M(i, C38277q.this.mo73394j(c26942j.aIm, hashMap));
                            C42484c.m75254kT(58);
                            AppMethodBeat.m2505o(94214);
                            return;
                    }
                }
            });
            AppMethodBeat.m2505o(94215);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiWriteBLECharacteristicValue", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            c2241c.mo6107M(i, mo73394j("fail:not available", hashMap));
            C42484c.m75253cZ(58, 63);
            AppMethodBeat.m2505o(94215);
        }
    }
}
