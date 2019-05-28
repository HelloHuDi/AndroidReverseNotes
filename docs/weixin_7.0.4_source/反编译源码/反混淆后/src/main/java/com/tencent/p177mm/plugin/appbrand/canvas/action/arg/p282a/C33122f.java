package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.p282a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.p886b.C10158e.C10159a;
import com.tencent.p177mm.plugin.appbrand.canvas.p886b.C42399a;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.a.f */
public final class C33122f extends C2098a<BasePathActionArg> {
    private static C33122f hdD = new C33122f();

    static {
        AppMethodBeat.m2504i(103642);
        AppMethodBeat.m2505o(103642);
    }

    public static C33122f aym() {
        return hdD;
    }

    /* renamed from: yA */
    public final <T> T mo5898yA(String str) {
        AppMethodBeat.m2504i(103641);
        BasePathActionArg ayr = ((C42399a) C10159a.hdT.hdS.get(str)).ayr();
        AppMethodBeat.m2505o(103641);
        return ayr;
    }
}
