package com.tencent.p177mm.plugin.appbrand.dynamic.p1138a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.C1858n;
import com.tencent.p177mm.modelappbrand.C18651l;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.modelappbrand.C26435d;
import com.tencent.p177mm.modelappbrand.C26436f;
import com.tencent.p177mm.modelappbrand.C32805ab;
import com.tencent.p177mm.modelappbrand.C9686c;
import com.tencent.p177mm.modelappbrand.C9687e;
import com.tencent.p177mm.modelappbrand.C9688w;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.plugin.appbrand.appcache.C26751z;
import com.tencent.p177mm.plugin.appbrand.collector.C2107c;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10210e;
import com.tencent.p177mm.plugin.appbrand.dynamic.C33164i;
import com.tencent.p177mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.p177mm.plugin.appbrand.dynamic.p284b.C33146d;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b.C10204a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b.C45542b;
import com.tencent.p177mm.plugin.appbrand.dynamic.p288h.C38202a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p288h.C38202a.C10215a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p289j.C19194a.C191961;
import com.tencent.p177mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.p177mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.C102233;
import com.tencent.p177mm.plugin.appbrand.p328r.C38496n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5013ao;
import com.tencent.p177mm.sdk.platformtools.C5013ao.C5011c;
import com.tencent.rtmp.TXLiveConstants;
import java.net.URLDecoder;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.a.c */
public final class C16599c implements OnAttachStateChangeListener, C9687e, C10215a, C5011c {
    private String gtl;
    private volatile C9686c hmc;
    private volatile C31287b hmj;
    private volatile C45538e hmk;

    public final void initialize() {
        AppMethodBeat.m2504i(10742);
        if (!(this.gtl == null || this.gtl.length() == 0)) {
            shutdown();
        }
        this.gtl = "Token#" + System.nanoTime();
        C5013ao.m7457a((C5011c) this);
        C26751z.m42581a(new C33146d());
        AppMethodBeat.m2505o(10742);
    }

    public final void shutdown() {
        AppMethodBeat.m2504i(10743);
        Map abx = azN().abx();
        if (abx == null || abx.isEmpty()) {
            AppMethodBeat.m2505o(10743);
            return;
        }
        for (Object next : new LinkedHashSet(abx.keySet())) {
            if (next != null && (next instanceof String)) {
                mo21022pm((String) next);
            }
        }
        AppMethodBeat.m2505o(10743);
    }

    /* renamed from: bS */
    public final View mo21018bS(Context context) {
        AppMethodBeat.m2504i(10744);
        IPCDynamicPageView iPCDynamicPageView = new IPCDynamicPageView(context);
        AppMethodBeat.m2505o(10744);
        return iPCDynamicPageView;
    }

