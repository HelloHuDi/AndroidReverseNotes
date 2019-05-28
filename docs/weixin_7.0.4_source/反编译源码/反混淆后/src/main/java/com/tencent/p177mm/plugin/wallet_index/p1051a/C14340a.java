package com.tencent.p177mm.plugin.wallet_index.p1051a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.wallet_index.p564c.C14346m;
import com.tencent.p177mm.sdk.p600b.C4879a;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.wallet_index.a.a */
public class C14340a implements C1816at {
    private C14346m tQP = new C14346m();

    public C14340a() {
        AppMethodBeat.m2504i(48162);
        AppMethodBeat.m2505o(48162);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(48163);
        C4879a.xxA.mo10052c(this.tQP.tRl);
        C4879a.xxA.mo10052c(this.tQP.tRm);
        AppMethodBeat.m2505o(48163);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(48164);
        C4879a.xxA.mo10053d(this.tQP.tRl);
        C4879a.xxA.mo10053d(this.tQP.tRm);
        AppMethodBeat.m2505o(48164);
    }
}
