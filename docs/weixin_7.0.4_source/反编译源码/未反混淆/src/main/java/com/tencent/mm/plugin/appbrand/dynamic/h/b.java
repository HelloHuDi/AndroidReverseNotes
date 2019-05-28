package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

public final class b {
    private static final ap hoF = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(10945);
            BaseIPCService lj = h.PO().lj("com.tencent.mm:support");
            if (lj != null) {
                lj.ci(false);
            }
            AppMethodBeat.o(10945);
            return false;
        }
    }, true);

    static {
        AppMethodBeat.i(10953);
        AppMethodBeat.o(10953);
    }

    public static void aAc() {
        AppMethodBeat.i(10950);
        if (e.lg("com.tencent.mm:support")) {
            if (com.tencent.mm.ipcinvoker.wx_extension.b.b.a.eGP.size() != 0) {
                ab.i("MicroMsg.DynamicProcessPerformance", "try to exit process, but has many tasks(%d) running. Abort it.", Integer.valueOf(com.tencent.mm.ipcinvoker.wx_extension.b.b.a.eGP.size()));
                AppMethodBeat.o(10950);
                return;
            }
            ab.i("MicroMsg.DynamicProcessPerformance", "post delayed(60s) to kill the support process.");
            hoF.ae(60000, 60000);
            AppMethodBeat.o(10950);
            return;
        }
        ab.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
        AppMethodBeat.o(10950);
    }

    public static void aAd() {
        AppMethodBeat.i(10951);
        if (e.lg("com.tencent.mm:support")) {
            ab.i("MicroMsg.DynamicProcessPerformance", "kill support process");
            hoF.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10946);
                    Process.killProcess(Process.myPid());
                    AppMethodBeat.o(10946);
                }
            }, 500);
            AppMethodBeat.o(10951);
            return;
        }
        ab.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
        AppMethodBeat.o(10951);
    }

    public static void aAe() {
        AppMethodBeat.i(10952);
        ab.i("MicroMsg.DynamicProcessPerformance", "killAllProcess");
        if (com.tencent.mm.ipcinvoker.b.PL().le("com.tencent.mm:tools")) {
            f.a("com.tencent.mm:tools", null, c.class, new c<Bundle>() {
                public final /* synthetic */ void ao(Object obj) {
                    AppMethodBeat.i(10947);
                    ab.i("MicroMsg.DynamicProcessPerformance", "on kill process tools callback");
                    g.li("com.tencent.mm:tools");
                    AppMethodBeat.o(10947);
                }
            });
        }
        if (com.tencent.mm.ipcinvoker.b.PL().le("com.tencent.mm:toolsmp")) {
            f.a("com.tencent.mm:toolsmp", null, c.class, new c<Bundle>() {
                public final /* synthetic */ void ao(Object obj) {
                    AppMethodBeat.i(10948);
                    ab.i("MicroMsg.DynamicProcessPerformance", "on kill process tools mp callback");
                    g.li("com.tencent.mm:toolsmp");
                    AppMethodBeat.o(10948);
                }
            });
        }
        if (com.tencent.mm.ipcinvoker.b.PL().le("com.tencent.mm:support")) {
            f.a("com.tencent.mm:support", null, c.class, new c<Bundle>() {
                public final /* synthetic */ void ao(Object obj) {
                    AppMethodBeat.i(10949);
                    ab.i("MicroMsg.DynamicProcessPerformance", "on kill process support callback");
                    g.li("com.tencent.mm:support");
                    AppMethodBeat.o(10949);
                }
            });
        }
        AppMethodBeat.o(10952);
    }
}
