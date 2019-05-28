package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends m {
    public d(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(45730);
        HashMap hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("passwd", str3);
        if (z) {
            hashMap.put("unbind_scene", "1");
        }
        M(hashMap);
        AppMethodBeat.o(45730);
    }

    public d(String str, String str2, boolean z) {
        AppMethodBeat.i(45731);
        HashMap hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("expired_flag", "1");
        if (z) {
            hashMap.put("unbind_scene", "1");
        }
        M(hashMap);
        AppMethodBeat.o(45731);
    }

    public final int bgI() {
        return 14;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int ZU() {
        return 473;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/unbind";
    }
}
