package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.o */
public final class C22540o extends C5749m {
    public C22540o(C14264s c14264s) {
        AppMethodBeat.m2504i(46198);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("verify_code", c14264s.tCi);
        hashMap.put("token", c14264s.token);
        mo70324a(c14264s.pGr, (Map) hashMap, (Map) hashMap2);
        mo70323M(hashMap);
        mo70328ba(hashMap2);
        AppMethodBeat.m2505o(46198);
    }

    public final int bgI() {
        return 11;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 470;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwdverify";
    }
}
