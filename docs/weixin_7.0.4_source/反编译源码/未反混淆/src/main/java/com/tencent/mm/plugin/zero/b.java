package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.by;
import com.tencent.mm.model.by.a;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.sdk.platformtools.ab;

public final class b implements c, com.tencent.mm.plugin.zero.b.b {
    private by uZV;
    private o xZZ;

    public final o ahW() {
        AppMethodBeat.i(58743);
        g.RQ();
        g.RN().QU();
        if (this.xZZ == null) {
            this.xZZ = new o();
        }
        o oVar = this.xZZ;
        AppMethodBeat.o(58743);
        return oVar;
    }

    public final by dgK() {
        AppMethodBeat.i(58744);
        g.RQ();
        g.RN().QU();
        if (this.uZV == null) {
            this.uZV = new by(new a() {
                public final boolean aaC() {
                    AppMethodBeat.i(58742);
                    if (b.this.ahW().fJj == null) {
                        AppMethodBeat.o(58742);
                        return true;
                    }
                    AppMethodBeat.o(58742);
                    return false;
                }
            });
        }
        by byVar = this.uZV;
        AppMethodBeat.o(58744);
        return byVar;
    }

    public final void onAccountInitialized(e.c cVar) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(58745);
        if (this.xZZ != null) {
            o oVar = this.xZZ;
            ab.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", Integer.valueOf(oVar.fJg.size()), Integer.valueOf(oVar.fJh.size()), oVar.fJj);
            oVar.fJg.clear();
            oVar.fJh.clear();
        }
        if (this.uZV != null) {
            this.uZV.aax();
        }
        AppMethodBeat.o(58745);
    }
}
