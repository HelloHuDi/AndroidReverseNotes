package com.bumptech.glide.p086c.p088b;

import com.bumptech.glide.p086c.C0779h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.c.b.r */
final class C37170r {
    private final Map<C0779h, C24644k<?>> aCa = new HashMap();
    private final Map<C0779h, C24644k<?>> aCb = new HashMap();

    C37170r() {
        AppMethodBeat.m2504i(91862);
        AppMethodBeat.m2505o(91862);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ax */
    public final Map<C0779h, C24644k<?>> mo59260ax(boolean z) {
        return z ? this.aCb : this.aCa;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo59259a(C0779h c0779h, C24644k<?> c24644k) {
        AppMethodBeat.m2504i(91863);
        Map ax = mo59260ax(c24644k.aAz);
        if (c24644k.equals(ax.get(c0779h))) {
            ax.remove(c0779h);
        }
        AppMethodBeat.m2505o(91863);
    }
}
