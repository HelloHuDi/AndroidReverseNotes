package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h.a;
import com.tencent.mm.g.a.fk;

final class b implements com.tencent.mm.plugin.appbrand.compat.a.b {
    b() {
    }

    public final void a(String str, a aVar, com.tencent.mm.ai.h.b bVar) {
        AppMethodBeat.i(135460);
        fk fkVar = new fk();
        fkVar.czf.op = 1;
        fkVar.czf.fileName = str;
        fkVar.czf.czh = true;
        fkVar.czf.com = true;
        fkVar.czf.czi = aVar;
        fkVar.czf.czj = bVar;
        com.tencent.mm.sdk.b.a.xxA.m(fkVar);
        AppMethodBeat.o(135460);
    }

    public final void pause() {
        AppMethodBeat.i(135461);
        fk fkVar = new fk();
        fkVar.czf.op = 4;
        com.tencent.mm.sdk.b.a.xxA.m(fkVar);
        AppMethodBeat.o(135461);
    }

    public final void stop() {
        AppMethodBeat.i(135462);
        fk fkVar = new fk();
        fkVar.czf.op = 2;
        com.tencent.mm.sdk.b.a.xxA.m(fkVar);
        AppMethodBeat.o(135462);
    }
}
