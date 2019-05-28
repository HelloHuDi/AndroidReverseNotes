package com.tencent.p177mm.plugin.wallet_payu.remittance.p1055a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.a.d */
public final class C46386d extends C36383a {
    public String desc;
    public double kCJ;
    public String pPP;
    public String pPQ;
    public int scene;
    public int timestamp;
    public String username;

    public C46386d(String str) {
        AppMethodBeat.m2504i(48531);
        HashMap hashMap = new HashMap();
        hashMap.put("transfer_url", str);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48531);
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48532);
        C4990ab.m7410d("MicroMsg.NetScenePayURemittanceGetUsername", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(48532);
            return;
        }
        this.username = jSONObject.optString("user_name");
        this.pPP = jSONObject.optString("true_name");
        this.kCJ = jSONObject.optDouble("fee") / 100.0d;
        this.desc = jSONObject.optString("desc");
        this.scene = jSONObject.optInt("scene");
        this.pPQ = jSONObject.optString("transfer_qrcode_id");
        this.timestamp = jSONObject.optInt("time_stamp");
        AppMethodBeat.m2505o(48532);
    }

    public final int cOX() {
        return 24;
    }
}
