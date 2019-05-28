package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C38283b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C2237b;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p301c.C26942j;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p898a.p1224a.C42486b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import org.json.JSONObject;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.f */
public final class C19335f extends C10296a {
    private static final int CTRL_INDEX = 180;
    private static final String NAME = "createBLEConnection";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(94185);
        C42484c.m75254kT(25);
        HashMap hashMap;
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiCreateBLEConnection", "createBLEConnection data is null, err");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10013));
            c2241c.mo6107M(i, mo73394j("fail:invalid data", hashMap));
            AppMethodBeat.m2505o(94185);
            return;
        }
        final String appId = c2241c.getAppId();
        C4990ab.m7417i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection data %s", appId, jSONObject.toString());
        C44696b AT = C42483a.m75250AT(c2241c.getAppId());
        if (AT == null) {
            C4990ab.m7412e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is null, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK));
            c2241c.mo6107M(i, mo73394j("fail:not init", hashMap));
            C42484c.m75253cZ(27, 30);
            AppMethodBeat.m2505o(94185);
        } else if (C38283b.aCZ()) {
            boolean optBoolean = jSONObject.optBoolean("debug", false);
            boolean optBoolean2 = jSONObject.optBoolean("mainThread", true);
            boolean optBoolean3 = jSONObject.optBoolean("serial", true);
            long optLong = jSONObject.optLong("timeout", 20000);
            boolean optBoolean4 = jSONObject.optBoolean("autoConnect", false);
            String optString = jSONObject.optString("transport", "LE");
            String optString2 = jSONObject.optString("deviceId");
            C42486b c42486b = new C42486b(optString2);
            c42486b.aJe = optBoolean;
            c42486b.hDP = optBoolean2;
            c42486b.hDR = optBoolean3;
            c42486b.hEx = optLong;
            c42486b.hEo = optBoolean4;
            c42486b.hEp = optString;
            AT.mo71732a(optString2, c42486b, new C2237b() {
                /* renamed from: a */
                public final void mo6097a(C26942j c26942j) {
                    AppMethodBeat.m2504i(94184);
                    C4990ab.m7417i("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection result:%s", appId, c26942j);
                    HashMap hashMap;
                    switch (c26942j.errCode) {
                        case 0:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(0));
                            c2241c.mo6107M(i, C19335f.this.mo73394j("ok", hashMap));
                            C42484c.m75254kT(26);
                            AppMethodBeat.m2505o(94184);
                            return;
                        default:
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(c26942j.errCode));
                            c2241c.mo6107M(i, C19335f.this.mo73394j(c26942j.aIm, hashMap));
                            C42484c.m75254kT(27);
                            AppMethodBeat.m2505o(94184);
                            return;
                    }
                }
            });
            AppMethodBeat.m2505o(94185);
        } else {
            C4990ab.m7412e("MicroMsg.JsApiCreateBLEConnection", "bleWorker is disable, may not open ble");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(10001));
            c2241c.mo6107M(i, mo73394j("fail:not available", hashMap));
            C42484c.m75253cZ(27, 32);
            AppMethodBeat.m2505o(94185);
        }
    }
}
