package com.tencent.p177mm.plugin.wxcredit.p1334a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wxcredit.a.f */
public final class C44026f extends C5749m {
    public C44026f(String str, String str2, String str3) {
        AppMethodBeat.m2504i(48663);
        HashMap hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("passwd", str3);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48663);
    }

    public final int bgI() {
        return 62;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
    }
}
