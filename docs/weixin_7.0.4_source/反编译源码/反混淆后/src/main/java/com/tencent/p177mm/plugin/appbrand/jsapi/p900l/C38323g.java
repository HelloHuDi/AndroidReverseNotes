package com.tencent.p177mm.plugin.appbrand.jsapi.p900l;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.g */
public final class C38323g extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 285;
    public static final String NAME = "requestVirtualPayment";
    boolean hTS = false;

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131420);
        final C38492q c38492q = (C38492q) c2241c;
        if (jSONObject == null) {
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131420);
            return;
        }
        Context context = (MMActivity) c38492q.mo61197ad(MMActivity.class);
        if (context == null) {
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131420);
        } else if (this.hTS) {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(2));
            C4990ab.m7413e("MicroMsg.JsApiRequestVirtualPayment", "errCode: %d, errMsg: an order is being paid", Integer.valueOf(2));
            c38492q.mo6107M(i, mo73394j("fail an order is being paid", hashMap));
            AppMethodBeat.m2505o(131420);
        } else {
            this.hTS = true;
            C104471 c104471 = new C5186a() {
                /* renamed from: c */
                public final void mo6069c(int i, int i2, Intent intent) {
                    AppMethodBeat.m2504i(131419);
                    if (i != (C38323g.this.hashCode() & CdnLogic.kBizGeneric)) {
                        AppMethodBeat.m2505o(131419);
                        return;
                    }
                    int intExtra;
                    C38323g.this.hTS = false;
                    if (intent != null) {
                        intExtra = intent.getIntExtra("key_err_code", 1);
                    } else {
                        intExtra = 1;
                    }
                    C4990ab.m7417i("MicroMsg.JsApiRequestVirtualPayment", "resultCode:%d,result:%d", Integer.valueOf(i2), Integer.valueOf(intExtra));
                    if (i2 != -1) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(intExtra));
                        c38492q.mo6107M(i, C38323g.this.mo73394j("cancel", hashMap));
                        AppMethodBeat.m2505o(131419);
                    } else if (intExtra == 0) {
                        C4990ab.m7416i("MicroMsg.JsApiRequestVirtualPayment", "requestIAP ok");
                        c38492q.mo6107M(i, C38323g.this.mo73394j("ok", null));
                        AppMethodBeat.m2505o(131419);
                    } else {
                        HashMap hashMap2 = new HashMap();
                        String nullAsNil = C5046bo.nullAsNil(intent.getStringExtra("key_err_msg"));
                        hashMap2.put("errCode", Integer.valueOf(intExtra));
                        C4990ab.m7417i("MicroMsg.JsApiRequestVirtualPayment", "requestVirtualPayment errCode: %d, errMsg: %s", Integer.valueOf(intExtra), nullAsNil);
                        c38492q.mo6107M(i, C38323g.this.mo73394j("fail ".concat(String.valueOf(nullAsNil)), hashMap2));
                        AppMethodBeat.m2505o(131419);
                    }
                }
            };
            Bundle bundle = new Bundle();
            bundle.putInt("scene", 0);
            C44709u currentPageView = c38492q.getCurrentPageView();
            if (currentPageView != null) {
                currentPageView.mo53736a(2, bundle, new Object[0]);
            } else {
                C4990ab.m7412e("MicroMsg.JsApiRequestVirtualPayment", "hy: associated page view is null!!");
            }
            Intent intent = new Intent();
            C4990ab.m7416i("MicroMsg.JsApiRequestVirtualPayment", "iap payment start ... data : ".concat(String.valueOf(jSONObject)));
            intent.putExtra("key_appid", c38492q.getAppId());
            intent.putExtra("key_product_id", jSONObject.optString("priceLevel"));
            intent.putExtra("key_price", jSONObject.optString("priceLevel"));
            intent.putExtra("key_currency_type", jSONObject.optString("currencyType", "CNY"));
            intent.putExtra("key_desc", jSONObject.optString("desc"));
            intent.putExtra("key_count", jSONObject.optInt("count", 1));
            intent.putExtra("key_is_mini_program", true);
            intent.putExtra("key_busiid", jSONObject.optString("outTradeNo"));
            intent.putExtra("key_virtual_pay_sign", jSONObject.optString("virtualPaySign"));
            intent.putExtra("key_attach", jSONObject.optString("attach"));
            context.ifE = c104471;
            C25985d.m41468b(context, "wallet_index", ".ui.WalletIapUI", intent, hashCode() & CdnLogic.kBizGeneric);
            AppMethodBeat.m2505o(131420);
        }
    }
}
