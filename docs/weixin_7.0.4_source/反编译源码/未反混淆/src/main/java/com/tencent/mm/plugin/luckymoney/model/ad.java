package com.tencent.mm.plugin.luckymoney.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class ad extends aa {
    public String cRS;
    public int cRT;
    public int cRU;
    public int cRV;
    public String nSX;
    public String nWO;
    public as nXf;
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

    public ad(String str, String str2, int i, String str3) {
        AppMethodBeat.i(42393);
        this.cRS = str2;
        this.nSX = str;
        this.nYo = i;
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        if (!bo.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("way", String.valueOf(i));
        hashMap.put(DownloadInfoColumns.CHANNELID, "2");
        hashMap.put("package", str3);
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
        M(hashMap);
        AppMethodBeat.o(42393);
    }

    public final int bgG() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(42394);
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
            g.RQ();
            g.RP().Ry().set(a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis() + (this.nYx * 1000)));
        }
        this.nXf = v.Y(jSONObject.optJSONObject("operationTail"));
        AppMethodBeat.o(42394);
    }
}
