package com.tencent.mm.plugin.appbrand.report.quality;

import a.a.t;
import a.f.b.j;
import a.f.b.k;
import a.f.b.u.b;
import a.l;
import a.v;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.g.b.a.cb;
import com.tencent.mm.g.b.a.cf;
import com.tencent.mm.g.b.a.ch;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

@l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u000eH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J!\u0010\u001c\u001a\u0004\u0018\u00010\f*\u0004\u0018\u00010\f2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001eH\bJ\u0014\u0010\u001f\u001a\u00020\u0011*\u00020 2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006!"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/report/quality/AppStartupPerformanceReportUtil;", "", "()V", "createContactReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemContactCGIStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "createLaunchReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemLaunchCGIStruct;", "createRuntimeSession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "generateInstanceId", "", "uin", "", "getNetworkType", "qualityOpen", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "onResume", "", "qualityOpenBeforeLaunch", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "qualityOpenBeforeNavigate", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "nilAs", "as", "Lkotlin/Function0;", "setParcel", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityOpenStruct;", "plugin-appbrand-integration_release"})
public final class g {
    public static final g iCO = new g();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class a extends k implements a.f.a.a<String> {
        final /* synthetic */ b iCP;
        final /* synthetic */ d iCQ;

        a(b bVar, d dVar) {
            this.iCP = bVar;
            this.iCQ = dVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(134948);
            this.iCP.AVD = 1;
            i runtime = this.iCQ.getRuntime();
            j.o(runtime, "from.runtime");
            AppBrandInitConfig yf = runtime.yf();
            if (yf == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC");
                AppMethodBeat.o(134948);
                throw vVar;
            }
            String pM = g.pM(((AppBrandInitConfigWC) yf).uin);
            AppMethodBeat.o(134948);
            return pM;
        }
    }

    static {
        AppMethodBeat.i(134958);
        AppMethodBeat.o(134958);
    }

    private g() {
    }

    public static final int getNetworkType() {
        AppMethodBeat.i(134949);
        String cV = c.cV(ah.getContext());
        if (cV == null) {
            j.dWJ();
        }
        if (j.j(cV, c.iAf)) {
            AppMethodBeat.o(134949);
            return 0;
        } else if (j.j(cV, c.iAg)) {
            AppMethodBeat.o(134949);
            return 1;
        } else if (j.j(cV, c.iAh)) {
            AppMethodBeat.o(134949);
            return 2;
        } else if (j.j(cV, c.iAi)) {
            AppMethodBeat.o(134949);
            return 3;
        } else if (j.j(cV, c.iAj)) {
            AppMethodBeat.o(134949);
            return 4;
        } else if (j.j(cV, "offline")) {
            AppMethodBeat.o(134949);
            return 5;
        } else {
            AppMethodBeat.o(134949);
            return Downloads.MIN_WAIT_FOR_NETWORK;
        }
    }

    public static final String pM(int i) {
        AppMethodBeat.i(134950);
        String[] strArr = new String[2];
        String string = p.getString(i);
        j.o(string, "UIN.getString(uin)");
        strArr[0] = string;
        strArr[1] = String.valueOf(bo.anU());
        String a = t.a((Iterable) a.a.l.listOf(strArr), (CharSequence) "_", null, null, 0, null, null, 62);
        AppMethodBeat.o(134950);
        return a;
    }

    public static final cf a(QualitySession qualitySession) {
        AppMethodBeat.i(134951);
        j.p(qualitySession, "session");
        cf cfVar = new cf();
        cfVar.ha(qualitySession.appId);
        cfVar.gZ(qualitySession.igT);
        cfVar.a(com.tencent.mm.g.b.a.cf.a.hf(qualitySession.iCZ));
        cfVar.dZ((long) qualitySession.apptype);
        cfVar.eb((long) qualitySession.scene);
        cfVar.dY((long) qualitySession.iDa);
        AppMethodBeat.o(134951);
        return cfVar;
    }

