package com.tencent.p177mm.plugin.appbrand.performance;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.magicbrush.C1000a.C1001a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.game.C42439b;
import com.tencent.p177mm.plugin.appbrand.performance.AppBrandPerformanceManager.C27255a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C19704i;
import com.tencent.p177mm.plugin.appbrand.report.quality.C19704i.C19705a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C27285a;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.performance.b */
public final class C33486b extends AppBrandPerformanceManager {

    /* renamed from: com.tencent.mm.plugin.appbrand.performance.b$a */
    static class C33485a extends C27255a {
        C33485a(C41243o c41243o) {
            super(c41243o);
            AppMethodBeat.m2504i(132492);
            this.ivG = c41243o.mo65903xy();
            AppMethodBeat.m2505o(132492);
        }

        /* Access modifiers changed, original: protected|final */
        public final void aKk() {
            AppMethodBeat.m2504i(132493);
            super.aKk();
            if (this.ivG) {
                C19704i c19704i = C19704i.iCT;
                C19705a aLB = C19704i.aLB();
                C33487c.m54689a(this.mAppId, "Hardware", "NATIVE_MEMORY", (double) aLB.iCW);
                C33487c.m54689a(this.mAppId, "Hardware", "DALVIK_MEMORY", (double) aLB.iCX);
            }
            AppMethodBeat.m2505o(132493);
        }

        /* Access modifiers changed, original: protected|final */
        public final void aKl() {
            AppMethodBeat.m2504i(132494);
            if (!this.ivG) {
                AppMethodBeat.m2505o(132494);
            } else if (this.ivC.mFinished) {
                AppMethodBeat.m2505o(132494);
            } else {
                QualitySessionRuntime DG = C27285a.m43319DG(this.mAppId);
                int gX = DG != null ? C5046bo.m7564gX(C4996ah.getContext()) - DG.iDf : BaseClientBuilder.API_PRIORITY_OTHER;
                if (gX != BaseClientBuilder.API_PRIORITY_OTHER) {
                    AppBrandPerformanceManager.m43288a(this.ivC, 103, gX + "m");
                }
                AppMethodBeat.m2505o(132494);
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void aKm() {
            AppMethodBeat.m2504i(132495);
            if (this.ivG) {
                C1001a aKq = aKq();
                if (aKq == null) {
                    AppMethodBeat.m2505o(132495);
                    return;
                }
                C33487c.m54689a(this.mAppId, "Game", "FPS_GAME_RT", (double) aKq.bSi);
                C33487c.m54689a(this.mAppId, "Game", "FPS_GAME_EX", (double) aKq.bSj);
                AppMethodBeat.m2505o(132495);
                return;
            }
            AppMethodBeat.m2505o(132495);
        }

        private C1001a aKq() {
            C1001a currentFps;
            AppMethodBeat.m2504i(132496);
            try {
                currentFps = ((C42439b) C10048a.m17635wI(this.mAppId).atK()).getMBRuntime().getCurrentFps();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", e, "get QualityEvent of WAGame but fail.", new Object[0]);
                currentFps = null;
            }
            AppMethodBeat.m2505o(132496);
            return currentFps;
        }

        /* Access modifiers changed, original: protected|final */
        public final void aKn() {
            AppMethodBeat.m2504i(132497);
            if (this.ivG) {
                try {
                    C33487c.m54689a(this.mAppId, "Game", "DRAW_CALLS", (double) ((C42439b) C10048a.m17635wI(this.mAppId).atK()).getMBRuntime().getInspector().mo3985yu());
                    AppMethodBeat.m2505o(132497);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", e, "get QualityEvent of WAGame but fail.", new Object[0]);
                    AppMethodBeat.m2505o(132497);
                    return;
                }
            }
            AppMethodBeat.m2505o(132497);
        }

        /* Access modifiers changed, original: protected|final */
        public final void aKo() {
            AppMethodBeat.m2504i(132498);
            if (this.ivG) {
                try {
                    C33487c.m54689a(this.mAppId, "Game", "VERTEXES", (double) ((C42439b) C10048a.m17635wI(this.mAppId).atK()).getMBRuntime().getInspector().mo3986yv());
                    AppMethodBeat.m2505o(132498);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", e, "get QualityEvent of WAGame but fail.", new Object[0]);
                    AppMethodBeat.m2505o(132498);
                    return;
                }
            }
            AppMethodBeat.m2505o(132498);
        }

        /* Access modifiers changed, original: protected|final */
        public final void aKp() {
            AppMethodBeat.m2504i(132499);
            if (this.ivG) {
                try {
                    C33487c.m54689a(this.mAppId, "Game", "TRIANGLES", (double) ((C42439b) C10048a.m17635wI(this.mAppId).atK()).getMBRuntime().getInspector().mo3987yw());
                    AppMethodBeat.m2505o(132499);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", e, "get QualityEvent of WAGame but fail.", new Object[0]);
                    AppMethodBeat.m2505o(132499);
                    return;
                }
            }
            AppMethodBeat.m2505o(132499);
        }
    }

    /* renamed from: n */
    public static void m54686n(C41243o c41243o) {
        AppMethodBeat.m2504i(132500);
        String str = c41243o.mAppId;
        C4990ab.m7411d("MicroMsg.AppBrandPerformanceManagerWC", "startMonitoring, appId: %s", str);
        C27255a c27255a = (C27255a) ivB.get(str.hashCode());
        if (!(c27255a instanceof C33485a)) {
            if (c27255a != null) {
                c27255a.stop();
            }
            c27255a = new C33485a(c41243o);
            ivB.put(str.hashCode(), c27255a);
        }
        c27255a.start();
        AppMethodBeat.m2505o(132500);
    }
}
