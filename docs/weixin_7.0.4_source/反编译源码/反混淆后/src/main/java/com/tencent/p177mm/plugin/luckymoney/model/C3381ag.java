package com.tencent.p177mm.plugin.luckymoney.model;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.luckymoney.p735b.C6964a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.ag */
public final class C3381ag extends C34442ak {
    public String few;
    public int kCv;
    public String kCx;
    public String nRT;
    public String nRU;
    public String nSd;
    public C43255as nXf;
    public String nYD;
    public boolean nYE;
    public int nYF;
    public String nYG;
    public C43255as nYH;
    public C43255as nYI;
    public C43255as nYJ;
    public int nYK = 0;
    public int nYL = 0;
    public int nYM = 0;
    public int nYN = 0;
    public int nYO = 0;
    public LinkedList<C43262u> nYP;

    public C3381ag(String str, int i) {
        AppMethodBeat.m2504i(42400);
        HashMap hashMap = new HashMap();
        hashMap.put("scene", "8");
        hashMap.put("ver", str);
        C1720g.m3537RQ();
        hashMap.put("walletType", String.valueOf(C1720g.m3536RP().mo5239Ry().get(339975, null)));
        hashMap.put("hasSource", String.valueOf(i));
        mo46410M(hashMap);
        AppMethodBeat.m2505o(42400);
    }

    public C3381ag(String str, int i, byte b) {
        AppMethodBeat.m2504i(42401);
        HashMap hashMap = new HashMap();
        hashMap.put("ver", str);
        C1720g.m3537RQ();
        hashMap.put("walletType", String.valueOf(C1720g.m3536RP().mo5239Ry().get(339975, null)));
        hashMap.put("hasSource", String.valueOf(i));
        mo46410M(hashMap);
        AppMethodBeat.m2505o(42401);
    }

    public final int getType() {
        return 1554;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/operationwxhb";
    }

