package com.tencent.p177mm.plugin.remittance.model;

import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.remittance.model.u */
public final class C46177u extends C5749m {
    public String nYZ = "";
    public String pPk = null;

    public C46177u(String str, String str2, int i, String str3, String str4, int i2) {
        AppMethodBeat.m2504i(44770);
        this.pPk = str3;
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str2);
        hashMap.put(C8741b.TRANSACTION_ID, str);
        hashMap.put("op", str3);
        hashMap.put("username", str4);
        hashMap.put("invalid_time", String.valueOf(i2));
        hashMap.put("total_fee", String.valueOf(i));
        C4990ab.m7416i("Micromsg.NetSceneTenpayRemittanceQuery", "trans_id=" + str2 + ";transaction_id=" + str + ";total_fee=" + i);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(44770);
    }

    public final int bgI() {
        return 0;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1691;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferoperation";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(44771);
        C4990ab.m7410d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(44771);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
        if (optJSONObject != null) {
            this.nYZ = optJSONObject.optString("guide_flag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        AppMethodBeat.m2505o(44771);
    }
}
