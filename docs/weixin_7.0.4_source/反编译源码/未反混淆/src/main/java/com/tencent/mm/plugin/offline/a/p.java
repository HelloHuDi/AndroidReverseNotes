package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class p extends m {
    public p(String str) {
        AppMethodBeat.i(43415);
        HashMap hashMap = new HashMap();
        hashMap.put("device_id", q.LM());
        hashMap.put("passwd", str);
        M(hashMap);
        AppMethodBeat.o(43415);
    }

    public final int bgI() {
        return 51;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
