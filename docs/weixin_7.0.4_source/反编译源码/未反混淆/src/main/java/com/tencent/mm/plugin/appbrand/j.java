package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.b;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.sdk.platformtools.ab;

final class j extends b {
    private final o gOq;
    volatile boolean gOr = false;
    private volatile e.b gOs;

    static class a implements com.tencent.mm.plugin.appbrand.task.e.a, com.tencent.mm.vending.e.a {
        private final e.b gOx;
        private o gOy;
        private b gOz;

        a(e.b bVar, o oVar, b bVar2) {
            AppMethodBeat.i(128956);
            this.gOx = bVar;
            this.gOy = oVar;
            this.gOz = bVar2;
            oVar.keep(this);
            AppMethodBeat.o(128956);
        }

        public final void onReady() {
            AppMethodBeat.i(128957);
            if (this.gOy == null || this.gOz == null) {
                AppMethodBeat.o(128957);
                return;
            }
            ab.i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", "tryPreloadBeforeResourceDone, READY!!! reason[%s], appId[%s]", this.gOx.name(), this.gOy.mAppId);
            this.gOz.wL();
            AppMethodBeat.o(128957);
        }

        public final void dead() {
            this.gOy = null;
            this.gOz = null;
        }
    }

    j(o oVar) {
        this.gOq = oVar;
    }

    public final void prepare() {
    }

    /* Access modifiers changed, original: final */
    public final void a(final e.b bVar) {
        AppMethodBeat.i(128958);
        if (this.gOr) {
            ab.i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", "tryPreloadBeforeResourceDone hasPreload=TRUE, preloadReasonBefore[%s], preloadReasonNow[%s]", this.gOs, bVar);
            AppMethodBeat.o(128958);
            return;
        }
        this.gOr = true;
        this.gOs = bVar;
        final o oVar = this.gOq;
        c cVar = oVar.gNE;
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                int i = 0;
                AppMethodBeat.i(128955);
                o oVar = oVar;
                b bVar = this;
                e.b bVar2 = bVar;
                if (!(oVar.mFinished || oVar.eMP || !e.aLQ())) {
                    g c = g.c(oVar.atI());
                    if (c == g.WASERVICE) {
                        ab.i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", "tryPreloadBeforeResourceDone, entered, reason[%s], appId[%s]", bVar2.name(), oVar.mAppId);
                        QualitySessionRuntime DG = com.tencent.mm.plugin.appbrand.report.quality.a.DG(oVar.mAppId);
                        if (DG != null) {
                            DG.iDj = true;
                        }
                        e.a(c, new a(bVar2, oVar, bVar), true, null);
                        i = 1;
                    }
                }
                if (i == 0) {
                    this.wL();
                }
                AppMethodBeat.o(128955);
            }
        };
        if (cVar.getAnimation() == null) {
            anonymousClass1.run();
            AppMethodBeat.o(128958);
            return;
        }
        cVar.iTV.add(anonymousClass1);
        AppMethodBeat.o(128958);
    }
}
