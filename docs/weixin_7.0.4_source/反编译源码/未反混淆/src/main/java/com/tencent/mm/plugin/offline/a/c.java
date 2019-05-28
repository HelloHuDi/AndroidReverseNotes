package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends m {
    public c(String str, int i, int i2) {
        AppMethodBeat.i(43386);
        HashMap hashMap = new HashMap();
        hashMap.put("req_key", str);
        hashMap.put("pay_scene", String.valueOf(i));
        hashMap.put("pay_channel", String.valueOf(i2));
        M(hashMap);
        AppMethodBeat.o(43386);
    }

    public final int bgI() {
        return 1385;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinecancelpay";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(43387);
        ab.i("NetSceneOfflineCancelPay", "onGYNetEnd errCode:%d, errMsg:%s", Integer.valueOf(i), str);
        AppMethodBeat.o(43387);
    }
}
