package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.util.ActUtil;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup {
    static final int[] LAYOUT_ATTRS = new int[]{16842931};
    private static final int[] PU = new int[]{16843828};
    static final boolean PV;
    private static final boolean PW;
    private final b PX;
    private float PY;
    private int PZ;
    private int Qa;
    private float Qb;
    private Paint Qc;
    final t Qd;
    final t Qe;
    private final d Qf;
    private final d Qg;
    int Qh;
    private int Qi;
    private int Qj;
    private int Qk;
    private int Ql;
    private boolean Qm;
    boolean Qn;
    private c Qo;
    private Drawable Qp;
    private Drawable Qq;
    CharSequence Qr;
    CharSequence Qs;
    Object Qt;
    private Drawable Qu;
    private Drawable Qv;
    private Drawable Qw;
    private Drawable Qx;
    private final ArrayList<View> Qy;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    List<c> mq;
    boolean pB;
    private Drawable pC;

    public static class LayoutParams extends MarginLayoutParams {
        float QA;
        boolean QB;
        int QC;
        public int gravity = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public interface c {
        void E(float f);

        void eH();

        void eI();
    }

    protected static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        int QD = 0;
        int QE;
        int QF;
        int QG;
        int QH;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.QD = parcel.readInt();
            this.QE = parcel.readInt();
            this.QF = parcel.readInt();
            this.QG = parcel.readInt();
            this.QH = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.QD);
            parcel.writeInt(this.QE);
            parcel.writeInt(this.QF);
            parcel.writeInt(this.QG);
            parcel.writeInt(this.QH);
        }
    }

    class a extends android.support.v4.view.a {
        private final Rect oT = new Rect();

        a() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, android.support.v4.view.a.b bVar) {
            if (DrawerLayout.PV) {
                super.onInitializeAccessibilityNodeInfo(view, bVar);
            } else {
                android.support.v4.view.a.b a = android.support.v4.view.a.b.a(bVar);
                super.onInitializeAccessibilityNodeInfo(view, a);
                bVar.setSource(view);
                ViewParent U = s.U(view);
                if (U instanceof View) {
                    bVar.setParent((View) U);
                }
                Rect rect = this.oT;
                a.getBoundsInParent(rect);
                bVar.setBoundsInParent(rect);
                a.getBoundsInScreen(rect);
                bVar.setBoundsInScreen(rect);
                bVar.setVisibleToUser(a.isVisibleToUser());
                bVar.setPackageName(a.NG.getPackageName());
                bVar.setClassName(a.NG.getClassName());
                bVar.setContentDescription(a.NG.getContentDescription());
                bVar.setEnabled(a.NG.isEnabled());
                bVar.setClickable(a.NG.isClickable());
                bVar.setFocusable(a.NG.isFocusable());
                bVar.setFocused(a.NG.isFocused());
                bVar.setAccessibilityFocused(a.isAccessibilityFocused());
                bVar.setSelected(a.NG.isSelected());
                bVar.setLongClickable(a.NG.isLongClickable());
                bVar.addAction(a.NG.getActions());
                a.NG.recycle();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (DrawerLayout.aJ(childAt)) {
                        bVar.addChild(childAt);
                    }
                }
            }
            bVar.setClassName(DrawerLayout.class.getName());
            bVar.setFocusable(false);
            bVar.setFocused(false);
            bVar.a(android.support.v4.view.a.b.a.NI);
            bVar.a(android.support.v4.view.a.b.a.NJ);
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View eG = DrawerLayout.this.eG();
            if (eG != null) {
                Object obj;
                int aE = DrawerLayout.this.aE(eG);
                DrawerLayout drawerLayout = DrawerLayout.this;
                aE = android.support.v4.view.d.getAbsoluteGravity(aE, s.T(drawerLayout));
                if (aE == 3) {
                    obj = drawerLayout.Qr;
                } else if (aE == 5) {
                    obj = drawerLayout.Qs;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    text.add(obj);
                }
            }
            return true;
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.PV || DrawerLayout.aJ(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    static final class b extends android.support.v4.view.a {
        b() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, android.support.v4.view.a.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            if (!DrawerLayout.aJ(view)) {
                bVar.setParent(null);
            }
        }
    }

    class d extends android.support.v4.widget.t.a {
        final int QI;
        t QJ;
        private final Runnable QK = new Runnable() {
            public final void run() {
                View aS;
                int i = 0;
                d dVar = d.this;
                int i2 = dVar.QJ.SR;
                boolean z = dVar.QI == 3;
                if (z) {
                    int i3;
                    aS = DrawerLayout.this.aS(3);
                    if (aS != null) {
                        i3 = -aS.getWidth();
                    } else {
                        i3 = 0;
                    }
                    i2 = i3 + i2;
                } else {
                    i2 = DrawerLayout.this.getWidth() - i2;
                    aS = DrawerLayout.this.aS(5);
                }
                if (aS == null) {
                    return;
                }
                if (((z && aS.getLeft() < i2) || (!z && aS.getLeft() > i2)) && DrawerLayout.this.aC(aS) == 0) {
                    LayoutParams layoutParams = (LayoutParams) aS.getLayoutParams();
                    dVar.QJ.h(aS, i2, aS.getTop());
                    layoutParams.QB = true;
                    DrawerLayout.this.invalidate();
                    dVar.eJ();
                    DrawerLayout drawerLayout = DrawerLayout.this;
                    if (!drawerLayout.Qn) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        int childCount = drawerLayout.getChildCount();
                        while (i < childCount) {
                            drawerLayout.getChildAt(i).dispatchTouchEvent(obtain);
                            i++;
                        }
                        obtain.recycle();
                        drawerLayout.Qn = true;
                    }
                }
            }
        };

        d(int i) {
            this.QI = i;
        }

        public final void eD() {
            DrawerLayout.this.removeCallbacks(this.QK);
        }

        public final boolean b(View view, int i) {
            return DrawerLayout.aG(view) && DrawerLayout.this.t(view, this.QI) && DrawerLayout.this.aC(view) == 0;
        }

        public final void N(int i) {
            DrawerLayout drawerLayout = DrawerLayout.this;
            View view = this.QJ.SU;
            int i2 = drawerLayout.Qd.SG;
            int i3 = drawerLayout.Qe.SG;
            if (i2 == 1 || i3 == 1) {
                i3 = 1;
            } else if (i2 == 2 || i3 == 2) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            if (view != null && i == 0) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.QA == 0.0f) {
                    layoutParams = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams.QC & 1) == 1) {
                        layoutParams.QC = 0;
                        if (drawerLayout.mq != null) {
                            for (i2 = drawerLayout.mq.size() - 1; i2 >= 0; i2--) {
                                ((c) drawerLayout.mq.get(i2)).eI();
                            }
                        }
                        drawerLayout.f(view, false);
                        if (drawerLayout.hasWindowFocus()) {
                            View rootView = drawerLayout.getRootView();
                            if (rootView != null) {
                                rootView.sendAccessibilityEvent(32);
                            }
                        }
                    }
                } else if (layoutParams.QA == 1.0f) {
                    layoutParams = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams.QC & 1) == 0) {
                        layoutParams.QC = 1;
                        if (drawerLayout.mq != null) {
                            for (i2 = drawerLayout.mq.size() - 1; i2 >= 0; i2--) {
                                ((c) drawerLayout.mq.get(i2)).eH();
                            }
                        }
                        drawerLayout.f(view, true);
                        if (drawerLayout.hasWindowFocus()) {
                            drawerLayout.sendAccessibilityEvent(32);
                        }
                    }
                }
            }
            if (i3 != drawerLayout.Qh) {
                drawerLayout.Qh = i3;
                if (drawerLayout.mq != null) {
                    for (int size = drawerLayout.mq.size() - 1; size >= 0; size--) {
                        drawerLayout.mq.get(size);
                    }
                }
            }
        }

        public final void b(View view, int i, int i2) {
            float f;
            int width = view.getWidth();
            if (DrawerLayout.this.t(view, 3)) {
                f = ((float) (width + i)) / ((float) width);
            } else {
                f = ((float) (DrawerLayout.this.getWidth() - i)) / ((float) width);
            }
            DrawerLayout.this.k(view, f);
            view.setVisibility(f == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        public final void k(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).QB = false;
            eJ();
        }

        /* Access modifiers changed, original: final */
        public final void eJ() {
            int i = 3;
            if (this.QI == 3) {
                i = 5;
            }
            View aS = DrawerLayout.this.aS(i);
            if (aS != null) {
                DrawerLayout.this.aI(aS);
            }
        }

        public final void a(View view, float f, float f2) {
            int i;
            float aD = DrawerLayout.aD(view);
            int width = view.getWidth();
            if (DrawerLayout.this.t(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && aD > 0.5f)) ? 0 : -width;
            } else {
                i = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && aD > 0.5f)) {
                    i -= width;
                }
            }
            this.QJ.D(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        public final void eK() {
            DrawerLayout.this.postDelayed(this.QK, 160);
        }

        public final void z(int i, int i2) {
            View aS;
            if ((i & 1) == 1) {
                aS = DrawerLayout.this.aS(3);
            } else {
                aS = DrawerLayout.this.aS(5);
            }
            if (aS != null && DrawerLayout.this.aC(aS) == 0) {
                this.QJ.u(aS, i2);
            }
        }

        public final int s(View view) {
            return DrawerLayout.aG(view) ? view.getWidth() : 0;
        }

        public final int d(View view, int i) {
            if (DrawerLayout.this.t(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public final int c(View view, int i) {
            return view.getTop();
        }
    }

    static {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 19) {
            z = true;
        } else {
            z = false;
        }
        PV = z;
        if (VERSION.SDK_INT < 21) {
            z2 = false;
        }
        PW = z2;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.PX = new b();
        this.Qa = -1728053248;
        this.Qc = new Paint();
        this.mFirstLayout = true;
        this.Qi = 3;
        this.Qj = 3;
        this.Qk = 3;
        this.Ql = 3;
        this.Qu = null;
        this.Qv = null;
        this.Qw = null;
        this.Qx = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.PZ = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.Qf = new d(3);
        this.Qg = new d(5);
        this.Qd = t.a((ViewGroup) this, 1.0f, this.Qf);
        this.Qd.SS = 1;
        this.Qd.SQ = f2;
        this.Qf.QJ = this.Qd;
        this.Qe = t.a((ViewGroup) this, 1.0f, this.Qg);
        this.Qe.SS = 2;
        this.Qe.SQ = f2;
        this.Qg.QJ = this.Qe;
        setFocusableInTouchMode(true);
        s.o(this, 1);
        s.a((View) this, new a());
        setMotionEventSplittingEnabled(false);
        if (s.al(this)) {
            if (VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                    @TargetApi(21)
                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        boolean z;
                        boolean z2 = true;
                        DrawerLayout drawerLayout = (DrawerLayout) view;
                        if (windowInsets.getSystemWindowInsetTop() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        drawerLayout.Qt = windowInsets;
                        drawerLayout.pB = z;
                        if (z || drawerLayout.getBackground() != null) {
                            z2 = false;
                        }
                        drawerLayout.setWillNotDraw(z2);
                        drawerLayout.requestLayout();
                        return windowInsets.consumeSystemWindowInsets();
                    }
                });
                setSystemUiVisibility(ActUtil.HEIGHT);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(PU);
                try {
                    this.pC = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.pC = null;
            }
        }
        this.PY = f * 10.0f;
        this.Qy = new ArrayList();
    }

    public void setDrawerElevation(float f) {
        this.PY = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (aG(childAt)) {
                s.h(childAt, this.PY);
            }
        }
    }

    public float getDrawerElevation() {
        if (PW) {
            return this.PY;
        }
        return 0.0f;
    }

    public void setScrimColor(int i) {
        this.Qa = i;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(c cVar) {
        if (this.Qo != null) {
            c cVar2 = this.Qo;
            if (!(cVar2 == null || this.mq == null)) {
                this.mq.remove(cVar2);
            }
        }
        if (!(cVar == null || cVar == null)) {
            if (this.mq == null) {
                this.mq = new ArrayList();
            }
            this.mq.add(cVar);
        }
        this.Qo = cVar;
    }

    public void setDrawerLockMode(int i) {
        y(i, 3);
        y(i, 5);
    }

    private void y(int i, int i2) {
        int absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(i2, s.T(this));
        switch (i2) {
            case 3:
                this.Qi = i;
                break;
            case 5:
                this.Qj = i;
                break;
            case 8388611:
                this.Qk = i;
                break;
            case 8388613:
                this.Ql = i;
                break;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.Qd : this.Qe).cancel();
        }
        View aS;
        switch (i) {
            case 1:
                aS = aS(absoluteGravity);
                if (aS != null) {
                    aI(aS);
                    return;
                }
                return;
            case 2:
                aS = aS(absoluteGravity);
                if (aS != null) {
                    aH(aS);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final int aC(View view) {
        if (aG(view)) {
            int i = ((LayoutParams) view.getLayoutParams()).gravity;
            int T = s.T(this);
            switch (i) {
                case 3:
                    if (this.Qi != 3) {
                        return this.Qi;
                    }
                    i = T == 0 ? this.Qk : this.Ql;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 5:
                    if (this.Qj != 3) {
                        return this.Qj;
                    }
                    i = T == 0 ? this.Ql : this.Qk;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 8388611:
                    if (this.Qk != 3) {
                        return this.Qk;
                    }
                    i = T == 0 ? this.Qi : this.Qj;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 8388613:
                    if (this.Ql != 3) {
                        return this.Ql;
                    }
                    i = T == 0 ? this.Qj : this.Qi;
                    if (i != 3) {
                        return i;
                    }
                    break;
            }
            return 0;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* Access modifiers changed, original: final */
    public final void f(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || aG(childAt)) && !(z && childAt == view)) {
                s.o(childAt, 4);
            } else {
                s.o(childAt, 1);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void k(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.QA) {
            layoutParams.QA = f;
            if (this.mq != null) {
                for (int size = this.mq.size() - 1; size >= 0; size--) {
                    ((c) this.mq.get(size)).E(f);
                }
            }
        }
    }

    static float aD(View view) {
        return ((LayoutParams) view.getLayoutParams()).QA;
    }

    /* Access modifiers changed, original: final */
    public final int aE(View view) {
        return android.support.v4.view.d.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, s.T(this));
    }

    /* Access modifiers changed, original: final */
    public final boolean t(View view, int i) {
        return (aE(view) & i) == i;
    }

    private View eF() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).QC & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* Access modifiers changed, original: final */
    public final View aS(int i) {
        int absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(i, s.T(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((aE(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int i, int i2) {
        Object obj;
        int T;
        Object obj2;
        Object obj3;
        int childCount;
        int i3;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (!(mode == ErrorDialogData.SUPPRESSED && mode2 == ErrorDialogData.SUPPRESSED)) {
            if (isInEditMode()) {
                if (mode != j.INVALID_ID && mode == 0) {
                    size = 300;
                }
                if (mode2 != j.INVALID_ID && mode2 == 0) {
                    mode = 300;
                    mode2 = size;
                    setMeasuredDimension(mode2, mode);
                    if (this.Qt == null && s.al(this)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    T = s.T(this);
                    obj2 = null;
                    obj3 = null;
                    childCount = getChildCount();
                    for (i3 = 0; i3 < childCount; i3++) {
                        View childAt = getChildAt(i3);
                        if (childAt.getVisibility() != 8) {
                            int absoluteGravity;
                            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                            if (obj != null) {
                                absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(layoutParams.gravity, T);
                                WindowInsets windowInsets;
                                if (s.al(childAt)) {
                                    if (VERSION.SDK_INT >= 21) {
                                        windowInsets = (WindowInsets) this.Qt;
                                        if (absoluteGravity == 3) {
                                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                                        } else if (absoluteGravity == 5) {
                                            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                                        }
                                        childAt.dispatchApplyWindowInsets(windowInsets);
                                    }
                                } else if (VERSION.SDK_INT >= 21) {
                                    windowInsets = (WindowInsets) this.Qt;
                                    if (absoluteGravity == 3) {
                                        windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                                    } else if (absoluteGravity == 5) {
                                        windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                                    }
                                    layoutParams.leftMargin = windowInsets.getSystemWindowInsetLeft();
                                    layoutParams.topMargin = windowInsets.getSystemWindowInsetTop();
                                    layoutParams.rightMargin = windowInsets.getSystemWindowInsetRight();
                                    layoutParams.bottomMargin = windowInsets.getSystemWindowInsetBottom();
                                }
                            }
                            if (aF(childAt)) {
                                childAt.measure(MeasureSpec.makeMeasureSpec((mode2 - layoutParams.leftMargin) - layoutParams.rightMargin, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec((mode - layoutParams.topMargin) - layoutParams.bottomMargin, ErrorDialogData.SUPPRESSED));
                            } else if (aG(childAt)) {
                                if (PW && s.ag(childAt) != this.PY) {
                                    s.h(childAt, this.PY);
                                }
                                absoluteGravity = aE(childAt) & 7;
                                Object obj4 = absoluteGravity == 3 ? 1 : null;
                                if ((obj4 == null || obj2 == null) && (obj4 != null || obj3 == null)) {
                                    if (obj4 != null) {
                                        obj2 = 1;
                                        obj4 = obj3;
                                    } else {
                                        obj4 = 1;
                                    }
                                    childAt.measure(getChildMeasureSpec(i, (this.PZ + layoutParams.leftMargin) + layoutParams.rightMargin, layoutParams.width), getChildMeasureSpec(i2, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                                    obj3 = obj4;
                                } else {
                                    String str;
                                    StringBuilder stringBuilder = new StringBuilder("Child drawer has absolute gravity ");
                                    if ((absoluteGravity & 3) == 3) {
                                        str = "LEFT";
                                    } else if ((absoluteGravity & 5) == 5) {
                                        str = "RIGHT";
                                    } else {
                                        str = Integer.toHexString(absoluteGravity);
                                    }
                                    throw new IllegalStateException(stringBuilder.append(str).append(" but this DrawerLayout already has a drawer view along that edge").toString());
                                }
                            } else {
                                throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                            }
                        }
                    }
                }
            }
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        }
        mode = size2;
        mode2 = size;
        setMeasuredDimension(mode2, mode);
        if (this.Qt == null) {
        }
        obj = null;
        T = s.T(this);
        obj2 = null;
        obj3 = null;
        childCount = getChildCount();
        while (i3 < childCount) {
        }
    }

    private static boolean c(Drawable drawable, int i) {
        if (drawable == null || !android.support.v4.a.a.a.b(drawable)) {
            return false;
        }
        android.support.v4.a.a.a.b(drawable, i);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (aF(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (t(childAt, 3)) {
                        i7 = ((int) (((float) measuredWidth) * layoutParams.QA)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i7)) / ((float) measuredWidth);
                    } else {
                        i7 = i5 - ((int) (((float) measuredWidth) * layoutParams.QA));
                        f = ((float) (i5 - i7)) / ((float) measuredWidth);
                    }
                    Object obj = f != layoutParams.QA ? 1 : null;
                    int i8;
                    switch (layoutParams.gravity & 112) {
                        case 16:
                            int i9 = i4 - i2;
                            i8 = (i9 - measuredHeight) / 2;
                            if (i8 < layoutParams.topMargin) {
                                i8 = layoutParams.topMargin;
                            } else if (i8 + measuredHeight > i9 - layoutParams.bottomMargin) {
                                i8 = (i9 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
                            break;
                        case 80:
                            i8 = i4 - i2;
                            childAt.layout(i7, (i8 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i8 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(i7, layoutParams.topMargin, measuredWidth + i7, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (obj != null) {
                        k(childAt, f);
                    }
                    int i10 = layoutParams.QA > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
        }
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).QA);
        }
        this.Qb = f;
        boolean eX = this.Qd.eX();
        boolean eX2 = this.Qe.eX();
        if (eX || eX2) {
            s.R(this);
        }
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.pC = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.pC;
    }

    public void setStatusBarBackground(int i) {
        this.pC = i != 0 ? android.support.v4.content.b.g(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.pC = new ColorDrawable(i);
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.pB && this.pC != null) {
            int systemWindowInsetTop = VERSION.SDK_INT >= 21 ? this.Qt != null ? ((WindowInsets) this.Qt).getSystemWindowInsetTop() : 0 : 0;
            if (systemWindowInsetTop > 0) {
                this.pC.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.pC.draw(canvas);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        int right;
        int height = getHeight();
        boolean aF = aF(view);
        int i = 0;
        int width = getWidth();
        int save = canvas.save();
        if (aF) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != view && childAt.getVisibility() == 0) {
                    Object obj;
                    Drawable background = childAt.getBackground();
                    if (background == null) {
                        obj = null;
                    } else if (background.getOpacity() == -1) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null && aG(childAt) && childAt.getHeight() >= height) {
                        if (t(childAt, 3)) {
                            right = childAt.getRight();
                            if (right <= i) {
                                right = i;
                            }
                            i = right;
                        } else {
                            right = childAt.getLeft();
                            if (right < width) {
                                width = right;
                            }
                        }
                    }
                }
            }
            canvas.clipRect(i, 0, width, getHeight());
        }
        right = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        float max;
        if (this.Qb > 0.0f && aF) {
            this.Qc.setColor((((int) (((float) ((this.Qa & WebView.NIGHT_MODE_COLOR) >>> 24)) * this.Qb)) << 24) | (this.Qa & 16777215));
            canvas.drawRect((float) i, 0.0f, (float) right, (float) getHeight(), this.Qc);
        } else if (this.Qp != null && t(view, 3)) {
            right = this.Qp.getIntrinsicWidth();
            i = view.getRight();
            max = Math.max(0.0f, Math.min(((float) i) / ((float) this.Qd.SR), 1.0f));
            this.Qp.setBounds(i, view.getTop(), right + i, view.getBottom());
            this.Qp.setAlpha((int) (255.0f * max));
            this.Qp.draw(canvas);
        } else if (this.Qq != null && t(view, 5)) {
            right = this.Qq.getIntrinsicWidth();
            i = view.getLeft();
            max = Math.max(0.0f, Math.min(((float) (getWidth() - i)) / ((float) this.Qe.SR), 1.0f));
            this.Qq.setBounds(i - right, view.getTop(), i, view.getBottom());
            this.Qq.setAlpha((int) (255.0f * max));
            this.Qq.draw(canvas);
        }
        return drawChild;
    }

    private static boolean aF(View view) {
        return ((LayoutParams) view.getLayoutParams()).gravity == 0;
    }

    static boolean aG(View view) {
        int absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, s.T(view));
        if ((absoluteGravity & 3) != 0) {
            return true;
        }
        if ((absoluteGravity & 5) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int f = this.Qe.f(motionEvent) | this.Qd.f(motionEvent);
        float y;
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                if (this.Qb > 0.0f) {
                    View F = this.Qd.F((int) x, (int) y);
                    if (F != null && aF(F)) {
                        z = true;
                        this.Qm = false;
                        this.Qn = false;
                        break;
                    }
                }
                z = false;
                this.Qm = false;
                this.Qn = false;
            case 1:
            case 3:
                J(true);
                this.Qm = false;
                this.Qn = false;
            case 2:
                t tVar = this.Qd;
                int length = tVar.SH.length;
                for (int i = 0; i < length; i++) {
                    boolean z2;
                    if (tVar.aZ(i)) {
                        y = tVar.SJ[i] - tVar.SH[i];
                        float f2 = tVar.SK[i] - tVar.SI[i];
                        z2 = (y * y) + (f2 * f2) > ((float) (tVar.mTouchSlop * tVar.mTouchSlop));
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z = true;
                        if (z) {
                            this.Qf.eD();
                            this.Qg.eD();
                            z = false;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                }
        }
        z = false;
        if (f == 0 && !z) {
            f = getChildCount();
            for (int i2 = 0; i2 < f; i2++) {
                if (((LayoutParams) getChildAt(i2).getLayoutParams()).QB) {
                    z = true;
                    if (!(z || this.Qn)) {
                        return false;
                    }
                }
            }
            z = false;
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.Qd.g(motionEvent);
        this.Qe.g(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                this.Qm = false;
                this.Qn = false;
                break;
            case 1:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View F = this.Qd.F((int) x, (int) y);
                if (F != null && aF(F)) {
                    x -= this.mInitialMotionX;
                    y -= this.mInitialMotionY;
                    int i = this.Qd.mTouchSlop;
                    if ((x * x) + (y * y) < ((float) (i * i))) {
                        View eF = eF();
                        if (eF != null) {
                            z = aC(eF) == 2;
                            J(z);
                            this.Qm = false;
                            break;
                        }
                    }
                }
                z = true;
                J(z);
                this.Qm = false;
            case 3:
                J(true);
                this.Qm = false;
                this.Qn = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.Qm = z;
        if (z) {
            J(true);
        }
    }

    private void J(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (aG(childAt) && (!z || layoutParams.QB)) {
                int width = childAt.getWidth();
                if (t(childAt, 3)) {
                    i |= this.Qd.h(childAt, -width, childAt.getTop());
                } else {
                    i |= this.Qe.h(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.QB = false;
            }
        }
        this.Qf.eD();
        this.Qg.eD();
        if (i != 0) {
            invalidate();
        }
    }

    private void aH(View view) {
        if (aG(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.mFirstLayout) {
                layoutParams.QA = 1.0f;
                layoutParams.QC = 1;
                f(view, true);
            } else {
                layoutParams.QC |= 2;
                if (t(view, 3)) {
                    this.Qd.h(view, 0, view.getTop());
                } else {
                    this.Qe.h(view, getWidth() - view.getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final void aI(View view) {
        if (aG(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.mFirstLayout) {
                layoutParams.QA = 0.0f;
                layoutParams.QC = 0;
            } else {
                layoutParams.QC |= 4;
                if (t(view, 3)) {
                    this.Qd.h(view, -view.getWidth(), view.getTop());
                } else {
                    this.Qe.h(view, getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    /* Access modifiers changed, original: protected */
    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* Access modifiers changed, original: protected */
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            int i3 = 0;
            Object obj = null;
            while (i3 < childCount) {
                Object obj2;
                View childAt = getChildAt(i3);
                if (!aG(childAt)) {
                    this.Qy.add(childAt);
                    obj2 = obj;
                } else if (aG(childAt)) {
                    if ((((LayoutParams) childAt.getLayoutParams()).QC & 1) == 1) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        childAt.addFocusables(arrayList, i, i2);
                        obj2 = 1;
                    }
                    obj2 = obj;
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
                i3++;
                obj = obj2;
            }
            if (obj == null) {
                int size = this.Qy.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = (View) this.Qy.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.Qy.clear();
        }
    }

    /* Access modifiers changed, original: final */
    public final View eG() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (aG(childAt)) {
                if (aG(childAt)) {
                    Object obj;
                    if (((LayoutParams) childAt.getLayoutParams()).QA > 0.0f) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        return childAt;
                    }
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
            }
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z;
            if (eG() != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                keyEvent.startTracking();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View eG = eG();
        if (eG != null && aC(eG) == 0) {
            J(false);
        }
        if (eG != null) {
            return true;
        }
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.LC);
            if (savedState.QD != 0) {
                View aS = aS(savedState.QD);
                if (aS != null) {
                    aH(aS);
                }
            }
            if (savedState.QE != 3) {
                y(savedState.QE, 3);
            }
            if (savedState.QF != 3) {
                y(savedState.QF, 5);
            }
            if (savedState.QG != 3) {
                y(savedState.QG, 8388611);
            }
            if (savedState.QH != 3) {
                y(savedState.QH, 8388613);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            Object obj = layoutParams.QC == 1 ? 1 : null;
            Object obj2;
            if (layoutParams.QC == 2) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj != null || obj2 != null) {
                savedState.QD = layoutParams.gravity;
                break;
            }
        }
        savedState.QE = this.Qi;
        savedState.QF = this.Qj;
        savedState.QG = this.Qk;
        savedState.QH = this.Ql;
        return savedState;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (eF() != null || aG(view)) {
            s.o(view, 4);
        } else {
            s.o(view, 1);
        }
        if (!PV) {
            s.a(view, this.PX);
        }
    }

    static boolean aJ(View view) {
        return (s.S(view) == 4 || s.S(view) == 2) ? false : true;
    }

    public void onRtlPropertiesChanged(int i) {
        if (!PW) {
            Drawable drawable;
            int T = s.T(this);
            if (T == 0) {
                if (this.Qu != null) {
                    c(this.Qu, T);
                    drawable = this.Qu;
                }
                drawable = this.Qw;
            } else {
                if (this.Qv != null) {
                    c(this.Qv, T);
                    drawable = this.Qv;
                }
                drawable = this.Qw;
            }
            this.Qp = drawable;
            T = s.T(this);
            if (T == 0) {
                if (this.Qv != null) {
                    c(this.Qv, T);
                    drawable = this.Qv;
                }
                drawable = this.Qx;
            } else {
                if (this.Qu != null) {
                    c(this.Qu, T);
                    drawable = this.Qu;
                }
                drawable = this.Qx;
            }
            this.Qq = drawable;
        }
    }
}
