package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l extends m {
    public l() {
        AppMethodBeat.i(46521);
        M(new HashMap());
        AppMethodBeat.o(46521);
    }

    public final int bgI() {
        return 1631;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46522);
        ab.i("MicroMsg.NetSceneQueryUserWallet", "errCode is : ".concat(String.valueOf(i)));
        if (i == 0) {
            r.cPL().bSd.hY("WalletKindInfo", "delete from WalletKindInfo");
            if (jSONObject != null) {
                ab.i("MicroMsg.NetSceneQueryUserWallet", "resp json " + jSONObject.toString());
                JSONArray optJSONArray = jSONObject.optJSONArray("UserWalletInfoList");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        aa aD = aa.aD(optJSONArray.optJSONObject(i2));
                        if (aD != null) {
                            r.cPL().b((c) aD);
                        }
                    }
                    AppMethodBeat.o(46522);
                    return;
                }
                ab.e("MicroMsg.NetSceneQueryUserWallet", "wallet array is null");
                AppMethodBeat.o(46522);
                return;
            }
            ab.e("MicroMsg.NetSceneQueryUserWallet", "response json is null");
        }
        AppMethodBeat.o(46522);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/queryuserwallet";
    }

    public final int ZU() {
        return 1631;
    }
}
