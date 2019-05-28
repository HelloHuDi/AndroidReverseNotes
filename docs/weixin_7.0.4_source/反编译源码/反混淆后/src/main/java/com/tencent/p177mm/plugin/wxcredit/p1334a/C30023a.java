package com.tencent.p177mm.plugin.wxcredit.p1334a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wxcredit.a.a */
public final class C30023a extends C5749m {
    public String cFl;
    public boolean cQU = true;
    private Map<String, String> oYG = new HashMap();
    public String token;
    public boolean uYs = false;

    public C30023a(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(48652);
        this.oYG.put("session_key", str3);
        this.oYG.put("bank_type", str4);
        this.oYG.put("name", str);
        this.oYG.put("cre_id", str2);
        mo70323M(this.oYG);
        AppMethodBeat.m2505o(48652);
    }

    public final boolean bXl() {
        AppMethodBeat.m2504i(48653);
        super.bXl();
        this.oYG.put("retry", "1");
        mo70323M(this.oYG);
        AppMethodBeat.m2505o(48653);
        return true;
    }

    public final int bgI() {
        return 64;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48654);
        C4990ab.m7410d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(48654);
            return;
        }
        try {
            this.token = jSONObject.optString("session_key");
            this.cQU = "1".equals(jSONObject.getString("need_bind"));
            this.uYs = "1".equals(jSONObject.getString("bank_user"));
            this.cFl = jSONObject.optString("mobile_no");
            AppMethodBeat.m2505o(48654);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            AppMethodBeat.m2505o(48654);
        }
    }
}
