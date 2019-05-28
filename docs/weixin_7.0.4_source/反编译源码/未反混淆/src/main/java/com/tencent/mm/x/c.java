package com.tencent.mm.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class c implements at {
    private static c eFk;
    private a eFl;

    private c() {
        AppMethodBeat.i(77749);
        if (a.eEQ == null) {
            a.eEQ = new a();
        }
        this.eFl = a.eEQ;
        AppMethodBeat.o(77749);
    }

    private static synchronized c PJ() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(77750);
            if (eFk == null) {
                cVar = new c();
                eFk = cVar;
                cVar.eFl.init();
            }
            cVar = eFk;
            AppMethodBeat.o(77750);
        }
        return cVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(77751);
        a aVar = this.eFl;
        aVar.eES.clear();
        b bVar = aVar.eER;
        ab.d("MicroMsg.NewBadgeDecoder", "[carl] decoder.clear()");
        bVar.eFa.clear();
        bVar.eFc.clear();
        bVar.eFb.clear();
        bVar.eFd.clear();
        aVar.initialized = false;
        AppMethodBeat.o(77751);
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(77752);
        this.eFl.init();
        AppMethodBeat.o(77752);
    }

    public final void bA(boolean z) {
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public static a PK() {
        AppMethodBeat.i(77753);
        g.RN().QU();
        a aVar = PJ().eFl;
        AppMethodBeat.o(77753);
        return aVar;
    }
}
