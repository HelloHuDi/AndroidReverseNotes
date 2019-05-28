package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22582aa;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.l */
public final class C40094l extends C5749m {
    public C40094l() {
        AppMethodBeat.m2504i(46521);
        mo70323M(new HashMap());
        AppMethodBeat.m2505o(46521);
    }

    public final int bgI() {
        return 1631;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46522);
        C4990ab.m7416i("MicroMsg.NetSceneQueryUserWallet", "errCode is : ".concat(String.valueOf(i)));
        if (i == 0) {
            C14241r.cPL().bSd.mo10108hY("WalletKindInfo", "delete from WalletKindInfo");
            if (jSONObject != null) {
                C4990ab.m7416i("MicroMsg.NetSceneQueryUserWallet", "resp json " + jSONObject.toString());
                JSONArray optJSONArray = jSONObject.optJSONArray("UserWalletInfoList");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        C22582aa aD = C22582aa.m34273aD(optJSONArray.optJSONObject(i2));
                        if (aD != null) {
                            C14241r.cPL().mo10101b((C4925c) aD);
                        }
                    }
                    AppMethodBeat.m2505o(46522);
                    return;
                }
                C4990ab.m7412e("MicroMsg.NetSceneQueryUserWallet", "wallet array is null");
                AppMethodBeat.m2505o(46522);
                return;
            }
            C4990ab.m7412e("MicroMsg.NetSceneQueryUserWallet", "response json is null");
        }
        AppMethodBeat.m2505o(46522);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/queryuserwallet";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1631;
    }
}
