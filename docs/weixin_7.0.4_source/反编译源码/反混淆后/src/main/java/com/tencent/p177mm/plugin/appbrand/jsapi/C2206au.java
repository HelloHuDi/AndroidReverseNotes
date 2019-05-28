package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.au */
public final class C2206au extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 59;
    public static final String NAME = "openCard";
    int bOs;

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130515);
        final C38492q c38492q = (C38492q) c2241c;
        Intent intent = new Intent();
        Context context = (MMActivity) c38492q.mo61197ad(MMActivity.class);
        if (context == null) {
            c38492q.mo6107M(i, mo73394j("fail", null));
            C4990ab.m7412e("MicroMsg.JsApiOpenCard", "mmActivity is null, invoke fail!");
            AppMethodBeat.m2505o(130515);
            return;
        }
        String optString = jSONObject.optString("cardList");
        if (C5046bo.isNullOrNil(optString)) {
            c38492q.mo6107M(i, mo73394j("fail", null));
            C4990ab.m7412e("MicroMsg.JsApiOpenCard", "cardList is null, invoke fail!");
            AppMethodBeat.m2505o(130515);
            return;
        }
        this.bOs = i;
        context.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(130514);
                if (i == 1) {
                    if (i2 == -1) {
                        c38492q.mo6107M(C2206au.this.bOs, C2206au.this.mo73394j("ok", null));
                        C4990ab.m7416i("MicroMsg.JsApiOpenCard", "view card result is cancel!");
                        AppMethodBeat.m2505o(130514);
                        return;
                    } else if (i2 == 0) {
                        c38492q.mo6107M(C2206au.this.bOs, C2206au.this.mo73394j("cancel", null));
                        C4990ab.m7412e("MicroMsg.JsApiOpenCard", "view card result is cancel!");
                        AppMethodBeat.m2505o(130514);
                        return;
                    } else {
                        c38492q.mo6107M(C2206au.this.bOs, C2206au.this.mo73394j("fail", null));
                        C4990ab.m7412e("MicroMsg.JsApiOpenCard", "view card result is fail!");
                    }
                }
                AppMethodBeat.m2505o(130514);
            }
        };
        intent.putExtra("key_app_id", c38492q.getAppId());
        intent.putExtra("card_list", optString);
        intent.putExtra("key_from_scene", 26);
        C16597h c16597h = (C16597h) c38492q.mo5937aa(C16597h.class);
        if (!(c16597h == null || c16597h.hhd == null)) {
            intent.putExtra("key_from_appbrand_type", c16597h.hhd.gVt);
        }
        C25985d.m41468b(context, "card", ".ui.CardViewEntranceUI", intent, 1);
        AppMethodBeat.m2505o(130515);
    }
}
