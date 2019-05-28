package com.tencent.mm.plugin.wallet_core.c;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class aa extends m {
    public JSONObject hwh;
    public String tuv = "";

    public aa(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        AppMethodBeat.i(46552);
        this.tuv = str;
        HashMap hashMap = new HashMap();
        hashMap.put("activity_id", str);
        hashMap.put("award_id", str2);
        hashMap.put("send_record_id", str3);
        hashMap.put("user_record_id", str4);
        hashMap.put("req_key", str5);
        hashMap.put(b.TRANSACTION_ID, str6);
        hashMap.put("activity_mch_id", String.valueOf(j));
        M(hashMap);
        AppMethodBeat.o(46552);
    }

    public final int bgI() {
        return 1979;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/querypayaward";
    }

    public final int ZU() {
        return 1979;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46553);
        ab.i("MicroMsg.NetSceneTenpayQueryPayaward", "errcode %s errmsg %s json %s", Integer.valueOf(i), str, jSONObject);
        this.hwh = jSONObject;
        AppMethodBeat.o(46553);
    }

    public final boolean bXm() {
        return false;
    }
}
