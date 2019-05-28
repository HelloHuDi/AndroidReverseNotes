package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aa extends a<h> {
    public static final int CTRL_INDEX = 58;
    public static final String NAME = "addCard";
    int bOs;

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130374);
        final h hVar = (h) cVar;
        Intent intent = new Intent();
        if (hVar.getContext() instanceof MMActivity) {
            Context context = (MMActivity) hVar.getContext();
            String optString = jSONObject.optString("cardList");
            if (bo.isNullOrNil(optString)) {
                hVar.M(i, j("fail:invalid data", null));
                ab.e("MicroMsg.JsApiAddCard", "cardList is null, invoke fail!");
                AppMethodBeat.o(130374);
                return;
            }
            this.bOs = i;
            context.ifE = new a() {
                public final void c(int i, int i2, Intent intent) {
                    AppMethodBeat.i(130373);
                    if (i == 1) {
                        if (i2 == -1) {
                            if (intent == null) {
                                hVar.M(aa.this.bOs, aa.this.j("fail:internal error", null));
                                ab.e("MicroMsg.JsApiAddCard", "location result is empty!");
                                AppMethodBeat.o(130373);
                                return;
                            }
                            Object jSONArray;
                            HashMap hashMap = new HashMap();
                            ab.d("MicroMsg.JsApiAddCard", "mmSetOnActivityResultCallback cardList:%s", intent.getStringExtra("card_list"));
                            try {
                                jSONArray = new JSONArray(intent.getStringExtra("card_list"));
                            } catch (JSONException e) {
                                ab.e("MicroMsg.JsApiAddCard", "parse fail result:%s", bo.l(e));
                                jSONArray = null;
                            }
                            if (jSONArray != null) {
                                hashMap.put("cardList", jSONArray);
                                hVar.M(aa.this.bOs, aa.this.j("ok", hashMap));
                                AppMethodBeat.o(130373);
                                return;
                            }
                            hVar.M(aa.this.bOs, aa.this.j("fail: cardList is empty", hashMap));
                            ab.e("MicroMsg.JsApiAddCard", "add card result is fail! cardList is empty");
                            AppMethodBeat.o(130373);
                            return;
                        } else if (i2 == 0) {
                            hVar.M(aa.this.bOs, aa.this.j("cancel", null));
                            ab.e("MicroMsg.JsApiAddCard", "add card result is cancel!");
                            AppMethodBeat.o(130373);
                            return;
                        } else {
                            int intExtra;
                            if (intent != null) {
                                intExtra = intent.getIntExtra("result_code", 2);
                            } else {
                                intExtra = 2;
                            }
                            ab.i("MicroMsg.JsApiAddCard", "mmSetOnActivityResultCallback ret_code:%d", Integer.valueOf(intExtra));
                            if (intExtra == 2) {
                                hVar.M(aa.this.bOs, aa.this.j("fail:internal error", null));
                                AppMethodBeat.o(130373);
                                return;
                            }
                            hVar.M(aa.this.bOs, aa.this.j("cancel", null));
                        }
                    }
                    AppMethodBeat.o(130373);
                }
            };
            intent.putExtra("key_in_card_list", optString);
            intent.putExtra("key_from_scene", 26);
            h ye = hVar.getRuntime().ye();
            if (!(ye == null || ye.hhd == null)) {
                intent.putExtra("key_from_appbrand_type", ye.hhd.gVt);
            }
            d.b(context, "card", ".ui.CardAddEntranceUI", intent, 1);
            AppMethodBeat.o(130374);
            return;
        }
        hVar.M(i, j("fail:internal error invalid android context", null));
        ab.e("MicroMsg.JsApiAddCard", "mmActivity is null, invoke fail!");
        AppMethodBeat.o(130374);
    }
}
