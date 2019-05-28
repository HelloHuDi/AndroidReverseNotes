package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.ac */
public final class C14222ac extends C5749m {
    public String tuh;
    public String tuu;

    public C14222ac(C14264s c14264s, String str) {
        AppMethodBeat.m2504i(46554);
        HashMap hashMap = new HashMap();
        hashMap.put("verify_code", c14264s.tCi);
        hashMap.put("token", c14264s.token);
        hashMap.put("passwd", c14264s.guu);
        hashMap.put("relation_key", str);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46554);
    }

    public final int bgI() {
        return 124;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46555);
        if (jSONObject != null && i == 0) {
            this.tuh = jSONObject.optString("token_type");
            this.tuu = jSONObject.optString("usertoken");
        }
        AppMethodBeat.m2505o(46555);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/webankverifysms";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1604;
    }
}
