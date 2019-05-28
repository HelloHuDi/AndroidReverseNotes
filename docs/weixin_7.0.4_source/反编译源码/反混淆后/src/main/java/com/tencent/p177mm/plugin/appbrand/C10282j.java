package com.tencent.p177mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i.C6764b;
import com.tencent.p177mm.plugin.appbrand.report.quality.C27285a;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.p177mm.plugin.appbrand.task.C27310e;
import com.tencent.p177mm.plugin.appbrand.task.C27310e.C27314a;
import com.tencent.p177mm.plugin.appbrand.task.C27310e.C27317b;
import com.tencent.p177mm.plugin.appbrand.task.C38519g;
import com.tencent.p177mm.plugin.appbrand.widget.C45713c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p639e.C5684a;

/* renamed from: com.tencent.mm.plugin.appbrand.j */
final class C10282j extends C6764b {
    private final C41243o gOq;
    volatile boolean gOr = false;
    private volatile C27317b gOs;

    /* renamed from: com.tencent.mm.plugin.appbrand.j$a */
    static class C10277a implements C27314a, C5684a {
        private final C27317b gOx;
        private C41243o gOy;
        private C6764b gOz;

        C10277a(C27317b c27317b, C41243o c41243o, C6764b c6764b) {
            AppMethodBeat.m2504i(128956);
            this.gOx = c27317b;
            this.gOy = c41243o;
            this.gOz = c6764b;
            c41243o.keep(this);
            AppMethodBeat.m2505o(128956);
        }

        public final void onReady() {
            AppMethodBeat.m2504i(128957);
            if (this.gOy == null || this.gOz == null) {
                AppMethodBeat.m2505o(128957);
                return;
            }
            C4990ab.m7417i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", "tryPreloadBeforeResourceDone, READY!!! reason[%s], appId[%s]", this.gOx.name(), this.gOy.mAppId);
            this.gOz.mo15047wL();
            AppMethodBeat.m2505o(128957);
        }

        public final void dead() {
            this.gOy = null;
            this.gOz = null;
        }
    }

    C10282j(C41243o c41243o) {
        this.gOq = c41243o;
    }

    public final void prepare() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo21729a(final C27317b c27317b) {
        AppMethodBeat.m2504i(128958);
        if (this.gOr) {
            C4990ab.m7417i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", "tryPreloadBeforeResourceDone hasPreload=TRUE, preloadReasonBefore[%s], preloadReasonNow[%s]", this.gOs, c27317b);
            AppMethodBeat.m2505o(128958);
            return;
        }
        this.gOr = true;
        this.gOs = c27317b;
        final C41243o c41243o = this.gOq;
        C45713c c45713c = c41243o.gNE;
        C102831 c102831 = new Runnable() {
            public final void run() {
                int i = 0;
                AppMethodBeat.m2504i(128955);
                C41243o c41243o = c41243o;
                C6764b c6764b = this;
                C27317b c27317b = c27317b;
                if (!(c41243o.mFinished || c41243o.eMP || !C27310e.aLQ())) {
                    C38519g c = C38519g.m65221c(c41243o.atI());
                    if (c == C38519g.WASERVICE) {
                        C4990ab.m7417i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", "tryPreloadBeforeResourceDone, entered, reason[%s], appId[%s]", c27317b.name(), c41243o.mAppId);
                        QualitySessionRuntime DG = C27285a.m43319DG(c41243o.mAppId);
                        if (DG != null) {
                            DG.iDj = true;
                        }
                        C27310e.m43373a(c, new C10277a(c27317b, c41243o, c6764b), true, null);
                        i = 1;
                    }
                }
                if (i == 0) {
                    this.mo15047wL();
                }
                AppMethodBeat.m2505o(128955);
            }
        };
        if (c45713c.getAnimation() == null) {
            c102831.run();
            AppMethodBeat.m2505o(128958);
            return;
        }
        c45713c.iTV.add(c102831);
        AppMethodBeat.m2505o(128958);
    }
}
