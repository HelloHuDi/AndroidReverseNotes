package com.tencent.p177mm.plugin.wxcredit.p1334a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wxcredit.a.d */
public final class C40408d extends C5749m {
    public C40409k uYw;

    public C40408d(String str, String str2) {
        AppMethodBeat.m2504i(48659);
        HashMap hashMap = new HashMap();
        hashMap.put("bind_serialno", str);
        hashMap.put("bank_type", str2);
        hashMap.put("query_method", "1");
        mo70323M(hashMap);
        hashMap = new HashMap();
        hashMap.put("banktype", str2);
        mo70328ba(hashMap);
        AppMethodBeat.m2505o(48659);
    }

    public final int bgI() {
        return 57;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        boolean z = true;
        AppMethodBeat.m2504i(48660);
        C4990ab.m7410d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(48660);
            return;
        }
        try {
            this.uYw = new C40409k();
            this.uYw.uYA = jSONObject.optInt("credit_state");
            this.uYw.uYv = ((double) jSONObject.optInt("credit_amount")) / 100.0d;
            this.uYw.uYB = ((double) jSONObject.optInt("credit_usable")) / 100.0d;
            this.uYw.uYC = ((double) jSONObject.optInt("bill_amount")) / 100.0d;
            this.uYw.uYD = jSONObject.optInt("bill_date");
            this.uYw.uYE = ((double) jSONObject.optInt("repay_amount")) / 100.0d;
            this.uYw.uYF = ((double) jSONObject.optInt("repay_minimum")) / 100.0d;
            C40409k c40409k = this.uYw;
            if (jSONObject.optInt("upgrade_amount") != 1) {
                z = false;
            }
            c40409k.uYG = z;
            this.uYw.uYH = jSONObject.optInt("bill_month");
            this.uYw.uYI = jSONObject.optString("repay_url");
            this.uYw.uYJ = jSONObject.optString("repay_lasttime");
            this.uYw.uYM = jSONObject.optString("lasttime");
            JSONArray jSONArray = jSONObject.getJSONArray("jump_url_array");
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    String string = jSONObject2.getString("jump_name");
                    if ("account_rights_url".equals(string)) {
                        this.uYw.uYL = jSONObject2.getString("jump_url");
                    } else if ("bill_url".equals(string)) {
                        this.uYw.pPO = jSONObject2.getString("jump_url");
                    } else if ("card_detail_url".equals(string)) {
                        this.uYw.uYK = jSONObject2.getString("jump_url");
                    } else if ("know_more_url".equals(string)) {
                        this.uYw.uYN = jSONObject2.getString("jump_url");
                    }
                }
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("appservice");
            if (jSONObject3 != null) {
                this.uYw.uYO = new C23212j();
                this.uYw.uYO.uYz = jSONObject3.getString("app_telephone");
                this.uYw.uYO.nickname = jSONObject3.getString("nickname");
                this.uYw.uYO.username = jSONObject3.getString("username");
                this.uYw.uYO.url = jSONObject3.getString("jump_url");
            }
            AppMethodBeat.m2505o(48660);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            AppMethodBeat.m2505o(48660);
        }
    }
}
