package com.tencent.p177mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.model.C34034c;

/* renamed from: com.tencent.mm.plugin.exdevice.service.u */
public final class C20548u {
    private static C20548u lwO = null;
    private C34034c lwP;
    private C27859f lwQ;

    private static C20548u bpw() {
        AppMethodBeat.m2504i(19626);
        if (lwO == null) {
            lwO = new C20548u();
        }
        C20548u c20548u = lwO;
        AppMethodBeat.m2505o(19626);
        return c20548u;
    }

    public static C27859f bpx() {
        AppMethodBeat.m2504i(19627);
        if (C20548u.bpw().lwQ == null) {
            C20548u.bpw().lwQ = new C27859f();
        }
        C27859f c27859f = C20548u.bpw().lwQ;
        AppMethodBeat.m2505o(19627);
        return c27859f;
    }

    /* renamed from: a */
    public static void m31750a(C27865m c27865m) {
        AppMethodBeat.m2504i(19628);
        C20548u.bpy().lqX = c27865m;
        AppMethodBeat.m2505o(19628);
    }

    public static C34034c bpy() {
        AppMethodBeat.m2504i(19629);
        if (C20548u.bpw().lwP == null) {
            C20548u.bpw().lwP = C34034c.boB();
        }
        C34034c c34034c = C20548u.bpw().lwP;
        AppMethodBeat.m2505o(19629);
        return c34034c;
    }
}
