package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.ad */
public final class C14223ad extends C5749m {
    public double pPt;
    public String pRv;
    public String tuy;
    public double tuz;

    public final int bgI() {
        return 0;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1689;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfergetchargefee";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46556);
        C4990ab.m7416i("Micromsg.NetSceneTransferChargeQuery", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            C4990ab.m7416i("Micromsg.NetSceneTransferChargeQuery", "NetSceneTransferChargeQuery request error");
            AppMethodBeat.m2505o(46556);
            return;
        }
        this.tuy = jSONObject.optString("short_desc");
        this.pRv = jSONObject.optString("charge_desc");
        this.tuz = jSONObject.optDouble("acc_fee");
        this.pPt = jSONObject.optDouble("remain_fee") / 100.0d;
        AppMethodBeat.m2505o(46556);
    }
}
