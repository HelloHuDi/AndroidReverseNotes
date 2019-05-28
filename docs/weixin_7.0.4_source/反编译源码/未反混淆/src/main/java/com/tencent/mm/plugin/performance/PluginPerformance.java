package com.tencent.mm.plugin.performance;

import android.app.ActivityManager;
import android.app.Application;
import android.content.IntentFilter;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ad;
import com.tencent.mm.plugin.expt.PluginExpt;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.performance.a.a;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.performance.elf.b;
import com.tencent.mm.plugin.report.PluginReport;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public class PluginPerformance extends f implements c, a {
    com.tencent.mm.plugin.performance.b.a peU;

    public void installed() {
        AppMethodBeat.i(111015);
        alias(a.class);
        AppMethodBeat.o(111015);
    }

    public void dependency() {
        AppMethodBeat.i(111016);
        dependsOn(PluginReport.class);
        dependsOn(p.class);
        dependsOn(PluginExpt.class);
        AppMethodBeat.o(111016);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(111018);
        if (ah.doE()) {
            b bVar = b.pfQ;
            try {
                bVar.nDl = b.aP(((float) ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_android_process_enable, 0)) / 10000.0f);
                b.pfL = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_android_process_check_time, 1200000);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ProcessElf", e, "", new Object[0]);
                b.pfL = 1200000;
                bVar.nDl = b.DEBUG;
            }
            ab.i("MicroMsg.ProcessElf", "[call] isEnable:%b CHECK_TIME:%s", Boolean.valueOf(bVar.nDl), Long.valueOf(b.bZm()));
            if (bVar.nDl) {
                b.pfh.removeCallbacks(b.pfS);
                b.pfh.postDelayed(b.pfS, b.bZm());
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("ACTION_ELF_CHECK_RESPONSE");
            intentFilter.addAction("com.tencent.mm.MMDensityManager");
            ah.getContext().registerReceiver(b.pfR, intentFilter);
        }
        gVar.cc.registerActivityLifecycleCallbacks(new com.tencent.mm.ac.a());
        if (ah.bqo()) {
            long j;
            a aVar = a.peX;
            Application application = gVar.cc;
            aVar.aFV = true;
            aVar.oAl.start();
            aVar.handler = new Handler(aVar.oAl.getLooper());
            application.registerActivityLifecycleCallbacks(aVar);
            com.tencent.mm.performance.a.a any = com.tencent.mm.performance.a.a.any();
            ActivityManager activityManager = (ActivityManager) ah.getContext().getSystemService("activity");
            any.ggb = activityManager.getMemoryClass();
            any.ggc = activityManager.getLargeMemoryClass();
            ((Application) ah.getContext()).registerActivityLifecycleCallbacks(any);
            e eVar = d.xDG;
            if (any.caA) {
                j = 300000;
            } else {
                j = 1800000;
            }
            eVar.p(any, j);
        }
        gVar.cc.registerActivityLifecycleCallbacks(new com.tencent.mm.plugin.performance.b.b());
        AppMethodBeat.o(111018);
    }

    public String toString() {
        return "plugin-performance";
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(111019);
        if (ah.bqo()) {
            com.tencent.mm.kernel.g.RS().m(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(111014);
                    ((MainProcessChecker) com.tencent.mm.plugin.performance.elf.a.as(MainProcessChecker.class)).start();
                    AppMethodBeat.o(111014);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.o(111019);
    }

    public void onAccountRelease() {
    }

    public void configure(g gVar) {
        AppMethodBeat.i(111017);
        com.tencent.mm.cf.c.ydB = new com.tencent.mm.cf.a() {
            public final boolean UC(String str) {
                AppMethodBeat.i(111039);
                boolean a = ad.a(str, r.Yz(), true, false);
                AppMethodBeat.o(111039);
                return a;
            }
        };
        com.tencent.mm.plugin.performance.b.a aVar = new com.tencent.mm.plugin.performance.b.a();
        this.peU = aVar;
        d.a(aVar);
        AppMethodBeat.o(111017);
    }
}
