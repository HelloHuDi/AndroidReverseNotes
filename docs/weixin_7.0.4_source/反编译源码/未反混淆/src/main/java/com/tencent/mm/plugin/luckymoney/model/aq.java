package com.tencent.mm.plugin.luckymoney.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class aq extends ak {
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
    public as nXf;
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
    public au nZm;
    String talker;

    public aq(int i, String str, String str2, int i2, String str3) {
        AppMethodBeat.i(42421);
        this.cdf = i;
        this.nSX = str;
        this.cRS = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("msgType", "1");
        hashMap.put(DownloadInfoColumns.CHANNELID, String.valueOf(i));
        hashMap.put("sendId", str);
        hashMap.put("inWay", String.valueOf(i2));
        hashMap.put("ver", str3);
        g.RQ();
        long longValue = ((Long) g.RP().Ry().get(a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue > 0) {
            if (System.currentTimeMillis() < longValue) {
                hashMap.put("agreeDuty", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                g.RQ();
                hashMap.put("agreeDuty", stringBuilder.append((Integer) g.RP().Ry().get(a.USERINFO_WALLET_DISCLAIMER_NEED_AGERR_INT_SYNC, Integer.valueOf(1))).toString());
            }
        }
        if (!bo.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        M(hashMap);
        AppMethodBeat.o(42421);
    }

    public final int getType() {
        return 1581;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/receivewxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        au auVar;
        AppMethodBeat.i(42422);
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
        if (!bo.isNullOrNil(this.nXl) && bo.isNullOrNil(this.nZg)) {
            this.nZg = ((b) g.K(b.class)).mJ(this.nXl);
        }
        this.nXf = v.Y(jSONObject.optJSONObject("operationTail"));
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
            g.RQ();
            g.RP().Ry().set(a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis() + (this.nYx * 1000)));
        }
        ab.i("MicroMsg.NetSceneReceiveLuckyMoney", "scenePicSwitch:" + this.nYK);
        this.nZj = jSONObject.optInt("preStrainFlag", 1);
        ab.i("MicroMsg.NetSceneReceiveLuckyMoney", "preStrainFlag:" + this.nZj);
        this.nYW = jSONObject.optInt("showYearExpression");
        ab.i("MicroMsg.NetSceneReceiveLuckyMoney", "showYearExpression:%s", Integer.valueOf(this.nYW));
        this.nZk = jSONObject.optInt("showRecNormalExpression");
        ab.i("MicroMsg.NetSceneReceiveLuckyMoney", "showRecNormalExpression:%s", Integer.valueOf(this.nZk));
        g.RQ();
        g.RP().Ry().set(a.USERINFO_NEWYEAR_HONGBAO_IMAGE_PRESTRAIN_FLAG_INT_SYNC, Integer.valueOf(this.nZj));
        this.nZl = jSONObject.optString("timingIdentifier");
        this.ffP = jSONObject.optString("effectResource");
        this.nYA = jSONObject.optString("expression_md5");
        this.nYB = jSONObject.optInt("expression_type");
        ab.i("MicroMsg.NetSceneReceiveLuckyMoney", "expressionmd5:%s expressiontype:%s", this.nYA, Integer.valueOf(this.nYB));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("showSourceRec");
        if (optJSONObject2 == null) {
            auVar = null;
        } else {
            auVar = new au();
            auVar.nZq = v.Z(optJSONObject2);
        }
        this.nZm = auVar;
        g.RQ();
        int intValue = ((Integer) g.RP().Ry().get(a.USERINFO_LUCKY_MONEY_HONGBAO_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue();
        int a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_hongbao_emoji_all_switch, 0);
        if (bo.gW(intValue, 1) || bo.gW(a, 1)) {
            this.nZk = 1;
            this.nYW = 1;
        }
        ab.i("MicroMsg.NetSceneReceiveLuckyMoney", "localSwitch() showRecNormalExpression:%s showYearExpression:%s", Integer.valueOf(this.nZk), Integer.valueOf(this.nYW));
        AppMethodBeat.o(42422);
    }
}
