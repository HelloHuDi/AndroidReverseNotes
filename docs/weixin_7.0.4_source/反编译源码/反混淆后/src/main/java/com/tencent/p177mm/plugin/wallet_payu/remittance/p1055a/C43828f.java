package com.tencent.p177mm.plugin.wallet_payu.remittance.p1055a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.a.f */
public final class C43828f extends C36383a {
    public C43828f(String str, int i, String str2, String str3, int i2) {
        AppMethodBeat.m2504i(48535);
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("total_fee", String.valueOf(i));
        hashMap.put("fee_type", str2);
        hashMap.put("receiver_name", str3);
        hashMap.put("invalid_time", String.valueOf(i2));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48535);
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48536);
        C4990ab.m7410d("MicroMsg.NetScenePayURemitttanceRetry", "errCode " + i + " errMsg: " + str);
        AppMethodBeat.m2505o(48536);
    }

    public final int cOX() {
        return 26;
    }
}
