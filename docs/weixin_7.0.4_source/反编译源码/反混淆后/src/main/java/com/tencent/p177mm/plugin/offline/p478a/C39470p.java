package com.tencent.p177mm.plugin.offline.p478a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.offline.a.p */
public final class C39470p extends C5749m {
    public C39470p(String str) {
        AppMethodBeat.m2504i(43415);
        HashMap hashMap = new HashMap();
        hashMap.put("device_id", C1427q.m3028LM());
        hashMap.put("passwd", str);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(43415);
    }

    public final int bgI() {
        return 51;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
    }
}
