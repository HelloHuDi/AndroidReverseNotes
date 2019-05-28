package com.tencent.p177mm.plugin.wallet.balance.p550a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44426i;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import com.tencent.p177mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.p177mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import java.math.RoundingMode;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.e */
public final class C46340e extends C5749m implements C44426i, ITenpaySave {
    public String cBT = null;
    public String cRb;
    public String cRc;
    public String cRd;
    public String cRe;
    public String cRf;
    public boolean teW = false;
    public String teX = "";
    private RetryPayInfo tfe;

    public C46340e(double d, String str, String str2, String str3) {
        AppMethodBeat.m2504i(45225);
        HashMap hashMap = new HashMap();
        hashMap.put("total_fee", C36391e.m59997b(String.valueOf(d), "100", 0, RoundingMode.HALF_UP).toString());
        hashMap.put("fee_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("bank_type", str3);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(45225);
    }

    public final int bgI() {
        return 74;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(45226);
        C4990ab.m7410d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(45226);
            return;
        }
        this.cBT = jSONObject.optString("req_key");
        this.teW = "1".equals(jSONObject.optString("should_alert"));
        this.teX = jSONObject.optString("alert_msg");
        if (jSONObject.has("real_name_info")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
            C4990ab.m7417i("Micromsg.NetSceneTenpayBalanceSave", "get real_name_info %s", optJSONObject.toString());
            this.cRb = optJSONObject.optString("guide_flag");
            this.cRc = optJSONObject.optString("guide_wording");
            this.cRd = optJSONObject.optString("left_button_wording");
            this.cRe = optJSONObject.optString("right_button_wording");
            this.cRf = optJSONObject.optString("upload_credit_url");
        }
        this.tfe = new RetryPayInfo();
        this.tfe.mo39956aA(jSONObject);
        AppMethodBeat.m2505o(45226);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1502;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/genpresave";
    }

    public final RetryPayInfo cMC() {
        return this.tfe;
    }
}
