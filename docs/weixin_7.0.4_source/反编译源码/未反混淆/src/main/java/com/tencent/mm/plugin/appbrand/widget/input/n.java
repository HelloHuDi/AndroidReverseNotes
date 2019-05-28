package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.s;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.luggage.g.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
public final class n extends FrameLayout {
    private static final int huq = R.id.a5;
    private View fs;
    private View jeH;
    private int jeI = -1;
    private final int[] jeJ = new int[2];
    private com.tencent.mm.plugin.appbrand.widget.d.a jeK;
    private WeakHashMap<View, b> jeL = new WeakHashMap();
    private Runnable jeM = new Runnable() {
        public final void run() {
            int i = 0;
            AppMethodBeat.i(126663);
            ab.i("MicroMsg.AppBrandUIdRootFrameLayout", "hideInactivePanelView, mPanel %s", n.this.jeH.getClass().getSimpleName());
            if (n.this.jeH == null) {
                AppMethodBeat.o(126663);
                return;
            }
            while (i < n.this.getChildCount()) {
                View childAt = n.this.getChildAt(i);
                if (!(childAt == null || childAt == n.this.fs || childAt == n.this.jeH)) {
                    n.cJ(childAt);
                }
                i++;
            }
            AppMethodBeat.o(126663);
        }
    };
    private final Runnable jeN = new Runnable() {
        public final void run() {
            int i = 0;
            AppMethodBeat.i(126664);
            ab.i("MicroMsg.AppBrandUIdRootFrameLayout", "callOnPanelChanged, size %d", Integer.valueOf(n.this.jeO.size()));
            if (n.this.jeO.size() <= 0) {
                AppMethodBeat.o(126664);
                return;
            }
            a[] aVarArr = new a[n.this.jeO.size()];
            n.this.jeO.toArray(aVarArr);
            int length = aVarArr.length;
            while (i < length) {
                aVarArr[i].aEM();
                i++;
            }
            AppMethodBeat.o(126664);
        }
    };
    public final Set<a> jeO = new HashSet();
    private boolean mInLayout = false;

    public interface a {
        void aEM();
    }

    static final class b {
        boolean jeQ;
        int jeR;

