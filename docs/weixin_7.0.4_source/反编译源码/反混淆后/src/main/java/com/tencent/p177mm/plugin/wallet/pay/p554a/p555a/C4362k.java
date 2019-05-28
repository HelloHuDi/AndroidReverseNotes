package com.tencent.p177mm.plugin.wallet.pay.p554a.p555a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pay.a.a.k */
public final class C4362k extends C29593c {
    public C4362k(Authen authen, Orders orders, boolean z) {
        super(authen, orders, z);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: aj */
    public final void mo9384aj(Map<String, String> map) {
        AppMethodBeat.m2504i(45930);
        map.put("busi_scene", this.toh.pbn);
        AppMethodBeat.m2505o(45930);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindauthen";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1274;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(45931);
        C7060h.pYm.mo8378a(663, 24, 1, false);
        int a = super.mo4456a(c1902e, c1202f);
        AppMethodBeat.m2505o(45931);
        return a;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(45932);
        super.mo9383a(i, str, jSONObject);
        if (i != 0) {
            C7060h.pYm.mo8378a(663, 25, 1, false);
        }
        AppMethodBeat.m2505o(45932);
    }
}
