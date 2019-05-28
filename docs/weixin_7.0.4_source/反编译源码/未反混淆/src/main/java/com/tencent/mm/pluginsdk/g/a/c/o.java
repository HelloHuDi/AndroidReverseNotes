package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.k;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.b.b;

public final class o implements c, com.tencent.mm.kernel.b.c {
    public static final o vfu = new o();
    private final n kzM = new a() {
        public final void gl(int i) {
            AppMethodBeat.i(79603);
            p.dix();
            AppMethodBeat.o(79603);
        }
    };
    private final com.tencent.mm.sdk.b.c vfv = new com.tencent.mm.sdk.b.c<k>() {
        {
            AppMethodBeat.i(79604);
            this.xxI = k.class.getName().hashCode();
            AppMethodBeat.o(79604);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(79605);
            if (!((k) bVar).csh.csi) {
                p.dix();
            }
            AppMethodBeat.o(79605);
            return false;
        }
    };

    public o() {
        AppMethodBeat.i(79606);
        AppMethodBeat.o(79606);
    }

    static {
        AppMethodBeat.i(79609);
        AppMethodBeat.o(79609);
    }

    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(79607);
        for (g cYt : r.diz()) {
            cYt.cYt();
        }
        g.RO().a(this.kzM);
        this.vfv.dnU();
        AppMethodBeat.o(79607);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(79608);
        g.RO().b(this.kzM);
        this.vfv.dead();
        for (g onAccountRelease : r.diz()) {
            onAccountRelease.onAccountRelease();
        }
        AppMethodBeat.o(79608);
    }
}
