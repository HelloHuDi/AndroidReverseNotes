package com.google.firebase.components;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.firebase.components.o */
final class C8745o {
    final C41645a<?> bve;
    final Set<C8745o> bvf = new HashSet();
    final Set<C8745o> bvg = new HashSet();

    C8745o(C41645a<?> c41645a) {
        AppMethodBeat.m2504i(10623);
        this.bve = c41645a;
        AppMethodBeat.m2505o(10623);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: uC */
    public final boolean mo19764uC() {
        AppMethodBeat.m2504i(10624);
        boolean isEmpty = this.bvg.isEmpty();
        AppMethodBeat.m2505o(10624);
        return isEmpty;
    }
}
