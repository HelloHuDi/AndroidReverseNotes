package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.b.a;
import com.tencent.mm.plugin.appbrand.canvas.b.e;

public final class f extends a<BasePathActionArg> {
    private static f hdD = new f();

    static {
        AppMethodBeat.i(103642);
        AppMethodBeat.o(103642);
    }

    public static f aym() {
        return hdD;
    }

    public final <T> T yA(String str) {
        AppMethodBeat.i(103641);
        BasePathActionArg ayr = ((a) e.a.hdT.hdS.get(str)).ayr();
        AppMethodBeat.o(103641);
        return ayr;
    }
}
