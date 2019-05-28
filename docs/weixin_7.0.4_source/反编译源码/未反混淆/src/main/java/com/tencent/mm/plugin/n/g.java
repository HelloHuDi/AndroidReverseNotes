package com.tencent.mm.plugin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class g {
    public long aOw = 0;
    public long cTh = 0;
    private boolean eif;
    public boolean llI = true;
    public boolean llJ = false;
    public long orA = 0;
    public long orB = 0;
    public long orC = 10;
    public boolean orD = true;
    public boolean orE = false;
    boolean orF = false;
    boolean orG = false;
    public long orx = 0;
    public long ory = -1;
    public long orz = 0;

    public g(boolean z) {
        this.eif = z;
    }

    public final String aZm() {
        AppMethodBeat.i(117871);
        String str = hashCode();
        AppMethodBeat.o(117871);
        return str;
    }

    public final void RH(String str) {
        AppMethodBeat.i(117872);
        if (this.orD) {
            h.pYm.a(354, 152, 1, false);
            h.pYm.e(13836, Integer.valueOf(500), Long.valueOf(bo.anT()), str);
            AppMethodBeat.o(117872);
            return;
        }
        AppMethodBeat.o(117872);
    }

    public final void RI(String str) {
        AppMethodBeat.i(117873);
        if (this.orD) {
            h.pYm.a(354, 153, 1, false);
            h.pYm.e(13836, Integer.valueOf(501), Long.valueOf(bo.anT()), str);
            AppMethodBeat.o(117873);
            return;
        }
        AppMethodBeat.o(117873);
    }

    public final void bOW() {
        AppMethodBeat.i(117874);
        if (this.orD) {
            h.pYm.a(354, 155, 1, false);
            h.pYm.e(13836, Integer.valueOf(ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS), Long.valueOf(bo.anT()), "");
            AppMethodBeat.o(117874);
            return;
        }
        AppMethodBeat.o(117874);
    }
}
