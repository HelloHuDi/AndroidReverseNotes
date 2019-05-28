package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cq;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;
import com.tencent.mm.plugin.welab.d.a.a;

public final class c implements d {
    public final void a(String str, b bVar) {
        AppMethodBeat.i(80537);
        a.ddj().uLR.put(str, bVar);
        AppMethodBeat.o(80537);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(80538);
        a.ddj().uLS = bVar;
        AppMethodBeat.o(80538);
    }

    public final cq agJ(String str) {
        AppMethodBeat.i(80539);
        a agI = a.ddj().agI(str);
        AppMethodBeat.o(80539);
        return agI;
    }
}
