package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class x extends m {
    public x(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(44788);
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("transfer_id", str2);
        hashMap.put("receiver_name", str3);
        hashMap.put("from", String.valueOf(i2));
        hashMap.put("invalid_time", String.valueOf(i));
        M(hashMap);
        AppMethodBeat.o(44788);
    }

    public final int bgI() {
        return 0;
    }

    public final int ZU() {
        return 1545;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferresendmsg";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(44789);
        ab.d("Micromsg.NetSceneTenpayRemittanceResendMsg", "errCode " + i + " errMsg: " + str);
        AppMethodBeat.o(44789);
    }
}
