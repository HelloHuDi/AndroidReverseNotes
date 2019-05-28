package com.tencent.p177mm.plugin.wallet_payu.pwd.p1054a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pwd.a.d */
public final class C22707d extends C36383a {
    public String cEW;
    public String tUr;
    public String tUs;

    public C22707d(String str, String str2) {
        AppMethodBeat.m2504i(48506);
        this.tUr = str;
        this.tUs = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("payu_reference", str);
        hashMap.put("new_pin", str2);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48506);
    }

    public final int cOX() {
        return 19;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48507);
        this.cEW = jSONObject.optString("payu_reference");
        AppMethodBeat.m2505o(48507);
    }
}
