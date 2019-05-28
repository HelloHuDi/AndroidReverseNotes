package com.tencent.p177mm.plugin.wxcredit.p1334a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wxcredit.a.h */
public final class C23210h extends C5749m {
    public C23210h(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(48666);
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
        AppMethodBeat.m2505o(48666);
    }

    public final int bgI() {
        return 66;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48667);
        C4990ab.m7410d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        AppMethodBeat.m2505o(48667);
    }
}
