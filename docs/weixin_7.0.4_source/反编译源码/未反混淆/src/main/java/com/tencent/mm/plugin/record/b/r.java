package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class r extends c<nt> {
    public r() {
        AppMethodBeat.i(135750);
        this.xxI = nt.class.getName().hashCode();
        AppMethodBeat.o(135750);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(135751);
        nt ntVar = (nt) bVar;
        ab.i("MicroMsg.RecordOperationListener", "on record operation listener, %d", Integer.valueOf(ntVar.cJY.type));
        switch (ntVar.cJY.type) {
            case 0:
                ntVar.cJZ.cKi = n.VI(ntVar.cJY.cKa);
                break;
            case 1:
                ab.i("MicroMsg.RecordOperationListener", "get record paths, msg id %d", Long.valueOf(ntVar.cJY.cvx));
                ntVar.cJZ.cKj = n.d(ntVar.cJY.cAv, ntVar.cJY.cvx);
                ntVar.cJZ.dataPath = n.c(ntVar.cJY.cAv, ntVar.cJY.cvx);
                ntVar.cJZ.cKk = n.e(ntVar.cJY.cAv, ntVar.cJY.cvx);
                ntVar.cJZ.thumbPath = n.f(ntVar.cJY.cAv, ntVar.cJY.cvx);
                break;
            case 2:
                ab.i("MicroMsg.RecordOperationListener", "send record msg, to %s, thumbPath %s, thumbId %s", ntVar.cJY.toUser, ntVar.cJY.thumbPath, Integer.valueOf(ntVar.cJY.cKc));
                n.a(ntVar.cJY.toUser, ntVar.cJY.cKb, ntVar.cJY.title, ntVar.cJY.desc, ntVar.cJY.thumbPath, ntVar.cJY.cKc, ntVar.cJY.cKg);
                break;
            case 3:
                ab.i("MicroMsg.RecordOperationListener", "clear resouces, msg id %d", Long.valueOf(ntVar.cJY.cvx));
                n.jF(ntVar.cJY.cvx);
                break;
            case 4:
                ab.i("MicroMsg.RecordOperationListener", "forward record msg, to %s, msg id %d", ntVar.cJY.toUser, Long.valueOf(ntVar.cJY.cKd.field_msgId));
                n.a(ntVar.cJY.toUser, ntVar.cJY.cAN, ntVar.cJY.cKd);
                break;
            case 5:
                ab.i("MicroMsg.RecordOperationListener", "summerrecord forward multi record msg, to %s", ntVar.cJY.toUser);
                n.a(ntVar.cJY.context, ntVar.cJY.toUser, ntVar.cJY.cKf, ntVar.cJY.cKe, ntVar.cJY.cJy, ntVar.cJY.cKh);
                break;
            case 6:
                cl clVar = new cl();
                b.a(ntVar.cJY.context, clVar, ntVar.cJY.cKf, ntVar.cJY.cKe);
                d a = n.a(ntVar.cJY.context, clVar, ntVar.cJY.cKf);
                ntVar.cJZ.cJy = clVar;
                ntVar.cJZ.cKh = a;
                break;
            case 8:
                if (!bo.isNullOrNil(ntVar.cJY.thumbPath)) {
                    n.c(ntVar.cJY.cAv, ntVar.cJY.cvx, true);
                    break;
                }
                n.b(ntVar.cJY.cAv, ntVar.cJY.cvx, true);
                break;
            case 9:
                ntVar.cJZ.cKj = n.g(ntVar.cJY.cAv, ntVar.cJY.cvx);
                break;
        }
        AppMethodBeat.o(135751);
        return false;
    }
}
