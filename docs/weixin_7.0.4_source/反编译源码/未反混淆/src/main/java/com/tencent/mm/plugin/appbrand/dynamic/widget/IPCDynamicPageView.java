package com.tencent.mm.plugin.appbrand.dynamic.widget;

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
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.ad;
import com.tencent.mm.modelappbrand.af;
import com.tencent.mm.modelappbrand.ag;
import com.tencent.mm.modelappbrand.ah;
import com.tencent.mm.modelappbrand.ai;
import com.tencent.mm.modelappbrand.aj;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.y;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.dynamic.a.b;
import com.tencent.mm.plugin.appbrand.dynamic.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.a.g;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.widget.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.lang.ref.WeakReference;
import org.json.JSONArray;

public class IPCDynamicPageView extends LinearLayout implements n, a, h {
    public static ak hlg;
    private static LayoutParams hpv = new LayoutParams(-1, -1);
    public String eIq;
    private long hcu;
    private e hll;
    private Bundle hpn;
    private com.tencent.mm.plugin.appbrand.dynamic.a hpo;
    public ab hpp;
    public volatile boolean hpq;
    public long hpr;
    private a hps;
    private Runnable hpt = new Runnable() {
        public final void run() {
            int i = 1;
            AppMethodBeat.i(11037);
            if (!IPCDynamicPageView.this.hpq) {
                IPCDynamicPageView.this.hpq = true;
                IPCDynamicPageView.b(IPCDynamicPageView.this);
                long currentTimeMillis = System.currentTimeMillis() - IPCDynamicPageView.this.hpr;
                if (currentTimeMillis <= 1000) {
                    i = 0;
                } else if (currentTimeMillis > FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                    i = currentTimeMillis <= 3000 ? 2 : currentTimeMillis <= 4000 ? 3 : currentTimeMillis <= 5000 ? 4 : currentTimeMillis <= ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME ? 5 : currentTimeMillis <= 7000 ? 6 : currentTimeMillis <= 8000 ? 7 : currentTimeMillis <= 9000 ? 8 : currentTimeMillis <= 10000 ? 9 : 10;
                }
                com.tencent.mm.plugin.report.service.h.pYm.a(645, (long) i, 1, false);
                com.tencent.mm.plugin.report.service.h.pYm.a(645, 11, 1, false);
                IPCDynamicPageView.this.nQ(TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY);
            }
            IPCDynamicPageView.this.hcu = System.currentTimeMillis();
            IPCDynamicPageView.this.hps.ayc();
            AppMethodBeat.o(11037);
        }
    };
    private Runnable hpu = new Runnable() {
        public final void run() {
            AppMethodBeat.i(11038);
            String e = IPCDynamicPageView.this.eIq;
            if (bo.isNullOrNil(e)) {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
                AppMethodBeat.o(11038);
                return;
            }
            IPCDynamicPageView.this.mDetached = true;
            com.tencent.mm.plugin.appbrand.dynamic.a f = IPCDynamicPageView.this.hpo;
            if (e == null || e.length() == 0) {
                com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", Integer.valueOf(f.hashCode()));
            } else {
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", Integer.valueOf(f.hashCode()), e);
                Bundle bundle = new Bundle();
                bundle.putString("id", e);
                f.a(i.azC().zV(e), bundle, b.class, new com.tencent.mm.plugin.appbrand.dynamic.a.AnonymousClass2(e));
                j azE = j.azE();
                if (azE.hlB.containsKey(e)) {
                    azE.hlB.remove(e);
                } else {
                    com.tencent.mm.ipcinvoker.h.b.w("WidgetReporter_14443", "OnDettach but no keylist found, widgetId[%s]", e);
                }
            }
            com.tencent.mm.plugin.appbrand.dynamic.e azz = com.tencent.mm.plugin.appbrand.dynamic.e.azz();
            if (bo.isNullOrNil(e)) {
                com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
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
            AppMethodBeat.o(11038);
        }
    };
    private volatile boolean mDetached;

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView$3 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ Bundle hkY;
        final /* synthetic */ ab hpx;
        final /* synthetic */ String val$appId;
        final /* synthetic */ String val$id;

        public AnonymousClass3(String str, Bundle bundle, ab abVar, String str2) {
            this.val$id = str;
            this.hkY = bundle;
            this.hpx = abVar;
            this.val$appId = str2;
        }

        public final void run() {
            AppMethodBeat.i(11039);
            if (!(IPCDynamicPageView.this.eIq == null || this.val$id.equals(IPCDynamicPageView.this.eIq))) {
                IPCDynamicPageView.this.detach();
            }
            IPCDynamicPageView.this.eIq = this.val$id;
            IPCDynamicPageView.this.hps.setTraceId(IPCDynamicPageView.this.eIq);
            IPCDynamicPageView.this.hpn = this.hkY;
            IPCDynamicPageView.this.hpp = new ac(this.hpx);
            com.tencent.mm.plugin.appbrand.dynamic.a f = IPCDynamicPageView.this.hpo;
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
            bundle2.putString("view_process_name", com.tencent.mm.ipcinvoker.e.PN());
            u.i("MicroMsg.DynamicIPCJsBridge", " attach %s， process %s", str, i.azC().zV(str));
            f.a(i.azC().zV(str), bundle2, c.class, new com.tencent.mm.plugin.appbrand.dynamic.a.AnonymousClass1(str3, str, str2, bundle));
            IPCDynamicPageView.this.mDetached = false;
            AppMethodBeat.o(11039);
        }
    }

