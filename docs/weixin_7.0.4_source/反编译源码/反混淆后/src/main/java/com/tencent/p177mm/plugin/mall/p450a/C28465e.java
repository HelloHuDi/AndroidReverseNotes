package com.tencent.p177mm.plugin.mall.p450a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.mall.a.e */
public final class C28465e extends C5749m {
    public C39350d okN;

    public C28465e() {
        AppMethodBeat.m2504i(43096);
        mo70323M(new HashMap());
        AppMethodBeat.m2505o(43096);
    }

    public final int bgI() {
        return 2713;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/geteuinfo";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(43097);
        C4990ab.m7410d("MicroMsg.NetSceneGetEUInfo", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(43097);
            return;
        }
        try {
            this.okN = new C39350d(jSONObject.toString());
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MALL_INDEX_GDPR_CACHE_STRING_SYNC, jSONObject.toString());
            AppMethodBeat.m2505o(43097);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetEUInfo", e, "", new Object[0]);
            AppMethodBeat.m2505o(43097);
        }
    }
}
