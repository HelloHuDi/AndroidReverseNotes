package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends m {
    public String cFl;
    public boolean cQU = true;
    private Map<String, String> oYG = new HashMap();
    public String token;
    public boolean uYs = false;

    public a(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(48652);
        this.oYG.put("session_key", str3);
        this.oYG.put("bank_type", str4);
        this.oYG.put("name", str);
        this.oYG.put("cre_id", str2);
        M(this.oYG);
        AppMethodBeat.o(48652);
    }

    public final boolean bXl() {
        AppMethodBeat.i(48653);
        super.bXl();
        this.oYG.put("retry", "1");
        M(this.oYG);
        AppMethodBeat.o(48653);
        return true;
    }

    public final int bgI() {
        return 64;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48654);
        ab.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(48654);
            return;
        }
        try {
            this.token = jSONObject.optString("session_key");
            this.cQU = "1".equals(jSONObject.getString("need_bind"));
            this.uYs = "1".equals(jSONObject.getString("bank_user"));
            this.cFl = jSONObject.optString("mobile_no");
            AppMethodBeat.o(48654);
        } catch (JSONException e) {
            ab.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            AppMethodBeat.o(48654);
        }
    }
}
