package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.w;
import java.util.HashMap;
import org.json.JSONObject;

public final class q extends m {
    public q() {
        AppMethodBeat.i(49178);
        M(new HashMap());
        AppMethodBeat.o(49178);
    }

    public final int bgI() {
        return 19;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(49179);
        ab.d("Micromsg.NetSceneTenpayTimeSeed", " errCode: " + i + " errMsg :" + str);
        String optString = jSONObject.optString("time_stamp");
        if (bo.isNullOrNil(optString)) {
            ab.w("Micromsg.NetSceneTenpayTimeSeed", "hy: no timeseed. use local timeseed");
            w.setTimeStamp((System.currentTimeMillis() / 1000));
            AppMethodBeat.o(49179);
            return;
        }
        w.setTimeStamp(optString);
        AppMethodBeat.o(49179);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/timeseed";
    }

    public final int ZU() {
        return b.CTRL_INDEX;
    }
}
