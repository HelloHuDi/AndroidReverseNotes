package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import java.util.HashMap;
import org.json.JSONObject;

public final class m extends com.tencent.mm.wallet_core.tenpay.model.m {
    public String ehr;
    public String tud;
    public String tue;
    public BindCardOrder tuf;

    public m(BindCardOrder bindCardOrder, String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, int i, int i2) {
        AppMethodBeat.i(46523);
        this.tuf = bindCardOrder;
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
        M(hashMap);
        AppMethodBeat.o(46523);
    }

    public final int bgI() {
        return 1786;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46524);
        if (jSONObject != null && i == 0) {
            this.tud = jSONObject.optString("result_code");
            this.ehr = jSONObject.optString("result_msg");
            this.tue = jSONObject.optString("alert_wording");
        }
        AppMethodBeat.o(46524);
    }

    public final int ZU() {
        return 1786;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sendbindcardaward";
    }
}
