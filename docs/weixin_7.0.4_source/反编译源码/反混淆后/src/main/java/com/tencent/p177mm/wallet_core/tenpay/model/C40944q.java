package com.tencent.p177mm.wallet_core.tenpay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.bio.face.C45581b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C30862w;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.tenpay.model.q */
public final class C40944q extends C5749m {
    public C40944q() {
        AppMethodBeat.m2504i(49178);
        mo70323M(new HashMap());
        AppMethodBeat.m2505o(49178);
    }

    public final int bgI() {
        return 19;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(49179);
        C4990ab.m7410d("Micromsg.NetSceneTenpayTimeSeed", " errCode: " + i + " errMsg :" + str);
        String optString = jSONObject.optString("time_stamp");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7420w("Micromsg.NetSceneTenpayTimeSeed", "hy: no timeseed. use local timeseed");
            C30862w.setTimeStamp((System.currentTimeMillis() / 1000));
            AppMethodBeat.m2505o(49179);
            return;
        }
        C30862w.setTimeStamp(optString);
        AppMethodBeat.m2505o(49179);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/timeseed";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return C45581b.CTRL_INDEX;
    }
}
