package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class n extends m {
    public n(String str, String str2) {
        AppMethodBeat.i(46196);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("resetpwd_token", str2);
        hashMap.put("passwd", str);
        M(hashMap);
        ba(hashMap2);
        AppMethodBeat.o(46196);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46197);
        ab.d("MicroMsg.NetSceneTenpayResetPwdByToken", " json %s", jSONObject.toString());
        AppMethodBeat.o(46197);
    }

    public final int ZU() {
        return 1371;
    }

    public final int bgI() {
        return 1371;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwdbytoken";
    }
}
