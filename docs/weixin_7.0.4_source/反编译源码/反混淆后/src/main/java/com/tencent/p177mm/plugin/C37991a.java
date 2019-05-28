package com.tencent.p177mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.modelstat.C42225q;

/* renamed from: com.tencent.mm.plugin.a */
public final class C37991a extends C7485q {
    private static C37991a gkD;

    public static synchronized C37991a aob() {
        C37991a c37991a;
        synchronized (C37991a.class) {
            AppMethodBeat.m2504i(79046);
            if (gkD == null) {
                gkD = new C37991a();
            }
            c37991a = gkD;
            AppMethodBeat.m2505o(79046);
        }
        return c37991a;
    }

    private C37991a() {
        super(C42225q.class);
    }
}
