package com.tencent.mm.plugin.websearch.widget;

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
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.ad;
import com.tencent.mm.g.b.a.cp;
import com.tencent.mm.g.b.a.cr;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.ae;
import com.tencent.mm.modelappbrand.af;
import com.tencent.mm.modelappbrand.ag;
import com.tencent.mm.modelappbrand.ai;
import com.tencent.mm.modelappbrand.aj;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.plugin.appbrand.r.p;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a implements f {
    private static u ucD = new u();
    private Context context;
    private Map<String, WidgetData> ucA = new HashMap();
    public boolean ucB = true;
    private r ucC;
    private WidgetData ucE;
    private Runnable ucF;
    private String ucG;
    private volatile String ucH = null;
    private HashMap<String, Object> ucs = new HashMap();
    private HashMap<String, Object> uct = new HashMap();
    private HashMap<String, Object> ucu = new HashMap();
    private Map<String, String> ucv = new HashMap();
    private int ucw = -1;
    private com.tencent.mm.modelappbrand.e ucx;
    private Map<String, e> ucy = new HashMap();
    private Map<String, d> ucz = new HashMap();

    class e {
        int ubI;
        int udj;

        private e() {
        }

        /* synthetic */ e(a aVar, byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(91407);
            String format = String.format("minH %d, maxH %d", new Object[]{Integer.valueOf(this.udj), Integer.valueOf(this.ubI)});
            AppMethodBeat.o(91407);
            return format;
        }
    }

    static class a implements i<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(91403);
            com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100266");
            int i = ll.isValid() ? bo.getInt((String) ll.dru().get("search_wa_widget_init_out_time"), TXRecordCommon.AUDIO_SAMPLERATE_8000) : TXRecordCommon.AUDIO_SAMPLERATE_8000;
            Bundle bundle = new Bundle();
            bundle.putInt("search_wa_widget_init_out_time", i);
            AppMethodBeat.o(91403);
            return bundle;
        }
    }

    static class b implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(91404);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("id");
            String string2 = bundle.getString("srcAppid");
            u.a(string, bundle.getInt("serviceType"), bundle.getString("appid"), string2, bundle.getInt("drawStrategy"));
            AppMethodBeat.o(91404);
        }
    }

    static class c implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private c() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(91405);
            Bundle bundle = (Bundle) obj;
            ((n) g.K(n.class)).gQ(bundle.getString("widgetId"), bundle.getString("path"));
            AppMethodBeat.o(91405);
        }
    }

    class d {
        int cBc;
        String csB;
        int gVu;
        String hlE;
        boolean isLoading;
        boolean udi;

        private d() {
        }

        /* synthetic */ d(a aVar, byte b) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(91406);
            String format = String.format("WidgetInfo appid %s, widgetId %s, pkgType %d, pkgVer %d", new Object[]{this.csB, this.hlE, Integer.valueOf(this.cBc), Integer.valueOf(this.gVu)});
            AppMethodBeat.o(91406);
            return format;
        }
    }

    static /* synthetic */ void a(a aVar, View view, View view2, int i, int i2, int i3, int i4, String str) {
        AppMethodBeat.i(91426);
        aVar.a(view, view2, i, i2, i3, i4, str);
        AppMethodBeat.o(91426);
    }

    static {
        AppMethodBeat.i(91427);
        AppMethodBeat.o(91427);
    }

    public static u cVO() {
        return ucD;
    }

    public a(Context context, final r rVar) {
        AppMethodBeat.i(91408);
        this.context = context;
        this.ucC = rVar;
        this.ucx = (com.tencent.mm.modelappbrand.e) g.K(com.tencent.mm.modelappbrand.e.class);
        if (this.ucB && new File(com.tencent.mm.compatible.util.e.eSn, "websearch-widget-not-use-tools").exists()) {
            this.ucB = false;
        }
        if (ah.bqo()) {
            com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:support", new j() {
                public final void onDisconnect() {
                    AppMethodBeat.i(91378);
                    if ("com.tencent.mm:support".equals(a.this.ucG)) {
                        u.i("FTSSearchWidgetMgr", "support process dead", new Object[0]);
                        if (a.this.ucE != null) {
                            ad eZ = new ad().eZ(a.this.ucE.ubs.fpS);
                            eZ.cYw = (long) a.this.ucE.ubs.fmr;
                            eZ.cYs = 21;
                            eZ.cYt = System.currentTimeMillis();
                            eZ.fa(at.gB(ah.getContext())).ajK();
                            v.kT(30);
                            rVar.cUV();
                        }
                    }
                    AppMethodBeat.o(91378);
                }
            });
        }
        AppMethodBeat.o(91408);
    }

    public final void adD(String str) {
        AppMethodBeat.i(91409);
        d dVar = (d) this.ucz.get(str);
        if (dVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", dVar.csB);
            bundle.putString("msg_id", dVar.hlE);
            bundle.putInt("pkg_type", dVar.cBc);
            bundle.putInt("pkg_version", dVar.gVu);
            ((com.tencent.mm.modelappbrand.e) g.K(com.tencent.mm.modelappbrand.e.class)).abz().e(this.context, bundle);
        }
        AppMethodBeat.o(91409);
    }

    public final void a(WidgetData widgetData, String str, int i, int i2) {
        AppMethodBeat.i(91410);
        final WidgetData widgetData2 = widgetData;
        final String str2 = str;
        final int i3 = i2;
        final int i4 = i;
        l.s(new Runnable() {
            public final void run() {
                AppMethodBeat.i(91392);
                if (widgetData2 == null || widgetData2.ubs == null || widgetData2.ubt == null) {
                    AppMethodBeat.o(91392);
                    return;
                }
                d.cVP();
                if (d.a(widgetData2)) {
                    al.d(new Runnable() {
                        public final void run() {
                            d dVar;
                            AppMethodBeat.i(91391);
                            a.this.ucE = widgetData2;
                            a.this.ucA.put(str2, widgetData2);
                            v.kT(0);
                            String str = "sessionid_" + System.currentTimeMillis();
                            u.i("FTSSearchWidgetMgr", "inserting widget: serviceType %d widgetId %s, sessionId %s, jsonData %s ", Integer.valueOf(widgetData2.ubs.fmr), str2, str, widgetData2.toString());
                            d dVar2 = (d) a.this.ucz.get(str2);
                            if (dVar2 == null) {
                                dVar2 = new d(a.this, (byte) 0);
                                a.this.ucz.put(str2, dVar2);
                                dVar = dVar2;
                            } else {
                                dVar = dVar2;
                            }
                            dVar.isLoading = true;
                            try {
                                long j;
                                d.cVP();
                                d.b(widgetData2);
                                e eVar = (e) a.this.ucy.get(str2);
                                if (eVar == null) {
                                    eVar = new e(a.this, (byte) 0);
                                    a.this.ucy.put(str2, eVar);
                                }
                                eVar.udj = (int) widgetData2.ubt.ubH;
                                eVar.ubI = widgetData2.ubt.ubI;
                                ab.i("FTSSearchWidgetMgr", "update widgetSize %s", eVar.toString());
                                a.cVO();
                                u.pu(widgetData2.ubs.fpS);
                                boolean z = !TextUtils.isEmpty((CharSequence) h.bP(widgetData2.ubs.csu).get("widgetData"));
                                if (z) {
                                    a.cVO();
                                    u.abL();
                                }
                                ad eZ = new ad().eZ(widgetData2.ubs.fpS);
                                if (z) {
                                    j = 1;
                                } else {
                                    j = 2;
                                }
                                eZ.cYx = j;
                                eZ.cYw = (long) widgetData2.ubs.fmr;
                                eZ.cYs = 1;
                                ad eY = eZ.eY(str2);
                                eY.cYt = System.currentTimeMillis();
                                eY.fa(at.gB(ah.getContext())).ajK();
                                final View bS = a.this.ucx.bS(a.this.context);
                                AbsoluteLayout absoluteLayout = (AbsoluteLayout) com.tencent.mm.ui.v.hu(a.this.context).inflate(R.layout.a24, null);
                                absoluteLayout.setLayoutParams(new LayoutParams(-1, -2, p.qd(widgetData2.ubt.offsetX), p.qd(widgetData2.ubt.offsetY)));
                                LayoutParams layoutParams = new LayoutParams(p.qd(widgetData2.ubt.width), p.qd(widgetData2.ubt.height), 0, 0);
                                bS.setLayoutParams(layoutParams);
                                absoluteLayout.addView(bS);
                                FrameLayout frameLayout = (FrameLayout) absoluteLayout.findViewById(R.id.c08);
                                frameLayout.setLayoutParams(layoutParams);
                                absoluteLayout.removeView(frameLayout);
                                absoluteLayout.addView(frameLayout);
                                try {
                                    bS.setBackgroundColor(Color.parseColor(widgetData2.ubt.hfo));
                                } catch (Exception e) {
                                    ab.e("FTSSearchWidgetMgr", "the color is error : ");
                                }
                                bS.setTag(str);
                                a.this.ucs.put(str2, bS);
                                a.this.uct.put(str2, absoluteLayout);
                                a.this.ucu.put(str2, frameLayout);
                                ThreeDotsLoadingView threeDotsLoadingView = (ThreeDotsLoadingView) absoluteLayout.findViewById(R.id.ue);
                                ImageView imageView = (ImageView) absoluteLayout.findViewById(R.id.a82);
                                String str2 = widgetData2.ubs.fpS + "_" + widgetData2.ubs.ubx.hashCode();
                                Bundle bundle = new Bundle();
                                if (a.this.ucB) {
                                    a.this.ucG = "com.tencent.mm:tools";
                                } else {
                                    a.this.ucG = "com.tencent.mm:support";
                                }
                                bundle.putString("exec_process_name", a.this.ucG);
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
                                bundle.putInt("view_init_width", p.qd(widgetData2.ubt.width));
                                bundle.putInt("view_init_height", p.qd(widgetData2.ubt.height));
                                bundle.putString(SearchIntents.EXTRA_QUERY, widgetData2.ubs.ubx);
                                bundle.putString("preload_launch_data", widgetData2.ubs.uby);
                                bundle.putString("preload_download_data", widgetData2.ubs.downloadUrl);
                                bundle.putInt("draw_strategy", i4);
                                bundle.putBoolean("use_predraw", ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_open_pre_draw, 0) == 1);
                                threeDotsLoadingView.setVisibility(0);
                                imageView.setVisibility(4);
                                threeDotsLoadingView.dKS();
                                dVar.csB = widgetData2.ubs.csB;
                                dVar.cBc = widgetData2.ubs.ubz;
                                dVar.gVu = widgetData2.ubs.version;
                                dVar.hlE = str2;
                                ab.i("FTSSearchWidgetMgr", "inserting widget %s", dVar.toString());
                                long currentTimeMillis = System.currentTimeMillis();
                                com.tencent.mm.plugin.report.service.h.pYm.a(867, 0, 1, false);
                                str2 = str;
                                final ThreeDotsLoadingView threeDotsLoadingView2 = threeDotsLoadingView;
                                final ImageView imageView2 = imageView;
                                final long j2 = currentTimeMillis;
                                final boolean z2 = z;
                                ac acVar = new ac(new com.tencent.mm.modelappbrand.f() {
                                    public final void F(View view, int i) {
                                        AppMethodBeat.i(91385);
                                        u.i("FTSSearchWidgetMgr", "onWidgetStateChanged sessionId %s, state %d", str2, Integer.valueOf(i));
                                        a.this.ucw = i;
                                        switch (i) {
                                            case 0:
                                                com.tencent.mm.plugin.report.service.h.pYm.a(867, 1, 1, false);
                                                if (a.this.ucz.get(str2) != null) {
                                                    if (((d) a.this.ucz.get(str2)).udi) {
                                                        threeDotsLoadingView2.setVisibility(8);
                                                    } else {
                                                        threeDotsLoadingView2.setVisibility(0);
                                                    }
                                                }
                                                imageView2.setVisibility(4);
                                                a.this.ucC.dw(str2, 1);
                                                AppMethodBeat.o(91385);
                                                return;
                                            case 1:
                                                com.tencent.mm.plugin.report.service.h.pYm.a(867, 3, 1, false);
                                                threeDotsLoadingView2.dKT();
                                                threeDotsLoadingView2.setVisibility(4);
                                                a.this.ucC.dw(str2, 3);
                                                a.cVO();
                                                u.B(widgetData2.ubs.csB, false);
                                                ((d) a.this.ucz.get(str2)).isLoading = false;
                                                AppMethodBeat.o(91385);
                                                return;
                                            case 4:
                                                long j;
                                                com.tencent.mm.plugin.report.service.h.pYm.a(867, 2, 1, false);
                                                threeDotsLoadingView2.setVisibility(4);
                                                imageView2.setVisibility(4);
                                                threeDotsLoadingView2.dKT();
                                                a.cVO();
                                                u.B(widgetData2.ubs.csB, true);
                                                ((d) a.this.ucz.get(str2)).isLoading = false;
                                                a.this.ucC.dw(str2, 2);
                                                u.i("FTSSearchWidgetMgr", "widget display timecost %d ms", Long.valueOf(System.currentTimeMillis() - j2));
                                                cp hw = new cp().hw(widgetData2.ubs.fpS);
                                                hw.dhm = System.currentTimeMillis() - j2;
                                                if (z2) {
                                                    j = 1;
                                                } else {
                                                    j = 2;
                                                }
                                                hw.cYx = j;
                                                hw.ajK();
                                                cr crVar = new cr();
                                                crVar.cTl = 4;
                                                cr hD = crVar.hD(widgetData2.ubs.fpS);
                                                hD.dhm = System.currentTimeMillis() - j2;
                                                if (z2) {
                                                    j = 1;
                                                } else {
                                                    j = 2;
                                                }
                                                hD.cYx = j;
                                                hD.dhw = (long) i4;
                                                hD.ajK();
                                                d.cVP();
                                                d.d(widgetData2);
                                                AppMethodBeat.o(91385);
                                                return;
                                            default:
                                                com.tencent.mm.plugin.report.service.h.pYm.a(867, 4, 1, false);
                                                a.cVO();
                                                u.B(widgetData2.ubs.csB, false);
                                                threeDotsLoadingView2.dKT();
                                                threeDotsLoadingView2.setVisibility(4);
                                                ((d) a.this.ucz.get(str2)).isLoading = false;
                                                if (i == 2) {
                                                    a.this.ucC.dw(str2, 4);
                                                    AppMethodBeat.o(91385);
                                                    return;
                                                }
                                                a.this.ucC.dw(str2, 3);
                                                AppMethodBeat.o(91385);
                                                return;
                                        }
                                    }
                                });
                                acVar.a(new w() {
                                    public final void abM() {
                                        AppMethodBeat.i(91386);
                                        d dVar = (d) a.this.ucz.get(str2);
                                        if (dVar != null) {
                                            dVar.udi = true;
                                            dVar.isLoading = false;
                                        }
                                        v.kT(33);
                                        AppMethodBeat.o(91386);
                                    }
                                });
                                acVar.a(new g(a.this.context));
                                acVar.a(new aj() {
                                    public final void a(int i, t tVar) {
                                        AppMethodBeat.i(91387);
                                        a.a(a.this, str2, i, tVar);
                                        AppMethodBeat.o(91387);
                                    }
                                });
                                acVar.a(new af() {
                                    public final void b(boolean z, String str, boolean z2) {
                                        AppMethodBeat.i(91388);
                                        ab.v("FTSSearchWidgetMgr", "on widget call %s ", "onSearchWAWidgetOnTapCallback");
                                        ab.i("FTSSearchWidgetMgr", "on widget call %s , hasHandler %s, eventId %s,res %s", "onSearchWAWidgetOnTapCallback", Boolean.valueOf(z), str, Boolean.valueOf(z2));
                                        if (str.equals(a.this.ucH)) {
                                            a.this.ucH = null;
                                            r c = a.this.ucC;
                                            if (!z) {
                                                z2 = false;
                                            }
                                            c.g(str, z2, str2);
                                        }
                                        AppMethodBeat.o(91388);
                                    }
                                });
                                acVar.a(new ag() {
                                    public final void abP() {
                                        AppMethodBeat.i(91389);
                                        a.a(a.this, str2, bS);
                                        AppMethodBeat.o(91389);
                                    }
                                });
                                acVar.a(new com.tencent.mm.modelappbrand.ah() {
                                    public final void pz(String str) {
                                        AppMethodBeat.i(91390);
                                        ab.v("FTSSearchWidgetMgr", "on widget call %s ", "onOpenApp");
                                        a.a(a.this, str, str2);
                                        AppMethodBeat.o(91390);
                                    }
                                });
                                acVar.a(new com.tencent.mm.modelappbrand.ad() {
                                    public final void py(String str) {
                                        AppMethodBeat.i(91380);
                                        ab.v("FTSSearchWidgetMgr", "on widget call %s ", "onMakePhoneCall");
                                        if (TextUtils.isEmpty(str)) {
                                            ab.e("FTSSearchWidgetMgr", "onMakePhone null number");
                                            AppMethodBeat.o(91380);
                                            return;
                                        }
                                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
                                        intent.addFlags(268435456);
                                        if (bo.k(a.this.context, intent)) {
                                            a.this.context.startActivity(intent);
                                        }
                                        AppMethodBeat.o(91380);
                                    }
                                });
                                acVar.a(new ai() {
                                    public final void pA(String str) {
                                        AppMethodBeat.i(91381);
                                        ab.v("FTSSearchWidgetMgr", "on widget reload data, widgetId[%s]", str);
                                        String c = a.c(a.this, str);
                                        if (bo.isNullOrNil(c)) {
                                            ab.e("FTSSearchWidgetMgr", "onWidgetReloadData widget cache key not found!");
                                            AppMethodBeat.o(91381);
                                            return;
                                        }
                                        a.this.ucC.adG(c);
                                        AppMethodBeat.o(91381);
                                    }
                                });
                                acVar.a(new ae() {
                                    public final void aq(String str, String str2) {
                                        AppMethodBeat.i(91382);
                                        ab.v("FTSSearchWidgetMgr", "on widget data push, widgetId[%s], respData[%s]", str, str2);
                                        String c = a.c(a.this, str);
                                        if (bo.isNullOrNil(c)) {
                                            ab.e("FTSSearchWidgetMgr", "onWidgetDataPush widget cache key not found!");
                                            AppMethodBeat.o(91382);
                                            return;
                                        }
                                        a.this.ucC.gS(c, str2);
                                        AppMethodBeat.o(91382);
                                    }
                                });
                                acVar.a(new aa() {
                                    public final void pw(String str) {
                                        AppMethodBeat.i(91383);
                                        d.cVP();
                                        d.b(widgetData2, str);
                                        AppMethodBeat.o(91383);
                                    }
                                });
                                acVar.a(new z() {
                                    public final void pv(String str) {
                                        AppMethodBeat.i(91384);
                                        d.cVP();
                                        d.c(widgetData2, str);
                                        AppMethodBeat.o(91384);
                                    }
                                });
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("id", str2);
                                bundle2.putString("appid", widgetData2.ubs.csB);
                                bundle2.putInt("serviceType", widgetData2.ubs.fmr);
                                bundle2.putInt("drawStrategy", i4);
                                bundle2.putString("srcAppid", widgetData2.ubs.fpS);
                                u.a(str2, widgetData2.ubs.fmr, widgetData2.ubs.csB, widgetData2.ubs.fpS, i4);
                                a.this.ucv.put(a.this.ucx.a(str, bS, bundle, acVar), str2);
                                com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", bundle2, b.class, new com.tencent.mm.ipcinvoker.c<Bundle>() {
                                    public final /* bridge */ /* synthetic */ void ao(Object obj) {
                                    }
                                });
                                com.tencent.mm.ipcinvoker.f.a(a.this.ucG, bundle2, b.class, new com.tencent.mm.ipcinvoker.c<Bundle>() {
                                    public final /* bridge */ /* synthetic */ void ao(Object obj) {
                                    }
                                });
                                com.tencent.mm.ipcinvoker.f.a(com.tencent.mm.ipcinvoker.e.PN(), bundle2, b.class, new com.tencent.mm.ipcinvoker.c<Bundle>() {
                                    public final /* bridge */ /* synthetic */ void ao(Object obj) {
                                    }
                                });
                                a.a(a.this, widgetData2, str2, str, bS, absoluteLayout, threeDotsLoadingView);
                                a.this.ucC.addView(absoluteLayout);
                                AppMethodBeat.o(91391);
                            } catch (Exception e2) {
                                ab.printErrStackTrace("FTSSearchWidgetMgr", e2, "", new Object[0]);
                                AppMethodBeat.o(91391);
                            }
                        }
                    });
                    AppMethodBeat.o(91392);
                    return;
                }
                u.i("FTSSearchWidgetMgr", "local forbidden widget %s", widgetData2.ubs.fpS);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(91379);
                        a.this.ucC.dw(str2, 3);
                        AppMethodBeat.o(91379);
                    }
                });
                AppMethodBeat.o(91392);
            }
        });
        AppMethodBeat.o(91410);
    }

    public final void m(String str, String str2, int i, int i2) {
        AppMethodBeat.i(91411);
        a(WidgetData.adQ(str), str2, i, i2);
        AppMethodBeat.o(91411);
    }

    public final void adE(String str) {
        AppMethodBeat.i(91412);
        adS(str);
        d.cVP();
        d.c(this.ucE);
        AppMethodBeat.o(91412);
    }

    private void adS(String str) {
        AppMethodBeat.i(91413);
        if (str != null && str.length() > 0) {
            WidgetData widgetData = (WidgetData) this.ucA.get(str);
            d dVar = (d) this.ucz.get(str);
            if (!(widgetData == null || dVar == null || !dVar.isLoading)) {
                ad eZ = new ad().eZ(widgetData.ubs.fpS);
                eZ.cYw = (long) widgetData.ubs.fmr;
                eZ.cYs = 24;
                ad eY = eZ.eY(str);
                eY.cYt = System.currentTimeMillis();
                eY.fa(at.gB(ah.getContext())).ajK();
            }
            View view = (View) this.ucs.get(str);
            if (view == null) {
                ab.i("FTSSearchWidgetMgr", "removeWidget cacheKey %s, can not find view", str);
                AppMethodBeat.o(91413);
                return;
            }
            ab.i("FTSSearchWidgetMgr", "removing widget sessionId %s", view.getTag().toString());
            if (this.ucx != null) {
                this.ucx.a((String) view.getTag(), view);
            }
            this.ucs.remove(str);
            this.ucu.remove(str);
            view = (View) this.uct.get(str);
            if (view != null) {
                this.ucC.removeView(view);
                this.uct.remove(str);
            }
        }
        AppMethodBeat.o(91413);
    }

    public final void gR(String str, String str2) {
        AppMethodBeat.i(91414);
        ab.i("FTSSearchWidgetMgr", "updating widget: widgetId %s, jsonData %s", str2, str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (str2 != null && str2.length() > 0) {
                View view = (View) this.ucs.get(str2);
                View view2 = (View) this.uct.get(str2);
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    if (jSONObject.has("width") || jSONObject.has("height")) {
                        a(view, (View) this.ucu.get(str2), layoutParams.height, p.qd(jSONObject.optInt("height")), layoutParams.width, p.qd(jSONObject.optInt("width")), str2);
                    }
                    if (jSONObject.has("offsetX")) {
                        layoutParams2.x = p.qd(jSONObject.optInt("offsetX"));
                    }
                    if (jSONObject.has("offsetY")) {
                        layoutParams2.y = p.qd(jSONObject.optInt("offsetY"));
                    }
                    view2.setLayoutParams(layoutParams2);
                    if (jSONObject.has("backgroundColor")) {
                        try {
                            view.setBackgroundColor(Color.parseColor(jSONObject.getString("backgroundColor")));
                        } catch (Exception e) {
                            ab.e("FTSSearchWidgetMgr", bo.l(e));
                        }
                    }
                    if (jSONObject.has("show")) {
                        if (jSONObject.has("show") ? jSONObject.optBoolean("show") : false) {
                            view.setVisibility(0);
                            view2.setVisibility(0);
                            AppMethodBeat.o(91414);
                            return;
                        }
                        view.setVisibility(8);
                        view2.setVisibility(8);
                    }
                }
            }
            AppMethodBeat.o(91414);
        } catch (Exception e2) {
            ab.e("FTSSearchWidgetMgr", "the error is e");
            AppMethodBeat.o(91414);
        }
    }

    public final void a(final WidgetData widgetData, final String str) {
        AppMethodBeat.i(91415);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(91397);
                            View view = (View) a.this.ucs.get(str);
                            View view2 = (View) a.this.uct.get(str);
                            if (view != null) {
                                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                                a.a(a.this, view, (View) a.this.ucu.get(str), layoutParams.height, p.qd(widgetData.ubt.height), layoutParams.width, p.qd(widgetData.ubt.width), str);
                                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                                if (layoutParams2 instanceof LayoutParams) {
                                    layoutParams = (LayoutParams) layoutParams2;
                                    layoutParams.x = p.qd(widgetData.ubt.offsetX);
                                    layoutParams.y = p.qd(widgetData.ubt.offsetY);
                                    view2.setLayoutParams(layoutParams);
                                } else if (layoutParams2 instanceof MarginLayoutParams) {
                                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams2;
                                    marginLayoutParams.leftMargin = p.qd(widgetData.ubt.offsetX);
                                    marginLayoutParams.topMargin = p.qd(widgetData.ubt.offsetY);
                                    view2.setLayoutParams(marginLayoutParams);
                                }
                                try {
                                    if (!TextUtils.isEmpty(widgetData.ubt.hfo)) {
                                        view.setBackgroundColor(Color.parseColor(widgetData.ubt.hfo));
                                    }
                                } catch (Exception e) {
                                    ab.e("FTSSearchWidgetMgr", bo.l(e));
                                }
                                if (widgetData.ubt.cNN) {
                                    view.setVisibility(0);
                                    view2.setVisibility(0);
                                    AppMethodBeat.o(91397);
                                    return;
                                }
                                view.setVisibility(8);
                                view2.setVisibility(8);
                            }
                            AppMethodBeat.o(91397);
                        }
                    });
                }
            } catch (Exception e) {
                ab.printErrStackTrace("FTSSearchWidgetMgr", e, "", new Object[0]);
                AppMethodBeat.o(91415);
                return;
            }
        }
        AppMethodBeat.o(91415);
    }

    public final void onResume() {
        AppMethodBeat.i(91416);
        if (this.ucx != null) {
            for (String str : this.ucs.keySet()) {
                if (str != null && str.length() > 0) {
                    ((com.tencent.mm.modelappbrand.e) g.K(com.tencent.mm.modelappbrand.e.class)).aby().pl((String) ((View) this.ucs.get(str)).getTag());
                }
            }
        }
        AppMethodBeat.o(91416);
    }

    public final void onPause() {
        AppMethodBeat.i(91417);
        if (this.ucx != null) {
            for (String str : this.ucs.keySet()) {
                if (str != null && str.length() > 0) {
                    ((com.tencent.mm.modelappbrand.e) g.K(com.tencent.mm.modelappbrand.e.class)).aby().pk((String) ((View) this.ucs.get(str)).getTag());
                }
            }
        }
        AppMethodBeat.o(91417);
    }

    public final void onDestroy() {
        AppMethodBeat.i(91418);
        try {
            final String str = "";
            File[] listFiles = new File(com.tencent.mm.loader.j.b.eSk.replace("/data/user/0", "/data/data") + "/fts_cache").listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    AppMethodBeat.i(91394);
                    if (file.getAbsolutePath().equals(str)) {
                        AppMethodBeat.o(91394);
                        return false;
                    }
                    AppMethodBeat.o(91394);
                    return true;
                }
            });
            if (listFiles != null) {
                for (File absoluteFile : listFiles) {
                    u.i("FTSSearchWidgetMgr", "deleting %s", absoluteFile.getAbsoluteFile());
                    absoluteFile.delete();
                }
            }
            if (this.ucx != null) {
                ab.i("FTSSearchWidgetMgr", "remove all widget count %d", Integer.valueOf(this.ucs.size()));
                for (String str2 : new HashMap(this.ucs).keySet()) {
                    if (str2 != null && str2.length() > 0) {
                        this.ucx.pm((String) ((View) this.ucs.get(str2)).getTag());
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
            AppMethodBeat.o(91418);
        } catch (Exception e) {
            ab.e("FTSSearchWidgetMgr", bo.l(e));
            AppMethodBeat.o(91418);
        }
    }

    public final void f(int i, int i2, String str, String str2) {
        AppMethodBeat.i(91419);
        u.v("FTSSearchWidgetMgr", "tapSearchWAWidgetView x %d, y %d, widgetId %s, eventId %s", Integer.valueOf(i), Integer.valueOf(i2), str, str2);
        View view = (View) this.ucs.get(str);
        if (view != null) {
            final com.tencent.mm.modelappbrand.n ch = this.ucx.ch(view);
            final int i3 = i;
            final int i4 = i2;
            final String str3 = str2;
            final String str4 = str;
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    boolean z;
                    AppMethodBeat.i(91399);
                    com.tencent.mm.plugin.websearch.widget.c.b bVar = new com.tencent.mm.plugin.websearch.widget.c.b(i3, i4, str3);
                    com.tencent.mm.modelappbrand.n nVar = ch;
                    if (nVar == null) {
                        ab.e("BaseJsapiEvent", "null JSBridgeAccessible ");
                        z = false;
                    } else {
                        z = nVar.ap(bVar.getName(), bVar.cVS());
                    }
                    if (z) {
                        a.this.ucH = str3;
                        com.tencent.mm.ce.a.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(91398);
                                if (str3.equals(a.this.ucH)) {
                                    ab.i("FTSSearchWidgetMgr", "tap event timeout id %s", str3);
                                    a.this.ucH = null;
                                    a.this.ucC.a(str3, false, "timeout", str4);
                                }
                                AppMethodBeat.o(91398);
                            }
                        }, 1000);
                        AppMethodBeat.o(91399);
                        return;
                    }
                    ab.i("FTSSearchWidgetMgr", "onTap fail: execute js event %s ", str4);
                    a.this.ucC.a(str3, false, "onTap fail: execute js event  " + str4, str4);
                    AppMethodBeat.o(91399);
                }
            }, "tapSearchWAWidgetView");
            AppMethodBeat.o(91419);
            return;
        }
        ab.i("FTSSearchWidgetMgr", "onTap fail: can not find Widget by widgetId %s", str);
        this.ucC.a(str2, false, "onTap fail: can not find Widget by widgetId ".concat(String.valueOf(str)), str);
        AppMethodBeat.o(91419);
    }

    public final void cUS() {
        this.ucB = false;
    }

    private void a(View view, View view2, int i, int i2, int i3, int i4, String str) {
        AppMethodBeat.i(91420);
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        final View view3 = view;
        final View view4 = view2;
        final String str2 = str;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(91402);
                ab.i("FTSSearchWidgetMgr", "animating  size beginH %d, endH %d, beginW %d, endW %d", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
                if (i5 == i6 && i7 == i8) {
                    AppMethodBeat.o(91402);
                    return;
                }
                final ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
                final ViewGroup.LayoutParams layoutParams2 = view4.getLayoutParams();
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i5, i6});
                ofInt.setDuration(300);
                ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
                ofInt.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(91400);
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        layoutParams.height = intValue;
                        view3.setLayoutParams(layoutParams);
                        layoutParams2.height = intValue;
                        view4.setLayoutParams(layoutParams2);
                        AppMethodBeat.o(91400);
                    }
                });
                ofInt.addListener(new AnimatorListener() {
                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(91401);
                        a.a(a.this, str2, view3);
                        AppMethodBeat.o(91401);
                    }

                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
                ofInt.start();
                AppMethodBeat.o(91402);
            }
        });
        AppMethodBeat.o(91420);
    }

    static /* synthetic */ String c(a aVar, String str) {
        AppMethodBeat.i(91425);
        String str2 = (String) aVar.ucv.get(str);
        AppMethodBeat.o(91425);
        return str2;
    }
}
