package com.tencent.mm.plugin.wallet.balance.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.plugin.wallet_core.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.e;
import java.math.RoundingMode;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends m implements i, ITenpaySave {
    public String cBT = null;
    public String cRb;
    public String cRc;
    public String cRd;
    public String cRe;
    public String cRf;
    public int cuy = 0;
    public double pPp = 0.0d;
    public double pPz = 0.0d;
    public boolean teW = false;
    public String teX = "";
    public b teY;
    public b teZ;
    public j tfa;
    public String tfb;
    public boolean tfc = false;
    public a tfd;
    private RetryPayInfo tfe;

    public static class a {
        public String content;
        public String tff;
        public String tfg;
        public String title;
    }

    public d(double d, String str, String str2, int i) {
        AppMethodBeat.i(45223);
        HashMap hashMap = new HashMap();
        hashMap.put("total_fee", e.b(String.valueOf(d), "100", 0, RoundingMode.HALF_UP).toString());
        hashMap.put("fee_type", str);
        hashMap.put("bank_type", str2);
        hashMap.put("operation", String.valueOf(i));
        hashMap.put("charge_rate_version", (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_FETCH_CHARGE_RATE_VERSION_STRING_SYNC, (Object) ""));
        M(hashMap);
        AppMethodBeat.o(45223);
    }

    public final int bgI() {
        return 75;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        boolean z = false;
        AppMethodBeat.i(45224);
        ab.d("Micromsg.NetSceneTenpayBalanceFetch", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(45224);
            return;
        }
        this.cBT = jSONObject.optString("req_key");
        this.teW = "1".equals(jSONObject.optString("should_alert"));
        this.teX = jSONObject.optString("alert_msg");
        this.pPp = jSONObject.optDouble("charge_fee", 0.0d) / 100.0d;
        this.pPz = jSONObject.optDouble("total_fee", 0.0d) / 100.0d;
        JSONObject optJSONObject = jSONObject.optJSONObject("first_fetch_info");
        if (optJSONObject != null) {
            ab.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is valid");
            this.teY = af.a(optJSONObject, false);
        } else {
            ab.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is null");
        }
        optJSONObject = jSONObject.optJSONObject("need_charge_fee_info");
        if (optJSONObject != null) {
            ab.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is valid");
            this.teZ = af.a(optJSONObject, false);
        } else {
            ab.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is null");
        }
        this.cuy = jSONObject.optInt("operation", 0);
        ab.i("Micromsg.NetSceneTenpayBalanceFetch", "charge_fee:" + this.pPp + " total_fee:" + this.pPz + " operation:" + this.cuy);
        if (jSONObject.has("real_name_info")) {
            optJSONObject = jSONObject.optJSONObject("real_name_info");
            ab.i("Micromsg.NetSceneTenpayBalanceFetch", "get real_name_info %s", optJSONObject.toString());
            this.cRb = optJSONObject.optString("guide_flag");
            this.cRc = optJSONObject.optString("guide_wording");
            this.cRd = optJSONObject.optString("left_button_wording");
            this.cRe = optJSONObject.optString("right_button_wording");
            this.cRf = optJSONObject.optString("upload_credit_url");
        }
        this.tfc = jSONObject.optBoolean("need_large_account_tip");
        if (this.tfc && jSONObject.has("large_account_tip")) {
            ab.i("Micromsg.NetSceneTenpayBalanceFetch", "get large_account_tip");
            a aVar = new a();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("large_account_tip");
            aVar.title = optJSONObject2.optString("title");
            aVar.content = optJSONObject2.optString(FirebaseAnalytics.b.CONTENT);
            aVar.tff = optJSONObject2.optString("button_name");
            aVar.tfg = optJSONObject2.optString("button_jump_url");
            ab.d("Micromsg.NetSceneTenpayBalanceFetch", "parseLargeAccountTipDialog() title:%s content:%s button_name:%s button_jump_url:%s", bo.nullAsNil(aVar.title), bo.nullAsNil(aVar.content), bo.nullAsNil(aVar.tff), bo.nullAsNil(aVar.tfg));
            this.tfd = aVar;
        }
        String str2 = "Micromsg.NetSceneTenpayBalanceFetch";
        String str3 = "needLargeAccountTip:%s accountTipDialog:%s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.tfc);
        if (this.tfd == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        ab.i(str2, str3, objArr);
        this.tfe = new RetryPayInfo();
        this.tfe.aA(jSONObject);
        this.tfb = jSONObject.optString("charge_checkout_wording");
        this.tfa = j.ay(jSONObject.optJSONObject("fetch_alert_dialog"));
        AppMethodBeat.o(45224);
    }

    public final int ZU() {
        return 1503;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/genprefetch";
    }

    public final RetryPayInfo cMC() {
        return this.tfe;
    }
}
