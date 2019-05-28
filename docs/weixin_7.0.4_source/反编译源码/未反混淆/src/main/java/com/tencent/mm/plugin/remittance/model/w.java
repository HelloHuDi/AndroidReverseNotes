package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class w extends m {
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

    public w(String str, int i) {
        AppMethodBeat.i(44774);
        HashMap hashMap = new HashMap();
        hashMap.put("transfer_url", URLEncoder.encode(str));
        M(hashMap);
        hashMap = new HashMap();
        hashMap.put("channel", String.valueOf(i));
        ba(hashMap);
        AppMethodBeat.o(44774);
    }

    public final int bgI() {
        return 0;
    }

    public final int ZU() {
        return 1515;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferscanqrcode";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(44775);
        try {
            ab.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "errCode " + i + " errMsg: " + str);
            if (i != 0) {
                AppMethodBeat.o(44775);
                return;
            }
            ab.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "json %s", jSONObject.toString());
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
            AppMethodBeat.o(44775);
        } catch (Exception e) {
            ab.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceGetUsername", e, "", new Object[0]);
            AppMethodBeat.o(44775);
        }
    }
}
