package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.bio.face.C38272c;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.wallet_core.p649c.C44426i;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.l */
public final class C40078l extends C5749m implements C44426i {
    public C40078l(C14264s c14264s) {
        AppMethodBeat.m2504i(46192);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("flag", c14264s.flag);
        hashMap.put("passwd", c14264s.guu);
        hashMap.put("rpasswd", c14264s.guu);
        hashMap.put("verify_code", c14264s.tCi);
        hashMap.put("token", c14264s.token);
        mo70324a(c14264s.pGr, (Map) hashMap, (Map) hashMap2);
        mo70323M(hashMap);
        mo70328ba(hashMap2);
        AppMethodBeat.m2505o(46192);
    }

    public final int bgI() {
        return 20;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return C38272c.CTRL_INDEX;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwd";
    }
}