        private b() {
            this.jeR = 8;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public static n cG(View view) {
        AppMethodBeat.i(126665);
        n nVar = (n) view.getRootView().findViewById(huq);
        AppMethodBeat.o(126665);
        return nVar;
    }

    public static n v(Activity activity) {
        AppMethodBeat.i(126666);
        n nVar = (n) activity.findViewById(huq);
        AppMethodBeat.o(126666);
        return nVar;
    }

    public static void w(Activity activity) {
        AppMethodBeat.i(126667);
        n v = v(activity);
        if (!(v == null || v.jeH == null)) {
            v.jeH.setVisibility(8);
            v.jeH = null;
        }
        AppMethodBeat.o(126667);
    }

    public n(Context context, View view) {
        super(context);
        AppMethodBeat.i(126668);
        super.setId(huq);
        this.fs = view;
        super.addView(view);
        AppMethodBeat.o(126668);
    }

    public final void setForceHeight(int i) {
        AppMethodBeat.i(126669);
        Object obj = i != this.jeI ? 1 : null;
        this.jeI = i;
        if (obj != null) {
            if (!s.as(this)) {
                AppMethodBeat.o(126669);
                return;
            } else if (this.mInLayout) {
                AppMethodBeat.o(126669);
                return;
            } else {
                requestLayout();
            }
        }
        AppMethodBeat.o(126669);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.i(126670);
        if (this.jeI > 0) {
            i2 = MeasureSpec.makeMeasureSpec(this.jeI, ErrorDialogData.SUPPRESSED);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(126670);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(126671);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            if (this.jeH != null && this.jeH.isShown()) {
                this.jeH.setVisibility(8);
                AppMethodBeat.o(126671);
                return true;
            } else if (f.az(getContext())) {
                AppMethodBeat.o(126671);
                return true;
            }
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(126671);
        return dispatchKeyEvent;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(126672);
        b bVar = (b) this.jeL.get(this.jeH);
        if (bVar != null && bVar.jeQ && this.jeH != null && this.jeH.isShown() && motionEvent.getAction() == 0) {
            float rawY = motionEvent.getRawY();
            this.jeH.getLocationOnScreen(this.jeJ);
            float f = (float) this.jeJ[1];
            float height = ((float) this.jeH.getHeight()) + f;
            if (rawY < f || rawY > height) {
                this.jeH.setVisibility(8);
                AppMethodBeat.o(126672);
                return true;
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(126672);
        return dispatchTouchEvent;
    }

    public final void setId(int i) {
    }

    public final void addView(View view) {
        AppMethodBeat.i(126673);
        if (view == this.fs || view == this.jeH) {
            super.addView(view);
        }
        AppMethodBeat.o(126673);
    }

    public final void addView(View view, int i) {
        AppMethodBeat.i(126674);
        if (view == this.fs || view == this.jeH) {
            super.addView(view, i);
        }
        AppMethodBeat.o(126674);
    }

    public final void addView(View view, int i, int i2) {
        AppMethodBeat.i(126675);
        if (view == this.fs || view == this.jeH) {
            super.addView(view, i, i2);
        }
        AppMethodBeat.o(126675);
    }

    public final void addView(View view, LayoutParams layoutParams) {
        AppMethodBeat.i(126676);
        if (view == this.fs || view == this.jeH) {
            super.addView(view, layoutParams);
        }
        AppMethodBeat.o(126676);
    }

    public final void addView(View view, int i, LayoutParams layoutParams) {
        AppMethodBeat.i(126677);
        if (view == this.fs || view == this.jeH) {
            super.addView(view, i, layoutParams);
        }
        AppMethodBeat.o(126677);
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

    public final void n(View view, boolean z) {
        AppMethodBeat.i(126678);
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
            b bVar = new b();
            bVar.jeQ = z;
            this.jeL.put(view, bVar);
        }
        AppMethodBeat.o(126678);
    }

    public final void cH(View view) {
        AppMethodBeat.i(126679);
        n(view, false);
        AppMethodBeat.o(126679);
    }

    public final void setOnLayoutListener(com.tencent.mm.plugin.appbrand.widget.d.a aVar) {
        this.jeK = aVar;
    }

    public final com.tencent.mm.plugin.appbrand.widget.d.a getOnLayoutListener() {
        return this.jeK;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(126680);
        this.mInLayout = true;
        if (s.as(this)) {
            boolean z2 = false;
            int i5 = 1;
            int i6 = 0;
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                View childAt = getChildAt(i7);
                if (!(childAt == null || childAt == this.fs)) {
                    b bVar = (b) this.jeL.get(childAt);
                    if (bVar != null) {
                        if (!(z2 || bVar.jeR == 0 || childAt.getVisibility() != 0)) {
                            this.jeH = childAt;
                            post(this.jeM);
                            z2 = true;
                        }
                        int i8 = (bVar.jeR == 0 ? 1 : 0) | i6;
                        if (childAt.getVisibility() != 0) {
                            i6 = 1;
                        } else {
                            i6 = 0;
                        }
                        i5 &= i6;
                        bVar.jeR = childAt.getVisibility();
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
            this.jeK.cK(this);
        }
        this.mInLayout = false;
        AppMethodBeat.o(126680);
    }

    public static u cI(View view) {
        AppMethodBeat.i(126681);
        n cG = cG(view);
        if (cG == null) {
            AppMethodBeat.o(126681);
            return null;
        }
        if (cG.getOnLayoutListener() == null || !(cG.getOnLayoutListener() instanceof u)) {
            cG.setOnLayoutListener(new u());
        }
        u uVar = (u) cG.getOnLayoutListener();
        AppMethodBeat.o(126681);
        return uVar;
    }

    static /* synthetic */ void cJ(View view) {
        AppMethodBeat.i(126682);
        if (view == null) {
            AppMethodBeat.o(126682);
            return;
        }
        if (view.getVisibility() != 8) {
            view.setVisibility(8);
        }
        AppMethodBeat.o(126682);
    }
}
