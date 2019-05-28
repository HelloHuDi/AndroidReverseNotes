package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.n */
public final class C46360n extends C5749m {
    public String ehr;
    public String tud;
    public String tue;
    public Promotions tug;

    public C46360n(Promotions promotions, String str, String str2, long j) {
        AppMethodBeat.m2504i(46525);
        this.tug = promotions;
        HashMap hashMap = new HashMap();
        hashMap.put("activity_id", promotions.ttW);
        hashMap.put("award_id", promotions.uZN);
        hashMap.put("send_record_id", promotions.tzP);
        hashMap.put("user_record_id", promotions.tzQ);
        hashMap.put("req_key", str);
        hashMap.put(C8741b.TRANSACTION_ID, str2);
        hashMap.put("activity_mch_id", String.valueOf(j));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46525);
    }

    public final int bgI() {
        return 1589;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46526);
        C4990ab.m7417i("MicroMsg.NetSenceTenPayBase", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", Integer.valueOf(i), str, jSONObject);
        if (jSONObject != null && i == 0) {
            this.tud = jSONObject.optString("result_code");
            this.ehr = jSONObject.optString("result_msg");
            this.tue = jSONObject.optString("alert_wording");
        }
        AppMethodBeat.m2505o(46526);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1589;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sendpayaward";
    }
}
