package com.tencent.p177mm.plugin.appbrand;

import android.content.Context;
import android.graphics.Point;
import android.util.Pair;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.luggage.sdk.p819a.p820a.C37402a;
import com.tencent.luggage.sdk.p819a.p820a.C45126b;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.p821d.C8881a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p232b.p233a.C32669br;
import com.tencent.p177mm.p230g.p232b.p233a.C32669br.C32668a;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.game.C42437a;
import com.tencent.p177mm.plugin.appbrand.game.C42437a.C19216b;
import com.tencent.p177mm.plugin.appbrand.game.C42437a.C26880c;
import com.tencent.p177mm.plugin.appbrand.game.C42437a.C424351;
import com.tencent.p177mm.plugin.appbrand.game.p291a.C10230f;
import com.tencent.p177mm.plugin.appbrand.game.p291a.C38213c;
import com.tencent.p177mm.plugin.appbrand.game.p293c.C2157d;
import com.tencent.p177mm.plugin.appbrand.game.p293c.C33191b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19346bo;
import com.tencent.p177mm.plugin.appbrand.jsapi.C27069q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C2319b;
import com.tencent.p177mm.plugin.appbrand.p1472u.C33536a;
import com.tencent.p177mm.plugin.appbrand.p297h.C10257s;
import com.tencent.p177mm.plugin.appbrand.p297h.C26903t;
import com.tencent.p177mm.plugin.appbrand.p297h.C33211h;
import com.tencent.p177mm.plugin.appbrand.p297h.C33212n;
import com.tencent.p177mm.plugin.appbrand.p297h.C38237q;
import com.tencent.p177mm.plugin.appbrand.p297h.C38238z;
import com.tencent.p177mm.plugin.appbrand.p297h.C42451v;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.plugin.appbrand.p297h.C6748m;
import com.tencent.p177mm.plugin.appbrand.p298j.C26909g;
import com.tencent.p177mm.plugin.appbrand.p322m.C10612a;
import com.tencent.p177mm.plugin.appbrand.p322m.C45651d;
import com.tencent.p177mm.plugin.appbrand.p322m.p1229b.C19598a;
import com.tencent.p177mm.plugin.appbrand.p328r.C45672d;
import com.tencent.p177mm.plugin.appbrand.p329s.C19716o;
import com.tencent.p177mm.plugin.appbrand.p329s.C19716o.C19718a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42681l;
import com.tencent.p177mm.plugin.appbrand.p329s.C42682n;
import com.tencent.p177mm.plugin.appbrand.p329s.C42682n.C42683a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42685u;
import com.tencent.p177mm.plugin.appbrand.p893e.C45551d;
import com.tencent.p177mm.plugin.appbrand.page.C19639h;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.page.C45664i;
import com.tencent.p177mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.p177mm.plugin.appbrand.permission.C33489a;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.report.C42669a;
import com.tencent.p177mm.plugin.appbrand.report.model.C33516e;
import com.tencent.p177mm.plugin.appbrand.report.quality.C2452f;
import com.tencent.p177mm.plugin.appbrand.report.quality.C27285a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C38501b;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.p177mm.plugin.appbrand.task.C38519g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.udp.libmmudp.C44232a;
import com.tencent.p177mm.udp.libmmudp.UdpNative;
import com.tencent.p177mm.udp.libmmudp.UdpNative.C5165b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.s */
public class C19722s extends C45126b implements C26909g {
    protected C41243o gOq;
    private volatile boolean gPO = false;
    private volatile boolean gPP = false;
    private volatile boolean gPQ = false;
    protected C42437a gPR;
    private C19598a gPS = null;
    private final LinkedList<Runnable> gPT = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.appbrand.s$8 */
    class C107248 implements C33211h {
        C107248() {
        }

