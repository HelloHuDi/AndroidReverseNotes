package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ae */
public final class C19283ae extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 501;
    public static final String NAME = "chooseInvoice";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(130409);
        final C38492q c38492q = (C38492q) c2241c;
        if (jSONObject == null) {
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(130409);
            return;
        }
        Context context = (MMActivity) c38492q.mo61197ad(MMActivity.class);
        if (context == null) {
            c38492q.mo6107M(i, mo73394j("fail", null));
            C4990ab.m7412e("MicroMsg.JsApiChooseInvoice", "mmActivity is null, invoke fail!");
            AppMethodBeat.m2505o(130409);
            return;
        }
        int optInt = jSONObject.optInt("timeStamp");
        String optString = jSONObject.optString("nonceStr");
        String optString2 = jSONObject.optString("signType");
        String optString3 = jSONObject.optString("cardSign");
        Intent intent = new Intent();
        intent.putExtra("app_id", c38492q.getAppId());
        intent.putExtra("sign_type", optString2);
        intent.putExtra("card_sign", optString3);
        intent.putExtra("time_stamp", optInt);
        intent.putExtra("nonce_str", optString);
        intent.putExtra("can_multi_select", 1);
        intent.putExtra("card_type", "INVOICE");
        intent.putExtra("key_from_scene", 7);
        context.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(130408);
                C4990ab.m7410d("MicroMsg.JsApiChooseInvoice", "request choose invoice, resultCode = ".concat(String.valueOf(i2)));
                HashMap hashMap = new HashMap();
                if (i2 == -1) {
                    if (intent != null) {
                        hashMap.put("choose_invoice_info", C5046bo.m7532bc(intent.getStringExtra("choose_invoice_info"), ""));
                    }
                    c38492q.mo6107M(i, C19283ae.this.mo73394j("ok", hashMap));
                    C4990ab.m7416i("MicroMsg.JsApiChooseInvoice", "callback ok values = ".concat(String.valueOf(hashMap)));
                    AppMethodBeat.m2505o(130408);
                } else if (i2 == 0) {
                    c38492q.mo6107M(i, C19283ae.this.mo73394j("cancel", null));
                    C4990ab.m7416i("MicroMsg.JsApiChooseInvoice", "callback cancel");
                    AppMethodBeat.m2505o(130408);
                } else {
                    c38492q.mo6107M(i, C19283ae.this.mo73394j("fail", null));
                    C4990ab.m7416i("MicroMsg.JsApiChooseInvoice", "callback fail");
                    AppMethodBeat.m2505o(130408);
                }
            }
        };
        C25985d.m41453a(context, "card", ".ui.CardListSelectedUI", intent, 1, false);
        AppMethodBeat.m2505o(130409);
    }
}
