package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.aa */
public final class C42464aa extends C10296a<C33327h> {
    public static final int CTRL_INDEX = 58;
    public static final String NAME = "addCard";
    int bOs;

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130374);
        final C33327h c33327h = (C33327h) c2241c;
        Intent intent = new Intent();
        if (c33327h.getContext() instanceof MMActivity) {
            Context context = (MMActivity) c33327h.getContext();
            String optString = jSONObject.optString("cardList");
            if (C5046bo.isNullOrNil(optString)) {
                c33327h.mo6107M(i, mo73394j("fail:invalid data", null));
                C4990ab.m7412e("MicroMsg.JsApiAddCard", "cardList is null, invoke fail!");
                AppMethodBeat.m2505o(130374);
                return;
            }
            this.bOs = i;
            context.ifE = new C5186a() {
                /* renamed from: c */
                public final void mo6069c(int i, int i2, Intent intent) {
                    AppMethodBeat.m2504i(130373);
                    if (i == 1) {
                        if (i2 == -1) {
                            if (intent == null) {
                                c33327h.mo6107M(C42464aa.this.bOs, C42464aa.this.mo73394j("fail:internal error", null));
                                C4990ab.m7412e("MicroMsg.JsApiAddCard", "location result is empty!");
                                AppMethodBeat.m2505o(130373);
                                return;
                            }
                            Object jSONArray;
                            HashMap hashMap = new HashMap();
                            C4990ab.m7411d("MicroMsg.JsApiAddCard", "mmSetOnActivityResultCallback cardList:%s", intent.getStringExtra("card_list"));
                            try {
                                jSONArray = new JSONArray(intent.getStringExtra("card_list"));
                            } catch (JSONException e) {
                                C4990ab.m7413e("MicroMsg.JsApiAddCard", "parse fail result:%s", C5046bo.m7574l(e));
                                jSONArray = null;
                            }
                            if (jSONArray != null) {
                                hashMap.put("cardList", jSONArray);
                                c33327h.mo6107M(C42464aa.this.bOs, C42464aa.this.mo73394j("ok", hashMap));
                                AppMethodBeat.m2505o(130373);
                                return;
                            }
                            c33327h.mo6107M(C42464aa.this.bOs, C42464aa.this.mo73394j("fail: cardList is empty", hashMap));
                            C4990ab.m7412e("MicroMsg.JsApiAddCard", "add card result is fail! cardList is empty");
                            AppMethodBeat.m2505o(130373);
                            return;
                        } else if (i2 == 0) {
                            c33327h.mo6107M(C42464aa.this.bOs, C42464aa.this.mo73394j("cancel", null));
                            C4990ab.m7412e("MicroMsg.JsApiAddCard", "add card result is cancel!");
                            AppMethodBeat.m2505o(130373);
                            return;
                        } else {
                            int intExtra;
                            if (intent != null) {
                                intExtra = intent.getIntExtra("result_code", 2);
                            } else {
                                intExtra = 2;
                            }
                            C4990ab.m7417i("MicroMsg.JsApiAddCard", "mmSetOnActivityResultCallback ret_code:%d", Integer.valueOf(intExtra));
                            if (intExtra == 2) {
                                c33327h.mo6107M(C42464aa.this.bOs, C42464aa.this.mo73394j("fail:internal error", null));
                                AppMethodBeat.m2505o(130373);
                                return;
                            }
                            c33327h.mo6107M(C42464aa.this.bOs, C42464aa.this.mo73394j("cancel", null));
                        }
                    }
                    AppMethodBeat.m2505o(130373);
                }
            };
            intent.putExtra("key_in_card_list", optString);
            intent.putExtra("key_from_scene", 26);
            C16597h ye = c33327h.getRuntime().mo15034ye();
            if (!(ye == null || ye.hhd == null)) {
                intent.putExtra("key_from_appbrand_type", ye.hhd.gVt);
            }
            C25985d.m41468b(context, "card", ".ui.CardAddEntranceUI", intent, 1);
            AppMethodBeat.m2505o(130374);
            return;
        }
        c33327h.mo6107M(i, mo73394j("fail:internal error invalid android context", null));
        C4990ab.m7412e("MicroMsg.JsApiAddCard", "mmActivity is null, invoke fail!");
        AppMethodBeat.m2505o(130374);
    }
}
