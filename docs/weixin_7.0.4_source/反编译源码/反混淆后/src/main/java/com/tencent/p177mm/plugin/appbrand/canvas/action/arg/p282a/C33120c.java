package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.p282a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C10162c;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C10155d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.a.c */
public final class C33120c extends C2098a<BaseDrawActionArg> {
    private static C10162c hdx = new C10162c();
    private static C33120c hdy = new C33120c();

    static {
        AppMethodBeat.m2504i(103635);
        AppMethodBeat.m2505o(103635);
    }

    public static C33120c ayj() {
        return hdy;
    }

    /* renamed from: yA */
    public final <T> T mo5898yA(String str) {
        AppMethodBeat.m2504i(103634);
        C10155d c10155d = (C10155d) hdx.hcD.get(str);
        if (c10155d == null) {
            AppMethodBeat.m2505o(103634);
            return null;
        }
        T ayf = c10155d.ayf();
        AppMethodBeat.m2505o(103634);
        return ayf;
    }
}
