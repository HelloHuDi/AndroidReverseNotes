package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.s;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.f.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public final class g extends n {
    private String hZt;
    private ViewGroup hkC;
    private com.tencent.mm.plugin.appbrand.widget.i.a iri;
    private FrameLayout irj;
    private u irk = getContainer().getPageViewPrivate();
    private Map<String, u> irl = new HashMap();
    private Map<Integer, AppBrandPageFullScreenView> irm = new HashMap();
    private boolean irn = false;
    private final Runnable iro = new Runnable() {
        public final void run() {
            AppMethodBeat.i(87037);
            g.a(g.this);
            AppMethodBeat.o(87037);
        }
    };
    private LinkedList<b> irp = new LinkedList();

    static abstract class b implements Runnable {
        private boolean irt;
        boolean xH;

        public abstract void aJi();

        private b() {
            this.irt = false;
            this.xH = false;
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public void run() {
            boolean z;
            if (this.irt || this.xH) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.irt = true;
                aJi();
            }
        }
    }

    public static final class a extends p {
        private static final int CTRL_INDEX = 390;
        private static final String NAME = "onTabItemTap";
    }

    public g(Context context, q qVar) {
        super(context, qVar);
        AppMethodBeat.i(87042);
        AppMethodBeat.o(87042);
    }

    /* Access modifiers changed, original: protected|final */
    public final View aAQ() {
        AppMethodBeat.i(87043);
        if (this.hkC == null) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            this.irj = new FrameLayout(getContext());
            this.iri = aJf();
            if (getContainer().getAppConfig().heV.hfq) {
                this.iri.setVisibility(8);
            }
            LayoutParams layoutParams;
            if ("top".equals(getContainer().getAppConfig().heV.hfm)) {
                layoutParams = new LayoutParams(-1, -1);
                layoutParams.addRule(10);
                relativeLayout.addView(this.irj, layoutParams);
                layoutParams = new LayoutParams(-1, -2);
                layoutParams.addRule(10);
                relativeLayout.addView(this.iri, layoutParams);
            } else {
                layoutParams = new LayoutParams(-1, -2);
                layoutParams.addRule(12);
                relativeLayout.addView(this.iri, layoutParams);
                layoutParams = new LayoutParams(-1, -1);
                layoutParams.addRule(2, this.iri.getId());
                relativeLayout.addView(this.irj, layoutParams);
            }
            this.hkC = relativeLayout;
        }
        ViewGroup viewGroup = this.hkC;
        AppMethodBeat.o(87043);
        return viewGroup;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.i(87044);
        super.onMeasure(i, i2);
        aJe();
        AppMethodBeat.o(87044);
    }

    public final void onDescendantInvalidated(View view, View view2) {
        AppMethodBeat.i(87045);
        super.onDescendantInvalidated(view, view2);
        if (view2 instanceof d) {
            aJe();
        }
        AppMethodBeat.o(87045);
    }

    private void aJe() {
        AppMethodBeat.i(87046);
        post(this.iro);
        AppMethodBeat.o(87046);
    }

    private com.tencent.mm.plugin.appbrand.widget.i.a aJf() {
        AppMethodBeat.i(87047);
        com.tencent.mm.plugin.appbrand.widget.i.a aVar = (com.tencent.mm.plugin.appbrand.widget.i.a) getContainer().getDecorWidgetFactory().b(getContext(), com.tencent.mm.plugin.appbrand.widget.i.a.class);
        aVar.setId(R.id.w);
        final f fVar = getContainer().getAppConfig().heV;
        aVar.setPosition(fVar.hfm);
        aVar.g(fVar.color, fVar.hfn, fVar.hfo, fVar.hfp);
        Iterator it = fVar.cHb.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.appbrand.config.a.g gVar = (com.tencent.mm.plugin.appbrand.config.a.g) it.next();
            aVar.h(gVar.url, gVar.text, gVar.cIY, gVar.hfr);
        }
        aVar.setClickListener(new com.tencent.mm.plugin.appbrand.widget.i.a.b() {
            public final void Z(int i, String str) {
                AppMethodBeat.i(87039);
                g.this.getContainer().Db(str);
                HashMap hashMap = new HashMap();
                hashMap.put("pagePath", str);
                hashMap.put("text", ((com.tencent.mm.plugin.appbrand.config.a.g) fVar.cHb.get(i)).text);
                hashMap.put(com.google.firebase.analytics.FirebaseAnalytics.b.INDEX, Integer.valueOf(i));
                g.this.getCurrentPageView().b(new a().t(hashMap));
                AppMethodBeat.o(87039);
            }
        });
        AppMethodBeat.o(87047);
        return aVar;
    }

    public final com.tencent.mm.plugin.appbrand.widget.i.a getTabBar() {
        return this.iri;
    }

    public final void loadUrl(final String str) {
        AppMethodBeat.i(87048);
        if (str.equals(this.hZt)) {
            AppMethodBeat.o(87048);
            return;
        }
        int EV = this.iri.EV(str);
        if (EV < 0) {
            AppMethodBeat.o(87048);
            return;
        }
        this.hZt = str;
        this.iri.re(EV);
        if (this.irl.get(h.bO(str)) == null) {
            final u CX = CX(h.bO(str));
            final AnonymousClass4 anonymousClass4 = new b() {
                public final void aJi() {
                    AppMethodBeat.i(87040);
                    g.a(g.this, str);
                    g.this.getContainer().aJp();
                    AppMethodBeat.o(87040);
                }
            };
            final long currentTimeMillis = System.currentTimeMillis();
            CX.a((e) new e() {
                public final void onReady() {
                    AppMethodBeat.i(87041);
                    CX.b((e) this);
                    anonymousClass4.run();
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    ab.i("MicroMsg.AppBrandMultiplePage", "Tab page onReady received, time: %d", Long.valueOf(currentTimeMillis));
                    AppMethodBeat.o(87041);
                }
            });
            if (this.irl.size() > 1) {
                this.irp.add(anonymousClass4);
                postDelayed(anonymousClass4, 500);
            }
            this.irn = true;
            CX.AA(str);
            AppMethodBeat.o(87048);
            return;
        }
        aJh();
        CY(str);
        AppMethodBeat.o(87048);
    }

    private synchronized u CX(String str) {
        u uVar;
        AppMethodBeat.i(87049);
        if (this.irk != null) {
            uVar = this.irk;
            this.irk = null;
        } else {
            uVar = getContainer().getPageViewPrivate();
        }
        uVar.k((n) this);
        this.irl.put(str, uVar);
        this.irj.addView(uVar.getContentView(), 0);
        AppMethodBeat.o(87049);
        return uVar;
    }

    private void CY(String str) {
        AppMethodBeat.i(87050);
        this.irn = false;
        u uVar = (u) this.irl.get(h.bO(str));
        uVar.getContentView().setVisibility(4);
        u uVar2 = null;
        for (u uVar3 : this.irl.values()) {
            u uVar32;
            if (uVar32.getContentView().getVisibility() != 0) {
                uVar32 = uVar2;
            }
            uVar2 = uVar32;
        }
        uVar.getContentView().setVisibility(0);
        if (uVar2 != null) {
            uVar2.getContentView().setVisibility(4);
        }
        if (uVar2 != null) {
            uVar2.wW();
        }
        uVar.wU();
        aJg();
        AppMethodBeat.o(87050);
    }

    private void aJg() {
        AppMethodBeat.i(87051);
        if (this.irm.size() <= 0) {
            AppMethodBeat.o(87051);
            return;
        }
        for (ViewGroup visibility : this.irm.values()) {
            visibility.setVisibility(4);
        }
        AppBrandPageFullScreenView appBrandPageFullScreenView = (AppBrandPageFullScreenView) this.irm.get(Integer.valueOf(getCurrentPageView().hashCode()));
        if (appBrandPageFullScreenView != null) {
            appBrandPageFullScreenView.setVisibility(0);
        }
        AppMethodBeat.o(87051);
    }

    private void aJh() {
        AppMethodBeat.i(87052);
        Iterator it = this.irp.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            removeCallbacks(bVar);
            bVar.xH = true;
        }
        this.irp.clear();
        AppMethodBeat.o(87052);
    }

    public final boolean Ay(String str) {
        AppMethodBeat.i(87053);
        if (this.iri.EV(str) != -1) {
            AppMethodBeat.o(87053);
            return true;
        }
        AppMethodBeat.o(87053);
        return false;
    }

    public final void aAS() {
        AppMethodBeat.i(87054);
        super.aAS();
        getCurrentPageView().wU();
        AppMethodBeat.o(87054);
    }

    public final void aAT() {
        AppMethodBeat.i(87055);
        super.aAT();
        getCurrentPageView().wW();
        AppMethodBeat.o(87055);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aAR() {
        AppMethodBeat.i(87056);
        super.aAR();
        if (this.irk != null) {
            this.irk.onDestroy();
        }
        for (u onDestroy : this.irl.values()) {
            onDestroy.onDestroy();
        }
        AppMethodBeat.o(87056);
    }

    public final void b(String str, String str2, int[] iArr) {
        AppMethodBeat.i(87057);
        if (this.irk != null && n.f(iArr, this.irk.hashCode())) {
            this.irk.h(str, str2, 0);
        }
        for (u uVar : this.irl.values()) {
            if (n.f(iArr, uVar.hashCode())) {
                uVar.h(str, str2, 0);
            }
        }
        AppMethodBeat.o(87057);
    }

    public final void cleanup() {
        AppMethodBeat.i(87058);
        super.cleanup();
        if (this.irk != null) {
            this.irk.cleanup();
        }
        for (u cleanup : this.irl.values()) {
            cleanup.cleanup();
        }
        aJh();
        AppMethodBeat.o(87058);
    }

    public final synchronized u getCurrentPageView() {
        u uVar;
        AppMethodBeat.i(87059);
        if (this.irk != null) {
            uVar = this.irk;
            AppMethodBeat.o(87059);
        } else {
            uVar = (u) this.irl.get(h.bO(this.hZt));
            AppMethodBeat.o(87059);
        }
        return uVar;
    }

    public final String getCurrentUrl() {
        return this.hZt;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(u uVar, AppBrandPageFullScreenView appBrandPageFullScreenView) {
        AppMethodBeat.i(138230);
        if (uVar == null) {
            ab.e("MicroMsg.AppBrandMultiplePage", "getCurrentFullScreenView err, pageView is null");
            AppMethodBeat.o(138230);
            return;
        }
        if (appBrandPageFullScreenView != null && appBrandPageFullScreenView.getParent() == null && (this.hkC instanceof ViewGroup)) {
            this.hkC.addView(appBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
            this.irm.put(Integer.valueOf(uVar.hashCode()), appBrandPageFullScreenView);
        }
        AppMethodBeat.o(138230);
    }

    static /* synthetic */ void a(g gVar) {
        AppMethodBeat.i(87061);
        if (gVar.getCurrentPageView() != null && !gVar.irn && "top".equals(gVar.iri.getPosition()) && (gVar.iri.getLayoutParams() instanceof MarginLayoutParams)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) gVar.iri.getLayoutParams();
            com.tencent.mm.plugin.appbrand.widget.actionbar.b actionBar = gVar.getCurrentPageView().getActionBar();
            int measuredHeight = actionBar.getMeasuredHeight() + actionBar.getTop();
            if (marginLayoutParams.topMargin != measuredHeight) {
                marginLayoutParams.topMargin = measuredHeight;
                gVar.iri.setLayoutParams(marginLayoutParams);
                gVar.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(87038);
                        if (s.av(g.this) && (g.this.iri.getLayoutParams() instanceof MarginLayoutParams) && ((MarginLayoutParams) g.this.iri.getLayoutParams()).topMargin != g.this.iri.getTop()) {
                            g.this.iri.requestLayout();
                        }
                        AppMethodBeat.o(87038);
                    }
                });
            }
            gVar.getCurrentPageView().pr(gVar.iri.getMeasuredHeight());
        }
        AppMethodBeat.o(87061);
    }
}
