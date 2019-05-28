package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class o extends m {
    public o() {
        AppMethodBeat.i(46527);
        M(new HashMap());
        AppMethodBeat.o(46527);
    }

    public final int bgI() {
        return 2791;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int ZU() {
        return 2791;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/setpayuserduty";
    }

    public final int getType() {
        return 2791;
    }
}
