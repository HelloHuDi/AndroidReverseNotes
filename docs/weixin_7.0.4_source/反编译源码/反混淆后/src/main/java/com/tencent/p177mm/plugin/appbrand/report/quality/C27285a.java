package com.tencent.p177mm.plugin.appbrand.report.quality;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.p230g.p232b.p233a.C1591bx;
import com.tencent.p177mm.p230g.p232b.p233a.C1591bx.C1592a;
import com.tencent.p177mm.p230g.p232b.p233a.C1593by;
import com.tencent.p177mm.p230g.p232b.p233a.C1593by.C1594a;
import com.tencent.p177mm.p230g.p232b.p233a.C18448cj;
import com.tencent.p177mm.p230g.p232b.p233a.C18448cj.C18449c;
import com.tencent.p177mm.p230g.p232b.p233a.C18448cj.C18450a;
import com.tencent.p177mm.p230g.p232b.p233a.C18448cj.C9512b;
import com.tencent.p177mm.p230g.p232b.p233a.C37826bz;
import com.tencent.p177mm.p230g.p232b.p233a.C37826bz.C37825a;
import com.tencent.p177mm.p230g.p232b.p233a.C42096cl;
import com.tencent.p177mm.p230g.p232b.p233a.C42096cl.C32672a;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.appcache.C19071r;
import com.tencent.p177mm.plugin.appbrand.appcache.PartialFile;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.performance.C27258f;
import com.tencent.p177mm.plugin.appbrand.report.C42674j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.appbrand.report.quality.a */
public class C27285a {
    static final /* synthetic */ boolean $assertionsDisabled = (!C27285a.class.desiredAssertionStatus());
    private static final C38501b iCC = new C38501b();
    private static final HashMap<String, QualitySessionRuntime> iCD = new HashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.report.quality.a$a */
    public static class C27287a {
        boolean iCG = false;
    }

    static {
        AppMethodBeat.m2504i(132684);
        AppMethodBeat.m2505o(132684);
    }

