package com.tencent.p177mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.C19456a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.c */
public final class C33379c extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 354;
    public static final String NAME = "sendHCEMessage";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, final JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(137870);
        mo34590a(new C19456a() {
            /* renamed from: T */
            public final void mo34591T(int i, String str) {
                AppMethodBeat.m2504i(137869);
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i));
                if (i == 0) {
                    C33379c c33379c = C33379c.this;
                    C2241c c2241c = c2241c;
                    int i2 = i;
                    JSONObject jSONObject = jSONObject;
                    HashMap hashMap2 = new HashMap();
                    String optString = jSONObject.optString("data");
                    if (C5046bo.isNullOrNil(optString)) {
                        hashMap2.put("errCode", Integer.valueOf(13005));
                        C33379c.m54571a(c2241c, i2, c33379c.mo73394j("fail", hashMap2));
                        AppMethodBeat.m2505o(137869);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("key_apdu_command", optString);
                    HCEEventLogic.m75350a(c2241c.getAppId(), 32, bundle);
                    hashMap2.put("errCode", Integer.valueOf(0));
                    c2241c.mo6107M(i2, c33379c.mo73394j("ok", hashMap2));
                    AppMethodBeat.m2505o(137869);
                    return;
                }
                C33379c.m54571a(c2241c, i, C33379c.this.mo73394j("fail: ".concat(String.valueOf(str)), hashMap));
                AppMethodBeat.m2505o(137869);
            }
        });
        AppMethodBeat.m2505o(137870);
    }

    /* renamed from: a */
    static void m54571a(C2241c c2241c, int i, String str) {
        AppMethodBeat.m2504i(137871);
        C4990ab.m7417i("MicroMsg.JsApiNFCSendHCEResponseCommand", "alvinluo sendHCEMessage callback json: %s", str);
        if (c2241c != null) {
            c2241c.mo6107M(i, str);
        }
        AppMethodBeat.m2505o(137871);
    }
}
