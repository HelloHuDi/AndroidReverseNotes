package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import java.util.Map;
import org.json.JSONObject;

public final class k extends c {
    public k(Authen authen, Orders orders, boolean z) {
        super(authen, orders, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aj(Map<String, String> map) {
        AppMethodBeat.i(45930);
        map.put("busi_scene", this.toh.pbn);
        AppMethodBeat.o(45930);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindauthen";
    }

    public final int ZU() {
        return 1274;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(45931);
        h.pYm.a(663, 24, 1, false);
        int a = super.a(eVar, fVar);
        AppMethodBeat.o(45931);
        return a;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(45932);
        super.a(i, str, jSONObject);
        if (i != 0) {
            h.pYm.a(663, 25, 1, false);
        }
        AppMethodBeat.o(45932);
    }
}
