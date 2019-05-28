package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.x */
public final class C35474x extends C5749m {
    public JSONObject hwh;
    public String tuv = "";

    public C35474x(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, int i, int i2) {
        AppMethodBeat.m2504i(46545);
        this.tuv = str;
        HashMap hashMap = new HashMap();
        hashMap.put("activity_id", str);
        hashMap.put("award_id", str2);
        hashMap.put("send_record_id", str3);
        hashMap.put("user_record_id", str4);
        hashMap.put("activity_mch_id", String.valueOf(j));
        hashMap.put("activity_type", String.valueOf(j2));
        hashMap.put("bank_type", String.valueOf(str5));
        hashMap.put("bank_serial", String.valueOf(str6));
        hashMap.put("bindbankscene", String.valueOf(i));
        hashMap.put("realname_scene", String.valueOf(i2));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46545);
    }

    public final int bgI() {
        return 1773;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/querybindcardaward";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1773;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46546);
        C4990ab.m7417i("MicroMsg.NetSceneTenpayQueryBindPayaward", "errcode %s errmsg %s json %s", Integer.valueOf(i), str, jSONObject);
        this.hwh = jSONObject;
        AppMethodBeat.m2505o(46546);
    }

    public final boolean bXm() {
        return false;
    }
}
