package com.tencent.p177mm.plugin.wallet.pay.p554a.p555a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pay.a.a.c */
public class C29593c extends C14157b {
    private boolean toq;

    public C29593c(Authen authen, Orders orders, boolean z) {
        super(authen, orders);
        this.toq = z;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: aj */
    public void mo9384aj(Map<String, String> map) {
    }

    public final int bgI() {
        return 120;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/banpaybindauthen";
    }

    /* renamed from: ZU */
    public int mo9382ZU() {
        return 1600;
    }

    /* renamed from: a */
    public int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(45925);
        int a = super.mo4456a(c1902e, c1202f);
        AppMethodBeat.m2505o(45925);
        return a;
    }

    /* renamed from: a */
    public void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(45926);
        super.mo9383a(i, str, jSONObject);
        AppMethodBeat.m2505o(45926);
    }
}
