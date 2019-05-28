package com.tencent.mm.plugin.appbrand.launching;

import a.f.b.j;
import a.l;
import com.tencent.luggage.g.d;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b;
import com.tencent.mm.vending.e.a;

@l(dWo = {1, 1, 13}, dWp = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J+\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00018\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u0012\u0010\u001c\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u001dH\u0016J\u0017\u0010\u001e\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0 H\bR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/launching/LaunchPrepareCallbackWrapper;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "referenced", "(Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;)V", "mDead", "", "mReferenced", "dead", "", "onDataTransferState", "state", "", "onDownloadProcess", "progress", "onDownloadStarted", "startTime", "", "onPrepareDone", "config", "errorAction", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;", "startupPerformanceReport", "Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;", "(Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;)V", "onSyncLaunchStart", "onVersionUpdateEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "tryOrThrows", "block", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class x<C extends AppBrandSysConfigLU> implements b<C>, a {
    private volatile boolean gOp;
    private volatile b<C> ihJ;

    public x(b<C> bVar) {
        j.p(bVar, "referenced");
        AppMethodBeat.i(134717);
        this.ihJ = bVar;
        AppMethodBeat.o(134717);
    }

    public final void nm(int i) {
        AppMethodBeat.i(134711);
        try {
            b bVar = this.ihJ;
            if (bVar != null) {
                bVar.nm(i);
                AppMethodBeat.o(134711);
                return;
            }
            AppMethodBeat.o(134711);
        } catch (Throwable th) {
            if (this.gOp) {
                d.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + th + " when dead");
                AppMethodBeat.o(134711);
                return;
            }
            AppMethodBeat.o(134711);
        }
    }

    public final void a(C c, AppBrandLaunchErrorAction appBrandLaunchErrorAction, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle) {
        AppMethodBeat.i(134712);
        try {
            b bVar = this.ihJ;
            if (bVar != null) {
                bVar.a(c, appBrandLaunchErrorAction, appStartupPerformanceReportBundle);
                AppMethodBeat.o(134712);
                return;
            }
            AppMethodBeat.o(134712);
        } catch (Throwable th) {
            if (this.gOp) {
                d.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + th + " when dead");
                AppMethodBeat.o(134712);
                return;
            }
            AppMethodBeat.o(134712);
        }
    }

    public final void gf(long j) {
        AppMethodBeat.i(134713);
        try {
            b bVar = this.ihJ;
            if (bVar != null) {
                bVar.gf(j);
                AppMethodBeat.o(134713);
                return;
            }
            AppMethodBeat.o(134713);
        } catch (Throwable th) {
            if (this.gOp) {
                d.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + th + " when dead");
                AppMethodBeat.o(134713);
                return;
            }
            AppMethodBeat.o(134713);
        }
    }

    public final void nn(int i) {
        AppMethodBeat.i(134714);
        try {
            b bVar = this.ihJ;
            if (bVar != null) {
                bVar.nn(i);
                AppMethodBeat.o(134714);
                return;
            }
            AppMethodBeat.o(134714);
        } catch (Throwable th) {
            if (this.gOp) {
                d.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + th + " when dead");
                AppMethodBeat.o(134714);
                return;
            }
            AppMethodBeat.o(134714);
        }
    }

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.version.a aVar) {
        AppMethodBeat.i(134715);
        try {
            b bVar = this.ihJ;
            if (bVar != null) {
                bVar.a(aVar);
                AppMethodBeat.o(134715);
                return;
            }
            AppMethodBeat.o(134715);
        } catch (Throwable th) {
            if (this.gOp) {
                d.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + th + " when dead");
                AppMethodBeat.o(134715);
                return;
            }
            AppMethodBeat.o(134715);
        }
    }

    public final void atT() {
        AppMethodBeat.i(134716);
        try {
            b bVar = this.ihJ;
            if (bVar != null) {
                bVar.atT();
                AppMethodBeat.o(134716);
                return;
            }
            AppMethodBeat.o(134716);
        } catch (Throwable th) {
            if (this.gOp) {
                d.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows get " + th + " when dead");
                AppMethodBeat.o(134716);
                return;
            }
            AppMethodBeat.o(134716);
        }
    }

    public final void dead() {
        this.ihJ = null;
        this.gOp = true;
    }
}
