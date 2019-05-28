package com.tencent.mm.plugin.profile.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class a implements com.tencent.mm.ah.d.a {
    private WeakReference<com.tencent.mm.ah.d.a> bSI;

    public a(com.tencent.mm.ah.d.a aVar) {
        AppMethodBeat.i(23960);
        this.bSI = new WeakReference(aVar);
        AppMethodBeat.o(23960);
    }

    public final void qj(String str) {
        AppMethodBeat.i(23961);
        if (this.bSI.get() != null) {
            ((com.tencent.mm.ah.d.a) this.bSI.get()).qj(str);
        }
        AppMethodBeat.o(23961);
    }
}
