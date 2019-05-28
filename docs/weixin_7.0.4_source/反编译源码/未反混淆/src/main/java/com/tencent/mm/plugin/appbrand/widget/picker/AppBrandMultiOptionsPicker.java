package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.m.b;

public final class AppBrandMultiOptionsPicker extends FrameLayout implements b<int[]> {
    private boolean anv;
    private final Drawable jkE;
    public LinearLayout jkF;
    private boolean jkG;
    private d jkH;
    public final YANumberPicker.b jkI = new YANumberPicker.b() {
        public final void a(YANumberPicker yANumberPicker, int i) {
            AppMethodBeat.i(126702);
            if (AppBrandMultiOptionsPicker.this.jkH != null) {
                int intValue = ((Integer) yANumberPicker.getTag(R.id.v)).intValue();
                d a = AppBrandMultiOptionsPicker.this.jkH;
                int[] iArr = new int[]{intValue, i};
                if (a.jkV != null) {
                    a.jkV.bw(iArr);
                }
            }
            AppMethodBeat.o(126702);
        }
    };

    public static final class a {
        public final String[] jkK;
        public final int jkL;

        public a(String[] strArr, int i) {
            AppMethodBeat.i(126703);
            this.jkK = strArr;
            this.jkL = Math.max(0, Math.min(i, strArr.length - 1));
            AppMethodBeat.o(126703);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker$2 */
    public class AnonymousClass2 extends c {
        public AnonymousClass2(Context context) {
            super(context);
        }
    }

    @Keep
    public AppBrandMultiOptionsPicker(Context context) {
        super(context);
        AppMethodBeat.i(126704);
        this.jkE = context.getResources().getDrawable(R.drawable.bx);
        this.jkF = new LinearLayout(context);
        this.jkF.setPadding(com.tencent.mm.bz.a.fromDPToPix(context, 2), 0, com.tencent.mm.bz.a.fromDPToPix(context, 2), 0);
        this.jkF.setOrientation(0);
        addView(this.jkF, new LayoutParams(-1, -1, 17));
        this.jkF.setDividerDrawable(this.jkE);
        this.jkF.setShowDividers(2);
        AppMethodBeat.o(126704);
    }

    public final void setLayoutFrozen(boolean z) {
        AppMethodBeat.i(126705);
        if (this.anv != z) {
            this.anv = z;
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                AppMethodBeat.o(126705);
                return;
            } else if (this.jkG) {
                requestLayout();
            }
        }
        AppMethodBeat.o(126705);
    }

    public final void requestLayout() {
        AppMethodBeat.i(126706);
        if (this.anv) {
            this.jkG = true;
            AppMethodBeat.o(126706);
            return;
        }
        super.requestLayout();
        AppMethodBeat.o(126706);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(126707);
        if (this.anv) {
            AppMethodBeat.o(126707);
            return false;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(126707);
        return onInterceptTouchEvent;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(126708);
        if (this.anv) {
            AppMethodBeat.o(126708);
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(126708);
        return onTouchEvent;
    }

    public final c qP(int i) {
        AppMethodBeat.i(126709);
        if (i < 0) {
            AppMethodBeat.o(126709);
            return null;
        } else if (this.jkF == null) {
            AppMethodBeat.o(126709);
            return null;
        } else {
            c cVar = (c) this.jkF.getChildAt(i);
            AppMethodBeat.o(126709);
            return cVar;
        }
    }

    public final int getPickersCount() {
        AppMethodBeat.i(126710);
        if (this.jkF == null) {
            AppMethodBeat.o(126710);
            return 0;
        }
        int childCount = this.jkF.getChildCount();
        AppMethodBeat.o(126710);
        return childCount;
    }

    public final void qQ(int i) {
        AppMethodBeat.i(126711);
        if (i <= 0) {
            AppMethodBeat.o(126711);
            return;
        }
        int pickersCount = getPickersCount() - 1;
        while (i > 0) {
            this.jkF.removeViewAt(pickersCount);
            pickersCount--;
            i--;
        }
        AppMethodBeat.o(126711);
    }

    public final View getView() {
        return this;
    }

    public final void a(d dVar) {
        this.jkH = dVar;
    }

    public final void aEH() {
        AppMethodBeat.i(126712);
        int pickersCount = getPickersCount();
        for (int i = 0; i < pickersCount; i++) {
            c qP = qP(i);
            if (qP != null) {
                qP.aRX();
            }
        }
        AppMethodBeat.o(126712);
    }

    public final void b(d dVar) {
        this.jkH = dVar;
    }

    public final void aEI() {
        this.jkH = null;
    }

    public final /* synthetic */ Object aEG() {
        int i = 0;
        AppMethodBeat.i(126713);
        int pickersCount = getPickersCount();
        if (pickersCount <= 0) {
            int[] iArr = new int[0];
            AppMethodBeat.o(126713);
            return iArr;
        }
        Object obj = new int[pickersCount];
        while (i < pickersCount) {
            obj[i] = qP(i).getValue();
            i++;
        }
        AppMethodBeat.o(126713);
        return obj;
    }
}
