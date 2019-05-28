package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.e */
public final class C35450e extends C5749m {
    public C35450e(String str) {
        AppMethodBeat.m2504i(46170);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46170);
    }

    public final int bgI() {
        return 0;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1321;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/closewalletlock";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46171);
        C4990ab.m7417i("MicroMsg.NetSceneCloseWalletLock", "alvinluo close wallet lock errCode: %d, errMsg: %s, json: %s", Integer.valueOf(i), str, jSONObject);
        AppMethodBeat.m2505o(46171);
    }
}
