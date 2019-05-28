package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class m extends c<jw> {
    private static boolean ceQ = false;
    private int ceR;
    private int ceS;

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(15384);
        jw jwVar = (jw) bVar;
        if (jwVar != null) {
            ab.w("MicroMsg.MediaLeakReporter", "event audio[%b %d] mediaplayer[%b %d] audioRecord[%b %d] hadRpt[%b]", Boolean.valueOf(jwVar.cFd.cFe), Integer.valueOf(jwVar.cFd.cFf), Boolean.valueOf(jwVar.cFd.cFg), Integer.valueOf(jwVar.cFd.cFh), Boolean.valueOf(jwVar.cFd.cFi), Integer.valueOf(jwVar.cFd.cFj), Boolean.valueOf(ceQ));
            if (jwVar.cFd.cFe) {
                h.pYm.a(650, (long) this.ceR, 1, false);
            }
            if (jwVar.cFd.cFg) {
                h.pYm.a(650, (long) this.ceS, 1, false);
            }
            if (jwVar.cFd.cFi) {
                h.pYm.a(650, (long) (this.ceS + 1), 1, false);
            }
            if (!ceQ && (jwVar.cFd.cFf > 10 || jwVar.cFd.cFh > 10 || jwVar.cFd.cFj > 0)) {
                h.pYm.g("mediaLeak", g.Le(), null);
                ceQ = true;
            }
        }
        AppMethodBeat.o(15384);
        return false;
    }

    public m(int i, int i2) {
        AppMethodBeat.i(15383);
        this.ceR = i;
        this.ceS = i2;
        this.xxI = jw.class.getName().hashCode();
        AppMethodBeat.o(15383);
    }
}
