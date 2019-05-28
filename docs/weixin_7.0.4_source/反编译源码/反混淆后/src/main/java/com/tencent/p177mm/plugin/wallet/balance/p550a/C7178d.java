package com.tencent.p177mm.plugin.wallet.balance.p550a;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.wallet_core.model.C22590b;
import com.tencent.p177mm.plugin.wallet_core.model.C29631j;
import com.tencent.p177mm.plugin.wallet_core.model.C43804af;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C44426i;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import com.tencent.p177mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.p177mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import java.math.RoundingMode;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.d */
public final class C7178d extends C5749m implements C44426i, ITenpaySave {
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
    public C22590b teY;
    public C22590b teZ;
    public C29631j tfa;
    public String tfb;
    public boolean tfc = false;
    public C7179a tfd;
    private RetryPayInfo tfe;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.d$a */
    public static class C7179a {
        public String content;
        public String tff;
        public String tfg;
        public String title;
    }

    public C7178d(double d, String str, String str2, int i) {
        AppMethodBeat.m2504i(45223);
        HashMap hashMap = new HashMap();
        hashMap.put("total_fee", C36391e.m59997b(String.valueOf(d), "100", 0, RoundingMode.HALF_UP).toString());
        hashMap.put("fee_type", str);
        hashMap.put("bank_type", str2);
        hashMap.put("operation", String.valueOf(i));
        hashMap.put("charge_rate_version", (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_FETCH_CHARGE_RATE_VERSION_STRING_SYNC, (Object) ""));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(45223);
    }

    public final int bgI() {
        return 75;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        boolean z = false;
        AppMethodBeat.m2504i(45224);
        C4990ab.m7410d("Micromsg.NetSceneTenpayBalanceFetch", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(45224);
            return;
        }
        this.cBT = jSONObject.optString("req_key");
        this.teW = "1".equals(jSONObject.optString("should_alert"));
        this.teX = jSONObject.optString("alert_msg");
        this.pPp = jSONObject.optDouble("charge_fee", 0.0d) / 100.0d;
        this.pPz = jSONObject.optDouble("total_fee", 0.0d) / 100.0d;
        JSONObject optJSONObject = jSONObject.optJSONObject("first_fetch_info");
        if (optJSONObject != null) {
            C4990ab.m7416i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is valid");
            this.teY = C43804af.m78519a(optJSONObject, false);
        } else {
            C4990ab.m7412e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is null");
        }
        optJSONObject = jSONObject.optJSONObject("need_charge_fee_info");
        if (optJSONObject != null) {
            C4990ab.m7416i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is valid");
            this.teZ = C43804af.m78519a(optJSONObject, false);
        } else {
            C4990ab.m7412e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is null");
        }
        this.cuy = jSONObject.optInt("operation", 0);
        C4990ab.m7416i("Micromsg.NetSceneTenpayBalanceFetch", "charge_fee:" + this.pPp + " total_fee:" + this.pPz + " operation:" + this.cuy);
        if (jSONObject.has("real_name_info")) {
            optJSONObject = jSONObject.optJSONObject("real_name_info");
            C4990ab.m7417i("Micromsg.NetSceneTenpayBalanceFetch", "get real_name_info %s", optJSONObject.toString());
            this.cRb = optJSONObject.optString("guide_flag");
            this.cRc = optJSONObject.optString("guide_wording");
            this.cRd = optJSONObject.optString("left_button_wording");
            this.cRe = optJSONObject.optString("right_button_wording");
            this.cRf = optJSONObject.optString("upload_credit_url");
        }
        this.tfc = jSONObject.optBoolean("need_large_account_tip");
        if (this.tfc && jSONObject.has("large_account_tip")) {
            C4990ab.m7416i("Micromsg.NetSceneTenpayBalanceFetch", "get large_account_tip");
            C7179a c7179a = new C7179a();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("large_account_tip");
            c7179a.title = optJSONObject2.optString("title");
            c7179a.content = optJSONObject2.optString(C8741b.CONTENT);
            c7179a.tff = optJSONObject2.optString("button_name");
            c7179a.tfg = optJSONObject2.optString("button_jump_url");
            C4990ab.m7411d("Micromsg.NetSceneTenpayBalanceFetch", "parseLargeAccountTipDialog() title:%s content:%s button_name:%s button_jump_url:%s", C5046bo.nullAsNil(c7179a.title), C5046bo.nullAsNil(c7179a.content), C5046bo.nullAsNil(c7179a.tff), C5046bo.nullAsNil(c7179a.tfg));
            this.tfd = c7179a;
        }
        String str2 = "Micromsg.NetSceneTenpayBalanceFetch";
        String str3 = "needLargeAccountTip:%s accountTipDialog:%s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.tfc);
        if (this.tfd == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        C4990ab.m7417i(str2, str3, objArr);
        this.tfe = new RetryPayInfo();
        this.tfe.mo39956aA(jSONObject);
        this.tfb = jSONObject.optString("charge_checkout_wording");
        this.tfa = C29631j.m46999ay(jSONObject.optJSONObject("fetch_alert_dialog"));
        AppMethodBeat.m2505o(45224);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1503;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/genprefetch";
    }

    public final RetryPayInfo cMC() {
        return this.tfe;
    }
}
