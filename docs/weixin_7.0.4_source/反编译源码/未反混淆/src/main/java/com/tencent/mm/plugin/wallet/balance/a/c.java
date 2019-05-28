package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends m {
    public String cBT = null;

    public c(int i, String str, String str2, String str3, int i2, String str4) {
        AppMethodBeat.i(45221);
        HashMap hashMap = new HashMap();
        hashMap.put("flag", String.valueOf(i));
        hashMap.put("passwd", str);
        hashMap.put("req_key", str3);
        hashMap.put("verify_code", str2);
        hashMap.put("pay_scene", String.valueOf(i2));
        hashMap.put("ignore_bind", str4);
        M(hashMap);
        hashMap = new HashMap();
        if (x.dNS()) {
            hashMap.put("uuid_for_bindcard", x.dNU());
            hashMap.put("bindcard_scene", x.dNT());
        }
        ba(hashMap);
        AppMethodBeat.o(45221);
    }

    public final int bgI() {
        return 76;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(45222);
        ab.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(45222);
            return;
        }
        this.cBT = jSONObject.optString("req_key");
        AppMethodBeat.o(45222);
    }

    public final int ZU() {
        return 1506;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/verifybind";
    }
}
