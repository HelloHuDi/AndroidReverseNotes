package com.tencent.p177mm.plugin.wallet_payu.create.p1317a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.create.a.b */
public final class C40157b extends C36383a {
    public String cEW;
    public String cMQ;
    public String pin;
    public String tTb;

    public final int cOX() {
        return 17;
    }

    public C40157b(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(48371);
        this.tTb = str;
        this.cMQ = str2;
        this.pin = str3;
        this.cEW = str4;
        HashMap hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", str2);
        hashMap.put("pin", str3);
        hashMap.put("payu_reference", str4);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48371);
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
    }
}
