package com.tencent.p177mm.plugin.wallet_core.model.p1314a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C29630d;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.a.a */
public final class C22580a extends C29630d {
    private static C22580a tDG = null;

    public static C22580a cQY() {
        AppMethodBeat.m2504i(47043);
        if (tDG == null) {
            tDG = new C22580a();
        }
        C22580a c22580a = tDG;
        AppMethodBeat.m2505o(47043);
        return c22580a;
    }

    /* renamed from: ar */
    public final Bankcard mo38120ar(JSONObject jSONObject) {
        AppMethodBeat.m2504i(47044);
        Bankcard ar = super.mo38120ar(jSONObject);
        ar.field_ext_msg = C22581b.m34272aJ(jSONObject);
        ar.field_bankcardClientType = 1;
        ar.field_desc = jSONObject.optString("description");
        ar.field_trueName = jSONObject.optString("name_on_card");
        if ("CREDITCARD_PAYU".equals(jSONObject.optString("bank_type"))) {
            ar.field_cardType |= Bankcard.twG;
        } else {
            ar.field_cardType |= Bankcard.twI;
        }
        AppMethodBeat.m2505o(47044);
        return ar;
    }
}
