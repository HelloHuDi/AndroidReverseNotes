package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.version.C42591a;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandPrepareTask.C2367b;
import com.tencent.p177mm.vending.p639e.C5684a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J+\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00018\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u0012\u0010\u001c\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u001dH\u0016J\u0017\u0010\u001e\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0 H\bR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/launching/LaunchPrepareCallbackWrapper;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "referenced", "(Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;)V", "mDead", "", "mReferenced", "dead", "", "onDataTransferState", "state", "", "onDownloadProcess", "progress", "onDownloadStarted", "startTime", "", "onPrepareDone", "config", "errorAction", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;", "startupPerformanceReport", "Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;", "(Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;)V", "onSyncLaunchStart", "onVersionUpdateEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "tryOrThrows", "block", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.launching.x */
public final class C10605x<C extends AppBrandSysConfigLU> implements C2367b<C>, C5684a {
    private volatile boolean gOp;
    private volatile C2367b<C> ihJ;

    public C10605x(C2367b<C> c2367b) {
        C25052j.m39376p(c2367b, "referenced");
        AppMethodBeat.m2504i(134717);
        this.ihJ = c2367b;
        AppMethodBeat.m2505o(134717);
    }

    /* renamed from: nm */
    public final void mo6247nm(int i) {
        AppMethodBeat.m2504i(134711);
        try {
            C2367b c2367b = this.ihJ;
            if (c2367b != null) {
                c2367b.mo6247nm(i);
                AppMethodBeat.m2505o(134711);
                return;
            }
            AppMethodBeat.m2505o(134711);
        } catch (Throwable th) {
            if (this.gOp) {
                C45124d.m82933w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + th + " when dead");
                AppMethodBeat.m2505o(134711);
                return;
            }
            AppMethodBeat.m2505o(134711);
        }
    }

    /* renamed from: a */
    public final void mo6256a(C c, AppBrandLaunchErrorAction appBrandLaunchErrorAction, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle) {
        AppMethodBeat.m2504i(134712);
        try {
            C2367b c2367b = this.ihJ;
            if (c2367b != null) {
                c2367b.mo6256a(c, appBrandLaunchErrorAction, appStartupPerformanceReportBundle);
                AppMethodBeat.m2505o(134712);
                return;
            }
            AppMethodBeat.m2505o(134712);
        } catch (Throwable th) {
            if (this.gOp) {
                C45124d.m82933w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + th + " when dead");
                AppMethodBeat.m2505o(134712);
                return;
            }
            AppMethodBeat.m2505o(134712);
        }
    }

    /* renamed from: gf */
    public final void mo6259gf(long j) {
        AppMethodBeat.m2504i(134713);
        try {
            C2367b c2367b = this.ihJ;
            if (c2367b != null) {
                c2367b.mo6259gf(j);
                AppMethodBeat.m2505o(134713);
                return;
            }
            AppMethodBeat.m2505o(134713);
        } catch (Throwable th) {
            if (this.gOp) {
                C45124d.m82933w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + th + " when dead");
                AppMethodBeat.m2505o(134713);
                return;
            }
            AppMethodBeat.m2505o(134713);
        }
    }

    /* renamed from: nn */
    public final void mo6260nn(int i) {
        AppMethodBeat.m2504i(134714);
        try {
            C2367b c2367b = this.ihJ;
            if (c2367b != null) {
                c2367b.mo6260nn(i);
                AppMethodBeat.m2505o(134714);
                return;
            }
            AppMethodBeat.m2505o(134714);
        } catch (Throwable th) {
            if (this.gOp) {
                C45124d.m82933w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + th + " when dead");
                AppMethodBeat.m2505o(134714);
                return;
            }
            AppMethodBeat.m2505o(134714);
        }
    }

    /* renamed from: a */
    public final void mo6257a(C42591a c42591a) {
        AppMethodBeat.m2504i(134715);
        try {
            C2367b c2367b = this.ihJ;
            if (c2367b != null) {
                c2367b.mo6257a(c42591a);
                AppMethodBeat.m2505o(134715);
                return;
            }
            AppMethodBeat.m2505o(134715);
        } catch (Throwable th) {
            if (this.gOp) {
                C45124d.m82933w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + th + " when dead");
                AppMethodBeat.m2505o(134715);
                return;
            }
            AppMethodBeat.m2505o(134715);
        }
    }

    public final void atT() {
        AppMethodBeat.m2504i(134716);
        try {
            C2367b c2367b = this.ihJ;
            if (c2367b != null) {
                c2367b.atT();
                AppMethodBeat.m2505o(134716);
                return;
            }
            AppMethodBeat.m2505o(134716);
        } catch (Throwable th) {
            if (this.gOp) {
                C45124d.m82933w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + th + " when dead");
                AppMethodBeat.m2505o(134716);
                return;
            }
            AppMethodBeat.m2505o(134716);
        }
    }

    public final void dead() {
        this.ihJ = null;
        this.gOp = true;
    }
}
