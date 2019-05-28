package com.tencent.p177mm.wallet_core.p1512e.p1513a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C30862w;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.e.a.b */
public final class C36884b extends C36383a {
    public C36884b() {
        AppMethodBeat.m2504i(49160);
        mo70323M(new HashMap());
        AppMethodBeat.m2505o(49160);
    }

    public final int cOX() {
        return 28;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(49161);
        C4990ab.m7410d("Micromsg.NetScenePayUTimeSeed", " errCode: " + i + " errMsg :" + str);
        String optString = jSONObject.optString("time_stamp");
        if (!C5046bo.isNullOrNil(optString)) {
            C30862w.setTimeStamp(optString);
        }
        AppMethodBeat.m2505o(49161);
    }
}
