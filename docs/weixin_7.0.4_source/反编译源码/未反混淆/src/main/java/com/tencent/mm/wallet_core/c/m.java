package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import org.json.JSONObject;

public final class m extends com.tencent.mm.wallet_core.tenpay.model.m {
    public String Afw;

    public m(String str) {
        AppMethodBeat.i(49061);
        this.Afw = str;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("crt_no", q.encode(str));
        hashMap.put("deviceid", com.tencent.mm.compatible.e.q.getDeviceID(ah.getContext()));
        M(hashMap);
        ba(hashMap2);
        AppMethodBeat.o(49061);
    }

    public final int bgI() {
        return 1568;
    }

    public final int ZU() {
        return 1568;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/deletedigitalcert";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(49062);
        ab.i("MicroMsg.NetSceneDeletedigitalcert", "onGYNetEnd %d %s", Integer.valueOf(i), str);
        AppMethodBeat.o(49062);
    }
}
