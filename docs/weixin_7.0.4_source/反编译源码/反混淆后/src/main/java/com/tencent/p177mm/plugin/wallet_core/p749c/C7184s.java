package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.s */
public final class C7184s extends C5749m {
    public String tui;
    public int tuj;
    public String tuk;
    public String tul;

    public C7184s(String str, String str2) {
        AppMethodBeat.m2504i(46534);
        HashMap hashMap = new HashMap();
        hashMap.put("token", str);
        hashMap.put("use_touch", "1");
        mo70323M(hashMap);
        hashMap = new HashMap();
        hashMap.put("soter_req", str2);
        mo70328ba(hashMap);
        AppMethodBeat.m2505o(46534);
    }

    public C7184s(String str, String str2, byte b) {
        AppMethodBeat.m2504i(46535);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        mo70323M(hashMap);
        mo70328ba(new HashMap());
        AppMethodBeat.m2505o(46535);
    }

    public C7184s(String str, String str2, char c) {
        AppMethodBeat.m2504i(46536);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        hashMap.put("resend", "1");
        mo70323M(hashMap);
        mo70328ba(new HashMap());
        AppMethodBeat.m2505o(46536);
    }

    public final int bgI() {
        return 100;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46537);
        C4990ab.m7410d("Micromsg.NetSceneTenpayCheckPwdByToken", "errCode " + i + " errMsg: " + str);
        this.tui = jSONObject.optString("usertoken");
        this.tuj = jSONObject.optInt("is_free_sms");
        this.tuk = jSONObject.optString("mobile_no");
        this.tul = jSONObject.optString("relation_key");
        AppMethodBeat.m2505o(46537);
    }

    public final boolean cOT() {
        return this.tuj == 0;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1515;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getusertoken";
    }
}
