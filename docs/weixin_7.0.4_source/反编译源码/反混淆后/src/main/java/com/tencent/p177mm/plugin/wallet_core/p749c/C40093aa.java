package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.aa */
public final class C40093aa extends C5749m {
    public JSONObject hwh;
    public String tuv = "";

    public C40093aa(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        AppMethodBeat.m2504i(46552);
        this.tuv = str;
        HashMap hashMap = new HashMap();
        hashMap.put("activity_id", str);
        hashMap.put("award_id", str2);
        hashMap.put("send_record_id", str3);
        hashMap.put("user_record_id", str4);
        hashMap.put("req_key", str5);
        hashMap.put(C8741b.TRANSACTION_ID, str6);
        hashMap.put("activity_mch_id", String.valueOf(j));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46552);
    }

    public final int bgI() {
        return 1979;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/querypayaward";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1979;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46553);
        C4990ab.m7417i("MicroMsg.NetSceneTenpayQueryPayaward", "errcode %s errmsg %s json %s", Integer.valueOf(i), str, jSONObject);
        this.hwh = jSONObject;
        AppMethodBeat.m2505o(46553);
    }

    public final boolean bXm() {
        return false;
    }
}
