package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;

public final class f extends c<d> {
    private static long cbv = 0;

    public f() {
        AppMethodBeat.i(90607);
        this.xxI = d.class.getName().hashCode();
        AppMethodBeat.o(90607);
    }

    private static boolean a(d dVar) {
        AppMethodBeat.i(138235);
        if (dVar.crQ.crR) {
            AppMethodBeat.o(138235);
        } else if (g.RK()) {
            if (cbv == 0) {
                cbv = ((Long) g.RP().Ry().get(a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(0))).longValue();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - cbv >= 21600000 && com.tinkerboots.sdk.a.dWj() != null) {
                com.tinkerboots.sdk.a.dWj().rF(false);
                ab.i("MicroMsg.Tinker.TinkerBootsActivateListener", "callback post task and fetchPatchUpdate false");
                cbv = currentTimeMillis;
                g.RP().Ry().set(a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
            }
            AppMethodBeat.o(138235);
        } else {
            AppMethodBeat.o(138235);
        }
        return false;
    }

    public static void iT(long j) {
        cbv = j;
    }
}
