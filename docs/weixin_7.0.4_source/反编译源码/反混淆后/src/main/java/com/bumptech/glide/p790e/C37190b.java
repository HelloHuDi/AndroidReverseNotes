package com.bumptech.glide.p790e;

import com.bumptech.glide.p086c.C0776f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.e.b */
public final class C37190b {
    private final List<C0776f> azH = new ArrayList();

    public C37190b() {
        AppMethodBeat.m2504i(92432);
        AppMethodBeat.m2505o(92432);
    }

    /* renamed from: nK */
    public final synchronized List<C0776f> mo59284nK() {
        return this.azH;
    }

    /* renamed from: a */
    public final synchronized void mo59283a(C0776f c0776f) {
        AppMethodBeat.m2504i(92433);
        this.azH.add(c0776f);
        AppMethodBeat.m2505o(92433);
    }
}
