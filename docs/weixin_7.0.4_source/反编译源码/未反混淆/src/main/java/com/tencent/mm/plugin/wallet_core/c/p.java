package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class p extends m {
    public p(String str) {
        AppMethodBeat.i(46528);
        HashMap hashMap = new HashMap();
        hashMap.put("wallet_tpa_country", str);
        M(hashMap);
        AppMethodBeat.o(46528);
    }

    public final int bgI() {
        return 1663;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int ZU() {
        return 1663;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/setuserwallet";
    }

    public final int getType() {
        AppMethodBeat.i(46529);
        int type = super.getType();
        AppMethodBeat.o(46529);
        return type;
    }
}
