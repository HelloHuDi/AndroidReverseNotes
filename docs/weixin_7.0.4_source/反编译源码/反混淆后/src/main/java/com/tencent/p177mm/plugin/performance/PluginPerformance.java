package com.tencent.p177mm.plugin.performance;

import android.app.ActivityManager;
import android.app.Application;
import android.content.IntentFilter;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p179ac.C1185a;
import com.tencent.p177mm.p215cf.C45279c;
import com.tencent.p177mm.performance.p1466a.C32884a;
import com.tencent.p177mm.plugin.expt.PluginExpt;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.performance.C34672b.C346731;
import com.tencent.p177mm.plugin.performance.elf.C43368a;
import com.tencent.p177mm.plugin.performance.elf.C43369b;
import com.tencent.p177mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.p177mm.plugin.performance.p1010a.C12802a;
import com.tencent.p177mm.plugin.performance.p1011b.C34669a;
import com.tencent.p177mm.plugin.performance.p1011b.C34670b;
import com.tencent.p177mm.plugin.report.PluginReport;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.p604g.p605a.C4943e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.performance.PluginPerformance */
public class PluginPerformance extends C7597f implements C1671c, C12802a {
    C34669a peU;

    /* renamed from: com.tencent.mm.plugin.performance.PluginPerformance$1 */
    class C433671 implements Runnable {
        C433671() {
        }

        public final void run() {
            AppMethodBeat.m2504i(111014);
            ((MainProcessChecker) C43368a.m77392as(MainProcessChecker.class)).start();
            AppMethodBeat.m2505o(111014);
        }
    }

    public void installed() {
        AppMethodBeat.m2504i(111015);
        alias(C12802a.class);
        AppMethodBeat.m2505o(111015);
    }

    public void dependency() {
        AppMethodBeat.m2504i(111016);
        dependsOn(PluginReport.class);
        dependsOn(C6983p.class);
        dependsOn(PluginExpt.class);
        AppMethodBeat.m2505o(111016);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(111018);
        if (C4996ah.doE()) {
            C43369b c43369b = C43369b.pfQ;
            try {
                c43369b.nDl = C43369b.m77393aP(((float) ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_android_process_enable, 0)) / 10000.0f);
                C43369b.pfL = ((C34069a) C1720g.m3528K(C34069a.class)).mo54612a(C11745a.clicfg_android_process_check_time, 1200000);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ProcessElf", e, "", new Object[0]);
                C43369b.pfL = 1200000;
                c43369b.nDl = C43369b.DEBUG;
            }
            C4990ab.m7417i("MicroMsg.ProcessElf", "[call] isEnable:%b CHECK_TIME:%s", Boolean.valueOf(c43369b.nDl), Long.valueOf(C43369b.bZm()));
            if (c43369b.nDl) {
                C43369b.pfh.removeCallbacks(C43369b.pfS);
                C43369b.pfh.postDelayed(C43369b.pfS, C43369b.bZm());
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("ACTION_ELF_CHECK_RESPONSE");
            intentFilter.addAction("com.tencent.mm.MMDensityManager");
            C4996ah.getContext().registerReceiver(C43369b.pfR, intentFilter);
        }
        c1681g.f1233cc.registerActivityLifecycleCallbacks(new C1185a());
        if (C4996ah.bqo()) {
            long j;
            C34666a c34666a = C34666a.peX;
            Application application = c1681g.f1233cc;
            c34666a.aFV = true;
            c34666a.oAl.start();
            c34666a.handler = new Handler(c34666a.oAl.getLooper());
            application.registerActivityLifecycleCallbacks(c34666a);
            C32884a any = C32884a.any();
            ActivityManager activityManager = (ActivityManager) C4996ah.getContext().getSystemService("activity");
            any.ggb = activityManager.getMemoryClass();
            any.ggc = activityManager.getLargeMemoryClass();
            ((Application) C4996ah.getContext()).registerActivityLifecycleCallbacks(any);
            C4943e c4943e = C7305d.xDG;
            if (any.caA) {
                j = 300000;
            } else {
                j = 1800000;
            }
            c4943e.mo10159p(any, j);
        }
        c1681g.f1233cc.registerActivityLifecycleCallbacks(new C34670b());
        AppMethodBeat.m2505o(111018);
    }

    public String toString() {
        return "plugin-performance";
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(111019);
        if (C4996ah.bqo()) {
            C1720g.m3539RS().mo10310m(new C433671(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.m2505o(111019);
    }

    public void onAccountRelease() {
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(111017);
        C45279c.ydB = new C346731();
        C34669a c34669a = new C34669a();
        this.peU = c34669a;
        C7305d.m12287a(c34669a);
        AppMethodBeat.m2505o(111017);
    }
}
