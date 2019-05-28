package com.tencent.p177mm.plugin.wallet_payu.p1561a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.wallet_payu.bind.model.C14361c;
import com.tencent.p177mm.plugin.wallet_payu.create.p1317a.C46383c;
import com.tencent.p177mm.plugin.wallet_payu.order.p1318a.C46384d;
import com.tencent.p177mm.plugin.wallet_payu.pwd.p1054a.C31468f;
import com.tencent.p177mm.plugin.wallet_payu.pwd.p1054a.C40163g;
import com.tencent.p177mm.plugin.wallet_payu.remittance.p1055a.C43829g;
import com.tencent.p177mm.wallet_core.C24143a;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.wallet_payu.a.d */
public class C43823d implements C1816at {
    public String tTA = null;
    private int tTB = -1;

    static {
        AppMethodBeat.m2504i(48414);
        C24143a.m37115g("PayUOpenProcess", C46383c.class);
        C24143a.m37115g("PayUBindProcess", C14361c.class);
        C24143a.m37115g("PayUForgotPwdProcess", C31468f.class);
        C24143a.m37115g("PayUModifyPasswordProcess", C40163g.class);
        C24143a.m37115g("PayURemittanceProcess", C43829g.class);
        C24143a.m37115g("PayUShowOrderProcess", C46384d.class);
        AppMethodBeat.m2505o(48414);
    }

    public static C43823d cTf() {
        AppMethodBeat.m2504i(48413);
        C43823d c43823d = (C43823d) C7485q.m12925Y(C43823d.class);
        AppMethodBeat.m2505o(48413);
        return c43823d;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
