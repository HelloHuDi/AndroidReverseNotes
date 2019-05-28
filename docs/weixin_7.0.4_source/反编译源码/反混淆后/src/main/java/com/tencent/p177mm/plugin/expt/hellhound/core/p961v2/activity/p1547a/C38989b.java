package com.tencent.p177mm.plugin.expt.hellhound.core.p961v2.activity.p1547a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.expt.hellhound.core.C11759b;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b */
public final class C38989b {
    private static volatile C38989b lMM;
    public C45903a lMN = new C46908c();

    public static C38989b bqC() {
        AppMethodBeat.m2504i(73427);
        if (lMM == null) {
            synchronized (C38989b.class) {
                try {
                    if (lMM == null) {
                        lMM = new C38989b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(73427);
                    }
                }
            }
        }
        C38989b c38989b = lMM;
        AppMethodBeat.m2505o(73427);
        return c38989b;
    }

    private C38989b() {
        AppMethodBeat.m2504i(73428);
        if (C11759b.bqo()) {
            this.lMN.reset();
        }
        AppMethodBeat.m2505o(73428);
    }
}
