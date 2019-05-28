package com.tencent.p177mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;

/* renamed from: com.tencent.mm.modelstat.f */
public final class C18691f {
    private static C18691f fSQ = null;
    public C1177f<String, Long> fSR = new C7598c(10);
    public String fSS;

    public static C18691f akh() {
        AppMethodBeat.m2504i(78731);
        if (fSQ == null) {
            fSQ = new C18691f();
        }
        C18691f c18691f = fSQ;
        AppMethodBeat.m2505o(78731);
        return c18691f;
    }

    private C18691f() {
        AppMethodBeat.m2504i(78732);
        AppMethodBeat.m2505o(78732);
    }

    /* renamed from: u */
    public final void mo33961u(String str, long j) {
        AppMethodBeat.m2504i(78733);
        if (this.fSR != null) {
            this.fSS = str;
            this.fSR.put(str, Long.valueOf(j));
        }
        AppMethodBeat.m2505o(78733);
    }
}
