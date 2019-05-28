package com.tencent.p177mm.plugin.appbrand.jsapi.p900l;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C10443b.C10444a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C42531a.C383222;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.pluginsdk.wallet.C40493g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.f */
public final class C27017f extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 149;
    public static final String NAME = "requestPaymentToBank";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131418);
        final C19722s c19722s = (C19722s) c2241c;
        Context context = (MMActivity) c19722s.mo61197ad(MMActivity.class);
        if (context == null) {
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131418);
            return;
        }
        try {
            jSONObject.put("appId", c19722s.getAppId());
            C42531a c42531a = C42531a.hTJ;
            AppBrandStatObject appBrandStatObject = c19722s.getRuntime().mo43491ya().bQn;
            C270181 c270181 = new C10444a() {
                /* renamed from: a */
                public final void mo21960a(int i, String str, Map<String, Object> map) {
                    AppMethodBeat.m2504i(131417);
                    switch (i) {
                        case 1:
                            c19722s.mo6107M(i, C27017f.this.mo73394j("ok", map));
                            AppMethodBeat.m2505o(131417);
                            return;
                        default:
                            c19722s.mo6107M(i, C27017f.this.mo73394j("fail:".concat(String.valueOf(str)), null));
                            AppMethodBeat.m2505o(131417);
                            return;
                    }
                }
            };
            C40493g c40493g = new C40493g(jSONObject);
            if (appBrandStatObject != null) {
                c40493g.cvS = C40493g.m69626gT(appBrandStatObject.scene, appBrandStatObject.cOo);
                c40493g.vwt = C40493g.m69625gS(appBrandStatObject.scene, appBrandStatObject.cOo);
            }
            c40493g.cIf = 46;
            C383222 c383222 = new C383222(c270181);
            Intent intent = new Intent();
            intent.putExtra("appId", c40493g.appId);
            intent.putExtra("timeStamp", c40493g.timeStamp);
            intent.putExtra("nonceStr", c40493g.nonceStr);
            intent.putExtra("packageExt", c40493g.packageExt);
            intent.putExtra("signtype", c40493g.signType);
            intent.putExtra("paySignature", c40493g.cId);
            intent.putExtra("url", c40493g.url);
            intent.putExtra("pay_scene", c40493g.cIg);
            context.ifE = c383222;
            C25985d.m41453a(context, "wallet", ".pay.ui.WalletLoanRepaymentUI", intent, c42531a.hashCode() & CdnLogic.kBizGeneric, false);
            AppMethodBeat.m2505o(131418);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.JsApiRequestPaymentToBank", e.getMessage());
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131418);
        }
    }
}
