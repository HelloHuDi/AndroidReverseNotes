package com.tencent.mm.plugin.wallet_core.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.w;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    private boolean tuJ;

    public a() {
        this("");
    }

    public a(String str) {
        this(str, true);
    }

    public a(String str, boolean z) {
        AppMethodBeat.i(46569);
        HashMap hashMap = new HashMap();
        hashMap.put("req_key", str);
        M(hashMap);
        this.tuJ = z;
        AppMethodBeat.o(46569);
    }

    public final int cOX() {
        return 1;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(46570);
        int a = super.a(eVar, fVar);
        AppMethodBeat.o(46570);
        return a;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46571);
        ab.i("MicroMsg.NetScenePayUQueryBoundBankcard", "hy: payu query bind on gy net end. errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        if (i != 0) {
            AppMethodBeat.o(46571);
            return;
        }
        try {
            Bankcard bankcard;
            long optLong = jSONObject.optLong("time_stamp");
            if (optLong > 0) {
                w.setTimeStamp(String.valueOf(optLong));
            } else {
                ab.w("MicroMsg.NetScenePayUQueryBoundBankcard", "no time_stamp in bindquerynew.");
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
            aj ajVar = new aj();
            if (jSONObject2 == null || jSONObject2.length() <= 0) {
                ajVar = null;
            } else {
                ajVar.field_is_reg = bo.getInt(jSONObject2.optString("is_reg"), 0);
                ajVar.field_true_name = jSONObject2.optString("true_name");
                ajVar.field_main_card_bind_serialno = jSONObject2.optString("main_card_bind_serialno");
                ajVar.field_ftf_pay_url = jSONObject2.optString("transfer_url");
                r.cPI();
                ak.acD(ajVar.field_main_card_bind_serialno);
            }
            ajVar.field_switchConfig = jSONObject.getJSONObject("switch_info").getInt("switch_bit");
            JSONArray optJSONArray = jSONObject.optJSONArray("Array");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                    jSONObject3.put("extra_bind_flag", "NORMAL");
                    Bankcard ar = com.tencent.mm.plugin.wallet_core.model.a.a.cQY().ar(jSONObject3);
                    if (ar != null) {
                        arrayList.add(ar);
                    }
                }
            }
            jSONObject2 = jSONObject.optJSONObject("balance_info");
            if (jSONObject2 == null || jSONObject2.length() <= 0) {
                bankcard = null;
            } else {
                bankcard = new Bankcard((byte) 0);
                bankcard.twS = ((double) jSONObject2.optInt("avail_balance")) / 100.0d;
                bankcard.twU = ((double) jSONObject2.optInt("fetch_balance")) / 100.0d;
                bankcard.field_bankcardType = jSONObject2.optString("balance_bank_type");
                bankcard.field_bindSerial = jSONObject2.optString("balance_bind_serial");
                bankcard.field_forbidWord = jSONObject2.optString("balance_forbid_word");
                bankcard.field_desc = ah.getContext().getString(R.string.ffn);
                bankcard.field_cardType |= Bankcard.twI;
            }
            r.cPI().a(ajVar, arrayList, null, bankcard, null, null, null, null, 0, 0, null);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetScenePayUQueryBoundBankcard", e, "", new Object[0]);
        }
        if (this.tuJ && !r.cPI().cQg()) {
            this.ehi.onSceneEnd(1000, -100869, "", this);
            this.AfK = true;
        }
        AppMethodBeat.o(46571);
    }
}
