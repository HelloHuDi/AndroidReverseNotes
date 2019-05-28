package com.tencent.p177mm.plugin.wallet.balance.p550a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36379x;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.c */
public final class C7177c extends C5749m {
    public String cBT = null;

    public C7177c(int i, String str, String str2, String str3, int i2, String str4) {
        AppMethodBeat.m2504i(45221);
        HashMap hashMap = new HashMap();
        hashMap.put("flag", String.valueOf(i));
        hashMap.put("passwd", str);
        hashMap.put("req_key", str3);
        hashMap.put("verify_code", str2);
        hashMap.put("pay_scene", String.valueOf(i2));
        hashMap.put("ignore_bind", str4);
        mo70323M(hashMap);
        hashMap = new HashMap();
        if (C36379x.dNS()) {
            hashMap.put("uuid_for_bindcard", C36379x.dNU());
            hashMap.put("bindcard_scene", C36379x.dNT());
        }
        mo70328ba(hashMap);
        AppMethodBeat.m2505o(45221);
    }

    public final int bgI() {
        return 76;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(45222);
        C4990ab.m7410d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(45222);
            return;
        }
        this.cBT = jSONObject.optString("req_key");
        AppMethodBeat.m2505o(45222);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1506;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/verifybind";
    }
}
