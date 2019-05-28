package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac extends aa {
    public int cRU;
    public int cRV;
    public long cSh;
    public int kCd;
    public String nSX;
    public RealnameGuideHelper nTN;
    public String nWO;
    public e nXd;
    public String nYf;
    public String nYg;
    public int nYh;
    public String nYi;
    public int nYj;
    public String nYk;
    public String nYl;
    public int nYm;
    public k nYn = null;

    public ac(String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(42391);
        this.nSX = str;
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        if (!bo.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("way", String.valueOf(i));
        hashMap.put(DownloadInfoColumns.CHANNELID, "2");
        hashMap.put("package", str3);
        hashMap.put("sessionUserName", str4);
        M(hashMap);
        AppMethodBeat.o(42391);
    }

    public final int bgG() {
        return 1;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(42392);
        this.nYf = jSONObject.optString("spidName");
        this.cRU = jSONObject.optInt("hbStatus");
        this.cRV = jSONObject.optInt("receiveStatus");
        this.nWO = jSONObject.optString("statusMess");
        this.nYg = jSONObject.optString("hintMess");
        this.cSh = jSONObject.optLong("amount");
        this.nYh = jSONObject.optInt("recNum");
        this.kCd = jSONObject.optInt("totalNum");
        this.nXd = new e();
        JSONObject optJSONObject = jSONObject.optJSONObject("atomicFunc");
        if (optJSONObject != null) {
            this.nXd.erD = optJSONObject.optInt("enable");
            this.nXd.nWz = optJSONObject.optString("fissionContent");
            this.nXd.nWy = optJSONObject.optString("fissionUrl");
        }
        this.nYj = jSONObject.optInt("focusFlag");
        this.nYk = jSONObject.optString("focusWording");
        this.nYl = jSONObject.optString("focusAppidUserName");
        this.nYm = jSONObject.optInt("isFocus");
        this.nYi = jSONObject.optString("smallHbButtonMess");
        try {
            this.nYn = v.W(jSONObject);
            this.nYn.nWR = jSONObject.optString("spidLogo");
            this.nYn.nWQ = jSONObject.optString("spidName");
            this.nYn.nSd = jSONObject.optString("spidWishing");
        } catch (JSONException e) {
            ab.w("MicroMsg.NetSceneLuckyMoneyBusiBase", "parse luckyMoneyDetail fail: " + e.getLocalizedMessage());
        }
        if (i == 0 && jSONObject.has("real_name_info")) {
            optJSONObject = jSONObject.optJSONObject("real_name_info");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("guide_flag");
                String optString2 = optJSONObject.optString("guide_wording");
                String optString3 = optJSONObject.optString("left_button_wording");
                String optString4 = optJSONObject.optString("right_button_wording");
                String optString5 = optJSONObject.optString("upload_credit_url");
                this.nTN = new RealnameGuideHelper();
                this.nTN.a(optString, optString2, optString3, optString4, optString5, 1005);
            }
        }
        AppMethodBeat.o(42392);
    }
}
