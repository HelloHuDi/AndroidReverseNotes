package com.tencent.p177mm.splash;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.splash.C5126o.C5125a;

/* renamed from: com.tencent.mm.splash.m */
public final class C5122m {
    private static String bWa;
    private static Application xGE;
    private static boolean xHB = false;
    private static C5121a xHC;
    private static boolean xHD = false;
    private static C5125a xHE;

    /* renamed from: com.tencent.mm.splash.m$a */
    public interface C5121a {
        /* renamed from: BQ */
        void mo10499BQ();

        /* renamed from: a */
        void mo10500a(C5125a c5125a);

        /* renamed from: b */
        void mo10501b(Application application, String str);
    }

    /* renamed from: BK */
    static /* synthetic */ void m7788BK() {
        AppMethodBeat.m2504i(114895);
        C5122m.drq();
        AppMethodBeat.m2505o(114895);
    }

    /* renamed from: sS */
    static /* synthetic */ void m7791sS(String str) {
        AppMethodBeat.m2504i(114894);
        C5122m.aoc(str);
        AppMethodBeat.m2505o(114894);
    }

    /* renamed from: a */
    public static void m7789a(Application application, String str, final String str2) {
        boolean z = true;
        AppMethodBeat.m2504i(114889);
        xGE = application;
        bWa = str;
        C5115h.m7772a(new C5126o() {
            /* renamed from: d */
            public final void mo10502d(C5125a c5125a) {
                AppMethodBeat.m2504i(114888);
                C4990ab.m7416i("MicroMsg.SplashInit", "do one more thing");
                C5122m.xHE = c5125a;
                C5122m.m7791sS(str2);
                C5122m.m7788BK();
                AppMethodBeat.m2505o(114888);
            }
        });
        C5115h.drh().mStartTimestamp = System.currentTimeMillis();
        if (!application.getPackageName().equals(str)) {
            C5115h.m7780g("MicroMsg.SplashInit", "not main process(%s), no hack, do fallback.", str);
        } else if (C5115h.m7782i(application)) {
            z = false;
            C5115h.drc();
        } else {
            C5115h.drh().mo10503m(675, 5, 1);
            C5115h.m7781hh(application);
            C5115h.m7780g("MicroMsg.SplashInit", "hack failed, do fallback logic.", new Object[0]);
        }
        xHB = z;
        if (C5115h.xGI != null) {
            C5115h.xGI.mo4572BP();
        }
        if (z) {
            if (C5102a.m7740hc(application)) {
                try {
                    C5102a.m7742he(application);
                    C5115h.m7780g("MicroMsg.SplashInit", "block checking dex opt result: %s", Boolean.valueOf(C5102a.m7744hg(application)));
                    if (!C5102a.m7744hg(application)) {
                        C5115h.m7780g("MicroMsg.SplashInit", "dexopt service return failed or timeout. kill self.", new Object[0]);
                        C5115h.bZk();
                    }
                } catch (InterruptedException e) {
                    RuntimeException runtimeException = new RuntimeException(e);
                    AppMethodBeat.m2505o(114889);
                    throw runtimeException;
                }
            }
            C5102a.m7741hd(application);
        }
        if (C5108g.f1294wY || z) {
            C5122m.aoc(str2);
        }
        AppMethodBeat.m2505o(114889);
    }

    private static void aoc(String str) {
        AppMethodBeat.m2504i(114890);
        if (xHC != null) {
            AppMethodBeat.m2505o(114890);
            return;
        }
        C5121a aod = C5122m.aod(str);
        aod.mo10501b(xGE, bWa);
        xHC = aod;
        AppMethodBeat.m2505o(114890);
    }

    private static void drq() {
        AppMethodBeat.m2504i(114891);
        if (xHD && xHE != null) {
            xHC.mo10500a(xHE);
        }
        AppMethodBeat.m2505o(114891);
    }

    public static void drr() {
        AppMethodBeat.m2504i(114892);
        C5115h.m7780g("MicroMsg.SplashInit", "applicationOnCreate", new Object[0]);
        C5115h.dqY();
        xHD = true;
        if (xHB) {
            xHC.mo10499BQ();
            AppMethodBeat.m2505o(114892);
            return;
        }
        C5122m.drq();
        AppMethodBeat.m2505o(114892);
    }

    private static C5121a aod(String str) {
        AppMethodBeat.m2504i(114893);
        try {
            C5121a c5121a = (C5121a) Class.forName(str).newInstance();
            AppMethodBeat.m2505o(114893);
            return c5121a;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SplashInit", e, "%s has problem!", str);
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(114893);
            throw runtimeException;
        }
    }
}
