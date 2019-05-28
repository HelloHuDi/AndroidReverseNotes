package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import java.util.Map;
import org.json.JSONObject;

public final class f extends c {
    public f(Authen authen, Orders orders, boolean z) {
        super(authen, orders, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aj(Map<String, String> map) {
        AppMethodBeat.i(45927);
        map.put("busi_scene", this.toh.pbn);
        AppMethodBeat.o(45927);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindauthen";
    }

    public final int ZU() {
        return 1259;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(45928);
        h.pYm.a(663, 20, 1, false);
        int a = super.a(eVar, fVar);
        AppMethodBeat.o(45928);
        return a;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(45929);
        super.a(i, str, jSONObject);
        if (i != 0) {
            h.pYm.a(663, 21, 1, false);
        }
        AppMethodBeat.o(45929);
    }
}
