package com.tencent.p177mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.model.a */
public final class C46364a extends C5749m {
    public C46364a(int i) {
        AppMethodBeat.m2504i(46634);
        HashMap hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46634);
    }

    public final int bgI() {
        return 1584;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46635);
        C4990ab.m7416i("MicroMsg.NetSceneAgreeDisclaimer", "errCode = " + i + ";errMsg = " + str);
        AppMethodBeat.m2505o(46635);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1584;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamesetduty";
    }
}
