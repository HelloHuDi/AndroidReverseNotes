package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.l.b.b;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONObject;

public final class i extends a<s> {
    public static final int CTRL_INDEX = 85;
    public static final String NAME = "verifyPaymentPassword";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131424);
        final s sVar = (s) cVar;
        if (jSONObject == null) {
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(131424);
            return;
        }
        MMActivity mMActivity = (MMActivity) sVar.ad(MMActivity.class);
        if (mMActivity == null) {
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(131424);
            return;
        }
        try {
            jSONObject.put("appId", sVar.getAppId());
            a.hTJ.a(mMActivity, jSONObject, new b() {
                public final void h(boolean z, String str) {
                    AppMethodBeat.i(131423);
                    if (z) {
                        HashMap hashMap = new HashMap(1);
                        hashMap.put("token", str);
                        sVar.M(i, i.this.j("ok", hashMap));
                        AppMethodBeat.o(131423);
                        return;
                    }
                    sVar.M(i, i.this.j("fail", null));
                    AppMethodBeat.o(131423);
                }
            });
            AppMethodBeat.o(131424);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiVerifyPaymentPassword", e.getMessage());
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(131424);
        }
    }
}
