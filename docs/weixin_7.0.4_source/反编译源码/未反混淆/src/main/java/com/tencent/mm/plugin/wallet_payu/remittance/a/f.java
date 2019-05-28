package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends a {
    public f(String str, int i, String str2, String str3, int i2) {
        AppMethodBeat.i(48535);
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("total_fee", String.valueOf(i));
        hashMap.put("fee_type", str2);
        hashMap.put("receiver_name", str3);
        hashMap.put("invalid_time", String.valueOf(i2));
        M(hashMap);
        AppMethodBeat.o(48535);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48536);
        ab.d("MicroMsg.NetScenePayURemitttanceRetry", "errCode " + i + " errMsg: " + str);
        AppMethodBeat.o(48536);
    }

    public final int cOX() {
        return 26;
    }
}
