package com.tencent.p177mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p230g.p232b.p233a.C18443ch;
import com.tencent.p177mm.p230g.p232b.p233a.C18443ch.C1595a;
import com.tencent.p177mm.p230g.p232b.p233a.C46882cf;
import com.tencent.p177mm.p230g.p232b.p233a.C46882cf.C26282a;
import com.tencent.p177mm.p230g.p232b.p233a.C9509cb;
import com.tencent.p177mm.p230g.p232b.p233a.C9509cb.C9508a;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.report.C42674j;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p001a.C25035t;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C41381u.C41380b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u000eH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J!\u0010\u001c\u001a\u0004\u0018\u00010\f*\u0004\u0018\u00010\f2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001eH\bJ\u0014\u0010\u001f\u001a\u00020\u0011*\u00020 2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006!"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/report/quality/AppStartupPerformanceReportUtil;", "", "()V", "createContactReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemContactCGIStruct;", "session", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "createLaunchReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualitySystemLaunchCGIStruct;", "createRuntimeSession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "generateInstanceId", "", "uin", "", "getNetworkType", "qualityOpen", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "onResume", "", "qualityOpenBeforeLaunch", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "qualityOpenBeforeNavigate", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "nilAs", "as", "Lkotlin/Function0;", "setParcel", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityOpenStruct;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.report.quality.g */
public final class C2453g {
    public static final C2453g iCO = new C2453g();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.report.quality.g$a */
    static final class C2454a extends C25053k implements C31214a<String> {
        final /* synthetic */ C41380b iCP;
        final /* synthetic */ C2119d iCQ;

        C2454a(C41380b c41380b, C2119d c2119d) {
            this.iCP = c41380b;
            this.iCQ = c2119d;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(134948);
            this.iCP.AVD = 1;
            C6750i runtime = this.iCQ.getRuntime();
            C25052j.m39375o(runtime, "from.runtime");
            AppBrandInitConfig yf = runtime.mo15035yf();
            if (yf == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC");
                AppMethodBeat.m2505o(134948);
                throw c44941v;
            }
            String pM = C2453g.m4700pM(((AppBrandInitConfigWC) yf).uin);
            AppMethodBeat.m2505o(134948);
            return pM;
        }
    }

    static {
        AppMethodBeat.m2504i(134958);
        AppMethodBeat.m2505o(134958);
    }

    private C2453g() {
    }

    public static final int getNetworkType() {
        AppMethodBeat.m2504i(134949);
        String cV = C19690c.m30503cV(C4996ah.getContext());
        if (cV == null) {
            C25052j.dWJ();
        }
        if (C25052j.m39373j(cV, C19690c.iAf)) {
            AppMethodBeat.m2505o(134949);
            return 0;
        } else if (C25052j.m39373j(cV, C19690c.iAg)) {
            AppMethodBeat.m2505o(134949);
            return 1;
        } else if (C25052j.m39373j(cV, C19690c.iAh)) {
            AppMethodBeat.m2505o(134949);
            return 2;
        } else if (C25052j.m39373j(cV, C19690c.iAi)) {
            AppMethodBeat.m2505o(134949);
            return 3;
        } else if (C25052j.m39373j(cV, C19690c.iAj)) {
            AppMethodBeat.m2505o(134949);
            return 4;
        } else if (C25052j.m39373j(cV, "offline")) {
            AppMethodBeat.m2505o(134949);
            return 5;
        } else {
            AppMethodBeat.m2505o(134949);
            return Downloads.MIN_WAIT_FOR_NETWORK;
        }
    }

    /* renamed from: pM */
    public static final String m4700pM(int i) {
        AppMethodBeat.m2504i(134950);
        String[] strArr = new String[2];
        String string = C1183p.getString(i);
        C25052j.m39375o(string, "UIN.getString(uin)");
        strArr[0] = string;
        strArr[1] = String.valueOf(C5046bo.anU());
        String a = C25035t.m39322a((Iterable) C7987l.listOf(strArr), (CharSequence) "_", null, null, 0, null, null, 62);
        AppMethodBeat.m2505o(134950);
        return a;
    }

    /* renamed from: a */
    public static final C46882cf m4693a(QualitySession qualitySession) {
        AppMethodBeat.m2504i(134951);
        C25052j.m39376p(qualitySession, "session");
        C46882cf c46882cf = new C46882cf();
        c46882cf.mo76069ha(qualitySession.appId);
        c46882cf.mo76068gZ(qualitySession.igT);
        c46882cf.mo76061a(C26282a.m41747hf(qualitySession.iCZ));
        c46882cf.mo76063dZ((long) qualitySession.apptype);
        c46882cf.mo76065eb((long) qualitySession.scene);
        c46882cf.mo76062dY((long) qualitySession.iDa);
        AppMethodBeat.m2505o(134951);
        return c46882cf;
    }

