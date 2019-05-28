package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import java.util.Map;
import org.json.JSONObject;

public class c extends b {
    private boolean toq;

    public c(Authen authen, Orders orders, boolean z) {
        super(authen, orders);
        this.toq = z;
    }

    /* Access modifiers changed, original: protected */
    public void aj(Map<String, String> map) {
    }

    public final int bgI() {
        return 120;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/banpaybindauthen";
    }

    public int ZU() {
        return 1600;
    }

    public int a(e eVar, f fVar) {
        AppMethodBeat.i(45925);
        int a = super.a(eVar, fVar);
        AppMethodBeat.o(45925);
        return a;
    }

    public void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(45926);
        super.a(i, str, jSONObject);
        AppMethodBeat.o(45926);
    }
}
