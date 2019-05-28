package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class ae extends a<q> {
    public static final int CTRL_INDEX = 501;
    public static final String NAME = "chooseInvoice";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(130409);
        final q qVar = (q) cVar;
        if (jSONObject == null) {
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(130409);
            return;
        }
        Context context = (MMActivity) qVar.ad(MMActivity.class);
        if (context == null) {
            qVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiChooseInvoice", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(130409);
            return;
        }
        int optInt = jSONObject.optInt("timeStamp");
        String optString = jSONObject.optString("nonceStr");
        String optString2 = jSONObject.optString("signType");
        String optString3 = jSONObject.optString("cardSign");
        Intent intent = new Intent();
        intent.putExtra("app_id", qVar.getAppId());
        intent.putExtra("sign_type", optString2);
        intent.putExtra("card_sign", optString3);
        intent.putExtra("time_stamp", optInt);
        intent.putExtra("nonce_str", optString);
        intent.putExtra("can_multi_select", 1);
        intent.putExtra("card_type", "INVOICE");
        intent.putExtra("key_from_scene", 7);
        context.ifE = new a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(130408);
                ab.d("MicroMsg.JsApiChooseInvoice", "request choose invoice, resultCode = ".concat(String.valueOf(i2)));
                HashMap hashMap = new HashMap();
                if (i2 == -1) {
                    if (intent != null) {
                        hashMap.put("choose_invoice_info", bo.bc(intent.getStringExtra("choose_invoice_info"), ""));
                    }
                    qVar.M(i, ae.this.j("ok", hashMap));
                    ab.i("MicroMsg.JsApiChooseInvoice", "callback ok values = ".concat(String.valueOf(hashMap)));
                    AppMethodBeat.o(130408);
                } else if (i2 == 0) {
                    qVar.M(i, ae.this.j("cancel", null));
                    ab.i("MicroMsg.JsApiChooseInvoice", "callback cancel");
                    AppMethodBeat.o(130408);
                } else {
                    qVar.M(i, ae.this.j("fail", null));
                    ab.i("MicroMsg.JsApiChooseInvoice", "callback fail");
                    AppMethodBeat.o(130408);
                }
            }
        };
        d.a(context, "card", ".ui.CardListSelectedUI", intent, 1, false);
        AppMethodBeat.o(130409);
    }
}
