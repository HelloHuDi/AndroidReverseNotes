package android.support.p057v4.widget;

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
import android.support.p057v4.content.C0380b;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.view.AbsSavedState;
import android.support.p057v4.view.C0449a;
import android.support.p057v4.view.C0456d;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.p067a.C0445b;
import android.support.p057v4.view.p067a.C0445b.C0442a;
import android.support.p057v4.widget.C0553t.C0552a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.util.ActUtil;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.widget.DrawerLayout */
public class DrawerLayout extends ViewGroup {
    static final int[] LAYOUT_ATTRS = new int[]{16842931};
    /* renamed from: PU */
    private static final int[] f597PU = new int[]{16843828};
    /* renamed from: PV */
    static final boolean f598PV;
    /* renamed from: PW */
    private static final boolean f599PW;
    /* renamed from: PX */
    private final C0506b f600PX;
    /* renamed from: PY */
    private float f601PY;
    /* renamed from: PZ */
    private int f602PZ;
    /* renamed from: Qa */
    private int f603Qa;
    /* renamed from: Qb */
    private float f604Qb;
    /* renamed from: Qc */
    private Paint f605Qc;
    /* renamed from: Qd */
    final C0553t f606Qd;
    /* renamed from: Qe */
    final C0553t f607Qe;
    /* renamed from: Qf */
    private final C0507d f608Qf;
    /* renamed from: Qg */
    private final C0507d f609Qg;
    /* renamed from: Qh */
    int f610Qh;
    /* renamed from: Qi */
    private int f611Qi;
    /* renamed from: Qj */
    private int f612Qj;
    /* renamed from: Qk */
    private int f613Qk;
    /* renamed from: Ql */
    private int f614Ql;
    /* renamed from: Qm */
    private boolean f615Qm;
    /* renamed from: Qn */
    boolean f616Qn;
    /* renamed from: Qo */
    private C0503c f617Qo;
    /* renamed from: Qp */
    private Drawable f618Qp;
    /* renamed from: Qq */
    private Drawable f619Qq;
    /* renamed from: Qr */
    CharSequence f620Qr;
    /* renamed from: Qs */
    CharSequence f621Qs;
    /* renamed from: Qt */
    Object f622Qt;
    /* renamed from: Qu */
    private Drawable f623Qu;
    /* renamed from: Qv */
    private Drawable f624Qv;
    /* renamed from: Qw */
    private Drawable f625Qw;
    /* renamed from: Qx */
    private Drawable f626Qx;
    /* renamed from: Qy */
    private final ArrayList<View> f627Qy;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    /* renamed from: mq */
    List<C0503c> f628mq;
    /* renamed from: pB */
    boolean f629pB;
    /* renamed from: pC */
    private Drawable f630pC;

    /* renamed from: android.support.v4.widget.DrawerLayout$1 */
    class C05011 implements OnApplyWindowInsetsListener {
        C05011() {
        }

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
            drawerLayout.f622Qt = windowInsets;
            drawerLayout.f629pB = z;
            if (z || drawerLayout.getBackground() != null) {
                z2 = false;
            }
            drawerLayout.setWillNotDraw(z2);
            drawerLayout.requestLayout();
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$LayoutParams */
    public static class LayoutParams extends MarginLayoutParams {
        /* renamed from: QA */
        float f593QA;
        /* renamed from: QB */
        boolean f594QB;
        /* renamed from: QC */
        int f595QC;
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

    /* renamed from: android.support.v4.widget.DrawerLayout$c */
    public interface C0503c {
        /* renamed from: E */
        void mo1172E(float f);

        /* renamed from: eH */
        void mo1173eH();

        /* renamed from: eI */
        void mo1174eI();
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$SavedState */
    protected static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C05021();
        /* renamed from: QD */
        int f631QD = 0;
        /* renamed from: QE */
        int f632QE;
        /* renamed from: QF */
        int f633QF;
        /* renamed from: QG */
        int f634QG;
        /* renamed from: QH */
        int f635QH;

