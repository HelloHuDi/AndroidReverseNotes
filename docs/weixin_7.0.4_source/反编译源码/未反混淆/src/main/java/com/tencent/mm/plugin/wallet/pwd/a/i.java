package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class i extends m {
    public i(String str, String str2) {
        AppMethodBeat.i(46182);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("new_passwd", str2);
        hashMap.put("new_rpasswd", str2);
        M(hashMap);
        AppMethodBeat.o(46182);
    }

    public final int bgI() {
        return 9;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46183);
        ab.d("Micromsg.NetSceneTenpayChangePwd", "errCode " + i + " errMsg: " + str);
        AppMethodBeat.o(46183);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/changepwd";
    }

    public final int ZU() {
        return a.CTRL_INDEX;
    }
}
