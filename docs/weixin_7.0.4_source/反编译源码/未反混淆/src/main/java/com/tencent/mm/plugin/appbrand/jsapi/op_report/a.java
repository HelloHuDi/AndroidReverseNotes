package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;

final class a extends p {
    private static final int CTRL_INDEX = 246;
    private static final String NAME = "onStartReportPageData";
    private static final a hSU = new a();

    a() {
    }

    static synchronized void k(c cVar) {
        synchronized (a.class) {
            AppMethodBeat.i(102003);
            hSU.i(cVar).aCj();
            AppMethodBeat.o(102003);
        }
    }

    static {
        AppMethodBeat.i(102004);
        AppMethodBeat.o(102004);
    }
}
