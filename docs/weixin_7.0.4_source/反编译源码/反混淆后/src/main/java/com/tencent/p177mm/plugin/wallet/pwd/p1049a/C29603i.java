package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p1225h.C26996a.C26998a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.i */
public final class C29603i extends C5749m {
    public C29603i(String str, String str2) {
        AppMethodBeat.m2504i(46182);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("new_passwd", str2);
        hashMap.put("new_rpasswd", str2);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46182);
    }

    public final int bgI() {
        return 9;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46183);
        C4990ab.m7410d("Micromsg.NetSceneTenpayChangePwd", "errCode " + i + " errMsg: " + str);
        AppMethodBeat.m2505o(46183);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/changepwd";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return C26998a.CTRL_INDEX;
    }
}
