package com.tencent.p177mm.plugin.offline.p478a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.offline.a.j */
public final class C21401j extends C5749m {
    public C21401j(String str) {
        AppMethodBeat.m2504i(43399);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("device_id", C1427q.m3028LM());
        mo70323M(hashMap);
        AppMethodBeat.m2505o(43399);
    }

    public final int bgI() {
        return 47;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(43400);
        super.mo4498a(i, i2, i3, str, c1929q, bArr);
        AppMethodBeat.m2505o(43400);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 566;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineclose";
    }
}
