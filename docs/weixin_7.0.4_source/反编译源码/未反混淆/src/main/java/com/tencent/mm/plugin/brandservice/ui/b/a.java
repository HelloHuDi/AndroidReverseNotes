package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.q;

public final class a {
    public static int jYZ = 180;
    private static long jZa = 43200000;
    private static long jZb = 0;

    public static void gP(long j) {
        jZa = j;
    }

    public static long aYQ() {
        if (jZa <= 0) {
            jZa = 43200000;
        }
        return jZa;
    }

    public static void gQ(long j) {
        jZb = j;
    }

    public static boolean e(q qVar) {
        AppMethodBeat.i(14446);
        if (qVar == null) {
            AppMethodBeat.o(14446);
            return false;
        }
        int i;
        qVar.xHU = d.FG(qVar.field_talker);
        if ((qVar.field_bitFlag & 1) != 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            AppMethodBeat.o(14446);
            return true;
        } else if (sG(2) && qVar.xHU) {
            AppMethodBeat.o(14446);
            return true;
        } else {
            if (sG(1)) {
                ad aoO = ((j) g.K(j.class)).XM().aoO(qVar.field_talker);
                if (aoO != null && aoO.Oe()) {
                    AppMethodBeat.o(14446);
                    return true;
                }
            }
            AppMethodBeat.o(14446);
            return false;
        }
    }

    public static boolean sG(int i) {
        return (jZb & ((long) i)) != 0;
    }
}
