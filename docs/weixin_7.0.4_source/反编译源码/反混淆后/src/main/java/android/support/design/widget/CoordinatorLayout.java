package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import android.support.p057v4.p065f.C37121i;
import android.support.p057v4.p065f.C37122k.C25335c;
import android.support.p057v4.p065f.C37122k.C8387a;
import android.support.p057v4.view.AbsSavedState;
import android.support.p057v4.view.C0451aa;
import android.support.p057v4.view.C0456d;
import android.support.p057v4.view.C0471n;
import android.support.p057v4.view.C0472o;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.C6202m;
import android.support.p057v4.widget.C17467h;
import android.support.p057v4.widget.C31872u;
import android.support.p1153b.C17364a.C17365a;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.p177mm.C25738R;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.util.ActUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements C6202m {
    /* renamed from: pk */
    static final String f16713pk;
    /* renamed from: pl */
    static final Class<?>[] f16714pl = new Class[]{Context.class, AttributeSet.class};
    /* renamed from: pm */
    static final ThreadLocal<Map<String, Constructor<Behavior>>> f16715pm = new ThreadLocal();
    /* renamed from: pn */
    static final Comparator<View> f16716pn;
    /* renamed from: po */
    private static final C8387a<Rect> f16717po = new C25335c(12);
    /* renamed from: mp */
    C0451aa f16718mp;
    /* renamed from: pA */
    private boolean f16719pA;
    /* renamed from: pB */
    boolean f16720pB;
    /* renamed from: pC */
    private Drawable f16721pC;
    /* renamed from: pD */
    OnHierarchyChangeListener f16722pD;
    /* renamed from: pE */
    private C0472o f16723pE;
    /* renamed from: pF */
    private final C0471n f16724pF;
    /* renamed from: pp */
    private final List<View> f16725pp;
    /* renamed from: pq */
    final C17467h<View> f16726pq;
    /* renamed from: pr */
    private final List<View> f16727pr;
    /* renamed from: ps */
    final List<View> f16728ps;
    /* renamed from: pt */
    private final int[] f16729pt;
    /* renamed from: pu */
    private boolean f16730pu;
    /* renamed from: pv */
    private boolean f16731pv;
    /* renamed from: pw */
    private int[] f16732pw;
    /* renamed from: px */
    private View f16733px;
    /* renamed from: py */
    private View f16734py;
    /* renamed from: pz */
    private C37098e f16735pz;

    /* renamed from: android.support.design.widget.CoordinatorLayout$a */
    public interface C0255a {
        /* renamed from: cb */
        Behavior mo413cb();
    }

    protected static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C61691();
        /* renamed from: pX */
        SparseArray<Parcelable> f1730pX;

        /* renamed from: android.support.design.widget.CoordinatorLayout$SavedState$1 */
        static class C61691 implements ClassLoaderCreator<SavedState> {
            C61691() {
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
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f1730pX = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f1730pX.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            int size = this.f1730pX != null ? this.f1730pX.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.f1730pX.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.f1730pX.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    public static abstract class Behavior<V extends View> {
        public Behavior(Context context, AttributeSet attributeSet) {
        }

        /* renamed from: a */
        public void mo18196a(C31839d c31839d) {
        }

        /* renamed from: a */
        public boolean mo442a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        /* renamed from: b */
        public boolean mo31556b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        /* renamed from: e */
        public boolean mo18160e(View view) {
            return false;
        }

        /* renamed from: a */
        public boolean mo18159a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        /* renamed from: a */
        public boolean mo18125a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        /* renamed from: a */
        public boolean mo18124a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        @Deprecated
        /* renamed from: J */
        public boolean mo31552J(int i) {
            return false;
        }

        /* renamed from: a */
        public boolean mo18126a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2) {
            if (i2 == 0) {
                return mo31552J(i);
            }
            return false;
        }

        @Deprecated
        /* renamed from: a */
        public void mo31553a(V v, View view) {
        }

        /* renamed from: a */
        public void mo18122a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                mo31553a((View) v, view);
            }
        }

        /* renamed from: b */
        public void mo18128b(CoordinatorLayout coordinatorLayout, V v, int i) {
        }

        @Deprecated
        /* renamed from: a */
        public void mo31554a(V v, View view, int i, int[] iArr) {
        }

        /* renamed from: a */
        public void mo18123a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int[] iArr, int i2) {
            if (i2 == 0) {
                mo31554a((View) v, view, i, iArr);
            }
        }

        /* renamed from: a */
        public boolean mo31555a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        /* renamed from: b */
        public static C0451aa m26967b(C0451aa c0451aa) {
            return c0451aa;
        }

        /* renamed from: a */
        public boolean mo18158a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        /* renamed from: a */
        public void mo18121a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        /* renamed from: b */
        public Parcelable mo18127b(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }

        /* renamed from: a */
        public boolean mo18197a(V v, Rect rect) {
            return false;
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: android.support.design.widget.CoordinatorLayout$b */
    public @interface C17384b {
        Class<? extends Behavior> value();
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$c */
    class C31838c implements OnHierarchyChangeListener {
        C31838c() {
        }

        public final void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.f16722pD != null) {
                CoordinatorLayout.this.f16722pD.onChildViewAdded(view, view2);
            }
        }

        public final void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.mo66173X(2);
            if (CoordinatorLayout.this.f16722pD != null) {
                CoordinatorLayout.this.f16722pD.onChildViewRemoved(view, view2);
            }
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$d */
    public static class C31839d extends MarginLayoutParams {
        public int anchorGravity = 0;
        public int gravity = 0;
        /* renamed from: pH */
        Behavior f14560pH;
        /* renamed from: pI */
        boolean f14561pI = false;
        /* renamed from: pJ */
        public int f14562pJ = -1;
        /* renamed from: pK */
        int f14563pK = -1;
        /* renamed from: pL */
        public int f14564pL = 0;
        /* renamed from: pM */
        public int f14565pM = 0;
        /* renamed from: pN */
        int f14566pN;
        /* renamed from: pO */
        int f14567pO;
        /* renamed from: pP */
        View f14568pP;
        /* renamed from: pQ */
        View f14569pQ;
        /* renamed from: pR */
        boolean f14570pR;
        /* renamed from: pS */
        private boolean f14571pS;
        /* renamed from: pT */
        private boolean f14572pT;
        /* renamed from: pU */
        boolean f14573pU;
        /* renamed from: pV */
        final Rect f14574pV = new Rect();
        /* renamed from: pW */
        Object f14575pW;

        public C31839d() {
            super(-2, -2);
        }

        C31839d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C17365a.CoordinatorLayout_Layout);
            this.gravity = obtainStyledAttributes.getInteger(0, 0);
            this.f14563pK = obtainStyledAttributes.getResourceId(2, -1);
            this.anchorGravity = obtainStyledAttributes.getInteger(4, 0);
            this.f14562pJ = obtainStyledAttributes.getInteger(3, -1);
            this.f14564pL = obtainStyledAttributes.getInt(5, 0);
            this.f14565pM = obtainStyledAttributes.getInt(6, 0);
            this.f14561pI = obtainStyledAttributes.hasValue(1);
            if (this.f14561pI) {
                this.f14560pH = CoordinatorLayout.m72413a(context, attributeSet, obtainStyledAttributes.getString(1));
            }
            obtainStyledAttributes.recycle();
            if (this.f14560pH != null) {
                this.f14560pH.mo18196a(this);
            }
        }

        public C31839d(C31839d c31839d) {
            super(c31839d);
        }

        public C31839d(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C31839d(LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* renamed from: a */
        public final void mo51801a(Behavior behavior) {
            if (this.f14560pH != behavior) {
                this.f14560pH = behavior;
                this.f14575pW = null;
                this.f14561pI = true;
                if (behavior != null) {
                    behavior.mo18196a(this);
                }
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cc */
        public final boolean mo51802cc() {
            return this.f14568pP == null && this.f14563pK != -1;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: i */
        public final void mo51803i(int i, boolean z) {
            switch (i) {
                case 0:
                    this.f14571pS = z;
                    return;
                case 1:
                    this.f14572pT = z;
                    return;
                default:
                    return;
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: Y */
        public final boolean mo51800Y(int i) {
            switch (i) {
                case 0:
                    return this.f14571pS;
                case 1:
                    return this.f14572pT;
                default:
                    return false;
            }
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$f */
    static class C31840f implements Comparator<View> {
        C31840f() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            View view = (View) obj2;
            float at = C0477s.m928at((View) obj);
            float at2 = C0477s.m928at(view);
            if (at > at2) {
                return -1;
            }
            if (at < at2) {
                return 1;
            }
            return 0;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$e */
    class C37098e implements OnPreDrawListener {
        C37098e() {
        }

        public final boolean onPreDraw() {
            CoordinatorLayout.this.mo66173X(0);
            return true;
        }
    }

    /* renamed from: android.support.design.widget.CoordinatorLayout$1 */
    class C414831 implements C0472o {
        C414831() {
        }

        /* renamed from: a */
        public final C0451aa mo1083a(View view, C0451aa c0451aa) {
            boolean z = true;
            int i = 0;
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            if (C37121i.equals(coordinatorLayout.f16718mp, c0451aa)) {
                return c0451aa;
            }
            C0451aa c0451aa2;
            coordinatorLayout.f16718mp = c0451aa;
            boolean z2 = c0451aa != null && c0451aa.getSystemWindowInsetTop() > 0;
            coordinatorLayout.f16720pB = z2;
            if (coordinatorLayout.f16720pB || coordinatorLayout.getBackground() != null) {
                z = false;
            }
            coordinatorLayout.setWillNotDraw(z);
            if (c0451aa.isConsumed()) {
                c0451aa2 = c0451aa;
            } else {
                int childCount = coordinatorLayout.getChildCount();
                C0451aa c0451aa3 = c0451aa;
                while (i < childCount) {
                    View childAt = coordinatorLayout.getChildAt(i);
                    if (C0477s.m920al(childAt) && ((C31839d) childAt.getLayoutParams()).f14560pH != null) {
                        c0451aa2 = Behavior.m26967b(c0451aa3);
                        if (c0451aa2.isConsumed()) {
                            break;
                        }
                    } else {
                        c0451aa2 = c0451aa3;
                    }
                    i++;
                    c0451aa3 = c0451aa2;
                }
                c0451aa2 = c0451aa3;
            }
            coordinatorLayout.requestLayout();
            return c0451aa2;
        }
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        f16713pk = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            f16716pn = new C31840f();
        } else {
            f16716pn = null;
        }
    }

    /* renamed from: bY */
    private static Rect m72420bY() {
        Rect rect = (Rect) f16717po.mo6364aA();
        if (rect == null) {
            return new Rect();
        }
        return rect;
    }

    /* renamed from: c */
    private static void m72422c(Rect rect) {
        rect.setEmpty();
        f16717po.release(rect);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5472n);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes;
        int i2 = 0;
        super(context, attributeSet, i);
        this.f16725pp = new ArrayList();
        this.f16726pq = new C17467h();
        this.f16727pr = new ArrayList();
        this.f16728ps = new ArrayList();
        this.f16729pt = new int[2];
        this.f16724pF = new C0471n(this);
        if (i == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C17365a.CoordinatorLayout, 0, C25738R.style.f11386yv);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C17365a.CoordinatorLayout, i, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f16732pw = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.f16732pw.length;
            while (i2 < length) {
                int[] iArr = this.f16732pw;
                iArr[i2] = (int) (((float) iArr[i2]) * f);
                i2++;
            }
        }
        this.f16721pC = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        m72424ca();
        super.setOnHierarchyChangeListener(new C31838c());
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f16722pD = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m72429q(false);
        if (this.f16719pA) {
            if (this.f16735pz == null) {
                this.f16735pz = new C37098e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f16735pz);
        }
        if (this.f16718mp == null && C0477s.m920al(this)) {
            C0477s.m919ak(this);
        }
        this.f16731pv = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m72429q(false);
        if (this.f16719pA && this.f16735pz != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f16735pz);
        }
        if (this.f16734py != null) {
            onStopNestedScroll(this.f16734py);
        }
        this.f16731pv = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.f16721pC != drawable) {
            if (this.f16721pC != null) {
                this.f16721pC.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f16721pC = drawable2;
            if (this.f16721pC != null) {
                if (this.f16721pC.isStateful()) {
                    this.f16721pC.setState(getDrawableState());
                }
                C0280a.m463b(this.f16721pC, C0477s.m893T(this));
                this.f16721pC.setVisible(getVisibility() == 0, false);
                this.f16721pC.setCallback(this);
            }
            C0477s.m891R(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.f16721pC;
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.f16721pC;
        if (drawable != null && drawable.isStateful()) {
            i = drawable.setState(drawableState) | 0;
        }
        if (i != 0) {
            invalidate();
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f16721pC;
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f16721pC != null && this.f16721pC.isVisible() != z) {
            this.f16721pC.setVisible(z, false);
        }
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? C0380b.m649g(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public final C0451aa getLastWindowInsets() {
        return this.f16718mp;
    }

    /* renamed from: q */
    private void m72429q(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Behavior behavior = ((C31839d) childAt.getLayoutParams()).f14560pH;
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    behavior.mo442a(this, childAt, obtain);
                } else {
                    behavior.mo31556b(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((C31839d) getChildAt(i2).getLayoutParams()).f14570pR = false;
        }
        this.f16733px = null;
        this.f16730pu = false;
    }

    /* renamed from: a */
    private boolean m72419a(MotionEvent motionEvent, int i) {
        int childDrawingOrder;
        boolean z = false;
        Object obj = null;
        int actionMasked = motionEvent.getActionMasked();
        List list = this.f16727pr;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            if (isChildrenDrawingOrderEnabled) {
                childDrawingOrder = getChildDrawingOrder(childCount, i2);
            } else {
                childDrawingOrder = i2;
            }
            list.add(getChildAt(childDrawingOrder));
        }
        if (f16716pn != null) {
            Collections.sort(list, f16716pn);
        }
        int size = list.size();
        int i3 = 0;
        MotionEvent motionEvent2 = null;
        while (i3 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i3);
            C31839d c31839d = (C31839d) view.getLayoutParams();
            Behavior behavior = c31839d.f14560pH;
            if ((!z && obj == null) || actionMasked == 0) {
                if (!(z || behavior == null)) {
                    switch (i) {
                        case 0:
                            z = behavior.mo442a(this, view, motionEvent);
                            break;
                        case 1:
                            z = behavior.mo31556b(this, view, motionEvent);
                            break;
                    }
                    if (z) {
                        this.f16733px = view;
                    }
                }
                isChildrenDrawingOrderEnabled = z;
                if (c31839d.f14560pH == null) {
                    c31839d.f14570pR = false;
                }
                boolean z2 = c31839d.f14570pR;
                if (c31839d.f14570pR) {
                    childDrawingOrder = 1;
                } else {
                    int i4 = c31839d.f14570pR | 0;
                    c31839d.f14570pR = i4;
                    childDrawingOrder = i4;
                }
                obj2 = (childDrawingOrder == 0 || z2) ? null : 1;
                if (childDrawingOrder == 0 || obj2 != null) {
                    motionEvent3 = motionEvent2;
                } else {
                    list.clear();
                    return isChildrenDrawingOrderEnabled;
                }
            } else if (behavior != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case 0:
                        behavior.mo442a(this, view, motionEvent3);
                        obj2 = obj;
                        isChildrenDrawingOrderEnabled = z;
                        continue;
                    case 1:
                        behavior.mo31556b(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                isChildrenDrawingOrderEnabled = z;
            } else {
                motionEvent3 = motionEvent2;
                obj2 = obj;
                isChildrenDrawingOrderEnabled = z;
            }
            i3++;
            motionEvent2 = motionEvent3;
            obj = obj2;
            z = isChildrenDrawingOrderEnabled;
        }
        isChildrenDrawingOrderEnabled = z;
        list.clear();
        return isChildrenDrawingOrderEnabled;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m72429q(true);
        }
        boolean a = m72419a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            m72429q(true);
        }
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        MotionEvent motionEvent2;
        int actionMasked = motionEvent.getActionMasked();
        boolean z2;
        if (this.f16733px == null) {
            boolean a = m72419a(motionEvent, 1);
            if (a) {
                z2 = a;
            } else {
                z2 = a;
                z = false;
                if (this.f16733px != null) {
                    z |= super.onTouchEvent(motionEvent);
                    motionEvent2 = null;
                } else if (z2) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    super.onTouchEvent(motionEvent2);
                } else {
                    motionEvent2 = null;
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                if (actionMasked == 1 || actionMasked == 3) {
                    m72429q(false);
                }
                return z;
            }
        }
        z2 = false;
        Behavior behavior = ((C31839d) this.f16733px.getLayoutParams()).f14560pH;
        z = behavior != null ? behavior.mo31556b(this, this.f16733px, motionEvent) : false;
        if (this.f16733px != null) {
        }
        if (motionEvent2 != null) {
        }
        m72429q(false);
        return z;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.f16730pu) {
            m72429q(false);
            this.f16730pu = true;
        }
    }

    /* renamed from: U */
    private int m72410U(int i) {
        if (this.f16732pw == null) {
            new StringBuilder("No keylines defined for ").append(this).append(" - attempted index lookup ").append(i);
            return 0;
        } else if (i >= 0 && i < this.f16732pw.length) {
            return this.f16732pw[i];
        } else {
            new StringBuilder("Keyline index ").append(i).append(" out of range for ").append(this);
            return 0;
        }
    }

    /* renamed from: a */
    static Behavior m72413a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object str2;
        if (str2.startsWith(".")) {
            str2 = context.getPackageName() + str2;
        } else if (str2.indexOf(46) < 0 && !TextUtils.isEmpty(f16713pk)) {
            str2 = f16713pk + '.' + str2;
        }
        try {
            Map map;
            Map map2 = (Map) f16715pm.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                f16715pm.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str2);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str2).getConstructor(f16714pl);
                constructor.setAccessible(true);
                map.put(str2, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e) {
            throw new RuntimeException("Could not inflate Behavior subclass ".concat(String.valueOf(str2)), e);
        }
    }

    /* renamed from: o */
    private static C31839d m72428o(View view) {
        C31839d c31839d = (C31839d) view.getLayoutParams();
        if (!c31839d.f14561pI) {
            if (view instanceof C0255a) {
                c31839d.mo51801a(((C0255a) view).mo413cb());
                c31839d.f14561pI = true;
            } else {
                C17384b c17384b = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    c17384b = (C17384b) cls.getAnnotation(C17384b.class);
                    if (c17384b != null) {
                        break;
                    }
                }
                C17384b c17384b2 = c17384b;
                if (c17384b2 != null) {
                    try {
                        c31839d.mo51801a((Behavior) c17384b2.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e) {
                        new StringBuilder("Default behavior class ").append(c17384b2.value().getName()).append(" could not be instantiated. Did you forget a default constructor?");
                    }
                }
                c31839d.f14561pI = true;
            }
        }
        return c31839d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x019a A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0085  */
    /* JADX WARNING: Missing block: B:42:0x00be, code skipped:
            if (r0 == null) goto L_0x00c0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: bZ */
    private void m72421bZ() {
        int i;
        ArrayList arrayList;
        this.f16725pp.clear();
        C17467h c17467h = this.f16726pq;
        int size = c17467h.f3996PR.size();
        for (i = 0; i < size; i++) {
            arrayList = (ArrayList) c17467h.f3996PR.valueAt(i);
            if (arrayList != null) {
                arrayList.clear();
                c17467h.f3995PQ.release(arrayList);
            }
        }
        c17467h.f3996PR.clear();
        size = getChildCount();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj;
            int obj2;
            View childAt = getChildAt(i2);
            C31839d o = m72428o(childAt);
            if (o.f14563pK == -1) {
                o.f14569pQ = null;
                o.f14568pP = null;
            } else {
                View view;
                View parent;
                if (o.f14568pP != null) {
                    if (o.f14568pP.getId() != o.f14563pK) {
                        obj2 = null;
                    } else {
                        view = o.f14568pP;
                        parent = o.f14568pP.getParent();
                        while (parent != this) {
                            if (parent == null || parent == childAt) {
                                o.f14569pQ = null;
                                o.f14568pP = null;
                                obj2 = null;
                                break;
                            }
                            if (parent instanceof View) {
                                view = parent;
                            }
                            parent = parent.getParent();
                        }
                        o.f14569pQ = view;
                        obj2 = 1;
                    }
                }
                o.f14568pP = findViewById(o.f14563pK);
                if (o.f14568pP != null) {
                    if (o.f14568pP != this) {
                        view = o.f14568pP;
                        parent = o.f14568pP.getParent();
                        while (parent != this && parent != null) {
                            if (parent != childAt) {
                                if (parent instanceof View) {
                                    view = parent;
                                }
                                parent = parent.getParent();
                            } else if (isInEditMode()) {
                                o.f14569pQ = null;
                                o.f14568pP = null;
                            } else {
                                throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                            }
                        }
                        o.f14569pQ = view;
                    } else if (isInEditMode()) {
                        o.f14569pQ = null;
                        o.f14568pP = null;
                    } else {
                        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                    }
                } else if (isInEditMode()) {
                    o.f14569pQ = null;
                    o.f14568pP = null;
                } else {
                    throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(o.f14563pK) + " to anchor view " + childAt);
                }
            }
            this.f16726pq.mo31808I(childAt);
            for (i = 0; i < size; i++) {
                if (i != i2) {
                    View childAt2 = getChildAt(i);
                    if (childAt2 != o.f14569pQ) {
                        int T = C0477s.m893T(this);
                        obj2 = C0456d.getAbsoluteGravity(((C31839d) childAt2.getLayoutParams()).f14564pL, T);
                        if (obj2 == 0 || (C0456d.getAbsoluteGravity(o.f14565pM, T) & obj2) != obj2) {
                            obj2 = null;
                        } else {
                            obj2 = 1;
                        }
                        if (obj2 == null && (o.f14560pH == null || !o.f14560pH.mo18160e(childAt2))) {
                            obj2 = null;
                            if (obj2 == null) {
                                continue;
                            } else {
                                if (!this.f16726pq.f3996PR.containsKey(childAt2)) {
                                    this.f16726pq.mo31808I(childAt2);
                                }
                                C17467h c17467h2 = this.f16726pq;
                                if (c17467h2.f3996PR.containsKey(childAt2) && c17467h2.f3996PR.containsKey(childAt)) {
                                    arrayList = (ArrayList) c17467h2.f3996PR.get(childAt2);
                                    if (arrayList == null) {
                                        arrayList = (ArrayList) c17467h2.f3995PQ.mo6364aA();
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        c17467h2.f3996PR.put(childAt2, arrayList);
                                    }
                                    arrayList.add(childAt);
                                } else {
                                    throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
                                }
                            }
                        }
                    }
                    obj2 = 1;
                    if (obj2 == null) {
                    }
                }
            }
        }
        this.f16725pp.addAll(this.f16726pq.mo31811eE());
        Collections.reverse(this.f16725pp);
    }

    /* Access modifiers changed, original: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    /* Access modifiers changed, original: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* renamed from: a */
    public final void mo66174a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        Object obj;
        m72421bZ();
        int childCount = getChildCount();
        for (i3 = 0; i3 < childCount; i3++) {
            Object obj2;
            View childAt = getChildAt(i3);
            C17467h c17467h = this.f16726pq;
            int size = c17467h.f3996PR.size();
            for (i4 = 0; i4 < size; i4++) {
                ArrayList arrayList = (ArrayList) c17467h.f3996PR.valueAt(i4);
                if (arrayList != null && arrayList.contains(childAt)) {
                    obj2 = 1;
                    break;
                }
            }
            obj2 = null;
            if (obj2 != null) {
                z = true;
                break;
            }
        }
        z = false;
        if (z != this.f16719pA) {
            if (z) {
                if (this.f16731pv) {
                    if (this.f16735pz == null) {
                        this.f16735pz = new C37098e();
                    }
                    getViewTreeObserver().addOnPreDrawListener(this.f16735pz);
                }
                this.f16719pA = true;
            } else {
                if (this.f16731pv && this.f16735pz != null) {
                    getViewTreeObserver().removeOnPreDrawListener(this.f16735pz);
                }
                this.f16719pA = false;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        i4 = getPaddingBottom();
        int T = C0477s.m893T(this);
        Object obj3;
        if (T == 1) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size3 = MeasureSpec.getSize(i2);
        int i5 = paddingLeft + paddingRight;
        int i6 = paddingTop + i4;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int i7 = 0;
        if (this.f16718mp == null || !C0477s.m920al(this)) {
            obj = null;
        } else {
            obj = 1;
        }
        int size4 = this.f16725pp.size();
        int i8 = 0;
        while (i8 < size4) {
            int U;
            View view = (View) this.f16725pp.get(i8);
            if (view.getVisibility() != 8) {
                int i9;
                C31839d c31839d = (C31839d) view.getLayoutParams();
                childCount = 0;
                if (c31839d.f14562pJ >= 0 && mode != 0) {
                    U = m72410U(c31839d.f14562pJ);
                    paddingTop = C0456d.getAbsoluteGravity(m72412W(c31839d.gravity), T) & 7;
                    if ((paddingTop == 3 && obj3 == null) || (paddingTop == 5 && obj3 != null)) {
                        childCount = Math.max(0, (size2 - paddingRight) - U);
                    } else if ((paddingTop == 5 && obj3 == null) || (paddingTop == 3 && obj3 != null)) {
                        childCount = Math.max(0, U - paddingLeft);
                    }
                }
                if (obj == null || C0477s.m920al(view)) {
                    i9 = i2;
                    i3 = i;
                } else {
                    paddingTop = this.f16718mp.getSystemWindowInsetTop() + this.f16718mp.getSystemWindowInsetBottom();
                    i3 = MeasureSpec.makeMeasureSpec(size2 - (this.f16718mp.getSystemWindowInsetLeft() + this.f16718mp.getSystemWindowInsetRight()), mode);
                    i9 = MeasureSpec.makeMeasureSpec(size3 - paddingTop, mode2);
                }
                Behavior behavior = c31839d.f14560pH;
                if (behavior == null || !behavior.mo18125a(this, view, i3, childCount, i9, 0)) {
                    mo66174a(view, i3, childCount, i9, 0);
                }
                i3 = Math.max(suggestedMinimumWidth, ((view.getMeasuredWidth() + i5) + c31839d.leftMargin) + c31839d.rightMargin);
                paddingTop = Math.max(suggestedMinimumHeight, ((view.getMeasuredHeight() + i6) + c31839d.topMargin) + c31839d.bottomMargin);
                U = View.combineMeasuredStates(i7, view.getMeasuredState());
                i4 = i3;
            } else {
                U = i7;
                paddingTop = suggestedMinimumHeight;
                i4 = suggestedMinimumWidth;
            }
            i8++;
            i7 = U;
            suggestedMinimumHeight = paddingTop;
            suggestedMinimumWidth = i4;
        }
        setMeasuredDimension(View.resolveSizeAndState(suggestedMinimumWidth, i, WebView.NIGHT_MODE_COLOR & i7), View.resolveSizeAndState(suggestedMinimumHeight, i2, i7 << 16));
    }

    /* renamed from: e */
    public final void mo66179e(View view, int i) {
        C31839d c31839d = (C31839d) view.getLayoutParams();
        if (c31839d.mo51802cc()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (c31839d.f14568pP != null) {
            m72417a(view, c31839d.f14568pP, i);
        } else if (c31839d.f14562pJ >= 0) {
            m72423c(view, c31839d.f14562pJ, i);
        } else {
            m72425f(view, i);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int T = C0477s.m893T(this);
        int size = this.f16725pp.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.f16725pp.get(i5);
            if (view.getVisibility() != 8) {
                Behavior behavior = ((C31839d) view.getLayoutParams()).f14560pH;
                if (behavior == null || !behavior.mo18124a(this, view, T)) {
                    mo66179e(view, T);
                }
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f16720pB && this.f16721pC != null) {
            int systemWindowInsetTop = this.f16718mp != null ? this.f16718mp.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.f16721pC.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.f16721pC.draw(canvas);
            }
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        m72424ca();
    }

    /* renamed from: a */
    private void m72418a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            C31872u.m51651a((ViewGroup) this, view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    /* renamed from: a */
    private static void m72414a(int i, Rect rect, Rect rect2, C31839d c31839d, int i2, int i3) {
        int i4 = c31839d.gravity;
        if (i4 == 0) {
            i4 = 17;
        }
        i4 = C0456d.getAbsoluteGravity(i4, i);
        int absoluteGravity = C0456d.getAbsoluteGravity(m72411V(c31839d.anchorGravity), i);
        int i5 = i4 & 7;
        int i6 = i4 & 112;
        int i7 = absoluteGravity & 112;
        switch (absoluteGravity & 7) {
            case 1:
                absoluteGravity = (rect.width() / 2) + rect.left;
                break;
            case 5:
                absoluteGravity = rect.right;
                break;
            default:
                absoluteGravity = rect.left;
                break;
        }
        switch (i7) {
            case 16:
                i4 = rect.top + (rect.height() / 2);
                break;
            case 80:
                i4 = rect.bottom;
                break;
            default:
                i4 = rect.top;
                break;
        }
        switch (i5) {
            case 1:
                absoluteGravity -= i2 / 2;
                break;
            case 5:
                break;
            default:
                absoluteGravity -= i2;
                break;
        }
        switch (i6) {
            case 16:
                i4 -= i3 / 2;
                break;
            case 80:
                break;
            default:
                i4 -= i3;
                break;
        }
        rect2.set(absoluteGravity, i4, absoluteGravity + i2, i4 + i3);
    }

    /* renamed from: a */
    private void m72415a(C31839d c31839d, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        width = Math.max(getPaddingLeft() + c31839d.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - c31839d.rightMargin));
        height = Math.max(getPaddingTop() + c31839d.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - c31839d.bottomMargin));
        rect.set(width, height, width + i, height + i2);
    }

    /* renamed from: a */
    private void m72416a(View view, int i, Rect rect, Rect rect2) {
        C31839d c31839d = (C31839d) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        m72414a(i, rect, rect2, c31839d, measuredWidth, measuredHeight);
        m72415a(c31839d, rect2, measuredWidth, measuredHeight);
    }

    /* renamed from: a */
    private void m72417a(View view, View view2, int i) {
        view.getLayoutParams();
        Rect bY = m72420bY();
        Rect bY2 = m72420bY();
        try {
            C31872u.m51651a((ViewGroup) this, view2, bY);
            m72416a(view, i, bY, bY2);
            view.layout(bY2.left, bY2.top, bY2.right, bY2.bottom);
        } finally {
            m72422c(bY);
            m72422c(bY2);
        }
    }

    /* renamed from: c */
    private void m72423c(View view, int i, int i2) {
        C31839d c31839d = (C31839d) view.getLayoutParams();
        int absoluteGravity = C0456d.getAbsoluteGravity(m72412W(c31839d.gravity), i2);
        int i3 = absoluteGravity & 7;
        int i4 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int U = m72410U(i) - measuredWidth;
        absoluteGravity = 0;
        switch (i3) {
            case 1:
                U += measuredWidth / 2;
                break;
            case 5:
                U += measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                absoluteGravity = (measuredHeight / 2) + 0;
                break;
            case 80:
                absoluteGravity = measuredHeight + 0;
                break;
        }
        U = Math.max(getPaddingLeft() + c31839d.leftMargin, Math.min(U, ((width - getPaddingRight()) - measuredWidth) - c31839d.rightMargin));
        int max = Math.max(getPaddingTop() + c31839d.topMargin, Math.min(absoluteGravity, ((height - getPaddingBottom()) - measuredHeight) - c31839d.bottomMargin));
        view.layout(U, max, U + measuredWidth, max + measuredHeight);
    }

    /* renamed from: f */
    private void m72425f(View view, int i) {
        C31839d c31839d = (C31839d) view.getLayoutParams();
        Rect bY = m72420bY();
        bY.set(getPaddingLeft() + c31839d.leftMargin, getPaddingTop() + c31839d.topMargin, (getWidth() - getPaddingRight()) - c31839d.rightMargin, (getHeight() - getPaddingBottom()) - c31839d.bottomMargin);
        if (!(this.f16718mp == null || !C0477s.m920al(this) || C0477s.m920al(view))) {
            bY.left += this.f16718mp.getSystemWindowInsetLeft();
            bY.top += this.f16718mp.getSystemWindowInsetTop();
            bY.right -= this.f16718mp.getSystemWindowInsetRight();
            bY.bottom -= this.f16718mp.getSystemWindowInsetBottom();
        }
        Rect bY2 = m72420bY();
        C0456d.apply(m72411V(c31839d.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), bY, bY2, i);
        view.layout(bY2.left, bY2.top, bY2.right, bY2.bottom);
        m72422c(bY);
        m72422c(bY2);
    }

    /* renamed from: V */
    private static int m72411V(int i) {
        int i2;
        if ((i & 7) == 0) {
            i2 = 8388611 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 112) == 0) {
            return i2 | 48;
        }
        return i2;
    }

    /* renamed from: W */
    private static int m72412W(int i) {
        return i == 0 ? 8388661 : i;
    }

    /* Access modifiers changed, original: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        view.getLayoutParams();
        return super.drawChild(canvas, view, j);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0279  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: X */
    public final void mo66173X(int i) {
        int T = C0477s.m893T(this);
        int size = this.f16725pp.size();
        Rect bY = m72420bY();
        Rect bY2 = m72420bY();
        Rect bY3 = m72420bY();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.f16725pp.get(i2);
            C31839d c31839d = (C31839d) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                int measuredWidth;
                int measuredHeight;
                Behavior behavior;
                int absoluteGravity;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (c31839d.f14569pQ == ((View) this.f16725pp.get(i3))) {
                        C31839d c31839d2 = (C31839d) view.getLayoutParams();
                        if (c31839d2.f14568pP != null) {
                            Rect bY4 = m72420bY();
                            Rect bY5 = m72420bY();
                            Rect bY6 = m72420bY();
                            C31872u.m51651a((ViewGroup) this, c31839d2.f14568pP, bY4);
                            m72418a(view, false, bY5);
                            measuredWidth = view.getMeasuredWidth();
                            measuredHeight = view.getMeasuredHeight();
                            m72414a(T, bY4, bY6, c31839d2, measuredWidth, measuredHeight);
                            Object obj = (bY6.left == bY5.left && bY6.top == bY5.top) ? null : 1;
                            m72415a(c31839d2, bY6, measuredWidth, measuredHeight);
                            measuredWidth = bY6.left - bY5.left;
                            measuredHeight = bY6.top - bY5.top;
                            if (measuredWidth != 0) {
                                C0477s.m952r(view, measuredWidth);
                            }
                            if (measuredHeight != 0) {
                                C0477s.m951q(view, measuredHeight);
                            }
                            if (obj != null) {
                                behavior = c31839d2.f14560pH;
                                if (behavior != null) {
                                    behavior.mo18159a(this, view, c31839d2.f14568pP);
                                }
                            }
                            m72422c(bY4);
                            m72422c(bY5);
                            m72422c(bY6);
                        }
                    }
                }
                m72418a(view, true, bY2);
                if (!(c31839d.f14564pL == 0 || bY2.isEmpty())) {
                    absoluteGravity = C0456d.getAbsoluteGravity(c31839d.f14564pL, T);
                    switch (absoluteGravity & 112) {
                        case 48:
                            bY.top = Math.max(bY.top, bY2.bottom);
                            break;
                        case 80:
                            bY.bottom = Math.max(bY.bottom, getHeight() - bY2.top);
                            break;
                    }
                    switch (absoluteGravity & 7) {
                        case 3:
                            bY.left = Math.max(bY.left, bY2.right);
                            break;
                        case 5:
                            bY.right = Math.max(bY.right, getWidth() - bY2.left);
                            break;
                    }
                }
                if (c31839d.f14565pM != 0 && view.getVisibility() == 0 && C0477s.m927as(view) && view.getWidth() > 0 && view.getHeight() > 0) {
                    C31839d c31839d3 = (C31839d) view.getLayoutParams();
                    Behavior behavior2 = c31839d3.f14560pH;
                    Rect bY7 = m72420bY();
                    Rect bY8 = m72420bY();
                    bY8.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                    if (behavior2 == null || !behavior2.mo18197a(view, bY7)) {
                        bY7.set(bY8);
                    } else if (!bY8.contains(bY7)) {
                        throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + bY7.toShortString() + " | Bounds:" + bY8.toShortString());
                    }
                    m72422c(bY8);
                    if (!bY7.isEmpty()) {
                        Object obj2;
                        measuredWidth = C0456d.getAbsoluteGravity(c31839d3.f14565pM, T);
                        Object obj3 = null;
                        if ((measuredWidth & 48) == 48) {
                            measuredHeight = (bY7.top - c31839d3.topMargin) - c31839d3.f14567pO;
                            if (measuredHeight < bY.top) {
                                m72427h(view, bY.top - measuredHeight);
                                obj3 = 1;
                            }
                        }
                        if ((measuredWidth & 80) == 80) {
                            measuredHeight = ((getHeight() - bY7.bottom) - c31839d3.bottomMargin) + c31839d3.f14567pO;
                            if (measuredHeight < bY.bottom) {
                                m72427h(view, measuredHeight - bY.bottom);
                                obj3 = 1;
                            }
                        }
                        if (obj3 == null) {
                            m72427h(view, 0);
                        }
                        obj3 = null;
                        if ((measuredWidth & 3) == 3) {
                            measuredHeight = (bY7.left - c31839d3.leftMargin) - c31839d3.f14566pN;
                            if (measuredHeight < bY.left) {
                                m72426g(view, bY.left - measuredHeight);
                                obj3 = 1;
                            }
                        }
                        if ((measuredWidth & 5) == 5) {
                            absoluteGravity = c31839d3.f14566pN + ((getWidth() - bY7.right) - c31839d3.rightMargin);
                            if (absoluteGravity < bY.right) {
                                m72426g(view, absoluteGravity - bY.right);
                                obj2 = 1;
                                if (obj2 == null) {
                                    m72426g(view, 0);
                                }
                            }
                        }
                        obj2 = obj3;
                        if (obj2 == null) {
                        }
                    }
                    m72422c(bY7);
                }
                if (i != 2) {
                    bY3.set(((C31839d) view.getLayoutParams()).f14574pV);
                    if (!bY3.equals(bY2)) {
                        ((C31839d) view.getLayoutParams()).f14574pV.set(bY2);
                    }
                }
                for (int i4 = i2 + 1; i4 < size; i4++) {
                    View view2 = (View) this.f16725pp.get(i4);
                    C31839d c31839d4 = (C31839d) view2.getLayoutParams();
                    behavior = c31839d4.f14560pH;
                    if (behavior != null && behavior.mo18160e(view)) {
                        if (i == 0 && c31839d4.f14573pU) {
                            c31839d4.f14573pU = false;
                        } else {
                            boolean z;
                            switch (i) {
                                case 2:
                                    z = true;
                                    break;
                                default:
                                    z = behavior.mo18159a(this, view2, view);
                                    break;
                            }
                            if (i == 1) {
                                c31839d4.f14573pU = z;
                            }
                        }
                    }
                }
            }
        }
        m72422c(bY);
        m72422c(bY2);
        m72422c(bY3);
    }

    /* renamed from: g */
    private static void m72426g(View view, int i) {
        C31839d c31839d = (C31839d) view.getLayoutParams();
        if (c31839d.f14566pN != i) {
            C0477s.m952r(view, i - c31839d.f14566pN);
            c31839d.f14566pN = i;
        }
    }

    /* renamed from: h */
    private static void m72427h(View view, int i) {
        C31839d c31839d = (C31839d) view.getLayoutParams();
        if (c31839d.f14567pO != i) {
            C0477s.m951q(view, i - c31839d.f14567pO);
            c31839d.f14567pO = i;
        }
    }

    /* renamed from: p */
    public final List<View> mo66198p(View view) {
        List K = this.f16726pq.mo31810K(view);
        this.f16728ps.clear();
        if (K != null) {
            this.f16728ps.addAll(K);
        }
        return this.f16728ps;
    }

    /* Access modifiers changed, original: final */
    public final List<View> getDependencySortedChildren() {
        m72421bZ();
        return Collections.unmodifiableList(this.f16725pp);
    }

    /* renamed from: d */
    public final boolean mo66176d(View view, int i, int i2) {
        Rect bY = m72420bY();
        C31872u.m51651a((ViewGroup) this, view, bY);
        try {
            boolean contains = bY.contains(i, i2);
            return contains;
        } finally {
            m72422c(bY);
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C31839d) && super.checkLayoutParams(layoutParams);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return mo14024e(view, i, 0);
    }

    /* renamed from: e */
    public final boolean mo14024e(View view, int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (i3 < childCount) {
            int i5;
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                C31839d c31839d = (C31839d) childAt.getLayoutParams();
                Behavior behavior = c31839d.f14560pH;
                if (behavior != null) {
                    boolean a = behavior.mo18126a(this, childAt, view, i, i2);
                    i5 = i4 | a;
                    c31839d.mo51803i(i2, a);
                    i3++;
                    i4 = i5;
                } else {
                    c31839d.mo51803i(i2, false);
                }
            }
            i5 = i4;
            i3++;
            i4 = i5;
        }
        return i4;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        mo14025i(view2, i);
    }

    /* renamed from: i */
    public final void mo14025i(View view, int i) {
        this.f16724pF.f565Ms = i;
        this.f16734py = view;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).getLayoutParams();
        }
    }

    public void onStopNestedScroll(View view) {
        mo14026j(view, 0);
    }

    /* renamed from: j */
    public final void mo14026j(View view, int i) {
        this.f16724pF.f565Ms = 0;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C31839d c31839d = (C31839d) childAt.getLayoutParams();
            if (c31839d.mo51800Y(i)) {
                Behavior behavior = c31839d.f14560pH;
                if (behavior != null) {
                    behavior.mo18122a(this, childAt, view, i);
                }
                c31839d.mo51803i(i, false);
                c31839d.f14573pU = false;
            }
        }
        this.f16734py = null;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        mo14027m(i4, 0);
    }

    /* renamed from: m */
    public final void mo14027m(int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (i3 < childCount) {
            int i5;
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                C31839d c31839d = (C31839d) childAt.getLayoutParams();
                if (c31839d.mo51800Y(i2)) {
                    Behavior behavior = c31839d.f14560pH;
                    if (behavior != null) {
                        behavior.mo18128b(this, childAt, i);
                        i5 = 1;
                        i3++;
                        i4 = i5;
                    }
                }
            }
            i5 = i4;
            i3++;
            i4 = i5;
        }
        if (i4 != 0) {
            mo66173X(1);
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        mo14023a(view, i, i2, iArr, 0);
    }

    /* renamed from: a */
    public final void mo14023a(View view, int i, int i2, int[] iArr, int i3) {
        int i4 = 0;
        int i5 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            int max;
            int max2;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C31839d c31839d = (C31839d) childAt.getLayoutParams();
                if (c31839d.mo51800Y(i3)) {
                    Behavior behavior = c31839d.f14560pH;
                    if (behavior != null) {
                        int[] iArr2 = this.f16729pt;
                        this.f16729pt[1] = 0;
                        iArr2[0] = 0;
                        behavior.mo18123a(this, childAt, view, i2, this.f16729pt, i3);
                        if (i > 0) {
                            max = Math.max(i4, this.f16729pt[0]);
                        } else {
                            max = Math.min(i4, this.f16729pt[0]);
                        }
                        if (i2 > 0) {
                            max2 = Math.max(i5, this.f16729pt[1]);
                        } else {
                            max2 = Math.min(i5, this.f16729pt[1]);
                        }
                        obj = 1;
                        i6++;
                        i5 = max2;
                        i4 = max;
                    }
                }
            }
            max2 = i5;
            max = i4;
            i6++;
            i5 = max2;
            i4 = max;
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (obj != null) {
            mo66173X(1);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                childAt.getLayoutParams();
            }
        }
        return false;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        int i2 = 0;
        while (i < childCount) {
            int a;
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C31839d c31839d = (C31839d) childAt.getLayoutParams();
                if (c31839d.mo51800Y(0)) {
                    Behavior behavior = c31839d.f14560pH;
                    if (behavior != null) {
                        a = behavior.mo31555a(this, childAt, view, f, f2) | i2;
                        i++;
                        i2 = a;
                    }
                }
            }
            a = i2;
            i++;
            i2 = a;
        }
        return i2;
    }

    public int getNestedScrollAxes() {
        return this.f16724pF.f565Ms;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.f507LC);
            SparseArray sparseArray = savedState.f1730pX;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                Behavior behavior = m72428o(childAt).f14560pH;
                if (!(id == -1 || behavior == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        behavior.mo18121a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = ((C31839d) childAt.getLayoutParams()).f14560pH;
            if (!(id == -1 || behavior == null)) {
                Parcelable b = behavior.mo18127b(this, childAt);
                if (b != null) {
                    sparseArray.append(id, b);
                }
            }
        }
        savedState.f1730pX = sparseArray;
        return savedState;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behavior = ((C31839d) view.getLayoutParams()).f14560pH;
        if (behavior == null || !behavior.mo18158a(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    /* renamed from: ca */
    private void m72424ca() {
        if (VERSION.SDK_INT >= 21) {
            if (C0477s.m920al(this)) {
                if (this.f16723pE == null) {
                    this.f16723pE = new C414831();
                }
                C0477s.m906a((View) this, this.f16723pE);
                setSystemUiVisibility(ActUtil.HEIGHT);
                return;
            }
            C0477s.m906a((View) this, null);
        }
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return new C31839d();
    }
}
