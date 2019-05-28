package com.tencent.p177mm.plugin.product.p1498a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.product.p481b.C12808c;
import com.tencent.p177mm.plugin.product.p481b.C12810d;
import com.tencent.p177mm.plugin.product.p481b.C46131a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.product.a.a */
public class C34676a implements C1816at {
    private C12808c pgK = null;
    private C12810d pgL = null;
    private C46131a pgM = new C46131a();

    public C34676a() {
        AppMethodBeat.m2504i(43940);
        AppMethodBeat.m2505o(43940);
    }

    public static C34676a bZC() {
        AppMethodBeat.m2504i(43941);
        C34676a c34676a = (C34676a) C7485q.m12925Y(C34676a.class);
        AppMethodBeat.m2505o(43941);
        return c34676a;
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
        AppMethodBeat.m2504i(43942);
        this.pgK = null;
        C4879a.xxA.mo10052c(this.pgM);
        AppMethodBeat.m2505o(43942);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(43943);
        C4879a.xxA.mo10053d(this.pgM);
        AppMethodBeat.m2505o(43943);
    }

    public static C12808c bZD() {
        AppMethodBeat.m2504i(43944);
        C1720g.m3534RN().mo5159QU();
        if (C34676a.bZC().pgK == null) {
            C34676a.bZC().pgK = new C12808c();
        }
        C12808c c12808c = C34676a.bZC().pgK;
        AppMethodBeat.m2505o(43944);
        return c12808c;
    }

    public final C12810d bZE() {
        AppMethodBeat.m2504i(43945);
        C1720g.m3534RN().mo5159QU();
        if (this.pgL == null) {
            this.pgL = new C12810d();
        }
        C12810d c12810d = this.pgL;
        AppMethodBeat.m2505o(43945);
        return c12810d;
    }
}
