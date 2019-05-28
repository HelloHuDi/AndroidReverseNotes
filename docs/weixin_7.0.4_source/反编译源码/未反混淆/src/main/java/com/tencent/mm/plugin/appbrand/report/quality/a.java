package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.b.a.bx;
import com.tencent.mm.g.b.a.by;
import com.tencent.mm.g.b.a.bz;
import com.tencent.mm.g.b.a.cj;
import com.tencent.mm.g.b.a.cj.b;
import com.tencent.mm.g.b.a.cl;
import com.tencent.mm.plugin.appbrand.appcache.PartialFile;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class a {
    static final /* synthetic */ boolean $assertionsDisabled = (!a.class.desiredAssertionStatus());
    private static final b iCC = new b();
    private static final HashMap<String, QualitySessionRuntime> iCD = new HashMap();

    public static class a {
        boolean iCG = false;
    }

    static {
        AppMethodBeat.i(132684);
        AppMethodBeat.o(132684);
    }

    public static void o(final o oVar) {
        AppMethodBeat.i(132677);
        d.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] startSession appId = [%s] runtime.hashCode = [%d]", oVar.mAppId, Integer.valueOf(oVar.hashCode()));
        QualitySession qualitySession = oVar.atI().hgN;
        if (qualitySession == null) {
            d.e("MicroMsg.AppBrandQualitySystem", "startSession with NULL qualityReportSession in InitConfig");
            qualitySession = new QualitySession(g.pM(oVar.atI().uin), oVar.atI(), oVar.ya().bQn);
            oVar.atI().hgN = qualitySession;
        }
        QualitySessionRuntime c = g.c(qualitySession);
        c.htn = oVar;
        c.hrs = oVar.xy();
        c.iDc = System.currentTimeMillis();
        synchronized (iCD) {
            try {
                if ($assertionsDisabled || iCD.get(oVar.mAppId) == null) {
                    iCD.put(c.appId, c);
                } else {
                    Object assertionError = new AssertionError();
                    throw assertionError;
                }
            } finally {
                AppMethodBeat.o(132677);
            }
        }
        g.a(oVar.mAppId, new c() {
            public final void onDestroy() {
                AppMethodBeat.i(132675);
                d.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] closeSession appId = [%s] runtime.hashCode = [%d]", oVar.mAppId, Integer.valueOf(oVar.hashCode()));
                a.p(oVar);
                AppMethodBeat.o(132675);
            }
        });
        AppMethodBeat.o(132677);
    }

    public static QualitySessionRuntime DG(String str) {
        AppMethodBeat.i(132678);
        QualitySessionRuntime aq = aq(str, true);
        AppMethodBeat.o(132678);
        return aq;
    }

    private static QualitySessionRuntime aq(String str, boolean z) {
        QualitySessionRuntime qualitySessionRuntime;
        AppMethodBeat.i(132679);
        synchronized (iCD) {
            try {
                qualitySessionRuntime = (QualitySessionRuntime) iCD.get(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(132679);
                }
            }
        }
        if (qualitySessionRuntime == null) {
            String format = String.format(Locale.US, "QualitySession not open. appId=%s", new Object[]{str});
            if (z && (f.DEBUG || f.IS_FLAVOR_RED)) {
                IllegalStateException illegalStateException = new IllegalStateException(format);
                AppMethodBeat.o(132679);
                throw illegalStateException;
            }
            d.printErrStackTrace("MicroMsg.AppBrandQualitySystem", new Throwable(), format, new Object[0]);
        }
        AppMethodBeat.o(132679);
        return qualitySessionRuntime;
    }

    public static b aLz() {
        return iCC;
    }

    public static void a(String str, final AppBrandSysConfigWC appBrandSysConfigWC, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle, o oVar) {
        long j = 0;
        AppMethodBeat.i(132680);
        final QualitySessionRuntime aq = aq(str, true);
        if (aq == null) {
            AppMethodBeat.o(132680);
            return;
        }
        aq.iDd = System.currentTimeMillis();
        aq.iDe = appStartupPerformanceReportBundle;
        aq.iDb = oVar.atI().startTime;
        AppStartupPerformanceReportBundle appStartupPerformanceReportBundle2 = (AppStartupPerformanceReportBundle) oVar.c(AppStartupPerformanceReportBundle.class, false);
        if (appStartupPerformanceReportBundle2 == null) {
            ab.e("MicroMsg.AppBrandQualitySystem", "ReportBundle == null in resourceReady");
        } else {
            cj cjVar = new cj();
            QualitySessionRuntime aq2 = aq(str, true);
            if (aq2 != null) {
                cj.c cVar;
                b bVar;
                long j2;
                cjVar.hi(aq2.appId);
                cjVar.hh(aq2.igT);
                cjVar.dgv = com.tencent.mm.g.b.a.cj.a.hk(aq2.iCZ);
                cjVar.ddz = (long) aq2.apptype;
                cjVar.cVR = (long) aq2.scene;
                cjVar.ddd = (long) aq2.iDa;
                cjVar.eq(oVar.atI().startTime);
                cjVar.Hg();
                cjVar.ep(cjVar.ddC - oVar.atI().startTime);
                AppBrandSysConfigWC atH = oVar.atH();
                AppBrandInitConfigWC atI = oVar.atI();
                if (appStartupPerformanceReportBundle2.igW) {
                    cVar = cj.c.sync;
                } else {
                    cVar = cj.c.unsync;
                }
                cjVar.dgx = cVar;
                if (atI.hgO) {
                    bVar = b.sync;
                } else {
                    bVar = b.unsync;
                }
                cjVar.dgy = bVar;
                if (oVar.gPs) {
                    j2 = 1;
                } else {
                    j2 = 0;
                }
                cjVar.dgz = j2;
                if (oVar.gPs) {
                    File file = new File(atH.hhd.gSP);
                    if (file.isFile() && file.canRead()) {
                        j = file.length();
                    }
                }
                cjVar.dgw = j;
                cjVar.cXm = (long) g.getNetworkType();
                cjVar.ajK();
            }
        }
        m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132676);
                if (aq.htn.mFinished) {
                    AppMethodBeat.o(132676);
                    return;
                }
                e eVar = aq.iDh;
                QualitySessionRuntime qualitySessionRuntime = aq;
                AppBrandSysConfigWC appBrandSysConfigWC = appBrandSysConfigWC;
                d.i("MicroMsg.AppBrandRuntimeEventReporter", "AppBrandRuntimeEventReporter.mayStart");
                d.i("MicroMsg.AppBrandRuntimeEventReporter", "shouldEnableReport() returned: [%b], localRandom = [%f] serverPercent = [%f]", Boolean.valueOf(new Random(((long) qualitySessionRuntime.htn.atI().uin) ^ System.nanoTime()).nextDouble() <= appBrandSysConfigWC.bQO.hgc), Double.valueOf(new Random(((long) qualitySessionRuntime.htn.atI().uin) ^ System.nanoTime()).nextDouble()), Double.valueOf(appBrandSysConfigWC.bQO.hgc));
                if (new Random(((long) qualitySessionRuntime.htn.atI().uin) ^ System.nanoTime()).nextDouble() <= appBrandSysConfigWC.bQO.hgc) {
                    synchronized (eVar) {
                        try {
                            eVar.iCK = qualitySessionRuntime;
                            if (eVar.handler == null) {
                                eVar.handler = new Handler(Looper.getMainLooper());
                                eVar.iCJ.ciy = (long) (appBrandSysConfigWC.bQO.hgd * 1000);
                                eVar.handler.post(eVar.iCJ);
                            }
                            if (!qualitySessionRuntime.hrs) {
                                eVar.iCL = new com.tencent.mm.plugin.appbrand.performance.f();
                                eVar.iCL.mInterval = 200;
                                eVar.iCL.ivJ = null;
                                eVar.iCL.start();
                            }
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(132676);
                        }
                    }
                    return;
                }
                AppMethodBeat.o(132676);
            }
        });
        AppMethodBeat.o(132680);
    }

    public static void a(String str, o oVar) {
        AppMethodBeat.i(132681);
        if (aq(str, true) == null) {
            AppMethodBeat.o(132681);
            return;
        }
        long j;
        bz bzVar = new bz();
        QualitySessionRuntime aq = aq(str, true);
        if (aq != null) {
            bz bzVar2;
            bzVar.gJ(aq.appId);
            bzVar.gI(aq.igT);
            bzVar.deC = com.tencent.mm.g.b.a.bz.a.ha(aq.iCZ);
            bzVar.ddz = (long) aq.apptype;
            bzVar.ddd = (long) aq.iDa;
            bzVar.cVR = (long) aq.scene;
            bzVar.dR(oVar.atI().startTime);
            bzVar.Hb();
            bzVar.dQ(bzVar.ddC - bzVar.ddB);
            try {
                bzVar.gK(q.encode(oVar.atJ().getCurrentUrl()));
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrandQualitySystem", "launchToInitReady appId %s getCurrentUrl npe = %s", str, e);
            }
            if (oVar.gPs) {
                j = 1;
            } else {
                j = 0;
            }
            bzVar.ddj = j;
            if (aq.iDe != null) {
                if (aq.iDe.aHk()) {
                    j = 1;
                } else {
                    j = 0;
                }
                bzVar.dew = j;
            } else if (f.DEBUG) {
                IllegalStateException illegalStateException = new IllegalStateException("StartupBundle not registered.");
                AppMethodBeat.o(132681);
                throw illegalStateException;
            }
            if (aq.iDj) {
                j = 2;
                bzVar2 = bzVar;
            } else if (oVar.atK().gPH) {
                j = 1;
                bzVar2 = bzVar;
            } else {
                j = 0;
                bzVar2 = bzVar;
            }
            bzVar2.ddg = j;
            bzVar.deD = 0;
            bzVar.gL(j.cW(ah.getContext()));
            PartialFile[] partialFileArr = oVar.atH().hhd.gSR;
            if (!r.avH() || partialFileArr == null || partialFileArr.length <= 0) {
                bzVar.deE = 0;
            } else {
                bzVar.deE = 1;
            }
            bzVar.ajK();
        }
        cl clVar = new cl();
        QualitySessionRuntime aq2 = aq(str, true);
        if (aq2 != null) {
            clVar.hm(aq2.appId);
            clVar.hl(aq2.igT);
            clVar.dgQ = com.tencent.mm.g.b.a.cl.a.hm(aq2.iCZ);
            clVar.ddz = (long) aq2.apptype;
            clVar.ddd = (long) aq2.iDa;
            clVar.cVR = (long) aq2.scene;
            clVar.eu(aq2.iDd);
            clVar.Hi();
            clVar.et(clVar.ddC - aq2.iDd);
            if (aq2.iDj) {
                clVar.ddg = 2;
            } else {
                if (oVar.atK().gPH) {
                    j = 1;
                } else {
                    j = 0;
                }
                clVar.ddg = j;
            }
            try {
                clVar.hn(q.encode(oVar.atJ().getCurrentUrl()));
            } catch (Exception e2) {
            }
            clVar.deD = 0;
            clVar.ho(j.cW(ah.getContext()));
            clVar.ajK();
        }
        AppMethodBeat.o(132681);
    }

    public static void a(String str, String str2, String str3, long j, int i) {
        AppMethodBeat.i(132682);
        QualitySessionRuntime aq = aq(str, true);
        if (aq == null) {
            AppMethodBeat.o(132682);
            return;
        }
        d.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject appId = [%s] session.runtime.hashCode = [%d] runtimeHashCode = [%d] name = [%s].", str, Integer.valueOf(aq.htn.hashCode()), Integer.valueOf(i), str2);
        IllegalStateException illegalStateException;
        if (i != aq.htn.hashCode()) {
            d.e("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject runtime hashCode mismatch");
            if (f.IS_FLAVOR_RED || f.DEBUG) {
                illegalStateException = new IllegalStateException("[RED_FLAVOR_ONLY] [APPBRAND] onUserScriptInject runtime hashCode mismatch");
                AppMethodBeat.o(132682);
                throw illegalStateException;
            }
            AppMethodBeat.o(132682);
        } else if (aq.htn.atK() == null) {
            d.e("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject getService == null");
            if (f.IS_FLAVOR_RED || f.DEBUG) {
                illegalStateException = new IllegalStateException("[RED_FLAVOR_ONLY] [APPBRAND] onUserScriptInject getService == null");
                AppMethodBeat.o(132682);
                throw illegalStateException;
            }
            AppMethodBeat.o(132682);
        } else {
            int length = str3.length();
            bx bxVar = new bx();
            QualitySessionRuntime aq2 = aq(str, true);
            if (aq2 != null) {
                bxVar.gC(aq2.appId);
                bxVar.gB(aq2.igT);
                bxVar.deo = com.tencent.mm.g.b.a.bx.a.gY(aq2.iCZ);
                bxVar.ddz = (long) aq2.apptype;
                bxVar.ddd = (long) aq2.iDa;
                bxVar.cVR = (long) aq2.scene;
                bxVar.dN(j);
                bxVar.GZ();
                bxVar.dM(bxVar.ddC - j);
                bxVar.dep = (long) length;
                bxVar.gD(str2);
                bxVar.ajK();
            }
            if (!aq.iDg.iCG && (str2.endsWith("app-service.js") || "game.js".equals(str2))) {
                aq.iDg.iCG = true;
                o oVar = aq.htn;
                by byVar = new by();
                QualitySessionRuntime aq3 = aq(str, true);
                if (aq3 != null) {
                    long j2;
                    by byVar2;
                    byVar.gF(aq3.appId);
                    byVar.gE(aq3.igT);
                    byVar.dev = com.tencent.mm.g.b.a.by.a.gZ(aq3.iCZ);
                    byVar.ddz = (long) aq3.apptype;
                    byVar.ddd = (long) aq3.iDa;
                    byVar.cVR = (long) aq3.scene;
                    byVar.dP(aq3.iDb);
                    byVar.Ha();
                    byVar.dO(byVar.ddC - aq3.iDb);
                    try {
                        byVar.gG(q.encode(oVar.atJ().getCurrentUrl()));
                    } catch (NullPointerException e) {
                        ab.e("MicroMsg.AppBrandQualitySystem", "launchToJsInject appId %s getCurrentUrl npe = %s", str, e);
                    }
                    if (oVar.gPs) {
                        j2 = 1;
                    } else {
                        j2 = 0;
                    }
                    byVar.ddj = j2;
                    if (aq3.iDe != null) {
                        if (aq3.iDe.aHk()) {
                            j2 = 1;
                        } else {
                            j2 = 0;
                        }
                        byVar.dew = j2;
                    } else if (f.DEBUG) {
                        illegalStateException = new IllegalStateException("StartupBundle not registered.");
                        AppMethodBeat.o(132682);
                        throw illegalStateException;
                    }
                    if (aq3.iDj) {
                        j2 = 2;
                        byVar2 = byVar;
                    } else if (oVar.atK().gPH) {
                        j2 = 1;
                        byVar2 = byVar;
                    } else {
                        j2 = 0;
                        byVar2 = byVar;
                    }
                    byVar2.ddg = j2;
                    byVar.gH(j.cW(ah.getContext()));
                    byVar.ajK();
                }
            }
            AppMethodBeat.o(132682);
        }
    }

    static /* synthetic */ void p(o oVar) {
        AppMethodBeat.i(132683);
        String str = oVar.mAppId;
        if (!TextUtils.isEmpty(str)) {
            QualitySessionRuntime aq = aq(str, false);
            if (aq != null && aq.htn == oVar) {
                aq.iDh.destroy();
                synchronized (iCD) {
                    try {
                        iCD.put(str, null);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(132683);
                    }
                }
                return;
            }
        }
        AppMethodBeat.o(132683);
    }
}
