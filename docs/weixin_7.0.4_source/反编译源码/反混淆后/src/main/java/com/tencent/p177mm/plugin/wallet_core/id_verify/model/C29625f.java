package com.tencent.p177mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.model.f */
public final class C29625f extends C5749m {
    public String tvH;
    public String tvI;
    public String tvJ;
    public String tvK;
    public String tvL;

    public C29625f(String str) {
        AppMethodBeat.m2504i(46648);
        HashMap hashMap = new HashMap();
        hashMap.put("channel", "1");
        mo70323M(hashMap);
        this.tvL = str;
        AppMethodBeat.m2505o(46648);
    }

    public final int bgI() {
        return 1630;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1630;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnameguidequery";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46649);
        if (i == 0 && jSONObject != null) {
            this.tvH = jSONObject.optString("guide_flag");
            this.tvI = jSONObject.optString("guide_wording");
            this.tvJ = jSONObject.optString("left_button_wording");
            this.tvK = jSONObject.optString("right_button_wording");
        }
        AppMethodBeat.m2505o(46649);
    }
}
