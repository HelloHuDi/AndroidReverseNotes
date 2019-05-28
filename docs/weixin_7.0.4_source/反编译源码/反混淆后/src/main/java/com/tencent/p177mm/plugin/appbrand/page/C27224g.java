package com.tencent.p177mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.p057v4.view.C0477s;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.C38163a.C38164g;
import com.tencent.p177mm.plugin.appbrand.config.C38163a.C38166f;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C45595e;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C10933b;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C38570d;
import com.tencent.p177mm.plugin.appbrand.widget.p340i.C10989a;
import com.tencent.p177mm.plugin.appbrand.widget.p340i.C10989a.C10988b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.page.g */
public final class C27224g extends C19640n {
    private String hZt;
    private ViewGroup hkC;
    private C10989a iri;
    private FrameLayout irj;
    private C44709u irk = getContainer().getPageViewPrivate();
    private Map<String, C44709u> irl = new HashMap();
    private Map<Integer, AppBrandPageFullScreenView> irm = new HashMap();
    private boolean irn = false;
    private final Runnable iro = new C24141();
    private LinkedList<C27226b> irp = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.appbrand.page.g$1 */
    class C24141 implements Runnable {
        C24141() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87037);
            C27224g.m43248a(C27224g.this);
            AppMethodBeat.m2505o(87037);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.g$2 */
    class C24152 implements Runnable {
        C24152() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87038);
            if (C0477s.m930av(C27224g.this) && (C27224g.this.iri.getLayoutParams() instanceof MarginLayoutParams) && ((MarginLayoutParams) C27224g.this.iri.getLayoutParams()).topMargin != C27224g.this.iri.getTop()) {
                C27224g.this.iri.requestLayout();
            }
            AppMethodBeat.m2505o(87038);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.g$b */
    static abstract class C27226b implements Runnable {
        private boolean irt;
        /* renamed from: xH */
        boolean f13677xH;

        public abstract void aJi();

        private C27226b() {
            this.irt = false;
            this.f13677xH = false;
        }

        /* synthetic */ C27226b(byte b) {
            this();
        }

