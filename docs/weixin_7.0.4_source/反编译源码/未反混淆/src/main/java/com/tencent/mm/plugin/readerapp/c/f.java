package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.model.bm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

final class f extends c<pg> {
    f() {
        AppMethodBeat.i(76762);
        this.xxI = pg.class.getName().hashCode();
        AppMethodBeat.o(76762);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(76763);
        pg pgVar = (pg) bVar;
        if (pgVar instanceof pg) {
            long j = pgVar.cLy.cvx;
            g.jA(j);
            bm cdZ = g.cdZ();
            ab.d("MicroMsg.ReaderAppInfoStorage", "deleteGroupByMsgSvrID:%s", "delete from " + bm.kH(20) + " where reserved2 = " + j);
            if (cdZ.fni.hY(bm.kH(20), "delete from " + bm.kH(20) + " where reserved2 = " + j)) {
                cdZ.kK(20);
                cdZ.doNotify();
            }
            AppMethodBeat.o(76763);
            return true;
        }
        AppMethodBeat.o(76763);
        return false;
    }
}
