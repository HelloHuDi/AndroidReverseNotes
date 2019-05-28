package com.tencent.p177mm.plugin.wallet_payu.balance.p1316a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.balance.a.a */
public final class C43824a extends C36383a {
    public String cuZ;
    public String czZ;
    public double pTN;

    public C43824a(double d, String str) {
        AppMethodBeat.m2504i(48320);
        this.pTN = d;
        this.cuZ = str;
        HashMap hashMap = new HashMap();
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48320);
    }

    public final int cOX() {
        return 20;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48321);
        this.czZ = jSONObject.optString("prepayid");
        AppMethodBeat.m2505o(48321);
    }
}
