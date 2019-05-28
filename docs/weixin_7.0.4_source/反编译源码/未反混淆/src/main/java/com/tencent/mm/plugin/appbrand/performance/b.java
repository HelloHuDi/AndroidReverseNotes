package com.tencent.mm.plugin.appbrand.performance;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class b extends AppBrandPerformanceManager {

    static class a extends a {
        a(o oVar) {
            super(oVar);
            AppMethodBeat.i(132492);
            this.ivG = oVar.xy();
            AppMethodBeat.o(132492);
        }

        /* Access modifiers changed, original: protected|final */
        public final void aKk() {
            AppMethodBeat.i(132493);
            super.aKk();
            if (this.ivG) {
                i iVar = i.iCT;
                com.tencent.mm.plugin.appbrand.report.quality.i.a aLB = i.aLB();
                c.a(this.mAppId, "Hardware", "NATIVE_MEMORY", (double) aLB.iCW);
                c.a(this.mAppId, "Hardware", "DALVIK_MEMORY", (double) aLB.iCX);
            }
            AppMethodBeat.o(132493);
        }

        /* Access modifiers changed, original: protected|final */
        public final void aKl() {
            AppMethodBeat.i(132494);
            if (!this.ivG) {
                AppMethodBeat.o(132494);
            } else if (this.ivC.mFinished) {
                AppMethodBeat.o(132494);
            } else {
                QualitySessionRuntime DG = com.tencent.mm.plugin.appbrand.report.quality.a.DG(this.mAppId);
                int gX = DG != null ? bo.gX(ah.getContext()) - DG.iDf : BaseClientBuilder.API_PRIORITY_OTHER;
                if (gX != BaseClientBuilder.API_PRIORITY_OTHER) {
                    AppBrandPerformanceManager.a(this.ivC, 103, gX + "m");
                }
                AppMethodBeat.o(132494);
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void aKm() {
            AppMethodBeat.i(132495);
            if (this.ivG) {
                com.tencent.magicbrush.a.a aKq = aKq();
                if (aKq == null) {
                    AppMethodBeat.o(132495);
                    return;
                }
                c.a(this.mAppId, "Game", "FPS_GAME_RT", (double) aKq.bSi);
                c.a(this.mAppId, "Game", "FPS_GAME_EX", (double) aKq.bSj);
                AppMethodBeat.o(132495);
                return;
            }
            AppMethodBeat.o(132495);
        }

        private com.tencent.magicbrush.a.a aKq() {
            com.tencent.magicbrush.a.a currentFps;
            AppMethodBeat.i(132496);
            try {
                currentFps = ((com.tencent.mm.plugin.appbrand.game.b) com.tencent.mm.plugin.appbrand.a.wI(this.mAppId).atK()).getMBRuntime().getCurrentFps();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", e, "get QualityEvent of WAGame but fail.", new Object[0]);
                currentFps = null;
            }
            AppMethodBeat.o(132496);
            return currentFps;
        }

        /* Access modifiers changed, original: protected|final */
        public final void aKn() {
            AppMethodBeat.i(132497);
            if (this.ivG) {
                try {
                    c.a(this.mAppId, "Game", "DRAW_CALLS", (double) ((com.tencent.mm.plugin.appbrand.game.b) com.tencent.mm.plugin.appbrand.a.wI(this.mAppId).atK()).getMBRuntime().getInspector().yu());
                    AppMethodBeat.o(132497);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", e, "get QualityEvent of WAGame but fail.", new Object[0]);
                    AppMethodBeat.o(132497);
                    return;
                }
            }
            AppMethodBeat.o(132497);
        }

        /* Access modifiers changed, original: protected|final */
        public final void aKo() {
            AppMethodBeat.i(132498);
            if (this.ivG) {
                try {
                    c.a(this.mAppId, "Game", "VERTEXES", (double) ((com.tencent.mm.plugin.appbrand.game.b) com.tencent.mm.plugin.appbrand.a.wI(this.mAppId).atK()).getMBRuntime().getInspector().yv());
                    AppMethodBeat.o(132498);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", e, "get QualityEvent of WAGame but fail.", new Object[0]);
                    AppMethodBeat.o(132498);
                    return;
                }
            }
            AppMethodBeat.o(132498);
        }

        /* Access modifiers changed, original: protected|final */
        public final void aKp() {
            AppMethodBeat.i(132499);
            if (this.ivG) {
                try {
                    c.a(this.mAppId, "Game", "TRIANGLES", (double) ((com.tencent.mm.plugin.appbrand.game.b) com.tencent.mm.plugin.appbrand.a.wI(this.mAppId).atK()).getMBRuntime().getInspector().yw());
                    AppMethodBeat.o(132499);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrandPerformanceManagerWC", e, "get QualityEvent of WAGame but fail.", new Object[0]);
                    AppMethodBeat.o(132499);
                    return;
                }
            }
            AppMethodBeat.o(132499);
        }
    }

    public static void n(o oVar) {
        AppMethodBeat.i(132500);
        String str = oVar.mAppId;
        ab.d("MicroMsg.AppBrandPerformanceManagerWC", "startMonitoring, appId: %s", str);
        a aVar = (a) ivB.get(str.hashCode());
        if (!(aVar instanceof a)) {
            if (aVar != null) {
                aVar.stop();
            }
            aVar = new a(oVar);
            ivB.put(str.hashCode(), aVar);
        }
        aVar.start();
        AppMethodBeat.o(132500);
    }
}
