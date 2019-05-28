package com.tencent.mm.plugin.wallet.bind.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends m {
    public boolean cQT = false;
    public ArrayList<Bankcard> tgB = null;
    public boolean tlh = true;
    public String tli;
    public String tlj;
    private String tlk;
    public String token;

    public c(String str, PayInfo payInfo) {
        AppMethodBeat.i(45728);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        a(payInfo, (Map) hashMap, (Map) hashMap2);
        g.RQ();
        p pVar = new p(bo.a((Integer) g.RP().Ry().get(9, null), 0));
        this.tlk = str;
        hashMap.put("import_code", str);
        hashMap.put("qqid", pVar.toString());
        M(hashMap);
        ba(hashMap2);
        AppMethodBeat.o(45728);
    }

    public final int bgI() {
        return 37;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(45729);
        if (i != 0) {
            AppMethodBeat.o(45729);
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
                Bankcard ar = d.cPh().ar(jSONObject2);
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
                        ar.field_desc = ah.getContext().getString(R.string.fdv, new Object[]{ar.field_bankName, ar.field_bankcardTail});
                    } else if (ar.cPb()) {
                        ar.field_desc = ah.getContext().getString(R.string.fwm, new Object[]{ar.field_bankName, ar.field_bankcardTail});
                    } else {
                        ar.field_desc = ah.getContext().getString(R.string.fee, new Object[]{ar.field_bankName, ar.field_bankcardTail});
                    }
                    JSONObject optJSONObject = jSONObject2.optJSONObject("bankappservice");
                    if (optJSONObject != null) {
                        this.tli = optJSONObject.optString("username");
                        this.tlj = optJSONObject.optString("app_recommend_desc");
                    }
                    this.tgB.add(ar);
                }
            }
            ab.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "got data---isReg:" + this.cQT + ",bankcard.size:" + this.tgB.size());
            AppMethodBeat.o(45729);
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.NetSceneTenpayQueryBindBankcard", e, "", new Object[0]);
            AppMethodBeat.o(45729);
        }
    }
}
