package com.tencent.mm.plugin.appbrand.game;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.n;
import com.tencent.mm.plugin.appbrand.debugger.t;
import com.tencent.mm.plugin.appbrand.game.d.d;
import com.tencent.mm.plugin.appbrand.h.h;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.plugin.appbrand.h.q;
import com.tencent.mm.plugin.appbrand.h.z;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.f;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.s.l;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends s {
    private n hku = null;
    private volatile boolean hqm = false;
    private volatile boolean hqn = false;
    private volatile boolean hqo = false;
    private volatile boolean hqp = false;
    private volatile boolean hqq = false;

    class a extends com.tencent.magicbrush.MBRuntime.a {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final void onRendererReady(int i, int i2) {
            AppMethodBeat.i(130009);
            ab.i("MicroMsg.WAGameAppService", "MagicBrushListener.onRendererReady width = [%d] height = [%d]", Integer.valueOf(i), Integer.valueOf(i2));
            b.this.hqm = true;
            b.this.getMBRuntime().getJsThreadHandler().f(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(130008);
                    b.b(b.this);
                    AppMethodBeat.o(130008);
                }
            });
            AppMethodBeat.o(130009);
        }

        public final void onSystemSizeChanged(int i, int i2) {
            AppMethodBeat.i(130010);
            o runtime = b.this.getRuntime();
            if (runtime == null) {
                AppMethodBeat.o(130010);
                return;
            }
            m mVar = runtime.gNM;
            ab.i("MicroMsg.AppBrandOnWindowSizeChangedEvent", "hy: on resizeWindow");
            mVar.i(runtime.xT()).aCj();
            AppMethodBeat.o(130010);
        }

        public final void onFirstFrameRendered() {
            AppMethodBeat.i(130011);
            if (b.this.atU() || b.this.isRunning()) {
                com.tencent.mm.plugin.appbrand.game.f.a aBG = com.tencent.mm.plugin.appbrand.game.f.a.aBG();
                aBG.hud = bo.yz();
                try {
                    aBG.mbInspector = ((b) com.tencent.mm.plugin.appbrand.a.wI(aBG.appId).atK()).getMBRuntime().getInspector();
                } catch (NullPointerException e) {
                    ab.printErrStackTrace("MicroMsg.MBNiReporter", e, "inspector null pointer!", new Object[0]);
                }
                if (aBG.mbInspector != null) {
                    com.tencent.magicbrush.a aVar = aBG.mbInspector;
                    int yt = aVar.yt();
                    aVar.bSh.put(yt, c.yz());
                    aBG.hue = yt;
                }
                com.tencent.mm.ce.a.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(130324);
                        a.this.hub = a.this.hug.size();
                        ab.i("MicroMsg.MBNiReporter", "hy: onFirstFrameRendered picnum:%d", Integer.valueOf(a.this.hub));
                        AppMethodBeat.o(130324);
                    }
                });
                com.tencent.mm.ce.a.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(130325);
                        com.tencent.magicbrush.a c = a.this.mbInspector;
                        if (c != null) {
                            a.this.huf = c.fQ(a.this.hue);
                        }
                        AppMethodBeat.o(130325);
                    }
                }, 10);
            }
            AppMethodBeat.o(130011);
        }

        public final void onConsoleOutput(String str) {
            AppMethodBeat.i(130012);
            ab.i("MicroMsg.WAGameAppService", "[WAGame][CONSOLE] output = [%s]", str);
            if (b.this.atU() || b.this.isRunning()) {
                o runtime = b.this.getRuntime();
                if (runtime == null || runtime.atH().bQp) {
                    d.aAI().Ax(str);
                }
                AppMethodBeat.o(130012);
                return;
            }
            AppMethodBeat.o(130012);
        }

        public final void onMainCanvasTypeDefined(int i) {
            AppMethodBeat.i(130013);
            if (i != 1 && i != 2) {
                IllegalStateException illegalStateException = new IllegalStateException("onMainCanvasTypeDefined received invalid input [" + i + "]");
                AppMethodBeat.o(130013);
                throw illegalStateException;
            } else if (b.this.atU() || b.this.isRunning()) {
                QualitySessionRuntime DG = com.tencent.mm.plugin.appbrand.report.quality.a.DG(b.this.getRuntime().mAppId);
                if (DG == null) {
                    AppMethodBeat.o(130013);
                    return;
                }
                DG.iDi.iDl = i == 1 ? com.tencent.mm.plugin.appbrand.report.quality.j.a._2D : com.tencent.mm.plugin.appbrand.report.quality.j.a.WEBGL;
                AppMethodBeat.o(130013);
            } else {
                AppMethodBeat.o(130013);
            }
        }
    }

    static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(130036);
        bVar.aAu();
        AppMethodBeat.o(130036);
    }

    public final i aua() {
        String aBv;
        byte[] Ec;
        g gVar = null;
        AppMethodBeat.i(130014);
        ab.i("MicroMsg.WAGameAppService", "createJsRuntime");
        long currentTimeMillis = System.currentTimeMillis();
        if (((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_j2v8_codecache, false)) {
            aBv = z.aBv();
        } else {
            aBv = null;
        }
        if (((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_j2v8_snapshot, false)) {
            Ec = com.tencent.mm.plugin.appbrand.r.d.Ec("wxa_library/v8_snapshot.bin");
        } else {
            Ec = null;
        }
        i bVar = new com.tencent.mm.plugin.appbrand.h.b(aBv, Ec);
        d dVar = new d(this, (q) bVar.af(q.class));
        bVar.setJsExceptionHandler(new h() {
            public final void C(String str, String str2) {
                AppMethodBeat.i(130000);
                ab.e("MicroMsg.WAGameAppService", "[WAGameJsException] hy: wxa main context exception %s %s", str, str2);
                com.tencent.mm.plugin.appbrand.jsapi.bo.a(b.this.aBx(), "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[]{l.Ej(str), l.Ej(str2)}), 0);
                try {
                    f.a(b.this, str, str2);
                    AppMethodBeat.o(130000);
                } catch (Throwable th) {
                    AppMethodBeat.o(130000);
                }
            }
        });
        dVar.hqv = aAt();
        bVar.addJavascriptInterface(dVar, "WeixinJSContext");
        com.tencent.mm.plugin.appbrand.s.n.a(bVar, String.format(";(function(){let interface = %s;let alloc = interface.alloc;let allocNativeGlobal = interface.allocNativeGlobal;interface.alloc = function(injectNativeGlobal) {if(injectNativeGlobal){return allocNativeGlobal();}else{return alloc();}}})();", new Object[]{"WeixinJSContext"}), new com.tencent.mm.plugin.appbrand.s.n.a() {
            public final void onSuccess(String str) {
                AppMethodBeat.i(130037);
                ab.i("MicroMsg.WAGameJsContextInterface", "Interface dl: success");
                AppMethodBeat.o(130037);
            }

            public final void lo(String str) {
                AppMethodBeat.i(130038);
                ab.i("MicroMsg.WAGameJsContextInterface", "Interface dl: fail");
                AppMethodBeat.o(130038);
            }
        });
        dVar.asH();
        ab.i("MicroMsg.WAGameAppService", "[damonlei] createJsRuntime cost [%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        com.tencent.mm.plugin.appbrand.report.quality.a.aLz();
        if (atU()) {
            gVar = g.WAGAME;
        }
        com.tencent.mm.plugin.appbrand.report.quality.b.a(gVar, getAppId(), currentTimeMillis, com.tencent.mm.plugin.appbrand.report.a.d(bVar));
        AppMethodBeat.o(130014);
        return bVar;
    }

    public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> aub() {
        AppMethodBeat.i(130015);
        Map aAK = com.tencent.mm.plugin.appbrand.game.e.f.aAK();
        AppMethodBeat.o(130015);
        return aAK;
    }

    private boolean aAs() {
        AppMethodBeat.i(130016);
        if (ah.doC() != null) {
            int i = ah.doC().getInt("appbrandgame_use_commandbuffer", -1);
            if (i != -1) {
                if (i != 0) {
                    AppMethodBeat.o(130016);
                    return true;
                }
                AppMethodBeat.o(130016);
                return false;
            }
        }
        if (this.gOq != null) {
            com.tencent.mm.plugin.appbrand.config.a appConfig = this.gOq.getAppConfig();
            if (appConfig.hfa) {
                boolean z = appConfig.heZ;
                AppMethodBeat.o(130016);
                return z;
            }
        }
        com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = com.tencent.mm.ipcinvoker.wx_extension.a.a.b.eGM;
        com.tencent.mm.storage.c ll = com.tencent.mm.ipcinvoker.wx_extension.a.a.ll("100466");
        if (ll == null || !ll.isValid()) {
            AppMethodBeat.o(130016);
            return false;
        } else if (bo.getInt((String) ll.dru().get("useCommandBuffer"), 0) == 1) {
            AppMethodBeat.o(130016);
            return true;
        } else {
            AppMethodBeat.o(130016);
            return false;
        }
    }

    private boolean aAt() {
        AppMethodBeat.i(130017);
        if (!this.hqp) {
            this.hqq = aAs();
            this.hqp = true;
        }
        boolean z = this.hqq;
        AppMethodBeat.o(130017);
        return z;
    }

    public final boolean aui() {
        return true;
    }

    public final void aul() {
        AppMethodBeat.i(130018);
        if (this.gPR == null) {
            super.aul();
            AppMethodBeat.o(130018);
            return;
        }
        this.gPR.hqd = aAt();
        this.gPR.hqh = new a(this, (byte) 0);
        this.gPR.hqc = true;
        this.gPR.hqe = true;
        this.gPR.hqi.allow_antialias_ = ((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_magicbrush_allow_antialias, false);
        this.gPR.hqi.allow_opengl3 = ((Boolean) com.tencent.mm.plugin.appbrand.game.a.b.hqB.Uw()).booleanValue();
        super.aul();
        AppMethodBeat.o(130018);
    }

    public final void auk() {
        AppMethodBeat.i(130019);
        if (this.gPR == null) {
            AppMethodBeat.o(130019);
            return;
        }
        MBRuntime mBRuntime = this.gPR.hqb;
        com.tencent.magicbrush.handler.glfont.h hVar = (com.tencent.magicbrush.handler.glfont.h) mBRuntime.getFontHandler();
        com.tencent.mm.plugin.appbrand.game.c.a.AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.game.c.a.AnonymousClass1(new WeakReference(getRuntime()));
        hVar.bSW = anonymousClass1;
        if (hVar.bTn != null) {
            hVar.bTn.bSW = anonymousClass1;
        }
        com.tencent.magicbrush.a.a.a(new com.tencent.mm.plugin.appbrand.game.c.a.a());
        com.tencent.magicbrush.handler.glfont.a.a(new com.tencent.mm.plugin.appbrand.game.c.a.b());
        com.tencent.mm.plugin.appbrand.game.c.b.a(this.gPR.hqb, getRuntime(), true);
        AppMethodBeat.o(130019);
    }

    public final void dw(boolean z) {
        AppMethodBeat.i(130020);
        ab.i("MicroMsg.WAGameAppService", "onRuntimeResume");
        super.dw(z);
        if (this.hku != null) {
            this.hku.hjW.bringToFront();
        }
        AppMethodBeat.o(130020);
    }

    public final void aup() {
        AppMethodBeat.i(130021);
        i aBx = aBx();
        if (aBx == null) {
            AppMethodBeat.o(130021);
            return;
        }
        com.tencent.mm.plugin.appbrand.h.n nVar = (com.tencent.mm.plugin.appbrand.h.n) aBx.af(com.tencent.mm.plugin.appbrand.h.n.class);
        if (nVar != null) {
            nVar.setThreadPriority(-8);
        }
        AppMethodBeat.o(130021);
    }

    public final MBRuntime getMBRuntime() {
        if (this.gPR == null) {
            return null;
        }
        return this.gPR.hqb;
    }

    public final void m(com.tencent.mm.plugin.appbrand.i iVar) {
        AppMethodBeat.i(130022);
        super.m(iVar);
        QualitySessionRuntime DG = com.tencent.mm.plugin.appbrand.report.quality.a.DG(getAppId());
        if (DG != null && DG.iDh.aLA()) {
            MBRuntime mBRuntime = getMBRuntime();
            if (mBRuntime != null) {
                com.tencent.magicbrush.a inspector = mBRuntime.getInspector();
                synchronized (inspector.bSg) {
                    try {
                        if (inspector.bSg.mNativeInst == 0) {
                        } else {
                            inspector.bSg.nativeSetEnableInspectFpsVariance(inspector.bSg.mNativeInst, true);
                            AppMethodBeat.o(130022);
                            return;
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(130022);
                    }
                }
            }
        }
        AppMethodBeat.o(130022);
    }

    public final void wO() {
        AppMethodBeat.i(130023);
        ab.i("MicroMsg.WAGameAppService", "WAGameAppService.init");
        this.hqn = true;
        aAu();
        AppMethodBeat.o(130023);
    }

    public final void auo() {
        AppMethodBeat.i(130024);
        if (getRuntime() != null && getRuntime().yd()) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(130001);
                    b.this.hku = new n();
                    com.tencent.mm.plugin.appbrand.debugger.l lVar = new com.tencent.mm.plugin.appbrand.debugger.l();
                    lVar.a(b.this, b.this.getRuntime().atI().extInfo);
                    b.this.hku.a(lVar);
                    AppMethodBeat.o(130001);
                }
            });
            String str = "xdebug";
            com.tencent.mm.plugin.appbrand.h.l lVar = (com.tencent.mm.plugin.appbrand.h.l) aBx().af(com.tencent.mm.plugin.appbrand.h.l.class);
            if (lVar != null) {
                lVar.Ce(str);
            }
            if (this.gPH) {
                try {
                    aBx().a(new URL("https://usr/" + "break.js"), "breakprogram();", null);
                } catch (MalformedURLException e) {
                    AppMethodBeat.o(130024);
                    return;
                }
            }
        }
        AppMethodBeat.o(130024);
    }

    private void aAu() {
        AppMethodBeat.i(130025);
        ab.i("MicroMsg.WAGameAppService", "WAGameAppService.initImpl mServiceReady = [%b], mRendererReady = [%b]", Boolean.valueOf(this.hqn), Boolean.valueOf(this.hqm));
        if (!this.hqn || !this.hqm) {
            AppMethodBeat.o(130025);
        } else if (isRunning()) {
            ab.i("MicroMsg.WAGameAppService", "WAGameAppService.initImpl start");
            aud();
            aAx();
            if (!aut()) {
                aAw();
            }
            atZ();
            AppMethodBeat.o(130025);
        } else {
            ab.i("MicroMsg.WAGameAppService", "WAGameAppService.initImpl !isRunning, skip");
            AppMethodBeat.o(130025);
        }
    }

    public final void cleanup() {
        AppMethodBeat.i(130026);
        super.cleanup();
        if (this.gPR != null) {
            try {
                this.gPR.hqj.bUA.get();
            } catch (InterruptedException e) {
                com.tencent.magicbrush.a.c.c.a("MagicBrush.SyncTask", e, "await failed", new Object[0]);
            } catch (ExecutionException e2) {
                com.tencent.magicbrush.a.c.c.a("MagicBrush.SyncTask", e2, "execute failed", new Object[0]);
            }
        }
        if (this.hku != null) {
            this.hku.destroy();
        }
        AppMethodBeat.o(130026);
    }

    public final void h(JSONObject jSONObject) {
        AppMethodBeat.i(130027);
        super.h(jSONObject);
        b(jSONObject, "isIsolateContext", Boolean.valueOf(aut()));
        AppMethodBeat.o(130027);
    }

    public final void i(JSONObject jSONObject) {
        JSONObject jSONObject2;
        int systemDisplayHeight;
        int systemDisplayWidth;
        AppMethodBeat.i(130028);
        super.i(jSONObject);
        AppBrandSysConfigWC atH = getRuntime().atH();
        JSONObject optJSONObject = jSONObject.optJSONObject("wxAppInfo");
        if (optJSONObject == null) {
            jSONObject2 = new JSONObject();
        } else {
            jSONObject2 = optJSONObject;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (Object put : atH.bQO.hgb) {
                jSONArray.put(put);
            }
            b(jSONObject2, "subContextImgDomain", jSONArray);
        } catch (Exception e) {
        }
        b(jSONObject, "wxAppInfo", jSONObject2);
        MBRuntime mBRuntime = getMBRuntime();
        if (mBRuntime != null) {
            systemDisplayWidth = mBRuntime.getSystemDisplayWidth();
            systemDisplayHeight = mBRuntime.getSystemDisplayHeight();
        } else {
            systemDisplayHeight = 0;
            systemDisplayWidth = 0;
        }
        ab.i("MicroMsg.WAGameAppService", "dm.widthPixels %d, dm.heightPixels %d", Integer.valueOf(systemDisplayWidth), Integer.valueOf(systemDisplayHeight));
        if (com.tencent.mm.plugin.appbrand.config.a.a.t(getRuntime())) {
            ab.i("MicroMsg.WAGameAppService", "screen in right orientation");
            b(jSONObject, "screenWidth", Integer.valueOf(systemDisplayWidth));
            b(jSONObject, "screenHeight", Integer.valueOf(systemDisplayHeight));
        } else {
            ab.w("MicroMsg.WAGameAppService", "screen in reverse orientation");
            b(jSONObject, "screenWidth", Integer.valueOf(systemDisplayHeight));
            b(jSONObject, "screenHeight", Integer.valueOf(systemDisplayWidth));
        }
        b(jSONObject, "devicePixelRatio", Float.valueOf(com.tencent.mm.bz.a.getDensity(getContext())));
        AppMethodBeat.o(130028);
    }

    private void aAv() {
        AppMethodBeat.i(130029);
        String str = com.tencent.mm.plugin.appbrand.r.d.Eb("wxa_library/android.js") + com.tencent.mm.plugin.appbrand.r.d.Eb("wxa_library/NativeGlobal-WAGame.js");
        if (aAt()) {
            str = str + com.tencent.mm.plugin.appbrand.r.d.Eb("wxa_library/commandbuffer.js");
        }
        com.tencent.mm.plugin.appbrand.s.n.a(aBx(), str, new com.tencent.mm.plugin.appbrand.s.n.a() {
            public final void onSuccess(String str) {
                AppMethodBeat.i(130002);
                ab.i("MicroMsg.WAGameAppService", "Inject WAGame Library Script suc: %s", str);
                AppMethodBeat.o(130002);
            }

            public final void lo(String str) {
                AppMethodBeat.i(130003);
                ab.e("MicroMsg.WAGameAppService", "Inject WAGame Library Script Failed: %s", str);
                AppMethodBeat.o(130003);
            }
        });
        AppMethodBeat.o(130029);
    }

    private void aAw() {
        AppMethodBeat.i(130030);
        if (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED || com.tencent.mm.sdk.platformtools.f.DEBUG) {
            ab.c("MicroMsg.WAGameAppService", "damon warns: This is only for test!!!!", new Object[0]);
            com.tencent.mm.plugin.appbrand.s.o.a(this, aBx(), "game.js", aw.a(getRuntime(), "game.js"), com.tencent.mm.plugin.appbrand.s.o.a.USR, new com.tencent.mm.plugin.appbrand.s.n.a() {
                public final void onSuccess(String str) {
                    AppMethodBeat.i(130004);
                    ab.i("MicroMsg.WAGameAppService", "dl: it's ok");
                    AppMethodBeat.o(130004);
                }

                public final void lo(String str) {
                    AppMethodBeat.i(130005);
                    ab.i("MicroMsg.WAGameAppService", "fail");
                    AppMethodBeat.o(130005);
                }
            });
            AppMethodBeat.o(130030);
            return;
        }
        AppMethodBeat.o(130030);
    }

    private void aAx() {
        AppMethodBeat.i(130031);
        if (this.hqo) {
            AppMethodBeat.o(130031);
            return;
        }
        this.hqo = true;
        ab.i("MicroMsg.WAGameAppService", "Inject WAGame to MainContext");
        aAv();
        String str = "WAGame.js";
        String xu = WxaCommLibRuntimeReader.xu("WAGame.js");
        String str2 = "v" + WxaCommLibRuntimeReader.avQ().gVu;
        com.tencent.mm.plugin.report.service.h.pYm.a(778, 13, 1, false);
        final long currentTimeMillis = System.currentTimeMillis();
        final boolean atU = atU();
        final int length = xu == null ? 0 : xu.length();
        AnonymousClass5 anonymousClass5 = new com.tencent.mm.plugin.appbrand.s.n.a() {
            public final void onSuccess(String str) {
                AppMethodBeat.i(130006);
                ab.i("MicroMsg.WAGameAppService", "Inject SDK WAGame Script suc: %s", str);
                if (b.this.atU() || b.this.isRunning()) {
                    com.tencent.mm.plugin.appbrand.report.quality.a.aLz();
                    com.tencent.mm.plugin.appbrand.report.quality.b.a(atU, b.this.getAppId(), currentTimeMillis, "WAGame.js", (long) length);
                }
                com.tencent.mm.plugin.report.service.h.pYm.a(778, 15, 1, false);
                AppMethodBeat.o(130006);
            }

            public final void lo(String str) {
                int i = 0;
                AppMethodBeat.i(130007);
                ab.e("MicroMsg.WAGameAppService", "Inject SDK WAGame Script Failed: %s", str);
                com.tencent.mm.plugin.report.service.h.pYm.a(778, 14, 1, false);
                com.tencent.mm.plugin.appbrand.report.c.br(b.this.getAppId(), 24);
                int i2 = -1;
                o runtime = b.this.getRuntime();
                if (runtime != null) {
                    i = runtime.atH().hhd.gVu;
                    i2 = runtime.atH().hhd.gVt;
                }
                com.tencent.mm.plugin.appbrand.report.c.a(b.this.getAppId(), i, i2, 778, 14);
                AppMethodBeat.o(130007);
            }
        };
        if (getRuntime() == null || !getRuntime().yd()) {
            com.tencent.mm.plugin.appbrand.s.o.a((com.tencent.mm.plugin.appbrand.q) this, aBx(), str, "WAGame.js", str2, xu, com.tencent.mm.plugin.appbrand.s.o.a.LIB, (com.tencent.mm.plugin.appbrand.s.n.a) anonymousClass5);
            AppMethodBeat.o(130031);
            return;
        }
        com.tencent.mm.plugin.appbrand.s.o.b(this, aBx(), "WAGame.js", ";(function(global) { var protectedConsole = global.console; Object.defineProperty(global, 'console', { get() { return protectedConsole; }, set() { } }); })(this);".concat(String.valueOf(xu)), com.tencent.mm.plugin.appbrand.s.o.a.LIB, anonymousClass5);
        AppMethodBeat.o(130031);
    }

    public final void xd(String str) {
        AppMethodBeat.i(130032);
        ab.i("MicroMsg.WAGameAppService", "hy: do nothing in game service when called from modularizing helper");
        AppMethodBeat.o(130032);
    }

    public final String xc(String str) {
        AppMethodBeat.i(130033);
        String str2;
        if (getRuntime() == null || !getRuntime().yd()) {
            str2 = "";
            AppMethodBeat.o(130033);
            return str2;
        }
        str2 = t.a(str, getRuntime());
        AppMethodBeat.o(130033);
        return str2;
    }

    public final void atV() {
        AppMethodBeat.i(130034);
        ab.i("MicroMsg.WAGameAppService", "start preload");
        auj();
        a(aBx());
        aAx();
        ab.i("MicroMsg.WAGameAppService", "WAGameAppService preloaded.");
        AppMethodBeat.o(130034);
    }

    public final boolean aut() {
        AppMethodBeat.i(130035);
        if (com.tencent.mm.sdk.platformtools.f.DEBUG || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) {
            boolean booleanValue = ((Boolean) com.tencent.mm.plugin.appbrand.game.a.d.hqL.Uw()).booleanValue();
            AppMethodBeat.o(130035);
            return booleanValue;
        }
        AppMethodBeat.o(130035);
        return true;
    }
}
