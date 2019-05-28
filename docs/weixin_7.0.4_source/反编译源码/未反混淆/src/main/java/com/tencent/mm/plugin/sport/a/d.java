package com.tencent.mm.plugin.sport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class d {
    public static final void kT(int i) {
        AppMethodBeat.i(55718);
        ab.v("MicroMsg.Sport.SportReportLogic", "report action=%d", Integer.valueOf(i));
        e.pXa.e(13168, Integer.valueOf(i));
        AppMethodBeat.o(55718);
    }
}
