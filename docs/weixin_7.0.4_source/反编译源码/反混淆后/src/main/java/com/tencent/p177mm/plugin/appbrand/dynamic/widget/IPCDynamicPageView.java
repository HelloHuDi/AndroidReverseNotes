package com.tencent.p177mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C9548e;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.modelappbrand.C1856af;
import com.tencent.p177mm.modelappbrand.C1857ah;
import com.tencent.p177mm.modelappbrand.C1858n;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.modelappbrand.C26436f;
import com.tencent.p177mm.modelappbrand.C26438t;
import com.tencent.p177mm.modelappbrand.C32805ab;
import com.tencent.p177mm.modelappbrand.C36700ac;
import com.tencent.p177mm.modelappbrand.C36701ad;
import com.tencent.p177mm.modelappbrand.C42203y;
import com.tencent.p177mm.modelappbrand.C45443aj;
import com.tencent.p177mm.modelappbrand.C9684ag;
import com.tencent.p177mm.modelappbrand.C9685ai;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.p1601c.C42400a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.C10164a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.C10164a.C10165a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10210e;
import com.tencent.p177mm.plugin.appbrand.dynamic.C2150h;
import com.tencent.p177mm.plugin.appbrand.dynamic.C33164i;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38183a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38183a.C10194d;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38183a.C10196e;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38183a.C10198g;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38183a.C2125f;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38183a.C246902;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38183a.C331421;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38183a.C38184b;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38183a.C38185a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38183a.C38186c;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38203j;
import com.tencent.p177mm.plugin.appbrand.dynamic.C45539b;
import com.tencent.p177mm.plugin.appbrand.dynamic.p289j.C33166b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45573as;
import com.tencent.p177mm.plugin.appbrand.widget.C44718e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.lang.ref.WeakReference;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView */
public class IPCDynamicPageView extends LinearLayout implements C1858n, C10164a, C2150h {
    public static C7306ak hlg;
    private static LayoutParams hpv = new LayoutParams(-1, -1);
    public String eIq;
    private long hcu;
    private C44718e hll;
    private Bundle hpn;
    private C38183a hpo;
    public C32805ab hpp;
    public volatile boolean hpq;
    public long hpr;
    private C10164a hps;
    private Runnable hpt = new C268751();
    private Runnable hpu = new C102222();
    private volatile boolean mDetached;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView$2 */
    class C102222 implements Runnable {
        C102222() {
        }