        /* renamed from: android.support.v4.widget.DrawerLayout$SavedState$1 */
        static class C05021 implements ClassLoaderCreator<SavedState> {
            C05021() {
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f631QD = parcel.readInt();
            this.f632QE = parcel.readInt();
            this.f633QF = parcel.readInt();
            this.f634QG = parcel.readInt();
            this.f635QH = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f631QD);
            parcel.writeInt(this.f632QE);
            parcel.writeInt(this.f633QF);
            parcel.writeInt(this.f634QG);
            parcel.writeInt(this.f635QH);
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$a */
    class C0505a extends C0449a {
        /* renamed from: oT */
        private final Rect f637oT = new Rect();

        C0505a() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, C0445b c0445b) {
            if (DrawerLayout.f598PV) {
                super.onInitializeAccessibilityNodeInfo(view, c0445b);
            } else {
                C0445b a = C0445b.m770a(c0445b);
                super.onInitializeAccessibilityNodeInfo(view, a);
                c0445b.setSource(view);
                ViewParent U = C0477s.m894U(view);
                if (U instanceof View) {
                    c0445b.setParent((View) U);
                }
                Rect rect = this.f637oT;
                a.getBoundsInParent(rect);
                c0445b.setBoundsInParent(rect);
                a.getBoundsInScreen(rect);
                c0445b.setBoundsInScreen(rect);
                c0445b.setVisibleToUser(a.isVisibleToUser());
                c0445b.setPackageName(a.f546NG.getPackageName());
                c0445b.setClassName(a.f546NG.getClassName());
                c0445b.setContentDescription(a.f546NG.getContentDescription());
                c0445b.setEnabled(a.f546NG.isEnabled());
                c0445b.setClickable(a.f546NG.isClickable());
                c0445b.setFocusable(a.f546NG.isFocusable());
                c0445b.setFocused(a.f546NG.isFocused());
                c0445b.setAccessibilityFocused(a.isAccessibilityFocused());
                c0445b.setSelected(a.f546NG.isSelected());
                c0445b.setLongClickable(a.f546NG.isLongClickable());
                c0445b.addAction(a.f546NG.getActions());
                a.f546NG.recycle();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (DrawerLayout.m1061aJ(childAt)) {
                        c0445b.addChild(childAt);
                    }
                }
            }
            c0445b.setClassName(DrawerLayout.class.getName());
            c0445b.setFocusable(false);
            c0445b.setFocused(false);
            c0445b.mo986a(C0442a.f513NI);
            c0445b.mo986a(C0442a.f514NJ);
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
            View eG = DrawerLayout.this.mo1185eG();
            if (eG != null) {
                Object obj;
                int aE = DrawerLayout.this.mo1177aE(eG);
                DrawerLayout drawerLayout = DrawerLayout.this;
                aE = C0456d.getAbsoluteGravity(aE, C0477s.m893T(drawerLayout));
                if (aE == 3) {
                    obj = drawerLayout.f620Qr;
                } else if (aE == 5) {
                    obj = drawerLayout.f621Qs;
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
            if (DrawerLayout.f598PV || DrawerLayout.m1061aJ(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$b */
    static final class C0506b extends C0449a {
        C0506b() {
        }

        public final void onInitializeAccessibilityNodeInfo(View view, C0445b c0445b) {
            super.onInitializeAccessibilityNodeInfo(view, c0445b);
            if (!DrawerLayout.m1061aJ(view)) {
                c0445b.setParent(null);
            }
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout$d */
    class C0507d extends C0552a {
        /* renamed from: QI */
        final int f638QI;
        /* renamed from: QJ */
        C0553t f639QJ;
        /* renamed from: QK */
        private final Runnable f640QK = new C05041();

        /* renamed from: android.support.v4.widget.DrawerLayout$d$1 */
        class C05041 implements Runnable {
            C05041() {
            }

            public final void run() {
                View aS;
                int i = 0;
                C0507d c0507d = C0507d.this;
                int i2 = c0507d.f639QJ.f728SR;
                boolean z = c0507d.f638QI == 3;
                if (z) {
                    int i3;
                    aS = DrawerLayout.this.mo1179aS(3);
                    if (aS != null) {
                        i3 = -aS.getWidth();
                    } else {
                        i3 = 0;
                    }
                    i2 = i3 + i2;
                } else {
                    i2 = DrawerLayout.this.getWidth() - i2;
                    aS = DrawerLayout.this.mo1179aS(5);
                }
                if (aS == null) {
                    return;
                }
                if (((z && aS.getLeft() < i2) || (!z && aS.getLeft() > i2)) && DrawerLayout.this.mo1176aC(aS) == 0) {
                    LayoutParams layoutParams = (LayoutParams) aS.getLayoutParams();
                    c0507d.f639QJ.mo1325h(aS, i2, aS.getTop());
                    layoutParams.f594QB = true;
                    DrawerLayout.this.invalidate();
                    c0507d.mo1222eJ();
                    DrawerLayout drawerLayout = DrawerLayout.this;
                    if (!drawerLayout.f616Qn) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        int childCount = drawerLayout.getChildCount();
                        while (i < childCount) {
                            drawerLayout.getChildAt(i).dispatchTouchEvent(obtain);
                            i++;
                        }
                        obtain.recycle();
                        drawerLayout.f616Qn = true;
                    }
                }
            }
        }

        C0507d(int i) {
            this.f638QI = i;
        }

        /* renamed from: eD */
        public final void mo1221eD() {
            DrawerLayout.this.removeCallbacks(this.f640QK);
        }

        /* renamed from: b */
        public final boolean mo1218b(View view, int i) {
            return DrawerLayout.m1059aG(view) && DrawerLayout.this.mo1214t(view, this.f638QI) && DrawerLayout.this.mo1176aC(view) == 0;
        }

        /* renamed from: N */
        public final void mo1215N(int i) {
            DrawerLayout drawerLayout = DrawerLayout.this;
            View view = this.f639QJ.f731SU;
            int i2 = drawerLayout.f606Qd.f717SG;
            int i3 = drawerLayout.f607Qe.f717SG;
            if (i2 == 1 || i3 == 1) {
                i3 = 1;
            } else if (i2 == 2 || i3 == 2) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            if (view != null && i == 0) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.f593QA == 0.0f) {
                    layoutParams = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams.f595QC & 1) == 1) {
                        layoutParams.f595QC = 0;
                        if (drawerLayout.f628mq != null) {
                            for (i2 = drawerLayout.f628mq.size() - 1; i2 >= 0; i2--) {
                                ((C0503c) drawerLayout.f628mq.get(i2)).mo1174eI();
                            }
                        }
                        drawerLayout.mo1186f(view, false);
                        if (drawerLayout.hasWindowFocus()) {
                            View rootView = drawerLayout.getRootView();
                            if (rootView != null) {
                                rootView.sendAccessibilityEvent(32);
                            }
                        }
                    }
                } else if (layoutParams.f593QA == 1.0f) {
                    layoutParams = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams.f595QC & 1) == 0) {
                        layoutParams.f595QC = 1;
                        if (drawerLayout.f628mq != null) {
                            for (i2 = drawerLayout.f628mq.size() - 1; i2 >= 0; i2--) {
                                ((C0503c) drawerLayout.f628mq.get(i2)).mo1173eH();
                            }
                        }
                        drawerLayout.mo1186f(view, true);
                        if (drawerLayout.hasWindowFocus()) {
                            drawerLayout.sendAccessibilityEvent(32);
                        }
                    }
                }
            }
            if (i3 != drawerLayout.f610Qh) {
                drawerLayout.f610Qh = i3;
                if (drawerLayout.f628mq != null) {
                    for (int size = drawerLayout.f628mq.size() - 1; size >= 0; size--) {
                        drawerLayout.f628mq.get(size);
                    }
                }
            }
        }

