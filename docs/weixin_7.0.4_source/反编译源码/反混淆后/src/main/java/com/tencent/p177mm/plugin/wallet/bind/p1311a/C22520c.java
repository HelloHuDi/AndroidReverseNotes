package com.tencent.p177mm.plugin.wallet.bind.p1311a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C29630d;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.bind.a.c */
public final class C22520c extends C5749m {
    public boolean cQT = false;
    public ArrayList<Bankcard> tgB = null;
    public boolean tlh = true;
    public String tli;
    public String tlj;
    private String tlk;
    public String token;

    public C22520c(String str, PayInfo payInfo) {
        AppMethodBeat.m2504i(45728);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        mo70324a(payInfo, (Map) hashMap, (Map) hashMap2);
        C1720g.m3537RQ();
        C1183p c1183p = new C1183p(C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(9, null), 0));
        this.tlk = str;
        hashMap.put("import_code", str);
        hashMap.put("qqid", c1183p.toString());
        mo70323M(hashMap);
        mo70328ba(hashMap2);
        AppMethodBeat.m2505o(45728);
    }

    public final int bgI() {
        return 37;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(45729);
        if (i != 0) {
            AppMethodBeat.m2505o(45729);
            return;
        }
        this.tgB = new ArrayList();
        try {
            this.cQT = "1".equals(jSONObject.optString("is_reg", AppEventsConstants.EVENT_PARAM_VALUE_NO));
            this.token = jSONObject.optString("token", "");
            JSONArray jSONArray = jSONObject.getJSONArray("Array");
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                Bankcard ar = C29630d.cPh().mo38120ar(jSONObject2);
                if (ar != null) {
                    if ((2 == jSONObject2.optInt("bank_acc_type", 2) ? 1 : null) != null) {
                        ar.field_cardType |= Bankcard.twG;
                    }
                    ar.field_bankcardTail = jSONObject2.optString("bank_tail");
                    ar.twO = "************" + ar.field_bankcardTail;
                    ar.field_trueName = jSONObject2.optString("true_name");
                    ar.twN = jSONObject2.optString("cre_id");
                    ar.twf = jSONObject2.optInt("cre_type", -1);
                    ar.txa = this.tlk;
                    ar.txb = 1 == jSONObject2.optInt("samecardexist", 0);
                    if (ar.cPc()) {
                        ar.field_desc = ar.field_bankName;
                    } else if (ar.cPe()) {
                        ar.field_desc = C4996ah.getContext().getString(C25738R.string.fdv, new Object[]{ar.field_bankName, ar.field_bankcardTail});
                    } else if (ar.cPb()) {
                        ar.field_desc = C4996ah.getContext().getString(C25738R.string.fwm, new Object[]{ar.field_bankName, ar.field_bankcardTail});
                    } else {
                        ar.field_desc = C4996ah.getContext().getString(C25738R.string.fee, new Object[]{ar.field_bankName, ar.field_bankcardTail});
                    }
                    JSONObject optJSONObject = jSONObject2.optJSONObject("bankappservice");
                    if (optJSONObject != null) {
                        this.tli = optJSONObject.optString("username");
                        this.tlj = optJSONObject.optString("app_recommend_desc");
                    }
                    this.tgB.add(ar);
                }
            }
            C4990ab.m7410d("MicroMsg.NetSceneTenpayQueryBindBankcard", "got data---isReg:" + this.cQT + ",bankcard.size:" + this.tgB.size());
            AppMethodBeat.m2505o(45729);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneTenpayQueryBindBankcard", e, "", new Object[0]);
            AppMethodBeat.m2505o(45729);
        }
    }
}
