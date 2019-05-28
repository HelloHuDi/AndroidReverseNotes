package com.tencent.p177mm.plugin.wallet_payu.security_question.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.model.d */
public final class C43830d extends C36383a {
    public ArrayList<PayUSecurityQuestion> tUM;

    public C43830d() {
        AppMethodBeat.m2504i(48572);
        mo70323M(new HashMap());
        AppMethodBeat.m2505o(48572);
    }

    public final int cOX() {
        return 11;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48573);
        if (jSONObject != null) {
            this.tUM = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("security_question_list");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        this.tUM.add(new PayUSecurityQuestion(optJSONObject.optString("id"), optJSONObject.optString("description")));
                    }
                }
            }
        }
        AppMethodBeat.m2505o(48573);
    }
}