        /* renamed from: b */
        public final void mo1217b(View view, int i, int i2) {
            float f;
            int width = view.getWidth();
            if (DrawerLayout.this.mo1214t(view, 3)) {
                f = ((float) (width + i)) / ((float) width);
            } else {
                f = ((float) (DrawerLayout.this.getWidth() - i)) / ((float) width);
            }
            DrawerLayout.this.mo1192k(view, f);
            view.setVisibility(f == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        /* renamed from: k */
        public final void mo1224k(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).f594QB = false;
            mo1222eJ();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: eJ */
        public final void mo1222eJ() {
            int i = 3;
            if (this.f638QI == 3) {
                i = 5;
            }
            View aS = DrawerLayout.this.mo1179aS(i);
            if (aS != null) {
                DrawerLayout.this.mo1178aI(aS);
            }
        }

        /* renamed from: a */
        public final void mo1216a(View view, float f, float f2) {
            int i;
            float aD = DrawerLayout.m1057aD(view);
            int width = view.getWidth();
            if (DrawerLayout.this.mo1214t(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && aD > 0.5f)) ? 0 : -width;
            } else {
                i = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && aD > 0.5f)) {
                    i -= width;
                }
            }
            this.f639QJ.mo1316D(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        /* renamed from: eK */
        public final void mo1223eK() {
            DrawerLayout.this.postDelayed(this.f640QK, 160);
        }

        /* renamed from: z */
        public final void mo1226z(int i, int i2) {
            View aS;
            if ((i & 1) == 1) {
                aS = DrawerLayout.this.mo1179aS(3);
            } else {
                aS = DrawerLayout.this.mo1179aS(5);
            }
            if (aS != null && DrawerLayout.this.mo1176aC(aS) == 0) {
                this.f639QJ.mo1326u(aS, i2);
            }
        }

        /* renamed from: s */
        public final int mo1225s(View view) {
            return DrawerLayout.m1059aG(view) ? view.getWidth() : 0;
        }

        /* renamed from: d */
        public final int mo1220d(View view, int i) {
            if (DrawerLayout.this.mo1214t(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        /* renamed from: c */
        public final int mo1219c(View view, int i) {
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
        f598PV = z;
        if (VERSION.SDK_INT < 21) {
            z2 = false;
        }
        f599PW = z2;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f600PX = new C0506b();
        this.f603Qa = -1728053248;
        this.f605Qc = new Paint();
        this.mFirstLayout = true;
        this.f611Qi = 3;
        this.f612Qj = 3;
        this.f613Qk = 3;
        this.f614Ql = 3;
        this.f623Qu = null;
        this.f624Qv = null;
        this.f625Qw = null;
        this.f626Qx = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f602PZ = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.f608Qf = new C0507d(3);
        this.f609Qg = new C0507d(5);
        this.f606Qd = C0553t.m1196a((ViewGroup) this, 1.0f, this.f608Qf);
        this.f606Qd.f729SS = 1;
        this.f606Qd.f727SQ = f2;
        this.f608Qf.f639QJ = this.f606Qd;
        this.f607Qe = C0553t.m1196a((ViewGroup) this, 1.0f, this.f609Qg);
        this.f607Qe.f729SS = 2;
        this.f607Qe.f727SQ = f2;
        this.f609Qg.f639QJ = this.f607Qe;
        setFocusableInTouchMode(true);
        C0477s.m949o(this, 1);
        C0477s.m905a((View) this, new C0505a());
        setMotionEventSplittingEnabled(false);
        if (C0477s.m920al(this)) {
            if (VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new C05011());
                setSystemUiVisibility(ActUtil.HEIGHT);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f597PU);
                try {
                    this.f630pC = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.f630pC = null;
            }
        }
        this.f601PY = f * 10.0f;
        this.f627Qy = new ArrayList();
    }

    public void setDrawerElevation(float f) {
        this.f601PY = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (DrawerLayout.m1059aG(childAt)) {
                C0477s.m945h(childAt, this.f601PY);
            }
        }
    }

    public float getDrawerElevation() {
        if (f599PW) {
            return this.f601PY;
        }
        return 0.0f;
    }

    public void setScrimColor(int i) {
        this.f603Qa = i;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(C0503c c0503c) {
        if (this.f617Qo != null) {
            C0503c c0503c2 = this.f617Qo;
            if (!(c0503c2 == null || this.f628mq == null)) {
                this.f628mq.remove(c0503c2);
            }
        }
        if (!(c0503c == null || c0503c == null)) {
            if (this.f628mq == null) {
                this.f628mq = new ArrayList();
            }
            this.f628mq.add(c0503c);
        }
        this.f617Qo = c0503c;
    }

    public void setDrawerLockMode(int i) {
        m1064y(i, 3);
        m1064y(i, 5);
    }

    /* renamed from: y */
    private void m1064y(int i, int i2) {
        int absoluteGravity = C0456d.getAbsoluteGravity(i2, C0477s.m893T(this));
        switch (i2) {
            case 3:
                this.f611Qi = i;
                break;
            case 5:
                this.f612Qj = i;
                break;
            case 8388611:
                this.f613Qk = i;
                break;
            case 8388613:
                this.f614Ql = i;
                break;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.f606Qd : this.f607Qe).cancel();
        }
        View aS;
        switch (i) {
            case 1:
                aS = mo1179aS(absoluteGravity);
                if (aS != null) {
                    mo1178aI(aS);
                    return;
                }
                return;
            case 2:
                aS = mo1179aS(absoluteGravity);
                if (aS != null) {
                    m1060aH(aS);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: aC */
    public final int mo1176aC(View view) {
        if (DrawerLayout.m1059aG(view)) {
            int i = ((LayoutParams) view.getLayoutParams()).gravity;
            int T = C0477s.m893T(this);
            switch (i) {
                case 3:
                    if (this.f611Qi != 3) {
                        return this.f611Qi;
                    }
                    i = T == 0 ? this.f613Qk : this.f614Ql;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 5:
                    if (this.f612Qj != 3) {
                        return this.f612Qj;
                    }
                    i = T == 0 ? this.f614Ql : this.f613Qk;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 8388611:
                    if (this.f613Qk != 3) {
                        return this.f613Qk;
                    }
                    i = T == 0 ? this.f611Qi : this.f612Qj;
                    if (i != 3) {
                        return i;
                    }
                    break;
                case 8388613:
                    if (this.f614Ql != 3) {
                        return this.f614Ql;
                    }
                    i = T == 0 ? this.f612Qj : this.f611Qi;
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
    /* renamed from: f */
    public final void mo1186f(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || DrawerLayout.m1059aG(childAt)) && !(z && childAt == view)) {
                C0477s.m949o(childAt, 4);
            } else {
                C0477s.m949o(childAt, 1);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: k */
    public final void mo1192k(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.f593QA) {
            layoutParams.f593QA = f;
            if (this.f628mq != null) {
                for (int size = this.f628mq.size() - 1; size >= 0; size--) {
                    ((C0503c) this.f628mq.get(size)).mo1172E(f);
                }
            }
        }
    }

    /* renamed from: aD */
    static float m1057aD(View view) {
        return ((LayoutParams) view.getLayoutParams()).f593QA;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: aE */
    public final int mo1177aE(View view) {
        return C0456d.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, C0477s.m893T(this));
    }

    /* Access modifiers changed, original: final */
    /* renamed from: t */
    public final boolean mo1214t(View view, int i) {
        return (mo1177aE(view) & i) == i;
    }

    /* renamed from: eF */
    private View m1063eF() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).f595QC & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: aS */
    public final View mo1179aS(int i) {
        int absoluteGravity = C0456d.getAbsoluteGravity(i, C0477s.m893T(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((mo1177aE(childAt) & 7) == absoluteGravity) {
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
                if (mode != C8415j.INVALID_ID && mode == 0) {
                    size = 300;
                }
                if (mode2 != C8415j.INVALID_ID && mode2 == 0) {
                    mode = 300;
                    mode2 = size;
                    setMeasuredDimension(mode2, mode);
                    if (this.f622Qt == null && C0477s.m920al(this)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    T = C0477s.m893T(this);
                    obj2 = null;
                    obj3 = null;
                    childCount = getChildCount();
                    for (i3 = 0; i3 < childCount; i3++) {
                        View childAt = getChildAt(i3);
                        if (childAt.getVisibility() != 8) {
                            int absoluteGravity;
                            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                            if (obj != null) {
                                absoluteGravity = C0456d.getAbsoluteGravity(layoutParams.gravity, T);
                                WindowInsets windowInsets;
                                if (C0477s.m920al(childAt)) {
                                    if (VERSION.SDK_INT >= 21) {
                                        windowInsets = (WindowInsets) this.f622Qt;
                                        if (absoluteGravity == 3) {
                                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                                        } else if (absoluteGravity == 5) {
                                            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                                        }
                                        childAt.dispatchApplyWindowInsets(windowInsets);
                                    }
                                } else if (VERSION.SDK_INT >= 21) {
                                    windowInsets = (WindowInsets) this.f622Qt;
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
                            if (DrawerLayout.m1058aF(childAt)) {
                                childAt.measure(MeasureSpec.makeMeasureSpec((mode2 - layoutParams.leftMargin) - layoutParams.rightMargin, ErrorDialogData.SUPPRESSED), MeasureSpec.makeMeasureSpec((mode - layoutParams.topMargin) - layoutParams.bottomMargin, ErrorDialogData.SUPPRESSED));
                            } else if (DrawerLayout.m1059aG(childAt)) {
                                if (f599PW && C0477s.m915ag(childAt) != this.f601PY) {
                                    C0477s.m945h(childAt, this.f601PY);
                                }
                                absoluteGravity = mo1177aE(childAt) & 7;
                                Object obj4 = absoluteGravity == 3 ? 1 : null;
                                if ((obj4 == null || obj2 == null) && (obj4 != null || obj3 == null)) {
                                    if (obj4 != null) {
                                        obj2 = 1;
                                        obj4 = obj3;
                                    } else {
                                        obj4 = 1;
                                    }
                                    childAt.measure(DrawerLayout.getChildMeasureSpec(i, (this.f602PZ + layoutParams.leftMargin) + layoutParams.rightMargin, layoutParams.width), DrawerLayout.getChildMeasureSpec(i2, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
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
        if (this.f622Qt == null) {
        }
        obj = null;
        T = C0477s.m893T(this);
        obj2 = null;
        obj3 = null;
        childCount = getChildCount();
        while (i3 < childCount) {
        }
    }

    /* renamed from: c */
    private static boolean m1062c(Drawable drawable, int i) {
        if (drawable == null || !C0280a.m462b(drawable)) {
            return false;
        }
        C0280a.m463b(drawable, i);
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
                if (DrawerLayout.m1058aF(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (mo1214t(childAt, 3)) {
                        i7 = ((int) (((float) measuredWidth) * layoutParams.f593QA)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i7)) / ((float) measuredWidth);
                    } else {
                        i7 = i5 - ((int) (((float) measuredWidth) * layoutParams.f593QA));
                        f = ((float) (i5 - i7)) / ((float) measuredWidth);
                    }
                    Object obj = f != layoutParams.f593QA ? 1 : null;
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
                        mo1192k(childAt, f);
                    }
                    int i10 = layoutParams.f593QA > 0.0f ? 0 : 4;
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
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).f593QA);
        }
        this.f604Qb = f;
        boolean eX = this.f606Qd.mo1322eX();
        boolean eX2 = this.f607Qe.mo1322eX();
        if (eX || eX2) {
            C0477s.m891R(this);
        }
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f630pC = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f630pC;
    }

    public void setStatusBarBackground(int i) {
        this.f630pC = i != 0 ? C0380b.m649g(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.f630pC = new ColorDrawable(i);
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f629pB && this.f630pC != null) {
            int systemWindowInsetTop = VERSION.SDK_INT >= 21 ? this.f622Qt != null ? ((WindowInsets) this.f622Qt).getSystemWindowInsetTop() : 0 : 0;
            if (systemWindowInsetTop > 0) {
                this.f630pC.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.f630pC.draw(canvas);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        int right;
        int height = getHeight();
        boolean aF = DrawerLayout.m1058aF(view);
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
                    if (obj != null && DrawerLayout.m1059aG(childAt) && childAt.getHeight() >= height) {
                        if (mo1214t(childAt, 3)) {
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
        if (this.f604Qb > 0.0f && aF) {
            this.f605Qc.setColor((((int) (((float) ((this.f603Qa & WebView.NIGHT_MODE_COLOR) >>> 24)) * this.f604Qb)) << 24) | (this.f603Qa & 16777215));
            canvas.drawRect((float) i, 0.0f, (float) right, (float) getHeight(), this.f605Qc);
        } else if (this.f618Qp != null && mo1214t(view, 3)) {
            right = this.f618Qp.getIntrinsicWidth();
            i = view.getRight();
            max = Math.max(0.0f, Math.min(((float) i) / ((float) this.f606Qd.f728SR), 1.0f));
            this.f618Qp.setBounds(i, view.getTop(), right + i, view.getBottom());
            this.f618Qp.setAlpha((int) (255.0f * max));
            this.f618Qp.draw(canvas);
        } else if (this.f619Qq != null && mo1214t(view, 5)) {
            right = this.f619Qq.getIntrinsicWidth();
            i = view.getLeft();
            max = Math.max(0.0f, Math.min(((float) (getWidth() - i)) / ((float) this.f607Qe.f728SR), 1.0f));
            this.f619Qq.setBounds(i - right, view.getTop(), i, view.getBottom());
            this.f619Qq.setAlpha((int) (255.0f * max));
            this.f619Qq.draw(canvas);
        }
        return drawChild;
    }

    /* renamed from: aF */
    private static boolean m1058aF(View view) {
        return ((LayoutParams) view.getLayoutParams()).gravity == 0;
    }

    /* renamed from: aG */
    static boolean m1059aG(View view) {
        int absoluteGravity = C0456d.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, C0477s.m893T(view));
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
        int f = this.f607Qe.mo1323f(motionEvent) | this.f606Qd.mo1323f(motionEvent);
        float y;
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                if (this.f604Qb > 0.0f) {
                    View F = this.f606Qd.mo1317F((int) x, (int) y);
                    if (F != null && DrawerLayout.m1058aF(F)) {
                        z = true;
                        this.f615Qm = false;
                        this.f616Qn = false;
                        break;
                    }
                }
                z = false;
                this.f615Qm = false;
                this.f616Qn = false;
            case 1:
            case 3:
                m1056J(true);
                this.f615Qm = false;
                this.f616Qn = false;
            case 2:
                C0553t c0553t = this.f606Qd;
                int length = c0553t.f718SH.length;
                for (int i = 0; i < length; i++) {
                    boolean z2;
                    if (c0553t.mo1318aZ(i)) {
                        y = c0553t.f720SJ[i] - c0553t.f718SH[i];
                        float f2 = c0553t.f721SK[i] - c0553t.f719SI[i];
                        z2 = (y * y) + (f2 * f2) > ((float) (c0553t.mTouchSlop * c0553t.mTouchSlop));
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z = true;
                        if (z) {
                            this.f608Qf.mo1221eD();
                            this.f609Qg.mo1221eD();
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
                if (((LayoutParams) getChildAt(i2).getLayoutParams()).f594QB) {
                    z = true;
                    if (!(z || this.f616Qn)) {
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
        this.f606Qd.mo1324g(motionEvent);
        this.f607Qe.mo1324g(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                this.f615Qm = false;
                this.f616Qn = false;
                break;
            case 1:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View F = this.f606Qd.mo1317F((int) x, (int) y);
                if (F != null && DrawerLayout.m1058aF(F)) {
                    x -= this.mInitialMotionX;
                    y -= this.mInitialMotionY;
                    int i = this.f606Qd.mTouchSlop;
                    if ((x * x) + (y * y) < ((float) (i * i))) {
                        View eF = m1063eF();
                        if (eF != null) {
                            z = mo1176aC(eF) == 2;
                            m1056J(z);
                            this.f615Qm = false;
                            break;
                        }
                    }
                }
                z = true;
                m1056J(z);
                this.f615Qm = false;
            case 3:
                m1056J(true);
                this.f615Qm = false;
                this.f616Qn = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f615Qm = z;
        if (z) {
            m1056J(true);
        }
    }

    /* renamed from: J */
    private void m1056J(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (DrawerLayout.m1059aG(childAt) && (!z || layoutParams.f594QB)) {
                int width = childAt.getWidth();
                if (mo1214t(childAt, 3)) {
                    i |= this.f606Qd.mo1325h(childAt, -width, childAt.getTop());
                } else {
                    i |= this.f607Qe.mo1325h(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.f594QB = false;
            }
        }
        this.f608Qf.mo1221eD();
        this.f609Qg.mo1221eD();
        if (i != 0) {
            invalidate();
        }
    }

    /* renamed from: aH */
    private void m1060aH(View view) {
        if (DrawerLayout.m1059aG(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.mFirstLayout) {
                layoutParams.f593QA = 1.0f;
                layoutParams.f595QC = 1;
                mo1186f(view, true);
            } else {
                layoutParams.f595QC |= 2;
                if (mo1214t(view, 3)) {
                    this.f606Qd.mo1325h(view, 0, view.getTop());
                } else {
                    this.f607Qe.mo1325h(view, getWidth() - view.getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    /* renamed from: aI */
    public final void mo1178aI(View view) {
        if (DrawerLayout.m1059aG(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.mFirstLayout) {
                layoutParams.f593QA = 0.0f;
                layoutParams.f595QC = 0;
            } else {
                layoutParams.f595QC |= 4;
                if (mo1214t(view, 3)) {
                    this.f606Qd.mo1325h(view, -view.getWidth(), view.getTop());
                } else {
                    this.f607Qe.mo1325h(view, getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
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
                if (!DrawerLayout.m1059aG(childAt)) {
                    this.f627Qy.add(childAt);
                    obj2 = obj;
                } else if (DrawerLayout.m1059aG(childAt)) {
                    if ((((LayoutParams) childAt.getLayoutParams()).f595QC & 1) == 1) {
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
                int size = this.f627Qy.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = (View) this.f627Qy.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.f627Qy.clear();
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: eG */
    public final View mo1185eG() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (DrawerLayout.m1059aG(childAt)) {
                if (DrawerLayout.m1059aG(childAt)) {
                    Object obj;
                    if (((LayoutParams) childAt.getLayoutParams()).f593QA > 0.0f) {
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
            if (mo1185eG() != null) {
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
        View eG = mo1185eG();
        if (eG != null && mo1176aC(eG) == 0) {
            m1056J(false);
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
            super.onRestoreInstanceState(savedState.f507LC);
            if (savedState.f631QD != 0) {
                View aS = mo1179aS(savedState.f631QD);
                if (aS != null) {
                    m1060aH(aS);
                }
            }
            if (savedState.f632QE != 3) {
                m1064y(savedState.f632QE, 3);
            }
            if (savedState.f633QF != 3) {
                m1064y(savedState.f633QF, 5);
            }
            if (savedState.f634QG != 3) {
                m1064y(savedState.f634QG, 8388611);
            }
            if (savedState.f635QH != 3) {
                m1064y(savedState.f635QH, 8388613);
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
            Object obj = layoutParams.f595QC == 1 ? 1 : null;
            Object obj2;
            if (layoutParams.f595QC == 2) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj != null || obj2 != null) {
                savedState.f631QD = layoutParams.gravity;
                break;
            }
        }
        savedState.f632QE = this.f611Qi;
        savedState.f633QF = this.f612Qj;
        savedState.f634QG = this.f613Qk;
        savedState.f635QH = this.f614Ql;
        return savedState;
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (m1063eF() != null || DrawerLayout.m1059aG(view)) {
            C0477s.m949o(view, 4);
        } else {
            C0477s.m949o(view, 1);
        }
        if (!f598PV) {
            C0477s.m905a(view, this.f600PX);
        }
    }

    /* renamed from: aJ */
    static boolean m1061aJ(View view) {
        return (C0477s.m892S(view) == 4 || C0477s.m892S(view) == 2) ? false : true;
    }

    public void onRtlPropertiesChanged(int i) {
        if (!f599PW) {
            Drawable drawable;
            int T = C0477s.m893T(this);
            if (T == 0) {
                if (this.f623Qu != null) {
                    DrawerLayout.m1062c(this.f623Qu, T);
                    drawable = this.f623Qu;
                }
                drawable = this.f625Qw;
            } else {
                if (this.f624Qv != null) {
                    DrawerLayout.m1062c(this.f624Qv, T);
                    drawable = this.f624Qv;
                }
                drawable = this.f625Qw;
            }
            this.f618Qp = drawable;
            T = C0477s.m893T(this);
            if (T == 0) {
                if (this.f624Qv != null) {
                    DrawerLayout.m1062c(this.f624Qv, T);
                    drawable = this.f624Qv;
                }
                drawable = this.f626Qx;
            } else {
                if (this.f623Qu != null) {
                    DrawerLayout.m1062c(this.f623Qu, T);
                    drawable = this.f623Qu;
                }
                drawable = this.f626Qx;
            }
            this.f619Qq = drawable;
        }
    }
}
