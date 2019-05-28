package com.tencent.mm.plugin.luckymoney.model;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ag extends ak {
    public String few;
    public int kCv;
    public String kCx;
    public String nRT;
    public String nRU;
    public String nSd;
    public as nXf;
    public String nYD;
    public boolean nYE;
    public int nYF;
    public String nYG;
    public as nYH;
    public as nYI;
    public as nYJ;
    public int nYK = 0;
    public int nYL = 0;
    public int nYM = 0;
    public int nYN = 0;
    public int nYO = 0;
    public LinkedList<u> nYP;

    public ag(String str, int i) {
        AppMethodBeat.i(42400);
        HashMap hashMap = new HashMap();
        hashMap.put("scene", "8");
        hashMap.put("ver", str);
        g.RQ();
        hashMap.put("walletType", String.valueOf(g.RP().Ry().get(339975, null)));
        hashMap.put("hasSource", String.valueOf(i));
        M(hashMap);
        AppMethodBeat.o(42400);
    }

    public ag(String str, int i, byte b) {
        AppMethodBeat.i(42401);
        HashMap hashMap = new HashMap();
        hashMap.put("ver", str);
        g.RQ();
        hashMap.put("walletType", String.valueOf(g.RP().Ry().get(339975, null)));
        hashMap.put("hasSource", String.valueOf(i));
        M(hashMap);
        AppMethodBeat.o(42401);
    }

    public final int getType() {
        return 1554;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/operationwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(42402);
        if (i == 0) {
            this.nYF = jSONObject.optInt("randomAmount");
            this.nYD = jSONObject.optString("randomWishing");
            this.kCx = jSONObject.optString("notice");
            this.nYG = jSONObject.optString("notice_url");
            this.nYE = jSONObject.optInt("hasCanShareHongBao") == 1;
            this.kCv = jSONObject.optInt(b.CURRENCY);
            this.nRT = jSONObject.optString("currencyUint");
            this.nRU = jSONObject.optString("currencyWording");
            this.few = jSONObject.optString("unique_id");
            ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "currency=" + this.kCv + ";currencyUint=" + this.nRT + ";currencyWording=" + this.nRU + ";uniqueId=" + this.few);
            i iVar = new i();
            iVar.nWH = jSONObject.optString("groupHint");
            iVar.nWI = jSONObject.optString("personalHint");
            iVar.nRR = ((double) jSONObject.optLong("totalAmount", 200000)) / 100.0d;
            iVar.nRO = jSONObject.optInt("totalNum", 100);
            iVar.nRP = ((double) jSONObject.optLong("perPersonMaxValue", 20000)) / 100.0d;
            iVar.nRS = ((double) jSONObject.optLong("perGroupMaxValue", 20000)) / 100.0d;
            iVar.nRQ = ((double) jSONObject.optLong("perMinValue", 1)) / 100.0d;
            iVar.nWJ = jSONObject.optInt("payShowBGFlag");
            iVar.kCv = this.kCv;
            iVar.nRT = this.nRT;
            iVar.nRU = this.nRU;
            iVar.nWK = jSONObject.optString("foreignFaqUrl");
            iVar.nWL = jSONObject.optString("foreignHongBaoName");
            iVar.nWM = jSONObject.optString("showSourceAndMac");
            ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "foreignFaqUrl: %s, foreignHongBaoName: %s", iVar.nWK, iVar.nWL);
            a.bKN();
            j bKO = a.bKO();
            bKO.nSs = iVar;
            bKO.bLt();
            ab.i("MicroMsg.LuckyMoneyConfigManager", "setConfig maxTotalAmount:" + bKO.nSs.nRR + " maxTotalNum:" + bKO.nSs.nRO + " perGroupMaxValue:" + bKO.nSs.nRS + " perMinValue:" + bKO.nSs.nRQ + " perPersonMaxValue:" + bKO.nSs.nRP);
            try {
                Object str2 = new String(bKO.nSs.toByteArray(), "ISO-8859-1");
                g.RQ();
                g.RP().Ry().set(356355, str2);
                g.RQ();
                g.RP().Ry().dsb();
            } catch (UnsupportedEncodingException e) {
                ab.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e.getLocalizedMessage());
            } catch (IOException e2) {
                ab.w("MicroMsg.LuckyMoneyConfigManager", "save config exp, " + e2.getLocalizedMessage());
            }
            this.nYH = v.Y(jSONObject.optJSONObject("operationHeader"));
            this.nXf = v.Y(jSONObject.optJSONObject("operationTail"));
            this.nYI = v.Y(jSONObject.optJSONObject("operationNext"));
            this.nYJ = v.Y(jSONObject.optJSONObject("operationMiddle"));
            int optInt = jSONObject.optInt("sceneSwitch");
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_LUCKY_MONEY_NEWYEAR_SWITCH_INT_SYNC, Integer.valueOf(optInt));
            ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "sceneSwitch:".concat(String.valueOf(optInt)));
            this.nYK = jSONObject.optInt("scenePicSwitch");
            ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "scenePicSwitch:" + this.nYK);
            this.nYM = jSONObject.optInt("enableYearHbExpression");
            ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableYearHbExpression:%s", Integer.valueOf(this.nYM));
            this.nYL = jSONObject.optInt("enableSelfie");
            ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableSelfIe:" + this.nYL);
            this.nYN = jSONObject.optInt("enableNormalSelfie");
            this.nYO = jSONObject.optInt("enableNormalAllExpression");
            ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "enableNormalSelfie:%s enableNormalAllExpression:%s", Integer.valueOf(this.nYN), Integer.valueOf(this.nYO));
            this.nSd = jSONObject.optString("wishing");
            ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "wishing: %s", this.nSd);
            JSONArray optJSONArray = jSONObject.optJSONArray("yearMess");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson is empty!");
            } else {
                ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "yearMessJson length:" + optJSONArray.length());
                this.nYP = new LinkedList();
                for (optInt = 0; optInt < optJSONArray.length(); optInt++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(optInt);
                    u uVar = new u();
                    uVar.nXX = optJSONObject.optInt("yearAmount", 0);
                    uVar.nXY = optJSONObject.optString("yearWish");
                    this.nYP.add(uVar);
                }
            }
            g.RQ();
            int intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_LUCKY_MONEY_HONGBAO_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue();
            optInt = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_hongbao_emoji_all_switch, 0);
            if (bo.gW(intValue, 1) || bo.gW(optInt, 1)) {
                this.nYN = 1;
                this.nYO = 1;
                this.nYL = 1;
                this.nYM = 1;
            }
            ab.i("MicroMsg.NetSceneLuckyMoneyGetConfig", "localSwitch() enableNormalSelfie:%s enableNormalAllExpression:%s enableSelfie:%s enableYearHbExpression:%s", Integer.valueOf(this.nYN), Integer.valueOf(this.nYO), Integer.valueOf(this.nYL), Integer.valueOf(this.nYM));
            AppMethodBeat.o(42402);
            return;
        }
        ab.e("MicroMsg.NetSceneLuckyMoneyGetConfig", "hongbao operation fail, errCode:" + i + ", errMsg:" + str);
        AppMethodBeat.o(42402);
    }
}
