package com.bumptech.glide.c.b;

import com.bumptech.glide.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

final class r {
    private final Map<h, k<?>> aCa = new HashMap();
    private final Map<h, k<?>> aCb = new HashMap();

    r() {
        AppMethodBeat.i(91862);
        AppMethodBeat.o(91862);
    }

    /* Access modifiers changed, original: final */
    public final Map<h, k<?>> ax(boolean z) {
        return z ? this.aCb : this.aCa;
    }

    /* Access modifiers changed, original: final */
    public final void a(h hVar, k<?> kVar) {
        AppMethodBeat.i(91863);
        Map ax = ax(kVar.aAz);
        if (kVar.equals(ax.get(hVar))) {
            ax.remove(hVar);
        }
        AppMethodBeat.o(91863);
    }
}
