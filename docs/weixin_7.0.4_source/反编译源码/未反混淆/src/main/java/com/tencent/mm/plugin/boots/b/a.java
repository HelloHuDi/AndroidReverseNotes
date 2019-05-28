package com.tencent.mm.plugin.boots.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.boots.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class a implements e {
    public static a jJA;
    public com.tencent.mm.plugin.boots.b.a.a jJB;

    public final void rT(int i) {
        AppMethodBeat.i(90530);
        e(i, false, 0);
        AppMethodBeat.o(90530);
    }

    public final void dC(int i, int i2) {
        AppMethodBeat.i(90531);
        e(i, true, i2);
        AppMethodBeat.o(90531);
    }

    private void e(int i, boolean z, int i2) {
        int i3 = 255;
        AppMethodBeat.i(90532);
        if (this.jJB != null) {
            com.tencent.mm.plugin.boots.a.a rV = this.jJB.rV(i);
            int rU = this.jJB.rU(i);
            if (z && rV.field_dau != rU) {
                if (rU <= 255) {
                    i3 = rU;
                }
                h.pYm.a((long) i2, (long) i3, 1, false);
            }
            AppMethodBeat.o(90532);
            return;
        }
        ab.w("MicroMsg.Boots.TinkerLogic", "storage is null.");
        AppMethodBeat.o(90532);
    }

    public final List<com.tencent.mm.plugin.boots.a.a> aVJ() {
        AppMethodBeat.i(90533);
        if (this.jJB != null) {
            List aVJ = this.jJB.aVJ();
            AppMethodBeat.o(90533);
            return aVJ;
        }
        AppMethodBeat.o(90533);
        return null;
    }
}
