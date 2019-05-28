package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONObject;

public final class g extends a<q> {
    public static final int CTRL_INDEX = 285;
    public static final String NAME = "requestVirtualPayment";
    boolean hTS = false;

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131420);
        final q qVar = (q) cVar;
        if (jSONObject == null) {
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(131420);
            return;
        }
        Context context = (MMActivity) qVar.ad(MMActivity.class);
        if (context == null) {
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(131420);
        } else if (this.hTS) {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(2));
            ab.e("MicroMsg.JsApiRequestVirtualPayment", "errCode: %d, errMsg: an order is being paid", Integer.valueOf(2));
            qVar.M(i, j("fail an order is being paid", hashMap));
            AppMethodBeat.o(131420);
        } else {
            this.hTS = true;
            AnonymousClass1 anonymousClass1 = new MMActivity.a() {
                public final void c(int i, int i2, Intent intent) {
                    AppMethodBeat.i(131419);
                    if (i != (g.this.hashCode() & CdnLogic.kBizGeneric)) {
                        AppMethodBeat.o(131419);
                        return;
                    }
                    int intExtra;
                    g.this.hTS = false;
                    if (intent != null) {
                        intExtra = intent.getIntExtra("key_err_code", 1);
                    } else {
                        intExtra = 1;
                    }
                    ab.i("MicroMsg.JsApiRequestVirtualPayment", "resultCode:%d,result:%d", Integer.valueOf(i2), Integer.valueOf(intExtra));
                    if (i2 != -1) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(intExtra));
                        qVar.M(i, g.this.j("cancel", hashMap));
                        AppMethodBeat.o(131419);
                    } else if (intExtra == 0) {
                        ab.i("MicroMsg.JsApiRequestVirtualPayment", "requestIAP ok");
                        qVar.M(i, g.this.j("ok", null));
                        AppMethodBeat.o(131419);
                    } else {
                        HashMap hashMap2 = new HashMap();
                        String nullAsNil = bo.nullAsNil(intent.getStringExtra("key_err_msg"));
                        hashMap2.put("errCode", Integer.valueOf(intExtra));
                        ab.i("MicroMsg.JsApiRequestVirtualPayment", "requestVirtualPayment errCode: %d, errMsg: %s", Integer.valueOf(intExtra), nullAsNil);
                        qVar.M(i, g.this.j("fail ".concat(String.valueOf(nullAsNil)), hashMap2));
                        AppMethodBeat.o(131419);
                    }
                }
            };
            Bundle bundle = new Bundle();
            bundle.putInt("scene", 0);
            u currentPageView = qVar.getCurrentPageView();
            if (currentPageView != null) {
                currentPageView.a(2, bundle, new Object[0]);
            } else {
                ab.e("MicroMsg.JsApiRequestVirtualPayment", "hy: associated page view is null!!");
            }
            Intent intent = new Intent();
            ab.i("MicroMsg.JsApiRequestVirtualPayment", "iap payment start ... data : ".concat(String.valueOf(jSONObject)));
            intent.putExtra("key_appid", qVar.getAppId());
            intent.putExtra("key_product_id", jSONObject.optString("priceLevel"));
            intent.putExtra("key_price", jSONObject.optString("priceLevel"));
            intent.putExtra("key_currency_type", jSONObject.optString("currencyType", "CNY"));
            intent.putExtra("key_desc", jSONObject.optString("desc"));
            intent.putExtra("key_count", jSONObject.optInt("count", 1));
            intent.putExtra("key_is_mini_program", true);
            intent.putExtra("key_busiid", jSONObject.optString("outTradeNo"));
            intent.putExtra("key_virtual_pay_sign", jSONObject.optString("virtualPaySign"));
            intent.putExtra("key_attach", jSONObject.optString("attach"));
            context.ifE = anonymousClass1;
            d.b(context, "wallet_index", ".ui.WalletIapUI", intent, hashCode() & CdnLogic.kBizGeneric);
            AppMethodBeat.o(131420);
        }
    }
}
