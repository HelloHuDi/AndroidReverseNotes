package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.d */
public class C46933d extends C46419bd<C24905d> {
    public final String name() {
        return "batchViewCard";
    }

    public final int biG() {
        return 2;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, final C22841a c22841a) {
        AppMethodBeat.m2504i(6283);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("card_list");
            String optString2 = jSONObject.optString("tempalate_id");
            Intent intent = new Intent();
            intent.putExtra("card_list", optString);
            intent.putExtra("key_template_id", optString2);
            intent.putExtra("key_from_scene", 7);
            ((MMActivity) context).ifE = new C5186a() {
                /* renamed from: c */
                public final void mo6069c(int i, int i2, Intent intent) {
                    AppMethodBeat.m2504i(6282);
                    if (i == (C46933d.this.hashCode() & CdnLogic.kBizGeneric)) {
                        if (i2 == -1) {
                            c22841a.mo26722d(null, null);
                            AppMethodBeat.m2505o(6282);
                            return;
                        }
                        c22841a.mo26722d("fail", null);
                    }
                    AppMethodBeat.m2505o(6282);
                }
            };
            Context context2 = context;
            C25985d.m41453a(context2, "card", ".ui.CardViewEntranceUI", intent, CdnLogic.kBizGeneric & hashCode(), false);
            AppMethodBeat.m2505o(6283);
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.JsApiBatchViewCard", "paras data error: " + e.getMessage());
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6283);
        }
    }
}
