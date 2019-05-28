package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.k;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

final class a extends c<ag> {
    a() {
        AppMethodBeat.i(76752);
        this.xxI = ag.class.getName().hashCode();
        AppMethodBeat.o(76752);
    }

    private boolean a(ag agVar) {
        AppMethodBeat.i(76753);
        if (agVar instanceof ag) {
            if (agVar.ctc.cte == 0) {
                try {
                    int YK = r.YK() | 262144;
                    g.RP().Ry().set(34, Integer.valueOf(YK));
                    bko bko = new bko();
                    bko.vCi = 262144;
                    bko.wNJ = 1;
                    ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(39, bko));
                    ((j) g.K(j.class)).XL().c(new k("", "", "", "", "", "", "", "", YK, "", ""));
                    g.b(new com.tencent.mm.plugin.readerapp.c.g.a() {
                        public final void cdW() {
                        }
                    });
                    g.RP().Ry().set(40, Integer.valueOf(r.YF() & -33));
                    ((j) g.K(j.class)).XL().c(new com.tencent.mm.az.g(21, 2));
                    ab.d("MicroMsg.ReaderAppBindQQ.EventListener", "doClearReaderAppWeiboHelper succ ");
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.ReaderAppBindQQ.EventListener", e, "", new Object[0]);
                }
            }
            AppMethodBeat.o(76753);
            return false;
        }
        ab.f("MicroMsg.ReaderAppBindQQ.EventListener", "not bind qq event");
        AppMethodBeat.o(76753);
        return false;
    }
}
