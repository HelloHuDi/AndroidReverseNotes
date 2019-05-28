package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends m {
    public String desc;
    public double pPz;
    public String pcl;

    public c(String str) {
        AppMethodBeat.i(45919);
        HashMap hashMap = new HashMap();
        hashMap.put("token", str);
        M(hashMap);
        AppMethodBeat.o(45919);
    }

    public final int bgI() {
        return 123;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(45920);
        if (i == 0) {
            this.pcl = jSONObject.optString("fee_type");
            this.pPz = jSONObject.optDouble("total_fee") / 100.0d;
            JSONArray optJSONArray = jSONObject.optJSONArray("Array");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.desc = ((JSONObject) optJSONArray.opt(0)).optString("desc");
            }
            ah cPJ = r.cPJ();
            JSONObject optJSONObject = jSONObject.optJSONObject("bindqueryresp");
            cPJ.tCN.clear();
            if (optJSONObject == null) {
                ab.e("MicroMsg.WalletRepaymentBankcardMgr", "parse from json error,json is null");
                AppMethodBeat.o(45920);
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
                    d cPh = d.cPh();
                    try {
                        jSONObject2 = (JSONObject) optJSONArray2.get(i3);
                    } catch (JSONException e) {
                        ab.printErrStackTrace("MicroMsg.WalletRepaymentBankcardMgr", e, "", new Object[0]);
                        jSONObject2 = null;
                    }
                    if (jSONObject2 != null) {
                        Bankcard ar = cPh.ar(jSONObject2);
                        if (ar.cPc()) {
                            ar.field_desc = ar.field_bankName;
                        } else if (ar.cPe()) {
                            ar.field_desc = com.tencent.mm.sdk.platformtools.ah.getContext().getString(R.string.fdv, new Object[]{ar.field_bankName, ar.field_bankcardTail});
                        } else if (ar.cPb()) {
                            ar.field_desc = com.tencent.mm.sdk.platformtools.ah.getContext().getString(R.string.fwm, new Object[]{ar.field_bankName, ar.field_bankcardTail});
                        } else {
                            ar.field_desc = com.tencent.mm.sdk.platformtools.ah.getContext().getString(R.string.fee, new Object[]{ar.field_bankName, ar.field_bankcardTail});
                        }
                        cPJ.tCN.add(ar);
                    }
                    i2 = i3 + 1;
                }
            } else {
                ab.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list is null");
            }
            jSONObject2 = optJSONObject.optJSONObject("user_info");
            if (jSONObject2 != null) {
                cPJ.tCO = jSONObject2.optString("last_card_bind_serialno");
                AppMethodBeat.o(45920);
                return;
            }
            ab.e("MicroMsg.WalletRepaymentBankcardMgr", "user_info is null");
        }
        AppMethodBeat.o(45920);
    }

    public final int ZU() {
        return 1603;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/webankloanordershow";
    }
}