    /* renamed from: a */
    public final String mo21014a(String str, View view, Bundle bundle, C32805ab c32805ab) {
        AppMethodBeat.m2504i(10745);
        String gv;
        if (view instanceof IPCDynamicPageView) {
            String string;
            String str2;
            gv = C38496n.m65149gv(System.nanoTime());
            C2107c.m4315d("widget_launch", gv, "on_bind_view", true);
            C2107c.m4313bE(gv, "init_finish");
            IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
            String str3 = null;
            if (bundle != null) {
                string = bundle.getString("app_id");
                str3 = bundle.getString("msg_id");
                bundle.putString("__session_id", str);
                bundle.putLong("__on_bind_nano_time", System.nanoTime());
                bundle.putString("__session_id", gv);
                bundle.putParcelable("__cost_time_session", C2107c.m4318yH(gv));
                str2 = string;
            } else {
                str2 = null;
            }
            gv = bundle.getString("wxa_unique_id");
            if (TextUtils.isEmpty(gv)) {
                gv = WxaWidgetInitializer.m42771bL(str2, str3);
            }
            string = bundle.getString("exec_process_name", "com.tencent.mm:support");
            C33164i.azC().mo53693bK(gv, string);
            C18652u.m29151i("MicroMsg.DynamicPageService", "onBindView(%s)", gv);
            C10210e.azz().mo21626b(gv, iPCDynamicPageView);
            str3 = (String) C8874h.m15848bP(bundle.getString("msg_path", "")).get("widgetData");
            if (!TextUtils.isEmpty(str3)) {
                try {
                    JSONObject jSONObject = new JSONObject(URLDecoder.decode(str3));
                    if (jSONObject.has("render_data") && jSONObject.getJSONObject("render_data").has("actions")) {
                        C18652u.m29151i("MicroMsg.DynamicPageService", "get render_data and begin predraw", new Object[0]);
                        JSONArray jSONArray = jSONObject.getJSONObject("render_data").getJSONArray("actions");
                        jSONObject = new JSONObject();
                        jSONObject.put("actions", jSONArray);
                        jSONObject.put("reserve", false);
                        String jSONObject2 = jSONObject.toString();
                        jSONObject.put("__invoke_jsapi_timestamp", System.currentTimeMillis());
                        C45542b c45542b = new C45542b();
                        c45542b.mo73354a(string, gv, jSONObject, null, null, C10204a.m17844bb(gv, bundle.getInt("draw_strategy")), jSONObject2);
                        C10204a.m17844bb(gv, bundle.getInt("draw_strategy")).mo21614a(c45542b);
                        C9688w c9688w = (C9688w) c32805ab.mo53363px("WidgetPreDrawCallback");
                        if (c9688w != null) {
                            c9688w.abM();
                        }
                        C18652u.m29152pp(gv);
                    }
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.DynamicPageService", e, "", new Object[0]);
                }
            }
            iPCDynamicPageView.removeOnAttachStateChangeListener(this);
            iPCDynamicPageView.addOnAttachStateChangeListener(this);
            Assert.assertNotNull(gv);
            iPCDynamicPageView.hpr = System.currentTimeMillis();
            C26436f abN = c32805ab != null ? c32805ab.abN() : null;
            if (!(iPCDynamicPageView.eIq == null || gv.equals(iPCDynamicPageView.eIq))) {
                iPCDynamicPageView.cleanup();
            }
            if (!(abN == null || (gv.equals(iPCDynamicPageView.eIq) && iPCDynamicPageView.hpq))) {
                abN.mo9596F(iPCDynamicPageView, 0);
            }
            iPCDynamicPageView.hpq = false;
            C18652u.m29151i("MicroMsg.IPCDynamicPageView", "attach (%s)", gv);
            IPCDynamicPageView.hlg.post(new C102233(gv, bundle, c32805ab, str2));
            C4990ab.m7419v("MicroMsg.DynamicPageService", "onBindView(%s)", gv);
            C38202a aAb = C38202a.aAb();
            if (!(str == null || str.length() == 0)) {
                aAb.hoE.put(str, this);
            }
            C38202a.aAb().mo60937c(str, iPCDynamicPageView);
            azN().mo21012d(str, iPCDynamicPageView);
            AppMethodBeat.m2505o(10745);
            return gv;
        }
        gv = "";
        AppMethodBeat.m2505o(10745);
        return gv;
    }

    /* renamed from: a */
    public final void mo21015a(String str, View view) {
        AppMethodBeat.m2504i(10746);
        if (view instanceof IPCDynamicPageView) {
            IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
            C4990ab.m7419v("MicroMsg.DynamicPageService", "onUnBindView(%s)", iPCDynamicPageView.getExtId());
            iPCDynamicPageView.removeOnAttachStateChangeListener(this);
            azN().mo21013e(str, iPCDynamicPageView);
            C38202a.aAb().mo60936b(str, iPCDynamicPageView);
            iPCDynamicPageView.detach();
            C33164i.azC().mo53695zW(str);
            AppMethodBeat.m2505o(10746);
            return;
        }
        AppMethodBeat.m2505o(10746);
    }

    /* renamed from: cg */
    public final void mo21019cg(View view) {
        AppMethodBeat.m2504i(10747);
        if (view instanceof IPCDynamicPageView) {
            ((IPCDynamicPageView) view).mo53699nQ(TXLiveConstants.PLAY_WARNING_RECV_DATA_LAG);
            AppMethodBeat.m2505o(10747);
            return;
        }
        AppMethodBeat.m2505o(10747);
    }

