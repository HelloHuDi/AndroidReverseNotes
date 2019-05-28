package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends m {
    public String name;
    public String token;
    public String uYt;
    public boolean uYu = true;

    public b(String str, int i, String str2) {
        AppMethodBeat.i(48655);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("bank_type", str2);
        hashMap.put("check_pwd_scene", String.valueOf(i));
        M(hashMap);
        hashMap = new HashMap();
        hashMap.put("check_pwd_scene", String.valueOf(i));
        ba(hashMap);
        AppMethodBeat.o(48655);
    }

    public final int bgI() {
        return 63;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48656);
        ab.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(48656);
            return;
        }
        this.token = jSONObject.optString("session_key");
        if ("1".equals(jSONObject.optString("all_info"))) {
            this.uYu = false;
            AppMethodBeat.o(48656);
            return;
        }
        this.uYu = true;
        this.name = jSONObject.optString("name");
        this.uYt = jSONObject.optString("cre_id");
        AppMethodBeat.o(48656);
    }
}
