package com.tencent.mm.wallet_core.tenpay.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.view.d;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public class o extends m implements i {
    public String AgN;
    public String appId;
    public int cIb;
    public String cwg;
    public String czZ;
    public String hwA;
    public int scene;
    public String tRb;
    public csj tRc = new csj();

    public o(String str, int i, int i2, int i3, int i4, String str2) {
        AppMethodBeat.i(49176);
        this.scene = i;
        this.cIb = i3;
        HashMap hashMap = new HashMap();
        hashMap.put("url", URLEncoder.encode(str));
        hashMap.put("scene", String.valueOf(i2));
        hashMap.put("a8key_scene", String.valueOf(i));
        hashMap.put("channel", String.valueOf(i3));
        ab.d("MicroMsg.NetSceneTenpayNativeAuthen", "sourceType: %d, source: %s", Integer.valueOf(i4), str2);
        if (i4 < 0) {
            ab.e("MicroMsg.NetSceneTenpayNativeAuthen", "illegal sourceType: %d, source: %s", Integer.valueOf(i4), str2);
            hashMap.put("source_type", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            hashMap.put("source", "");
        } else {
            hashMap.put("source_type", String.valueOf(i4));
            hashMap.put("source", str2);
        }
        M(hashMap);
        c ll = com.tencent.mm.model.c.c.abi().ll("100456");
        if (!ll.isValid()) {
            ab.w("MicroMsg.NetSceneTenpayNativeAuthen", "invalid abtest value");
            AppMethodBeat.o(49176);
        } else if (bo.getInt((String) ll.dru().get("open"), 0) == 0) {
            ab.i("MicroMsg.NetSceneTenpayNativeAuthen", "abtest unopened");
            AppMethodBeat.o(49176);
        } else {
            try {
                String query = new URI(str).getQuery();
                if (!bo.isNullOrNil(query)) {
                    String[] split = query.split("&");
                    int length = split.length;
                    for (int i5 = 0; i5 < length; i5++) {
                        if (split[i5].contains("groupid")) {
                            String[] split2 = split[i5].split("=");
                            if (split2.length == 2) {
                                ab.d("MicroMsg.NetSceneTenpayNativeAuthen", "groupid: %s", Integer.valueOf(bo.getInt(split2[1], 0)));
                                dNN().acF().fsO = r3;
                            }
                        }
                    }
                }
                AppMethodBeat.o(49176);
            } catch (URISyntaxException e) {
                ab.printErrStackTrace("MicroMsg.NetSceneTenpayNativeAuthen", e, "", new Object[0]);
                AppMethodBeat.o(49176);
            }
        }
    }

    public final int bgI() {
        return d.MIC_SketchMark;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(49177);
        ab.i("MicroMsg.NetSceneTenpayNativeAuthen", "errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        ab.d("MicroMsg.NetSceneTenpayNativeAuthen", "json: %s", jSONObject.toString());
        this.czZ = jSONObject.optString("reqkey");
        this.appId = jSONObject.optString("appid");
        this.tRb = jSONObject.optString("appsource");
        this.cwg = jSONObject.optString("productid");
        this.AgN = jSONObject.optString("retcode");
        this.hwA = jSONObject.optString("retmsg");
        JSONObject optJSONObject = jSONObject.optJSONObject("wallet_mix_sp_genprepay_resp");
        if (optJSONObject != null) {
            this.tRc.xpI = optJSONObject.optString("pay_gate_url");
            this.tRc.xpK = optJSONObject.optBoolean("need_dialog");
            this.tRc.xpL = optJSONObject.optString("dialog_text");
            optJSONObject = optJSONObject.optJSONObject("callback_retry_conf");
            if (optJSONObject != null) {
                this.tRc.xpJ = new nb();
                this.tRc.xpJ.vRF = optJSONObject.optInt("inteval_time");
                this.tRc.xpJ.vRG = optJSONObject.optInt("max_count");
                this.tRc.xpJ.vRH = optJSONObject.optString("default_wording");
            }
            ab.d("MicroMsg.NetSceneTenpayNativeAuthen", "pay_gate_url: %s, dialog_text: %s", this.tRc.xpI, this.tRc.xpL);
        }
        AppMethodBeat.o(49177);
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/payauthnative";
    }

    public int ZU() {
        return 1694;
    }
}
