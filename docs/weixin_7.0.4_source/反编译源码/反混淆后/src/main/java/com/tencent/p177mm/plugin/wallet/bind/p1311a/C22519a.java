package com.tencent.p177mm.plugin.wallet.bind.p1311a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.bind.a.a */
public final class C22519a extends C5749m {
    public int tle;
    public String tlf;

    public C22519a(String str, String str2) {
        AppMethodBeat.m2504i(45724);
        HashMap hashMap = new HashMap();
        hashMap.put("bankcard_type", str);
        hashMap.put("bind_serial", str2);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(45724);
    }

    public final int bgI() {
        return 1540;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1540;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/unbindbanner";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(45725);
        if (i == 0) {
            if (jSONObject != null) {
                this.tle = jSONObject.optInt("unbindbannerlevel", 0);
                this.tlf = jSONObject.optString("unbindbannerwording");
                AppMethodBeat.m2505o(45725);
                return;
            }
            C4990ab.m7412e("MicroMsg.NetSceneGetUnbindInfo", "json is null");
        }
        AppMethodBeat.m2505o(45725);
    }
}
