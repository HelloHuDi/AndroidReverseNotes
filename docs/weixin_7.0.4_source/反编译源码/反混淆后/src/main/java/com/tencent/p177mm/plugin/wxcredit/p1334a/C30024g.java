package com.tencent.p177mm.plugin.wxcredit.p1334a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wxcredit.a.g */
public final class C30024g extends C5749m {
    public String cIe = null;

    public C30024g(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(48664);
        HashMap hashMap = new HashMap();
        hashMap.put("verify_code", str);
        hashMap.put("session_key", str2);
        hashMap.put("passwd", str3);
        hashMap.put("bind_serialno", str4);
        hashMap.put("bank_type", str5);
        mo70323M(hashMap);
        hashMap = new HashMap();
        hashMap.put("banktype", str5);
        mo70328ba(hashMap);
        AppMethodBeat.m2505o(48664);
    }

    public final int bgI() {
        return 65;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48665);
        C4990ab.m7410d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(48665);
            return;
        }
        this.cIe = jSONObject.optString("app_username");
        AppMethodBeat.m2505o(48665);
    }
}
