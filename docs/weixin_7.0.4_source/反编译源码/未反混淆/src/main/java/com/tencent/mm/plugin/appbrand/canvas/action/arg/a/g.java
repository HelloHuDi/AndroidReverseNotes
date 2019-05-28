package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionLinearArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionNormalArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionPatternArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionRadialArg;

public final class g extends a<BaseDrawActionArg> {
    private static g hdE = new g();

    static {
        AppMethodBeat.i(103644);
        AppMethodBeat.o(103644);
    }

    public static g ayn() {
        return hdE;
    }

    public final <T> T yA(String str) {
        AppMethodBeat.i(103643);
        BaseDrawActionArg baseDrawActionArg = null;
        if ("linear".equalsIgnoreCase(str)) {
            baseDrawActionArg = new RealSetFillStyleActionLinearArg();
        } else if ("radial".equalsIgnoreCase(str)) {
            baseDrawActionArg = new RealSetFillStyleActionRadialArg();
        } else if ("normal".equalsIgnoreCase(str)) {
            baseDrawActionArg = new RealSetFillStyleActionNormalArg();
        } else if ("pattern".equalsIgnoreCase(str)) {
            baseDrawActionArg = new RealSetFillStyleActionPatternArg();
        }
        baseDrawActionArg.method = str;
        AppMethodBeat.o(103643);
        return baseDrawActionArg;
    }
}
