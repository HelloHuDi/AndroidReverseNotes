package com.tencent.p177mm.plugin.remittance.model;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p1629b.p1630a.C44420a;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.remittance.model.z */
public final class C3723z extends C44420a {
    public int kCv = 0;
    public String pPf = "";
    public int pPl;
    public String pQA = "";
    public int pQB;

    public C3723z(double d, String str, String str2, String str3, String str4, int i) {
        AppMethodBeat.m2504i(44792);
        C4990ab.m7416i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay create");
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("transfer_amount", Math.round(100.0d * d));
            hashMap.put("pay_nickname", URLEncoder.encode(str, ProtocolPackage.ServerEncoding));
            hashMap.put("rcvd_username", String.valueOf(str2));
            hashMap.put("rcvd_nickname", URLEncoder.encode(str3, ProtocolPackage.ServerEncoding));
            hashMap.put("reason", URLEncoder.encode(C5046bo.m7532bc(str4, ""), ProtocolPackage.ServerEncoding));
            hashMap.put(C8741b.CURRENCY, String.valueOf(i));
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneTenpayh5Pay", "error " + e.getMessage());
        }
        mo70315M(hashMap);
        AppMethodBeat.m2505o(44792);
    }

    public final int bgG() {
        return 1;
    }

    /* renamed from: a */
    public final void mo6950a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(44793);
        C4990ab.m7416i("MicroMsg.NetSceneTenpayh5Pay", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayh5Pay", "NetSceneTenpayh5Pay request error");
            AppMethodBeat.m2505o(44793);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        this.pPf = jSONObject.optString("payurl");
        this.pQA = jSONObject.optString("tradeurl");
        this.pPl = jSONObject.optInt("transfering_num");
        this.pQB = jSONObject.optInt("transfering_type");
        stringBuffer.append("payurl:" + this.pPf);
        stringBuffer.append(" tradeurl:" + this.pQA);
        stringBuffer.append(" transfering_num:" + this.pPl);
        stringBuffer.append(" transfering_type:" + this.pQB);
        C4990ab.m7416i("MicroMsg.NetSceneTenpayh5Pay", "resp " + stringBuffer.toString());
        AppMethodBeat.m2505o(44793);
    }

    public final int getType() {
        return 1622;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/h5requesttransfer";
    }
}
