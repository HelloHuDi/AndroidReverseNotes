package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends m {
    public e(String str) {
        AppMethodBeat.i(46170);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        M(hashMap);
        AppMethodBeat.o(46170);
    }

    public final int bgI() {
        return 0;
    }

    public final int ZU() {
        return 1321;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/closewalletlock";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46171);
        ab.i("MicroMsg.NetSceneCloseWalletLock", "alvinluo close wallet lock errCode: %d, errMsg: %s, json: %s", Integer.valueOf(i), str, jSONObject);
        AppMethodBeat.o(46171);
    }
}
