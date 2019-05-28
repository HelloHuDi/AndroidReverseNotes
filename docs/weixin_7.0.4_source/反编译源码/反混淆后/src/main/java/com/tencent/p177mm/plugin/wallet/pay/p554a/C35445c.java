package com.tencent.p177mm.plugin.wallet.pay.p554a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22585ah;
import com.tencent.p177mm.plugin.wallet_core.model.C29630d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pay.a.c */
public final class C35445c extends C5749m {
    public String desc;
    public double pPz;
    public String pcl;

    public C35445c(String str) {
        AppMethodBeat.m2504i(45919);
        HashMap hashMap = new HashMap();
        hashMap.put("token", str);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(45919);
    }

    public final int bgI() {
        return 123;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(45920);
        if (i == 0) {
            this.pcl = jSONObject.optString("fee_type");
            this.pPz = jSONObject.optDouble("total_fee") / 100.0d;
            JSONArray optJSONArray = jSONObject.optJSONArray("Array");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.desc = ((JSONObject) optJSONArray.opt(0)).optString("desc");
            }
            C22585ah cPJ = C14241r.cPJ();
            JSONObject optJSONObject = jSONObject.optJSONObject("bindqueryresp");
            cPJ.tCN.clear();
            if (optJSONObject == null) {
                C4990ab.m7412e("MicroMsg.WalletRepaymentBankcardMgr", "parse from json error,json is null");
                AppMethodBeat.m2505o(45920);
                return;
            }
            JSONObject jSONObject2;
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("Array");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= optJSONArray2.length()) {
                        break;
                    }
                    C29630d cPh = C29630d.cPh();
                    try {
                        jSONObject2 = (JSONObject) optJSONArray2.get(i3);
                    } catch (JSONException e) {
                        C4990ab.printErrStackTrace("MicroMsg.WalletRepaymentBankcardMgr", e, "", new Object[0]);
                        jSONObject2 = null;
                    }
                    if (jSONObject2 != null) {
                        Bankcard ar = cPh.mo38120ar(jSONObject2);
                        if (ar.cPc()) {
                            ar.field_desc = ar.field_bankName;
                        } else if (ar.cPe()) {
                            ar.field_desc = C4996ah.getContext().getString(C25738R.string.fdv, new Object[]{ar.field_bankName, ar.field_bankcardTail});
                        } else if (ar.cPb()) {
                            ar.field_desc = C4996ah.getContext().getString(C25738R.string.fwm, new Object[]{ar.field_bankName, ar.field_bankcardTail});
                        } else {
                            ar.field_desc = C4996ah.getContext().getString(C25738R.string.fee, new Object[]{ar.field_bankName, ar.field_bankcardTail});
                        }
                        cPJ.tCN.add(ar);
                    }
                    i2 = i3 + 1;
                }
            } else {
                C4990ab.m7412e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list is null");
            }
            jSONObject2 = optJSONObject.optJSONObject("user_info");
            if (jSONObject2 != null) {
                cPJ.tCO = jSONObject2.optString("last_card_bind_serialno");
                AppMethodBeat.m2505o(45920);
                return;
            }
            C4990ab.m7412e("MicroMsg.WalletRepaymentBankcardMgr", "user_info is null");
        }
        AppMethodBeat.m2505o(45920);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1603;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/webankloanordershow";
    }
}
