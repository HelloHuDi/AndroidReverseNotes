package com.tencent.mm.plugin.profile.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.n;
import java.lang.ref.WeakReference;

public final class b implements com.tencent.mm.sdk.e.n.b {
    private WeakReference<com.tencent.mm.sdk.e.n.b> bSI;

    public b(com.tencent.mm.sdk.e.n.b bVar) {
        AppMethodBeat.i(23962);
        this.bSI = new WeakReference(bVar);
        AppMethodBeat.o(23962);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(23963);
        if (this.bSI.get() != null) {
            ((com.tencent.mm.sdk.e.n.b) this.bSI.get()).a(i, nVar, obj);
        }
        AppMethodBeat.o(23963);
    }
}
