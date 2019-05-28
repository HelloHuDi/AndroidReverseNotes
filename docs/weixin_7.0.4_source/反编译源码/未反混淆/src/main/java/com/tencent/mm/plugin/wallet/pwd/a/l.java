package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.c;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class l extends m implements i {
    public l(s sVar) {
        AppMethodBeat.i(46192);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("flag", sVar.flag);
        hashMap.put("passwd", sVar.guu);
        hashMap.put("rpasswd", sVar.guu);
        hashMap.put("verify_code", sVar.tCi);
        hashMap.put("token", sVar.token);
        a(sVar.pGr, (Map) hashMap, (Map) hashMap2);
        M(hashMap);
        ba(hashMap2);
        AppMethodBeat.o(46192);
    }

    public final int bgI() {
        return 20;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int ZU() {
        return c.CTRL_INDEX;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwd";
    }
}
