package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.AnonymousClass3;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a<s> {
    public static final int CTRL_INDEX = 86;
    public static final String NAME = "bindPaymentCard";

    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131412);
        final s sVar = (s) cVar;
        if (jSONObject == null) {
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(131412);
            return;
        }
        MMActivity mMActivity = (MMActivity) sVar.ad(MMActivity.class);
        if (mMActivity == null) {
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(131412);
            return;
        }
        try {
            jSONObject.put("appId", sVar.getAppId());
            a aVar = a.hTJ;
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(new b.a() {
                public final void a(int i, String str, Map<String, Object> map) {
                    AppMethodBeat.i(131411);
                    switch (i) {
                        case 1:
                            sVar.M(i, c.this.j("ok", null));
                            AppMethodBeat.o(131411);
                            return;
                        default:
                            sVar.M(i, c.this.j("fail", null));
                            AppMethodBeat.o(131411);
                            return;
                    }
                }
            });
            g gVar = new g(jSONObject);
            gVar.cIg = 4;
            h.b(mMActivity, gVar, aVar.hashCode() & CdnLogic.kBizGeneric, anonymousClass3);
            AppMethodBeat.o(131412);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiBindPaymentCard", e.getMessage());
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(131412);
        }
    }
}
