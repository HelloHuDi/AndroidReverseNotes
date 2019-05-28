package com.tencent.p177mm.plugin.websearch.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C18514l;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C42141j;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9548e;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelappbrand.C1856af;
import com.tencent.p177mm.modelappbrand.C1857ah;
import com.tencent.p177mm.modelappbrand.C1858n;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.modelappbrand.C26436f;
import com.tencent.p177mm.modelappbrand.C26438t;
import com.tencent.p177mm.modelappbrand.C26439v;
import com.tencent.p177mm.modelappbrand.C36699aa;
import com.tencent.p177mm.modelappbrand.C36700ac;
import com.tencent.p177mm.modelappbrand.C36701ad;
import com.tencent.p177mm.modelappbrand.C36702ae;
import com.tencent.p177mm.modelappbrand.C37936z;
import com.tencent.p177mm.modelappbrand.C45443aj;
import com.tencent.p177mm.modelappbrand.C9684ag;
import com.tencent.p177mm.modelappbrand.C9685ai;
import com.tencent.p177mm.modelappbrand.C9687e;
import com.tencent.p177mm.modelappbrand.C9688w;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p230g.p232b.p233a.C18451cp;
import com.tencent.p177mm.p230g.p232b.p233a.C26273ad;
import com.tencent.p177mm.p230g.p232b.p233a.C9513cr;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.widget.ThreeDotsLoadingView;
import com.tencent.p177mm.plugin.appbrand.p328r.C10706p;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C22759r;
import com.tencent.p177mm.plugin.websearch.api.C40192f;
import com.tencent.p177mm.plugin.websearch.api.C43852n;
import com.tencent.p177mm.plugin.websearch.api.WidgetData;
import com.tencent.p177mm.plugin.websearch.widget.p1323c.C40202b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.websearch.widget.a */
public final class C29750a implements C40192f {
    private static C18652u ucD = new C18652u();
    private Context context;
    private Map<String, WidgetData> ucA = new HashMap();
    public boolean ucB = true;
    private C22759r ucC;
    private WidgetData ucE;
    private Runnable ucF;
    private String ucG;
    private volatile String ucH = null;
    private HashMap<String, Object> ucs = new HashMap();
    private HashMap<String, Object> uct = new HashMap();
    private HashMap<String, Object> ucu = new HashMap();
    private Map<String, String> ucv = new HashMap();
    private int ucw = -1;
    private C9687e ucx;
    private Map<String, C14434e> ucy = new HashMap();
    private Map<String, C29756d> ucz = new HashMap();

    /* renamed from: com.tencent.mm.plugin.websearch.widget.a$e */
    class C14434e {
        int ubI;
        int udj;

        private C14434e() {
        }

