package com.tencent.p177mm.plugin.p1506t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.modelcontrol.C37938c;

/* renamed from: com.tencent.mm.plugin.t.a */
public final class C35280a extends C7485q {
    private static C35280a pfY;

    public static synchronized C35280a bZt() {
        C35280a c35280a;
        synchronized (C35280a.class) {
            AppMethodBeat.m2504i(79145);
            if (pfY == null) {
                pfY = new C35280a();
            }
            c35280a = pfY;
            AppMethodBeat.m2505o(79145);
        }
        return c35280a;
    }

    private C35280a() {
        super(C37938c.class);
    }
}
