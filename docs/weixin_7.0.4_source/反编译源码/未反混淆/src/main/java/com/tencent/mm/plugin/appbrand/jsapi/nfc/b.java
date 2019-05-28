package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 358;
    public static final String NAME = "getHCEState";

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(137868);
        a(new a() {
            public final void T(int i, String str) {
                AppMethodBeat.i(137867);
                ab.i("MicroMsg.JsApiGetHCEState", "alvinluo checkIsSupport onResult errCode: %d, errMsg: %s", Integer.valueOf(i), str);
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i));
                if (i == 0) {
                    cVar.M(i, b.this.j("ok", hashMap));
                    AppMethodBeat.o(137867);
                    return;
                }
                cVar.M(i, b.this.j("fail ".concat(String.valueOf(str)), hashMap));
                AppMethodBeat.o(137867);
            }
        });
        AppMethodBeat.o(137868);
    }
}
