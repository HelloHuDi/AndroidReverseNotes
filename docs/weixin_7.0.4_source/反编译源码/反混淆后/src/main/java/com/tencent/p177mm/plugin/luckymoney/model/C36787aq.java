package com.tencent.p177mm.plugin.luckymoney.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.aq */
public final class C36787aq extends C34442ak {
    public String cRS;
    public int cRT;
    public int cRU;
    public int cRV;
    public int cdf;
    long cvx;
    public String ffP;
    public int msgType = 1;
    public String nSX;
    public String nSd;
    public String nUk;
    public String nWO;
    public String nWR;
    public int nWZ;
    public C43255as nXf;
    public String nXg;
    public String nXl;
    public String nYA;
    public int nYB;
    public int nYK = 0;
    public int nYW = 0;
    public int nYr = 1;
    public String nYs = null;
    public String nYt = null;
    public String nYu = null;
    public String nYv = null;
    public String nYw = null;
    public long nYx = 0;
    public String nZg;
    public long nZh;
    public long nZi;
    public int nZj;
    public int nZk = 0;
    public String nZl;
    public C43256au nZm;
    String talker;

    public C36787aq(int i, String str, String str2, int i2, String str3) {
        AppMethodBeat.m2504i(42421);
        this.cdf = i;
        this.nSX = str;
        this.cRS = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("msgType", "1");
        hashMap.put(DownloadInfoColumns.CHANNELID, String.valueOf(i));
        hashMap.put("sendId", str);
        hashMap.put("inWay", String.valueOf(i2));
        hashMap.put("ver", str3);
        C1720g.m3537RQ();
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue > 0) {
            if (System.currentTimeMillis() < longValue) {
                hashMap.put("agreeDuty", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                C1720g.m3537RQ();
                hashMap.put("agreeDuty", stringBuilder.append((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_DISCLAIMER_NEED_AGERR_INT_SYNC, Integer.valueOf(1))).toString());
            }
        }
        if (!C5046bo.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        mo46410M(hashMap);
        AppMethodBeat.m2505o(42421);
    }

    public final int getType() {
        return 1581;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/receivewxhb";
    }

    /* renamed from: a */
    public final void mo7791a(int i, String str, JSONObject jSONObject) {
        C43256au c43256au;
        AppMethodBeat.m2504i(42422);
        this.nZg = jSONObject.optString("sendNick");
        this.nWR = jSONObject.optString("sendHeadImg");
        this.cRU = jSONObject.optInt("hbStatus");
        this.cRV = jSONObject.optInt("receiveStatus");
        this.nWO = jSONObject.optString("statusMess");
        this.nSd = jSONObject.optString("wishing");
        this.nWZ = jSONObject.optInt("isSender");
        this.nZh = jSONObject.optLong("sceneAmount");
        this.nZi = jSONObject.optLong("sceneRecTimeStamp");
        this.cRT = jSONObject.optInt("hbType");
        this.nXg = jSONObject.optString("watermark");
        this.nUk = jSONObject.optString("externMess");
        this.nXl = jSONObject.optString("sendUserName");
        if (!C5046bo.isNullOrNil(this.nXl) && C5046bo.isNullOrNil(this.nZg)) {
            this.nZg = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(this.nXl);
        }
        this.nXf = C43263v.m77010Y(jSONObject.optJSONObject("operationTail"));
        this.nYK = jSONObject.optInt("scenePicSwitch");
        JSONObject optJSONObject = jSONObject.optJSONObject("agree_duty");
        if (optJSONObject != null) {
            this.nYs = optJSONObject.optString("agreed_flag", "-1");
            this.nYt = optJSONObject.optString("title", "");
            this.nYu = optJSONObject.optString("service_protocol_wording", "");
            this.nYv = optJSONObject.optString("service_protocol_url", "");
            this.nYw = optJSONObject.optString("button_wording", "");
            this.nYx = optJSONObject.optLong("delay_expired_time", 0);
        }
        if (this.nYx > 0) {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis() + (this.nYx * 1000)));
        }
        C4990ab.m7416i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.nYK);
        this.nZj = jSONObject.optInt("preStrainFlag", 1);
        C4990ab.m7416i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.nZj);
        this.nYW = jSONObject.optInt("showYearExpression");
        C4990ab.m7417i("MicroMsg.NetSceneReceiveLuckyMoney", "showYearExpression:%s", Integer.valueOf(this.nYW));
        this.nZk = jSONObject.optInt("showRecNormalExpression");
        C4990ab.m7417i("MicroMsg.NetSceneReceiveLuckyMoney", "showRecNormalExpression:%s", Integer.valueOf(this.nZk));
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEWYEAR_HONGBAO_IMAGE_PRESTRAIN_FLAG_INT_SYNC, Integer.valueOf(this.nZj));
        this.nZl = jSONObject.optString("timingIdentifier");
        this.ffP = jSONObject.optString("effectResource");
        this.nYA = jSONObject.optString("expression_md5");
        this.nYB = jSONObject.optInt("expression_type");
        C4990ab.m7417i("MicroMsg.NetSceneReceiveLuckyMoney", "expressionmd5:%s expressiontype:%s", this.nYA, Integer.valueOf(this.nYB));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("showSourceRec");
        if (optJSONObject2 == null) {
            c43256au = null;
        } else {
            c43256au = new C43256au();
            c43256au.nZq = C43263v.m77011Z(optJSONObject2);
        }
        this.nZm = c43256au;
        C1720g.m3537RQ();
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LUCKY_MONEY_HONGBAO_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue();
        int a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_hongbao_emoji_all_switch, 0);
        if (C5046bo.m7563gW(intValue, 1) || C5046bo.m7563gW(a, 1)) {
            this.nZk = 1;
            this.nYW = 1;
        }
        C4990ab.m7417i("MicroMsg.NetSceneReceiveLuckyMoney", "localSwitch() showRecNormalExpression:%s showYearExpression:%s", Integer.valueOf(this.nZk), Integer.valueOf(this.nYW));
        AppMethodBeat.m2505o(42422);
    }
}
