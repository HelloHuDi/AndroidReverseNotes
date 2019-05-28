package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends bd<com.tencent.mm.plugin.webview.luggage.d> {
    public final String name() {
        return "batchViewCard";
    }

    public final int biG() {
        return 2;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, final bc.a aVar) {
        AppMethodBeat.i(6283);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("card_list");
            String optString2 = jSONObject.optString("tempalate_id");
            Intent intent = new Intent();
            intent.putExtra("card_list", optString);
            intent.putExtra("key_template_id", optString2);
            intent.putExtra("key_from_scene", 7);
            ((MMActivity) context).ifE = new MMActivity.a() {
                public final void c(int i, int i2, Intent intent) {
                    AppMethodBeat.i(6282);
                    if (i == (d.this.hashCode() & CdnLogic.kBizGeneric)) {
                        if (i2 == -1) {
                            aVar.d(null, null);
                            AppMethodBeat.o(6282);
                            return;
                        }
                        aVar.d("fail", null);
                    }
                    AppMethodBeat.o(6282);
                }
            };
            Context context2 = context;
            com.tencent.mm.bp.d.a(context2, "card", ".ui.CardViewEntranceUI", intent, CdnLogic.kBizGeneric & hashCode(), false);
            AppMethodBeat.o(6283);
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiBatchViewCard", "paras data error: " + e.getMessage());
            aVar.d("fail", null);
            AppMethodBeat.o(6283);
        }
    }
}