    /* renamed from: b */
    public static final C18443ch m4697b(QualitySession qualitySession) {
        AppMethodBeat.m2504i(134952);
        C25052j.m39376p(qualitySession, "session");
        C18443ch c18443ch = new C18443ch();
        c18443ch.mo33717he(qualitySession.appId);
        c18443ch.mo33716hd(qualitySession.igT);
        c18443ch.mo33709a(C1595a.m3235hi(qualitySession.iCZ));
        c18443ch.mo33711ei((long) qualitySession.apptype);
        c18443ch.mo33713ek((long) qualitySession.scene);
        c18443ch.mo33710eh((long) qualitySession.iDa);
        AppMethodBeat.m2505o(134952);
        return c18443ch;
    }

    /* renamed from: c */
    public static final QualitySessionRuntime m4699c(QualitySession qualitySession) {
        AppMethodBeat.m2504i(134953);
        C25052j.m39376p(qualitySession, "session");
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        qualitySession.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        QualitySessionRuntime qualitySessionRuntime = new QualitySessionRuntime(obtain);
        obtain.recycle();
        AppMethodBeat.m2505o(134953);
        return qualitySessionRuntime;
    }

    /* renamed from: a */
    public static final void m4696a(C41243o c41243o, boolean z) {
        AppMethodBeat.m2504i(134954);
        C25052j.m39376p(c41243o, "runtime");
        QualitySessionRuntime DG = C27285a.m43319DG(c41243o.getAppId());
        if (DG != null) {
            C9509cb c9509cb = new C9509cb();
            c9509cb.mo20798gR(DG.appId);
            c9509cb.mo20793dU((long) DG.iDa);
            c9509cb.mo20792a(C9508a.m16931hc(DG.iCZ));
            c9509cb.mo20794dV((long) DG.apptype);
            c9509cb.mo20795dW((long) c41243o.mo43490xx().scene);
            c9509cb.mo20799gS(C42674j.m75576cW(C4996ah.getContext()));
            c9509cb.mo20800gT(c41243o.atI().username);
            c9509cb.mo20797gQ(DG.igT);
            c9509cb.mo20796dX(z ? 0 : 1);
            c9509cb.ajK();
            AppMethodBeat.m2505o(134954);
            return;
        }
        AppMethodBeat.m2505o(134954);
    }

    /* renamed from: a */
    public static final String m4694a(LaunchParcel launchParcel) {
        Object obj;
        int i;
        AppMethodBeat.m2504i(134955);
        C25052j.m39376p(launchParcel, "parcel");
        String str = launchParcel.appId;
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            str = C26842p.m42740zm(launchParcel.username);
        }
        str = C45694h.m84424bv(str, launchParcel.har);
        charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            C25052j.m39375o(C1720g.m3534RN(), "MMKernel.account()");
            str = C2453g.m4700pM(C1668a.m3383QF());
            i = 1;
        } else {
            i = 0;
        }
        if (str == null) {
            C25052j.dWJ();
        }
        C9509cb c9509cb = new C9509cb();
        c9509cb.mo20797gQ(str);
        c9509cb.mo20796dX((long) i);
        C2453g.m4695a(c9509cb, launchParcel);
        c9509cb.ajK();
        AppMethodBeat.m2505o(134955);
        return str;
    }

    /* JADX WARNING: Missing block: B:11:0x0042, code skipped:
            if (r0 != null) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public static final String m4698b(C2119d c2119d, LaunchParcel launchParcel) {
        String str;
        AppMethodBeat.m2504i(134956);
        C25052j.m39376p(c2119d, "from");
        C25052j.m39376p(launchParcel, "parcel");
        C41380b c41380b = new C41380b();
        c41380b.AVD = 0;
        C41243o wI = C10048a.m17635wI(launchParcel.appId);
        if (wI != null) {
            if (wI.ate() && !wI.finished() && wI.asT() == launchParcel.har) {
                QualitySessionRuntime DG = C27285a.m43319DG(wI.getAppId());
                if (DG != null) {
                    str = DG.igT;
                }
            }
            str = null;
        }
        str = (String) new C2454a(c41380b, c2119d).invoke();
        C9509cb c9509cb = new C9509cb();
        c9509cb.mo20797gQ(str);
        c9509cb.mo20796dX((long) c41380b.AVD);
        C2453g.m4695a(c9509cb, launchParcel);
        c9509cb.ajK();
        AppMethodBeat.m2505o(134956);
        return str;
    }

    /* renamed from: a */
    private static void m4695a(C9509cb c9509cb, LaunchParcel launchParcel) {
        AppMethodBeat.m2504i(134957);
        c9509cb.mo20798gR(launchParcel.appId);
        c9509cb.mo20793dU((long) launchParcel.version);
        c9509cb.mo20792a(C9508a.m16931hc(launchParcel.har + 1));
        c9509cb.mo20795dW((long) launchParcel.ijy.scene);
        c9509cb.mo20799gS(C42674j.m75576cW(C4996ah.getContext()));
        c9509cb.mo20800gT(launchParcel.username);
        AppMethodBeat.m2505o(134957);
    }
}
