package com.tencent.p177mm.sdk.p604g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.p605a.C4941c;
import com.tencent.p177mm.sdk.p604g.p605a.C4941c.C4940a;
import com.tencent.p177mm.sdk.p604g.p605a.C4943e;

/* renamed from: com.tencent.mm.sdk.g.c */
public final class C7302c implements C4941c {
    private C4940a xDA;
    private C4943e xDz;

    /* renamed from: a */
    public final void mo10139a(C4940a c4940a) {
        this.xDA = c4940a;
    }

    public C7302c(C4943e c4943e) {
        this.xDz = c4943e;
    }

    /* renamed from: ak */
    public final void mo10142ak(Runnable runnable) {
        AppMethodBeat.m2504i(52530);
        mo10144o(runnable, 0);
        AppMethodBeat.m2505o(52530);
    }

    /* renamed from: o */
    public final void mo10144o(Runnable runnable, long j) {
        AppMethodBeat.m2504i(52531);
        if (0 >= j) {
            this.xDz.execute(runnable);
            AppMethodBeat.m2505o(52531);
            return;
        }
        this.xDz.mo10159p(runnable, j);
        AppMethodBeat.m2505o(52531);
    }

    /* renamed from: a */
    public final void mo10140a(Runnable runnable, String str) {
        AppMethodBeat.m2504i(52532);
        mo10141a(runnable, str, 0);
        AppMethodBeat.m2505o(52532);
    }

    /* renamed from: a */
    public final void mo10141a(Runnable runnable, String str, long j) {
        AppMethodBeat.m2504i(52533);
        if (0 >= j) {
            this.xDz.mo10151b(runnable, str);
            AppMethodBeat.m2505o(52533);
            return;
        }
        this.xDz.mo10152b(runnable, str, j);
        AppMethodBeat.m2505o(52533);
    }

    /* renamed from: al */
    public final void mo10143al(Runnable runnable) {
        AppMethodBeat.m2504i(52534);
        this.xDz.remove(runnable);
        AppMethodBeat.m2505o(52534);
    }
}
