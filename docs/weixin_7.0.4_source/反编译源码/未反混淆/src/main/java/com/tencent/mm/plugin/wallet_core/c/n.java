package com.tencent.mm.plugin.wallet_core.c;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class n extends m {
    public String ehr;
    public String tud;
    public String tue;
    public Promotions tug;

    public n(Promotions promotions, String str, String str2, long j) {
        AppMethodBeat.i(46525);
        this.tug = promotions;
        HashMap hashMap = new HashMap();
        hashMap.put("activity_id", promotions.ttW);
        hashMap.put("award_id", promotions.uZN);
        hashMap.put("send_record_id", promotions.tzP);
        hashMap.put("user_record_id", promotions.tzQ);
        hashMap.put("req_key", str);
        hashMap.put(b.TRANSACTION_ID, str2);
        hashMap.put("activity_mch_id", String.valueOf(j));
        M(hashMap);
        AppMethodBeat.o(46525);
    }

    public final int bgI() {
        return 1589;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46526);
        ab.i("MicroMsg.NetSenceTenPayBase", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", Integer.valueOf(i), str, jSONObject);
        if (jSONObject != null && i == 0) {
            this.tud = jSONObject.optString("result_code");
            this.ehr = jSONObject.optString("result_msg");
            this.tue = jSONObject.optString("alert_wording");
        }
        AppMethodBeat.o(46526);
    }

    public final int ZU() {
        return 1589;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sendpayaward";
    }
}
