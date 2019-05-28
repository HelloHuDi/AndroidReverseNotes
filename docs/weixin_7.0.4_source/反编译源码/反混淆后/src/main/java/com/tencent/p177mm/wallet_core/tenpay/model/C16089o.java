package com.tencent.p177mm.wallet_core.tenpay.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.protocal.protobuf.C30205nb;
import com.tencent.p177mm.protocal.protobuf.csj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.wallet_core.p649c.C44426i;
import com.tencent.view.C31128d;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.tenpay.model.o */
public class C16089o extends C5749m implements C44426i {
    public String AgN;
    public String appId;
    public int cIb;
    public String cwg;
    public String czZ;
    public String hwA;
    public int scene;
    public String tRb;
    public csj tRc = new csj();

    public C16089o(String str, int i, int i2, int i3, int i4, String str2) {
        AppMethodBeat.m2504i(49176);
        this.scene = i;
        this.cIb = i3;
        HashMap hashMap = new HashMap();
        hashMap.put("url", URLEncoder.encode(str));
        hashMap.put("scene", String.valueOf(i2));
        hashMap.put("a8key_scene", String.valueOf(i));
        hashMap.put("channel", String.valueOf(i3));
        C4990ab.m7411d("MicroMsg.NetSceneTenpayNativeAuthen", "sourceType: %d, source: %s", Integer.valueOf(i4), str2);
        if (i4 < 0) {
            C4990ab.m7413e("MicroMsg.NetSceneTenpayNativeAuthen", "illegal sourceType: %d, source: %s", Integer.valueOf(i4), str2);
            hashMap.put("source_type", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            hashMap.put("source", "");
        } else {
            hashMap.put("source_type", String.valueOf(i4));
            hashMap.put("source", str2);
        }
        mo70323M(hashMap);
        C5141c ll = C18624c.abi().mo17131ll("100456");
        if (!ll.isValid()) {
            C4990ab.m7420w("MicroMsg.NetSceneTenpayNativeAuthen", "invalid abtest value");
            AppMethodBeat.m2505o(49176);
        } else if (C5046bo.getInt((String) ll.dru().get("open"), 0) == 0) {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayNativeAuthen", "abtest unopened");
            AppMethodBeat.m2505o(49176);
        } else {
            try {
                String query = new URI(str).getQuery();
                if (!C5046bo.isNullOrNil(query)) {
                    String[] split = query.split("&");
                    int length = split.length;
                    for (int i5 = 0; i5 < length; i5++) {
                        if (split[i5].contains("groupid")) {
                            String[] split2 = split[i5].split("=");
                            if (split2.length == 2) {
                                C4990ab.m7411d("MicroMsg.NetSceneTenpayNativeAuthen", "groupid: %s", Integer.valueOf(C5046bo.getInt(split2[1], 0)));
                                dNN().acF().fsO = r3;
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(49176);
            } catch (URISyntaxException e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneTenpayNativeAuthen", e, "", new Object[0]);
                AppMethodBeat.m2505o(49176);
            }
        }
    }

    public final int bgI() {
        return C31128d.MIC_SketchMark;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(49177);
        C4990ab.m7417i("MicroMsg.NetSceneTenpayNativeAuthen", "errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        C4990ab.m7411d("MicroMsg.NetSceneTenpayNativeAuthen", "json: %s", jSONObject.toString());
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
                this.tRc.xpJ = new C30205nb();
                this.tRc.xpJ.vRF = optJSONObject.optInt("inteval_time");
                this.tRc.xpJ.vRG = optJSONObject.optInt("max_count");
                this.tRc.xpJ.vRH = optJSONObject.optString("default_wording");
            }
            C4990ab.m7411d("MicroMsg.NetSceneTenpayNativeAuthen", "pay_gate_url: %s, dialog_text: %s", this.tRc.xpI, this.tRc.xpL);
        }
        AppMethodBeat.m2505o(49177);
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/payauthnative";
    }

    /* renamed from: ZU */
    public int mo9382ZU() {
        return 1694;
    }
}
