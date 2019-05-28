package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class j extends m {
    public j(String str) {
        AppMethodBeat.i(43399);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("device_id", q.LM());
        M(hashMap);
        AppMethodBeat.o(43399);
    }

    public final int bgI() {
        return 47;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(43400);
        super.a(i, i2, i3, str, qVar, bArr);
        AppMethodBeat.o(43400);
    }

    public final int ZU() {
        return 566;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineclose";
    }
}
