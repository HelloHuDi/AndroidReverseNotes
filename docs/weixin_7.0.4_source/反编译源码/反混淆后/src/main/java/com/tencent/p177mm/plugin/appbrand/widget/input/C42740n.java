package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.p057v4.view.C0477s;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.luggage.p147g.C8873f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.p1234d.C19811a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.n */
public final class C42740n extends FrameLayout {
    private static final int huq = 2131820575;
    /* renamed from: fs */
    private View f17189fs;
    private View jeH;
    private int jeI = -1;
    private final int[] jeJ = new int[2];
    private C19811a jeK;
    private WeakHashMap<View, C11026b> jeL = new WeakHashMap();
    private Runnable jeM = new C386021();
    private final Runnable jeN = new C336292();
    public final Set<C11025a> jeO = new HashSet();
    private boolean mInLayout = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.n$a */
    public interface C11025a {
        void aEM();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.n$b */
    static final class C11026b {
        boolean jeQ;
        int jeR;

        private C11026b() {
            this.jeR = 8;
        }

        /* synthetic */ C11026b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.n$2 */
    class C336292 implements Runnable {
        C336292() {
        }

        public final void run() {
            int i = 0;
            AppMethodBeat.m2504i(126664);
            C4990ab.m7417i("MicroMsg.AppBrandUIdRootFrameLayout", "callOnPanelChanged, size %d", Integer.valueOf(C42740n.this.jeO.size()));
            if (C42740n.this.jeO.size() <= 0) {
                AppMethodBeat.m2505o(126664);
                return;
            }
            C11025a[] c11025aArr = new C11025a[C42740n.this.jeO.size()];
            C42740n.this.jeO.toArray(c11025aArr);
            int length = c11025aArr.length;
            while (i < length) {
                c11025aArr[i].aEM();
                i++;
            }
            AppMethodBeat.m2505o(126664);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.n$1 */
    class C386021 implements Runnable {
        C386021() {
        }

        public final void run() {
            int i = 0;
            AppMethodBeat.m2504i(126663);
            C4990ab.m7417i("MicroMsg.AppBrandUIdRootFrameLayout", "hideInactivePanelView, mPanel %s", C42740n.this.jeH.getClass().getSimpleName());
            if (C42740n.this.jeH == null) {
                AppMethodBeat.m2505o(126663);
                return;
            }
            while (i < C42740n.this.getChildCount()) {
                View childAt = C42740n.this.getChildAt(i);
                if (!(childAt == null || childAt == C42740n.this.f17189fs || childAt == C42740n.this.jeH)) {
                    C42740n.m75742cJ(childAt);
                }
                i++;
            }
            AppMethodBeat.m2505o(126663);
        }
    }

    /* renamed from: cG */
    public static C42740n m75740cG(View view) {
        AppMethodBeat.m2504i(126665);
        C42740n c42740n = (C42740n) view.getRootView().findViewById(huq);
        AppMethodBeat.m2505o(126665);
        return c42740n;
    }

    /* renamed from: v */
    public static C42740n m75744v(Activity activity) {
        AppMethodBeat.m2504i(126666);
        C42740n c42740n = (C42740n) activity.findViewById(huq);
        AppMethodBeat.m2505o(126666);
        return c42740n;
    }

    /* renamed from: w */
    public static void m75745w(Activity activity) {
        AppMethodBeat.m2504i(126667);
        C42740n v = C42740n.m75744v(activity);
        if (!(v == null || v.jeH == null)) {
            v.jeH.setVisibility(8);
            v.jeH = null;
        }
        AppMethodBeat.m2505o(126667);
    }

    public C42740n(Context context, View view) {
        super(context);
        AppMethodBeat.m2504i(126668);
        super.setId(huq);
        this.f17189fs = view;
        super.addView(view);
        AppMethodBeat.m2505o(126668);
    }

    public final void setForceHeight(int i) {
        AppMethodBeat.m2504i(126669);
        Object obj = i != this.jeI ? 1 : null;
        this.jeI = i;
        if (obj != null) {
            if (!C0477s.m927as(this)) {
                AppMethodBeat.m2505o(126669);
                return;
            } else if (this.mInLayout) {
                AppMethodBeat.m2505o(126669);
                return;
            } else {
                requestLayout();
            }
        }
        AppMethodBeat.m2505o(126669);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(126670);
        if (this.jeI > 0) {
            i2 = MeasureSpec.makeMeasureSpec(this.jeI, ErrorDialogData.SUPPRESSED);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(126670);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(126671);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            if (this.jeH != null && this.jeH.isShown()) {
                this.jeH.setVisibility(8);
                AppMethodBeat.m2505o(126671);
                return true;
            } else if (C8873f.m15846az(getContext())) {
                AppMethodBeat.m2505o(126671);
                return true;
            }
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(126671);
        return dispatchKeyEvent;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(126672);
        C11026b c11026b = (C11026b) this.jeL.get(this.jeH);
        if (c11026b != null && c11026b.jeQ && this.jeH != null && this.jeH.isShown() && motionEvent.getAction() == 0) {
            float rawY = motionEvent.getRawY();
            this.jeH.getLocationOnScreen(this.jeJ);
            float f = (float) this.jeJ[1];
            float height = ((float) this.jeH.getHeight()) + f;
            if (rawY < f || rawY > height) {
                this.jeH.setVisibility(8);
                AppMethodBeat.m2505o(126672);
                return true;
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(126672);
        return dispatchTouchEvent;
    }

    public final void setId(int i) {
    }

    public final void addView(View view) {
        AppMethodBeat.m2504i(126673);
        if (view == this.f17189fs || view == this.jeH) {
            super.addView(view);
        }
        AppMethodBeat.m2505o(126673);
    }

    public final void addView(View view, int i) {
        AppMethodBeat.m2504i(126674);
        if (view == this.f17189fs || view == this.jeH) {
            super.addView(view, i);
        }
        AppMethodBeat.m2505o(126674);
    }

    public final void addView(View view, int i, int i2) {
        AppMethodBeat.m2504i(126675);
        if (view == this.f17189fs || view == this.jeH) {
            super.addView(view, i, i2);
        }
        AppMethodBeat.m2505o(126675);
    }

    public final void addView(View view, LayoutParams layoutParams) {
        AppMethodBeat.m2504i(126676);
        if (view == this.f17189fs || view == this.jeH) {
            super.addView(view, layoutParams);
        }
        AppMethodBeat.m2505o(126676);
    }

    public final void addView(View view, int i, LayoutParams layoutParams) {
        AppMethodBeat.m2504i(126677);
        if (view == this.f17189fs || view == this.jeH) {
            super.addView(view, i, layoutParams);
        }
        AppMethodBeat.m2505o(126677);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean addViewInLayout(View view, int i, LayoutParams layoutParams) {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean addViewInLayout(View view, int i, LayoutParams layoutParams, boolean z) {
        return false;
    }

    public final View getCurrentBottomPanel() {
        return this.jeH;
    }

    /* renamed from: n */
    public final void mo68198n(View view, boolean z) {
        AppMethodBeat.m2504i(126678);
        if (this.jeH != null) {
            this.jeH.setVisibility(8);
            this.jeH = null;
        }
        if (this != view.getParent()) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.jeH = view;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            super.addView(view, layoutParams);
            C11026b c11026b = new C11026b();
            c11026b.jeQ = z;
            this.jeL.put(view, c11026b);
        }
        AppMethodBeat.m2505o(126678);
    }

    /* renamed from: cH */
    public final void mo68193cH(View view) {
        AppMethodBeat.m2504i(126679);
        mo68198n(view, false);
        AppMethodBeat.m2505o(126679);
    }

    public final void setOnLayoutListener(C19811a c19811a) {
        this.jeK = c19811a;
    }

    public final C19811a getOnLayoutListener() {
        return this.jeK;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(126680);
        this.mInLayout = true;
        if (C0477s.m927as(this)) {
            boolean z2 = false;
            int i5 = 1;
            int i6 = 0;
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                View childAt = getChildAt(i7);
                if (!(childAt == null || childAt == this.f17189fs)) {
                    C11026b c11026b = (C11026b) this.jeL.get(childAt);
                    if (c11026b != null) {
                        if (!(z2 || c11026b.jeR == 0 || childAt.getVisibility() != 0)) {
                            this.jeH = childAt;
                            post(this.jeM);
                            z2 = true;
                        }
                        int i8 = (c11026b.jeR == 0 ? 1 : 0) | i6;
                        if (childAt.getVisibility() != 0) {
                            i6 = 1;
                        } else {
                            i6 = 0;
                        }
                        i5 &= i6;
                        c11026b.jeR = childAt.getVisibility();
                        i6 = i8;
                    }
                }
            }
            if (z2 || !(i6 == 0 || i5 == 0)) {
                post(this.jeN);
            }
        }
        super.onLayout(z, i, i2, i3, i4);
        if (this.jeK != null) {
            this.jeK.mo35031cK(this);
        }
        this.mInLayout = false;
        AppMethodBeat.m2505o(126680);
    }

    /* renamed from: cI */
    public static C38606u m75741cI(View view) {
        AppMethodBeat.m2504i(126681);
        C42740n cG = C42740n.m75740cG(view);
        if (cG == null) {
            AppMethodBeat.m2505o(126681);
            return null;
        }
        if (cG.getOnLayoutListener() == null || !(cG.getOnLayoutListener() instanceof C38606u)) {
            cG.setOnLayoutListener(new C38606u());
        }
        C38606u c38606u = (C38606u) cG.getOnLayoutListener();
        AppMethodBeat.m2505o(126681);
        return c38606u;
    }

    /* renamed from: cJ */
    static /* synthetic */ void m75742cJ(View view) {
        AppMethodBeat.m2504i(126682);
        if (view == null) {
            AppMethodBeat.m2505o(126682);
            return;
        }
        if (view.getVisibility() != 8) {
            view.setVisibility(8);
        }
        AppMethodBeat.m2505o(126682);
    }
}
