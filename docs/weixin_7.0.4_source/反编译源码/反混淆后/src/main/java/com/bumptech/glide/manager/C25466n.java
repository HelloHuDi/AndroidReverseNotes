package com.bumptech.glide.manager;

import com.bumptech.glide.p791f.C17553b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.bumptech.glide.manager.n */
public final class C25466n {
    public final Set<C17553b> aGR = Collections.newSetFromMap(new WeakHashMap());
    public final List<C17553b> aGS = new ArrayList();
    public boolean isPaused;

    public C25466n() {
        AppMethodBeat.m2504i(92408);
        AppMethodBeat.m2505o(92408);
    }

    /* renamed from: a */
    public final boolean mo42517a(C17553b c17553b, boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(92409);
        if (c17553b == null) {
            AppMethodBeat.m2505o(92409);
        } else {
            boolean remove = this.aGR.remove(c17553b);
            if (!(this.aGS.remove(c17553b) || remove)) {
                z2 = false;
            }
            if (z2) {
                c17553b.clear();
                if (z) {
                    c17553b.recycle();
                }
            }
            AppMethodBeat.m2505o(92409);
        }
        return z2;
    }

    public final String toString() {
        AppMethodBeat.m2504i(92410);
        String str = super.toString() + "{numRequests=" + this.aGR.size() + ", isPaused=" + this.isPaused + "}";
        AppMethodBeat.m2505o(92410);
        return str;
    }
}
