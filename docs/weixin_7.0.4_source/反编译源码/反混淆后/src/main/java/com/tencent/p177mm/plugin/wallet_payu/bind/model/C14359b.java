package com.tencent.p177mm.plugin.wallet_payu.bind.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.bind.model.b */
public final class C14359b extends C36383a {
    public String cEW;
    public String tSI;

    public C14359b(String str, String str2) {
        AppMethodBeat.m2504i(48337);
        this.tSI = str;
        this.cEW = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("bind_serial", str);
        hashMap.put("payu_reference", String.valueOf(str2));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48337);
    }

    public final int cOX() {
        return 6;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
    }
}
