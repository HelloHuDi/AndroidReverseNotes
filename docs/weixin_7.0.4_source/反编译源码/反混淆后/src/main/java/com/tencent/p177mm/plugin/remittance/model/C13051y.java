package com.tencent.p177mm.plugin.remittance.model;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p1629b.p1630a.C44420a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.remittance.model.y */
public final class C13051y extends C44420a {
    public int kCv = 0;
    public String kCx;
    public String kCy;
    public String pQy = "";
    public String pQz = "";

    public C13051y(int i) {
        AppMethodBeat.m2504i(44790);
        C4990ab.m7416i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
        HashMap hashMap = new HashMap();
        hashMap.put("wallet_type", String.valueOf(i));
        mo70315M(hashMap);
        AppMethodBeat.m2505o(44790);
    }

    public final int bgG() {
        return 0;
    }

    /* renamed from: a */
    public final void mo6950a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(44791);
        C4990ab.m7416i("MicroMsg.NetSceneTenpayh5Index", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTransferChargeQuery request error");
            AppMethodBeat.m2505o(44791);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        this.kCv = jSONObject.optInt(C8741b.CURRENCY);
        this.pQy = jSONObject.optString("currencyUint");
        this.pQz = jSONObject.optString("currencyWording");
        this.kCx = jSONObject.optString("notice");
        this.kCy = jSONObject.optString("notice_url");
        stringBuffer.append("currency:" + this.kCv);
        stringBuffer.append(" currencyuint:" + this.pQy);
        stringBuffer.append(" currencywording:" + this.pQz);
        stringBuffer.append(" notice:" + this.kCx);
        stringBuffer.append(" notice_url:" + this.kCy);
        C4990ab.m7416i("MicroMsg.NetSceneTenpayh5Index", "resp " + stringBuffer.toString());
        AppMethodBeat.m2505o(44791);
    }

    public final int getType() {
        return 1574;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/h5transferoperate";
    }
}
