package com.tencent.p177mm.plugin.appbrand.game;

import com.tencent.magicbrush.C1000a;
import com.tencent.magicbrush.C37414c;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MBRuntime.C25712a;
import com.tencent.magicbrush.handler.glfont.C37416a;
import com.tencent.magicbrush.handler.glfont.C6277h;
import com.tencent.magicbrush.p1173a.C37409a;
import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a.C32718b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.C38163a;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a;
import com.tencent.p177mm.plugin.appbrand.debugger.C26852t;
import com.tencent.p177mm.plugin.appbrand.debugger.C42411l;
import com.tencent.p177mm.plugin.appbrand.debugger.C42413n;
import com.tencent.p177mm.plugin.appbrand.game.C45559d.C21591;
import com.tencent.p177mm.plugin.appbrand.game.p1223f.C38226a;
import com.tencent.p177mm.plugin.appbrand.game.p1223f.C38226a.C382272;
import com.tencent.p177mm.plugin.appbrand.game.p1223f.C38226a.C382281;
import com.tencent.p177mm.plugin.appbrand.game.p291a.C31292d;
import com.tencent.p177mm.plugin.appbrand.game.p291a.C45554b;
import com.tencent.p177mm.plugin.appbrand.game.p293c.C19227a.C19228b;
import com.tencent.p177mm.plugin.appbrand.game.p293c.C19227a.C19229a;
import com.tencent.p177mm.plugin.appbrand.game.p293c.C19227a.C192301;
import com.tencent.p177mm.plugin.appbrand.game.p293c.C33191b;
import com.tencent.p177mm.plugin.appbrand.game.p294d.C45558d;
import com.tencent.p177mm.plugin.appbrand.game.p295e.C19239f;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19346bo;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.p297h.C19243l;
import com.tencent.p177mm.plugin.appbrand.p297h.C26898b;
import com.tencent.p177mm.plugin.appbrand.p297h.C33211h;
import com.tencent.p177mm.plugin.appbrand.p297h.C33212n;
import com.tencent.p177mm.plugin.appbrand.p297h.C38237q;
import com.tencent.p177mm.plugin.appbrand.p297h.C38238z;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.plugin.appbrand.p328r.C45672d;
import com.tencent.p177mm.plugin.appbrand.p329s.C19716o;
import com.tencent.p177mm.plugin.appbrand.p329s.C19716o.C19718a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42681l;
import com.tencent.p177mm.plugin.appbrand.p329s.C42682n;
import com.tencent.p177mm.plugin.appbrand.p329s.C42682n.C42683a;
import com.tencent.p177mm.plugin.appbrand.page.C27229m;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.report.C42669a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C2452f;
import com.tencent.p177mm.plugin.appbrand.report.quality.C27285a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C38501b;
import com.tencent.p177mm.plugin.appbrand.report.quality.C45678j.C33521a;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.p177mm.plugin.appbrand.task.C38519g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C5141c;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.game.b */
public final class C42439b extends C19722s {
    private C42413n hku = null;
    private volatile boolean hqm = false;
    private volatile boolean hqn = false;
    private volatile boolean hqo = false;
    private volatile boolean hqp = false;
    private volatile boolean hqq = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.b$4 */
    class C192204 implements C42683a {
        C192204() {
        }

        public final void onSuccess(String str) {
            AppMethodBeat.m2504i(130004);
            C4990ab.m7416i("MicroMsg.WAGameAppService", "dl: it's ok");
            AppMethodBeat.m2505o(130004);
        }

