package com.tencent.p177mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.C19456a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.e */
public final class C38361e extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 353;
    public static final String NAME = "stopHCE";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(137882);
        mo34590a(new C19456a() {
            /* renamed from: T */
            public final void mo34591T(int i, String str) {
                AppMethodBeat.m2504i(137881);
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i));
                if (i == 0) {
                    C38361e c38361e = C38361e.this;
                    C2241c c2241c = c2241c;
                    int i2 = i;
                    HCEEventLogic.m75349BF(c2241c.getAppId());
                    HCEEventLogic.m75350a(c2241c.getAppId(), 13, null);
                    HashMap hashMap2 = new HashMap(2);
                    hashMap2.put("errCode", Integer.valueOf(0));
                    C38361e.m64927a(c2241c, i2, c38361e.mo73394j("ok", hashMap2));
                    AppMethodBeat.m2505o(137881);
                    return;
                }
                C38361e.m64927a(c2241c, i, C38361e.this.mo73394j("fail: ".concat(String.valueOf(str)), hashMap));
                AppMethodBeat.m2505o(137881);
            }
        });
        AppMethodBeat.m2505o(137882);
    }

    /* renamed from: a */
    static void m64927a(C2241c c2241c, int i, String str) {
        AppMethodBeat.m2504i(137883);
        C4990ab.m7417i("MicroMsg.JsApiNFCStartHCE", "alvinluo stopHCE callback result: %s", str);
        if (c2241c != null) {
            c2241c.mo6107M(i, str);
        }
        AppMethodBeat.m2505o(137883);
    }
}
