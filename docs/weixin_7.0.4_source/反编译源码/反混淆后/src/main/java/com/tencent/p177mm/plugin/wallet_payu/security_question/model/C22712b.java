package com.tencent.p177mm.plugin.wallet_payu.security_question.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.model.b */
public final class C22712b extends C36383a {
    public String cEW;
    /* renamed from: id */
    public String f4402id;
    public boolean lSP;
    public String nYb;
    public String tUK;

    public C22712b(String str, String str2, String str3) {
        AppMethodBeat.m2504i(48568);
        this.f4402id = str2;
        this.nYb = str3;
        this.cEW = str;
        HashMap hashMap = new HashMap();
        hashMap.put("id", str2);
        hashMap.put("answer", str3);
        hashMap.put("payu_reference", str);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48568);
    }

    public final int cOX() {
        return 18;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48569);
        this.lSP = jSONObject.optBoolean("verified");
        this.tUK = jSONObject.optString("payu_reference");
        AppMethodBeat.m2505o(48569);
    }
}
