package com.tencent.p177mm.plugin.wallet_payu.pay.p571a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pay.a.c */
public final class C36856c extends C36383a {
    public Orders pWy;
    private String tos;

    public C36856c(String str) {
        this(str, 0);
    }

    public C36856c(String str, int i) {
        AppMethodBeat.m2504i(48443);
        this.pWy = null;
        this.tos = null;
        this.tos = str;
        HashMap hashMap = new HashMap();
        hashMap.put("req_key", this.tos);
        hashMap.put("query_scene", String.valueOf(i));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48443);
    }

    public final int cOX() {
        return 8;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48444);
        this.pWy = Orders.m68762ap(jSONObject);
        if (this.pWy != null) {
            this.pWy.czZ = this.tos;
        }
        AppMethodBeat.m2505o(48444);
    }
}
