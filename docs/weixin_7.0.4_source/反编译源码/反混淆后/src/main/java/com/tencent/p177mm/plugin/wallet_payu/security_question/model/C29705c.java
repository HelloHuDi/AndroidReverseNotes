package com.tencent.p177mm.plugin.wallet_payu.security_question.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.security_question.model.c */
public final class C29705c extends C36383a {
    public String cEW;
    /* renamed from: id */
    public String f13719id;
    public String tUL;

    public C29705c() {
        this("");
    }

    public C29705c(String str) {
        AppMethodBeat.m2504i(48570);
        this.cEW = str;
        HashMap hashMap = new HashMap();
        hashMap.put("payu_reference", C5046bo.m7532bc(str, ""));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48570);
    }

    public final int cOX() {
        return 23;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48571);
        this.f13719id = jSONObject.optString("id");
        this.tUL = jSONObject.optString("description");
        AppMethodBeat.m2505o(48571);
    }
}
