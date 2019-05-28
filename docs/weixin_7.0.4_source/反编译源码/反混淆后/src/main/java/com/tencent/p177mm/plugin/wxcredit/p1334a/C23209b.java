package com.tencent.p177mm.plugin.wxcredit.p1334a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wxcredit.a.b */
public final class C23209b extends C5749m {
    public String name;
    public String token;
    public String uYt;
    public boolean uYu = true;

    public C23209b(String str, int i, String str2) {
        AppMethodBeat.m2504i(48655);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("bank_type", str2);
        hashMap.put("check_pwd_scene", String.valueOf(i));
        mo70323M(hashMap);
        hashMap = new HashMap();
        hashMap.put("check_pwd_scene", String.valueOf(i));
        mo70328ba(hashMap);
        AppMethodBeat.m2505o(48655);
    }

    public final int bgI() {
        return 63;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48656);
        C4990ab.m7410d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(48656);
            return;
        }
        this.token = jSONObject.optString("session_key");
        if ("1".equals(jSONObject.optString("all_info"))) {
            this.uYu = false;
            AppMethodBeat.m2505o(48656);
            return;
        }
        this.uYu = true;
        this.name = jSONObject.optString("name");
        this.uYt = jSONObject.optString("cre_id");
        AppMethodBeat.m2505o(48656);
    }
}
