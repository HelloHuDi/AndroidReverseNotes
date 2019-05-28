package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class g extends m {
    public String cIe = null;

    public g(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(48664);
        HashMap hashMap = new HashMap();
        hashMap.put("verify_code", str);
        hashMap.put("session_key", str2);
        hashMap.put("passwd", str3);
        hashMap.put("bind_serialno", str4);
        hashMap.put("bank_type", str5);
        M(hashMap);
        hashMap = new HashMap();
        hashMap.put("banktype", str5);
        ba(hashMap);
        AppMethodBeat.o(48664);
    }

    public final int bgI() {
        return 65;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48665);
        ab.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(48665);
            return;
        }
        this.cIe = jSONObject.optString("app_username");
        AppMethodBeat.o(48665);
    }
}
