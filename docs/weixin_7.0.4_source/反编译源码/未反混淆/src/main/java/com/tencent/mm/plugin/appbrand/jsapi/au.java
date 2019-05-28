package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONObject;

public final class au extends a<q> {
    public static final int CTRL_INDEX = 59;
    public static final String NAME = "openCard";
    int bOs;

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130515);
        final q qVar = (q) cVar;
        Intent intent = new Intent();
        Context context = (MMActivity) qVar.ad(MMActivity.class);
        if (context == null) {
            qVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiOpenCard", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(130515);
            return;
        }
        String optString = jSONObject.optString("cardList");
        if (bo.isNullOrNil(optString)) {
            qVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiOpenCard", "cardList is null, invoke fail!");
            AppMethodBeat.o(130515);
            return;
        }
        this.bOs = i;
        context.ifE = new a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(130514);
                if (i == 1) {
                    if (i2 == -1) {
                        qVar.M(au.this.bOs, au.this.j("ok", null));
                        ab.i("MicroMsg.JsApiOpenCard", "view card result is cancel!");
                        AppMethodBeat.o(130514);
                        return;
                    } else if (i2 == 0) {
                        qVar.M(au.this.bOs, au.this.j("cancel", null));
                        ab.e("MicroMsg.JsApiOpenCard", "view card result is cancel!");
                        AppMethodBeat.o(130514);
                        return;
                    } else {
                        qVar.M(au.this.bOs, au.this.j("fail", null));
                        ab.e("MicroMsg.JsApiOpenCard", "view card result is fail!");
                    }
                }
                AppMethodBeat.o(130514);
            }
        };
        intent.putExtra("key_app_id", qVar.getAppId());
        intent.putExtra("card_list", optString);
        intent.putExtra("key_from_scene", 26);
        h hVar = (h) qVar.aa(h.class);
        if (!(hVar == null || hVar.hhd == null)) {
            intent.putExtra("key_from_appbrand_type", hVar.hhd.gVt);
        }
        d.b(context, "card", ".ui.CardViewEntranceUI", intent, 1);
        AppMethodBeat.o(130515);
    }
}
