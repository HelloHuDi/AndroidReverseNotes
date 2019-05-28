package com.tencent.p177mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.remittance.model.t */
public final class C39602t extends C5749m {
    public C39602t(String str, String str2) {
        AppMethodBeat.m2504i(44767);
        HashMap hashMap = new HashMap();
        hashMap.put("receiver_user_name", str);
        hashMap.put("transfer_qrcode_id", str2);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(44767);
    }

    public C39602t(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(44768);
        HashMap hashMap = new HashMap();
        hashMap.put("receiver_user_name", str);
        hashMap.put("transfer_qrcode_id", str2);
        hashMap.put("rcvr_ticket", str3);
        hashMap.put("receiver_openid", str4);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(44768);
    }

    public final int bgI() {
        return 0;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1535;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfersendcancelf2f";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(44769);
        C4990ab.m7410d("MicroMsg.NetSenceTenPayBase", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(44769);
        } else {
            AppMethodBeat.m2505o(44769);
        }
    }
}
