package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class ac extends m {
    public String tuh;
    public String tuu;

    public ac(s sVar, String str) {
        AppMethodBeat.i(46554);
        HashMap hashMap = new HashMap();
        hashMap.put("verify_code", sVar.tCi);
        hashMap.put("token", sVar.token);
        hashMap.put("passwd", sVar.guu);
        hashMap.put("relation_key", str);
        M(hashMap);
        AppMethodBeat.o(46554);
    }

    public final int bgI() {
        return 124;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46555);
        if (jSONObject != null && i == 0) {
            this.tuh = jSONObject.optString("token_type");
            this.tuu = jSONObject.optString("usertoken");
        }
        AppMethodBeat.o(46555);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/webankverifysms";
    }

    public final int ZU() {
        return 1604;
    }
}
