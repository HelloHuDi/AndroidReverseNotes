package com.tencent.p177mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.remittance.model.x */
public final class C7040x extends C5749m {
    public C7040x(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(44788);
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("transfer_id", str2);
        hashMap.put("receiver_name", str3);
        hashMap.put("from", String.valueOf(i2));
        hashMap.put("invalid_time", String.valueOf(i));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(44788);
    }

    public final int bgI() {
        return 0;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1545;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferresendmsg";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(44789);
        C4990ab.m7410d("Micromsg.NetSceneTenpayRemittanceResendMsg", "errCode " + i + " errMsg: " + str);
        AppMethodBeat.m2505o(44789);
    }
}
