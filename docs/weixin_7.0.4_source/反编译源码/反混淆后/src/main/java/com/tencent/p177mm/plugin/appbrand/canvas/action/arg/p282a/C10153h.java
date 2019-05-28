package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.p282a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionLinearArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionNormalArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.RealSetStrokeStyleActionRadialArg;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.a.h */
public final class C10153h extends C2098a<BaseDrawActionArg> {
    private static C10153h hdF = new C10153h();

    static {
        AppMethodBeat.m2504i(103646);
        AppMethodBeat.m2505o(103646);
    }

    public static C10153h ayo() {
        return hdF;
    }

    /* renamed from: yA */
    public final <T> T mo5898yA(String str) {
        AppMethodBeat.m2504i(103645);
        BaseDrawActionArg baseDrawActionArg = null;
        if ("linear".equalsIgnoreCase(str)) {
            baseDrawActionArg = new RealSetStrokeStyleActionLinearArg();
        } else if ("radial".equalsIgnoreCase(str)) {
            baseDrawActionArg = new RealSetStrokeStyleActionRadialArg();
        } else if ("normal".equalsIgnoreCase(str)) {
            baseDrawActionArg = new RealSetStrokeStyleActionNormalArg();
        }
        baseDrawActionArg.method = str;
        AppMethodBeat.m2505o(103645);
        return baseDrawActionArg;
    }
}
