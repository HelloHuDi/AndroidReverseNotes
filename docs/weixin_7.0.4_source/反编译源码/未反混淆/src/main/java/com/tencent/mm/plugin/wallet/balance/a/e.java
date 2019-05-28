package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.math.RoundingMode;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends m implements i, ITenpaySave {
    public String cBT = null;
    public String cRb;
    public String cRc;
    public String cRd;
    public String cRe;
    public String cRf;
    public boolean teW = false;
    public String teX = "";
    private RetryPayInfo tfe;

    public e(double d, String str, String str2, String str3) {
        AppMethodBeat.i(45225);
        HashMap hashMap = new HashMap();
        hashMap.put("total_fee", com.tencent.mm.wallet_core.ui.e.b(String.valueOf(d), "100", 0, RoundingMode.HALF_UP).toString());
        hashMap.put("fee_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("bank_type", str3);
        M(hashMap);
        AppMethodBeat.o(45225);
    }

    public final int bgI() {
        return 74;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(45226);
        ab.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(45226);
            return;
        }
        this.cBT = jSONObject.optString("req_key");
        this.teW = "1".equals(jSONObject.optString("should_alert"));
        this.teX = jSONObject.optString("alert_msg");
        if (jSONObject.has("real_name_info")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
            ab.i("Micromsg.NetSceneTenpayBalanceSave", "get real_name_info %s", optJSONObject.toString());
            this.cRb = optJSONObject.optString("guide_flag");
            this.cRc = optJSONObject.optString("guide_wording");
            this.cRd = optJSONObject.optString("left_button_wording");
            this.cRe = optJSONObject.optString("right_button_wording");
            this.cRf = optJSONObject.optString("upload_credit_url");
        }
        this.tfe = new RetryPayInfo();
        this.tfe.aA(jSONObject);
        AppMethodBeat.o(45226);
    }

    public final int ZU() {
        return 1502;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/genpresave";
    }

    public final RetryPayInfo cMC() {
        return this.tfe;
    }
}
