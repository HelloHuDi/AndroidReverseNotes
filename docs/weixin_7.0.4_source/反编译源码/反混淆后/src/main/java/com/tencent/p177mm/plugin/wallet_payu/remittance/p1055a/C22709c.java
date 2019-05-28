package com.tencent.p177mm.plugin.wallet_payu.remittance.p1055a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.a.c */
public final class C22709c extends C36383a {
    public C22709c(String str, int i, String str2, String str3) {
        AppMethodBeat.m2504i(48529);
        HashMap hashMap = new HashMap();
        hashMap.put("req_key", str);
        hashMap.put("total_fee", String.valueOf(i));
        hashMap.put("fee_type", str2);
        hashMap.put("to_customer_name", str3);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48529);
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48530);
        C4990ab.m7410d("MicroMsg.NetScenePayURemittanceConfirm", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(48530);
        } else {
            AppMethodBeat.m2505o(48530);
        }
    }

    public final int cOX() {
        return 15;
    }
}