        public void run() {
            boolean z;
            if (this.irt || this.f13677xH) {
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

    /* renamed from: com.tencent.mm.plugin.appbrand.page.g$a */
    public static final class C27227a extends C38369p {
        private static final int CTRL_INDEX = 390;
        private static final String NAME = "onTabItemTap";
    }

    public C27224g(Context context, C38470q c38470q) {
        super(context, c38470q);
        AppMethodBeat.m2504i(87042);
        AppMethodBeat.m2505o(87042);
    }

    /* Access modifiers changed, original: protected|final */
    public final View aAQ() {
        AppMethodBeat.m2504i(87043);
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
        AppMethodBeat.m2505o(87043);
        return viewGroup;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(87044);
        super.onMeasure(i, i2);
        aJe();
        AppMethodBeat.m2505o(87044);
    }

    public final void onDescendantInvalidated(View view, View view2) {
        AppMethodBeat.m2504i(87045);
        super.onDescendantInvalidated(view, view2);
        if (view2 instanceof C38570d) {
            aJe();
        }
        AppMethodBeat.m2505o(87045);
    }

    private void aJe() {
        AppMethodBeat.m2504i(87046);
        post(this.iro);
        AppMethodBeat.m2505o(87046);
    }

    private C10989a aJf() {
        AppMethodBeat.m2504i(87047);
        C10989a c10989a = (C10989a) getContainer().getDecorWidgetFactory().mo6322b(getContext(), C10989a.class);
        c10989a.setId(2131820566);
        final C38166f c38166f = getContainer().getAppConfig().heV;
        c10989a.setPosition(c38166f.hfm);
        c10989a.mo22646g(c38166f.color, c38166f.hfn, c38166f.hfo, c38166f.hfp);
        Iterator it = c38166f.cHb.iterator();
        while (it.hasNext()) {
            C38164g c38164g = (C38164g) it.next();
            c10989a.mo22648h(c38164g.url, c38164g.text, c38164g.cIY, c38164g.hfr);
        }
        c10989a.setClickListener(new C10988b() {
            /* renamed from: Z */
            public final void mo22637Z(int i, String str) {
                AppMethodBeat.m2504i(87039);
                C27224g.this.getContainer().mo61156Db(str);
                HashMap hashMap = new HashMap();
                hashMap.put("pagePath", str);
                hashMap.put("text", ((C38164g) c38166f.cHb.get(i)).text);
                hashMap.put(C8741b.INDEX, Integer.valueOf(i));
                C27224g.this.getCurrentPageView().mo6115b(new C27227a().mo34958t(hashMap));
                AppMethodBeat.m2505o(87039);
            }
        });
        AppMethodBeat.m2505o(87047);
        return c10989a;
    }

    public final C10989a getTabBar() {
        return this.iri;
    }

    public final void loadUrl(final String str) {
        AppMethodBeat.m2504i(87048);
        if (str.equals(this.hZt)) {
            AppMethodBeat.m2505o(87048);
            return;
        }
        int EV = this.iri.mo22638EV(str);
        if (EV < 0) {
            AppMethodBeat.m2505o(87048);
            return;
        }
        this.hZt = str;
        this.iri.mo22649re(EV);
        if (this.irl.get(C8874h.m15847bO(str)) == null) {
            final C44709u CX = m43246CX(C8874h.m15847bO(str));
            final C196384 c196384 = new C27226b() {
                public final void aJi() {
                    AppMethodBeat.m2504i(87040);
                    C27224g.m43249a(C27224g.this, str);
                    C27224g.this.getContainer().aJp();
                    AppMethodBeat.m2505o(87040);
                }
            };
            final long currentTimeMillis = System.currentTimeMillis();
            CX.mo68074a((C45595e) new C45595e() {
                public final void onReady() {
                    AppMethodBeat.m2504i(87041);
                    CX.mo68075b((C45595e) this);
                    c196384.run();
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    C4990ab.m7417i("MicroMsg.AppBrandMultiplePage", "Tab page onReady received, time: %d", Long.valueOf(currentTimeMillis));
                    AppMethodBeat.m2505o(87041);
                }
            });
            if (this.irl.size() > 1) {
                this.irp.add(c196384);
                postDelayed(c196384, 500);
            }
            this.irn = true;
            CX.mo44893AA(str);
            AppMethodBeat.m2505o(87048);
            return;
        }
        aJh();
        m43247CY(str);
        AppMethodBeat.m2505o(87048);
    }

    /* renamed from: CX */
    private synchronized C44709u m43246CX(String str) {
        C44709u c44709u;
        AppMethodBeat.m2504i(87049);
        if (this.irk != null) {
            c44709u = this.irk;
            this.irk = null;
        } else {
            c44709u = getContainer().getPageViewPrivate();
        }
        c44709u.mo71765k((C19640n) this);
        this.irl.put(str, c44709u);
        this.irj.addView(c44709u.getContentView(), 0);
        AppMethodBeat.m2505o(87049);
        return c44709u;
    }

    /* renamed from: CY */
    private void m43247CY(String str) {
        AppMethodBeat.m2504i(87050);
        this.irn = false;
        C44709u c44709u = (C44709u) this.irl.get(C8874h.m15847bO(str));
        c44709u.getContentView().setVisibility(4);
        C44709u c44709u2 = null;
        for (C44709u c44709u3 : this.irl.values()) {
            C44709u c44709u32;
            if (c44709u32.getContentView().getVisibility() != 0) {
                c44709u32 = c44709u2;
            }
            c44709u2 = c44709u32;
        }
        c44709u.getContentView().setVisibility(0);
        if (c44709u2 != null) {
            c44709u2.getContentView().setVisibility(4);
        }
        if (c44709u2 != null) {
            c44709u2.mo71773wW();
        }
        c44709u.mo71772wU();
        aJg();
        AppMethodBeat.m2505o(87050);
    }

    private void aJg() {
        AppMethodBeat.m2504i(87051);
        if (this.irm.size() <= 0) {
            AppMethodBeat.m2505o(87051);
            return;
        }
        for (ViewGroup visibility : this.irm.values()) {
            visibility.setVisibility(4);
        }
        AppBrandPageFullScreenView appBrandPageFullScreenView = (AppBrandPageFullScreenView) this.irm.get(Integer.valueOf(getCurrentPageView().hashCode()));
        if (appBrandPageFullScreenView != null) {
            appBrandPageFullScreenView.setVisibility(0);
        }
        AppMethodBeat.m2505o(87051);
    }

    private void aJh() {
        AppMethodBeat.m2504i(87052);
        Iterator it = this.irp.iterator();
        while (it.hasNext()) {
            C27226b c27226b = (C27226b) it.next();
            removeCallbacks(c27226b);
            c27226b.f13677xH = true;
        }
        this.irp.clear();
        AppMethodBeat.m2505o(87052);
    }

    /* renamed from: Ay */
    public final boolean mo21657Ay(String str) {
        AppMethodBeat.m2504i(87053);
        if (this.iri.mo22638EV(str) != -1) {
            AppMethodBeat.m2505o(87053);
            return true;
        }
        AppMethodBeat.m2505o(87053);
        return false;
    }

    public final void aAS() {
        AppMethodBeat.m2504i(87054);
        super.aAS();
        getCurrentPageView().mo71772wU();
        AppMethodBeat.m2505o(87054);
    }

    public final void aAT() {
        AppMethodBeat.m2504i(87055);
        super.aAT();
        getCurrentPageView().mo71773wW();
        AppMethodBeat.m2505o(87055);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aAR() {
        AppMethodBeat.m2504i(87056);
        super.aAR();
        if (this.irk != null) {
            this.irk.onDestroy();
        }
        for (C44709u onDestroy : this.irl.values()) {
            onDestroy.onDestroy();
        }
        AppMethodBeat.m2505o(87056);
    }

    /* renamed from: b */
    public final void mo21662b(String str, String str2, int[] iArr) {
        AppMethodBeat.m2504i(87057);
        if (this.irk != null && C19640n.m30441f(iArr, this.irk.hashCode())) {
            this.irk.mo51255h(str, str2, 0);
        }
        for (C44709u c44709u : this.irl.values()) {
            if (C19640n.m30441f(iArr, c44709u.hashCode())) {
                c44709u.mo51255h(str, str2, 0);
            }
        }
        AppMethodBeat.m2505o(87057);
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(87058);
        super.cleanup();
        if (this.irk != null) {
            this.irk.cleanup();
        }
        for (C44709u cleanup : this.irl.values()) {
            cleanup.cleanup();
        }
        aJh();
        AppMethodBeat.m2505o(87058);
    }

    public final synchronized C44709u getCurrentPageView() {
        C44709u c44709u;
        AppMethodBeat.m2504i(87059);
        if (this.irk != null) {
            c44709u = this.irk;
            AppMethodBeat.m2505o(87059);
        } else {
            c44709u = (C44709u) this.irl.get(C8874h.m15847bO(this.hZt));
            AppMethodBeat.m2505o(87059);
        }
        return c44709u;
    }

    public final String getCurrentUrl() {
        return this.hZt;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo34866a(C44709u c44709u, AppBrandPageFullScreenView appBrandPageFullScreenView) {
        AppMethodBeat.m2504i(138230);
        if (c44709u == null) {
            C4990ab.m7412e("MicroMsg.AppBrandMultiplePage", "getCurrentFullScreenView err, pageView is null");
            AppMethodBeat.m2505o(138230);
            return;
        }
        if (appBrandPageFullScreenView != null && appBrandPageFullScreenView.getParent() == null && (this.hkC instanceof ViewGroup)) {
            this.hkC.addView(appBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
            this.irm.put(Integer.valueOf(c44709u.hashCode()), appBrandPageFullScreenView);
        }
        AppMethodBeat.m2505o(138230);
    }

    /* renamed from: a */
    static /* synthetic */ void m43248a(C27224g c27224g) {
        AppMethodBeat.m2504i(87061);
        if (c27224g.getCurrentPageView() != null && !c27224g.irn && "top".equals(c27224g.iri.getPosition()) && (c27224g.iri.getLayoutParams() instanceof MarginLayoutParams)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) c27224g.iri.getLayoutParams();
            C10933b actionBar = c27224g.getCurrentPageView().getActionBar();
            int measuredHeight = actionBar.getMeasuredHeight() + actionBar.getTop();
            if (marginLayoutParams.topMargin != measuredHeight) {
                marginLayoutParams.topMargin = measuredHeight;
                c27224g.iri.setLayoutParams(marginLayoutParams);
                c27224g.post(new C24152());
            }
            c27224g.getCurrentPageView().mo71768pr(c27224g.iri.getMeasuredHeight());
        }
        AppMethodBeat.m2505o(87061);
    }
}
