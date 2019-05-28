package com.tencent.p177mm.plugin.wallet_payu.p1561a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.a.b */
public final class C40156b extends C36383a {
    public String cEW;
    public String tTb;
    public String tTc;
    public boolean tTz;

    public C40156b(String str, String str2) {
        AppMethodBeat.m2504i(48408);
        this.tTb = str;
        this.tTc = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", String.valueOf(str2));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48408);
    }

    public final int cOX() {
        return 12;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48409);
        C4990ab.m7411d("MicroMsg.NetScenePayUGenerateOtp", "hy: get NetScenePayUGenerateOtp info. errCode: %d, errMsg:%s, json:%s", Integer.valueOf(i), str, jSONObject.toString());
        this.tTz = jSONObject.optBoolean("has_mobile");
        this.cEW = jSONObject.optString("payu_reference");
        AppMethodBeat.m2505o(48409);
    }
}
