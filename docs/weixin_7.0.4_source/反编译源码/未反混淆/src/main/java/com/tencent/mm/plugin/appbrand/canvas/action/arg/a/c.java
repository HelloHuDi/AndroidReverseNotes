package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.d;

public final class c extends a<BaseDrawActionArg> {
    private static com.tencent.mm.plugin.appbrand.canvas.c hdx = new com.tencent.mm.plugin.appbrand.canvas.c();
    private static c hdy = new c();

    static {
        AppMethodBeat.i(103635);
        AppMethodBeat.o(103635);
    }

    public static c ayj() {
        return hdy;
    }

    public final <T> T yA(String str) {
        AppMethodBeat.i(103634);
        d dVar = (d) hdx.hcD.get(str);
        if (dVar == null) {
            AppMethodBeat.o(103634);
            return null;
        }
        T ayf = dVar.ayf();
        AppMethodBeat.o(103634);
        return ayf;
    }
}
