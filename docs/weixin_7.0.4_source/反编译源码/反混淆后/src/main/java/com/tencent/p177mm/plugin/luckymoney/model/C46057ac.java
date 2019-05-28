package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.ac */
public final class C46057ac extends C34440aa {
    public int cRU;
    public int cRV;
    public long cSh;
    public int kCd;
    public String nSX;
    public RealnameGuideHelper nTN;
    public String nWO;
    public C46060e nXd;
    public String nYf;
    public String nYg;
    public int nYh;
    public String nYi;
    public int nYj;
    public String nYk;
    public String nYl;
    public int nYm;
    public C12428k nYn = null;

    public C46057ac(String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.m2504i(42391);
        this.nSX = str;
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        if (!C5046bo.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("way", String.valueOf(i));
        hashMap.put(DownloadInfoColumns.CHANNELID, "2");
        hashMap.put("package", str3);
        hashMap.put("sessionUserName", str4);
        mo46410M(hashMap);
        AppMethodBeat.m2505o(42391);
    }

    public final int bgG() {
        return 1;
    }

    /* renamed from: a */
    public final void mo7791a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(42392);
        this.nYf = jSONObject.optString("spidName");
        this.cRU = jSONObject.optInt("hbStatus");
        this.cRV = jSONObject.optInt("receiveStatus");
        this.nWO = jSONObject.optString("statusMess");
        this.nYg = jSONObject.optString("hintMess");
        this.cSh = jSONObject.optLong("amount");
        this.nYh = jSONObject.optInt("recNum");
        this.kCd = jSONObject.optInt("totalNum");
        this.nXd = new C46060e();
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
            this.nYn = C43263v.m77008W(jSONObject);
            this.nYn.nWR = jSONObject.optString("spidLogo");
            this.nYn.nWQ = jSONObject.optString("spidName");
            this.nYn.nSd = jSONObject.optString("spidWishing");
        } catch (JSONException e) {
            C4990ab.m7420w("MicroMsg.NetSceneLuckyMoneyBusiBase", "parse luckyMoneyDetail fail: " + e.getLocalizedMessage());
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
                this.nTN.mo74571a(optString, optString2, optString3, optString4, optString5, 1005);
            }
        }
        AppMethodBeat.m2505o(42392);
    }
}
