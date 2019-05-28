package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.o */
public final class C40095o extends C5749m {
    public C40095o() {
        AppMethodBeat.m2504i(46527);
        mo70323M(new HashMap());
        AppMethodBeat.m2505o(46527);
    }

    public final int bgI() {
        return 2791;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 2791;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/setpayuserduty";
    }

    public final int getType() {
        return 2791;
    }
}
