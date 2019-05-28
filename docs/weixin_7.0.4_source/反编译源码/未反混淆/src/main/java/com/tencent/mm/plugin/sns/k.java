package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.plugin.sns.model.ab.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class k extends c<oe> {
    public k() {
        AppMethodBeat.i(35626);
        this.xxI = oe.class.getName().hashCode();
        AppMethodBeat.o(35626);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(35627);
        oe oeVar = (oe) bVar;
        if (oeVar instanceof oe) {
            if (oeVar.cKx.state == 0) {
                ab.d("MicroMsg.RemoveSnsTaskEventListener", "start clean");
                com.tencent.mm.plugin.sns.model.ab.nLD = true;
                com.tencent.mm.plugin.sns.model.ab abVar = new com.tencent.mm.plugin.sns.model.ab();
                abVar.qKk = System.currentTimeMillis();
                if (!abVar.qKj) {
                    new a().u("");
                }
            } else {
                ab.d("MicroMsg.RemoveSnsTaskEventListener", "stop clean");
                com.tencent.mm.plugin.sns.model.ab.nLD = false;
            }
            AppMethodBeat.o(35627);
            return true;
        }
        ab.f("MicroMsg.RemoveSnsTaskEventListener", "mismatched event");
        AppMethodBeat.o(35627);
        return false;
    }
}
