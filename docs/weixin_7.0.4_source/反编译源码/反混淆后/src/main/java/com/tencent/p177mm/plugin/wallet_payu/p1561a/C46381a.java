package com.tencent.p177mm.plugin.wallet_payu.p1561a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.a.a */
public final class C46381a extends C36383a {
    public String cEW;
    public boolean qnM;
    public String tTx;
    public String tTy;

    public C46381a(String str, String str2) {
        AppMethodBeat.m2504i(48406);
        this.tTx = str;
        this.cEW = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("otp", str);
        hashMap.put("payu_reference", String.valueOf(str2));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48406);
    }

    public final int cOX() {
        return 4;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48407);
        C4990ab.m7411d("MicroMsg.NetScenePayUComfirmOtp", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", Integer.valueOf(i), str, jSONObject.toString());
        this.qnM = jSONObject.optBoolean("verified");
        this.tTy = jSONObject.optString("payu_reference");
        AppMethodBeat.m2505o(48407);
    }
}
