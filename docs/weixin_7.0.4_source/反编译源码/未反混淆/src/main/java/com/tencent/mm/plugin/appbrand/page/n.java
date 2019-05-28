package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.luggage.g.f;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;
import org.json.JSONObject;

public abstract class n extends SwipeBackLayout {
    private View WL;
    private q gND;
    private final a irA = new a() {
        public final void h(int i, float f) {
            AppMethodBeat.i(87069);
            if (i != 0) {
                n.this.mSwiping = true;
            } else {
                n.this.mSwiping = false;
            }
            n e = n.this.gND.e(n.this);
            if (Float.compare(1.0f, f) <= 0) {
                if (!n.this.irz[0]) {
                    if (e != null) {
                        n.l(e.getContentView(), 0.0f);
                    }
                    e = n.this;
                    e.mSwiping = true;
                    e.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(87070);
                            n.this.gND.c(n.this);
                            AppMethodBeat.o(87070);
                        }
                    });
                    n.this.irz[0] = true;
                }
            } else if (e != null) {
                e.onSwipe(f);
            }
            ab.i("MicroMsg.AppBrandPage", "scrollPercent %f", Float.valueOf(f));
            AppMethodBeat.o(87069);
        }

        public final void xv() {
        }

        public final void l(MotionEvent motionEvent) {
        }

        public final boolean ba(boolean z) {
            return false;
        }
    };
    private boolean irv = true;
    private boolean irw = false;
    private int irx;
    private int iry;
    final boolean[] irz = new boolean[]{false};
    public boolean mSwiping = false;

    public abstract boolean Ay(String str);

    public abstract View aAQ();

    public abstract void b(String str, String str2, int[] iArr);

    public abstract u getCurrentPageView();

    public abstract String getCurrentUrl();

    public abstract void loadUrl(String str);

    public n(Context context, q qVar) {
        super(context);
        this.gND = qVar;
        setLayoutParams(new LayoutParams(-1, -1));
        setScrimColor(0);
        this.WL = aAQ();
        addView(getContentView());
        setContentView(getContentView());
        a(this.irA);
    }

    /* Access modifiers changed, original: protected */
    public void a(u uVar, AppBrandPageFullScreenView appBrandPageFullScreenView) {
        if (appBrandPageFullScreenView != null && appBrandPageFullScreenView.getParent() == null && (this.WL instanceof ViewGroup)) {
            ((ViewGroup) this.WL).addView(appBrandPageFullScreenView, new LayoutParams(-1, -1));
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
    public final void xN() {
        cleanup();
    }

    /* Access modifiers changed, original: protected */
    public void cleanup() {
    }

    /* Access modifiers changed, original: protected */
    public void aAS() {
        ab.d("MicroMsg.AppBrandPage", "onPageForeground: %s", getCurrentUrl());
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
        ab.d("MicroMsg.AppBrandPage", "onPageBackground: %s", getCurrentUrl());
    }

    /* Access modifiers changed, original: protected */
    public void aAR() {
        ab.d("MicroMsg.AppBrandPage", "onPageDestroy: %s", getCurrentUrl());
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
        return this.WL;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        if (this.irv) {
            this.irw = true;
        }
        u currentPageView = getCurrentPageView();
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
    public q getContainer() {
        return this.gND;
    }

    public d getPageConfig() {
        return getCurrentPageView().getPageConfig();
    }

    private void a(String str, aq aqVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("path", h.bO(getCurrentUrl()));
        hashMap.put(SearchIntents.EXTRA_QUERY, h.bP(getCurrentUrl()));
        hashMap.put("rawPath", getCurrentUrl());
        if (aqVar != null) {
            hashMap.put("openType", aqVar.toString());
        }
        if ("onAppRoute".equals(str)) {
            hashMap.put("resizing", Boolean.valueOf(getCurrentPageView().aJK()));
        }
        e.d(hashMap);
        getCurrentPageView().a(str, new JSONObject(hashMap).toString(), null);
    }

    public final void a(aq aqVar) {
        a("onAppRoute", aqVar);
        ab.i("MicroMsg.AppBrandPage", "onAppRoute: %s, %s", aqVar.toString(), getCurrentUrl());
    }

    public final void aJl() {
        a("onAppRouteDone", null);
        ab.i("MicroMsg.AppBrandPage", "onAppRouteDone: %s", getCurrentUrl());
    }

    protected static boolean f(int[] iArr, int i) {
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
        f.az(getContext());
    }

    private static void l(View view, float f) {
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
        l(getContentView(), (((float) (getContentView().getWidth() / 4)) * (1.0f - f)) * -1.0f);
    }
}
