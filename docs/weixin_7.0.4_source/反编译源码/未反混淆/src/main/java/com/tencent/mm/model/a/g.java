package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public class g implements at {
    private c foc = null;

    private static g aaJ() {
        AppMethodBeat.i(118151);
        g gVar = (g) q.Y(g.class);
        AppMethodBeat.o(118151);
        return gVar;
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(118152);
        c aaK = aaK();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            aaK.oQ((String) com.tencent.mm.kernel.g.RP().Ry().get(328193, null));
            if (aaK.aaI()) {
                f.oS(aaK.fnW.fnS);
            }
        } catch (Exception e) {
            ab.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", e.toString());
        }
        ab.i("MicroMsg.abtest.AbTestManager", "[Abtest] init use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(118152);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(118153);
        c aaK = aaK();
        aaK.fnX = null;
        aaK.fnW = null;
        AppMethodBeat.o(118153);
    }

    public static c aaK() {
        AppMethodBeat.i(118154);
        com.tencent.mm.kernel.g.RN().QU();
        if (aaJ().foc == null) {
            aaJ().foc = new c();
        }
        c cVar = aaJ().foc;
        AppMethodBeat.o(118154);
        return cVar;
    }
}
