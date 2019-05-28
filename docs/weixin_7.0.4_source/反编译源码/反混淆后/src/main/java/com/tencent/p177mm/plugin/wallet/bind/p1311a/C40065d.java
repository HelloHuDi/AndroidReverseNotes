package com.tencent.p177mm.plugin.wallet.bind.p1311a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.bind.a.d */
public final class C40065d extends C5749m {
    public C40065d(String str, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(45730);
        HashMap hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("passwd", str3);
        if (z) {
            hashMap.put("unbind_scene", "1");
        }
        mo70323M(hashMap);
        AppMethodBeat.m2505o(45730);
    }

    public C40065d(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(45731);
        HashMap hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("expired_flag", "1");
        if (z) {
            hashMap.put("unbind_scene", "1");
        }
        mo70323M(hashMap);
        AppMethodBeat.m2505o(45731);
    }

    public final int bgI() {
        return 14;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 473;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/unbind";
    }
}
