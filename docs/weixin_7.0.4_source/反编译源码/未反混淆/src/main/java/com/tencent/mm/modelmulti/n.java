package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.c;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;

public class n implements at {
    public static HashMap<Integer, d> eaA = new HashMap();
    private c fJe;

    static {
        AppMethodBeat.i(16510);
        AppMethodBeat.o(16510);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(16505);
        a aVar = a.xxA;
        c cVar = new c();
        this.fJe = cVar;
        aVar.c(cVar);
        AppMethodBeat.o(16505);
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.n ahV() {
        AppMethodBeat.i(16506);
        g.RQ();
        g.RN().QU();
        com.tencent.mm.plugin.messenger.foundation.a.a.n ahV = ((j) g.K(j.class)).ahV();
        AppMethodBeat.o(16506);
        return ahV;
    }

    public static o ahW() {
        AppMethodBeat.i(16507);
        o ahW = ((b) g.K(b.class)).ahW();
        AppMethodBeat.o(16507);
        return ahW;
    }

    public static n ahX() {
        AppMethodBeat.i(16508);
        aw.ZE();
        n nVar = (n) bw.oJ(n.class.getName());
        if (nVar == null) {
            nVar = new n();
            aw.ZE().a(n.class.getName(), nVar);
        }
        AppMethodBeat.o(16508);
        return nVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(16509);
        if (this.fJe != null) {
            c cVar = this.fJe;
            a.xxA.d(cVar.fCr);
            com.tencent.mm.aq.b.agG().fCk = null;
            ((j) g.K(j.class)).XR().b(cVar);
            ahX();
            ahV().d(cVar);
            a.xxA.d(this.fJe);
        }
        AppMethodBeat.o(16509);
    }
}
