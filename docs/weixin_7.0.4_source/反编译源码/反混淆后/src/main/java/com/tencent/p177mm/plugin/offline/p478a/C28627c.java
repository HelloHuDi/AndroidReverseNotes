package com.tencent.p177mm.plugin.offline.p478a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.offline.a.c */
public final class C28627c extends C5749m {
    public C28627c(String str, int i, int i2) {
        AppMethodBeat.m2504i(43386);
        HashMap hashMap = new HashMap();
        hashMap.put("req_key", str);
        hashMap.put("pay_scene", String.valueOf(i));
        hashMap.put("pay_channel", String.valueOf(i2));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(43386);
    }

    public final int bgI() {
        return 1385;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinecancelpay";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(43387);
        C4990ab.m7417i("NetSceneOfflineCancelPay", "onGYNetEnd errCode:%d, errMsg:%s", Integer.valueOf(i), str);
        AppMethodBeat.m2505o(43387);
    }
}