        /* renamed from: C */
        public final void mo5989C(String str, String str2) {
            AppMethodBeat.m2504i(129076);
            C4990ab.m7413e("MicroMsg.AppBrandService", "hy: wxa main context exception %s %s", str, str2);
            String format = String.format("{'message':'%s', 'stack': '%s'}", new Object[]{C42681l.m75588Ej(str), C42681l.m75588Ej(str2)});
            C19346bo.m30025a(C19722s.this.aBx(), "onError", format, 0);
            C4990ab.m7412e("MicroMsg.AppBrand.JsRuntimeException", format);
            try {
                C2452f.m4692a(C19722s.this, str, str2);
                AppMethodBeat.m2505o(129076);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(129076);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.s$11 */
    class C1970811 implements C42683a {
        C1970811() {
        }

        public final void onSuccess(String str) {
            AppMethodBeat.m2504i(129081);
            C4990ab.m7416i("MicroMsg.AppBrandService", "Inject performanceJs Script Success");
            AppMethodBeat.m2505o(129081);
        }

        /* renamed from: lo */
        public final void mo5987lo(String str) {
            AppMethodBeat.m2504i(129082);
            C4990ab.m7412e("MicroMsg.AppBrandService", "Inject performanceJs Script Failed");
            AppMethodBeat.m2505o(129082);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.s$6 */
    class C197236 extends C19639h {
        C197236() {
        }

        /* renamed from: t */
        public final /* synthetic */ C42467ah mo34958t(Map map) {
            AppMethodBeat.m2504i(129073);
            C38369p s = mo34957s(map);
            AppMethodBeat.m2505o(129073);
            return s;
        }

        /* renamed from: s */
        public final C38369p mo34957s(Map<String, Object> map) {
            AppMethodBeat.m2504i(129072);
            JSONObject jSONObject = new JSONObject(map);
            C41243o runtime = C19722s.this.getRuntime();
            try {
                Pair l = C33516e.m54743l((C27242w) runtime.asV().getCurrentPage().getCurrentPageView());
                String str = (String) l.second;
                jSONObject.put("targetAction", ((Integer) l.first).intValue());
                jSONObject.put("targetPagePath", str);
                jSONObject.put("usedState", runtime.mo43491ya().bQn.iAo);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterBackground ex = %s", e);
            }
            super.mo61027AL(jSONObject.toString());
            AppMethodBeat.m2505o(129072);
            return this;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.s$9 */
    class C197249 implements C42683a {
        C197249() {
        }

        public final void onSuccess(String str) {
            AppMethodBeat.m2504i(129077);
            C4990ab.m7416i("MicroMsg.AppBrandService", "Inject android.js Script Success");
            AppMethodBeat.m2505o(129077);
        }

        /* renamed from: lo */
        public final void mo5987lo(String str) {
            AppMethodBeat.m2504i(129078);
            C4990ab.m7412e("MicroMsg.AppBrandService", "Inject android.js Script Failed");
            AppMethodBeat.m2505o(129078);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.s$5 */
    class C197305 implements Runnable {
        C197305() {
        }

        public final void run() {
            AppMethodBeat.m2504i(129071);
            C4990ab.m7416i("MicroMsg.AppBrandService", "destoryUdpBinding destoryUdp");
            UdpNative.instance().destoryUdp();
            AppMethodBeat.m2505o(129071);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m30535b(C19722s c19722s) {
        AppMethodBeat.m2504i(129113);
        c19722s.aus();
        AppMethodBeat.m2505o(129113);
    }

    public final /* synthetic */ C44709u getCurrentPageView() {
        AppMethodBeat.m2504i(129112);
        C27242w aun = aun();
        AppMethodBeat.m2505o(129112);
        return aun;
    }

    /* renamed from: xL */
    public /* synthetic */ C25697b mo34954xL() {
        AppMethodBeat.m2504i(129109);
        C41243o runtime = getRuntime();
        AppMethodBeat.m2505o(129109);
        return runtime;
    }

    /* renamed from: xV */
    public final /* synthetic */ C37402a mo34955xV() {
        AppMethodBeat.m2504i(129110);
        C27242w aun = aun();
        AppMethodBeat.m2505o(129110);
        return aun;
    }

    public C19722s() {
        boolean z = false;
        AppMethodBeat.m2504i(129083);
        if (C5047bp.dpL() || C5058f.IS_FLAVOR_RED) {
            z = true;
        }
        this.gNV = z;
        AppMethodBeat.m2505o(129083);
    }

    /* Access modifiers changed, original: protected */
    public boolean aui() {
        AppMethodBeat.m2504i(129084);
        boolean a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_waservice_webgl_component, true);
        AppMethodBeat.m2505o(129084);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final void auj() {
        AppMethodBeat.m2504i(129085);
        String str = "MicroMsg.AppBrandService";
        String str2 = "setup magicbrush. loaded?[%b]";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.gPR != null);
        C4990ab.m7417i(str, str2, objArr);
        if (this.gPR != null) {
            AppMethodBeat.m2505o(129085);
        } else if (aui()) {
            long yz = C5046bo.m7588yz();
            aCd();
            this.gPR = new C42437a();
            aul();
            C42437a c42437a = this.gPR;
            Context context = getContext();
            IllegalStateException illegalStateException;
            if (c42437a.hqf == null) {
                illegalStateException = new IllegalStateException("JsRuntime invalid");
                AppMethodBeat.m2505o(129085);
                throw illegalStateException;
            } else if (c42437a.hqg == null) {
                illegalStateException = new IllegalStateException("JsThreadHandler invalid");
                AppMethodBeat.m2505o(129085);
                throw illegalStateException;
            } else {
                long j;
                c42437a.hqi.device_pixel_ratio_ = (double) C8881a.getDensity(context);
                Point aA = C8881a.m15856aA(context);
                c42437a.hqi.screen_width_ = aA.x;
                c42437a.hqi.screen_height_ = aA.y;
                c42437a.hqi.use_command_buffer = c42437a.hqd;
                c42437a.hqi.adjust_thread_priority = c42437a.hqc;
                c42437a.hqi.enable_request_animation_frame = c42437a.hqe;
                c42437a.hqi.gc_factor = C38213c.hqH.mo60949cD(context);
                c42437a.hqi.enable_wxbindcanvastexture = C10230f.aAE();
                c42437a.hqb = new MBRuntime(c42437a.hqi);
                if (c42437a.hqh != null) {
                    c42437a.hqb.registerEventListener(c42437a.hqh);
                }
                c42437a.hqb.registerEventListener(new C19216b());
                c42437a.hqb.setJsThreadHandler(c42437a.hqg);
                c42437a.hqb.init();
                c42437a.hqg.mo33017f(new C424351());
                C27285a.aLz();
                boolean atU = atU();
                str = getAppId();
                C32669br c32669br = new C32669br();
                if (!atU) {
                    QualitySessionRuntime DG = C27285a.m43319DG(str);
                    if (DG != null) {
                        c32669br.mo53195gq(DG.appId);
                        c32669br.mo53194gp(DG.igT);
                        c32669br.ddH = C32668a.m53282gS(DG.iCZ);
                        c32669br.ddz = (long) DG.apptype;
                        c32669br.cVR = (long) DG.scene;
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandService", "setup magicbrush, done. cost?[%d]", Long.valueOf(C5046bo.m7525az(yz)));
                    AppMethodBeat.m2505o(129085);
                }
                c32669br.mo53192dA(yz);
                c32669br.mo53191GX();
                c32669br.mo53193dz(c32669br.ddC - c32669br.ddB);
                if (atU) {
                    j = 1;
                } else {
                    j = 0;
                }
                c32669br.ddI = j;
                c32669br.ajK();
                C4990ab.m7417i("MicroMsg.AppBrandService", "setup magicbrush, done. cost?[%d]", Long.valueOf(C5046bo.m7525az(yz)));
                AppMethodBeat.m2505o(129085);
            }
        } else {
            C4990ab.m7416i("MicroMsg.AppBrandService", "setup magicbrush, done. expt closed");
            AppMethodBeat.m2505o(129085);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo34931a(final C6747i c6747i) {
        AppMethodBeat.m2504i(129086);
        C4990ab.m7416i("MicroMsg.AppBrandService", "createUdpBinding");
        if (UdpNative.instance().hasInit()) {
            C4990ab.m7416i("MicroMsg.AppBrandService", "createUdpBinding hasInit");
            AppMethodBeat.m2505o(129086);
        } else if (c6747i == null) {
            C4990ab.m7412e("MicroMsg.AppBrandService", "createUdpBinding jsruntime is null");
            AppMethodBeat.m2505o(129086);
        } else {
            C44232a.m79828yB();
            final C33212n c33212n = (C33212n) c6747i.mo14970af(C33212n.class);
            if (c33212n == null) {
                C4990ab.m7412e("MicroMsg.AppBrandService", "createUdpBinding jsThreadHandler is null");
                AppMethodBeat.m2505o(129086);
                return;
            }
            final C197091 c197091 = new C5165b() {
                /* renamed from: xe */
                public final void mo10621xe(final String str) {
                    AppMethodBeat.m2504i(129064);
                    c33212n.mo30581f(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(129063);
                            C4990ab.m7417i("MicroMsg.AppBrandService", "onCallBack apiName:%s", str);
                            UdpNative.instance().updateNativeInterface();
                            AppMethodBeat.m2505o(129063);
                        }
                    });
                    AppMethodBeat.m2505o(129064);
                }
            };
            c33212n.mo30581f(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(129070);
                    C4990ab.m7416i("MicroMsg.AppBrandService", "createUdpBinding initBindingUdp");
                    C10257s c10257s = (C10257s) c6747i.mo14970af(C10257s.class);
                    if (c10257s == null) {
                        C4990ab.m7412e("MicroMsg.AppBrandService", "createUdpBinding v8Addon is null");
                        AppMethodBeat.m2505o(129070);
                        return;
                    }
                    UdpNative.instance().initBindingUdp(c10257s.getIsolatePtr(), c10257s.aGW());
                    UdpNative.instance().InitCallBack(c197091);
                    AppMethodBeat.m2505o(129070);
                }
            });
            AppMethodBeat.m2505o(129086);
        }
    }

    /* Access modifiers changed, original: protected */
    public void auk() {
        AppMethodBeat.m2504i(129087);
        if (this.gPR != null) {
            C33191b.m54293a(this.gPR.hqb, getRuntime(), false);
        }
        AppMethodBeat.m2505o(129087);
    }

    /* Access modifiers changed, original: protected */
    public void aul() {
        AppMethodBeat.m2504i(129088);
        if (this.gPR != null) {
            C42437a c42437a = this.gPR;
            C6747i aBx = aBx();
            c42437a.hqf = aBx;
            IllegalArgumentException illegalArgumentException;
            if (aBx.mo14970af(C10257s.class) == null) {
                illegalArgumentException = new IllegalArgumentException("JsRuntime not support addon: V8");
                AppMethodBeat.m2505o(129088);
                throw illegalArgumentException;
            } else if (aBx.mo14970af(C33212n.class) == null) {
                illegalArgumentException = new IllegalArgumentException("JsRuntime not support addon: JsThread");
                AppMethodBeat.m2505o(129088);
                throw illegalArgumentException;
            } else if (aBx.mo14970af(C6748m.class) == null) {
                illegalArgumentException = new IllegalArgumentException("JsRuntime not support addon: DestroyListener");
                AppMethodBeat.m2505o(129088);
                throw illegalArgumentException;
            } else {
                c42437a.hqg = new C26880c(aBx, (byte) 0);
            }
        }
        AppMethodBeat.m2505o(129088);
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

    public final C27242w aun() {
        AppMethodBeat.m2504i(129089);
        C27242w c27242w = (C27242w) super.mo61196ac(C27242w.class);
        AppMethodBeat.m2505o(129089);
        return c27242w;
    }

    /* Access modifiers changed, original: protected|final */
    public final C42701w atY() {
        AppMethodBeat.m2504i(129090);
        C44720x c44720x = new C44720x(this);
        AppMethodBeat.m2505o(129090);
        return c44720x;
    }

    public C6747i aua() {
        String aBv;
        byte[] Ec;
        C38519g c38519g = null;
        AppMethodBeat.m2504i(129091);
        long currentTimeMillis = System.currentTimeMillis();
        if (getContext() == null) {
            C4996ah.getContext();
        }
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
        int i = WxaCommLibRuntimeReader.avQ().gVu;
        C18994ac.aux();
        C6747i d = C26903t.m42836d(i, aBv, Ec);
        boolean z;
        if (d instanceof C42451v) {
            this.gPS = new C10612a();
            C19598a c19598a = this.gPS;
            C4990ab.m7416i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCreateJsRuntime");
            c19598a.iqc = new C45651d(this, d);
            d.addJavascriptInterface(c19598a.iqc, "gJavaBroker");
            z = true;
        } else {
            z = false;
        }
        C38237q c38237q = (C38237q) d.mo14970af(C38237q.class);
        if (c38237q != null && (C18994ac.aux() || z)) {
            C36711f c36711f = new C36711f(this, c38237q);
            d.addJavascriptInterface(c36711f, "WeixinJSContext");
            c36711f.asH();
            this.gPO = true;
        }
        mo34931a(d);
        C27285a.aLz();
        if (atU()) {
            c38519g = C38519g.WASERVICE;
        }
        C38501b.m65161a(c38519g, getAppId(), currentTimeMillis, C42669a.m75572d(d));
        AppMethodBeat.m2505o(129091);
        return d;
    }

    public void cleanup() {
        AppMethodBeat.m2504i(129092);
        if (this.gPR != null) {
            C42437a c42437a = this.gPR;
            ((C6748m) c42437a.hqf.mo14970af(C6748m.class)).mo14974a(c42437a.hqj);
        }
        C6747i aBx = aBx();
        C4990ab.m7416i("MicroMsg.AppBrandService", "destoryUdpBinding");
        if (!UdpNative.instance().hasInit()) {
            C4990ab.m7416i("MicroMsg.AppBrandService", "destoryUdpBinding not Init");
        } else if (aBx == null) {
            C4990ab.m7412e("MicroMsg.AppBrandService", "destoryUdpBinding jsruntime is null");
        } else {
            C33212n c33212n = (C33212n) aBx.mo14970af(C33212n.class);
            if (c33212n == null) {
                C4990ab.m7412e("MicroMsg.AppBrandService", "destoryUdpBinding jsThreadHandler is null");
            } else {
                c33212n.mo30581f(new C197305());
            }
        }
        super.cleanup();
        this.gOq = null;
        if (this.gPS != null) {
            C19598a c19598a = this.gPS;
            C4990ab.m7416i("MicroMsg.AppBrandNodeJSInstallHelper", "whenCleanUp");
            if (c19598a.iqc == null) {
                IllegalStateException illegalStateException = new IllegalStateException("You had not called whenCreateJsRuntime!");
                AppMethodBeat.m2505o(129092);
                throw illegalStateException;
            }
            c19598a.iqc.aIS();
        }
        AppMethodBeat.m2505o(129092);
    }

    public Map<String, C45608m> aub() {
        AppMethodBeat.m2504i(129093);
        Map aCh = C27069q.aCh();
        AppMethodBeat.m2505o(129093);
        return aCh;
    }

    /* Access modifiers changed, original: protected */
    public void atV() {
        AppMethodBeat.m2504i(129094);
        auj();
        mo34931a(aBx());
        auq();
        AppMethodBeat.m2505o(129094);
    }

    /* Access modifiers changed, original: protected */
    public void aud() {
        AppMethodBeat.m2504i(129095);
        super.aud();
        C42685u.m75595a(this.gOq, aBx());
        auo();
        if (this.gPH) {
            super.mo61200bo("onWxConfigReady", "");
        }
        AppMethodBeat.m2505o(129095);
    }

    public void auo() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: wO */
    public void mo34953wO() {
        AppMethodBeat.m2504i(129096);
        try {
            aup();
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandService", th, "[NOT CRASH]", new Object[0]);
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
                AppMethodBeat.m2505o(129096);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        atZ();
    }

    /* renamed from: m */
    public void mo34952m(C6750i c6750i) {
        AppMethodBeat.m2504i(129097);
        this.gOq = (C41243o) c6750i;
        super.mo34952m(c6750i);
        this.hvM = new C33489a(this.gOq, this);
        auj();
        mo34931a(aBx());
        auk();
        try {
            aup();
            AppMethodBeat.m2505o(129097);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandService", th, "[NOT CRASH]", new Object[0]);
            AppMethodBeat.m2505o(129097);
        }
    }

    /* Access modifiers changed, original: protected */
    public void aup() {
        AppMethodBeat.m2504i(129098);
        C6747i aBx = aBx();
        if (aBx == null) {
            AppMethodBeat.m2505o(129098);
            return;
        }
        C33212n c33212n = (C33212n) aBx.mo14970af(C33212n.class);
        if (c33212n != null) {
            c33212n.setThreadPriority(-2);
        }
        AppMethodBeat.m2505o(129098);
    }

    /* Access modifiers changed, original: protected|final */
    public final void atW() {
        AppMethodBeat.m2504i(129099);
        C4990ab.m7416i("MicroMsg.AppBrandService", "dl: onRuntimePause, dispatch AppBrandOnAppEnterBackgroundEvent ");
        new C197236().mo34864A(getRuntime());
        try {
            C6747i aBx = aBx();
            if (aBx != null) {
                C33212n c33212n = (C33212n) aBx.mo14970af(C33212n.class);
                if (c33212n != null) {
                    c33212n.setThreadPriority(10);
                }
                AppMethodBeat.m2505o(129099);
                return;
            }
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandService", th, "[NOT CRASH]", new Object[0]);
        }
        AppMethodBeat.m2505o(129099);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: dw */
    public void mo34948dw(final boolean z) {
        AppMethodBeat.m2504i(129100);
        C4990ab.m7416i("MicroMsg.AppBrandService", "dl:onRuntimeResume, dispatch AppBrandOnAppEnterForegroundEvent");
        if (getRuntime() == null) {
            C4990ab.m7420w("MicroMsg.AppBrandService", "onRuntimeResume, getRuntime == NULL");
            AppMethodBeat.m2505o(129100);
            return;
        }
        new C45664i() {
            /* renamed from: t */
            public final /* synthetic */ C42467ah mo34958t(Map map) {
                AppMethodBeat.m2504i(129075);
                C38369p s = mo34957s(map);
                AppMethodBeat.m2505o(129075);
                return s;
            }

            /* renamed from: s */
            public final C38369p mo34957s(Map<String, Object> map) {
                AppMethodBeat.m2504i(129074);
                map.put("scene", Integer.valueOf(C19722s.this.getRuntime().mo43491ya().bQn.scene));
                JSONObject xA = C19722s.this.getRuntime().atI().mo32987xA();
                if (xA != null) {
                    map.put("shareInfo", xA);
                }
                JSONObject jSONObject = new JSONObject(map);
                C41243o runtime = C19722s.this.getRuntime();
                if (z) {
                    C33516e.m54741a(runtime, jSONObject);
                } else {
                    try {
                        C33516e.m54742b(runtime, jSONObject);
                        jSONObject.put("referpagepath", runtime.atJ().getReporter().aHX().aLo().iBm);
                        jSONObject.put("clickTimestamp", runtime.atI().startTime);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterForeground ex = %s", e);
                    }
                }
                super.mo61027AL(jSONObject.toString());
                AppMethodBeat.m2505o(129074);
                return this;
            }
        }.mo73457a(getRuntime(), z);
        try {
            aup();
            AppMethodBeat.m2505o(129100);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandService", th, "[NOT CRASH]", new Object[0]);
            AppMethodBeat.m2505o(129100);
        }
    }

    /* renamed from: h */
    public void mo21957h(JSONObject jSONObject) {
        AppMethodBeat.m2504i(129101);
        super.mo21957h(jSONObject);
        mo21956b(jSONObject, "clientVersion", Integer.valueOf(C7243d.vxo));
        if (getClass() == C19722s.class) {
            mo21956b(jSONObject, "isIsolateContext", Boolean.valueOf(this.gPO));
        }
        mo21956b(jSONObject, "JSEngineName", C26903t.m42834b(aBx()));
        C45551d.m84004a(C33536a.aSj(), jSONObject);
        C45551d.m84006b(C33536a.aSk(), jSONObject);
        AppMethodBeat.m2505o(129101);
    }

    /* renamed from: xW */
    public final JSONObject mo21959xW() {
        AppMethodBeat.m2504i(129102);
        JSONObject xW = super.mo21959xW();
        mo34951i(xW);
        AppMethodBeat.m2505o(129102);
        return xW;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: i */
    public void mo34951i(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject jSONObject2;
        AppMethodBeat.m2504i(129103);
        mo21956b(jSONObject, "debug", Boolean.valueOf(this.gOq.atH().bQp));
        JSONObject jSONObject3 = new JSONObject();
        mo21956b(jSONObject3, "scene", Integer.valueOf(this.gOq.mo43491ya().bQn.scene));
        String atc = this.gOq.atc();
        mo21956b(jSONObject3, "path", C8874h.m15847bO(atc));
        mo21956b(jSONObject3, SearchIntents.EXTRA_QUERY, new JSONObject(C8874h.m15848bP(atc)));
        mo21956b(jSONObject3, "referrerInfo", this.gOq.atI().hgF.ayF());
        mo21956b(jSONObject3, "shareInfo", this.gOq.atI().mo32987xA());
        C33516e.m54741a(this.gOq, jSONObject3);
        AppBrandSysConfigWC atH = this.gOq.atH();
        JSONObject jSONObject4 = new JSONObject();
        mo21956b(jSONObject4, "maxRequestConcurrent", Integer.valueOf(atH.bQw));
        mo21956b(jSONObject4, "maxUploadConcurrent", Integer.valueOf(atH.bQx));
        mo21956b(jSONObject4, "maxDownloadConcurrent", Integer.valueOf(atH.bQy));
        mo21956b(jSONObject4, "maxWebsocketConnect", Integer.valueOf(atH.bQz));
        mo21956b(jSONObject4, "maxWorkerConcurrent", Integer.valueOf(atH.bQA));
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
            jSONObject2.put("HAS_SPLASHSCREEN", ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_appbrand_game_splashscreen, false) ? 1 : 0);
        } catch (Exception e) {
        }
        mo21956b(jSONObject, "appLaunchInfo", jSONObject3);
        mo21956b(jSONObject, "wxAppInfo", jSONObject4);
        mo21956b(jSONObject, "isPluginMiniProgram", Boolean.valueOf(getRuntime().atD()));
        mo21956b(jSONObject, "envVersion", C2319b.m4540ot(this.gOq.atI().gVs).name().toLowerCase());
        jSONObject2 = new JSONObject();
        try {
            jSONObject2 = new JSONObject(this.gOq.atI().bQk);
        } catch (Exception e2) {
        }
        try {
            if (!C5046bo.isNullOrNil(atH.bQu)) {
                optJSONObject = new JSONObject();
                optJSONObject.put("jsonInfo", new JSONObject(atH.bQu));
                mo21956b(jSONObject2, "operationInfo", optJSONObject);
            }
        } catch (Exception e3) {
            C4990ab.m7413e("MicroMsg.AppBrandService", "postProcessConfig, put operationInfo to appContactInfo fail", e3);
        }
        mo21956b(jSONObject, "appContactInfo", jSONObject2);
        mo21956b(jSONObject, "accountInfo", this.gOq.atI().mo32988xB());
        AppMethodBeat.m2505o(129103);
    }

    private void auq() {
        String Eb;
        AppMethodBeat.m2504i(129104);
        if (!this.gPQ) {
            aBx().setJsExceptionHandler(new C107248());
            Eb = C45672d.m84370Eb("wxa_library/android.js");
            if (this.gPS != null) {
                Eb = Eb + this.gPS.aIW();
            }
            if (this.gPR != null) {
                Eb = Eb + C45672d.m84370Eb("wxa_library/NativeGlobal-WAService.js");
            } else {
                Eb = Eb + C45672d.m84370Eb("wxa_library/NativeGlobal-Dummy.js");
            }
            C42682n.m75589a(aBx(), Eb, new C197249());
            String xu = WxaCommLibRuntimeReader.m42569xu("WAService.js");
            Eb = "v" + WxaCommLibRuntimeReader.avQ().gVu;
            final long currentTimeMillis = System.currentTimeMillis();
            final boolean atU = atU();
            final int length = xu == null ? 0 : xu.length();
            C19716o.m30529a((C38492q) this, aBx(), "WAService.js", "WAService.js", Eb, xu, C19718a.LIB, (C42683a) new C42683a() {
                public final void onSuccess(String str) {
                    AppMethodBeat.m2504i(129079);
                    C4990ab.m7417i("MicroMsg.AppBrandService", "Inject SDK Service Script Successwx.version = %s", WxaCommLibRuntimeReader.avP().avk());
                    if (C19722s.this.atU() || C19722s.this.isRunning()) {
                        C27285a.aLz();
                        C38501b.m65164a(atU, C19722s.this.getAppId(), currentTimeMillis, "WAService.js", (long) length);
                    }
                    C7060h.pYm.mo8378a(370, 7, 1, false);
                    AppMethodBeat.m2505o(129079);
                }

                /* renamed from: lo */
                public final void mo5987lo(String str) {
                    int i = 0;
                    AppMethodBeat.m2504i(129080);
                    C4990ab.m7413e("MicroMsg.AppBrandService", "Inject SDK Service Script Failed: %s, wx.version = %s", str, WxaCommLibRuntimeReader.avP().avk());
                    C7060h.pYm.mo8378a(370, 6, 1, false);
                    C19690c.m30502br(C19722s.this.getAppId(), 24);
                    int i2 = -1;
                    if (C19722s.this.gOq != null) {
                        i = C19722s.this.gOq.atH().hhd.gVu;
                        i2 = C19722s.this.gOq.atH().hhd.gVt;
                    }
                    C19690c.m30497a(C19722s.this.getAppId(), i, i2, 370, 6);
                    AppMethodBeat.m2505o(129080);
                }
            });
            C7060h.pYm.mo8378a(370, 5, 1, false);
            this.gPQ = true;
        }
        Eb = this.gOq != null ? aur() : null;
        if (!C5046bo.isNullOrNil(Eb)) {
            C42682n.m75589a(aBx(), Eb, new C1970811());
        }
        AppMethodBeat.m2505o(129104);
    }

    private String aur() {
        AppMethodBeat.m2504i(129105);
        String str = null;
        if (AppBrandPerformanceManager.m43291b(getRuntime())) {
            str = WxaCommLibRuntimeReader.m42569xu("WAPerf.js");
        }
        AppMethodBeat.m2505o(129105);
        return str;
    }

    private void aus() {
        AppMethodBeat.m2504i(129106);
        if (this.gPO) {
            AppMethodBeat.m2505o(129106);
        } else if (this.gPP) {
            AppMethodBeat.m2505o(129106);
        } else {
            C42685u.m75595a(getRuntime(), aBx());
            final String a = C33082aw.m54068a(getRuntime(), "app-service.js");
            String str = "app-service.js";
            if (C5046bo.isNullOrNil(a)) {
                AppMethodBeat.m2505o(129106);
                return;
            }
            C7060h.pYm.mo8378a(370, 9, 1, false);
            final long currentTimeMillis = System.currentTimeMillis();
            C19716o.m30527a(getRuntime(), aBx(), str, str + "_" + getAppId(), getRuntime().atH().hhd.cvZ, a, C19718a.USR, new C42683a() {
                public final void onSuccess(String str) {
                    int i = -1;
                    AppMethodBeat.m2504i(129065);
                    if (C19722s.this.atU() || C19722s.this.isRunning()) {
                        C41243o runtime = C19722s.this.getRuntime();
                        String str2 = "MicroMsg.AppBrandService";
                        String str3 = "[QualitySystem] app-service.js runtime.hashCode = [%d]";
                        Object[] objArr = new Object[1];
                        objArr[0] = Integer.valueOf(runtime != null ? runtime.hashCode() : -1);
                        C4990ab.m7417i(str2, str3, objArr);
                        str2 = C19722s.this.getAppId();
                        str3 = "app-service.js";
                        String str4 = a;
                        long j = currentTimeMillis;
                        if (runtime != null) {
                            i = runtime.hashCode();
                        }
                        C27285a.m43322a(str2, str3, str4, j, i);
                    }
                    C7060h.pYm.mo8378a(370, 11, 1, false);
                    AppMethodBeat.m2505o(129065);
                }

                /* renamed from: lo */
                public final void mo5987lo(String str) {
                    AppMethodBeat.m2504i(129066);
                    C4990ab.m7413e("MicroMsg.AppBrandService", "Inject External Service Script Failed: %s", str);
                    try {
                        C7060h.pYm.mo8378a(370, 10, 1, false);
                        C19690c.m30502br(C19722s.this.getAppId(), 24);
                        C19690c.m30497a(C19722s.this.getAppId(), C19722s.this.gOq.atH().hhd.gVu, C19722s.this.gOq.atH().hhd.gVt, 370, 10);
                        AppMethodBeat.m2505o(129066);
                    } catch (NullPointerException e) {
                        C4990ab.m7413e("MicroMsg.AppBrandService", "Inject External Service Script Failed, report npe = %s", e);
                        AppMethodBeat.m2505o(129066);
                    }
                }
            });
            this.gPP = true;
            AppMethodBeat.m2505o(129106);
        }
    }

    /* renamed from: xd */
    public void mo34956xd(final String str) {
        AppMethodBeat.m2504i(129107);
        C197273 c197273 = new Runnable() {

            /* renamed from: com.tencent.mm.plugin.appbrand.s$3$1 */
            class C197281 implements C42683a {
                C197281() {
                }

                public final void onSuccess(String str) {
                    AppMethodBeat.m2504i(129067);
                    C7060h.pYm.mo8378a(370, 31, 1, false);
                    AppMethodBeat.m2505o(129067);
                }

                /* renamed from: lo */
                public final void mo5987lo(String str) {
                    AppMethodBeat.m2504i(129068);
                    C4990ab.m7413e("MicroMsg.AppBrandService", "inject module(%s) script failed: %s", str, str);
                    C7060h.pYm.mo8378a(370, 32, 1, false);
                    AppMethodBeat.m2505o(129068);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(129069);
                if (C19722s.this.gPO) {
                    try {
                        C19722s.this.mo61200bo("onSubPackageReady", new JSONObject().put("moduleName", str).toString());
                        AppMethodBeat.m2505o(129069);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.AppBrandService", "loadModule using isolate context, notify but get exception %s");
                        AppMethodBeat.m2505o(129069);
                    }
                } else if ("__APP__".equals(str)) {
                    C19722s.m30535b(C19722s.this);
                    AppMethodBeat.m2505o(129069);
                } else {
                    String str = str + (str.endsWith("/") ? "" : "/") + "app-service.js";
                    String a = C33082aw.m54068a(C19722s.this.gOq, str);
                    C7060h.pYm.mo8378a(370, 30, 1, false);
                    C19716o.m30527a(C19722s.this.getRuntime(), C19722s.this.aBx(), str, "", "", a, C19718a.USR, new C197281());
                    AppMethodBeat.m2505o(129069);
                }
            }
        };
        if (isRunning()) {
            c197273.run();
            AppMethodBeat.m2505o(129107);
            return;
        }
        synchronized (this.gPT) {
            try {
                this.gPT.add(c197273);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(129107);
            }
        }
    }

    public C41243o getRuntime() {
        AppMethodBeat.m2504i(129108);
        C41243o c41243o = (C41243o) super.mo34954xL();
        AppMethodBeat.m2505o(129108);
        return c41243o;
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
        AppMethodBeat.m2504i(129114);
        C2157d.axy();
        AppMethodBeat.m2505o(129114);
    }
}
