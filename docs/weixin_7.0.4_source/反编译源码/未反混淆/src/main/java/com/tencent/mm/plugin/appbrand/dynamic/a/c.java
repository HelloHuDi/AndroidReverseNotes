package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.plugin.appbrand.appcache.z;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.b.d;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.b;
import com.tencent.mm.plugin.appbrand.dynamic.h.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.AnonymousClass3;
import com.tencent.mm.plugin.appbrand.r.n;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.rtmp.TXLiveConstants;
import java.net.URLDecoder;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements OnAttachStateChangeListener, e, a, com.tencent.mm.sdk.platformtools.ao.c {
    private String gtl;
    private volatile com.tencent.mm.modelappbrand.c hmc;
    private volatile b hmj;
    private volatile e hmk;

    public final void initialize() {
        AppMethodBeat.i(10742);
        if (!(this.gtl == null || this.gtl.length() == 0)) {
            shutdown();
        }
        this.gtl = "Token#" + System.nanoTime();
        ao.a((com.tencent.mm.sdk.platformtools.ao.c) this);
        z.a(new d());
        AppMethodBeat.o(10742);
    }

    public final void shutdown() {
        AppMethodBeat.i(10743);
        Map abx = azN().abx();
        if (abx == null || abx.isEmpty()) {
            AppMethodBeat.o(10743);
            return;
        }
        for (Object next : new LinkedHashSet(abx.keySet())) {
            if (next != null && (next instanceof String)) {
                pm((String) next);
            }
        }
        AppMethodBeat.o(10743);
    }

    public final View bS(Context context) {
        AppMethodBeat.i(10744);
        IPCDynamicPageView iPCDynamicPageView = new IPCDynamicPageView(context);
        AppMethodBeat.o(10744);
        return iPCDynamicPageView;
    }

    public final String a(String str, View view, Bundle bundle, ab abVar) {
        AppMethodBeat.i(10745);
        String gv;
        if (view instanceof IPCDynamicPageView) {
            String string;
            String str2;
            gv = n.gv(System.nanoTime());
            com.tencent.mm.plugin.appbrand.collector.c.d("widget_launch", gv, "on_bind_view", true);
            com.tencent.mm.plugin.appbrand.collector.c.bE(gv, "init_finish");
            IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
            String str3 = null;
            if (bundle != null) {
                string = bundle.getString("app_id");
                str3 = bundle.getString("msg_id");
                bundle.putString("__session_id", str);
                bundle.putLong("__on_bind_nano_time", System.nanoTime());
                bundle.putString("__session_id", gv);
                bundle.putParcelable("__cost_time_session", com.tencent.mm.plugin.appbrand.collector.c.yH(gv));
                str2 = string;
            } else {
                str2 = null;
            }
            gv = bundle.getString("wxa_unique_id");
            if (TextUtils.isEmpty(gv)) {
                gv = WxaWidgetInitializer.bL(str2, str3);
            }
            string = bundle.getString("exec_process_name", "com.tencent.mm:support");
            i.azC().bK(gv, string);
            u.i("MicroMsg.DynamicPageService", "onBindView(%s)", gv);
            com.tencent.mm.plugin.appbrand.dynamic.e.azz().b(gv, iPCDynamicPageView);
            str3 = (String) h.bP(bundle.getString("msg_path", "")).get("widgetData");
            if (!TextUtils.isEmpty(str3)) {
                try {
                    JSONObject jSONObject = new JSONObject(URLDecoder.decode(str3));
                    if (jSONObject.has("render_data") && jSONObject.getJSONObject("render_data").has("actions")) {
                        u.i("MicroMsg.DynamicPageService", "get render_data and begin predraw", new Object[0]);
                        JSONArray jSONArray = jSONObject.getJSONObject("render_data").getJSONArray("actions");
                        jSONObject = new JSONObject();
                        jSONObject.put("actions", jSONArray);
                        jSONObject.put("reserve", false);
                        String jSONObject2 = jSONObject.toString();
                        jSONObject.put("__invoke_jsapi_timestamp", System.currentTimeMillis());
                        b bVar = new b();
                        bVar.a(string, gv, jSONObject, null, null, com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bb(gv, bundle.getInt("draw_strategy")), jSONObject2);
                        com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bb(gv, bundle.getInt("draw_strategy")).a(bVar);
                        w wVar = (w) abVar.px("WidgetPreDrawCallback");
                        if (wVar != null) {
                            wVar.abM();
                        }
                        u.pp(gv);
                    }
                } catch (JSONException e) {
                    com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.DynamicPageService", e, "", new Object[0]);
                }
            }
            iPCDynamicPageView.removeOnAttachStateChangeListener(this);
            iPCDynamicPageView.addOnAttachStateChangeListener(this);
            Assert.assertNotNull(gv);
            iPCDynamicPageView.hpr = System.currentTimeMillis();
            f abN = abVar != null ? abVar.abN() : null;
            if (!(iPCDynamicPageView.eIq == null || gv.equals(iPCDynamicPageView.eIq))) {
                iPCDynamicPageView.cleanup();
            }
            if (!(abN == null || (gv.equals(iPCDynamicPageView.eIq) && iPCDynamicPageView.hpq))) {
                abN.F(iPCDynamicPageView, 0);
            }
            iPCDynamicPageView.hpq = false;
            u.i("MicroMsg.IPCDynamicPageView", "attach (%s)", gv);
            IPCDynamicPageView.hlg.post(new AnonymousClass3(gv, bundle, abVar, str2));
            com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.DynamicPageService", "onBindView(%s)", gv);
            com.tencent.mm.plugin.appbrand.dynamic.h.a aAb = com.tencent.mm.plugin.appbrand.dynamic.h.a.aAb();
            if (!(str == null || str.length() == 0)) {
                aAb.hoE.put(str, this);
            }
            com.tencent.mm.plugin.appbrand.dynamic.h.a.aAb().c(str, iPCDynamicPageView);
            azN().d(str, iPCDynamicPageView);
            AppMethodBeat.o(10745);
            return gv;
        }
        gv = "";
        AppMethodBeat.o(10745);
        return gv;
    }

    public final void a(String str, View view) {
        AppMethodBeat.i(10746);
        if (view instanceof IPCDynamicPageView) {
            IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
            com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.DynamicPageService", "onUnBindView(%s)", iPCDynamicPageView.getExtId());
            iPCDynamicPageView.removeOnAttachStateChangeListener(this);
            azN().e(str, iPCDynamicPageView);
            com.tencent.mm.plugin.appbrand.dynamic.h.a.aAb().b(str, iPCDynamicPageView);
            iPCDynamicPageView.detach();
            i.azC().zW(str);
            AppMethodBeat.o(10746);
            return;
        }
        AppMethodBeat.o(10746);
    }

    public final void cg(View view) {
        AppMethodBeat.i(10747);
        if (view instanceof IPCDynamicPageView) {
            ((IPCDynamicPageView) view).nQ(TXLiveConstants.PLAY_WARNING_RECV_DATA_LAG);
            AppMethodBeat.o(10747);
            return;
        }
        AppMethodBeat.o(10747);
    }

    public final void pm(String str) {
        AppMethodBeat.i(10748);
        com.tencent.mm.plugin.appbrand.dynamic.h.a.aAb().hoD.remove(str);
        com.tencent.mm.plugin.appbrand.dynamic.h.a aAb = com.tencent.mm.plugin.appbrand.dynamic.h.a.aAb();
        if (!(str == null || str.length() == 0)) {
            aAb.hoE.remove(str);
        }
        Set<View> be = azN().be(str);
        if (be == null || be.isEmpty()) {
            AppMethodBeat.o(10748);
            return;
        }
        for (View view : be) {
            if (view != null && (view instanceof IPCDynamicPageView)) {
                IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
                com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.DynamicPageService", "onUnbindAllView, do unBindView(%s)", iPCDynamicPageView.getExtId());
                iPCDynamicPageView.removeOnAttachStateChangeListener(this);
                iPCDynamicPageView.detach();
            }
        }
        if (azN().abx().isEmpty()) {
            com.tencent.mm.ce.a.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10980);
                    for (String str : i.azC().azD()) {
                        if (com.tencent.mm.ipcinvoker.b.PL().le(str)) {
                            com.tencent.mm.ipcinvoker.f.a(str, null, b.class, null);
                        } else {
                            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DynamicPkgUpdater", "has not Connected RemoteService, abort clearCache");
                            AppMethodBeat.o(10980);
                            return;
                        }
                    }
                    AppMethodBeat.o(10980);
                }
            });
        }
        i.azC().zW(str);
        AppMethodBeat.o(10748);
    }

    public final com.tencent.mm.modelappbrand.n ch(View view) {
        if (view instanceof IPCDynamicPageView) {
            return (com.tencent.mm.modelappbrand.n) view;
        }
        return null;
    }

    private com.tencent.mm.modelappbrand.c azN() {
        AppMethodBeat.i(10749);
        if (this.hmc == null) {
            synchronized (this) {
                try {
                    if (this.hmc == null) {
                        this.hmc = new a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(10749);
                    }
                }
            }
        }
        com.tencent.mm.modelappbrand.c cVar = this.hmc;
        AppMethodBeat.o(10749);
        return cVar;
    }

    public final com.tencent.mm.modelappbrand.d aby() {
        AppMethodBeat.i(10750);
        if (this.hmj == null) {
            synchronized (this) {
                try {
                    if (this.hmj == null) {
                        this.hmj = new b(azN());
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(10750);
                    }
                }
            }
        }
        b bVar = this.hmj;
        AppMethodBeat.o(10750);
        return bVar;
    }

    public final l abz() {
        AppMethodBeat.i(10751);
        if (this.hmk == null) {
            synchronized (this) {
                try {
                    if (this.hmk == null) {
                        this.hmk = new e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(10751);
                    }
                }
            }
        }
        e eVar = this.hmk;
        AppMethodBeat.o(10751);
        return eVar;
    }

    public final void b(String str, Throwable th) {
        AppMethodBeat.i(10752);
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.DynamicPageService", "uncaughtException(%s)", Log.getStackTraceString(th));
        shutdown();
        AppMethodBeat.o(10752);
    }

    public final void onViewAttachedToWindow(View view) {
        AppMethodBeat.i(10753);
        if (view == null || !(view instanceof IPCDynamicPageView)) {
            AppMethodBeat.o(10753);
            return;
        }
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.DynamicPageService", "onViewAttachedToWindow(%s)", ((IPCDynamicPageView) view).getExtId());
        r7.onResume();
        AppMethodBeat.o(10753);
    }

    public final void onViewDetachedFromWindow(View view) {
        AppMethodBeat.i(10754);
        if (view == null || !(view instanceof IPCDynamicPageView)) {
            AppMethodBeat.o(10754);
            return;
        }
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.DynamicPageService", "onViewDetachedFromWindow(%s)", ((IPCDynamicPageView) view).getExtId());
        r7.onPause();
        AppMethodBeat.o(10754);
    }

    public final void a(String str, IPCDynamicPageView iPCDynamicPageView) {
        AppMethodBeat.i(10755);
        com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.DynamicPageService", "onOverLength(sessionId : %s, view : %s)", str, iPCDynamicPageView.getExtId());
        a(str, (View) iPCDynamicPageView);
        AppMethodBeat.o(10755);
    }
}
