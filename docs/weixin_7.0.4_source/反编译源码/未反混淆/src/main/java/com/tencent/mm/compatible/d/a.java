package com.tencent.mm.compatible.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public enum a {
    ;
    
    private static volatile a epC;

    public interface a {
        void u(long j, long j2);
    }

    private a(String str) {
    }

    static {
        epC = new a() {
            public final void u(long j, long j2) {
                AppMethodBeat.i(92904);
                ab.w("MicroMsg.ReportDelegate", "hy: dummy reportIDKey, do nothing");
                AppMethodBeat.o(92904);
            }
        };
        AppMethodBeat.o(92909);
    }

    public static synchronized void a(a aVar) {
        synchronized (a.class) {
            epC = aVar;
        }
    }

    public static void eT(long j) {
        AppMethodBeat.i(92907);
        epC.u(853, j);
        AppMethodBeat.o(92907);
    }

    public static void eU(long j) {
        AppMethodBeat.i(92908);
        epC.u(650, j);
        AppMethodBeat.o(92908);
    }
}