    /* renamed from: pm */
    public final void mo21022pm(String str) {
        AppMethodBeat.m2504i(10748);
        C38202a.aAb().hoD.remove(str);
        C38202a aAb = C38202a.aAb();
        if (!(str == null || str.length() == 0)) {
            aAb.hoE.remove(str);
        }
        Set<View> be = azN().mo21011be(str);
        if (be == null || be.isEmpty()) {
            AppMethodBeat.m2505o(10748);
            return;
        }
        for (View view : be) {
            if (view != null && (view instanceof IPCDynamicPageView)) {
                IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
                C4990ab.m7419v("MicroMsg.DynamicPageService", "onUnbindAllView, do unBindView(%s)", iPCDynamicPageView.getExtId());
                iPCDynamicPageView.removeOnAttachStateChangeListener(this);
                iPCDynamicPageView.detach();
            }
        }
        if (azN().abx().isEmpty()) {
            C26006a.post(new C191961());
        }
        C33164i.azC().mo53695zW(str);
        AppMethodBeat.m2505o(10748);
    }

    /* renamed from: ch */
    public final C1858n mo21020ch(View view) {
        if (view instanceof IPCDynamicPageView) {
            return (C1858n) view;
        }
        return null;
    }

    private C9686c azN() {
        AppMethodBeat.m2504i(10749);
        if (this.hmc == null) {
            synchronized (this) {
                try {
                    if (this.hmc == null) {
                        this.hmc = new C16598a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(10749);
                    }
                }
            }
        }
        C9686c c9686c = this.hmc;
        AppMethodBeat.m2505o(10749);
        return c9686c;
    }

    public final C26435d aby() {
        AppMethodBeat.m2504i(10750);
        if (this.hmj == null) {
            synchronized (this) {
                try {
                    if (this.hmj == null) {
                        this.hmj = new C31287b(azN());
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(10750);
                    }
                }
            }
        }
        C31287b c31287b = this.hmj;
        AppMethodBeat.m2505o(10750);
        return c31287b;
    }

    public final C18651l abz() {
        AppMethodBeat.m2504i(10751);
        if (this.hmk == null) {
            synchronized (this) {
                try {
                    if (this.hmk == null) {
                        this.hmk = new C45538e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(10751);
                    }
                }
            }
        }
        C45538e c45538e = this.hmk;
        AppMethodBeat.m2505o(10751);
        return c45538e;
    }

    /* renamed from: b */
    public final void mo4564b(String str, Throwable th) {
        AppMethodBeat.m2504i(10752);
        C4990ab.m7413e("MicroMsg.DynamicPageService", "uncaughtException(%s)", Log.getStackTraceString(th));
        shutdown();
        AppMethodBeat.m2505o(10752);
    }

    public final void onViewAttachedToWindow(View view) {
        AppMethodBeat.m2504i(10753);
        if (view == null || !(view instanceof IPCDynamicPageView)) {
            AppMethodBeat.m2505o(10753);
            return;
        }
        C4990ab.m7411d("MicroMsg.DynamicPageService", "onViewAttachedToWindow(%s)", ((IPCDynamicPageView) view).getExtId());
        r7.onResume();
        AppMethodBeat.m2505o(10753);
    }

    public final void onViewDetachedFromWindow(View view) {
        AppMethodBeat.m2504i(10754);
        if (view == null || !(view instanceof IPCDynamicPageView)) {
            AppMethodBeat.m2505o(10754);
            return;
        }
        C4990ab.m7411d("MicroMsg.DynamicPageService", "onViewDetachedFromWindow(%s)", ((IPCDynamicPageView) view).getExtId());
        r7.onPause();
        AppMethodBeat.m2505o(10754);
    }

    /* renamed from: a */
    public final void mo21629a(String str, IPCDynamicPageView iPCDynamicPageView) {
        AppMethodBeat.m2504i(10755);
        C4990ab.m7419v("MicroMsg.DynamicPageService", "onOverLength(sessionId : %s, view : %s)", str, iPCDynamicPageView.getExtId());
        mo21015a(str, (View) iPCDynamicPageView);
        AppMethodBeat.m2505o(10755);
    }
}
