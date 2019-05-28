package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.af */
public final class C12425af extends C34442ak {
    long cvx;
    public String nYA;
    public int nYB;
    public LuckyMoneyEmojiSwitch nYC;
    public C12428k nYn;
    public String nYz;
    String talker;

    public C12425af(String str, int i, int i2, String str2, String str3) {
        this(str, i, i2, str2, str3, "");
    }

    public C12425af(String str, int i, String str2, long j, String str3, String str4) {
        AppMethodBeat.m2504i(42397);
        this.nYn = null;
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", "11");
        hashMap.put("offset", String.valueOf(i));
        if (!C5046bo.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("befortTimestamp", String.valueOf(j));
        hashMap.put("ver", str3);
        hashMap.put("processContent", str4);
        mo46410M(hashMap);
        AppMethodBeat.m2505o(42397);
    }

    public C12425af(String str, int i, int i2, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(42398);
        this.nYn = null;
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("limit", String.valueOf(i));
        hashMap.put("offset", String.valueOf(i2));
        if (!C5046bo.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("ver", str3);
        hashMap.put("processContent", str4);
        mo46410M(hashMap);
        AppMethodBeat.m2505o(42398);
    }

    public final int getType() {
        return 1585;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/qrydetailwxhb";
    }

    /* renamed from: a */
    public final void mo7791a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(42399);
        try {
            this.nYn = C43263v.m77008W(jSONObject);
            this.nYz = jSONObject.optString("processContent");
            this.nYC = LuckyMoneyEmojiSwitch.m20343V(jSONObject);
            C4990ab.m7417i("MicroMsg.NetSceneLuckyMoneyDetail", "luckyMoneyEmojiSwitch:%s", this.nYC.toString());
            this.nYA = jSONObject.optString("expression_md5");
            this.nYB = jSONObject.optInt("expression_type");
            C4990ab.m7417i("MicroMsg.NetSceneLuckyMoneyDetail", "expressionmd5:%s expressiontype:%s", this.nYA, Integer.valueOf(this.nYB));
            C1720g.m3537RQ();
            int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LUCKY_MONEY_HONGBAO_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue();
            int a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_hongbao_emoji_all_switch, 0);
            if (C5046bo.m7563gW(intValue, 1) || C5046bo.m7563gW(a, 1)) {
                if (this.nYC == null) {
                    this.nYC = new LuckyMoneyEmojiSwitch();
                }
                this.nYC.nXp = 1;
                this.nYC.nXq = 1;
                this.nYC.nXr = 1;
                this.nYC.nXs = 1;
            }
            C4990ab.m7417i("MicroMsg.NetSceneLuckyMoneyDetail", "localSwitch() luckyMoneyEmojiSwitch:%s ", this.nYC.toString());
            AppMethodBeat.m2505o(42399);
        } catch (JSONException e) {
            C4990ab.m7420w("MicroMsg.NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + e.getLocalizedMessage());
            AppMethodBeat.m2505o(42399);
        }
    }
}
