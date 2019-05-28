package com.tencent.p177mm.plugin.luckymoney.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.ad */
public final class C36784ad extends C34440aa {
    public String cRS;
    public int cRT;
    public int cRU;
    public int cRV;
    public String nSX;
    public String nWO;
    public C43255as nXf;
    public String nXg;
    public String nYf;
    public String nYg;
    public int nYj;
    public String nYk;
    public String nYl;
    public int nYm;
    public int nYo;
    public String nYp;
    public String nYq;
    public int nYr = 1;
    public String nYs = null;
    public String nYt = null;
    public String nYu = null;
    public String nYv = null;
    public String nYw = null;
    public long nYx = 0;

    public C36784ad(String str, String str2, int i, String str3) {
        AppMethodBeat.m2504i(42393);
        this.cRS = str2;
        this.nSX = str;
        this.nYo = i;
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        if (!C5046bo.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("way", String.valueOf(i));
        hashMap.put(DownloadInfoColumns.CHANNELID, "2");
        hashMap.put("package", str3);
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
        mo46410M(hashMap);
        AppMethodBeat.m2505o(42393);
    }

    public final int bgG() {
        return 0;
    }

    /* renamed from: a */
    public final void mo7791a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(42394);
        this.nYp = jSONObject.optString("spidLogo");
        this.nYq = jSONObject.optString("spidWishing");
        this.nYf = jSONObject.optString("spidName");
        this.nYp = jSONObject.optString("spidLogo");
        this.cRU = jSONObject.optInt("hbStatus");
        this.cRV = jSONObject.optInt("receiveStatus");
        this.nWO = jSONObject.optString("statusMess");
        this.nYg = jSONObject.optString("hintMess");
        this.nXg = jSONObject.optString("watermark");
        this.nSX = jSONObject.optString("sendId");
        this.nYj = jSONObject.optInt("focusFlag");
        this.nYk = jSONObject.optString("focusWording");
        this.nYl = jSONObject.optString("focusAppidUserName");
        this.nYm = jSONObject.optInt("isFocus");
        this.cRT = jSONObject.optInt("hbType");
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
        this.nXf = C43263v.m77010Y(jSONObject.optJSONObject("operationTail"));
        AppMethodBeat.m2505o(42394);
    }
}
