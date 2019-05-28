package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.p282a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionLinearArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionNormalArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionPatternArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.RealSetFillStyleActionRadialArg;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.a.g */
public final class C26812g extends C2098a<BaseDrawActionArg> {
    private static C26812g hdE = new C26812g();

    static {
        AppMethodBeat.m2504i(103644);
        AppMethodBeat.m2505o(103644);
    }

    public static C26812g ayn() {
        return hdE;
    }

    /* renamed from: yA */
    public final <T> T mo5898yA(String str) {
        AppMethodBeat.m2504i(103643);
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
        AppMethodBeat.m2505o(103643);
        return baseDrawActionArg;
    }
}
