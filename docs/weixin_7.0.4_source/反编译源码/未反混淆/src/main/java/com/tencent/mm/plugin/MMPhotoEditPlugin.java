package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.a;
import com.tencent.mm.api.o;
import com.tencent.mm.api.s;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ab;

public class MMPhotoEditPlugin extends f implements c {
    public void installed() {
    }

    public void configure(g gVar) {
    }

    public void execute(g gVar) {
        AppMethodBeat.i(116300);
        s.ccQ = new a();
        AppMethodBeat.o(116300);
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(116301);
        com.tencent.mm.ai.f fVar = com.tencent.mm.bx.a.xuc;
        ab.i("MicroMsg.MediaSecurityReport", "init");
        com.tencent.mm.kernel.g.Rg().a(110, fVar);
        com.tencent.mm.kernel.g.Rg().a(149, fVar);
        com.tencent.mm.kernel.g.a(o.class, com.tencent.mm.bx.a.xuc);
        AppMethodBeat.o(116301);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(116302);
        com.tencent.mm.kernel.g.L(o.class);
        com.tencent.mm.ai.f fVar = com.tencent.mm.bx.a.xuc;
        ab.i("MicroMsg.MediaSecurityReport", "release");
        com.tencent.mm.kernel.g.Rg().b(110, fVar);
        com.tencent.mm.kernel.g.Rg().b(149, fVar);
        fVar.xud.clear();
        AppMethodBeat.o(116302);
    }
}
