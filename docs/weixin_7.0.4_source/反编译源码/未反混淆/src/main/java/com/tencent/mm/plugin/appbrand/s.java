package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.graphics.Point;
import android.util.Pair;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.sdk.a.a.b;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.br;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.game.a;
import com.tencent.mm.plugin.appbrand.game.a.c;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.plugin.appbrand.h.m;
import com.tencent.mm.plugin.appbrand.h.n;
import com.tencent.mm.plugin.appbrand.h.q;
import com.tencent.mm.plugin.appbrand.h.s;
import com.tencent.mm.plugin.appbrand.h.t;
import com.tencent.mm.plugin.appbrand.h.v;
import com.tencent.mm.plugin.appbrand.h.z;
import com.tencent.mm.plugin.appbrand.j.g;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.report.model.e;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.s.l;
import com.tencent.mm.plugin.appbrand.s.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.udp.libmmudp.UdpNative;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public class s extends b implements g {
    protected o gOq;
    private volatile boolean gPO = false;
    private volatile boolean gPP = false;
    private volatile boolean gPQ = false;
    protected a gPR;
    private com.tencent.mm.plugin.appbrand.m.b.a gPS = null;
    private final LinkedList<Runnable> gPT = new LinkedList();

    static /* synthetic */ void b(s sVar) {
        AppMethodBeat.i(129113);
        sVar.aus();
        AppMethodBeat.o(129113);
    }

    public final /* synthetic */ u getCurrentPageView() {
        AppMethodBeat.i(129112);
        w aun = aun();
        AppMethodBeat.o(129112);
        return aun;
    }

    public /* synthetic */ com.tencent.luggage.sdk.b.b xL() {
        AppMethodBeat.i(129109);
        o runtime = getRuntime();
        AppMethodBeat.o(129109);
        return runtime;
    }

    public final /* synthetic */ com.tencent.luggage.sdk.a.a.a xV() {
        AppMethodBeat.i(129110);
        w aun = aun();
        AppMethodBeat.o(129110);
        return aun;
    }

    public s() {
        boolean z = false;
        AppMethodBeat.i(129083);
        if (bp.dpL() || f.IS_FLAVOR_RED) {
            z = true;
        }
        this.gNV = z;
        AppMethodBeat.o(129083);
    }

    /* Access modifiers changed, original: protected */
    public boolean aui() {
        AppMethodBeat.i(129084);
        boolean a = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_waservice_webgl_component, true);
        AppMethodBeat.o(129084);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final void auj() {
        AppMethodBeat.i(129085);
        String str = "MicroMsg.AppBrandService";
        String str2 = "setup magicbrush. loaded?[%b]";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.gPR != null);
        ab.i(str, str2, objArr);
        if (this.gPR != null) {
            AppMethodBeat.o(129085);
        } else if (aui()) {
            long yz = bo.yz();
            aCd();
            this.gPR = new a();
            aul();
            a aVar = this.gPR;
            Context context = getContext();
            IllegalStateException illegalStateException;
            if (aVar.hqf == null) {
                illegalStateException = new IllegalStateException("JsRuntime invalid");
                AppMethodBeat.o(129085);
                throw illegalStateException;
            } else if (aVar.hqg == null) {
                illegalStateException = new IllegalStateException("JsThreadHandler invalid");
                AppMethodBeat.o(129085);
                throw illegalStateException;
            } else {
                long j;
                aVar.hqi.device_pixel_ratio_ = (double) com.tencent.magicbrush.d.a.getDensity(context);
                Point aA = com.tencent.magicbrush.d.a.aA(context);
                aVar.hqi.screen_width_ = aA.x;
                aVar.hqi.screen_height_ = aA.y;
                aVar.hqi.use_command_buffer = aVar.hqd;
                aVar.hqi.adjust_thread_priority = aVar.hqc;
                aVar.hqi.enable_request_animation_frame = aVar.hqe;
                aVar.hqi.gc_factor = c.hqH.cD(context);
                aVar.hqi.enable_wxbindcanvastexture = com.tencent.mm.plugin.appbrand.game.a.f.aAE();
                aVar.hqb = new MBRuntime(aVar.hqi);
                if (aVar.hqh != null) {
                    aVar.hqb.registerEventListener(aVar.hqh);
                }
                aVar.hqb.registerEventListener(new a.b());
                aVar.hqb.setJsThreadHandler(aVar.hqg);
                aVar.hqb.init();
                aVar.hqg.f(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(129992);
                        if (a.this.hqb == null) {
                            AppMethodBeat.o(129992);
                            return;
                        }
                        synchronized (a.this) {
                            try {
                                if (a.this.hqb == null) {
                                } else if (a.this.hqf == null) {
                                    AppMethodBeat.o(129992);
                                } else {
                                    s sVar = (s) a.this.hqf.af(s.class);
                                    a.this.hqb.bindTo(sVar.getIsolatePtr(), sVar.aGW());
                                    AppMethodBeat.o(129992);
                                }
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.o(129992);
                            }
                        }
                    }
                });
                com.tencent.mm.plugin.appbrand.report.quality.a.aLz();
                boolean atU = atU();
                str = getAppId();
                br brVar = new br();
                if (!atU) {
                    QualitySessionRuntime DG = com.tencent.mm.plugin.appbrand.report.quality.a.DG(str);
                    if (DG != null) {
                        brVar.gq(DG.appId);
                        brVar.gp(DG.igT);
                        brVar.ddH = br.a.gS(DG.iCZ);
                        brVar.ddz = (long) DG.apptype;
                        brVar.cVR = (long) DG.scene;
                    }
                    ab.i("MicroMsg.AppBrandService", "setup magicbrush, done. cost?[%d]", Long.valueOf(bo.az(yz)));
                    AppMethodBeat.o(129085);
                }
                brVar.dA(yz);
                brVar.GX();
                brVar.dz(brVar.ddC - brVar.ddB);
                if (atU) {
                    j = 1;
                } else {
                    j = 0;
                }
                brVar.ddI = j;
                brVar.ajK();
                ab.i("MicroMsg.AppBrandService", "setup magicbrush, done. cost?[%d]", Long.valueOf(bo.az(yz)));
                AppMethodBeat.o(129085);
            }
        } else {
            ab.i("MicroMsg.AppBrandService", "setup magicbrush, done. expt closed");
            AppMethodBeat.o(129085);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(final i iVar) {
        AppMethodBeat.i(129086);
        ab.i("MicroMsg.AppBrandService", "createUdpBinding");
        if (UdpNative.instance().hasInit()) {
            ab.i("MicroMsg.AppBrandService", "createUdpBinding hasInit");
            AppMethodBeat.o(129086);
        } else if (iVar == null) {
            ab.e("MicroMsg.AppBrandService", "createUdpBinding jsruntime is null");
            AppMethodBeat.o(129086);
        } else {
            com.tencent.mm.udp.libmmudp.a.yB();
            final n nVar = (n) iVar.af(n.class);
            if (nVar == null) {
                ab.e("MicroMsg.AppBrandService", "createUdpBinding jsThreadHandler is null");
                AppMethodBeat.o(129086);
                return;
            }
            final AnonymousClass1 anonymousClass1 = new UdpNative.b() {
                public final void xe(final String str) {
                    AppMethodBeat.i(129064);
                    nVar.f(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(129063);
                            ab.i("MicroMsg.AppBrandService", "onCallBack apiName:%s", str);
                            UdpNative.instance().updateNativeInterface();
                            AppMethodBeat.o(129063);
                        }
                    });
                    AppMethodBeat.o(129064);
                }
            };
            nVar.f(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(129070);
                    ab.i("MicroMsg.AppBrandService", "createUdpBinding initBindingUdp");
                    com.tencent.mm.plugin.appbrand.h.s sVar = (com.tencent.mm.plugin.appbrand.h.s) iVar.af(com.tencent.mm.plugin.appbrand.h.s.class);
                    if (sVar == null) {
                        ab.e("MicroMsg.AppBrandService", "createUdpBinding v8Addon is null");
                        AppMethodBeat.o(129070);
                        return;
                    }
                    UdpNative.instance().initBindingUdp(sVar.getIsolatePtr(), sVar.aGW());
                    UdpNative.instance().InitCallBack(anonymousClass1);
                    AppMethodBeat.o(129070);
                }
            });
            AppMethodBeat.o(129086);
        }
    }

    /* Access modifiers changed, original: protected */
    public void auk() {
        AppMethodBeat.i(129087);
        if (this.gPR != null) {
            com.tencent.mm.plugin.appbrand.game.c.b.a(this.gPR.hqb, getRuntime(), false);
        }
        AppMethodBeat.o(129087);
    }

    /* Access modifiers changed, original: protected */
    public void aul() {
        AppMethodBeat.i(129088);
        if (this.gPR != null) {
            a aVar = this.gPR;
            i aBx = aBx();
            aVar.hqf = aBx;
            IllegalArgumentException illegalArgumentException;
            if (aBx.af(com.tencent.mm.plugin.appbrand.h.s.class) == null) {
                illegalArgumentException = new IllegalArgumentException("JsRuntime not support addon: V8");
                AppMethodBeat.o(129088);
                throw illegalArgumentException;
            } else if (aBx.af(n.class) == null) {
                illegalArgumentException = new IllegalArgumentException("JsRuntime not support addon: JsThread");
                AppMethodBeat.o(129088);
                throw illegalArgumentException;
            } else if (aBx.af(m.class) == null) {
                illegalArgumentException = new IllegalArgumentException("JsRuntime not support addon: DestroyListener");
                AppMethodBeat.o(129088);
                throw illegalArgumentException;
            } else {
                aVar.hqg = new a.c(aBx, (byte) 0);
            }
        }
        AppMethodBeat.o(129088);
    }

    public final MBRuntime aum() {
        MBRuntime mBRuntime = null;
        if (this.gPR == null) {
            return mBRuntime;
        }
        try {
            return this.gPR.hqb;
        } catch (NullPointerException e) {
            return mBRuntime;
        }
    }

    public final w aun() {
        AppMethodBeat.i(129089);
        w wVar = (w) super.ac(w.class);
        AppMethodBeat.o(129089);
        return wVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final w atY() {
        AppMethodBeat.i(129090);
        x xVar = new x(this);
        AppMethodBeat.o(129090);
        return xVar;
    }

    public i aua() {
        String aBv;
        byte[] Ec;
        com.tencent.mm.plugin.appbrand.task.g gVar = null;
        AppMethodBeat.i(129091);
        long currentTimeMillis = System.currentTimeMillis();
        if (getContext() == null) {
            ah.getContext();
        }
        if (((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_j2v8_codecache, false)) {
            aBv = z.aBv();
        } else {
            aBv = null;
        }
        if (((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_j2v8_snapshot, false)) {
            Ec = d.Ec("wxa_library/v8_snapshot.bin");
        } else {
            Ec = null;
        }
        int i = WxaCommLibRuntimeReader.avQ().gVu;
        ac.aux();
        i d = t.d(i, aBv, Ec);
        boolean z;
        if (d instanceof v) {
            this.gPS = new com.tencent.mm.plugin.appbrand.m.a();
            com.tencent.mm.plugin.appbrand.m.b.a aVar = this.gPS;
            ab.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCreateJsRuntime");
            aVar.iqc = new com.tencent.mm.plugin.appbrand.m.d(this, d);
            d.addJavascriptInterface(aVar.iqc, "gJavaBroker");
            z = true;
        } else {
            z = false;
        }
        q qVar = (q) d.af(q.class);
        if (qVar != null && (ac.aux() || z)) {
            f fVar = new f(this, qVar);
            d.addJavascriptInterface(fVar, "WeixinJSContext");
            fVar.asH();
            this.gPO = true;
        }
        a(d);
        com.tencent.mm.plugin.appbrand.report.quality.a.aLz();
        if (atU()) {
            gVar = com.tencent.mm.plugin.appbrand.task.g.WASERVICE;
        }
        com.tencent.mm.plugin.appbrand.report.quality.b.a(gVar, getAppId(), currentTimeMillis, com.tencent.mm.plugin.appbrand.report.a.d(d));
        AppMethodBeat.o(129091);
        return d;
    }

    public void cleanup() {
        AppMethodBeat.i(129092);
        if (this.gPR != null) {
            a aVar = this.gPR;
            ((m) aVar.hqf.af(m.class)).a(aVar.hqj);
        }
        i aBx = aBx();
        ab.i("MicroMsg.AppBrandService", "destoryUdpBinding");
        if (!UdpNative.instance().hasInit()) {
            ab.i("MicroMsg.AppBrandService", "destoryUdpBinding not Init");
        } else if (aBx == null) {
            ab.e("MicroMsg.AppBrandService", "destoryUdpBinding jsruntime is null");
        } else {
            n nVar = (n) aBx.af(n.class);
            if (nVar == null) {
                ab.e("MicroMsg.AppBrandService", "destoryUdpBinding jsThreadHandler is null");
            } else {
                nVar.f(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(129071);
                        ab.i("MicroMsg.AppBrandService", "destoryUdpBinding destoryUdp");
                        UdpNative.instance().destoryUdp();
                        AppMethodBeat.o(129071);
                    }
                });
            }
        }
        super.cleanup();
        this.gOq = null;
        if (this.gPS != null) {
            com.tencent.mm.plugin.appbrand.m.b.a aVar2 = this.gPS;
            ab.i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCleanUp");
            if (aVar2.iqc == null) {
                IllegalStateException illegalStateException = new IllegalStateException("You had not called whenCreateJsRuntime!");
                AppMethodBeat.o(129092);
                throw illegalStateException;
            }
            aVar2.iqc.aIS();
        }
        AppMethodBeat.o(129092);
    }

    public Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> aub() {
        AppMethodBeat.i(129093);
        Map aCh = com.tencent.mm.plugin.appbrand.jsapi.q.aCh();
        AppMethodBeat.o(129093);
        return aCh;
    }

    /* Access modifiers changed, original: protected */
    public void atV() {
        AppMethodBeat.i(129094);
        auj();
        a(aBx());
        auq();
        AppMethodBeat.o(129094);
    }

    /* Access modifiers changed, original: protected */
    public void aud() {
        AppMethodBeat.i(129095);
        super.aud();
        com.tencent.mm.plugin.appbrand.s.u.a(this.gOq, aBx());
        auo();
        if (this.gPH) {
            super.bo("onWxConfigReady", "");
        }
        AppMethodBeat.o(129095);
    }

    public void auo() {
    }

    /* Access modifiers changed, original: protected */
    public void wO() {
        AppMethodBeat.i(129096);
        try {
            aup();
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.AppBrandService", th, "[NOT CRASH]", new Object[0]);
        }
        aud();
        auq();
        aus();
        LinkedList linkedList = new LinkedList();
        synchronized (this.gPT) {
            try {
                linkedList.addAll(this.gPT);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(129096);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        atZ();
    }

    public void m(i iVar) {
        AppMethodBeat.i(129097);
        this.gOq = (o) iVar;
        super.m(iVar);
        this.hvM = new com.tencent.mm.plugin.appbrand.permission.a(this.gOq, this);
        auj();
        a(aBx());
        auk();
        try {
            aup();
            AppMethodBeat.o(129097);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.AppBrandService", th, "[NOT CRASH]", new Object[0]);
            AppMethodBeat.o(129097);
        }
    }

    /* Access modifiers changed, original: protected */
    public void aup() {
        AppMethodBeat.i(129098);
        i aBx = aBx();
        if (aBx == null) {
            AppMethodBeat.o(129098);
            return;
        }
        n nVar = (n) aBx.af(n.class);
        if (nVar != null) {
            nVar.setThreadPriority(-2);
        }
        AppMethodBeat.o(129098);
    }

    /* Access modifiers changed, original: protected|final */
    public final void atW() {
        AppMethodBeat.i(129099);
        ab.i("MicroMsg.AppBrandService", "dl: onRuntimePause, dispatch AppBrandOnAppEnterBackgroundEvent ");
        new h() {
            public final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.ah t(Map map) {
                AppMethodBeat.i(129073);
                p s = s(map);
                AppMethodBeat.o(129073);
                return s;
            }

            public final p s(Map<String, Object> map) {
                AppMethodBeat.i(129072);
                JSONObject jSONObject = new JSONObject(map);
                o runtime = s.this.getRuntime();
                try {
                    Pair l = e.l((w) runtime.asV().getCurrentPage().getCurrentPageView());
                    String str = (String) l.second;
                    jSONObject.put("targetAction", ((Integer) l.first).intValue());
                    jSONObject.put("targetPagePath", str);
                    jSONObject.put("usedState", runtime.ya().bQn.iAo);
                } catch (Exception e) {
                    ab.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterBackground ex = %s", e);
                }
                super.AL(jSONObject.toString());
                AppMethodBeat.o(129072);
                return this;
            }
        }.A(getRuntime());
        try {
            i aBx = aBx();
            if (aBx != null) {
                n nVar = (n) aBx.af(n.class);
                if (nVar != null) {
                    nVar.setThreadPriority(10);
                }
                AppMethodBeat.o(129099);
                return;
            }
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.AppBrandService", th, "[NOT CRASH]", new Object[0]);
        }
        AppMethodBeat.o(129099);
    }

    /* Access modifiers changed, original: protected */
    public void dw(final boolean z) {
        AppMethodBeat.i(129100);
        ab.i("MicroMsg.AppBrandService", "dl:onRuntimeResume, dispatch AppBrandOnAppEnterForegroundEvent");
        if (getRuntime() == null) {
            ab.w("MicroMsg.AppBrandService", "onRuntimeResume, getRuntime == NULL");
            AppMethodBeat.o(129100);
            return;
        }
        new com.tencent.mm.plugin.appbrand.page.i() {
            public final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.ah t(Map map) {
                AppMethodBeat.i(129075);
                p s = s(map);
                AppMethodBeat.o(129075);
                return s;
            }

            public final p s(Map<String, Object> map) {
                AppMethodBeat.i(129074);
                map.put("scene", Integer.valueOf(s.this.getRuntime().ya().bQn.scene));
                JSONObject xA = s.this.getRuntime().atI().xA();
                if (xA != null) {
                    map.put("shareInfo", xA);
                }
                JSONObject jSONObject = new JSONObject(map);
                o runtime = s.this.getRuntime();
                if (z) {
                    e.a(runtime, jSONObject);
                } else {
                    try {
                        e.b(runtime, jSONObject);
                        jSONObject.put("referpagepath", runtime.atJ().getReporter().aHX().aLo().iBm);
                        jSONObject.put("clickTimestamp", runtime.atI().startTime);
                    } catch (Exception e) {
                        ab.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterForeground ex = %s", e);
                    }
                }
                super.AL(jSONObject.toString());
                AppMethodBeat.o(129074);
                return this;
            }
        }.a(getRuntime(), z);
        try {
            aup();
            AppMethodBeat.o(129100);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.AppBrandService", th, "[NOT CRASH]", new Object[0]);
            AppMethodBeat.o(129100);
        }
    }

    public void h(JSONObject jSONObject) {
        AppMethodBeat.i(129101);
        super.h(jSONObject);
        b(jSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.vxo));
        if (getClass() == s.class) {
            b(jSONObject, "isIsolateContext", Boolean.valueOf(this.gPO));
        }
        b(jSONObject, "JSEngineName", t.b(aBx()));
        com.tencent.mm.plugin.appbrand.e.d.a(com.tencent.mm.plugin.appbrand.u.a.aSj(), jSONObject);
        com.tencent.mm.plugin.appbrand.e.d.b(com.tencent.mm.plugin.appbrand.u.a.aSk(), jSONObject);
        AppMethodBeat.o(129101);
    }

    public final JSONObject xW() {
        AppMethodBeat.i(129102);
        JSONObject xW = super.xW();
        i(xW);
        AppMethodBeat.o(129102);
        return xW;
    }

    /* Access modifiers changed, original: protected */
    public void i(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject jSONObject2;
        AppMethodBeat.i(129103);
        b(jSONObject, "debug", Boolean.valueOf(this.gOq.atH().bQp));
        JSONObject jSONObject3 = new JSONObject();
        b(jSONObject3, "scene", Integer.valueOf(this.gOq.ya().bQn.scene));
        String atc = this.gOq.atc();
        b(jSONObject3, "path", com.tencent.luggage.g.h.bO(atc));
        b(jSONObject3, SearchIntents.EXTRA_QUERY, new JSONObject(com.tencent.luggage.g.h.bP(atc)));
        b(jSONObject3, "referrerInfo", this.gOq.atI().hgF.ayF());
        b(jSONObject3, "shareInfo", this.gOq.atI().xA());
        e.a(this.gOq, jSONObject3);
        AppBrandSysConfigWC atH = this.gOq.atH();
        JSONObject jSONObject4 = new JSONObject();
        b(jSONObject4, "maxRequestConcurrent", Integer.valueOf(atH.bQw));
        b(jSONObject4, "maxUploadConcurrent", Integer.valueOf(atH.bQx));
        b(jSONObject4, "maxDownloadConcurrent", Integer.valueOf(atH.bQy));
        b(jSONObject4, "maxWebsocketConnect", Integer.valueOf(atH.bQz));
        b(jSONObject4, "maxWorkerConcurrent", Integer.valueOf(atH.bQA));
        try {
            optJSONObject = jSONObject.optJSONObject("env");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                jSONObject.put("env", optJSONObject);
                jSONObject2 = optJSONObject;
            } else {
                jSONObject2 = optJSONObject;
            }
            jSONObject2.put("USER_DATA_PATH", "wxfile://usr");
            jSONObject2.put("OPEN_DATA_PATH", "wxfile://opendata");
            jSONObject2.put("HAS_SPLASHSCREEN", ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_appbrand_game_splashscreen, false) ? 1 : 0);
        } catch (Exception e) {
        }
        b(jSONObject, "appLaunchInfo", jSONObject3);
        b(jSONObject, "wxAppInfo", jSONObject4);
        b(jSONObject, "isPluginMiniProgram", Boolean.valueOf(getRuntime().atD()));
        b(jSONObject, "envVersion", com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b.ot(this.gOq.atI().gVs).name().toLowerCase());
        jSONObject2 = new JSONObject();
        try {
            jSONObject2 = new JSONObject(this.gOq.atI().bQk);
        } catch (Exception e2) {
        }
        try {
            if (!bo.isNullOrNil(atH.bQu)) {
                optJSONObject = new JSONObject();
                optJSONObject.put("jsonInfo", new JSONObject(atH.bQu));
                b(jSONObject2, "operationInfo", optJSONObject);
            }
        } catch (Exception e3) {
            ab.e("MicroMsg.AppBrandService", "postProcessConfig, put operationInfo to appContactInfo fail", e3);
        }
        b(jSONObject, "appContactInfo", jSONObject2);
        b(jSONObject, "accountInfo", this.gOq.atI().xB());
        AppMethodBeat.o(129103);
    }

    private void auq() {
        String Eb;
        AppMethodBeat.i(129104);
        if (!this.gPQ) {
            aBx().setJsExceptionHandler(new com.tencent.mm.plugin.appbrand.h.h() {
                public final void C(String str, String str2) {
                    AppMethodBeat.i(129076);
                    ab.e("MicroMsg.AppBrandService", "hy: wxa main context exception %s %s", str, str2);
                    String format = String.format("{'message':'%s', 'stack': '%s'}", new Object[]{l.Ej(str), l.Ej(str2)});
                    com.tencent.mm.plugin.appbrand.jsapi.bo.a(s.this.aBx(), "onError", format, 0);
                    ab.e("MicroMsg.AppBrand.JsRuntimeException", format);
                    try {
                        com.tencent.mm.plugin.appbrand.report.quality.f.a(s.this, str, str2);
                        AppMethodBeat.o(129076);
                    } catch (Throwable th) {
                        AppMethodBeat.o(129076);
                    }
                }
            });
            Eb = d.Eb("wxa_library/android.js");
            if (this.gPS != null) {
                Eb = Eb + this.gPS.aIW();
            }
            if (this.gPR != null) {
                Eb = Eb + d.Eb("wxa_library/NativeGlobal-WAService.js");
            } else {
                Eb = Eb + d.Eb("wxa_library/NativeGlobal-Dummy.js");
            }
            com.tencent.mm.plugin.appbrand.s.n.a(aBx(), Eb, new com.tencent.mm.plugin.appbrand.s.n.a() {
                public final void onSuccess(String str) {
                    AppMethodBeat.i(129077);
                    ab.i("MicroMsg.AppBrandService", "Inject android.js Script Success");
                    AppMethodBeat.o(129077);
                }

                public final void lo(String str) {
                    AppMethodBeat.i(129078);
                    ab.e("MicroMsg.AppBrandService", "Inject android.js Script Failed");
                    AppMethodBeat.o(129078);
                }
            });
            String xu = WxaCommLibRuntimeReader.xu("WAService.js");
            Eb = "v" + WxaCommLibRuntimeReader.avQ().gVu;
            final long currentTimeMillis = System.currentTimeMillis();
            final boolean atU = atU();
            final int length = xu == null ? 0 : xu.length();
            o.a((q) this, aBx(), "WAService.js", "WAService.js", Eb, xu, o.a.LIB, (com.tencent.mm.plugin.appbrand.s.n.a) new com.tencent.mm.plugin.appbrand.s.n.a() {
                public final void onSuccess(String str) {
                    AppMethodBeat.i(129079);
                    ab.i("MicroMsg.AppBrandService", "Inject SDK Service Script Successwx.version = %s", WxaCommLibRuntimeReader.avP().avk());
                    if (s.this.atU() || s.this.isRunning()) {
                        com.tencent.mm.plugin.appbrand.report.quality.a.aLz();
                        com.tencent.mm.plugin.appbrand.report.quality.b.a(atU, s.this.getAppId(), currentTimeMillis, "WAService.js", (long) length);
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.a(370, 7, 1, false);
                    AppMethodBeat.o(129079);
                }

                public final void lo(String str) {
                    int i = 0;
                    AppMethodBeat.i(129080);
                    ab.e("MicroMsg.AppBrandService", "Inject SDK Service Script Failed: %s, wx.version = %s", str, WxaCommLibRuntimeReader.avP().avk());
                    com.tencent.mm.plugin.report.service.h.pYm.a(370, 6, 1, false);
                    com.tencent.mm.plugin.appbrand.report.c.br(s.this.getAppId(), 24);
                    int i2 = -1;
                    if (s.this.gOq != null) {
                        i = s.this.gOq.atH().hhd.gVu;
                        i2 = s.this.gOq.atH().hhd.gVt;
                    }
                    com.tencent.mm.plugin.appbrand.report.c.a(s.this.getAppId(), i, i2, 370, 6);
                    AppMethodBeat.o(129080);
                }
            });
            com.tencent.mm.plugin.report.service.h.pYm.a(370, 5, 1, false);
            this.gPQ = true;
        }
        Eb = this.gOq != null ? aur() : null;
        if (!bo.isNullOrNil(Eb)) {
            com.tencent.mm.plugin.appbrand.s.n.a(aBx(), Eb, new com.tencent.mm.plugin.appbrand.s.n.a() {
                public final void onSuccess(String str) {
                    AppMethodBeat.i(129081);
                    ab.i("MicroMsg.AppBrandService", "Inject performanceJs Script Success");
                    AppMethodBeat.o(129081);
                }

                public final void lo(String str) {
                    AppMethodBeat.i(129082);
                    ab.e("MicroMsg.AppBrandService", "Inject performanceJs Script Failed");
                    AppMethodBeat.o(129082);
                }
            });
        }
        AppMethodBeat.o(129104);
    }

    private String aur() {
        AppMethodBeat.i(129105);
        String str = null;
        if (AppBrandPerformanceManager.b(getRuntime())) {
            str = WxaCommLibRuntimeReader.xu("WAPerf.js");
        }
        AppMethodBeat.o(129105);
        return str;
    }

    private void aus() {
        AppMethodBeat.i(129106);
        if (this.gPO) {
            AppMethodBeat.o(129106);
        } else if (this.gPP) {
            AppMethodBeat.o(129106);
        } else {
            com.tencent.mm.plugin.appbrand.s.u.a(getRuntime(), aBx());
            final String a = aw.a(getRuntime(), "app-service.js");
            String str = "app-service.js";
            if (bo.isNullOrNil(a)) {
                AppMethodBeat.o(129106);
                return;
            }
            com.tencent.mm.plugin.report.service.h.pYm.a(370, 9, 1, false);
            final long currentTimeMillis = System.currentTimeMillis();
            o.a(getRuntime(), aBx(), str, str + "_" + getAppId(), getRuntime().atH().hhd.cvZ, a, o.a.USR, new com.tencent.mm.plugin.appbrand.s.n.a() {
                public final void onSuccess(String str) {
                    int i = -1;
                    AppMethodBeat.i(129065);
                    if (s.this.atU() || s.this.isRunning()) {
                        o runtime = s.this.getRuntime();
                        String str2 = "MicroMsg.AppBrandService";
                        String str3 = "[QualitySystem] app-service.js runtime.hashCode = [%d]";
                        Object[] objArr = new Object[1];
                        objArr[0] = Integer.valueOf(runtime != null ? runtime.hashCode() : -1);
                        ab.i(str2, str3, objArr);
                        str2 = s.this.getAppId();
                        str3 = "app-service.js";
                        String str4 = a;
                        long j = currentTimeMillis;
                        if (runtime != null) {
                            i = runtime.hashCode();
                        }
                        com.tencent.mm.plugin.appbrand.report.quality.a.a(str2, str3, str4, j, i);
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.a(370, 11, 1, false);
                    AppMethodBeat.o(129065);
                }

                public final void lo(String str) {
                    AppMethodBeat.i(129066);
                    ab.e("MicroMsg.AppBrandService", "Inject External Service Script Failed: %s", str);
                    try {
                        com.tencent.mm.plugin.report.service.h.pYm.a(370, 10, 1, false);
                        com.tencent.mm.plugin.appbrand.report.c.br(s.this.getAppId(), 24);
                        com.tencent.mm.plugin.appbrand.report.c.a(s.this.getAppId(), s.this.gOq.atH().hhd.gVu, s.this.gOq.atH().hhd.gVt, 370, 10);
                        AppMethodBeat.o(129066);
                    } catch (NullPointerException e) {
                        ab.e("MicroMsg.AppBrandService", "Inject External Service Script Failed, report npe = %s", e);
                        AppMethodBeat.o(129066);
                    }
                }
            });
            this.gPP = true;
            AppMethodBeat.o(129106);
        }
    }

    public void xd(final String str) {
        AppMethodBeat.i(129107);
        AnonymousClass3 anonymousClass3 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(129069);
                if (s.this.gPO) {
                    try {
                        s.this.bo("onSubPackageReady", new JSONObject().put("moduleName", str).toString());
                        AppMethodBeat.o(129069);
                    } catch (Exception e) {
                        ab.e("MicroMsg.AppBrandService", "loadModule using isolate context, notify but get exception %s");
                        AppMethodBeat.o(129069);
                    }
                } else if ("__APP__".equals(str)) {
                    s.b(s.this);
                    AppMethodBeat.o(129069);
                } else {
                    String str = str + (str.endsWith("/") ? "" : "/") + "app-service.js";
                    String a = aw.a(s.this.gOq, str);
                    com.tencent.mm.plugin.report.service.h.pYm.a(370, 30, 1, false);
                    o.a(s.this.getRuntime(), s.this.aBx(), str, "", "", a, o.a.USR, new com.tencent.mm.plugin.appbrand.s.n.a() {
                        public final void onSuccess(String str) {
                            AppMethodBeat.i(129067);
                            com.tencent.mm.plugin.report.service.h.pYm.a(370, 31, 1, false);
                            AppMethodBeat.o(129067);
                        }

                        public final void lo(String str) {
                            AppMethodBeat.i(129068);
                            ab.e("MicroMsg.AppBrandService", "inject module(%s) script failed: %s", str, str);
                            com.tencent.mm.plugin.report.service.h.pYm.a(370, 32, 1, false);
                            AppMethodBeat.o(129068);
                        }
                    });
                    AppMethodBeat.o(129069);
                }
            }
        };
        if (isRunning()) {
            anonymousClass3.run();
            AppMethodBeat.o(129107);
            return;
        }
        synchronized (this.gPT) {
            try {
                this.gPT.add(anonymousClass3);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(129107);
            }
        }
    }

    public o getRuntime() {
        AppMethodBeat.i(129108);
        o oVar = (o) super.xL();
        AppMethodBeat.o(129108);
        return oVar;
    }

    public final String aug() {
        return "https://usr/";
    }

    public final String auf() {
        return "https://lib/";
    }

    public boolean aut() {
        return this.gPO;
    }

    static {
        AppMethodBeat.i(129114);
        com.tencent.mm.plugin.appbrand.game.c.d.axy();
        AppMethodBeat.o(129114);
    }
}
