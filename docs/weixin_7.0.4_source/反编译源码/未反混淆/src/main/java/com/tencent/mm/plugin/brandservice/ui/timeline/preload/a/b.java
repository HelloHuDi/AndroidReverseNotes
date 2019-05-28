package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class b extends j<a> {
    public static final String[] fjY = new String[]{j.a(a.fjX, "BizAppMsgReportContext")};
    public static final String[] fjZ = new String[0];
    final e bSd;

    public final /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(14397);
        boolean a = a((a) cVar);
        AppMethodBeat.o(14397);
        return a;
    }

    static {
        AppMethodBeat.i(14398);
        AppMethodBeat.o(14398);
    }

    public b(e eVar) {
        super(eVar, a.fjX, "BizAppMsgReportContext", fjZ);
        this.bSd = eVar;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(14395);
        aVar.field_appMsgReportContextId = aVar.field_reportTime;
        boolean b = super.b((c) aVar);
        AppMethodBeat.o(14395);
        return b;
    }

    public final void ba(List<a> list) {
        AppMethodBeat.i(14396);
        long iV = g.RP().eJN.iV(Thread.currentThread().getId());
        for (a a : list) {
            if (!a((c) a, new String[0])) {
                ab.v("MicroMsg.Preload.BizAppMsgReportContextStorage", "[remove] delete fail");
            }
        }
        g.RP().eJN.mB(iV);
        AppMethodBeat.o(14396);
    }
}
