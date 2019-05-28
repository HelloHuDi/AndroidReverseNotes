package com.tencent.p177mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.p230g.p231a.C6502jw;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.app.m */
public final class C9004m extends C4884c<C6502jw> {
    private static boolean ceQ = false;
    private int ceR;
    private int ceS;

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(15384);
        C6502jw c6502jw = (C6502jw) c4883b;
        if (c6502jw != null) {
            C4990ab.m7421w("MicroMsg.MediaLeakReporter", "event audio[%b %d] mediaplayer[%b %d] audioRecord[%b %d] hadRpt[%b]", Boolean.valueOf(c6502jw.cFd.cFe), Integer.valueOf(c6502jw.cFd.cFf), Boolean.valueOf(c6502jw.cFd.cFg), Integer.valueOf(c6502jw.cFd.cFh), Boolean.valueOf(c6502jw.cFd.cFi), Integer.valueOf(c6502jw.cFd.cFj), Boolean.valueOf(ceQ));
            if (c6502jw.cFd.cFe) {
                C7060h.pYm.mo8378a(650, (long) this.ceR, 1, false);
            }
            if (c6502jw.cFd.cFg) {
                C7060h.pYm.mo8378a(650, (long) this.ceS, 1, false);
            }
            if (c6502jw.cFd.cFi) {
                C7060h.pYm.mo8378a(650, (long) (this.ceS + 1), 1, false);
            }
            if (!ceQ && (c6502jw.cFd.cFf > 10 || c6502jw.cFd.cFh > 10 || c6502jw.cFd.cFj > 0)) {
                C7060h.pYm.mo8382g("mediaLeak", C1407g.m2954Le(), null);
                ceQ = true;
            }
        }
        AppMethodBeat.m2505o(15384);
        return false;
    }

    public C9004m(int i, int i2) {
        AppMethodBeat.m2504i(15383);
        this.ceR = i;
        this.ceS = i2;
        this.xxI = C6502jw.class.getName().hashCode();
        AppMethodBeat.m2505o(15383);
    }
}
