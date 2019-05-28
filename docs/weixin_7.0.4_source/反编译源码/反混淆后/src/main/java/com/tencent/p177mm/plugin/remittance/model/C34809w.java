package com.tencent.p177mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.remittance.model.w */
public final class C34809w extends C5749m {
    public String desc;
    public double kCJ;
    public String pPP;
    public String pPQ;
    public String pPR = "";
    public String pPS = "";
    public String pPT = "";
    public String pPU = "";
    public int pPV;
    public String pPW = "";
    public String pPX = "";
    public int pPY;
    public String pPZ;
    public String pPw;
    public String pQa;
    public int pQb;
    public String pQc;
    public BusiRemittanceResp pQd;
    public int scene;
    public String username;

    public C34809w(String str, int i) {
        AppMethodBeat.m2504i(44774);
        HashMap hashMap = new HashMap();
        hashMap.put("transfer_url", URLEncoder.encode(str));
        mo70323M(hashMap);
        hashMap = new HashMap();
        hashMap.put("channel", String.valueOf(i));
        mo70328ba(hashMap);
        AppMethodBeat.m2505o(44774);
    }

    public final int bgI() {
        return 0;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1515;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferscanqrcode";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(44775);
        try {
            C4990ab.m7410d("Micromsg.NetSceneTenpayRemittanceGetUsername", "errCode " + i + " errMsg: " + str);
            if (i != 0) {
                AppMethodBeat.m2505o(44775);
                return;
            }
            C4990ab.m7411d("Micromsg.NetSceneTenpayRemittanceGetUsername", "json %s", jSONObject.toString());
            this.username = jSONObject.optString("user_name", "");
            this.pPP = jSONObject.optString("true_name");
            this.kCJ = jSONObject.optDouble("fee") / 100.0d;
            this.desc = jSONObject.optString("desc");
            this.scene = jSONObject.optInt("scene");
            this.pPQ = URLEncoder.encode(jSONObject.optString("transfer_qrcode_id"));
            this.pPR = jSONObject.optString("f2f_pay_desc");
            this.pPS = jSONObject.optString("rcvr_desc");
            this.pPT = jSONObject.optString("payer_desc");
            this.pPU = jSONObject.optString("rcvr_ticket");
            this.pPV = jSONObject.optInt("busi_type", 0);
            this.pPW = jSONObject.optString("mch_name");
            this.pPX = jSONObject.optString("mch_photo");
            this.pQa = jSONObject.optString("mch_type", "");
            this.pPY = jSONObject.optInt("mch_time", 0);
            this.pPZ = jSONObject.optString("receiver_openid");
            this.pQb = jSONObject.optInt("get_pay_wifi");
            this.pPw = jSONObject.optString("receiver_true_name");
            this.pQc = jSONObject.optString("mch_info_string");
            this.pQd = new BusiRemittanceResp(jSONObject);
            AppMethodBeat.m2505o(44775);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceGetUsername", e, "", new Object[0]);
            AppMethodBeat.m2505o(44775);
        }
    }
}