    public static final ch b(QualitySession qualitySession) {
        AppMethodBeat.i(134952);
        j.p(qualitySession, "session");
        ch chVar = new ch();
        chVar.he(qualitySession.appId);
        chVar.hd(qualitySession.igT);
        chVar.a(com.tencent.mm.g.b.a.ch.a.hi(qualitySession.iCZ));
        chVar.ei((long) qualitySession.apptype);
        chVar.ek((long) qualitySession.scene);
        chVar.eh((long) qualitySession.iDa);
        AppMethodBeat.o(134952);
        return chVar;
    }

    public static final QualitySessionRuntime c(QualitySession qualitySession) {
        AppMethodBeat.i(134953);
        j.p(qualitySession, "session");
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        qualitySession.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        QualitySessionRuntime qualitySessionRuntime = new QualitySessionRuntime(obtain);
        obtain.recycle();
        AppMethodBeat.o(134953);
        return qualitySessionRuntime;
    }

    public static final void a(o oVar, boolean z) {
        AppMethodBeat.i(134954);
        j.p(oVar, "runtime");
        QualitySessionRuntime DG = a.DG(oVar.getAppId());
        if (DG != null) {
            cb cbVar = new cb();
            cbVar.gR(DG.appId);
            cbVar.dU((long) DG.iDa);
            cbVar.a(com.tencent.mm.g.b.a.cb.a.hc(DG.iCZ));
            cbVar.dV((long) DG.apptype);
            cbVar.dW((long) oVar.xx().scene);
            cbVar.gS(com.tencent.mm.plugin.appbrand.report.j.cW(ah.getContext()));
            cbVar.gT(oVar.atI().username);
            cbVar.gQ(DG.igT);
            cbVar.dX(z ? 0 : 1);
            cbVar.ajK();
            AppMethodBeat.o(134954);
            return;
        }
        AppMethodBeat.o(134954);
    }

    public static final String a(LaunchParcel launchParcel) {
        Object obj;
        int i;
        AppMethodBeat.i(134955);
        j.p(launchParcel, "parcel");
        String str = launchParcel.appId;
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            str = com.tencent.mm.plugin.appbrand.config.p.zm(launchParcel.username);
        }
        str = h.bv(str, launchParcel.har);
        charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            j.o(com.tencent.mm.kernel.g.RN(), "MMKernel.account()");
            str = pM(com.tencent.mm.kernel.a.QF());
            i = 1;
        } else {
            i = 0;
        }
        if (str == null) {
            j.dWJ();
        }
        cb cbVar = new cb();
        cbVar.gQ(str);
        cbVar.dX((long) i);
        a(cbVar, launchParcel);
        cbVar.ajK();
        AppMethodBeat.o(134955);
        return str;
    }

    /* JADX WARNING: Missing block: B:11:0x0042, code skipped:
            if (r0 != null) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final String b(d dVar, LaunchParcel launchParcel) {
        String str;
        AppMethodBeat.i(134956);
        j.p(dVar, "from");
        j.p(launchParcel, "parcel");
        b bVar = new b();
        bVar.AVD = 0;
        o wI = com.tencent.mm.plugin.appbrand.a.wI(launchParcel.appId);
        if (wI != null) {
            if (wI.ate() && !wI.finished() && wI.asT() == launchParcel.har) {
                QualitySessionRuntime DG = a.DG(wI.getAppId());
                if (DG != null) {
                    str = DG.igT;
                }
            }
            str = null;
        }
        str = (String) new a(bVar, dVar).invoke();
        cb cbVar = new cb();
        cbVar.gQ(str);
        cbVar.dX((long) bVar.AVD);
        a(cbVar, launchParcel);
        cbVar.ajK();
        AppMethodBeat.o(134956);
        return str;
    }

    private static void a(cb cbVar, LaunchParcel launchParcel) {
        AppMethodBeat.i(134957);
        cbVar.gR(launchParcel.appId);
        cbVar.dU((long) launchParcel.version);
        cbVar.a(com.tencent.mm.g.b.a.cb.a.hc(launchParcel.har + 1));
        cbVar.dW((long) launchParcel.ijy.scene);
        cbVar.gS(com.tencent.mm.plugin.appbrand.report.j.cW(ah.getContext()));
        cbVar.gT(launchParcel.username);
        AppMethodBeat.o(134957);
    }
}
