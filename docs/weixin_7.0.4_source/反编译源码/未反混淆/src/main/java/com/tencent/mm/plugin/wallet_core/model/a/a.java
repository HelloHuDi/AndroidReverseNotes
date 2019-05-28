package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import org.json.JSONObject;

public final class a extends d {
    private static a tDG = null;

    public static a cQY() {
        AppMethodBeat.i(47043);
        if (tDG == null) {
            tDG = new a();
        }
        a aVar = tDG;
        AppMethodBeat.o(47043);
        return aVar;
    }

    public final Bankcard ar(JSONObject jSONObject) {
        AppMethodBeat.i(47044);
        Bankcard ar = super.ar(jSONObject);
        ar.field_ext_msg = b.aJ(jSONObject);
        ar.field_bankcardClientType = 1;
        ar.field_desc = jSONObject.optString("description");
        ar.field_trueName = jSONObject.optString("name_on_card");
        if ("CREDITCARD_PAYU".equals(jSONObject.optString("bank_type"))) {
            ar.field_cardType |= Bankcard.twG;
        } else {
            ar.field_cardType |= Bankcard.twI;
        }
        AppMethodBeat.o(47044);
        return ar;
    }
}
