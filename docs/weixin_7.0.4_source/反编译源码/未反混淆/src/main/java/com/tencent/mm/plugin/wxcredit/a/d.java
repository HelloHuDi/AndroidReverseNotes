package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends m {
    public k uYw;

    public d(String str, String str2) {
        AppMethodBeat.i(48659);
        HashMap hashMap = new HashMap();
        hashMap.put("bind_serialno", str);
        hashMap.put("bank_type", str2);
        hashMap.put("query_method", "1");
        M(hashMap);
        hashMap = new HashMap();
        hashMap.put("banktype", str2);
        ba(hashMap);
        AppMethodBeat.o(48659);
    }

    public final int bgI() {
        return 57;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        boolean z = true;
        AppMethodBeat.i(48660);
        ab.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(48660);
            return;
        }
        try {
            this.uYw = new k();
            this.uYw.uYA = jSONObject.optInt("credit_state");
            this.uYw.uYv = ((double) jSONObject.optInt("credit_amount")) / 100.0d;
            this.uYw.uYB = ((double) jSONObject.optInt("credit_usable")) / 100.0d;
            this.uYw.uYC = ((double) jSONObject.optInt("bill_amount")) / 100.0d;
            this.uYw.uYD = jSONObject.optInt("bill_date");
            this.uYw.uYE = ((double) jSONObject.optInt("repay_amount")) / 100.0d;
            this.uYw.uYF = ((double) jSONObject.optInt("repay_minimum")) / 100.0d;
            k kVar = this.uYw;
            if (jSONObject.optInt("upgrade_amount") != 1) {
                z = false;
            }
            kVar.uYG = z;
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
                this.uYw.uYO = new j();
                this.uYw.uYO.uYz = jSONObject3.getString("app_telephone");
                this.uYw.uYO.nickname = jSONObject3.getString("nickname");
                this.uYw.uYO.username = jSONObject3.getString("username");
                this.uYw.uYO.url = jSONObject3.getString("jump_url");
            }
            AppMethodBeat.o(48660);
        } catch (Exception e) {
            ab.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            AppMethodBeat.o(48660);
        }
    }
}
