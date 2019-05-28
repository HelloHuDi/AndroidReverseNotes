package com.tencent.p177mm.plugin.wallet_core.p749c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.c.p */
public final class C46361p extends C5749m {
    public C46361p(String str) {
        AppMethodBeat.m2504i(46528);
        HashMap hashMap = new HashMap();
        hashMap.put("wallet_tpa_country", str);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46528);
    }

    public final int bgI() {
        return 1663;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1663;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/setuserwallet";
    }

    public final int getType() {
        AppMethodBeat.m2504i(46529);
        int type = super.getType();
        AppMethodBeat.m2505o(46529);
        return type;
    }
}
