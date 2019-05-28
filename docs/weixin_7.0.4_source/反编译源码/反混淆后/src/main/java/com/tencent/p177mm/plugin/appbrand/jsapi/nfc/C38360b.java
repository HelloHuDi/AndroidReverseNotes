package com.tencent.p177mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.C19456a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.b */
public final class C38360b extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 358;
    public static final String NAME = "getHCEState";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(137868);
        mo34590a(new C19456a() {
            /* renamed from: T */
            public final void mo34591T(int i, String str) {
                AppMethodBeat.m2504i(137867);
                C4990ab.m7417i("MicroMsg.JsApiGetHCEState", "alvinluo checkIsSupport onResult errCode: %d, errMsg: %s", Integer.valueOf(i), str);
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i));
                if (i == 0) {
                    c2241c.mo6107M(i, C38360b.this.mo73394j("ok", hashMap));
                    AppMethodBeat.m2505o(137867);
                    return;
                }
                c2241c.mo6107M(i, C38360b.this.mo73394j("fail ".concat(String.valueOf(str)), hashMap));
                AppMethodBeat.m2505o(137867);
            }
        });
        AppMethodBeat.m2505o(137868);
    }
}
