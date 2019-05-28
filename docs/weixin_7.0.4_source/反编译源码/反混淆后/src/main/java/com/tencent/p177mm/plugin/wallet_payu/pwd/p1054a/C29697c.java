package com.tencent.p177mm.plugin.wallet_payu.pwd.p1054a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pwd.a.c */
public final class C29697c extends C36383a {
    public String token = "";

    public C29697c(String str) {
        AppMethodBeat.m2504i(48504);
        HashMap hashMap = new HashMap();
        hashMap.put("pin", str);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48504);
    }

    public final int cOX() {
        return 3;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48505);
        C4990ab.m7410d("MicroMsg.NetScenePayUCheckPwd", "errCode " + i + " errMsg: " + str);
        this.token = jSONObject.optString("payu_reference");
        AppMethodBeat.m2505o(48505);
    }
}
