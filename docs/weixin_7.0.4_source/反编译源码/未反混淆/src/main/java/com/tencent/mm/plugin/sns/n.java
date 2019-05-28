package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.plugin.sns.j.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class n extends c<sc> {
    public n() {
        AppMethodBeat.i(35635);
        this.xxI = sc.class.getName().hashCode();
        AppMethodBeat.o(35635);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(35636);
        sc scVar = (sc) bVar;
        if (scVar instanceof sc) {
            scVar.cOa.cvi = a.b(scVar.cNZ.cOd, scVar.cNZ.url, scVar.cNZ.cOc);
            AppMethodBeat.o(35636);
            return true;
        }
        ab.f("MicroMsg.SnsfillEventInfoListener", "mismatched event");
        AppMethodBeat.o(35636);
        return false;
    }
}
