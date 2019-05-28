package com.google.firebase.components;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

final class o {
    final a<?> bve;
    final Set<o> bvf = new HashSet();
    final Set<o> bvg = new HashSet();

    o(a<?> aVar) {
        AppMethodBeat.i(10623);
        this.bve = aVar;
        AppMethodBeat.o(10623);
    }

    /* Access modifiers changed, original: final */
    public final boolean uC() {
        AppMethodBeat.i(10624);
        boolean isEmpty = this.bvg.isEmpty();
        AppMethodBeat.o(10624);
        return isEmpty;
    }
}
