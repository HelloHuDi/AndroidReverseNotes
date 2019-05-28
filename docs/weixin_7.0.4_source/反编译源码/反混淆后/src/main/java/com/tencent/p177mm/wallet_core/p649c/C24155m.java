package com.tencent.p177mm.wallet_core.p649c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.c.m */
public final class C24155m extends C5749m {
    public String Afw;

    public C24155m(String str) {
        AppMethodBeat.m2504i(49061);
        this.Afw = str;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("crt_no", C18178q.encode(str));
        hashMap.put("deviceid", C1427q.getDeviceID(C4996ah.getContext()));
        mo70323M(hashMap);
        mo70328ba(hashMap2);
        AppMethodBeat.m2505o(49061);
    }

    public final int bgI() {
        return 1568;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1568;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/deletedigitalcert";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(49062);
        C4990ab.m7417i("MicroMsg.NetSceneDeletedigitalcert", "onGYNetEnd %d %s", Integer.valueOf(i), str);
        AppMethodBeat.m2505o(49062);
    }
}