    /* renamed from: a */
    public final void mo7791a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(42402);
        if (i == 0) {
            this.nYF = jSONObject.optInt("randomAmount");
            this.nYD = jSONObject.optString("randomWishing");
            this.kCx = jSONObject.optString("notice");
            this.nYG = jSONObject.optString("notice_url");
            this.nYE = jSONObject.optInt("hasCanShareHongBao") == 1;
            this.kCv = jSONObject.optInt(C8741b.CURRENCY);
            this.nRT = jSONObject.optString("currencyUint");
            this.nRU = jSONObject.optString("currencyWording");
            this.few = jSONObject.optString("unique_id");
            C4990ab.m7416i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.kCv + ";currencyUint=" + this.nRT + ";currencyWording=" + this.nRU + ";uniqueId=" + this.few);
            C21200i c21200i = new C21200i();
            c21200i.nWH = jSONObject.optString("groupHint");
            c21200i.nWI = jSONObject.optString("personalHint");
            c21200i.nRR = ((double) jSONObject.optLong("totalAmount", 200000)) / 100.0d;
            c21200i.nRO = jSONObject.optInt("totalNum", 100);
            c21200i.nRP = ((double) jSONObject.optLong("perPersonMaxValue", 20000)) / 100.0d;
            c21200i.nRS = ((double) jSONObject.optLong("perGroupMaxValue", 20000)) / 100.0d;
            c21200i.nRQ = ((double) jSONObject.optLong("perMinValue", 1)) / 100.0d;
            c21200i.nWJ = jSONObject.optInt("payShowBGFlag");
            c21200i.kCv = this.kCv;
            c21200i.nRT = this.nRT;
            c21200i.nRU = this.nRU;
            c21200i.nWK = jSONObject.optString("foreignFaqUrl");
            c21200i.nWL = jSONObject.optString("foreignHongBaoName");
            c21200i.nWM = jSONObject.optString("showSourceAndMac");
            C4990ab.m7417i("MicroMsg.NetSceneLuckyMoneyGetConfig", "foreignFaqUrl: %s, foreignHongBaoName: %s", c21200i.nWK, c21200i.nWL);
            C6964a.bKN();
            C28426j bKO = C6964a.bKO();
            bKO.nSs = c21200i;
            bKO.bLt();
            C4990ab.m7416i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + bKO.nSs.nRR + " maxTotalNum:" + bKO.nSs.nRO + " perGroupMaxValue:" + bKO.nSs.nRS + " perMinValue:" + bKO.nSs.nRQ + " perPersonMaxValue:" + bKO.nSs.nRP);
            try {
                Object str2 = new String(bKO.nSs.toByteArray(), "ISO-8859-1");
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(356355, str2);
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().dsb();
            } catch (UnsupportedEncodingException e) {
                C4990ab.m7420w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e.getLocalizedMessage());
            } catch (IOException e2) {
                C4990ab.m7420w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e2.getLocalizedMessage());
            }
            this.nYH = C43263v.m77010Y(jSONObject.optJSONObject("operationHeader"));
            this.nXf = C43263v.m77010Y(jSONObject.optJSONObject("operationTail"));
            this.nYI = C43263v.m77010Y(jSONObject.optJSONObject("operationNext"));
            this.nYJ = C43263v.m77010Y(jSONObject.optJSONObject("operationMiddle"));
            int optInt = jSONObject.optInt("sceneSwitch");
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LUCKY_MONEY_NEWYEAR_SWITCH_INT_SYNC, Integer.valueOf(optInt));
            C4990ab.m7416i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:".concat(String.valueOf(optInt)));
            this.nYK = jSONObject.optInt("scenePicSwitch");
            C4990ab.m7416i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.nYK);
            this.nYM = jSONObject.optInt("enableYearHbExpression");
            C4990ab.m7417i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableYearHbExpression:%s", Integer.valueOf(this.nYM));
            this.nYL = jSONObject.optInt("enableSelfie");
            C4990ab.m7416i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableSelfIe:" + this.nYL);
            this.nYN = jSONObject.optInt("enableNormalSelfie");
            this.nYO = jSONObject.optInt("enableNormalAllExpression");
            C4990ab.m7417i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableNormalSelfie:%s enableNormalAllExpression:%s", Integer.valueOf(this.nYN), Integer.valueOf(this.nYO));
            this.nSd = jSONObject.optString("wishing");
            C4990ab.m7417i("MicroMsg.NetSceneLuckyMoneyGetConfig", "wishing: %s", this.nSd);
            JSONArray optJSONArray = jSONObject.optJSONArray("yearMess");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                C4990ab.m7416i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson is empty!");
            } else {
                C4990ab.m7416i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + optJSONArray.length());
                this.nYP = new LinkedList();
                for (optInt = 0; optInt < optJSONArray.length(); optInt++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(optInt);
                    C43262u c43262u = new C43262u();
                    c43262u.nXX = optJSONObject.optInt("yearAmount", 0);
                    c43262u.nXY = optJSONObject.optString("yearWish");
                    this.nYP.add(c43262u);
                }
            }
            C1720g.m3537RQ();
            int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LUCKY_MONEY_HONGBAO_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue();
            optInt = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_hongbao_emoji_all_switch, 0);
            if (C5046bo.m7563gW(intValue, 1) || C5046bo.m7563gW(optInt, 1)) {
                this.nYN = 1;
                this.nYO = 1;
                this.nYL = 1;
                this.nYM = 1;
            }
            C4990ab.m7417i("MicroMsg.NetSceneLuckyMoneyGetConfig", "localSwitch() enableNormalSelfie:%s enableNormalAllExpression:%s enableSelfie:%s enableYearHbExpression:%s", Integer.valueOf(this.nYN), Integer.valueOf(this.nYO), Integer.valueOf(this.nYL), Integer.valueOf(this.nYM));
            AppMethodBeat.m2505o(42402);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + i + ", errMsg:" + str);
        AppMethodBeat.m2505o(42402);
    }
}
