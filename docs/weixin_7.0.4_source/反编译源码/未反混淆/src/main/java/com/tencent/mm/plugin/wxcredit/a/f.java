package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends m {
    public f(String str, String str2, String str3) {
        AppMethodBeat.i(48663);
        HashMap hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("passwd", str3);
        M(hashMap);
        AppMethodBeat.o(48663);
    }

    public final int bgI() {
        return 62;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
