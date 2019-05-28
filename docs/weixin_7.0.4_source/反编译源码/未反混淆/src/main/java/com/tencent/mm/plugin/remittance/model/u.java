package com.tencent.mm.plugin.remittance.model;

import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class u extends m {
    public String nYZ = "";
    public String pPk = null;

    public u(String str, String str2, int i, String str3, String str4, int i2) {
        AppMethodBeat.i(44770);
        this.pPk = str3;
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str2);
        hashMap.put(b.TRANSACTION_ID, str);
        hashMap.put("op", str3);
        hashMap.put("username", str4);
        hashMap.put("invalid_time", String.valueOf(i2));
        hashMap.put("total_fee", String.valueOf(i));
        ab.i("Micromsg.NetSceneTenpayRemittanceQuery", "trans_id=" + str2 + ";transaction_id=" + str + ";total_fee=" + i);
        M(hashMap);
        AppMethodBeat.o(44770);
    }

    public final int bgI() {
        return 0;
    }

    public final int ZU() {
        return 1691;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferoperation";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(44771);
        ab.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(44771);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
        if (optJSONObject != null) {
            this.nYZ = optJSONObject.optString("guide_flag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        AppMethodBeat.o(44771);
    }
}