        public final void run() {
            AppMethodBeat.m2504i(11038);
            String e = IPCDynamicPageView.this.eIq;
            if (C5046bo.isNullOrNil(e)) {
                C4990ab.m7416i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
                AppMethodBeat.m2505o(11038);
                return;
            }
            IPCDynamicPageView.this.mDetached = true;
            C38183a f = IPCDynamicPageView.this.hpo;
            if (e == null || e.length() == 0) {
                C4990ab.m7419v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", Integer.valueOf(f.hashCode()));
            } else {
                C4990ab.m7417i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", Integer.valueOf(f.hashCode()), e);
                Bundle bundle = new Bundle();
                bundle.putString("id", e);
                C9549f.m17012a(C33164i.azC().mo53694zV(e), bundle, C38184b.class, new C246902(e));
                C38203j azE = C38203j.azE();
                if (azE.hlB.containsKey(e)) {
                    azE.hlB.remove(e);
                } else {
                    C26340b.m41918w("WidgetReporter_14443", "OnDettach but no keylist found, widgetId[%s]", e);
                }
            }
            C10210e azz = C10210e.azz();
            if (C5046bo.isNullOrNil(e)) {
                C4990ab.m7420w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
            } else {
                WeakReference weakReference = (WeakReference) azz.hlz.remove(e);
                if (weakReference != null) {
                    weakReference.get();
                }
            }
            IPCDynamicPageView.this.cleanup();
            IPCDynamicPageView.this.hll = null;
            IPCDynamicPageView.this.eIq = null;
            IPCDynamicPageView.this.hpp = null;
            IPCDynamicPageView.this.hpq = false;
            IPCDynamicPageView.this.hps.aye();
            IPCDynamicPageView.this.hps.setTraceId(null);
            AppMethodBeat.m2505o(11038);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView$3 */
    public class C102233 implements Runnable {
        final /* synthetic */ Bundle hkY;
        final /* synthetic */ C32805ab hpx;
        final /* synthetic */ String val$appId;
        final /* synthetic */ String val$id;

        public C102233(String str, Bundle bundle, C32805ab c32805ab, String str2) {
            this.val$id = str;
            this.hkY = bundle;
            this.hpx = c32805ab;
            this.val$appId = str2;
        }

        public final void run() {
            AppMethodBeat.m2504i(11039);
            if (!(IPCDynamicPageView.this.eIq == null || this.val$id.equals(IPCDynamicPageView.this.eIq))) {
                IPCDynamicPageView.this.detach();
            }
            IPCDynamicPageView.this.eIq = this.val$id;
            IPCDynamicPageView.this.hps.setTraceId(IPCDynamicPageView.this.eIq);
            IPCDynamicPageView.this.hpn = this.hkY;
            IPCDynamicPageView.this.hpp = new C36700ac(this.hpx);
            C38183a f = IPCDynamicPageView.this.hpo;
            String str = this.val$id;
            String str2 = this.val$appId;
            Bundle bundle = this.hkY;
            f.eIq = str;
            String str3 = "Token#" + System.nanoTime();
            f.hkV = str3;
            Bundle bundle2 = new Bundle();
            bundle2.putString("id", str);
            bundle2.putString("appId", str2);
            if (bundle != null) {
                bundle2.putInt("scene", bundle.getInt("scene"));
                bundle2.putInt("widgetType", bundle.getInt("widget_type"));
                bundle2.putInt("serviceType", bundle.getInt("service_type"));
                bundle2.putInt("wxaPkgType", bundle.getInt("msg_pkg_type"));
                bundle2.putString("searchId", bundle.getString("search_id", ""));
                bundle2.putInt("pkgVersion", bundle.getInt("pkg_version"));
                bundle2.putString("preloadLaunchData", bundle.getString("preload_launch_data", ""));
                bundle2.putString("preload_download_data", bundle.getString("preload_download_data", ""));
                bundle2.putString("cache_key", bundle.getString("cache_key", ""));
            }
            bundle2.putString("view_process_name", C9548e.m17007PN());
            C18652u.m29151i("MicroMsg.DynamicIPCJsBridge", " attach %s， process %s", str, C33164i.azC().mo53694zV(str));
            C9549f.m17012a(C33164i.azC().mo53694zV(str), bundle2, C38186c.class, new C331421(str3, str, str2, bundle));
            IPCDynamicPageView.this.mDetached = false;
            AppMethodBeat.m2505o(11039);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView$1 */
    class C268751 implements Runnable {
        C268751() {
        }

        public final void run() {
            int i = 1;
            AppMethodBeat.m2504i(11037);
            if (!IPCDynamicPageView.this.hpq) {
                IPCDynamicPageView.this.hpq = true;
                IPCDynamicPageView.m54227b(IPCDynamicPageView.this);
                long currentTimeMillis = System.currentTimeMillis() - IPCDynamicPageView.this.hpr;
                if (currentTimeMillis <= 1000) {
                    i = 0;
                } else if (currentTimeMillis > FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                    i = currentTimeMillis <= 3000 ? 2 : currentTimeMillis <= 4000 ? 3 : currentTimeMillis <= 5000 ? 4 : currentTimeMillis <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME ? 5 : currentTimeMillis <= 7000 ? 6 : currentTimeMillis <= 8000 ? 7 : currentTimeMillis <= 9000 ? 8 : currentTimeMillis <= 10000 ? 9 : 10;
                }
                C7060h.pYm.mo8378a(645, (long) i, 1, false);
                C7060h.pYm.mo8378a(645, 11, 1, false);
                IPCDynamicPageView.this.mo53699nQ(TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY);
            }
            IPCDynamicPageView.this.hcu = System.currentTimeMillis();
            IPCDynamicPageView.this.hps.ayc();
            AppMethodBeat.m2505o(11037);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView$5 */
    class C331685 implements Runnable {
        C331685() {
        }

        public final void run() {
            AppMethodBeat.m2504i(11041);
            IPCDynamicPageView.this.hpo;
            String e = IPCDynamicPageView.this.eIq;
            Bundle bundle = new Bundle();
            bundle.putString("id", e);
            C9549f.m17012a(C33164i.azC().mo53694zV(e), bundle, C10194d.class, null);
            AppMethodBeat.m2505o(11041);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView$6 */
    class C331716 implements Runnable {
        C331716() {
        }

        public final void run() {
            AppMethodBeat.m2504i(11042);
            IPCDynamicPageView.this.hpo;
            String e = IPCDynamicPageView.this.eIq;
            Bundle bundle = new Bundle();
            bundle.putString("id", e);
            C9549f.m17012a(C33164i.azC().mo53694zV(e), bundle, C10196e.class, null);
            AppMethodBeat.m2505o(11042);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m54227b(IPCDynamicPageView iPCDynamicPageView) {
        AppMethodBeat.m2504i(11082);
        iPCDynamicPageView.m54234nP(4);
        AppMethodBeat.m2505o(11082);
    }

    static {
        AppMethodBeat.m2504i(11084);
        HandlerThread anM = C7305d.anM("WxaWidget#UIActionThread");
        anM.start();
        hlg = new C7306ak(anM.getLooper());
        AppMethodBeat.m2505o(11084);
    }

    public IPCDynamicPageView(Context context) {
        super(context);
        AppMethodBeat.m2504i(11044);
        init(context);
        AppMethodBeat.m2505o(11044);
    }

    public IPCDynamicPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(11045);
        init(context);
        AppMethodBeat.m2505o(11045);
    }

    public IPCDynamicPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(11046);
        init(context);
        AppMethodBeat.m2505o(11046);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(11047);
        this.hpo = new C38183a(this);
        View bS = C33173b.m54252bS(context);
        addView(bS, hpv);
        this.hps = (C10164a) bS;
        this.hps.setTraceId(this.eIq);
        AppMethodBeat.m2505o(11047);
    }

    /* renamed from: d */
    public final void mo5971d(final String str, final String str2, final Bundle bundle) {
        AppMethodBeat.m2504i(11048);
        hlg.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(11040);
                String str = "";
                if (bundle != null) {
                    str = bundle.getString("cache_key", "");
                }
                C18652u.m29151i("MicroMsg.IPCDynamicPageView", "prepare(%s, %s)", str, str2);
                IPCDynamicPageView.this.hll = C33166b.m54215Am(str);
                if (IPCDynamicPageView.this.hll == null) {
                    IPCDynamicPageView.this.hll = new C44718e();
                }
                IPCDynamicPageView.this.hll.field_id = str;
                IPCDynamicPageView.this.hll.field_cacheKey = str;
                IPCDynamicPageView.this.hll.field_appId = C18652u.m29154pr(IPCDynamicPageView.this.eIq);
                IPCDynamicPageView.this.getDrawContext().eIo.mo53356j("id", str);
                C10210e.azz().mo21626b(str, IPCDynamicPageView.this);
                if (bundle != null) {
                    bundle.putBundle("__env_args", IPCDynamicPageView.m54226b(IPCDynamicPageView.this, bundle));
                }
                IPCDynamicPageView.this.hpo;
                str = str;
                String str2 = str2;
                Bundle bundle = bundle;
                Bundle bundle2 = new Bundle();
                bundle2.putString("id", str);
                bundle2.putString("appId", str2);
                bundle2.putBundle("extData", bundle);
                C18652u.m29151i("MicroMsg.DynamicIPCJsBridge", "before IPCInvoke_AttachTo invoke", new Object[0]);
                C9549f.m17012a(C33164i.azC().mo53694zV(str), bundle2, C38185a.class, null);
                AppMethodBeat.m2505o(11040);
            }
        });
        AppMethodBeat.m2505o(11048);
    }

    public final void detach() {
        AppMethodBeat.m2504i(11049);
        if (Looper.myLooper() == hlg.getLooper()) {
            this.hpu.run();
            AppMethodBeat.m2505o(11049);
            return;
        }
        hlg.post(this.hpu);
        AppMethodBeat.m2505o(11049);
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(11050);
        if (this.hll != null) {
            C4990ab.m7417i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s, %s, %s, %s)", this.eIq, this.hll.field_id, this.hll.field_appId, this.hll.field_cacheKey);
        } else {
            C4990ab.m7417i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s)", this.eIq);
        }
        ayd();
        AppMethodBeat.m2505o(11050);
    }

    /* renamed from: nK */
    public final void mo5972nK(int i) {
        AppMethodBeat.m2504i(11051);
        m54234nP(i);
        detach();
        AppMethodBeat.m2505o(11051);
    }

    public final void azB() {
        AppMethodBeat.m2504i(11052);
        if (this.hpp == null) {
            AppMethodBeat.m2505o(11052);
            return;
        }
        C9684ag c9684ag = (C9684ag) this.hpp.mo53363px("onUiUpdate");
        if (c9684ag == null) {
            AppMethodBeat.m2505o(11052);
            return;
        }
        c9684ag.abP();
        AppMethodBeat.m2505o(11052);
    }

    /* renamed from: b */
    public final void mo5968b(String str, C26438t c26438t) {
        AppMethodBeat.m2504i(11053);
        if (this.hpp == null) {
            c26438t.mo5959b(false, "listener is null", null);
            AppMethodBeat.m2505o(11053);
            return;
        }
        C36701ad c36701ad = (C36701ad) this.hpp.mo53363px(C45573as.NAME);
        if (c36701ad == null) {
            c26438t.mo5959b(false, "listener is null", null);
            AppMethodBeat.m2505o(11053);
            return;
        }
        c36701ad.mo9597py(str);
        AppMethodBeat.m2505o(11053);
    }

    /* renamed from: c */
    public final void mo5969c(String str, C26438t c26438t) {
        AppMethodBeat.m2504i(11054);
        if (this.hpp == null) {
            c26438t.mo5959b(false, "listener is null", null);
            AppMethodBeat.m2505o(11054);
            return;
        }
        C9685ai c9685ai = (C9685ai) this.hpp.mo53363px("onSearchWAWidgetReloadData");
        if (c9685ai == null) {
            c26438t.mo5959b(false, "listener is null", null);
            AppMethodBeat.m2505o(11054);
            return;
        }
        c9685ai.mo9592pA(str);
        AppMethodBeat.m2505o(11054);
    }

    /* renamed from: a */
    public final void mo5963a(String str, C26438t c26438t) {
        AppMethodBeat.m2504i(11055);
        if (this.hpp == null) {
            c26438t.mo5959b(false, "listener is null", null);
            AppMethodBeat.m2505o(11055);
            return;
        }
        C1857ah c1857ah = (C1857ah) this.hpp.mo53363px("openApp");
        if (c1857ah == null) {
            c26438t.mo5959b(false, "listener is null", null);
            AppMethodBeat.m2505o(11055);
            return;
        }
        c1857ah.mo5433pz(str);
        AppMethodBeat.m2505o(11055);
    }

    /* renamed from: a */
    public final void mo5965a(boolean z, String str, boolean z2, C26438t c26438t) {
        AppMethodBeat.m2504i(11056);
        if (this.hpp == null) {
            c26438t.mo5959b(false, "listener is null", null);
            AppMethodBeat.m2505o(11056);
            return;
        }
        C1856af c1856af = (C1856af) this.hpp.mo53363px("OnTapCallback");
        if (c1856af == null) {
            c26438t.mo5959b(false, "listener is null", null);
            AppMethodBeat.m2505o(11056);
            return;
        }
        c1856af.mo5431b(z, str, z2);
        AppMethodBeat.m2505o(11056);
    }

    /* renamed from: a */
    public final void mo5964a(String str, String str2, C26438t c26438t) {
        AppMethodBeat.m2504i(11057);
        if (this.hpp == null) {
            c26438t.mo5959b(false, "listener is null", null);
            AppMethodBeat.m2505o(11057);
            return;
        }
        C42203y c42203y = (C42203y) this.hpp.mo53363px("showPicker");
        if (c42203y == null) {
            c26438t.mo5959b(false, "listener is null", null);
            AppMethodBeat.m2505o(11057);
            return;
        }
        c42203y.mo38364a(str, str2, c26438t);
        AppMethodBeat.m2505o(11057);
    }

    /* renamed from: b */
    public final void mo5967b(int i, C26438t c26438t) {
        AppMethodBeat.m2504i(11058);
        if (this.hpp == null) {
            c26438t.mo5959b(false, "listener is null", null);
            AppMethodBeat.m2505o(11058);
            return;
        }
        C45443aj c45443aj = (C45443aj) this.hpp.mo53363px("setWidgetSize");
        if (c45443aj == null) {
            c26438t.mo5959b(false, "listener is null", null);
            AppMethodBeat.m2505o(11058);
            return;
        }
        c45443aj.mo9594a(i, c26438t);
        AppMethodBeat.m2505o(11058);
    }

    /* renamed from: e */
    public final boolean mo21540e(Canvas canvas) {
        AppMethodBeat.m2504i(11059);
        boolean e = this.hps.mo21540e(canvas);
        AppMethodBeat.m2505o(11059);
        return e;
    }

    public final void ayc() {
        AppMethodBeat.m2504i(11060);
        long currentTimeMillis = System.currentTimeMillis() - this.hcu;
        hlg.removeCallbacks(this.hpt);
        if (currentTimeMillis < 12) {
            hlg.postDelayed(this.hpt, currentTimeMillis);
            AppMethodBeat.m2505o(11060);
            return;
        }
        this.hpt.run();
        AppMethodBeat.m2505o(11060);
    }

    /* renamed from: a */
    public final void mo21535a(JSONArray jSONArray, C10165a c10165a) {
        AppMethodBeat.m2504i(11061);
        this.hps.mo21535a(jSONArray, c10165a);
        AppMethodBeat.m2505o(11061);
    }

    /* renamed from: b */
    public final void mo21539b(JSONArray jSONArray, C10165a c10165a) {
        AppMethodBeat.m2504i(11062);
        this.hps.mo21539b(jSONArray, c10165a);
        AppMethodBeat.m2505o(11062);
    }

    /* renamed from: a */
    public final void mo21534a(DrawCanvasArg drawCanvasArg, C10165a c10165a) {
        AppMethodBeat.m2504i(11063);
        this.hps.mo21534a(drawCanvasArg, c10165a);
        AppMethodBeat.m2505o(11063);
    }

    /* renamed from: b */
    public final void mo21538b(DrawCanvasArg drawCanvasArg, C10165a c10165a) {
        AppMethodBeat.m2504i(11064);
        this.hps.mo21538b(drawCanvasArg, c10165a);
        AppMethodBeat.m2505o(11064);
    }

    public final void ayd() {
        AppMethodBeat.m2504i(11065);
        this.hps.ayd();
        AppMethodBeat.m2505o(11065);
    }

    /* renamed from: C */
    public final void mo21533C(Runnable runnable) {
        AppMethodBeat.m2504i(11066);
        this.hps.mo21533C(runnable);
        AppMethodBeat.m2505o(11066);
    }

    public C2102d getDrawContext() {
        AppMethodBeat.m2504i(11067);
        C2102d drawContext = this.hps.getDrawContext();
        AppMethodBeat.m2505o(11067);
        return drawContext;
    }

    public void setDrawActionReportable(C42400a c42400a) {
        AppMethodBeat.m2504i(11068);
        this.hps.setDrawActionReportable(c42400a);
        AppMethodBeat.m2505o(11068);
    }

    public void setTraceId(String str) {
        AppMethodBeat.m2504i(11069);
        this.hps.setTraceId(str);
        AppMethodBeat.m2505o(11069);
    }

    public String getTraceId() {
        AppMethodBeat.m2504i(11070);
        String traceId = this.hps.getTraceId();
        AppMethodBeat.m2505o(11070);
        return traceId;
    }

    public final void onPause() {
        AppMethodBeat.m2504i(11071);
        C4990ab.m7417i("MicroMsg.IPCDynamicPageView", "onPause(%s)", this.eIq);
        hlg.post(new C331685());
        AppMethodBeat.m2505o(11071);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(11072);
        C4990ab.m7417i("MicroMsg.IPCDynamicPageView", "onResume(%s)", this.eIq);
        this.hps.onResume();
        hlg.post(new C331716());
        AppMethodBeat.m2505o(11072);
    }

    public final boolean isPaused() {
        AppMethodBeat.m2504i(11073);
        boolean isPaused = this.hps.isPaused();
        AppMethodBeat.m2505o(11073);
        return isPaused;
    }

    public String getSessionId() {
        AppMethodBeat.m2504i(11074);
        String sessionId = this.hps.getSessionId();
        AppMethodBeat.m2505o(11074);
        return sessionId;
    }

    public void setSessionId(String str) {
        AppMethodBeat.m2504i(11075);
        this.hps.setSessionId(str);
        AppMethodBeat.m2505o(11075);
    }

    public void setStartTime(long j) {
        AppMethodBeat.m2504i(11076);
        this.hps.setStartTime(j);
        AppMethodBeat.m2505o(11076);
    }

    public final void aye() {
        AppMethodBeat.m2504i(11077);
        this.hps.aye();
        AppMethodBeat.m2505o(11077);
    }

    public String getExtId() {
        return this.eIq;
    }

    public Bundle getExtData() {
        return this.hpn;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(11078);
        super.onSizeChanged(i, i2, i3, i4);
        C4990ab.m7417i("MicroMsg.IPCDynamicPageView", "onSizeChanged(w : %d, h : %d, oldw : %d, oldh : %d)", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        Bundle bundle = new Bundle();
        bundle.putInt("__page_view_width", i);
        bundle.putInt("__page_view_height", i2);
        String str = this.eIq;
        Bundle bundle2 = new Bundle();
        bundle2.putString("id", str);
        bundle2.putBundle("__env_args", bundle);
        C9549f.m17012a(C33164i.azC().mo53694zV(str), bundle2, C10198g.class, null);
        AppMethodBeat.m2505o(11078);
    }

    /* renamed from: nP */
    private void m54234nP(final int i) {
        AppMethodBeat.m2504i(11079);
        if (this.hpp == null) {
            C4990ab.m7417i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener wrapper is null.", this.eIq, Integer.valueOf(i));
            AppMethodBeat.m2505o(11079);
            return;
        }
        final C26436f abN = this.hpp.abN();
        if (abN == null) {
            C4990ab.m7417i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener is null.", this.eIq, Integer.valueOf(i));
            AppMethodBeat.m2505o(11079);
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            abN.mo9596F(this, i);
            AppMethodBeat.m2505o(11079);
        } else {
            C45539b.m83988E(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(11043);
                    abN.mo9596F(IPCDynamicPageView.this, i);
                    AppMethodBeat.m2505o(11043);
                }
            });
            AppMethodBeat.m2505o(11079);
        }
    }

    /* renamed from: ap */
    public final boolean mo5434ap(String str, String str2) {
        AppMethodBeat.m2504i(11080);
        C38183a c38183a = this.hpo;
        String str3 = this.eIq;
        if (c38183a.eIq == null || c38183a.eIq.length() == 0 || str == null || str.length() == 0) {
            AppMethodBeat.m2505o(11080);
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("id", str3);
        bundle.putString("event", str);
        bundle.putString("data", str2);
        IPCBoolean iPCBoolean = (IPCBoolean) C9549f.m17010a(C33164i.azC().mo53694zV(str3), bundle, C2125f.class);
        if (iPCBoolean != null) {
            boolean z = iPCBoolean.value;
            AppMethodBeat.m2505o(11080);
            return z;
        }
        AppMethodBeat.m2505o(11080);
        return false;
    }

    /* renamed from: nQ */
    public final void mo53699nQ(int i) {
        AppMethodBeat.m2504i(11081);
        this.hpo.mo60922aY(this.eIq, i);
        AppMethodBeat.m2505o(11081);
    }
}
