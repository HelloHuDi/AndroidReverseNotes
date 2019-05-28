package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.n */
public final class C43777n extends C5749m {
    public C43777n(String str, String str2) {
        AppMethodBeat.m2504i(46196);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("resetpwd_token", str2);
        hashMap.put("passwd", str);
        mo70323M(hashMap);
        mo70328ba(hashMap2);
        AppMethodBeat.m2505o(46196);
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46197);
        C4990ab.m7411d("MicroMsg.NetSceneTenpayResetPwdByToken", " json %s", jSONObject.toString());
        AppMethodBeat.m2505o(46197);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1371;
    }

    public final int bgI() {
        return 1371;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwdbytoken";
    }
}
