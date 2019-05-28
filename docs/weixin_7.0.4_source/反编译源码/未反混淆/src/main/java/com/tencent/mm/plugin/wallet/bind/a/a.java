package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends m {
    public int tle;
    public String tlf;

    public a(String str, String str2) {
        AppMethodBeat.i(45724);
        HashMap hashMap = new HashMap();
        hashMap.put("bankcard_type", str);
        hashMap.put("bind_serial", str2);
        M(hashMap);
        AppMethodBeat.o(45724);
    }

    public final int bgI() {
        return 1540;
    }

    public final int ZU() {
        return 1540;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/unbindbanner";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(45725);
        if (i == 0) {
            if (jSONObject != null) {
                this.tle = jSONObject.optInt("unbindbannerlevel", 0);
                this.tlf = jSONObject.optString("unbindbannerwording");
                AppMethodBeat.o(45725);
                return;
            }
            ab.e("MicroMsg.NetSceneGetUnbindInfo", "json is null");
        }
        AppMethodBeat.o(45725);
    }
}
