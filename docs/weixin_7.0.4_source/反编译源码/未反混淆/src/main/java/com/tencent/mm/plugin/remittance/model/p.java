package com.tencent.mm.plugin.remittance.model;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class p extends a {
    public p(String str, String str2, int i, long j, int i2) {
        AppMethodBeat.i(44758);
        HashMap hashMap = new HashMap();
        hashMap.put("recv_username", str);
        hashMap.put("qrcodeid", str2);
        hashMap.put(b.CURRENCY, String.valueOf(i));
        hashMap.put("amount", String.valueOf(j));
        hashMap.put("set_amount", String.valueOf(i2));
        M(hashMap);
        ab.i("MicroMsg.NetSceneH5F2fTransferCancelPay", "qrcodeId: %s, currency: %s", str2, Integer.valueOf(i));
        AppMethodBeat.o(44758);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(44759);
        ab.d("MicroMsg.NetSceneH5F2fTransferCancelPay", "json: %s", jSONObject.toString());
        ab.i("MicroMsg.NetSceneH5F2fTransferCancelPay", "errCode: %s, errMsg: %s", Integer.valueOf(i), str);
        AppMethodBeat.o(44759);
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/h5f2ftransfercancelpay";
    }

    public final int getType() {
        return 1257;
    }

    public final int bgG() {
        return 1257;
    }
}