    /* renamed from: o */
    public static void m43324o(final C41243o c41243o) {
        AppMethodBeat.m2504i(132677);
        C45124d.m82930i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] startSession appId = [%s] runtime.hashCode = [%d]", c41243o.mAppId, Integer.valueOf(c41243o.hashCode()));
        QualitySession qualitySession = c41243o.atI().hgN;
        if (qualitySession == null) {
            C45124d.m82927e("MicroMsg.AppBrandQualitySystem", "startSession with NULL qualityReportSession in InitConfig");
            qualitySession = new QualitySession(C2453g.m4700pM(c41243o.atI().uin), c41243o.atI(), c41243o.mo43491ya().bQn);
            c41243o.atI().hgN = qualitySession;
        }
        QualitySessionRuntime c = C2453g.m4699c(qualitySession);
        c.htn = c41243o;
        c.hrs = c41243o.mo65903xy();
        c.iDc = System.currentTimeMillis();
        synchronized (iCD) {
            try {
                if ($assertionsDisabled || iCD.get(c41243o.mAppId) == null) {
                    iCD.put(c.appId, c);
                } else {
                    Object assertionError = new AssertionError();
                    throw assertionError;
                }
            } finally {
                AppMethodBeat.m2505o(132677);
            }
        }
        C33183g.m54274a(c41243o.mAppId, new C33186c() {
            public final void onDestroy() {
                AppMethodBeat.m2504i(132675);
                C45124d.m82930i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] closeSession appId = [%s] runtime.hashCode = [%d]", c41243o.mAppId, Integer.valueOf(c41243o.hashCode()));
                C27285a.m43325p(c41243o);
                AppMethodBeat.m2505o(132675);
            }
        });
        AppMethodBeat.m2505o(132677);
    }

    /* renamed from: DG */
    public static QualitySessionRuntime m43319DG(String str) {
        AppMethodBeat.m2504i(132678);
        QualitySessionRuntime aq = C27285a.m43323aq(str, true);
        AppMethodBeat.m2505o(132678);
        return aq;
    }

    /* renamed from: aq */
    private static QualitySessionRuntime m43323aq(String str, boolean z) {
        QualitySessionRuntime qualitySessionRuntime;
        AppMethodBeat.m2504i(132679);
        synchronized (iCD) {
            try {
                qualitySessionRuntime = (QualitySessionRuntime) iCD.get(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(132679);
                }
            }
        }
        if (qualitySessionRuntime == null) {
            String format = String.format(Locale.US, "QualitySession not open. appId=%s", new Object[]{str});
            if (z && (C5058f.DEBUG || C5058f.IS_FLAVOR_RED)) {
                IllegalStateException illegalStateException = new IllegalStateException(format);
                AppMethodBeat.m2505o(132679);
                throw illegalStateException;
            }
            C45124d.printErrStackTrace("MicroMsg.AppBrandQualitySystem", new Throwable(), format, new Object[0]);
        }
        AppMethodBeat.m2505o(132679);
        return qualitySessionRuntime;
    }

    public static C38501b aLz() {
        return iCC;
    }

    /* renamed from: a */
    public static void m43320a(String str, final AppBrandSysConfigWC appBrandSysConfigWC, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle, C41243o c41243o) {
        long j = 0;
        AppMethodBeat.m2504i(132680);
        final QualitySessionRuntime aq = C27285a.m43323aq(str, true);
        if (aq == null) {
            AppMethodBeat.m2505o(132680);
            return;
        }
        aq.iDd = System.currentTimeMillis();
        aq.iDe = appStartupPerformanceReportBundle;
        aq.iDb = c41243o.atI().startTime;
        AppStartupPerformanceReportBundle appStartupPerformanceReportBundle2 = (AppStartupPerformanceReportBundle) c41243o.mo15016c(AppStartupPerformanceReportBundle.class, false);
        if (appStartupPerformanceReportBundle2 == null) {
            C4990ab.m7412e("MicroMsg.AppBrandQualitySystem", "ReportBundle == null in resourceReady");
        } else {
            C18448cj c18448cj = new C18448cj();
            QualitySessionRuntime aq2 = C27285a.m43323aq(str, true);
            if (aq2 != null) {
                C18449c c18449c;
                C9512b c9512b;
                long j2;
                c18448cj.mo33726hi(aq2.appId);
                c18448cj.mo33725hh(aq2.igT);
                c18448cj.dgv = C18450a.m28711hk(aq2.iCZ);
                c18448cj.ddz = (long) aq2.apptype;
                c18448cj.cVR = (long) aq2.scene;
                c18448cj.ddd = (long) aq2.iDa;
                c18448cj.mo33724eq(c41243o.atI().startTime);
                c18448cj.mo33722Hg();
                c18448cj.mo33723ep(c18448cj.ddC - c41243o.atI().startTime);
                AppBrandSysConfigWC atH = c41243o.atH();
                AppBrandInitConfigWC atI = c41243o.atI();
                if (appStartupPerformanceReportBundle2.igW) {
                    c18449c = C18449c.sync;
                } else {
                    c18449c = C18449c.unsync;
                }
                c18448cj.dgx = c18449c;
                if (atI.hgO) {
                    c9512b = C9512b.sync;
                } else {
                    c9512b = C9512b.unsync;
                }
                c18448cj.dgy = c9512b;
                if (c41243o.gPs) {
                    j2 = 1;
                } else {
                    j2 = 0;
                }
                c18448cj.dgz = j2;
                if (c41243o.gPs) {
                    File file = new File(atH.hhd.gSP);
                    if (file.isFile() && file.canRead()) {
                        j = file.length();
                    }
                }
                c18448cj.dgw = j;
                c18448cj.cXm = (long) C2453g.getNetworkType();
                c18448cj.ajK();
            }
        }
        C45673m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(132676);
                if (aq.htn.mFinished) {
                    AppMethodBeat.m2505o(132676);
                    return;
                }
                C38502e c38502e = aq.iDh;
                QualitySessionRuntime qualitySessionRuntime = aq;
                AppBrandSysConfigWC appBrandSysConfigWC = appBrandSysConfigWC;
                C45124d.m82929i("MicroMsg.AppBrandRuntimeEventReporter", "AppBrandRuntimeEventReporter.mayStart");
                C45124d.m82930i("MicroMsg.AppBrandRuntimeEventReporter", "shouldEnableReport() returned: [%b], localRandom = [%f] serverPercent = [%f]", Boolean.valueOf(new Random(((long) qualitySessionRuntime.htn.atI().uin) ^ System.nanoTime()).nextDouble() <= appBrandSysConfigWC.bQO.hgc), Double.valueOf(new Random(((long) qualitySessionRuntime.htn.atI().uin) ^ System.nanoTime()).nextDouble()), Double.valueOf(appBrandSysConfigWC.bQO.hgc));
                if (new Random(((long) qualitySessionRuntime.htn.atI().uin) ^ System.nanoTime()).nextDouble() <= appBrandSysConfigWC.bQO.hgc) {
                    synchronized (c38502e) {
                        try {
                            c38502e.iCK = qualitySessionRuntime;
                            if (c38502e.handler == null) {
                                c38502e.handler = new Handler(Looper.getMainLooper());
                                c38502e.iCJ.ciy = (long) (appBrandSysConfigWC.bQO.hgd * 1000);
                                c38502e.handler.post(c38502e.iCJ);
                            }
                            if (!qualitySessionRuntime.hrs) {
                                c38502e.iCL = new C27258f();
                                c38502e.iCL.mInterval = 200;
                                c38502e.iCL.ivJ = null;
                                c38502e.iCL.start();
                            }
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(132676);
                        }
                    }
                    return;
                }
                AppMethodBeat.m2505o(132676);
            }
        });
        AppMethodBeat.m2505o(132680);
    }

    /* renamed from: a */
    public static void m43321a(String str, C41243o c41243o) {
        AppMethodBeat.m2504i(132681);
        if (C27285a.m43323aq(str, true) == null) {
            AppMethodBeat.m2505o(132681);
            return;
        }
        long j;
        C37826bz c37826bz = new C37826bz();
        QualitySessionRuntime aq = C27285a.m43323aq(str, true);
        if (aq != null) {
            C37826bz c37826bz2;
            c37826bz.mo60533gJ(aq.appId);
            c37826bz.mo60532gI(aq.igT);
            c37826bz.deC = C37825a.m63768ha(aq.iCZ);
            c37826bz.ddz = (long) aq.apptype;
            c37826bz.ddd = (long) aq.iDa;
            c37826bz.cVR = (long) aq.scene;
            c37826bz.mo60531dR(c41243o.atI().startTime);
            c37826bz.mo60529Hb();
            c37826bz.mo60530dQ(c37826bz.ddC - c37826bz.ddB);
            try {
                c37826bz.mo60534gK(C18178q.encode(c41243o.atJ().getCurrentUrl()));
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrandQualitySystem", "launchToInitReady appId %s getCurrentUrl npe = %s", str, e);
            }
            if (c41243o.gPs) {
                j = 1;
            } else {
                j = 0;
            }
            c37826bz.ddj = j;
            if (aq.iDe != null) {
                if (aq.iDe.aHk()) {
                    j = 1;
                } else {
                    j = 0;
                }
                c37826bz.dew = j;
            } else if (C5058f.DEBUG) {
                IllegalStateException illegalStateException = new IllegalStateException("StartupBundle not registered.");
                AppMethodBeat.m2505o(132681);
                throw illegalStateException;
            }
            if (aq.iDj) {
                j = 2;
                c37826bz2 = c37826bz;
            } else if (c41243o.atK().gPH) {
                j = 1;
                c37826bz2 = c37826bz;
            } else {
                j = 0;
                c37826bz2 = c37826bz;
            }
            c37826bz2.ddg = j;
            c37826bz.deD = 0;
            c37826bz.mo60535gL(C42674j.m75576cW(C4996ah.getContext()));
            PartialFile[] partialFileArr = c41243o.atH().hhd.gSR;
            if (!C19071r.avH() || partialFileArr == null || partialFileArr.length <= 0) {
                c37826bz.deE = 0;
            } else {
                c37826bz.deE = 1;
            }
            c37826bz.ajK();
        }
        C42096cl c42096cl = new C42096cl();
        QualitySessionRuntime aq2 = C27285a.m43323aq(str, true);
        if (aq2 != null) {
            c42096cl.mo67658hm(aq2.appId);
            c42096cl.mo67657hl(aq2.igT);
            c42096cl.dgQ = C32672a.m53304hm(aq2.iCZ);
            c42096cl.ddz = (long) aq2.apptype;
            c42096cl.ddd = (long) aq2.iDa;
            c42096cl.cVR = (long) aq2.scene;
            c42096cl.mo67656eu(aq2.iDd);
            c42096cl.mo67654Hi();
            c42096cl.mo67655et(c42096cl.ddC - aq2.iDd);
            if (aq2.iDj) {
                c42096cl.ddg = 2;
            } else {
                if (c41243o.atK().gPH) {
                    j = 1;
                } else {
                    j = 0;
                }
                c42096cl.ddg = j;
            }
            try {
                c42096cl.mo67659hn(C18178q.encode(c41243o.atJ().getCurrentUrl()));
            } catch (Exception e2) {
            }
            c42096cl.deD = 0;
            c42096cl.mo67660ho(C42674j.m75576cW(C4996ah.getContext()));
            c42096cl.ajK();
        }
        AppMethodBeat.m2505o(132681);
    }

    /* renamed from: a */
    public static void m43322a(String str, String str2, String str3, long j, int i) {
        AppMethodBeat.m2504i(132682);
        QualitySessionRuntime aq = C27285a.m43323aq(str, true);
        if (aq == null) {
            AppMethodBeat.m2505o(132682);
            return;
        }
        C45124d.m82930i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject appId = [%s] session.runtime.hashCode = [%d] runtimeHashCode = [%d] name = [%s].", str, Integer.valueOf(aq.htn.hashCode()), Integer.valueOf(i), str2);
        IllegalStateException illegalStateException;
        if (i != aq.htn.hashCode()) {
            C45124d.m82927e("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject runtime hashCode mismatch");
            if (C5058f.IS_FLAVOR_RED || C5058f.DEBUG) {
                illegalStateException = new IllegalStateException("[RED_FLAVOR_ONLY] [APPBRAND] onUserScriptInject runtime hashCode mismatch");
                AppMethodBeat.m2505o(132682);
                throw illegalStateException;
            }
            AppMethodBeat.m2505o(132682);
        } else if (aq.htn.atK() == null) {
            C45124d.m82927e("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject getService == null");
            if (C5058f.IS_FLAVOR_RED || C5058f.DEBUG) {
                illegalStateException = new IllegalStateException("[RED_FLAVOR_ONLY] [APPBRAND] onUserScriptInject getService == null");
                AppMethodBeat.m2505o(132682);
                throw illegalStateException;
            }
            AppMethodBeat.m2505o(132682);
        } else {
            int length = str3.length();
            C1591bx c1591bx = new C1591bx();
            QualitySessionRuntime aq2 = C27285a.m43323aq(str, true);
            if (aq2 != null) {
                c1591bx.mo5026gC(aq2.appId);
                c1591bx.mo5025gB(aq2.igT);
                c1591bx.deo = C1592a.m3224gY(aq2.iCZ);
                c1591bx.ddz = (long) aq2.apptype;
                c1591bx.ddd = (long) aq2.iDa;
                c1591bx.cVR = (long) aq2.scene;
                c1591bx.mo5024dN(j);
                c1591bx.mo5022GZ();
                c1591bx.mo5023dM(c1591bx.ddC - j);
                c1591bx.dep = (long) length;
                c1591bx.mo5027gD(str2);
                c1591bx.ajK();
            }
            if (!aq.iDg.iCG && (str2.endsWith("app-service.js") || "game.js".equals(str2))) {
                aq.iDg.iCG = true;
                C41243o c41243o = aq.htn;
                C1593by c1593by = new C1593by();
                QualitySessionRuntime aq3 = C27285a.m43323aq(str, true);
                if (aq3 != null) {
                    long j2;
                    C1593by c1593by2;
                    c1593by.mo5032gF(aq3.appId);
                    c1593by.mo5031gE(aq3.igT);
                    c1593by.dev = C1594a.m3234gZ(aq3.iCZ);
                    c1593by.ddz = (long) aq3.apptype;
                    c1593by.ddd = (long) aq3.iDa;
                    c1593by.cVR = (long) aq3.scene;
                    c1593by.mo5030dP(aq3.iDb);
                    c1593by.mo5028Ha();
                    c1593by.mo5029dO(c1593by.ddC - aq3.iDb);
                    try {
                        c1593by.mo5033gG(C18178q.encode(c41243o.atJ().getCurrentUrl()));
                    } catch (NullPointerException e) {
                        C4990ab.m7413e("MicroMsg.AppBrandQualitySystem", "launchToJsInject appId %s getCurrentUrl npe = %s", str, e);
                    }
                    if (c41243o.gPs) {
                        j2 = 1;
                    } else {
                        j2 = 0;
                    }
                    c1593by.ddj = j2;
                    if (aq3.iDe != null) {
                        if (aq3.iDe.aHk()) {
                            j2 = 1;
                        } else {
                            j2 = 0;
                        }
                        c1593by.dew = j2;
                    } else if (C5058f.DEBUG) {
                        illegalStateException = new IllegalStateException("StartupBundle not registered.");
                        AppMethodBeat.m2505o(132682);
                        throw illegalStateException;
                    }
                    if (aq3.iDj) {
                        j2 = 2;
                        c1593by2 = c1593by;
                    } else if (c41243o.atK().gPH) {
                        j2 = 1;
                        c1593by2 = c1593by;
                    } else {
                        j2 = 0;
                        c1593by2 = c1593by;
                    }
                    c1593by2.ddg = j2;
                    c1593by.mo5034gH(C42674j.m75576cW(C4996ah.getContext()));
                    c1593by.ajK();
                }
            }
            AppMethodBeat.m2505o(132682);
        }
    }

    /* renamed from: p */
    static /* synthetic */ void m43325p(C41243o c41243o) {
        AppMethodBeat.m2504i(132683);
        String str = c41243o.mAppId;
        if (!TextUtils.isEmpty(str)) {
            QualitySessionRuntime aq = C27285a.m43323aq(str, false);
            if (aq != null && aq.htn == c41243o) {
                aq.iDh.destroy();
                synchronized (iCD) {
                    try {
                        iCD.put(str, null);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(132683);
                    }
                }
                return;
            }
        }
        AppMethodBeat.m2505o(132683);
    }
}
