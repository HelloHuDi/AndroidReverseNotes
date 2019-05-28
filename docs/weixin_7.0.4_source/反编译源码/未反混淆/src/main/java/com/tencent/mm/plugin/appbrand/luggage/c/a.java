package com.tencent.mm.plugin.appbrand.luggage.c;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

public final class a implements com.tencent.mm.plugin.appbrand.n.a {
    public final void f(long j, long j2, long j3) {
        AppMethodBeat.i(132153);
        h.pYm.a(j, j2, j3, false);
        AppMethodBeat.o(132153);
    }

    public final void b(ArrayList<IDKey> arrayList, boolean z) {
        AppMethodBeat.i(132154);
        h.pYm.b(arrayList, z);
        AppMethodBeat.o(132154);
    }
}
