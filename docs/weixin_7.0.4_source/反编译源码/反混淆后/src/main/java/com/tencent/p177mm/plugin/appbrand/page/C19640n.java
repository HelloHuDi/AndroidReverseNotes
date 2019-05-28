package com.tencent.p177mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.luggage.p147g.C8873f;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.C38163a.C33131d;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;
import p1358me.imid.swipebacklayout.lib.SwipeBackLayout;
import p1358me.imid.swipebacklayout.lib.SwipeBackLayout.C24597a;

/* renamed from: com.tencent.mm.plugin.appbrand.page.n */
public abstract class C19640n extends SwipeBackLayout {
    /* renamed from: WL */
    private View f4355WL;
    private C38470q gND;
    private final C24597a irA = new C196411();
    private boolean irv = true;
    private boolean irw = false;
    private int irx;
    private int iry;
    final boolean[] irz = new boolean[]{false};
    public boolean mSwiping = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.page.n$1 */
    class C196411 implements C24597a {
        C196411() {
        }

        /* renamed from: h */
        public final void mo3956h(int i, float f) {
            AppMethodBeat.m2504i(87069);
            if (i != 0) {
                C19640n.this.mSwiping = true;
            } else {
                C19640n.this.mSwiping = false;
            }
            C19640n e = C19640n.this.gND.mo61165e(C19640n.this);
            if (Float.compare(1.0f, f) <= 0) {
                if (!C19640n.this.irz[0]) {
                    if (e != null) {
                        C19640n.m30442l(e.getContentView(), 0.0f);
                    }
                    e = C19640n.this;
                    e.mSwiping = true;
                    e.post(new C196422());
                    C19640n.this.irz[0] = true;
                }
            } else if (e != null) {
                e.onSwipe(f);
            }
            C4990ab.m7417i("MicroMsg.AppBrandPage", "scrollPercent %f", Float.valueOf(f));
            AppMethodBeat.m2505o(87069);
        }

        /* renamed from: xv */
        public final void mo3958xv() {
        }

        /* renamed from: l */
        public final void mo3957l(MotionEvent motionEvent) {
        }

