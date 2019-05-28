package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.AnonymousClass2;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;
import org.json.JSONObject;

public final class f extends a<s> {
    public static final int CTRL_INDEX = 149;
    public static final String NAME = "requestPaymentToBank";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131418);
        final s sVar = (s) cVar;
        Context context = (MMActivity) sVar.ad(MMActivity.class);
        if (context == null) {
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(131418);
            return;
        }
        try {
            jSONObject.put("appId", sVar.getAppId());
            a aVar = a.hTJ;
            AppBrandStatObject appBrandStatObject = sVar.getRuntime().ya().bQn;
            AnonymousClass1 anonymousClass1 = new b.a() {
                public final void a(int i, String str, Map<String, Object> map) {
                    AppMethodBeat.i(131417);
                    switch (i) {
                        case 1:
                            sVar.M(i, f.this.j("ok", map));
                            AppMethodBeat.o(131417);
                            return;
                        default:
                            sVar.M(i, f.this.j("fail:".concat(String.valueOf(str)), null));
                            AppMethodBeat.o(131417);
                            return;
                    }
                }
            };
            g gVar = new g(jSONObject);
            if (appBrandStatObject != null) {
                gVar.cvS = g.gT(appBrandStatObject.scene, appBrandStatObject.cOo);
                gVar.vwt = g.gS(appBrandStatObject.scene, appBrandStatObject.cOo);
            }
            gVar.cIf = 46;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(anonymousClass1);
            Intent intent = new Intent();
            intent.putExtra("appId", gVar.appId);
            intent.putExtra("timeStamp", gVar.timeStamp);
            intent.putExtra("nonceStr", gVar.nonceStr);
            intent.putExtra("packageExt", gVar.packageExt);
            intent.putExtra("signtype", gVar.signType);
            intent.putExtra("paySignature", gVar.cId);
            intent.putExtra("url", gVar.url);
            intent.putExtra("pay_scene", gVar.cIg);
            context.ifE = anonymousClass2;
            d.a(context, "wallet", ".pay.ui.WalletLoanRepaymentUI", intent, aVar.hashCode() & CdnLogic.kBizGeneric, false);
            AppMethodBeat.o(131418);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiRequestPaymentToBank", e.getMessage());
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(131418);
        }
    }
}
