package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class ad extends m {
    public double pPt;
    public String pRv;
    public String tuy;
    public double tuz;

    public final int bgI() {
        return 0;
    }

    public final int ZU() {
        return 1689;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfergetchargefee";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46556);
        ab.i("Micromsg.NetSceneTransferChargeQuery", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            ab.i("Micromsg.NetSceneTransferChargeQuery", "NetSceneTransferChargeQuery request error");
            AppMethodBeat.o(46556);
            return;
        }
        this.tuy = jSONObject.optString("short_desc");
        this.pRv = jSONObject.optString("charge_desc");
        this.tuz = jSONObject.optDouble("acc_fee");
        this.pPt = jSONObject.optDouble("remain_fee") / 100.0d;
        AppMethodBeat.o(46556);
    }
}
