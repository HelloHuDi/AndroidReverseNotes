package com.tencent.p177mm.plugin.wallet_core.p749c.p1659b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22586aj;
import com.tencent.p177mm.plugin.wallet_core.model.C22587ak;
import com.tencent.p177mm.plugin.wallet_core.model.p1314a.C22580a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import com.tencent.p177mm.wallet_core.p649c.C30862w;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.b.a */
public final class C46358a extends C36383a {
    private boolean tuJ;

    public C46358a() {
        this("");
    }

    public C46358a(String str) {
        this(str, true);
    }

    public C46358a(String str, boolean z) {
        AppMethodBeat.m2504i(46569);
        HashMap hashMap = new HashMap();
        hashMap.put("req_key", str);
        mo70323M(hashMap);
        this.tuJ = z;
        AppMethodBeat.m2505o(46569);
    }

    public final int cOX() {
        return 1;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46570);
        int a = super.mo4456a(c1902e, c1202f);
        AppMethodBeat.m2505o(46570);
        return a;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46571);
        C4990ab.m7417i("MicroMsg.NetScenePayUQueryBoundBankcard", "hy: payu query bind on gy net end. errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        if (i != 0) {
            AppMethodBeat.m2505o(46571);
            return;
        }
        try {
            Bankcard bankcard;
            long optLong = jSONObject.optLong("time_stamp");
            if (optLong > 0) {
                C30862w.setTimeStamp(String.valueOf(optLong));
            } else {
                C4990ab.m7420w("MicroMsg.NetScenePayUQueryBoundBankcard", "no time_stamp in bindquerynew.");
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("user_info");
            C22586aj c22586aj = new C22586aj();
            if (jSONObject2 == null || jSONObject2.length() <= 0) {
                c22586aj = null;
            } else {
                c22586aj.field_is_reg = C5046bo.getInt(jSONObject2.optString("is_reg"), 0);
                c22586aj.field_true_name = jSONObject2.optString("true_name");
                c22586aj.field_main_card_bind_serialno = jSONObject2.optString("main_card_bind_serialno");
                c22586aj.field_ftf_pay_url = jSONObject2.optString("transfer_url");
                C14241r.cPI();
                C22587ak.acD(c22586aj.field_main_card_bind_serialno);
            }
            c22586aj.field_switchConfig = jSONObject.getJSONObject("switch_info").getInt("switch_bit");
            JSONArray optJSONArray = jSONObject.optJSONArray("Array");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                    jSONObject3.put("extra_bind_flag", "NORMAL");
                    Bankcard ar = C22580a.cQY().mo38120ar(jSONObject3);
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
                bankcard.field_desc = C4996ah.getContext().getString(C25738R.string.ffn);
                bankcard.field_cardType |= Bankcard.twI;
            }
            C14241r.cPI().mo38133a(c22586aj, arrayList, null, bankcard, null, null, null, null, 0, 0, null);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetScenePayUQueryBoundBankcard", e, "", new Object[0]);
        }
        if (this.tuJ && !C14241r.cPI().cQg()) {
            this.ehi.onSceneEnd(1000, -100869, "", this);
            this.AfK = true;
        }
        AppMethodBeat.m2505o(46571);
    }
}
