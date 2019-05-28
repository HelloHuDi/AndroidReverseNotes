package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionLinearArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionNormalArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionRadialArg;

public final class h extends a<BaseDrawActionArg> {
    private static h hdF = new h();

    static {
        AppMethodBeat.i(103646);
        AppMethodBeat.o(103646);
    }

    public static h ayo() {
        return hdF;
    }

    public final <T> T yA(String str) {
        AppMethodBeat.i(103645);
        BaseDrawActionArg baseDrawActionArg = null;
        if ("linear".equalsIgnoreCase(str)) {
            baseDrawActionArg = new RealSetStrokeStyleActionLinearArg();
        } else if ("radial".equalsIgnoreCase(str)) {
            baseDrawActionArg = new RealSetStrokeStyleActionRadialArg();
        } else if ("normal".equalsIgnoreCase(str)) {
            baseDrawActionArg = new RealSetStrokeStyleActionNormalArg();
        }
        baseDrawActionArg.method = str;
        AppMethodBeat.o(103645);
        return baseDrawActionArg;
    }
}
