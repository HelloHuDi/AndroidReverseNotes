package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.sdk.platformtools.ah;

public final class a {
    private static a tdT;
    public i sTj = new i(ah.getContext());

    private a() {
        AppMethodBeat.i(135312);
        AppMethodBeat.o(135312);
    }

    public static a cMm() {
        AppMethodBeat.i(135313);
        if (tdT == null) {
            tdT = new a();
        }
        a aVar = tdT;
        AppMethodBeat.o(135313);
        return aVar;
    }

    public static a cMn() {
        AppMethodBeat.i(135314);
        if (tdT == null) {
            tdT = cMm();
        }
        a aVar = tdT;
        AppMethodBeat.o(135314);
        return aVar;
    }

    public final void cMo() {
        AppMethodBeat.i(135315);
        if (this.sTj != null) {
            this.sTj.ao(0, true);
        }
        AppMethodBeat.o(135315);
    }

    public final void stopRing() {
        AppMethodBeat.i(135316);
        if (this.sTj != null) {
            this.sTj.stop();
        }
        AppMethodBeat.o(135316);
    }

    public final boolean cKq() {
        AppMethodBeat.i(135317);
        if (this.sTj != null) {
            boolean DB = this.sTj.DB();
            AppMethodBeat.o(135317);
            return DB;
        }
        AppMethodBeat.o(135317);
        return true;
    }
}
