package com.tencent.p177mm.plugin.appbrand.launching;

import android.os.HandlerThread;
import android.os.Looper;
import android.support.p057v4.p065f.C6197a;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.p230g.p231a.C18304iz;
import com.tencent.p177mm.p230g.p231a.C26269vx;
import com.tencent.p177mm.p230g.p231a.C37815vy;
import com.tencent.p177mm.p230g.p232b.p233a.C37827cg;
import com.tencent.p177mm.p230g.p232b.p233a.C37827cg.C26284a;
import com.tencent.p177mm.p230g.p232b.p233a.C37827cg.C9511b;
import com.tencent.p177mm.p707ba.C45181k;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C42359s;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42364c;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42364c.C42363a;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42365d;
import com.tencent.p177mm.plugin.appbrand.appusage.C26772k;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C31283e;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandLaunchErrorAction.C10573a;
import com.tencent.p177mm.plugin.appbrand.launching.C42607af.C271591;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.p896i.C45567f;
import com.tencent.p177mm.plugin.appbrand.p904k.C42597a;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.p177mm.plugin.appbrand.report.quality.C2453g;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C11048d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.aoy;
import com.tencent.p177mm.protocal.protobuf.arb;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p644j.C5710a;
import com.tencent.p177mm.vending.p644j.C7625d;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.g */
public final class C27165g implements ILaunchWxaAppInfoNotify {
    private static final C6197a<String, C27165g> igC = new C6197a();
    private static final C7625d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> igQ = C5710a.m8577i(null, null, null);
    final String appId;
    final int cDB;
    final int cOq;
    final int har;
    final String hgC;
    final AppBrandLaunchReferrer hgF;
    private final QualitySession hgN;
    volatile C27169b igD;
    volatile boolean igE;
    volatile C7625d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> igF;
    volatile long igG;
    final String igH;
    final int igI;
    private volatile C31283e igJ;
    private final AppStartupPerformanceReportBundle igK;
    private final List<kv_14609> igL;
    private final C4884c<C18304iz> igM;
    private final List<C37827cg> igN;
    private final C4884c<C26269vx> igO;
    private final C4884c<C37815vy> igP;
    volatile boolean started;
    final String username;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.g$1 */
    class C195681 extends C4884c<C18304iz> {
        C195681() {
            AppMethodBeat.m2504i(131772);
            this.xxI = C18304iz.class.getName().hashCode();
            AppMethodBeat.m2505o(131772);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(131773);
            C18304iz c18304iz = (C18304iz) c4883b;
            if (C27165g.this.appId.equals(c18304iz.cEe.cEf.appId) && C27165g.this.igJ.axy == c18304iz.cEe.cEf.ihB) {
                C27165g.this.igL.add(c18304iz.cEe.cEf);
                AppMethodBeat.m2505o(131773);
                return true;
            } else if (c18304iz.cEe.cEf.cBc == 14) {
                C27165g.this.igL.add(c18304iz.cEe.cEf);
                AppMethodBeat.m2505o(131773);
                return true;
            } else {
                AppMethodBeat.m2505o(131773);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.g$2 */
    class C195692 extends C4884c<C26269vx> {
        C195692() {
            AppMethodBeat.m2504i(131774);
            this.xxI = C26269vx.class.getName().hashCode();
            AppMethodBeat.m2505o(131774);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(131775);
            C26269vx c26269vx = (C26269vx) c4883b;
            if (C27165g.this.appId.equals(((arb) c26269vx.cTe.cTf.ehh.fsG.fsP).csB) && C27165g.this.igJ.axy == ((arb) c26269vx.cTe.cTf.ehh.fsG.fsP).vOP && (c26269vx.cTe.cTf.avn() == 0 || c26269vx.cTe.cTf.avn() == 4)) {
                C9511b c9511b;
                C37827cg c37827cg = new C37827cg();
                c37827cg.dfQ = C26284a.release;
                c37827cg.mo60536ee(c26269vx.cTe.bZJ - c26269vx.cTe.cTh);
                c37827cg.mo60537ef(c26269vx.cTe.cTh);
                c37827cg.mo60538eg(c26269vx.cTe.bZJ);
                if (C42597a.m75415b(c26269vx.cTe.cTg)) {
                    c9511b = C9511b.ok;
                } else {
                    c9511b = C9511b.common_fail;
                }
                c37827cg.dfR = c9511b;
                c37827cg.cXm = (long) C2453g.getNetworkType();
                C27165g.this.igN.add(c37827cg);
                AppMethodBeat.m2505o(131775);
                return true;
            }
            AppMethodBeat.m2505o(131775);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.g$3 */
    class C195703 extends C4884c<C37815vy> {
        C195703() {
            AppMethodBeat.m2504i(131776);
            this.xxI = C37815vy.class.getName().hashCode();
            AppMethodBeat.m2505o(131776);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(131777);
            C37815vy c37815vy = (C37815vy) c4883b;
            if (C27165g.this.appId.equals(((aoy) c37815vy.cTi.cTj.ehh.fsG.fsP).csB) && ((aoy) c37815vy.cTi.cTj.ehh.fsG.fsP).vSb == C27165g.this.har) {
                C9511b c9511b;
                C37827cg c37827cg = new C37827cg();
                c37827cg.dfQ = C26284a.m41748hg(C27165g.this.har + 1);
                c37827cg.mo60536ee(c37815vy.cTi.bZJ - c37815vy.cTi.cTh);
                c37827cg.mo60537ef(c37815vy.cTi.cTh);
                c37827cg.mo60538eg(c37815vy.cTi.bZJ);
                if (C42597a.m75415b(c37815vy.cTi.cTg)) {
                    c9511b = C9511b.ok;
                } else {
                    c9511b = C9511b.common_fail;
                }
                c37827cg.dfR = c9511b;
                c37827cg.cXm = (long) C2453g.getNetworkType();
                C27165g.this.igN.add(c37827cg);
                AppMethodBeat.m2505o(131777);
                return true;
            }
            AppMethodBeat.m2505o(131777);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.g$7 */
    class C271687 implements Runnable {
        C271687() {
        }

        public final void run() {
            AppMethodBeat.m2504i(131783);
            String[] zl = C26842p.m42739zl(C27165g.this.username);
            if (zl != null && zl.length > 0) {
                for (String pC : zl) {
                    C37926b.abR().mo60688pC(pC);
                }
            }
            if (C1720g.m3536RP().isSDCardAvailable()) {
                C1720g.m3535RO().eJo.mo14541a(new C45181k(12), 0);
            }
            AppMethodBeat.m2505o(131783);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.g$b */
    interface C27169b extends C38422j {
        /* renamed from: a */
        void mo6244a(AppBrandSysConfigWC appBrandSysConfigWC, AppBrandLaunchErrorAction appBrandLaunchErrorAction, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle);

        void aHe();

        void atT();

        void onDownloadProgress(int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.g$8 */
    class C271708 extends TimerTask {
        C271708() {
        }

        public final void run() {
            AppMethodBeat.m2504i(131784);
            C4990ab.m7416i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transfer task cost more than 5000");
            if (C27165g.this.igD != null) {
                C27165g.this.igD.mo6247nm(3);
                C4990ab.m7416i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_OVER_THRESHOLD ");
            }
            AppMethodBeat.m2505o(131784);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.g$a */
    static final class C27171a extends C7564ap {
        public C27171a(final String str) {
            super(Looper.getMainLooper(), new C5015a() {
                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(131785);
                    C7060h.pYm.mo15419k(369, 23, 1);
                    C27165g.m43174Cg(str);
                    AppMethodBeat.m2505o(131785);
                    return false;
                }
            }, false);
            AppMethodBeat.m2504i(131786);
            AppMethodBeat.m2505o(131786);
        }
    }

    static {
        AppMethodBeat.m2504i(131801);
        AppMethodBeat.m2505o(131801);
    }

    /* renamed from: Cg */
    static C27165g m43174Cg(String str) {
        C27165g c27165g;
        AppMethodBeat.m2504i(131787);
        synchronized (igC) {
            try {
                c27165g = (C27165g) igC.remove(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(131787);
                }
            }
        }
        if (c27165g != null) {
            C4990ab.m7417i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "pollProcess appId(%s) type(%d) sessionId(%s)", c27165g.appId, Integer.valueOf(c27165g.har), str);
        }
        AppMethodBeat.m2505o(131787);
        return c27165g;
    }

    /* renamed from: Ch */
    static C27165g m43175Ch(String str) {
        C27165g c27165g;
        AppMethodBeat.m2504i(131788);
        synchronized (igC) {
            try {
                c27165g = (C27165g) igC.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(131788);
            }
        }
        return c27165g;
    }

    public C27165g(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        this(appBrandInitConfigWC.username, appBrandInitConfigWC.appId, appBrandInitConfigWC.gVs, appBrandStatObject.cOq, appBrandStatObject.scene, appBrandInitConfigWC.hgC, appBrandInitConfigWC.hgF, appBrandInitConfigWC.mo32993xz(), -1, appBrandInitConfigWC.hgN);
        AppMethodBeat.m2504i(131789);
        if (appBrandInitConfigWC.mo32992xy()) {
            C42359s.m74913xp(appBrandInitConfigWC.appId);
        }
        AppMethodBeat.m2505o(131789);
    }

    public C27165g(String str, String str2, int i, int i2, int i3, String str3, AppBrandLaunchReferrer appBrandLaunchReferrer, String str4, int i4, QualitySession qualitySession) {
        AppMethodBeat.m2504i(131790);
        this.igG = -1;
        this.igL = new CopyOnWriteArrayList();
        this.igM = new C195681();
        this.igN = new CopyOnWriteArrayList();
        this.igO = new C195692();
        this.igP = new C195703();
        this.username = str;
        this.appId = str2;
        this.har = i;
        this.cOq = i2;
        this.cDB = i3;
        this.hgC = str3;
        this.hgF = appBrandLaunchReferrer;
        this.igH = str4;
        this.igI = i4;
        this.hgN = qualitySession;
        this.igK = new AppStartupPerformanceReportBundle(qualitySession.igT);
        AppMethodBeat.m2505o(131790);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo44841a(C7625d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> c7625d) {
        AppMethodBeat.m2504i(131791);
        this.igF = c7625d;
        if (this.igD != null) {
            this.igD.mo6244a((AppBrandSysConfigWC) c7625d.get(0), (AppBrandLaunchErrorAction) c7625d.get(1), (AppStartupPerformanceReportBundle) c7625d.get(2));
            C27165g.m43174Cg(this.igH);
        }
        AppMethodBeat.m2505o(131791);
    }

    /* renamed from: a */
    public final void mo34768a(String str, int i, String str2, C27157aa c27157aa) {
        AppMethodBeat.m2504i(131792);
        if (this.igF != null) {
            C10573a c10573a = AppBrandLaunchErrorAction.CREATOR;
            AppBrandLaunchErrorAction a = C10573a.m18260a(this.appId, this.har, c27157aa);
            if (a != null) {
                this.igF = C5710a.m8577i(null, a, this.igK);
                AppMethodBeat.m2505o(131792);
                return;
            }
            AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) this.igF.get(0);
            if (appBrandSysConfigWC == null) {
                C4990ab.m7413e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyLaunchInfoUpdate null config with appId(%s)", str);
                AppMethodBeat.m2505o(131792);
                return;
            }
            c27157aa.mo44829a(appBrandSysConfigWC);
            this.igF = C5710a.m8577i(appBrandSysConfigWC, null, this.igK);
        }
        AppMethodBeat.m2505o(131792);
    }

    public final void aHd() {
        AppMethodBeat.m2504i(131793);
        if (this.started) {
            AppMethodBeat.m2505o(131793);
            return;
        }
        this.started = true;
        C4990ab.m7417i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] startPrepare in mm %s %d", this.appId, Integer.valueOf(this.har));
        synchronized (igC) {
            try {
                igC.put(this.igH, this);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(131793);
            }
        }
        C27171a c27171a = new C27171a(this.igH);
        long toMillis = TimeUnit.SECONDS.toMillis(300);
        c27171a.mo16770ae(toMillis, toMillis);
        final HandlerThread anM = C7305d.anM(String.format(Locale.US, "AppLaunchPrepareProcess[%s %d]", new Object[]{this.appId, Integer.valueOf(this.har)}));
        anM.start();
        new C7306ak(anM.getLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(131778);
                try {
                    C27165g.m43177a(C27165g.this, C27165g.this.aHf());
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", e, "call() exp ", new Object[0]);
                    C42608ag.m75435oZ(C25738R.string.f8954kn);
                    C27165g.m43177a(C27165g.this, C27165g.igQ);
                }
                anM.quit();
                AppMethodBeat.m2505o(131778);
            }
        });
    }

    /* Access modifiers changed, original: final */
    public final void aHg() {
        AppMethodBeat.m2504i(131795);
        if (this.igD != null) {
            this.igD.onDownloadProgress(100);
        }
        AppMethodBeat.m2505o(131795);
    }

    private void aHh() {
        AppMethodBeat.m2504i(131796);
        C4990ab.m7416i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferData   callback != null " + (this.igD != null));
        Timer timer = new Timer();
        timer.schedule(new C271708(), 5000);
        if (this.igD != null) {
            this.igD.mo6247nm(1);
            C4990ab.m7416i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_START ");
        }
        C1812ai[] c1812aiArr = new C1812ai[]{new C42364c(this.appId)};
        for (int i = 0; i <= 0; i++) {
            C1812ai c1812ai = c1812aiArr[0];
            if (c1812ai.mo5386kw(C7243d.vxo)) {
                c1812ai.transfer(C7243d.vxo);
            }
        }
        timer.cancel();
        if (this.igD != null) {
            this.igD.mo6247nm(2);
            C4990ab.m7416i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_FINISH ");
        }
        AppMethodBeat.m2505o(131796);
    }

    public final C7625d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> aHf() {
        AppMethodBeat.m2504i(131794);
        AppBrandSysConfigWC zj = C26842p.m42737zj(this.appId);
        if (zj == null) {
            C42608ag.m75434Ck(C42677e.getMMString(C25738R.string.f9007m9, ""));
        }
        if (zj == null) {
            C4990ab.m7412e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "get null config!!!");
            C7625d c7625d = igQ;
            AppMethodBeat.m2505o(131794);
            return c7625d;
        }
        Object obj;
        ((C26772k) C42340f.m74878E(C26772k.class)).mo44544x(C26842p.m42742zo(this.appId), C5046bo.anT());
        C19681j c19681j = new C19681j();
        WxaAttributes e = C42340f.auO().mo21573e(this.appId, "versionInfo", "appInfo");
        this.igM.dnU();
        if (this.har == 0) {
            this.igO.dnU();
        } else {
            this.igP.dnU();
        }
        this.igJ = e.ayL();
        C271665 c271665 = new C19559ai(zj.appId, this.har, this.hgC, this.cDB, e) {
            public final void aHe() {
                AppMethodBeat.m2504i(131779);
                C27165g.m43180d(C27165g.this);
                AppMethodBeat.m2505o(131779);
            }

            public final void aHj() {
                AppMethodBeat.m2504i(131780);
                C27165g.m43181e(C27165g.this);
                AppMethodBeat.m2505o(131780);
            }

            public final void onDownloadProgress(int i) {
                AppMethodBeat.m2504i(131781);
                if (C27165g.this.igD != null) {
                    C27165g.this.igD.onDownloadProgress(i);
                }
                AppMethodBeat.m2505o(131781);
            }
        };
        FutureTask futureTask = new FutureTask(c271665);
        C7305d.xDG.mo10147a(futureTask, c271665.getTag(), new C271591(futureTask));
        C27157aa c27157aa = (C27157aa) new C19561aj(this.appId, this.har, this.cOq, this.cDB, this.hgC, this.hgF, this.igH, this.igI, this.hgN) {
            /* Access modifiers changed, original: final */
            public final void atT() {
                AppMethodBeat.m2504i(131782);
                C27165g.m43182f(C27165g.this);
                AppMethodBeat.m2505o(131782);
            }
        }.aHy();
        if (c27157aa == null) {
            C4990ab.m7417i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null launchInfo", this.username, this.appId);
            obj = null;
        } else {
            C10573a c10573a = AppBrandLaunchErrorAction.CREATOR;
            AppBrandLaunchErrorAction a = C10573a.m18260a(this.appId, this.har, c27157aa);
            if (a != null) {
                c19681j.value = a;
                C4990ab.m7417i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, launch ban code %d", this.username, this.appId, Integer.valueOf(c27157aa.field_launchAction.vAS));
                obj = null;
            } else {
                this.igK.igW = c27157aa.ihY;
                if (c27157aa.field_jsapiInfo == null || c27157aa.field_jsapiInfo.vYw == null) {
                    C4990ab.m7413e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null jsapi_info", this.username, this.appId);
                    obj = null;
                } else {
                    c27157aa.mo44829a(zj);
                    if (c27157aa.field_launchAction.wBv) {
                        C1720g.m3528K(C11048d.class);
                        zj.bQr = !C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_APP_BRAND_RECENT_BAR_HAS_BEEN_REVEALED_BY_FIRST_APP_LAUNCH_BOOLEAN, false);
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_RECENT_BAR_HAS_BEEN_REVEALED_BY_FIRST_APP_LAUNCH_BOOLEAN, Boolean.TRUE);
                    } else {
                        zj.bQr = false;
                    }
                    WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) futureTask.get();
                    this.igE = true;
                    aHg();
                    this.igM.dead();
                    this.igO.dead();
                    this.igP.dead();
                    this.igK.igU.addAll(this.igN);
                    this.igK.igV.addAll(this.igL);
                    if (wxaPkgWrappingInfo == null) {
                        C4990ab.m7417i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig null app pkg, username %s appId %s", this.username, this.appId);
                        obj = null;
                    } else {
                        zj.hhd.mo53639a(wxaPkgWrappingInfo);
                        if (zj.hhd.gVt != 0) {
                            zj.hhd.gVu = 0;
                        }
                        C4990ab.m7417i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, app pkg %s", this.username, zj.appId, zj.hhd);
                        zj.bQO = AppBrandGlobalSystemConfig.ayC();
                        zj.bQP = C42340f.m74880xH().get("key_sendtodesktop_no_more_show_permission_notify_dialog", AppEventsConstants.EVENT_PARAM_VALUE_NO).equals("1");
                        C45567f c45567f = C45567f.inF;
                        Long cF = C45567f.m84062cF(this.appId, "copypath");
                        zj.bQN = cF == null ? 0 : cF.longValue();
                        C4990ab.m7416i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "copyPathMenuShowExpireTime = " + zj.bQN);
                        C7305d.post(new C271687(), "AppLaunchPrepareProcess#ExtraWorks");
                        C4990ab.m7417i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig ok username %s, appId %s", this.username, this.appId);
                        aHh();
                        C42363a c42363a = C42364c.gXf;
                        zj.hhe = C42363a.m74934xV(this.appId);
                        zj.hhf = C42365d.gXk.awJ();
                        obj = 1;
                    }
                }
            }
        }
        C7625d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> i;
        if (obj == null) {
            C4990ab.m7417i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, false, username %s, appId %s", this.username, this.appId);
            i = C5710a.m8577i(null, c19681j.value, this.igK);
            AppMethodBeat.m2505o(131794);
            return i;
        }
        C4990ab.m7417i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, just go weapp, username %s, appId %s", this.username, this.appId);
        i = C5710a.m8577i(zj, null, this.igK);
        AppMethodBeat.m2505o(131794);
        return i;
    }

    /* renamed from: a */
    static /* synthetic */ void m43177a(C27165g c27165g, C7625d c7625d) {
        boolean z;
        AppMethodBeat.m2504i(131797);
        C4990ab.m7419v("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] onPrepareDone %s %d in mm process", c27165g.appId, Integer.valueOf(c27165g.har));
        c27165g.mo44841a(c7625d);
        C16597h c16597h = (C16597h) c7625d.get(0);
        String str = c27165g.appId;
        int i = c27165g.har;
        int i2 = c27165g.cDB;
        if (c16597h != null) {
            z = true;
        } else {
            z = false;
        }
        LaunchBroadCast.m43154a(str, i, i2, z);
        AppMethodBeat.m2505o(131797);
    }

    /* renamed from: d */
    static /* synthetic */ void m43180d(C27165g c27165g) {
        AppMethodBeat.m2504i(131798);
        C4990ab.m7417i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "preDownload, appId %s, versionType %d", c27165g.appId, Integer.valueOf(c27165g.har));
        c27165g.igG = C5046bo.anU();
        if (c27165g.igD != null) {
            c27165g.igD.aHe();
        }
        AppMethodBeat.m2505o(131798);
    }

    /* renamed from: e */
    static /* synthetic */ void m43181e(C27165g c27165g) {
        AppMethodBeat.m2504i(131799);
        C4990ab.m7417i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "postDownload, appId %s, versionType %d", c27165g.appId, Integer.valueOf(c27165g.har));
        if (c27165g.igD != null) {
            C27169b c27169b = c27165g.igD;
        }
        AppMethodBeat.m2505o(131799);
    }

    /* renamed from: f */
    static /* synthetic */ void m43182f(C27165g c27165g) {
        AppMethodBeat.m2504i(131800);
        if (c27165g.igD != null) {
            c27165g.igD.atT();
        }
        AppMethodBeat.m2505o(131800);
    }
}
