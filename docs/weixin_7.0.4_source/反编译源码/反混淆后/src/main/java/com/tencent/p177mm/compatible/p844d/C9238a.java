package com.tencent.p177mm.compatible.p844d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.compatible.d.a */
public enum C9238a {
    ;
    
    private static volatile C9240a epC;

    /* renamed from: com.tencent.mm.compatible.d.a$1 */
    static class C92391 implements C9240a {
        C92391() {
        }

        /* renamed from: u */
        public final void mo20660u(long j, long j2) {
            AppMethodBeat.m2504i(92904);
            C4990ab.m7420w("MicroMsg.ReportDelegate", "hy: dummy reportIDKey, do nothing");
            AppMethodBeat.m2505o(92904);
        }
    }

    /* renamed from: com.tencent.mm.compatible.d.a$a */
    public interface C9240a {
        /* renamed from: u */
        void mo20660u(long j, long j2);
    }

    private C9238a(String str) {
    }

    static {
        epC = new C92391();
        AppMethodBeat.m2505o(92909);
    }

    /* renamed from: a */
    public static synchronized void m16769a(C9240a c9240a) {
        synchronized (C9238a.class) {
            epC = c9240a;
        }
    }

    /* renamed from: eT */
    public static void m16770eT(long j) {
        AppMethodBeat.m2504i(92907);
        epC.mo20660u(853, j);
        AppMethodBeat.m2505o(92907);
    }

    /* renamed from: eU */
    public static void m16771eU(long j) {
        AppMethodBeat.m2504i(92908);
        epC.mo20660u(650, j);
        AppMethodBeat.m2505o(92908);
    }
}
