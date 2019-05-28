package com.tencent.mm.plugin.appbrand.launching;

import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.g.b.a.cg;
import com.tencent.mm.model.ai;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.e;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.arb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.j.d;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public final class g implements ILaunchWxaAppInfoNotify {
    private static final android.support.v4.f.a<String, g> igC = new android.support.v4.f.a();
    private static final d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> igQ = com.tencent.mm.vending.j.a.i(null, null, null);
    final String appId;
    final int cDB;
    final int cOq;
    final int har;
    final String hgC;
    final AppBrandLaunchReferrer hgF;
    private final QualitySession hgN;
    volatile b igD;
    volatile boolean igE;
    volatile d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> igF;
    volatile long igG;
    final String igH;
    final int igI;
    private volatile e igJ;
    private final AppStartupPerformanceReportBundle igK;
    private final List<kv_14609> igL;
    private final c<iz> igM;
    private final List<cg> igN;
    private final c<vx> igO;
    private final c<vy> igP;
    volatile boolean started;
    final String username;

    interface b extends j {
        void a(AppBrandSysConfigWC appBrandSysConfigWC, AppBrandLaunchErrorAction appBrandLaunchErrorAction, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle);

        void aHe();

        void atT();

        void onDownloadProgress(int i);
    }

    static final class a extends ap {
        public a(final String str) {
            super(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(131785);
                    h.pYm.k(369, 23, 1);
                    g.Cg(str);
                    AppMethodBeat.o(131785);
                    return false;
                }
            }, false);
            AppMethodBeat.i(131786);
            AppMethodBeat.o(131786);
        }
    }

    static {
        AppMethodBeat.i(131801);
        AppMethodBeat.o(131801);
    }

    static g Cg(String str) {
        g gVar;
        AppMethodBeat.i(131787);
        synchronized (igC) {
            try {
                gVar = (g) igC.remove(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(131787);
                }
            }
        }
        if (gVar != null) {
            ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "pollProcess appId(%s) type(%d) sessionId(%s)", gVar.appId, Integer.valueOf(gVar.har), str);
        }
        AppMethodBeat.o(131787);
        return gVar;
    }

    static g Ch(String str) {
        g gVar;
        AppMethodBeat.i(131788);
        synchronized (igC) {
            try {
                gVar = (g) igC.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(131788);
            }
        }
        return gVar;
    }

    public g(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        this(appBrandInitConfigWC.username, appBrandInitConfigWC.appId, appBrandInitConfigWC.gVs, appBrandStatObject.cOq, appBrandStatObject.scene, appBrandInitConfigWC.hgC, appBrandInitConfigWC.hgF, appBrandInitConfigWC.xz(), -1, appBrandInitConfigWC.hgN);
        AppMethodBeat.i(131789);
        if (appBrandInitConfigWC.xy()) {
            s.xp(appBrandInitConfigWC.appId);
        }
        AppMethodBeat.o(131789);
    }

    public g(String str, String str2, int i, int i2, int i3, String str3, AppBrandLaunchReferrer appBrandLaunchReferrer, String str4, int i4, QualitySession qualitySession) {
        AppMethodBeat.i(131790);
        this.igG = -1;
        this.igL = new CopyOnWriteArrayList();
        this.igM = new c<iz>() {
            {
                AppMethodBeat.i(131772);
                this.xxI = iz.class.getName().hashCode();
                AppMethodBeat.o(131772);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(131773);
                iz izVar = (iz) bVar;
                if (g.this.appId.equals(izVar.cEe.cEf.appId) && g.this.igJ.axy == izVar.cEe.cEf.ihB) {
                    g.this.igL.add(izVar.cEe.cEf);
                    AppMethodBeat.o(131773);
                    return true;
                } else if (izVar.cEe.cEf.cBc == 14) {
                    g.this.igL.add(izVar.cEe.cEf);
                    AppMethodBeat.o(131773);
                    return true;
                } else {
                    AppMethodBeat.o(131773);
                    return false;
                }
            }
        };
        this.igN = new CopyOnWriteArrayList();
        this.igO = new c<vx>() {
            {
                AppMethodBeat.i(131774);
                this.xxI = vx.class.getName().hashCode();
                AppMethodBeat.o(131774);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(131775);
                vx vxVar = (vx) bVar;
                if (g.this.appId.equals(((arb) vxVar.cTe.cTf.ehh.fsG.fsP).csB) && g.this.igJ.axy == ((arb) vxVar.cTe.cTf.ehh.fsG.fsP).vOP && (vxVar.cTe.cTf.avn() == 0 || vxVar.cTe.cTf.avn() == 4)) {
                    com.tencent.mm.g.b.a.cg.b bVar2;
                    cg cgVar = new cg();
                    cgVar.dfQ = com.tencent.mm.g.b.a.cg.a.release;
                    cgVar.ee(vxVar.cTe.bZJ - vxVar.cTe.cTh);
                    cgVar.ef(vxVar.cTe.cTh);
                    cgVar.eg(vxVar.cTe.bZJ);
                    if (com.tencent.mm.plugin.appbrand.k.a.b(vxVar.cTe.cTg)) {
                        bVar2 = com.tencent.mm.g.b.a.cg.b.ok;
                    } else {
                        bVar2 = com.tencent.mm.g.b.a.cg.b.common_fail;
                    }
                    cgVar.dfR = bVar2;
                    cgVar.cXm = (long) com.tencent.mm.plugin.appbrand.report.quality.g.getNetworkType();
                    g.this.igN.add(cgVar);
                    AppMethodBeat.o(131775);
                    return true;
                }
                AppMethodBeat.o(131775);
                return false;
            }
        };
        this.igP = new c<vy>() {
            {
                AppMethodBeat.i(131776);
                this.xxI = vy.class.getName().hashCode();
                AppMethodBeat.o(131776);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(131777);
                vy vyVar = (vy) bVar;
                if (g.this.appId.equals(((aoy) vyVar.cTi.cTj.ehh.fsG.fsP).csB) && ((aoy) vyVar.cTi.cTj.ehh.fsG.fsP).vSb == g.this.har) {
                    com.tencent.mm.g.b.a.cg.b bVar2;
                    cg cgVar = new cg();
                    cgVar.dfQ = com.tencent.mm.g.b.a.cg.a.hg(g.this.har + 1);
                    cgVar.ee(vyVar.cTi.bZJ - vyVar.cTi.cTh);
                    cgVar.ef(vyVar.cTi.cTh);
                    cgVar.eg(vyVar.cTi.bZJ);
                    if (com.tencent.mm.plugin.appbrand.k.a.b(vyVar.cTi.cTg)) {
                        bVar2 = com.tencent.mm.g.b.a.cg.b.ok;
                    } else {
                        bVar2 = com.tencent.mm.g.b.a.cg.b.common_fail;
                    }
                    cgVar.dfR = bVar2;
                    cgVar.cXm = (long) com.tencent.mm.plugin.appbrand.report.quality.g.getNetworkType();
                    g.this.igN.add(cgVar);
                    AppMethodBeat.o(131777);
                    return true;
                }
                AppMethodBeat.o(131777);
                return false;
            }
        };
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
        AppMethodBeat.o(131790);
    }

    /* Access modifiers changed, original: final */
    public final void a(d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> dVar) {
        AppMethodBeat.i(131791);
        this.igF = dVar;
        if (this.igD != null) {
            this.igD.a((AppBrandSysConfigWC) dVar.get(0), (AppBrandLaunchErrorAction) dVar.get(1), (AppStartupPerformanceReportBundle) dVar.get(2));
            Cg(this.igH);
        }
        AppMethodBeat.o(131791);
    }

    public final void a(String str, int i, String str2, aa aaVar) {
        AppMethodBeat.i(131792);
        if (this.igF != null) {
            a aVar = AppBrandLaunchErrorAction.CREATOR;
            AppBrandLaunchErrorAction a = a.a(this.appId, this.har, aaVar);
            if (a != null) {
                this.igF = com.tencent.mm.vending.j.a.i(null, a, this.igK);
                AppMethodBeat.o(131792);
                return;
            }
            AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) this.igF.get(0);
            if (appBrandSysConfigWC == null) {
                ab.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyLaunchInfoUpdate null config with appId(%s)", str);
                AppMethodBeat.o(131792);
                return;
            }
            aaVar.a(appBrandSysConfigWC);
            this.igF = com.tencent.mm.vending.j.a.i(appBrandSysConfigWC, null, this.igK);
        }
        AppMethodBeat.o(131792);
    }

    public final void aHd() {
        AppMethodBeat.i(131793);
        if (this.started) {
            AppMethodBeat.o(131793);
            return;
        }
        this.started = true;
        ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] startPrepare in mm %s %d", this.appId, Integer.valueOf(this.har));
        synchronized (igC) {
            try {
                igC.put(this.igH, this);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(131793);
            }
        }
        a aVar = new a(this.igH);
        long toMillis = TimeUnit.SECONDS.toMillis(300);
        aVar.ae(toMillis, toMillis);
        final HandlerThread anM = com.tencent.mm.sdk.g.d.anM(String.format(Locale.US, "AppLaunchPrepareProcess[%s %d]", new Object[]{this.appId, Integer.valueOf(this.har)}));
        anM.start();
        new ak(anM.getLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(131778);
                try {
                    g.a(g.this, g.this.aHf());
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", e, "call() exp ", new Object[0]);
                    ag.oZ(R.string.kn);
                    g.a(g.this, g.igQ);
                }
                anM.quit();
                AppMethodBeat.o(131778);
            }
        });
    }

    /* Access modifiers changed, original: final */
    public final void aHg() {
        AppMethodBeat.i(131795);
        if (this.igD != null) {
            this.igD.onDownloadProgress(100);
        }
        AppMethodBeat.o(131795);
    }

    private void aHh() {
        AppMethodBeat.i(131796);
        ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferData   callback != null " + (this.igD != null));
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.i(131784);
                ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transfer task cost more than 5000");
                if (g.this.igD != null) {
                    g.this.igD.nm(3);
                    ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_OVER_THRESHOLD ");
                }
                AppMethodBeat.o(131784);
            }
        }, 5000);
        if (this.igD != null) {
            this.igD.nm(1);
            ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_START ");
        }
        ai[] aiVarArr = new ai[]{new com.tencent.mm.plugin.appbrand.appstorage.c(this.appId)};
        for (int i = 0; i <= 0; i++) {
            ai aiVar = aiVarArr[0];
            if (aiVar.kw(com.tencent.mm.protocal.d.vxo)) {
                aiVar.transfer(com.tencent.mm.protocal.d.vxo);
            }
        }
        timer.cancel();
        if (this.igD != null) {
            this.igD.nm(2);
            ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_FINISH ");
        }
        AppMethodBeat.o(131796);
    }

    public final d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> aHf() {
        AppMethodBeat.i(131794);
        AppBrandSysConfigWC zj = p.zj(this.appId);
        if (zj == null) {
            ag.Ck(com.tencent.mm.plugin.appbrand.s.e.getMMString(R.string.m9, ""));
        }
        if (zj == null) {
            ab.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "get null config!!!");
            d dVar = igQ;
            AppMethodBeat.o(131794);
            return dVar;
        }
        Object obj;
        ((k) f.E(k.class)).x(p.zo(this.appId), bo.anT());
        j jVar = new j();
        WxaAttributes e = f.auO().e(this.appId, "versionInfo", "appInfo");
        this.igM.dnU();
        if (this.har == 0) {
            this.igO.dnU();
        } else {
            this.igP.dnU();
        }
        this.igJ = e.ayL();
        AnonymousClass5 anonymousClass5 = new ai(zj.appId, this.har, this.hgC, this.cDB, e) {
            public final void aHe() {
                AppMethodBeat.i(131779);
                g.d(g.this);
                AppMethodBeat.o(131779);
            }

            public final void aHj() {
                AppMethodBeat.i(131780);
                g.e(g.this);
                AppMethodBeat.o(131780);
            }

            public final void onDownloadProgress(int i) {
                AppMethodBeat.i(131781);
                if (g.this.igD != null) {
                    g.this.igD.onDownloadProgress(i);
                }
                AppMethodBeat.o(131781);
            }
        };
        FutureTask futureTask = new FutureTask(anonymousClass5);
        com.tencent.mm.sdk.g.d.xDG.a(futureTask, anonymousClass5.getTag(), new com.tencent.mm.plugin.appbrand.launching.af.AnonymousClass1(futureTask));
        aa aaVar = (aa) new aj(this.appId, this.har, this.cOq, this.cDB, this.hgC, this.hgF, this.igH, this.igI, this.hgN) {
            /* Access modifiers changed, original: final */
            public final void atT() {
                AppMethodBeat.i(131782);
                g.f(g.this);
                AppMethodBeat.o(131782);
            }
        }.aHy();
        if (aaVar == null) {
            ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null launchInfo", this.username, this.appId);
            obj = null;
        } else {
            a aVar = AppBrandLaunchErrorAction.CREATOR;
            AppBrandLaunchErrorAction a = a.a(this.appId, this.har, aaVar);
            if (a != null) {
                jVar.value = a;
                ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, launch ban code %d", this.username, this.appId, Integer.valueOf(aaVar.field_launchAction.vAS));
                obj = null;
            } else {
                this.igK.igW = aaVar.ihY;
                if (aaVar.field_jsapiInfo == null || aaVar.field_jsapiInfo.vYw == null) {
                    ab.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null jsapi_info", this.username, this.appId);
                    obj = null;
                } else {
                    aaVar.a(zj);
                    if (aaVar.field_launchAction.wBv) {
                        com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
                        zj.bQr = !com.tencent.mm.kernel.g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_RECENT_BAR_HAS_BEEN_REVEALED_BY_FIRST_APP_LAUNCH_BOOLEAN, false);
                        com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_RECENT_BAR_HAS_BEEN_REVEALED_BY_FIRST_APP_LAUNCH_BOOLEAN, Boolean.TRUE);
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
                        ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig null app pkg, username %s appId %s", this.username, this.appId);
                        obj = null;
                    } else {
                        zj.hhd.a(wxaPkgWrappingInfo);
                        if (zj.hhd.gVt != 0) {
                            zj.hhd.gVu = 0;
                        }
                        ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, app pkg %s", this.username, zj.appId, zj.hhd);
                        zj.bQO = AppBrandGlobalSystemConfig.ayC();
                        zj.bQP = f.xH().get("key_sendtodesktop_no_more_show_permission_notify_dialog", AppEventsConstants.EVENT_PARAM_VALUE_NO).equals("1");
                        com.tencent.mm.plugin.appbrand.i.f fVar = com.tencent.mm.plugin.appbrand.i.f.inF;
                        Long cF = com.tencent.mm.plugin.appbrand.i.f.cF(this.appId, "copypath");
                        zj.bQN = cF == null ? 0 : cF.longValue();
                        ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "copyPathMenuShowExpireTime = " + zj.bQN);
                        com.tencent.mm.sdk.g.d.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(131783);
                                String[] zl = p.zl(g.this.username);
                                if (zl != null && zl.length > 0) {
                                    for (String pC : zl) {
                                        com.tencent.mm.modelappbrand.a.b.abR().pC(pC);
                                    }
                                }
                                if (com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
                                    com.tencent.mm.kernel.g.RO().eJo.a(new com.tencent.mm.ba.k(12), 0);
                                }
                                AppMethodBeat.o(131783);
                            }
                        }, "AppLaunchPrepareProcess#ExtraWorks");
                        ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig ok username %s, appId %s", this.username, this.appId);
                        aHh();
                        com.tencent.mm.plugin.appbrand.appstorage.c.a aVar2 = com.tencent.mm.plugin.appbrand.appstorage.c.gXf;
                        zj.hhe = com.tencent.mm.plugin.appbrand.appstorage.c.a.xV(this.appId);
                        zj.hhf = com.tencent.mm.plugin.appbrand.appstorage.d.gXk.awJ();
                        obj = 1;
                    }
                }
            }
        }
        d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> i;
        if (obj == null) {
            ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, false, username %s, appId %s", this.username, this.appId);
            i = com.tencent.mm.vending.j.a.i(null, jVar.value, this.igK);
            AppMethodBeat.o(131794);
            return i;
        }
        ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, just go weapp, username %s, appId %s", this.username, this.appId);
        i = com.tencent.mm.vending.j.a.i(zj, null, this.igK);
        AppMethodBeat.o(131794);
        return i;
    }

    static /* synthetic */ void a(g gVar, d dVar) {
        boolean z;
        AppMethodBeat.i(131797);
        ab.v("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] onPrepareDone %s %d in mm process", gVar.appId, Integer.valueOf(gVar.har));
        gVar.a(dVar);
        com.tencent.mm.plugin.appbrand.config.h hVar = (com.tencent.mm.plugin.appbrand.config.h) dVar.get(0);
        String str = gVar.appId;
        int i = gVar.har;
        int i2 = gVar.cDB;
        if (hVar != null) {
            z = true;
        } else {
            z = false;
        }
        LaunchBroadCast.a(str, i, i2, z);
        AppMethodBeat.o(131797);
    }

    static /* synthetic */ void d(g gVar) {
        AppMethodBeat.i(131798);
        ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "preDownload, appId %s, versionType %d", gVar.appId, Integer.valueOf(gVar.har));
        gVar.igG = bo.anU();
        if (gVar.igD != null) {
            gVar.igD.aHe();
        }
        AppMethodBeat.o(131798);
    }

    static /* synthetic */ void e(g gVar) {
        AppMethodBeat.i(131799);
        ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "postDownload, appId %s, versionType %d", gVar.appId, Integer.valueOf(gVar.har));
        if (gVar.igD != null) {
            b bVar = gVar.igD;
        }
        AppMethodBeat.o(131799);
    }

    static /* synthetic */ void f(g gVar) {
        AppMethodBeat.i(131800);
        if (gVar.igD != null) {
            gVar.igD.atT();
        }
        AppMethodBeat.o(131800);
    }
}
