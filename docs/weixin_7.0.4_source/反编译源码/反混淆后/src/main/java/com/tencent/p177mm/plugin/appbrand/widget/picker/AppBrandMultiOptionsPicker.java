package com.tencent.p177mm.plugin.appbrand.widget.picker;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p311m.C19427b;
import com.tencent.p177mm.plugin.appbrand.widget.picker.YANumberPicker.C27425b;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker */
public final class AppBrandMultiOptionsPicker extends FrameLayout implements C19427b<int[]> {
    private boolean anv;
    private final Drawable jkE;
    public LinearLayout jkF;
    private boolean jkG;
    private C33642d jkH;
    public final C27425b jkI = new C386161();

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker$a */
    public static final class C27421a {
        public final String[] jkK;
        public final int jkL;

        public C27421a(String[] strArr, int i) {
            AppMethodBeat.m2504i(126703);
            this.jkK = strArr;
            this.jkL = Math.max(0, Math.min(i, strArr.length - 1));
            AppMethodBeat.m2505o(126703);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker$2 */
    public class C367422 extends C33641c {
        public C367422(Context context) {
            super(context);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker$1 */
    class C386161 implements C27425b {
        C386161() {
        }

        /* renamed from: a */
        public final void mo45198a(YANumberPicker yANumberPicker, int i) {
            AppMethodBeat.m2504i(126702);
            if (AppBrandMultiOptionsPicker.this.jkH != null) {
                int intValue = ((Integer) yANumberPicker.getTag(2131820565)).intValue();
                C33642d a = AppBrandMultiOptionsPicker.this.jkH;
                int[] iArr = new int[]{intValue, i};
                if (a.jkV != null) {
                    a.jkV.mo34564bw(iArr);
                }
            }
            AppMethodBeat.m2505o(126702);
        }
    }

    @Keep
    public AppBrandMultiOptionsPicker(Context context) {
        super(context);
        AppMethodBeat.m2504i(126704);
        this.jkE = context.getResources().getDrawable(C25738R.drawable.f6368bx);
        this.jkF = new LinearLayout(context);
        this.jkF.setPadding(C1338a.fromDPToPix(context, 2), 0, C1338a.fromDPToPix(context, 2), 0);
        this.jkF.setOrientation(0);
        addView(this.jkF, new LayoutParams(-1, -1, 17));
        this.jkF.setDividerDrawable(this.jkE);
        this.jkF.setShowDividers(2);
        AppMethodBeat.m2505o(126704);
    }

    public final void setLayoutFrozen(boolean z) {
        AppMethodBeat.m2504i(126705);
        if (this.anv != z) {
            this.anv = z;
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                AppMethodBeat.m2505o(126705);
                return;
            } else if (this.jkG) {
                requestLayout();
            }
        }
        AppMethodBeat.m2505o(126705);
    }

    public final void requestLayout() {
        AppMethodBeat.m2504i(126706);
        if (this.anv) {
            this.jkG = true;
            AppMethodBeat.m2505o(126706);
            return;
        }
        super.requestLayout();
        AppMethodBeat.m2505o(126706);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(126707);
        if (this.anv) {
            AppMethodBeat.m2505o(126707);
            return false;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.m2505o(126707);
        return onInterceptTouchEvent;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(126708);
        if (this.anv) {
            AppMethodBeat.m2505o(126708);
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(126708);
        return onTouchEvent;
    }

    /* renamed from: qP */
    public final C33641c mo68208qP(int i) {
        AppMethodBeat.m2504i(126709);
        if (i < 0) {
            AppMethodBeat.m2505o(126709);
            return null;
        } else if (this.jkF == null) {
            AppMethodBeat.m2505o(126709);
            return null;
        } else {
            C33641c c33641c = (C33641c) this.jkF.getChildAt(i);
            AppMethodBeat.m2505o(126709);
            return c33641c;
        }
    }

    public final int getPickersCount() {
        AppMethodBeat.m2504i(126710);
        if (this.jkF == null) {
            AppMethodBeat.m2505o(126710);
            return 0;
        }
        int childCount = this.jkF.getChildCount();
        AppMethodBeat.m2505o(126710);
        return childCount;
    }

    /* renamed from: qQ */
    public final void mo68209qQ(int i) {
        AppMethodBeat.m2504i(126711);
        if (i <= 0) {
            AppMethodBeat.m2505o(126711);
            return;
        }
        int pickersCount = getPickersCount() - 1;
        while (i > 0) {
            this.jkF.removeViewAt(pickersCount);
            pickersCount--;
            i--;
        }
        AppMethodBeat.m2505o(126711);
    }

    public final View getView() {
        return this;
    }

    /* renamed from: a */
    public final void mo22726a(C33642d c33642d) {
        this.jkH = c33642d;
    }

    public final void aEH() {
        AppMethodBeat.m2504i(126712);
        int pickersCount = getPickersCount();
        for (int i = 0; i < pickersCount; i++) {
            C33641c qP = mo68208qP(i);
            if (qP != null) {
                qP.aRX();
            }
        }
        AppMethodBeat.m2505o(126712);
    }

    /* renamed from: b */
    public final void mo22731b(C33642d c33642d) {
        this.jkH = c33642d;
    }

    public final void aEI() {
        this.jkH = null;
    }

    public final /* synthetic */ Object aEG() {
        int i = 0;
        AppMethodBeat.m2504i(126713);
        int pickersCount = getPickersCount();
        if (pickersCount <= 0) {
            int[] iArr = new int[0];
            AppMethodBeat.m2505o(126713);
            return iArr;
        }
        Object obj = new int[pickersCount];
        while (i < pickersCount) {
            obj[i] = mo68208qP(i).getValue();
            i++;
        }
        AppMethodBeat.m2505o(126713);
        return obj;
    }
}