        /* synthetic */ C14434e(C29750a c29750a, byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.m2504i(91407);
            String format = String.format("minH %d, maxH %d", new Object[]{Integer.valueOf(this.udj), Integer.valueOf(this.ubI)});
            AppMethodBeat.m2505o(91407);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.a$a */
    static class C29753a implements C45413i<Bundle, Bundle> {
        private C29753a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(91403);
            C5141c ll = C18624c.abi().mo17131ll("100266");
            int i = ll.isValid() ? C5046bo.getInt((String) ll.dru().get("search_wa_widget_init_out_time"), TXRecordCommon.AUDIO_SAMPLERATE_8000) : TXRecordCommon.AUDIO_SAMPLERATE_8000;
            Bundle bundle = new Bundle();
            bundle.putInt("search_wa_widget_init_out_time", i);
            AppMethodBeat.m2505o(91403);
            return bundle;
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.a$b */
    static class C29754b implements C37866a<Bundle, Bundle> {
        private C29754b() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(91404);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("id");
            String string2 = bundle.getString("srcAppid");
            C18652u.m29149a(string, bundle.getInt("serviceType"), bundle.getString("appid"), string2, bundle.getInt("drawStrategy"));
            AppMethodBeat.m2505o(91404);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.a$c */
    static class C29755c implements C37866a<Bundle, Bundle> {
        private C29755c() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(91405);
            Bundle bundle = (Bundle) obj;
            ((C43852n) C1720g.m3528K(C43852n.class)).mo47998gQ(bundle.getString("widgetId"), bundle.getString("path"));
            AppMethodBeat.m2505o(91405);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.a$d */
    class C29756d {
        int cBc;
        String csB;
        int gVu;
        String hlE;
        boolean isLoading;
        boolean udi;

        private C29756d() {
        }

        /* synthetic */ C29756d(C29750a c29750a, byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.m2504i(91406);
            String format = String.format("WidgetInfo appid %s, widgetId %s, pkgType %d, pkgVer %d", new Object[]{this.csB, this.hlE, Integer.valueOf(this.cBc), Integer.valueOf(this.gVu)});
            AppMethodBeat.m2505o(91406);
            return format;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m47175a(C29750a c29750a, View view, View view2, int i, int i2, int i3, int i4, String str) {
        AppMethodBeat.m2504i(91426);
        c29750a.m47174a(view, view2, i, i2, i3, i4, str);
        AppMethodBeat.m2505o(91426);
    }

    static {
        AppMethodBeat.m2504i(91427);
        AppMethodBeat.m2505o(91427);
    }

    public static C18652u cVO() {
        return ucD;
    }

    public C29750a(Context context, final C22759r c22759r) {
        AppMethodBeat.m2504i(91408);
        this.context = context;
        this.ucC = c22759r;
        this.ucx = (C9687e) C1720g.m3528K(C9687e.class);
        if (this.ucB && new File(C6457e.eSn, "websearch-widget-not-use-tools").exists()) {
            this.ucB = false;
        }
        if (C4996ah.bqo()) {
            C9549f.m17011a("com.tencent.mm:support", new C42141j() {
                public final void onDisconnect() {
                    AppMethodBeat.m2504i(91378);
                    if ("com.tencent.mm:support".equals(C29750a.this.ucG)) {
                        C18652u.m29151i("FTSSearchWidgetMgr", "support process dead", new Object[0]);
                        if (C29750a.this.ucE != null) {
                            C26273ad eZ = new C26273ad().mo43951eZ(C29750a.this.ucE.ubs.fpS);
                            eZ.cYw = (long) C29750a.this.ucE.ubs.fmr;
                            eZ.cYs = 21;
                            eZ.cYt = System.currentTimeMillis();
                            eZ.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
                            C26439v.m42099kT(30);
                            c22759r.cUV();
                        }
                    }
                    AppMethodBeat.m2505o(91378);
                }
            });
        }
        AppMethodBeat.m2505o(91408);
    }

    public final void adD(String str) {
        AppMethodBeat.m2504i(91409);
        C29756d c29756d = (C29756d) this.ucz.get(str);
        if (c29756d != null) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", c29756d.csB);
            bundle.putString("msg_id", c29756d.hlE);
            bundle.putInt("pkg_type", c29756d.cBc);
            bundle.putInt("pkg_version", c29756d.gVu);
            ((C9687e) C1720g.m3528K(C9687e.class)).abz().mo33915e(this.context, bundle);
        }
        AppMethodBeat.m2505o(91409);
    }

    /* renamed from: a */
    public final void mo48002a(WidgetData widgetData, String str, int i, int i2) {
        AppMethodBeat.m2504i(91410);
        final WidgetData widgetData2 = widgetData;
        final String str2 = str;
        final int i3 = i2;
        final int i4 = i;
        C18514l.m28821s(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.websearch.widget.a$2$2 */
            class C45182 implements Runnable {

                /* renamed from: com.tencent.mm.plugin.websearch.widget.a$2$2$5 */
                class C45175 extends C36699aa {
                    C45175() {
                    }

                    /* renamed from: pw */
                    public final void mo9589pw(String str) {
                        AppMethodBeat.m2504i(91383);
                        C40203d.cVP();
                        C40203d.m68951b(widgetData2, str);
                        AppMethodBeat.m2505o(91383);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.websearch.widget.a$2$2$4 */
                class C45194 extends C36702ae {
                    C45194() {
                    }

                    /* renamed from: aq */
                    public final void mo9591aq(String str, String str2) {
                        AppMethodBeat.m2504i(91382);
                        C4990ab.m7419v("FTSSearchWidgetMgr", "on widget data push, widgetId[%s], respData[%s]", str, str2);
                        String c = C29750a.m47183c(C29750a.this, str);
                        if (C5046bo.isNullOrNil(c)) {
                            C4990ab.m7412e("FTSSearchWidgetMgr", "onWidgetDataPush widget cache key not found!");
                            AppMethodBeat.m2505o(91382);
                            return;
                        }
                        C29750a.this.ucC.mo38350gS(c, str2);
                        AppMethodBeat.m2505o(91382);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.websearch.widget.a$2$2$3 */
                class C45203 extends C9685ai {
                    C45203() {
                    }

                    /* renamed from: pA */
                    public final void mo9592pA(String str) {
                        AppMethodBeat.m2504i(91381);
                        C4990ab.m7419v("FTSSearchWidgetMgr", "on widget reload data, widgetId[%s]", str);
                        String c = C29750a.m47183c(C29750a.this, str);
                        if (C5046bo.isNullOrNil(c)) {
                            C4990ab.m7412e("FTSSearchWidgetMgr", "onWidgetReloadData widget cache key not found!");
                            AppMethodBeat.m2505o(91381);
                            return;
                        }
                        C29750a.this.ucC.adG(c);
                        AppMethodBeat.m2505o(91381);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.websearch.widget.a$2$2$10 */
                class C452110 extends C9688w {
                    C452110() {
                    }

                    public final void abM() {
                        AppMethodBeat.m2504i(91386);
                        C29756d c29756d = (C29756d) C29750a.this.ucz.get(str2);
                        if (c29756d != null) {
                            c29756d.udi = true;
                            c29756d.isLoading = false;
                        }
                        C26439v.m42099kT(33);
                        AppMethodBeat.m2505o(91386);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.websearch.widget.a$2$2$11 */
                class C452211 extends C45443aj {
                    C452211() {
                    }

                    /* renamed from: a */
                    public final void mo9594a(int i, C26438t c26438t) {
                        AppMethodBeat.m2504i(91387);
                        C29750a.m47177a(C29750a.this, str2, i, c26438t);
                        AppMethodBeat.m2505o(91387);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.websearch.widget.a$2$2$6 */
                class C45236 extends C37936z {
                    C45236() {
                    }

                    /* renamed from: pv */
                    public final void mo9595pv(String str) {
                        AppMethodBeat.m2504i(91384);
                        C40203d.cVP();
                        C40203d.m68953c(widgetData2, str);
                        AppMethodBeat.m2505o(91384);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.websearch.widget.a$2$2$7 */
                class C45247 implements C18507c<Bundle> {
                    C45247() {
                    }

                    /* renamed from: ao */
                    public final /* bridge */ /* synthetic */ void mo5960ao(Object obj) {
                    }
                }

                /* renamed from: com.tencent.mm.plugin.websearch.widget.a$2$2$8 */
                class C45258 implements C18507c<Bundle> {
                    C45258() {
                    }

                    /* renamed from: ao */
                    public final /* bridge */ /* synthetic */ void mo5960ao(Object obj) {
                    }
                }

                /* renamed from: com.tencent.mm.plugin.websearch.widget.a$2$2$2 */
                class C45272 extends C36701ad {
                    C45272() {
                    }

                    /* renamed from: py */
                    public final void mo9597py(String str) {
                        AppMethodBeat.m2504i(91380);
                        C4990ab.m7419v("FTSSearchWidgetMgr", "on widget call %s ", "onMakePhoneCall");
                        if (TextUtils.isEmpty(str)) {
                            C4990ab.m7412e("FTSSearchWidgetMgr", "onMakePhone null number");
                            AppMethodBeat.m2505o(91380);
                            return;
                        }
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
                        intent.addFlags(268435456);
                        if (C5046bo.m7572k(C29750a.this.context, intent)) {
                            C29750a.this.context.startActivity(intent);
                        }
                        AppMethodBeat.m2505o(91380);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.websearch.widget.a$2$2$1 */
                class C45281 implements C18507c<Bundle> {
                    C45281() {
                    }

                    /* renamed from: ao */
                    public final /* bridge */ /* synthetic */ void mo5960ao(Object obj) {
                    }
                }

                /* renamed from: com.tencent.mm.plugin.websearch.widget.a$2$2$14 */
                class C453014 extends C1857ah {
                    C453014() {
                    }

                    /* renamed from: pz */
                    public final void mo5433pz(String str) {
                        AppMethodBeat.m2504i(91390);
                        C4990ab.m7419v("FTSSearchWidgetMgr", "on widget call %s ", "onOpenApp");
                        C29750a.m47179a(C29750a.this, str, str2);
                        AppMethodBeat.m2505o(91390);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.websearch.widget.a$2$2$12 */
                class C453112 extends C1856af {
                    C453112() {
                    }

                    /* renamed from: b */
                    public final void mo5431b(boolean z, String str, boolean z2) {
                        AppMethodBeat.m2504i(91388);
                        C4990ab.m7419v("FTSSearchWidgetMgr", "on widget call %s ", "onSearchWAWidgetOnTapCallback");
                        C4990ab.m7417i("FTSSearchWidgetMgr", "on widget call %s , hasHandler %s, eventId %s,res %s", "onSearchWAWidgetOnTapCallback", Boolean.valueOf(z), str, Boolean.valueOf(z2));
                        if (str.equals(C29750a.this.ucH)) {
                            C29750a.this.ucH = null;
                            C22759r c = C29750a.this.ucC;
                            if (!z) {
                                z2 = false;
                            }
                            c.mo38349g(str, z2, str2);
                        }
                        AppMethodBeat.m2505o(91388);
                    }
                }

                C45182() {
                }

                public final void run() {
                    C29756d c29756d;
                    AppMethodBeat.m2504i(91391);
                    C29750a.this.ucE = widgetData2;
                    C29750a.this.ucA.put(str2, widgetData2);
                    C26439v.m42099kT(0);
                    String str = "sessionid_" + System.currentTimeMillis();
                    C18652u.m29151i("FTSSearchWidgetMgr", "inserting widget: serviceType %d widgetId %s, sessionId %s, jsonData %s ", Integer.valueOf(widgetData2.ubs.fmr), str2, str, widgetData2.toString());
                    C29756d c29756d2 = (C29756d) C29750a.this.ucz.get(str2);
                    if (c29756d2 == null) {
                        c29756d2 = new C29756d(C29750a.this, (byte) 0);
                        C29750a.this.ucz.put(str2, c29756d2);
                        c29756d = c29756d2;
                    } else {
                        c29756d = c29756d2;
                    }
                    c29756d.isLoading = true;
                    try {
                        long j;
                        C40203d.cVP();
                        C40203d.m68950b(widgetData2);
                        C14434e c14434e = (C14434e) C29750a.this.ucy.get(str2);
                        if (c14434e == null) {
                            c14434e = new C14434e(C29750a.this, (byte) 0);
                            C29750a.this.ucy.put(str2, c14434e);
                        }
                        c14434e.udj = (int) widgetData2.ubt.ubH;
                        c14434e.ubI = widgetData2.ubt.ubI;
                        C4990ab.m7417i("FTSSearchWidgetMgr", "update widgetSize %s", c14434e.toString());
                        C29750a.cVO();
                        C18652u.m29156pu(widgetData2.ubs.fpS);
                        boolean z = !TextUtils.isEmpty((CharSequence) C8874h.m15848bP(widgetData2.ubs.csu).get("widgetData"));
                        if (z) {
                            C29750a.cVO();
                            C18652u.abL();
                        }
                        C26273ad eZ = new C26273ad().mo43951eZ(widgetData2.ubs.fpS);
                        if (z) {
                            j = 1;
                        } else {
                            j = 2;
                        }
                        eZ.cYx = j;
                        eZ.cYw = (long) widgetData2.ubs.fmr;
                        eZ.cYs = 1;
                        C26273ad eY = eZ.mo43950eY(str2);
                        eY.cYt = System.currentTimeMillis();
                        eY.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
                        final View bS = C29750a.this.ucx.mo21018bS(C29750a.this.context);
                        AbsoluteLayout absoluteLayout = (AbsoluteLayout) C5616v.m8409hu(C29750a.this.context).inflate(2130969646, null);
                        absoluteLayout.setLayoutParams(new LayoutParams(-1, -2, C10706p.m18379qd(widgetData2.ubt.offsetX), C10706p.m18379qd(widgetData2.ubt.offsetY)));
                        LayoutParams layoutParams = new LayoutParams(C10706p.m18379qd(widgetData2.ubt.width), C10706p.m18379qd(widgetData2.ubt.height), 0, 0);
                        bS.setLayoutParams(layoutParams);
                        absoluteLayout.addView(bS);
                        FrameLayout frameLayout = (FrameLayout) absoluteLayout.findViewById(2131824289);
                        frameLayout.setLayoutParams(layoutParams);
                        absoluteLayout.removeView(frameLayout);
                        absoluteLayout.addView(frameLayout);
                        try {
                            bS.setBackgroundColor(Color.parseColor(widgetData2.ubt.hfo));
                        } catch (Exception e) {
                            C4990ab.m7412e("FTSSearchWidgetMgr", "the color is error : ");
                        }
                        bS.setTag(str);
                        C29750a.this.ucs.put(str2, bS);
                        C29750a.this.uct.put(str2, absoluteLayout);
                        C29750a.this.ucu.put(str2, frameLayout);
                        ThreeDotsLoadingView threeDotsLoadingView = (ThreeDotsLoadingView) absoluteLayout.findViewById(2131821325);
                        ImageView imageView = (ImageView) absoluteLayout.findViewById(2131821842);
                        String str2 = widgetData2.ubs.fpS + "_" + widgetData2.ubs.ubx.hashCode();
                        Bundle bundle = new Bundle();
                        if (C29750a.this.ucB) {
                            C29750a.this.ucG = "com.tencent.mm:tools";
                        } else {
                            C29750a.this.ucG = "com.tencent.mm:support";
                        }
                        bundle.putString("exec_process_name", C29750a.this.ucG);
                        bundle.putString("app_id", widgetData2.ubs.csB);
                        bundle.putString("src_app_id", widgetData2.ubs.fpS);
                        bundle.putString("wxa_unique_id", str2);
                        bundle.putString("msg_id", str2);
                        bundle.putString("search_id", widgetData2.ubs.hlm);
                        bundle.putString("cache_key", widgetData2.ubs.ubx);
                        bundle.putString("msg_title", widgetData2.ubs.bCu);
                        bundle.putString("msg_path", widgetData2.ubs.csu);
                        bundle.putInt("pkg_version", widgetData2.ubs.version);
                        bundle.putInt("msg_pkg_type", widgetData2.ubs.ubz);
                        bundle.putString("init_data", widgetData2.ubs.ubw);
                        bundle.putInt("widget_type", 1);
                        bundle.putInt("service_type", widgetData2.ubs.fmr);
                        String str3 = "scene";
                        int i = i3;
                        if (i == 201) {
                            i = 1006;
                        } else if (i == 3) {
                            i = 1005;
                        } else if (i == 16) {
                            i = 1042;
                        } else if (i == 20) {
                            i = FilterEnum4Shaka.MIC_SHAKA_ADD2_18;
                        } else {
                            i = 1000;
                        }
                        bundle.putInt(str3, i);
                        bundle.putInt("view_init_width", C10706p.m18379qd(widgetData2.ubt.width));
                        bundle.putInt("view_init_height", C10706p.m18379qd(widgetData2.ubt.height));
                        bundle.putString(SearchIntents.EXTRA_QUERY, widgetData2.ubs.ubx);
                        bundle.putString("preload_launch_data", widgetData2.ubs.uby);
                        bundle.putString("preload_download_data", widgetData2.ubs.downloadUrl);
                        bundle.putInt("draw_strategy", i4);
                        bundle.putBoolean("use_predraw", ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_open_pre_draw, 0) == 1);
                        threeDotsLoadingView.setVisibility(0);
                        imageView.setVisibility(4);
                        threeDotsLoadingView.dKS();
                        c29756d.csB = widgetData2.ubs.csB;
                        c29756d.cBc = widgetData2.ubs.ubz;
                        c29756d.gVu = widgetData2.ubs.version;
                        c29756d.hlE = str2;
                        C4990ab.m7417i("FTSSearchWidgetMgr", "inserting widget %s", c29756d.toString());
                        long currentTimeMillis = System.currentTimeMillis();
                        C7060h.pYm.mo8378a(867, 0, 1, false);
                        str2 = str;
                        final ThreeDotsLoadingView threeDotsLoadingView2 = threeDotsLoadingView;
                        final ImageView imageView2 = imageView;
                        final long j2 = currentTimeMillis;
                        final boolean z2 = z;
                        C36700ac c36700ac = new C36700ac(new C26436f() {
                            /* renamed from: F */
                            public final void mo9596F(View view, int i) {
                                AppMethodBeat.m2504i(91385);
                                C18652u.m29151i("FTSSearchWidgetMgr", "onWidgetStateChanged sessionId %s, state %d", str2, Integer.valueOf(i));
                                C29750a.this.ucw = i;
                                switch (i) {
                                    case 0:
                                        C7060h.pYm.mo8378a(867, 1, 1, false);
                                        if (C29750a.this.ucz.get(str2) != null) {
                                            if (((C29756d) C29750a.this.ucz.get(str2)).udi) {
                                                threeDotsLoadingView2.setVisibility(8);
                                            } else {
                                                threeDotsLoadingView2.setVisibility(0);
                                            }
                                        }
                                        imageView2.setVisibility(4);
                                        C29750a.this.ucC.mo38346dw(str2, 1);
                                        AppMethodBeat.m2505o(91385);
                                        return;
                                    case 1:
                                        C7060h.pYm.mo8378a(867, 3, 1, false);
                                        threeDotsLoadingView2.dKT();
                                        threeDotsLoadingView2.setVisibility(4);
                                        C29750a.this.ucC.mo38346dw(str2, 3);
                                        C29750a.cVO();
                                        C18652u.m29148B(widgetData2.ubs.csB, false);
                                        ((C29756d) C29750a.this.ucz.get(str2)).isLoading = false;
                                        AppMethodBeat.m2505o(91385);
                                        return;
                                    case 4:
                                        long j;
                                        C7060h.pYm.mo8378a(867, 2, 1, false);
                                        threeDotsLoadingView2.setVisibility(4);
                                        imageView2.setVisibility(4);
                                        threeDotsLoadingView2.dKT();
                                        C29750a.cVO();
                                        C18652u.m29148B(widgetData2.ubs.csB, true);
                                        ((C29756d) C29750a.this.ucz.get(str2)).isLoading = false;
                                        C29750a.this.ucC.mo38346dw(str2, 2);
                                        C18652u.m29151i("FTSSearchWidgetMgr", "widget display timecost %d ms", Long.valueOf(System.currentTimeMillis() - j2));
                                        C18451cp hw = new C18451cp().mo33727hw(widgetData2.ubs.fpS);
                                        hw.dhm = System.currentTimeMillis() - j2;
                                        if (z2) {
                                            j = 1;
                                        } else {
                                            j = 2;
                                        }
                                        hw.cYx = j;
                                        hw.ajK();
                                        C9513cr c9513cr = new C9513cr();
                                        c9513cr.cTl = 4;
                                        C9513cr hD = c9513cr.mo20801hD(widgetData2.ubs.fpS);
                                        hD.dhm = System.currentTimeMillis() - j2;
                                        if (z2) {
                                            j = 1;
                                        } else {
                                            j = 2;
                                        }
                                        hD.cYx = j;
                                        hD.dhw = (long) i4;
                                        hD.ajK();
                                        C40203d.cVP();
                                        C40203d.m68954d(widgetData2);
                                        AppMethodBeat.m2505o(91385);
                                        return;
                                    default:
                                        C7060h.pYm.mo8378a(867, 4, 1, false);
                                        C29750a.cVO();
                                        C18652u.m29148B(widgetData2.ubs.csB, false);
                                        threeDotsLoadingView2.dKT();
                                        threeDotsLoadingView2.setVisibility(4);
                                        ((C29756d) C29750a.this.ucz.get(str2)).isLoading = false;
                                        if (i == 2) {
                                            C29750a.this.ucC.mo38346dw(str2, 4);
                                            AppMethodBeat.m2505o(91385);
                                            return;
                                        }
                                        C29750a.this.ucC.mo38346dw(str2, 3);
                                        AppMethodBeat.m2505o(91385);
                                        return;
                                }
                            }
                        });
                        c36700ac.mo58565a(new C452110());
                        c36700ac.mo58565a(new C22772g(C29750a.this.context));
                        c36700ac.mo58565a(new C452211());
                        c36700ac.mo58565a(new C453112());
                        c36700ac.mo58565a(new C9684ag() {
                            public final void abP() {
                                AppMethodBeat.m2504i(91389);
                                C29750a.m47178a(C29750a.this, str2, bS);
                                AppMethodBeat.m2505o(91389);
                            }
                        });
                        c36700ac.mo58565a(new C453014());
                        c36700ac.mo58565a(new C45272());
                        c36700ac.mo58565a(new C45203());
                        c36700ac.mo58565a(new C45194());
                        c36700ac.mo58565a(new C45175());
                        c36700ac.mo58565a(new C45236());
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("id", str2);
                        bundle2.putString("appid", widgetData2.ubs.csB);
                        bundle2.putInt("serviceType", widgetData2.ubs.fmr);
                        bundle2.putInt("drawStrategy", i4);
                        bundle2.putString("srcAppid", widgetData2.ubs.fpS);
                        C18652u.m29149a(str2, widgetData2.ubs.fmr, widgetData2.ubs.csB, widgetData2.ubs.fpS, i4);
                        C29750a.this.ucv.put(C29750a.this.ucx.mo21014a(str, bS, bundle, c36700ac), str2);
                        C9549f.m17012a("com.tencent.mm", bundle2, C29754b.class, new C45281());
                        C9549f.m17012a(C29750a.this.ucG, bundle2, C29754b.class, new C45247());
                        C9549f.m17012a(C9548e.m17007PN(), bundle2, C29754b.class, new C45258());
                        C29750a.m47176a(C29750a.this, widgetData2, str2, str, bS, absoluteLayout, threeDotsLoadingView);
                        C29750a.this.ucC.addView(absoluteLayout);
                        AppMethodBeat.m2505o(91391);
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("FTSSearchWidgetMgr", e2, "", new Object[0]);
                        AppMethodBeat.m2505o(91391);
                    }
                }
            }

            /* renamed from: com.tencent.mm.plugin.websearch.widget.a$2$1 */
            class C144311 implements Runnable {
                C144311() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(91379);
                    C29750a.this.ucC.mo38346dw(str2, 3);
                    AppMethodBeat.m2505o(91379);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(91392);
                if (widgetData2 == null || widgetData2.ubs == null || widgetData2.ubt == null) {
                    AppMethodBeat.m2505o(91392);
                    return;
                }
                C40203d.cVP();
                if (C40203d.m68949a(widgetData2)) {
                    C5004al.m7441d(new C45182());
                    AppMethodBeat.m2505o(91392);
                    return;
                }
                C18652u.m29151i("FTSSearchWidgetMgr", "local forbidden widget %s", widgetData2.ubs.fpS);
                C5004al.m7441d(new C144311());
                AppMethodBeat.m2505o(91392);
            }
        });
        AppMethodBeat.m2505o(91410);
    }

    /* renamed from: m */
    public final void mo48008m(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(91411);
        mo48002a(WidgetData.adQ(str), str2, i, i2);
        AppMethodBeat.m2505o(91411);
    }

    public final void adE(String str) {
        AppMethodBeat.m2504i(91412);
        adS(str);
        C40203d.cVP();
        C40203d.m68952c(this.ucE);
        AppMethodBeat.m2505o(91412);
    }

    private void adS(String str) {
        AppMethodBeat.m2504i(91413);
        if (str != null && str.length() > 0) {
            WidgetData widgetData = (WidgetData) this.ucA.get(str);
            C29756d c29756d = (C29756d) this.ucz.get(str);
            if (!(widgetData == null || c29756d == null || !c29756d.isLoading)) {
                C26273ad eZ = new C26273ad().mo43951eZ(widgetData.ubs.fpS);
                eZ.cYw = (long) widgetData.ubs.fmr;
                eZ.cYs = 24;
                C26273ad eY = eZ.mo43950eY(str);
                eY.cYt = System.currentTimeMillis();
                eY.mo43952fa(C5023at.m7471gB(C4996ah.getContext())).ajK();
            }
            View view = (View) this.ucs.get(str);
            if (view == null) {
                C4990ab.m7417i("FTSSearchWidgetMgr", "removeWidget cacheKey %s, can not find view", str);
                AppMethodBeat.m2505o(91413);
                return;
            }
            C4990ab.m7417i("FTSSearchWidgetMgr", "removing widget sessionId %s", view.getTag().toString());
            if (this.ucx != null) {
                this.ucx.mo21015a((String) view.getTag(), view);
            }
            this.ucs.remove(str);
            this.ucu.remove(str);
            view = (View) this.uct.get(str);
            if (view != null) {
                this.ucC.removeView(view);
                this.uct.remove(str);
            }
        }
        AppMethodBeat.m2505o(91413);
    }

    /* renamed from: gR */
    public final void mo48007gR(String str, String str2) {
        AppMethodBeat.m2504i(91414);
        C4990ab.m7417i("FTSSearchWidgetMgr", "updating widget: widgetId %s, jsonData %s", str2, str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (str2 != null && str2.length() > 0) {
                View view = (View) this.ucs.get(str2);
                View view2 = (View) this.uct.get(str2);
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    if (jSONObject.has("width") || jSONObject.has("height")) {
                        m47174a(view, (View) this.ucu.get(str2), layoutParams.height, C10706p.m18379qd(jSONObject.optInt("height")), layoutParams.width, C10706p.m18379qd(jSONObject.optInt("width")), str2);
                    }
                    if (jSONObject.has("offsetX")) {
                        layoutParams2.x = C10706p.m18379qd(jSONObject.optInt("offsetX"));
                    }
                    if (jSONObject.has("offsetY")) {
                        layoutParams2.y = C10706p.m18379qd(jSONObject.optInt("offsetY"));
                    }
                    view2.setLayoutParams(layoutParams2);
                    if (jSONObject.has("backgroundColor")) {
                        try {
                            view.setBackgroundColor(Color.parseColor(jSONObject.getString("backgroundColor")));
                        } catch (Exception e) {
                            C4990ab.m7412e("FTSSearchWidgetMgr", C5046bo.m7574l(e));
                        }
                    }
                    if (jSONObject.has("show")) {
                        if (jSONObject.has("show") ? jSONObject.optBoolean("show") : false) {
                            view.setVisibility(0);
                            view2.setVisibility(0);
                            AppMethodBeat.m2505o(91414);
                            return;
                        }
                        view.setVisibility(8);
                        view2.setVisibility(8);
                    }
                }
            }
            AppMethodBeat.m2505o(91414);
        } catch (Exception e2) {
            C4990ab.m7412e("FTSSearchWidgetMgr", "the error is e");
            AppMethodBeat.m2505o(91414);
        }
    }

    /* renamed from: a */
    public final void mo48001a(final WidgetData widgetData, final String str) {
        AppMethodBeat.m2504i(91415);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(91397);
                            View view = (View) C29750a.this.ucs.get(str);
                            View view2 = (View) C29750a.this.uct.get(str);
                            if (view != null) {
                                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                                C29750a.m47175a(C29750a.this, view, (View) C29750a.this.ucu.get(str), layoutParams.height, C10706p.m18379qd(widgetData.ubt.height), layoutParams.width, C10706p.m18379qd(widgetData.ubt.width), str);
                                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                                if (layoutParams2 instanceof LayoutParams) {
                                    layoutParams = (LayoutParams) layoutParams2;
                                    layoutParams.x = C10706p.m18379qd(widgetData.ubt.offsetX);
                                    layoutParams.y = C10706p.m18379qd(widgetData.ubt.offsetY);
                                    view2.setLayoutParams(layoutParams);
                                } else if (layoutParams2 instanceof MarginLayoutParams) {
                                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams2;
                                    marginLayoutParams.leftMargin = C10706p.m18379qd(widgetData.ubt.offsetX);
                                    marginLayoutParams.topMargin = C10706p.m18379qd(widgetData.ubt.offsetY);
                                    view2.setLayoutParams(marginLayoutParams);
                                }
                                try {
                                    if (!TextUtils.isEmpty(widgetData.ubt.hfo)) {
                                        view.setBackgroundColor(Color.parseColor(widgetData.ubt.hfo));
                                    }
                                } catch (Exception e) {
                                    C4990ab.m7412e("FTSSearchWidgetMgr", C5046bo.m7574l(e));
                                }
                                if (widgetData.ubt.cNN) {
                                    view.setVisibility(0);
                                    view2.setVisibility(0);
                                    AppMethodBeat.m2505o(91397);
                                    return;
                                }
                                view.setVisibility(8);
                                view2.setVisibility(8);
                            }
                            AppMethodBeat.m2505o(91397);
                        }
                    });
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("FTSSearchWidgetMgr", e, "", new Object[0]);
                AppMethodBeat.m2505o(91415);
                return;
            }
        }
        AppMethodBeat.m2505o(91415);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(91416);
        if (this.ucx != null) {
            for (String str : this.ucs.keySet()) {
                if (str != null && str.length() > 0) {
                    ((C9687e) C1720g.m3528K(C9687e.class)).aby().mo44200pl((String) ((View) this.ucs.get(str)).getTag());
                }
            }
        }
        AppMethodBeat.m2505o(91416);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(91417);
        if (this.ucx != null) {
            for (String str : this.ucs.keySet()) {
                if (str != null && str.length() > 0) {
                    ((C9687e) C1720g.m3528K(C9687e.class)).aby().mo44199pk((String) ((View) this.ucs.get(str)).getTag());
                }
            }
        }
        AppMethodBeat.m2505o(91417);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(91418);
        try {
            final String str = "";
            File[] listFiles = new File(C1761b.eSk.replace("/data/user/0", "/data/data") + "/fts_cache").listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    AppMethodBeat.m2504i(91394);
                    if (file.getAbsolutePath().equals(str)) {
                        AppMethodBeat.m2505o(91394);
                        return false;
                    }
                    AppMethodBeat.m2505o(91394);
                    return true;
                }
            });
            if (listFiles != null) {
                for (File absoluteFile : listFiles) {
                    C18652u.m29151i("FTSSearchWidgetMgr", "deleting %s", absoluteFile.getAbsoluteFile());
                    absoluteFile.delete();
                }
            }
            if (this.ucx != null) {
                C4990ab.m7417i("FTSSearchWidgetMgr", "remove all widget count %d", Integer.valueOf(this.ucs.size()));
                for (String str2 : new HashMap(this.ucs).keySet()) {
                    if (str2 != null && str2.length() > 0) {
                        this.ucx.mo21022pm((String) ((View) this.ucs.get(str2)).getTag());
                        if (((View) this.uct.get(str2)) != null) {
                            adS(str2);
                            this.uct.remove(str2);
                        }
                    }
                }
                this.ucs.clear();
                this.ucu.clear();
            }
            this.ucE = null;
            AppMethodBeat.m2505o(91418);
        } catch (Exception e) {
            C4990ab.m7412e("FTSSearchWidgetMgr", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(91418);
        }
    }

    /* renamed from: f */
    public final void mo48006f(int i, int i2, String str, String str2) {
        AppMethodBeat.m2504i(91419);
        C18652u.m29157v("FTSSearchWidgetMgr", "tapSearchWAWidgetView x %d, y %d, widgetId %s, eventId %s", Integer.valueOf(i), Integer.valueOf(i2), str, str2);
        View view = (View) this.ucs.get(str);
        if (view != null) {
            final C1858n ch = this.ucx.mo21020ch(view);
            final int i3 = i;
            final int i4 = i2;
            final String str3 = str2;
            final String str4 = str;
            C7305d.post(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.websearch.widget.a$7$1 */
                class C144331 implements Runnable {
                    C144331() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(91398);
                        if (str3.equals(C29750a.this.ucH)) {
                            C4990ab.m7417i("FTSSearchWidgetMgr", "tap event timeout id %s", str3);
                            C29750a.this.ucH = null;
                            C29750a.this.ucC.mo38342a(str3, false, "timeout", str4);
                        }
                        AppMethodBeat.m2505o(91398);
                    }
                }

                public final void run() {
                    boolean z;
                    AppMethodBeat.m2504i(91399);
                    C40202b c40202b = new C40202b(i3, i4, str3);
                    C1858n c1858n = ch;
                    if (c1858n == null) {
                        C4990ab.m7412e("BaseJsapiEvent", "null JSBridgeAccessible ");
                        z = false;
                    } else {
                        z = c1858n.mo5434ap(c40202b.getName(), c40202b.cVS());
                    }
                    if (z) {
                        C29750a.this.ucH = str3;
                        C26006a.postDelayed(new C144331(), 1000);
                        AppMethodBeat.m2505o(91399);
                        return;
                    }
                    C4990ab.m7417i("FTSSearchWidgetMgr", "onTap fail: execute js event %s ", str4);
                    C29750a.this.ucC.mo38342a(str3, false, "onTap fail: execute js event  " + str4, str4);
                    AppMethodBeat.m2505o(91399);
                }
            }, "tapSearchWAWidgetView");
            AppMethodBeat.m2505o(91419);
            return;
        }
        C4990ab.m7417i("FTSSearchWidgetMgr", "onTap fail: can not find Widget by widgetId %s", str);
        this.ucC.mo38342a(str2, false, "onTap fail: can not find Widget by widgetId ".concat(String.valueOf(str)), str);
        AppMethodBeat.m2505o(91419);
    }

    public final void cUS() {
        this.ucB = false;
    }

    /* renamed from: a */
    private void m47174a(View view, View view2, int i, int i2, int i3, int i4, String str) {
        AppMethodBeat.m2504i(91420);
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        final View view3 = view;
        final View view4 = view2;
        final String str2 = str;
        C5004al.m7441d(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.websearch.widget.a$8$2 */
            class C45332 implements AnimatorListener {
                C45332() {
                }

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.m2504i(91401);
                    C29750a.m47178a(C29750a.this, str2, view3);
                    AppMethodBeat.m2505o(91401);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(91402);
                C4990ab.m7417i("FTSSearchWidgetMgr", "animating  size beginH %d, endH %d, beginW %d, endW %d", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
                if (i5 == i6 && i7 == i8) {
                    AppMethodBeat.m2505o(91402);
                    return;
                }
                final ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
                final ViewGroup.LayoutParams layoutParams2 = view4.getLayoutParams();
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i5, i6});
                ofInt.setDuration(300);
                ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
                ofInt.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.m2504i(91400);
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        layoutParams.height = intValue;
                        view3.setLayoutParams(layoutParams);
                        layoutParams2.height = intValue;
                        view4.setLayoutParams(layoutParams2);
                        AppMethodBeat.m2505o(91400);
                    }
                });
                ofInt.addListener(new C45332());
                ofInt.start();
                AppMethodBeat.m2505o(91402);
            }
        });
        AppMethodBeat.m2505o(91420);
    }

    /* renamed from: c */
    static /* synthetic */ String m47183c(C29750a c29750a, String str) {
        AppMethodBeat.m2504i(91425);
        String str2 = (String) c29750a.ucv.get(str);
        AppMethodBeat.m2505o(91425);
        return str2;
    }
}
