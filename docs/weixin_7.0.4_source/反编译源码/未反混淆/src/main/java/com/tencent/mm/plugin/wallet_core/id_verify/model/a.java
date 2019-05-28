package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends m {
    public a(int i) {
        AppMethodBeat.i(46634);
        HashMap hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        M(hashMap);
        AppMethodBeat.o(46634);
    }

    public final int bgI() {
        return 1584;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46635);
        ab.i("MicroMsg.NetSceneAgreeDisclaimer", "errCode = " + i + ";errMsg = " + str);
        AppMethodBeat.o(46635);
    }

    public final int ZU() {
        return 1584;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamesetduty";
    }
}
