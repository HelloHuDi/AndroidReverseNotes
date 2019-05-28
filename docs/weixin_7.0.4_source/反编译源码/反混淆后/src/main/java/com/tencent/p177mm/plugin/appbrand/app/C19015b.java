package com.tencent.p177mm.plugin.appbrand.app;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.p177mm.plugin.appbrand.task.C27310e;
import com.tencent.p177mm.plugin.appbrand.task.C38519g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.appbrand.app.b */
public final class C19015b {
    private static volatile boolean gQN = false;
    private static volatile boolean gQO = false;

    /* renamed from: a */
    public static void m29592a(final C38519g c38519g, AppBrandPreloadProfiler appBrandPreloadProfiler) {
        AppMethodBeat.m2504i(129194);
        gQO = true;
        if (c38519g == null || c38519g == C38519g.NIL) {
            C4990ab.m7416i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "dl: AppBrandProcessPreloader said I can not preload [nil] type.");
            AppMethodBeat.m2505o(129194);
            return;
        }
        if (appBrandPreloadProfiler == null) {
            appBrandPreloadProfiler = new AppBrandPreloadProfiler();
        }
        appBrandPreloadProfiler.iEi = SystemClock.elapsedRealtime();
        C5004al.m7441d(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.appbrand.app.b$1$1 */
            class C190171 implements IdleHandler {
                C190171() {
                }

                public final boolean queueIdle() {
                    AppMethodBeat.m2504i(129192);
                    C19015b.gQO = true;
                    Looper.myQueue().removeIdleHandler(this);
                    if (!C19015b.gQN) {
                        try {
                            C4990ab.m7417i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "start misc preload [%s]", c38519g);
                            AppBrandMainProcessService.aBM();
                            C27310e.m43373a(c38519g, null, false, appBrandPreloadProfiler);
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.AppBrandProcessProfileInit[applaunch]", e, "Preload [%s] in IdleHandler encountered Exception", c38519g.name());
                        }
                    }
                    AppMethodBeat.m2505o(129192);
                    return false;
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(129193);
                Looper.myQueue().addIdleHandler(new C190171());
                AppMethodBeat.m2505o(129193);
            }
        });
        AppMethodBeat.m2505o(129194);
    }

    public static boolean auE() {
        return gQO;
    }

    public static void auF() {
        AppMethodBeat.m2504i(129195);
        C4990ab.m7417i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "setSkipMiscPreload %b", Boolean.TRUE);
        gQN = true;
        AppMethodBeat.m2505o(129195);
    }
}