    static /* synthetic */ void b(IPCDynamicPageView iPCDynamicPageView) {
        AppMethodBeat.i(11082);
        iPCDynamicPageView.nP(4);
        AppMethodBeat.o(11082);
    }

    static {
        AppMethodBeat.i(11084);
        HandlerThread anM = d.anM("WxaWidget#UIActionThread");
        anM.start();
        hlg = new ak(anM.getLooper());
        AppMethodBeat.o(11084);
    }

    public IPCDynamicPageView(Context context) {
        super(context);
        AppMethodBeat.i(11044);
        init(context);
        AppMethodBeat.o(11044);
    }

    public IPCDynamicPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(11045);
        init(context);
        AppMethodBeat.o(11045);
    }

    public IPCDynamicPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(11046);
        init(context);
        AppMethodBeat.o(11046);
    }

    private void init(Context context) {
        AppMethodBeat.i(11047);
        this.hpo = new com.tencent.mm.plugin.appbrand.dynamic.a(this);
        View bS = b.bS(context);
        addView(bS, hpv);
        this.hps = (a) bS;
        this.hps.setTraceId(this.eIq);
        AppMethodBeat.o(11047);
    }

    public final void d(final String str, final String str2, final Bundle bundle) {
        AppMethodBeat.i(11048);
        hlg.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(11040);
                String str = "";
                if (bundle != null) {
                    str = bundle.getString("cache_key", "");
                }
                u.i("MicroMsg.IPCDynamicPageView", "prepare(%s, %s)", str, str2);
                IPCDynamicPageView.this.hll = com.tencent.mm.plugin.appbrand.dynamic.j.b.Am(str);
                if (IPCDynamicPageView.this.hll == null) {
                    IPCDynamicPageView.this.hll = new e();
                }
                IPCDynamicPageView.this.hll.field_id = str;
                IPCDynamicPageView.this.hll.field_cacheKey = str;
                IPCDynamicPageView.this.hll.field_appId = u.pr(IPCDynamicPageView.this.eIq);
                IPCDynamicPageView.this.getDrawContext().eIo.j("id", str);
                com.tencent.mm.plugin.appbrand.dynamic.e.azz().b(str, IPCDynamicPageView.this);
                if (bundle != null) {
                    bundle.putBundle("__env_args", IPCDynamicPageView.b(IPCDynamicPageView.this, bundle));
                }
                IPCDynamicPageView.this.hpo;
                str = str;
                String str2 = str2;
                Bundle bundle = bundle;
                Bundle bundle2 = new Bundle();
                bundle2.putString("id", str);
                bundle2.putString("appId", str2);
                bundle2.putBundle("extData", bundle);
                u.i("MicroMsg.DynamicIPCJsBridge", "before IPCInvoke_AttachTo invoke", new Object[0]);
                f.a(i.azC().zV(str), bundle2, com.tencent.mm.plugin.appbrand.dynamic.a.a.class, null);
                AppMethodBeat.o(11040);
            }
        });
        AppMethodBeat.o(11048);
    }

    public final void detach() {
        AppMethodBeat.i(11049);
        if (Looper.myLooper() == hlg.getLooper()) {
            this.hpu.run();
            AppMethodBeat.o(11049);
            return;
        }
        hlg.post(this.hpu);
        AppMethodBeat.o(11049);
    }

    public final void cleanup() {
        AppMethodBeat.i(11050);
        if (this.hll != null) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s, %s, %s, %s)", this.eIq, this.hll.field_id, this.hll.field_appId, this.hll.field_cacheKey);
        } else {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s)", this.eIq);
        }
        ayd();
        AppMethodBeat.o(11050);
    }

    public final void nK(int i) {
        AppMethodBeat.i(11051);
        nP(i);
        detach();
        AppMethodBeat.o(11051);
    }

    public final void azB() {
        AppMethodBeat.i(11052);
        if (this.hpp == null) {
            AppMethodBeat.o(11052);
            return;
        }
        ag agVar = (ag) this.hpp.px("onUiUpdate");
        if (agVar == null) {
            AppMethodBeat.o(11052);
            return;
        }
        agVar.abP();
        AppMethodBeat.o(11052);
    }

    public final void b(String str, t tVar) {
        AppMethodBeat.i(11053);
        if (this.hpp == null) {
            tVar.b(false, "listener is null", null);
            AppMethodBeat.o(11053);
            return;
        }
        ad adVar = (ad) this.hpp.px(as.NAME);
        if (adVar == null) {
            tVar.b(false, "listener is null", null);
            AppMethodBeat.o(11053);
            return;
        }
        adVar.py(str);
        AppMethodBeat.o(11053);
    }

    public final void c(String str, t tVar) {
        AppMethodBeat.i(11054);
        if (this.hpp == null) {
            tVar.b(false, "listener is null", null);
            AppMethodBeat.o(11054);
            return;
        }
        ai aiVar = (ai) this.hpp.px("onSearchWAWidgetReloadData");
        if (aiVar == null) {
            tVar.b(false, "listener is null", null);
            AppMethodBeat.o(11054);
            return;
        }
        aiVar.pA(str);
        AppMethodBeat.o(11054);
    }

    public final void a(String str, t tVar) {
        AppMethodBeat.i(11055);
        if (this.hpp == null) {
            tVar.b(false, "listener is null", null);
            AppMethodBeat.o(11055);
            return;
        }
        ah ahVar = (ah) this.hpp.px("openApp");
        if (ahVar == null) {
            tVar.b(false, "listener is null", null);
            AppMethodBeat.o(11055);
            return;
        }
        ahVar.pz(str);
        AppMethodBeat.o(11055);
    }

    public final void a(boolean z, String str, boolean z2, t tVar) {
        AppMethodBeat.i(11056);
        if (this.hpp == null) {
            tVar.b(false, "listener is null", null);
            AppMethodBeat.o(11056);
            return;
        }
        af afVar = (af) this.hpp.px("OnTapCallback");
        if (afVar == null) {
            tVar.b(false, "listener is null", null);
            AppMethodBeat.o(11056);
            return;
        }
        afVar.b(z, str, z2);
        AppMethodBeat.o(11056);
    }

    public final void a(String str, String str2, t tVar) {
        AppMethodBeat.i(11057);
        if (this.hpp == null) {
            tVar.b(false, "listener is null", null);
            AppMethodBeat.o(11057);
            return;
        }
        y yVar = (y) this.hpp.px("showPicker");
        if (yVar == null) {
            tVar.b(false, "listener is null", null);
            AppMethodBeat.o(11057);
            return;
        }
        yVar.a(str, str2, tVar);
        AppMethodBeat.o(11057);
    }

    public final void b(int i, t tVar) {
        AppMethodBeat.i(11058);
        if (this.hpp == null) {
            tVar.b(false, "listener is null", null);
            AppMethodBeat.o(11058);
            return;
        }
        aj ajVar = (aj) this.hpp.px("setWidgetSize");
        if (ajVar == null) {
            tVar.b(false, "listener is null", null);
            AppMethodBeat.o(11058);
            return;
        }
        ajVar.a(i, tVar);
        AppMethodBeat.o(11058);
    }

    public final boolean e(Canvas canvas) {
        AppMethodBeat.i(11059);
        boolean e = this.hps.e(canvas);
        AppMethodBeat.o(11059);
        return e;
    }

    public final void ayc() {
        AppMethodBeat.i(11060);
        long currentTimeMillis = System.currentTimeMillis() - this.hcu;
        hlg.removeCallbacks(this.hpt);
        if (currentTimeMillis < 12) {
            hlg.postDelayed(this.hpt, currentTimeMillis);
            AppMethodBeat.o(11060);
            return;
        }
        this.hpt.run();
        AppMethodBeat.o(11060);
    }

    public final void a(JSONArray jSONArray, a.a aVar) {
        AppMethodBeat.i(11061);
        this.hps.a(jSONArray, aVar);
        AppMethodBeat.o(11061);
    }

    public final void b(JSONArray jSONArray, a.a aVar) {
        AppMethodBeat.i(11062);
        this.hps.b(jSONArray, aVar);
        AppMethodBeat.o(11062);
    }

    public final void a(DrawCanvasArg drawCanvasArg, a.a aVar) {
        AppMethodBeat.i(11063);
        this.hps.a(drawCanvasArg, aVar);
        AppMethodBeat.o(11063);
    }

    public final void b(DrawCanvasArg drawCanvasArg, a.a aVar) {
        AppMethodBeat.i(11064);
        this.hps.b(drawCanvasArg, aVar);
        AppMethodBeat.o(11064);
    }

    public final void ayd() {
        AppMethodBeat.i(11065);
        this.hps.ayd();
        AppMethodBeat.o(11065);
    }

    public final void C(Runnable runnable) {
        AppMethodBeat.i(11066);
        this.hps.C(runnable);
        AppMethodBeat.o(11066);
    }

    public com.tencent.mm.plugin.appbrand.canvas.d getDrawContext() {
        AppMethodBeat.i(11067);
        com.tencent.mm.plugin.appbrand.canvas.d drawContext = this.hps.getDrawContext();
        AppMethodBeat.o(11067);
        return drawContext;
    }

    public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a aVar) {
        AppMethodBeat.i(11068);
        this.hps.setDrawActionReportable(aVar);
        AppMethodBeat.o(11068);
    }

    public void setTraceId(String str) {
        AppMethodBeat.i(11069);
        this.hps.setTraceId(str);
        AppMethodBeat.o(11069);
    }

    public String getTraceId() {
        AppMethodBeat.i(11070);
        String traceId = this.hps.getTraceId();
        AppMethodBeat.o(11070);
        return traceId;
    }

    public final void onPause() {
        AppMethodBeat.i(11071);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.IPCDynamicPageView", "onPause(%s)", this.eIq);
        hlg.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(11041);
                IPCDynamicPageView.this.hpo;
                String e = IPCDynamicPageView.this.eIq;
                Bundle bundle = new Bundle();
                bundle.putString("id", e);
                f.a(i.azC().zV(e), bundle, com.tencent.mm.plugin.appbrand.dynamic.a.d.class, null);
                AppMethodBeat.o(11041);
            }
        });
        AppMethodBeat.o(11071);
    }

    public final void onResume() {
        AppMethodBeat.i(11072);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.IPCDynamicPageView", "onResume(%s)", this.eIq);
        this.hps.onResume();
        hlg.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(11042);
                IPCDynamicPageView.this.hpo;
                String e = IPCDynamicPageView.this.eIq;
                Bundle bundle = new Bundle();
                bundle.putString("id", e);
                f.a(i.azC().zV(e), bundle, com.tencent.mm.plugin.appbrand.dynamic.a.e.class, null);
                AppMethodBeat.o(11042);
            }
        });
        AppMethodBeat.o(11072);
    }

    public final boolean isPaused() {
        AppMethodBeat.i(11073);
        boolean isPaused = this.hps.isPaused();
        AppMethodBeat.o(11073);
        return isPaused;
    }

    public String getSessionId() {
        AppMethodBeat.i(11074);
        String sessionId = this.hps.getSessionId();
        AppMethodBeat.o(11074);
        return sessionId;
    }

    public void setSessionId(String str) {
        AppMethodBeat.i(11075);
        this.hps.setSessionId(str);
        AppMethodBeat.o(11075);
    }

    public void setStartTime(long j) {
        AppMethodBeat.i(11076);
        this.hps.setStartTime(j);
        AppMethodBeat.o(11076);
    }

    public final void aye() {
        AppMethodBeat.i(11077);
        this.hps.aye();
        AppMethodBeat.o(11077);
    }

    public String getExtId() {
        return this.eIq;
    }

    public Bundle getExtData() {
        return this.hpn;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(11078);
        super.onSizeChanged(i, i2, i3, i4);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.IPCDynamicPageView", "onSizeChanged(w : %d, h : %d, oldw : %d, oldh : %d)", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        Bundle bundle = new Bundle();
        bundle.putInt("__page_view_width", i);
        bundle.putInt("__page_view_height", i2);
        String str = this.eIq;
        Bundle bundle2 = new Bundle();
        bundle2.putString("id", str);
        bundle2.putBundle("__env_args", bundle);
        f.a(i.azC().zV(str), bundle2, g.class, null);
        AppMethodBeat.o(11078);
    }

    private void nP(final int i) {
        AppMethodBeat.i(11079);
        if (this.hpp == null) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener wrapper is null.", this.eIq, Integer.valueOf(i));
            AppMethodBeat.o(11079);
            return;
        }
        final com.tencent.mm.modelappbrand.f abN = this.hpp.abN();
        if (abN == null) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener is null.", this.eIq, Integer.valueOf(i));
            AppMethodBeat.o(11079);
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            abN.F(this, i);
            AppMethodBeat.o(11079);
        } else {
            com.tencent.mm.plugin.appbrand.dynamic.b.E(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(11043);
                    abN.F(IPCDynamicPageView.this, i);
                    AppMethodBeat.o(11043);
                }
            });
            AppMethodBeat.o(11079);
        }
    }

    public final boolean ap(String str, String str2) {
        AppMethodBeat.i(11080);
        com.tencent.mm.plugin.appbrand.dynamic.a aVar = this.hpo;
        String str3 = this.eIq;
        if (aVar.eIq == null || aVar.eIq.length() == 0 || str == null || str.length() == 0) {
            AppMethodBeat.o(11080);
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("id", str3);
        bundle.putString("event", str);
        bundle.putString("data", str2);
        IPCBoolean iPCBoolean = (IPCBoolean) f.a(i.azC().zV(str3), bundle, com.tencent.mm.plugin.appbrand.dynamic.a.f.class);
        if (iPCBoolean != null) {
            boolean z = iPCBoolean.value;
            AppMethodBeat.o(11080);
            return z;
        }
        AppMethodBeat.o(11080);
        return false;
    }

    public final void nQ(int i) {
        AppMethodBeat.i(11081);
        this.hpo.aY(this.eIq, i);
        AppMethodBeat.o(11081);
    }
}