        /* renamed from: lo */
        public final void mo5987lo(String str) {
            AppMethodBeat.m2504i(130005);
            C4990ab.m7416i("MicroMsg.WAGameAppService", "fail");
            AppMethodBeat.m2505o(130005);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.b$a */
    class C19223a extends C25712a {

        /* renamed from: com.tencent.mm.plugin.appbrand.game.b$a$1 */
        class C192221 implements Runnable {
            C192221() {
            }

            public final void run() {
                AppMethodBeat.m2504i(130008);
                C42439b.m75162b(C42439b.this);
                AppMethodBeat.m2505o(130008);
            }
        }

        private C19223a() {
        }

        /* synthetic */ C19223a(C42439b c42439b, byte b) {
            this();
        }

        public final void onRendererReady(int i, int i2) {
            AppMethodBeat.m2504i(130009);
            C4990ab.m7417i("MicroMsg.WAGameAppService", "MagicBrushListener.onRendererReady width = [%d] height = [%d]", Integer.valueOf(i), Integer.valueOf(i2));
            C42439b.this.hqm = true;
            C42439b.this.getMBRuntime().getJsThreadHandler().mo33017f(new C192221());
            AppMethodBeat.m2505o(130009);
        }

        public final void onSystemSizeChanged(int i, int i2) {
            AppMethodBeat.m2504i(130010);
            C41243o runtime = C42439b.this.getRuntime();
            if (runtime == null) {
                AppMethodBeat.m2505o(130010);
                return;
            }
            C27229m c27229m = runtime.gNM;
            C4990ab.m7416i("MicroMsg.AppBrandOnWindowSizeChangedEvent", "hy: on resizeWindow");
            c27229m.mo61031i(runtime.mo15032xT()).aCj();
            AppMethodBeat.m2505o(130010);
        }

        public final void onFirstFrameRendered() {
            AppMethodBeat.m2504i(130011);
            if (C42439b.this.atU() || C42439b.this.isRunning()) {
                C38226a aBG = C38226a.aBG();
                aBG.hud = C5046bo.m7588yz();
                try {
                    aBG.mbInspector = ((C42439b) C10048a.m17635wI(aBG.appId).atK()).getMBRuntime().getInspector();
                } catch (NullPointerException e) {
                    C4990ab.printErrStackTrace("MicroMsg.MBNiReporter", e, "inspector null pointer!", new Object[0]);
                }
                if (aBG.mbInspector != null) {
                    C1000a c1000a = aBG.mbInspector;
                    int yt = c1000a.mo3984yt();
                    c1000a.bSh.put(yt, C37414c.m63043yz());
                    aBG.hue = yt;
                }
                C26006a.post(new C382281());
                C26006a.postDelayed(new C382272(), 10);
            }
            AppMethodBeat.m2505o(130011);
        }

        public final void onConsoleOutput(String str) {
            AppMethodBeat.m2504i(130012);
            C4990ab.m7417i("MicroMsg.WAGameAppService", "[WAGame][CONSOLE] output = [%s]", str);
            if (C42439b.this.atU() || C42439b.this.isRunning()) {
                C41243o runtime = C42439b.this.getRuntime();
                if (runtime == null || runtime.atH().bQp) {
                    C45558d.aAI().mo73366Ax(str);
                }
                AppMethodBeat.m2505o(130012);
                return;
            }
            AppMethodBeat.m2505o(130012);
        }

        public final void onMainCanvasTypeDefined(int i) {
            AppMethodBeat.m2504i(130013);
            if (i != 1 && i != 2) {
                IllegalStateException illegalStateException = new IllegalStateException("onMainCanvasTypeDefined received invalid input [" + i + "]");
                AppMethodBeat.m2505o(130013);
                throw illegalStateException;
            } else if (C42439b.this.atU() || C42439b.this.isRunning()) {
                QualitySessionRuntime DG = C27285a.m43319DG(C42439b.this.getRuntime().mAppId);
                if (DG == null) {
                    AppMethodBeat.m2505o(130013);
                    return;
                }
                DG.iDi.iDl = i == 1 ? C33521a._2D : C33521a.WEBGL;
                AppMethodBeat.m2505o(130013);
            } else {
                AppMethodBeat.m2505o(130013);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.b$3 */
    class C331883 implements C42683a {
        C331883() {
        }

        public final void onSuccess(String str) {
            AppMethodBeat.m2504i(130002);
            C4990ab.m7417i("MicroMsg.WAGameAppService", "Inject WAGame Library Script suc: %s", str);
            AppMethodBeat.m2505o(130002);
        }

        /* renamed from: lo */
        public final void mo5987lo(String str) {
            AppMethodBeat.m2504i(130003);
            C4990ab.m7413e("MicroMsg.WAGameAppService", "Inject WAGame Library Script Failed: %s", str);
            AppMethodBeat.m2505o(130003);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.b$2 */
    class C382142 implements Runnable {
        C382142() {
        }

        public final void run() {
            AppMethodBeat.m2504i(130001);
            C42439b.this.hku = new C42413n();
            C42411l c42411l = new C42411l();
            c42411l.mo67920a(C42439b.this, C42439b.this.getRuntime().atI().extInfo);
            C42439b.this.hku.mo67938a(c42411l);
            AppMethodBeat.m2505o(130001);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.b$1 */
    class C424401 implements C33211h {
        C424401() {
        }

        /* renamed from: C */
        public final void mo5989C(String str, String str2) {
            AppMethodBeat.m2504i(130000);
            C4990ab.m7413e("MicroMsg.WAGameAppService", "[WAGameJsException] hy: wxa main context exception %s %s", str, str2);
            C19346bo.m30025a(C42439b.this.aBx(), "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[]{C42681l.m75588Ej(str), C42681l.m75588Ej(str2)}), 0);
            try {
                C2452f.m4692a(C42439b.this, str, str2);
                AppMethodBeat.m2505o(130000);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(130000);
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m75162b(C42439b c42439b) {
        AppMethodBeat.m2504i(130036);
        c42439b.aAu();
        AppMethodBeat.m2505o(130036);
    }

    public final C6747i aua() {
        String aBv;
        byte[] Ec;
        C38519g c38519g = null;
        AppMethodBeat.m2504i(130014);
        C4990ab.m7416i("MicroMsg.WAGameAppService", "createJsRuntime");
        long currentTimeMillis = System.currentTimeMillis();
        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_j2v8_codecache, false)) {
            aBv = C38238z.aBv();
        } else {
            aBv = null;
        }
        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_j2v8_snapshot, false)) {
            Ec = C45672d.m84371Ec("wxa_library/v8_snapshot.bin");
        } else {
            Ec = null;
        }
        C6747i c26898b = new C26898b(aBv, Ec);
        C45559d c45559d = new C45559d(this, (C38237q) c26898b.mo14970af(C38237q.class));
        c26898b.setJsExceptionHandler(new C424401());
        c45559d.hqv = aAt();
        c26898b.addJavascriptInterface(c45559d, "WeixinJSContext");
        C42682n.m75589a(c26898b, String.format(";(function(){let interface = %s;let alloc = interface.alloc;let allocNativeGlobal = interface.allocNativeGlobal;interface.alloc = function(injectNativeGlobal) {if(injectNativeGlobal){return allocNativeGlobal();}else{return alloc();}}})();", new Object[]{"WeixinJSContext"}), new C21591());
        c45559d.asH();
        C4990ab.m7417i("MicroMsg.WAGameAppService", "[damonlei] createJsRuntime cost [%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        C27285a.aLz();
        if (atU()) {
            c38519g = C38519g.WAGAME;
        }
        C38501b.m65161a(c38519g, getAppId(), currentTimeMillis, C42669a.m75572d(c26898b));
        AppMethodBeat.m2505o(130014);
        return c26898b;
    }

    public final Map<String, C45608m> aub() {
        AppMethodBeat.m2504i(130015);
        Map aAK = C19239f.aAK();
        AppMethodBeat.m2505o(130015);
        return aAK;
    }

    private boolean aAs() {
        AppMethodBeat.m2504i(130016);
        if (C4996ah.doC() != null) {
            int i = C4996ah.doC().getInt("appbrandgame_use_commandbuffer", -1);
            if (i != -1) {
                if (i != 0) {
                    AppMethodBeat.m2505o(130016);
                    return true;
                }
                AppMethodBeat.m2505o(130016);
                return false;
            }
        }
        if (this.gOq != null) {
            C38163a appConfig = this.gOq.getAppConfig();
            if (appConfig.hfa) {
                boolean z = appConfig.heZ;
                AppMethodBeat.m2505o(130016);
                return z;
            }
        }
        C42142a c42142a = C32718b.eGM;
        C5141c ll = C42142a.m74295ll("100466");
        if (ll == null || !ll.isValid()) {
            AppMethodBeat.m2505o(130016);
            return false;
        } else if (C5046bo.getInt((String) ll.dru().get("useCommandBuffer"), 0) == 1) {
            AppMethodBeat.m2505o(130016);
            return true;
        } else {
            AppMethodBeat.m2505o(130016);
            return false;
        }
    }

    private boolean aAt() {
        AppMethodBeat.m2504i(130017);
        if (!this.hqp) {
            this.hqq = aAs();
            this.hqp = true;
        }
        boolean z = this.hqq;
        AppMethodBeat.m2505o(130017);
        return z;
    }

    public final boolean aui() {
        return true;
    }

    public final void aul() {
        AppMethodBeat.m2504i(130018);
        if (this.gPR == null) {
            super.aul();
            AppMethodBeat.m2505o(130018);
            return;
        }
        this.gPR.hqd = aAt();
        this.gPR.hqh = new C19223a(this, (byte) 0);
        this.gPR.hqc = true;
        this.gPR.hqe = true;
        this.gPR.hqi.allow_antialias_ = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_magicbrush_allow_antialias, false);
        this.gPR.hqi.allow_opengl3 = ((Boolean) C45554b.hqB.mo21639Uw()).booleanValue();
        super.aul();
        AppMethodBeat.m2505o(130018);
    }

    public final void auk() {
        AppMethodBeat.m2504i(130019);
        if (this.gPR == null) {
            AppMethodBeat.m2505o(130019);
            return;
        }
        MBRuntime mBRuntime = this.gPR.hqb;
        C6277h c6277h = (C6277h) mBRuntime.getFontHandler();
        C192301 c192301 = new C192301(new WeakReference(getRuntime()));
        c6277h.bSW = c192301;
        if (c6277h.bTn != null) {
            c6277h.bTn.bSW = c192301;
        }
        C37409a.m63027a(new C19229a());
        C37416a.m63045a(new C19228b());
        C33191b.m54293a(this.gPR.hqb, getRuntime(), true);
        AppMethodBeat.m2505o(130019);
    }

    /* renamed from: dw */
    public final void mo34948dw(boolean z) {
        AppMethodBeat.m2504i(130020);
        C4990ab.m7416i("MicroMsg.WAGameAppService", "onRuntimeResume");
        super.mo34948dw(z);
        if (this.hku != null) {
            this.hku.hjW.bringToFront();
        }
        AppMethodBeat.m2505o(130020);
    }

    public final void aup() {
        AppMethodBeat.m2504i(130021);
        C6747i aBx = aBx();
        if (aBx == null) {
            AppMethodBeat.m2505o(130021);
            return;
        }
        C33212n c33212n = (C33212n) aBx.mo14970af(C33212n.class);
        if (c33212n != null) {
            c33212n.setThreadPriority(-8);
        }
        AppMethodBeat.m2505o(130021);
    }

    public final MBRuntime getMBRuntime() {
        if (this.gPR == null) {
            return null;
        }
        return this.gPR.hqb;
    }

    /* renamed from: m */
    public final void mo34952m(C6750i c6750i) {
        AppMethodBeat.m2504i(130022);
        super.mo34952m(c6750i);
        QualitySessionRuntime DG = C27285a.m43319DG(getAppId());
        if (DG != null && DG.iDh.aLA()) {
            MBRuntime mBRuntime = getMBRuntime();
            if (mBRuntime != null) {
                C1000a inspector = mBRuntime.getInspector();
                synchronized (inspector.bSg) {
                    try {
                        if (inspector.bSg.mNativeInst == 0) {
                        } else {
                            inspector.bSg.nativeSetEnableInspectFpsVariance(inspector.bSg.mNativeInst, true);
                            AppMethodBeat.m2505o(130022);
                            return;
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(130022);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(130022);
    }

    /* renamed from: wO */
    public final void mo34953wO() {
        AppMethodBeat.m2504i(130023);
        C4990ab.m7416i("MicroMsg.WAGameAppService", "WAGameAppService.init");
        this.hqn = true;
        aAu();
        AppMethodBeat.m2505o(130023);
    }

    public final void auo() {
        AppMethodBeat.m2504i(130024);
        if (getRuntime() != null && getRuntime().mo43493yd()) {
            C5004al.m7441d(new C382142());
            String str = "xdebug";
            C19243l c19243l = (C19243l) aBx().mo14970af(C19243l.class);
            if (c19243l != null) {
                c19243l.mo30571Ce(str);
            }
            if (this.gPH) {
                try {
                    aBx().mo14967a(new URL("https://usr/" + "break.js"), "breakprogram();", null);
                } catch (MalformedURLException e) {
                    AppMethodBeat.m2505o(130024);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(130024);
    }

    private void aAu() {
        AppMethodBeat.m2504i(130025);
        C4990ab.m7417i("MicroMsg.WAGameAppService", "WAGameAppService.initImpl mServiceReady = [%b], mRendererReady = [%b]", Boolean.valueOf(this.hqn), Boolean.valueOf(this.hqm));
        if (!this.hqn || !this.hqm) {
            AppMethodBeat.m2505o(130025);
        } else if (isRunning()) {
            C4990ab.m7416i("MicroMsg.WAGameAppService", "WAGameAppService.initImpl start");
            aud();
            aAx();
            if (!aut()) {
                aAw();
            }
            atZ();
            AppMethodBeat.m2505o(130025);
        } else {
            C4990ab.m7416i("MicroMsg.WAGameAppService", "WAGameAppService.initImpl !isRunning, skip");
            AppMethodBeat.m2505o(130025);
        }
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(130026);
        super.cleanup();
        if (this.gPR != null) {
            try {
                this.gPR.hqj.bUA.get();
            } catch (InterruptedException e) {
                C17837c.m27913a("MagicBrush.SyncTask", e, "await failed", new Object[0]);
            } catch (ExecutionException e2) {
                C17837c.m27913a("MagicBrush.SyncTask", e2, "execute failed", new Object[0]);
            }
        }
        if (this.hku != null) {
            this.hku.destroy();
        }
        AppMethodBeat.m2505o(130026);
    }

    /* renamed from: h */
    public final void mo21957h(JSONObject jSONObject) {
        AppMethodBeat.m2504i(130027);
        super.mo21957h(jSONObject);
        mo21956b(jSONObject, "isIsolateContext", Boolean.valueOf(aut()));
        AppMethodBeat.m2505o(130027);
    }

    /* renamed from: i */
    public final void mo34951i(JSONObject jSONObject) {
        JSONObject jSONObject2;
        int systemDisplayHeight;
        int systemDisplayWidth;
        AppMethodBeat.m2504i(130028);
        super.mo34951i(jSONObject);
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
            mo21956b(jSONObject2, "subContextImgDomain", jSONArray);
        } catch (Exception e) {
        }
        mo21956b(jSONObject, "wxAppInfo", jSONObject2);
        MBRuntime mBRuntime = getMBRuntime();
        if (mBRuntime != null) {
            systemDisplayWidth = mBRuntime.getSystemDisplayWidth();
            systemDisplayHeight = mBRuntime.getSystemDisplayHeight();
        } else {
            systemDisplayHeight = 0;
            systemDisplayWidth = 0;
        }
        C4990ab.m7417i("MicroMsg.WAGameAppService", "dm.widthPixels %d, dm.heightPixels %d", Integer.valueOf(systemDisplayWidth), Integer.valueOf(systemDisplayHeight));
        if (C26835a.m42718t(getRuntime())) {
            C4990ab.m7416i("MicroMsg.WAGameAppService", "screen in right orientation");
            mo21956b(jSONObject, "screenWidth", Integer.valueOf(systemDisplayWidth));
            mo21956b(jSONObject, "screenHeight", Integer.valueOf(systemDisplayHeight));
        } else {
            C4990ab.m7420w("MicroMsg.WAGameAppService", "screen in reverse orientation");
            mo21956b(jSONObject, "screenWidth", Integer.valueOf(systemDisplayHeight));
            mo21956b(jSONObject, "screenHeight", Integer.valueOf(systemDisplayWidth));
        }
        mo21956b(jSONObject, "devicePixelRatio", Float.valueOf(C1338a.getDensity(getContext())));
        AppMethodBeat.m2505o(130028);
    }

    private void aAv() {
        AppMethodBeat.m2504i(130029);
        String str = C45672d.m84370Eb("wxa_library/android.js") + C45672d.m84370Eb("wxa_library/NativeGlobal-WAGame.js");
        if (aAt()) {
            str = str + C45672d.m84370Eb("wxa_library/commandbuffer.js");
        }
        C42682n.m75589a(aBx(), str, new C331883());
        AppMethodBeat.m2505o(130029);
    }

    private void aAw() {
        AppMethodBeat.m2504i(130030);
        if (C5058f.IS_FLAVOR_RED || C5058f.DEBUG) {
            C4990ab.m7409c("MicroMsg.WAGameAppService", "damon warns: This is only for test!!!!", new Object[0]);
            C19716o.m30528a(this, aBx(), "game.js", C33082aw.m54068a(getRuntime(), "game.js"), C19718a.USR, new C192204());
            AppMethodBeat.m2505o(130030);
            return;
        }
        AppMethodBeat.m2505o(130030);
    }

    private void aAx() {
        AppMethodBeat.m2504i(130031);
        if (this.hqo) {
            AppMethodBeat.m2505o(130031);
            return;
        }
        this.hqo = true;
        C4990ab.m7416i("MicroMsg.WAGameAppService", "Inject WAGame to MainContext");
        aAv();
        String str = "WAGame.js";
        String xu = WxaCommLibRuntimeReader.m42569xu("WAGame.js");
        String str2 = "v" + WxaCommLibRuntimeReader.avQ().gVu;
        C7060h.pYm.mo8378a(778, 13, 1, false);
        final long currentTimeMillis = System.currentTimeMillis();
        final boolean atU = atU();
        final int length = xu == null ? 0 : xu.length();
        C192215 c192215 = new C42683a() {
            public final void onSuccess(String str) {
                AppMethodBeat.m2504i(130006);
                C4990ab.m7417i("MicroMsg.WAGameAppService", "Inject SDK WAGame Script suc: %s", str);
                if (C42439b.this.atU() || C42439b.this.isRunning()) {
                    C27285a.aLz();
                    C38501b.m65164a(atU, C42439b.this.getAppId(), currentTimeMillis, "WAGame.js", (long) length);
                }
                C7060h.pYm.mo8378a(778, 15, 1, false);
                AppMethodBeat.m2505o(130006);
            }

            /* renamed from: lo */
            public final void mo5987lo(String str) {
                int i = 0;
                AppMethodBeat.m2504i(130007);
                C4990ab.m7413e("MicroMsg.WAGameAppService", "Inject SDK WAGame Script Failed: %s", str);
                C7060h.pYm.mo8378a(778, 14, 1, false);
                C19690c.m30502br(C42439b.this.getAppId(), 24);
                int i2 = -1;
                C41243o runtime = C42439b.this.getRuntime();
                if (runtime != null) {
                    i = runtime.atH().hhd.gVu;
                    i2 = runtime.atH().hhd.gVt;
                }
                C19690c.m30497a(C42439b.this.getAppId(), i, i2, 778, 14);
                AppMethodBeat.m2505o(130007);
            }
        };
        if (getRuntime() == null || !getRuntime().mo43493yd()) {
            C19716o.m30529a((C38492q) this, aBx(), str, "WAGame.js", str2, xu, C19718a.LIB, (C42683a) c192215);
            AppMethodBeat.m2505o(130031);
            return;
        }
        C19716o.m30530b(this, aBx(), "WAGame.js", ";(function(global) { var protectedConsole = global.console; Object.defineProperty(global, 'console', { get() { return protectedConsole; }, set() { } }); })(this);".concat(String.valueOf(xu)), C19718a.LIB, c192215);
        AppMethodBeat.m2505o(130031);
    }

    /* renamed from: xd */
    public final void mo34956xd(String str) {
        AppMethodBeat.m2504i(130032);
        C4990ab.m7416i("MicroMsg.WAGameAppService", "hy: do nothing in game service when called from modularizing helper");
        AppMethodBeat.m2505o(130032);
    }

    /* renamed from: xc */
    public final String mo61201xc(String str) {
        AppMethodBeat.m2504i(130033);
        String str2;
        if (getRuntime() == null || !getRuntime().mo43493yd()) {
            str2 = "";
            AppMethodBeat.m2505o(130033);
            return str2;
        }
        str2 = C26852t.m42763a(str, getRuntime());
        AppMethodBeat.m2505o(130033);
        return str2;
    }

    public final void atV() {
        AppMethodBeat.m2504i(130034);
        C4990ab.m7416i("MicroMsg.WAGameAppService", "start preload");
        auj();
        mo34931a(aBx());
        aAx();
        C4990ab.m7416i("MicroMsg.WAGameAppService", "WAGameAppService preloaded.");
        AppMethodBeat.m2505o(130034);
    }

    public final boolean aut() {
        AppMethodBeat.m2504i(130035);
        if (C5058f.DEBUG || C5058f.IS_FLAVOR_RED) {
            boolean booleanValue = ((Boolean) C31292d.hqL.mo21639Uw()).booleanValue();
            AppMethodBeat.m2505o(130035);
            return booleanValue;
        }
        AppMethodBeat.m2505o(130035);
        return true;
    }
}
