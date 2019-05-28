package com.tencent.mm.splash;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class m {
    private static String bWa;
    private static Application xGE;
    private static boolean xHB = false;
    private static a xHC;
    private static boolean xHD = false;
    private static com.tencent.mm.splash.o.a xHE;

    public interface a {
        void BQ();

        void a(com.tencent.mm.splash.o.a aVar);

        void b(Application application, String str);
    }

    static /* synthetic */ void BK() {
        AppMethodBeat.i(114895);
        drq();
        AppMethodBeat.o(114895);
    }

    static /* synthetic */ void sS(String str) {
        AppMethodBeat.i(114894);
        aoc(str);
        AppMethodBeat.o(114894);
    }

    public static void a(Application application, String str, final String str2) {
        boolean z = true;
        AppMethodBeat.i(114889);
        xGE = application;
        bWa = str;
        h.a(new o() {
            public final void d(com.tencent.mm.splash.o.a aVar) {
                AppMethodBeat.i(114888);
                ab.i("MicroMsg.SplashInit", "do one more thing");
                m.xHE = aVar;
                m.sS(str2);
                m.BK();
                AppMethodBeat.o(114888);
            }
        });
        h.drh().mStartTimestamp = System.currentTimeMillis();
        if (!application.getPackageName().equals(str)) {
            h.g("MicroMsg.SplashInit", "not main process(%s), no hack, do fallback.", str);
        } else if (h.i(application)) {
            z = false;
            h.drc();
        } else {
            h.drh().m(675, 5, 1);
            h.hh(application);
            h.g("MicroMsg.SplashInit", "hack failed, do fallback logic.", new Object[0]);
        }
        xHB = z;
        if (h.xGI != null) {
            h.xGI.BP();
        }
        if (z) {
            if (a.hc(application)) {
                try {
                    a.he(application);
                    h.g("MicroMsg.SplashInit", "block checking dex opt result: %s", Boolean.valueOf(a.hg(application)));
                    if (!a.hg(application)) {
                        h.g("MicroMsg.SplashInit", "dexopt service return failed or timeout. kill self.", new Object[0]);
                        h.bZk();
                    }
                } catch (InterruptedException e) {
                    RuntimeException runtimeException = new RuntimeException(e);
                    AppMethodBeat.o(114889);
                    throw runtimeException;
                }
            }
            a.hd(application);
        }
        if (g.wY || z) {
            aoc(str2);
        }
        AppMethodBeat.o(114889);
    }

    private static void aoc(String str) {
        AppMethodBeat.i(114890);
        if (xHC != null) {
            AppMethodBeat.o(114890);
            return;
        }
        a aod = aod(str);
        aod.b(xGE, bWa);
        xHC = aod;
        AppMethodBeat.o(114890);
    }

    private static void drq() {
        AppMethodBeat.i(114891);
        if (xHD && xHE != null) {
            xHC.a(xHE);
        }
        AppMethodBeat.o(114891);
    }

    public static void drr() {
        AppMethodBeat.i(114892);
        h.g("MicroMsg.SplashInit", "applicationOnCreate", new Object[0]);
        h.dqY();
        xHD = true;
        if (xHB) {
            xHC.BQ();
            AppMethodBeat.o(114892);
            return;
        }
        drq();
        AppMethodBeat.o(114892);
    }

    private static a aod(String str) {
        AppMethodBeat.i(114893);
        try {
            a aVar = (a) Class.forName(str).newInstance();
            AppMethodBeat.o(114893);
            return aVar;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SplashInit", e, "%s has problem!", str);
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.o(114893);
            throw runtimeException;
        }
    }
}
