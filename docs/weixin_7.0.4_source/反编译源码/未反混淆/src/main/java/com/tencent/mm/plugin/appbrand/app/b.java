package com.tencent.mm.plugin.appbrand.app;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class b {
    private static volatile boolean gQN = false;
    private static volatile boolean gQO = false;

    public static void a(final g gVar, AppBrandPreloadProfiler appBrandPreloadProfiler) {
        AppMethodBeat.i(129194);
        gQO = true;
        if (gVar == null || gVar == g.NIL) {
            ab.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "dl: AppBrandProcessPreloader said I can not preload [nil] type.");
            AppMethodBeat.o(129194);
            return;
        }
        if (appBrandPreloadProfiler == null) {
            appBrandPreloadProfiler = new AppBrandPreloadProfiler();
        }
        appBrandPreloadProfiler.iEi = SystemClock.elapsedRealtime();
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(129193);
                Looper.myQueue().addIdleHandler(new IdleHandler() {
                    public final boolean queueIdle() {
                        AppMethodBeat.i(129192);
                        b.gQO = true;
                        Looper.myQueue().removeIdleHandler(this);
                        if (!b.gQN) {
                            try {
                                ab.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "start misc preload [%s]", gVar);
                                AppBrandMainProcessService.aBM();
                                e.a(gVar, null, false, appBrandPreloadProfiler);
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.AppBrandProcessProfileInit[applaunch]", e, "Preload [%s] in IdleHandler encountered Exception", gVar.name());
                            }
                        }
                        AppMethodBeat.o(129192);
                        return false;
                    }
                });
                AppMethodBeat.o(129193);
            }
        });
        AppMethodBeat.o(129194);
    }

    public static boolean auE() {
        return gQO;
    }

    public static void auF() {
        AppMethodBeat.i(129195);
        ab.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "setSkipMiscPreload %b", Boolean.TRUE);
        gQN = true;
        AppMethodBeat.o(129195);
    }
}