        /* renamed from: ba */
        public final boolean mo3955ba(boolean z) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.n$2 */
    class C196422 implements Runnable {
        C196422() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87070);
            C19640n.this.gND.mo61164c(C19640n.this);
            AppMethodBeat.m2505o(87070);
        }
    }

    /* renamed from: Ay */
    public abstract boolean mo21657Ay(String str);

    public abstract View aAQ();

    /* renamed from: b */
    public abstract void mo21662b(String str, String str2, int[] iArr);

    public abstract C44709u getCurrentPageView();

    public abstract String getCurrentUrl();

    public abstract void loadUrl(String str);

    public C19640n(Context context, C38470q c38470q) {
        super(context);
        this.gND = c38470q;
        setLayoutParams(new LayoutParams(-1, -1));
        setScrimColor(0);
        this.f4355WL = aAQ();
        addView(getContentView());
        setContentView(getContentView());
        mo65734a(this.irA);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo34866a(C44709u c44709u, AppBrandPageFullScreenView appBrandPageFullScreenView) {
        if (appBrandPageFullScreenView != null && appBrandPageFullScreenView.getParent() == null && (this.f4355WL instanceof ViewGroup)) {
            ((ViewGroup) this.f4355WL).addView(appBrandPageFullScreenView, new LayoutParams(-1, -1));
        }
    }

    /* Access modifiers changed, original: final */
    public final void aJj() {
        if (this.irv) {
            this.irv = false;
            this.irw = false;
            aAS();
        }
    }

    /* Access modifiers changed, original: final */
    public final void aJk() {
        if (!this.irv) {
            this.irv = true;
            aAT();
        }
    }

    /* Access modifiers changed, original: final */
    public final void performDestroy() {
        aAR();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: xN */
    public final void mo34878xN() {
        cleanup();
    }

    /* Access modifiers changed, original: protected */
    public void cleanup() {
    }

    /* Access modifiers changed, original: protected */
    public void aAS() {
        C4990ab.m7411d("MicroMsg.AppBrandPage", "onPageForeground: %s", getCurrentUrl());
        if (getPageConfig().hfB) {
            setEnableGesture(false);
        } else {
            setEnableGesture(this.gND.aAV());
        }
        setEdgeTrackingEnabled(1);
        onSwipe(1.0f);
        setVisibility(0);
    }

    /* Access modifiers changed, original: protected */
    public void aAT() {
        C4990ab.m7411d("MicroMsg.AppBrandPage", "onPageBackground: %s", getCurrentUrl());
    }

    /* Access modifiers changed, original: protected */
    public void aAR() {
        C4990ab.m7411d("MicroMsg.AppBrandPage", "onPageDestroy: %s", getCurrentUrl());
    }

    private void hide() {
        if (this.irv) {
            setVisibility(4);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean isInBackground() {
        return this.irv;
    }

    private View getContentView() {
        return this.f4355WL;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        if (this.irv) {
            this.irw = true;
        }
        C44709u currentPageView = getCurrentPageView();
        if (currentPageView != null) {
            currentPageView.onConfigurationChanged(configuration);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        Object obj = (!this.irv || this.irw || this.irx <= 0 || this.iry <= 0) ? null : 1;
        if (obj != null) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(this.irx, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec(this.iry, ErrorDialogData.SUPPRESSED));
            return;
        }
        super.onMeasure(i, i2);
        this.irx = getMeasuredWidth();
        this.iry = getMeasuredHeight();
    }

    public String getAppId() {
        return this.gND.getAppId();
    }

    /* Access modifiers changed, original: protected */
    public C38470q getContainer() {
        return this.gND;
    }

    public C33131d getPageConfig() {
        return getCurrentPageView().getPageConfig();
    }

    /* renamed from: a */
    private void m30437a(String str, C2412aq c2412aq) {
        HashMap hashMap = new HashMap();
        hashMap.put("path", C8874h.m15847bO(getCurrentUrl()));
        hashMap.put(SearchIntents.EXTRA_QUERY, C8874h.m15848bP(getCurrentUrl()));
        hashMap.put("rawPath", getCurrentUrl());
        if (c2412aq != null) {
            hashMap.put("openType", c2412aq.toString());
        }
        if ("onAppRoute".equals(str)) {
            hashMap.put("resizing", Boolean.valueOf(getCurrentPageView().aJK()));
        }
        C42677e.m75584d(hashMap);
        getCurrentPageView().mo6109a(str, new JSONObject(hashMap).toString(), null);
    }

    /* renamed from: a */
    public final void mo34865a(C2412aq c2412aq) {
        m30437a("onAppRoute", c2412aq);
        C4990ab.m7417i("MicroMsg.AppBrandPage", "onAppRoute: %s, %s", c2412aq.toString(), getCurrentUrl());
    }

    public final void aJl() {
        m30437a("onAppRouteDone", null);
        C4990ab.m7417i("MicroMsg.AppBrandPage", "onAppRouteDone: %s", getCurrentUrl());
    }

    /* renamed from: f */
    protected static boolean m30441f(int[] iArr, int i) {
        if (iArr == null || iArr.length == 0) {
            return true;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqX() {
        C8873f.m15846az(getContext());
    }

    /* renamed from: l */
    private static void m30442l(View view, float f) {
        view.clearAnimation();
        view.setTranslationX(f);
    }

    private void onSwipe(float f) {
        if (this.irv) {
            if (f >= 0.0f) {
                setVisibility(0);
            } else {
                hide();
            }
        }
        C19640n.m30442l(getContentView(), (((float) (getContentView().getWidth() / 4)) * (1.0f - f)) * -1.0f);
    }
}
