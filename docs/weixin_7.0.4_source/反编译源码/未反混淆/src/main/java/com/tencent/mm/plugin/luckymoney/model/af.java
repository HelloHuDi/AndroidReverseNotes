package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class af extends ak {
    long cvx;
    public String nYA;
    public int nYB;
    public LuckyMoneyEmojiSwitch nYC;
    public k nYn;
    public String nYz;
    String talker;

    public af(String str, int i, int i2, String str2, String str3) {
        this(str, i, i2, str2, str3, "");
    }

    public af(String str, int i, String str2, long j, String str3, String str4) {
        AppMethodBeat.i(42397);
        this.nYn = null;
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", "11");
        hashMap.put("offset", String.valueOf(i));
        if (!bo.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("befortTimestamp", String.valueOf(j));
        hashMap.put("ver", str3);
        hashMap.put("processContent", str4);
        M(hashMap);
        AppMethodBeat.o(42397);
    }

    public af(String str, int i, int i2, String str2, String str3, String str4) {
        AppMethodBeat.i(42398);
        this.nYn = null;
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", String.valueOf(i));
        hashMap.put("offset", String.valueOf(i2));
        if (!bo.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("ver", str3);
        hashMap.put("processContent", str4);
        M(hashMap);
        AppMethodBeat.o(42398);
    }

    public final int getType() {
        return 1585;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/qrydetailwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(42399);
        try {
            this.nYn = v.W(jSONObject);
            this.nYz = jSONObject.optString("processContent");
            this.nYC = LuckyMoneyEmojiSwitch.V(jSONObject);
            ab.i("MicroMsg.NetSceneLuckyMoneyDetail", "luckyMoneyEmojiSwitch:%s", this.nYC.toString());
            this.nYA = jSONObject.optString("expression_md5");
            this.nYB = jSONObject.optInt("expression_type");
            ab.i("MicroMsg.NetSceneLuckyMoneyDetail", "expressionmd5:%s expressiontype:%s", this.nYA, Integer.valueOf(this.nYB));
            g.RQ();
            int intValue = ((Integer) g.RP().Ry().get(a.USERINFO_LUCKY_MONEY_HONGBAO_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue();
            int a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_hongbao_emoji_all_switch, 0);
            if (bo.gW(intValue, 1) || bo.gW(a, 1)) {
                if (this.nYC == null) {
                    this.nYC = new LuckyMoneyEmojiSwitch();
                }
                this.nYC.nXp = 1;
                this.nYC.nXq = 1;
                this.nYC.nXr = 1;
                this.nYC.nXs = 1;
            }
            ab.i("MicroMsg.NetSceneLuckyMoneyDetail", "localSwitch() luckyMoneyEmojiSwitch:%s ", this.nYC.toString());
            AppMethodBeat.o(42399);
        } catch (JSONException e) {
            ab.w("MicroMsg.NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + e.getLocalizedMessage());
            AppMethodBeat.o(42399);
        }
    }
}
