package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.m */
public final class C43790m extends C5749m {
    public String ehr;
    public String tud;
    public String tue;
    public BindCardOrder tuf;

    public C43790m(BindCardOrder bindCardOrder, String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, int i, int i2) {
        AppMethodBeat.m2504i(46523);
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
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46523);
    }

    public final int bgI() {
        return 1786;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46524);
        if (jSONObject != null && i == 0) {
            this.tud = jSONObject.optString("result_code");
            this.ehr = jSONObject.optString("result_msg");
            this.tue = jSONObject.optString("alert_wording");
        }
        AppMethodBeat.m2505o(46524);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1786;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sendbindcardaward";
    }
}
