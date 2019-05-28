package com.tencent.p177mm.kernel;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.kernel.j */
public final class C1736j {
    private static long eKJ;
    private static long eKK;
    private static volatile C1735a eKL = null;

    /* renamed from: com.tencent.mm.kernel.j$a */
    public interface C1735a {
        /* renamed from: d */
        void mo5259d(String str, String str2, Object... objArr);

        /* renamed from: e */
        void mo5260e(String str, String str2, Object... objArr);

        /* renamed from: i */
        void mo5261i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        /* renamed from: w */
        void mo5263w(String str, String str2, Object... objArr);
    }

    /* renamed from: q */
    public static void m3589q(long j, long j2) {
        eKJ = j;
        eKK = j2;
    }

    /* renamed from: h */
    public static void m3586h(String str, long j) {
        AppMethodBeat.m2504i(123266);
        long nanoTime = System.nanoTime() - j;
        C4990ab.m7417i("Blink-LOG", "since the %s : %s", str, Long.valueOf(nanoTime));
        AppMethodBeat.m2505o(123266);
    }

    /* renamed from: jD */
    public static void m3588jD(String str) {
        AppMethodBeat.m2504i(123267);
        long elapsedRealtime = SystemClock.elapsedRealtime() - eKK;
        C4990ab.m7417i("Blink-LOG", "since startup %s : %s", str, Long.valueOf(elapsedRealtime));
        String.format("since startup %s : %s", new Object[]{str, Long.valueOf(elapsedRealtime)});
        AppMethodBeat.m2505o(123267);
    }

    /* renamed from: a */
    public static void m3583a(C1735a c1735a) {
        eKL = c1735a;
    }

    /* renamed from: e */
    public static void m3585e(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(123268);
        if (eKL != null) {
            eKL.mo5260e(str, str2, objArr);
        }
        AppMethodBeat.m2505o(123268);
    }

    /* renamed from: w */
    public static void m3590w(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(123269);
        if (eKL != null) {
            eKL.mo5263w(str, str2, objArr);
        }
        AppMethodBeat.m2505o(123269);
    }

    /* renamed from: i */
    public static void m3587i(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(123270);
        if (eKL != null) {
            eKL.mo5261i(str, str2, objArr);
        }
        AppMethodBeat.m2505o(123270);
    }

    /* renamed from: d */
    public static void m3584d(String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(123271);
        if (eKL != null) {
            eKL.mo5259d(str, str2, objArr);
        }
        AppMethodBeat.m2505o(123271);
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        AppMethodBeat.m2504i(123272);
        if (eKL != null) {
            eKL.printErrStackTrace(str, th, str2, objArr);
        }
        AppMethodBeat.m2505o(123272);
    }

    /* renamed from: RU */
    public static void m3582RU() {
    }
}
