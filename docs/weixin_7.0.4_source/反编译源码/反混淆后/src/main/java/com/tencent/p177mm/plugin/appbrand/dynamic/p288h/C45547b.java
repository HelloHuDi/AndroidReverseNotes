package com.tencent.p177mm.plugin.appbrand.dynamic.p288h;

import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.BaseIPCService;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C32710b;
import com.tencent.p177mm.ipcinvoker.C37871h;
import com.tencent.p177mm.ipcinvoker.C45412g;
import com.tencent.p177mm.ipcinvoker.C9548e;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.wx_extension.p856b.C32720b.C9558a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.h.b */
public final class C45547b {
    private static final C7564ap hoF = new C7564ap(new C331601(), true);

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.h.b$5 */
    static class C21495 implements C18507c<Bundle> {
        C21495() {
        }

        /* renamed from: ao */
        public final /* synthetic */ void mo5960ao(Object obj) {
            AppMethodBeat.m2504i(10949);
            C4990ab.m7416i("MicroMsg.DynamicProcessPerformance", "on kill process support callback");
            C45412g.m83633li("com.tencent.mm:support");
            AppMethodBeat.m2505o(10949);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.h.b$3 */
    static class C102163 implements C18507c<Bundle> {
        C102163() {
        }

        /* renamed from: ao */
        public final /* synthetic */ void mo5960ao(Object obj) {
            AppMethodBeat.m2504i(10947);
            C4990ab.m7416i("MicroMsg.DynamicProcessPerformance", "on kill process tools callback");
            C45412g.m83633li("com.tencent.mm:tools");
            AppMethodBeat.m2505o(10947);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.h.b$4 */
    static class C102174 implements C18507c<Bundle> {
        C102174() {
        }

        /* renamed from: ao */
        public final /* synthetic */ void mo5960ao(Object obj) {
            AppMethodBeat.m2504i(10948);
            C4990ab.m7416i("MicroMsg.DynamicProcessPerformance", "on kill process tools mp callback");
            C45412g.m83633li("com.tencent.mm:toolsmp");
            AppMethodBeat.m2505o(10948);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.h.b$1 */
    static class C331601 implements C5015a {
        C331601() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(10945);
            BaseIPCService lj = C37871h.m63909PO().mo60593lj("com.tencent.mm:support");
            if (lj != null) {
                lj.mo33740ci(false);
            }
            AppMethodBeat.m2505o(10945);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.h.b$2 */
    static class C331612 implements Runnable {
        C331612() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10946);
            Process.killProcess(Process.myPid());
            AppMethodBeat.m2505o(10946);
        }
    }

    static {
        AppMethodBeat.m2504i(10953);
        AppMethodBeat.m2505o(10953);
    }

    public static void aAc() {
        AppMethodBeat.m2504i(10950);
        if (C9548e.m17008lg("com.tencent.mm:support")) {
            if (C9558a.eGP.size() != 0) {
                C4990ab.m7417i("MicroMsg.DynamicProcessPerformance", "try to exit process, but has many tasks(%d) running. Abort it.", Integer.valueOf(C9558a.eGP.size()));
                AppMethodBeat.m2505o(10950);
                return;
            }
            C4990ab.m7416i("MicroMsg.DynamicProcessPerformance", "post delayed(60s) to kill the support process.");
            hoF.mo16770ae(60000, 60000);
            AppMethodBeat.m2505o(10950);
            return;
        }
        C4990ab.m7416i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
        AppMethodBeat.m2505o(10950);
    }

    public static void aAd() {
        AppMethodBeat.m2504i(10951);
        if (C9548e.m17008lg("com.tencent.mm:support")) {
            C4990ab.m7416i("MicroMsg.DynamicProcessPerformance", "kill support process");
            hoF.postDelayed(new C331612(), 500);
            AppMethodBeat.m2505o(10951);
            return;
        }
        C4990ab.m7416i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
        AppMethodBeat.m2505o(10951);
    }

    public static void aAe() {
        AppMethodBeat.m2504i(10952);
        C4990ab.m7416i("MicroMsg.DynamicProcessPerformance", "killAllProcess");
        if (C32710b.m53380PL().mo53222le("com.tencent.mm:tools")) {
            C9549f.m17012a("com.tencent.mm:tools", null, C41228c.class, new C102163());
        }
        if (C32710b.m53380PL().mo53222le("com.tencent.mm:toolsmp")) {
            C9549f.m17012a("com.tencent.mm:toolsmp", null, C41228c.class, new C102174());
        }
        if (C32710b.m53380PL().mo53222le("com.tencent.mm:support")) {
            C9549f.m17012a("com.tencent.mm:support", null, C41228c.class, new C21495());
        }
        AppMethodBeat.m2505o(10952);
    }
}
