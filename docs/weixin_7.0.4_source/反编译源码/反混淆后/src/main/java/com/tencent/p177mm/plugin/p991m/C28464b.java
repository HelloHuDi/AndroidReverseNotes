package com.tencent.p177mm.plugin.p991m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C6617c;

/* renamed from: com.tencent.mm.plugin.m.b */
public final class C28464b implements C6617c {
    private static C28464b ops;

    private C28464b() {
    }

    public static synchronized C28464b bOh() {
        C28464b c28464b;
        synchronized (C28464b.class) {
            AppMethodBeat.m2504i(79105);
            if (ops == null) {
                ops = new C28464b();
            }
            c28464b = ops;
            AppMethodBeat.m2505o(79105);
        }
        return c28464b;
    }
}
