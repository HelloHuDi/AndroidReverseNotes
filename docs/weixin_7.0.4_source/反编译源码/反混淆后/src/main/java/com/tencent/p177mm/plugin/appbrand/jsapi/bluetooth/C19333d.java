package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C2237b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C26942j;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.p1224a.C26940a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import org.json.JSONObject;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.d */
public final class C19333d extends C10296a {
    private static final int CTRL_INDEX = 181;
    private static final String NAME = "closeBLEConnection";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(94182);
        C42484c.m75254kT(91);
        HashMap hashMap;
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiCloseBLEConnection", "JsApiCloseBLEConnection data is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10013));
            c2241c.mo6107M(i, mo73394j("fail:invalid data", hashMap));
            C42484c.m75253cZ(93, 94);
            AppMethodBeat.m2505o(94182);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiCloseBLEConnection", "appId:%s closeBLEConnection data %s", c2241c.getAppId(), jSONObject.toString());
        C44696b AT = C42483a.m75250AT(c2241c.getAppId());
        if (AT == null) {
            C4990ab.m7412e("MicroMsg.JsApiCloseBLEConnection", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            c2241c.mo6107M(i, mo73394j("fail:not init", hashMap));
            C42484c.m75253cZ(93, 96);
            AppMethodBeat.m2505o(94182);
        } else if (C38283b.aCZ()) {
            String optString = jSONObject.optString("deviceId");
            boolean optBoolean = jSONObject.optBoolean("debug", false);
            boolean optBoolean2 = jSONObject.optBoolean("mainThread", true);
            boolean optBoolean3 = jSONObject.optBoolean("serial", true);
            C26940a c26940a = new C26940a();
            c26940a.aJe = optBoolean;
            c26940a.hDP = optBoolean2;
            c26940a.hDR = optBoolean3;
            AT.mo71732a(optString, c26940a, new C2237b() {
                /* renamed from: a */
                public final void mo6097a(C26942j c26942j) {
                    AppMethodBeat.m2504i(94181);
                    HashMap hashMap;
                    switch (c26942j.errCode) {
                        case 0:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(0));
                            c2241c.mo6107M(i, C19333d.this.mo73394j("ok", hashMap));
                            C42484c.m75254kT(92);
                            AppMethodBeat.m2505o(94181);
                            return;
                        default:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(c26942j.errCode));
                            c2241c.mo6107M(i, C19333d.this.mo73394j(c26942j.aIm, hashMap));
                            C42484c.m75254kT(93);
                            AppMethodBeat.m2505o(94181);
                            return;
                    }
                }
            });
            AppMethodBeat.m2505o(94182);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiCloseBLEConnection", "adapter is null or not enabled!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            c2241c.mo6107M(i, mo73394j("fail:not available", hashMap));
            C42484c.m75253cZ(93, 98);
            AppMethodBeat.m2505o(94182);
        }
    }
}
