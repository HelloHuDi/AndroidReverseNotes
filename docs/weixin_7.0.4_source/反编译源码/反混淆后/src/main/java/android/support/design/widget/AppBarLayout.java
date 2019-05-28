package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.C37097a.C37096a;
import android.support.design.widget.CoordinatorLayout.C17384b;
import android.support.design.widget.CoordinatorLayout.C31839d;
import android.support.p057v4.p065f.C37121i;
import android.support.p057v4.p1154c.C17435a;
import android.support.p057v4.view.AbsSavedState;
import android.support.p057v4.view.C0451aa;
import android.support.p057v4.view.C0472o;
import android.support.p057v4.view.C0477s;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.tencent.p177mm.C25738R;
import java.lang.ref.WeakReference;
import java.util.List;

@C17384b(Behavior.class)
public class AppBarLayout extends LinearLayout {
    /* renamed from: mk */
    private int f2177mk = -1;
    /* renamed from: ml */
    private int f2178ml = -1;
    /* renamed from: mm */
    private int f2179mm = -1;
    /* renamed from: mn */
    boolean f2180mn;
    /* renamed from: mo */
    int f2181mo = 0;
    /* renamed from: mp */
    C0451aa f2182mp;
    /* renamed from: mq */
    List<C8325a> f2183mq;
    /* renamed from: mr */
    private boolean f2184mr;
    /* renamed from: ms */
    boolean f2185ms;
    /* renamed from: mt */
    private int[] f2186mt;

    public static class Behavior extends HeaderBehavior<AppBarLayout> {
        /* renamed from: mA */
        private WeakReference<View> f2165mA;
        /* renamed from: mB */
        private C8324a f2166mB;
        /* renamed from: mv */
        private int f2167mv;
        /* renamed from: mw */
        private ValueAnimator f2168mw;
        /* renamed from: mx */
        private int f2169mx = -1;
        /* renamed from: my */
        private boolean f2170my;
        /* renamed from: mz */
        private float f2171mz;

        protected static class SavedState extends AbsSavedState {
            public static final Creator<SavedState> CREATOR = new C83221();
            /* renamed from: mF */
            int f2162mF;
            /* renamed from: mG */
            float f2163mG;
            /* renamed from: mH */
            boolean f2164mH;

            /* renamed from: android.support.design.widget.AppBarLayout$Behavior$SavedState$1 */
            static class C83221 implements ClassLoaderCreator<SavedState> {
                C83221() {
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
                this.f2162mF = parcel.readInt();
                this.f2163mG = parcel.readFloat();
                this.f2164mH = parcel.readByte() != (byte) 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f2162mF);
                parcel.writeFloat(this.f2163mG);
                parcel.writeByte((byte) (this.f2164mH ? 1 : 0));
            }
        }

        /* renamed from: android.support.design.widget.AppBarLayout$Behavior$a */
        public static abstract class C8324a {
            /* renamed from: bC */
            public abstract boolean mo18135bC();
        }

        /* renamed from: G */
        public final /* bridge */ /* synthetic */ boolean mo18118G(int i) {
            return super.mo18118G(i);
        }

        /* renamed from: a */
        public final /* synthetic */ void mo18122a(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i == 0) {
                m14643a(coordinatorLayout, appBarLayout);
            }
            this.f2165mA = new WeakReference(view2);
        }

        /* renamed from: b */
        public final /* synthetic */ Parcelable mo18127b(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = false;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            Parcelable b = super.mo18127b(coordinatorLayout, appBarLayout);
            int bB = super.mo18130bB();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + bB;
                if (childAt.getTop() + bB > 0 || bottom < 0) {
                    i++;
                } else {
                    SavedState savedState = new SavedState(b);
                    savedState.f2162mF = i;
                    if (bottom == C0477s.m909aa(childAt) + appBarLayout.getTopInset()) {
                        z = true;
                    }
                    savedState.f2164mH = z;
                    savedState.f2163mG = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return b;
        }

        /* renamed from: b */
        public final /* synthetic */ void mo18128b(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i < 0) {
                mo51805b(coordinatorLayout, appBarLayout, i, -appBarLayout.getDownNestedScrollRange(), 0);
            }
        }

        /* renamed from: bB */
        public final /* bridge */ /* synthetic */ int mo18130bB() {
            return super.mo18130bB();
        }

        /* Access modifiers changed, original: final|synthetic */
        /* renamed from: c */
        public final /* synthetic */ int mo18132c(View view) {
            return ((AppBarLayout) view).getTotalScrollRange();
        }

        /* Access modifiers changed, original: final|synthetic */
        /* renamed from: d */
        public final /* synthetic */ int mo18133d(View view) {
            return -((AppBarLayout) view).getDownNestedScrollRange();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* renamed from: a */
        private void m14644a(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(mo18131bz() - i);
            float abs2 = Math.abs(0.0f);
            if (abs2 > 0.0f) {
                abs = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                abs = (int) (((((float) abs) / ((float) appBarLayout.getHeight())) + 1.0f) * 150.0f);
            }
            if (mo18131bz() != i) {
                if (this.f2168mw == null) {
                    this.f2168mw = new ValueAnimator();
                    this.f2168mw.setInterpolator(C31841a.f14583mj);
                    this.f2168mw.addUpdateListener(new AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            Behavior.this.mo51806c(coordinatorLayout, appBarLayout, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                } else {
                    this.f2168mw.cancel();
                }
                this.f2168mw.setDuration((long) Math.min(abs, 600));
                this.f2168mw.setIntValues(new int[]{r1, i});
                this.f2168mw.start();
            } else if (this.f2168mw != null && this.f2168mw.isRunning()) {
                this.f2168mw.cancel();
            }
        }

        /* renamed from: a */
        private void m14643a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int i;
            int bz = mo18131bz();
            int childCount = appBarLayout.getChildCount();
            for (i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                if (childAt.getTop() <= (-bz) && childAt.getBottom() >= (-bz)) {
                    childCount = i;
                    break;
                }
            }
            childCount = -1;
            if (childCount >= 0) {
                View childAt2 = appBarLayout.getChildAt(childCount);
                int i2 = ((LayoutParams) childAt2.getLayoutParams()).f2175mI;
                if ((i2 & 17) == 17) {
                    int i3 = -childAt2.getTop();
                    i = -childAt2.getBottom();
                    if (childCount == appBarLayout.getChildCount() - 1) {
                        i += appBarLayout.getTopInset();
                    }
                    if (m14646l(i2, 2)) {
                        i += C0477s.m909aa(childAt2);
                    } else if (m14646l(i2, 5)) {
                        childCount = C0477s.m909aa(childAt2) + i;
                        if (bz < childCount) {
                            i3 = childCount;
                        } else {
                            i = childCount;
                        }
                    }
                    if (bz >= (i + i3) / 2) {
                        i = i3;
                    }
                    m14644a(coordinatorLayout, appBarLayout, C17435a.clamp(i, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        /* renamed from: l */
        private static boolean m14646l(int i, int i2) {
            return (i & i2) == i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:58:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00b1  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:56:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0054  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00b1  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0054  */
        /* JADX WARNING: Removed duplicated region for block: B:56:? A:{SYNTHETIC, RETURN} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        private static void m14645a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, boolean z) {
            int i3;
            View view;
            Object obj = null;
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    view = childAt;
                    break;
                }
            }
            view = null;
            if (view != null) {
                boolean z2;
                int i4 = ((LayoutParams) view.getLayoutParams()).f2175mI;
                if ((i4 & 1) != 0) {
                    abs = C0477s.m909aa(view);
                    if (i2 > 0 && (i4 & 12) != 0) {
                        z2 = (-i) >= (view.getBottom() - abs) - appBarLayout.getTopInset();
                        if (appBarLayout.f2185ms != z2) {
                        }
                        if (VERSION.SDK_INT >= 11) {
                        }
                    } else if ((i4 & 2) != 0) {
                        Object obj2;
                        z2 = (-i) >= (view.getBottom() - abs) - appBarLayout.getTopInset();
                        if (appBarLayout.f2185ms != z2) {
                            appBarLayout.f2185ms = z2;
                            appBarLayout.refreshDrawableState();
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if (VERSION.SDK_INT >= 11) {
                            if (!z) {
                                if (obj2 != null) {
                                    List J = coordinatorLayout.f16726pq.mo31809J(appBarLayout);
                                    coordinatorLayout.f16728ps.clear();
                                    if (J != null) {
                                        coordinatorLayout.f16728ps.addAll(J);
                                    }
                                    List list = coordinatorLayout.f16728ps;
                                    childCount = list.size();
                                    for (i3 = 0; i3 < childCount; i3++) {
                                        android.support.design.widget.CoordinatorLayout.Behavior behavior = ((C31839d) ((View) list.get(i3)).getLayoutParams()).f14560pH;
                                        if (behavior instanceof ScrollingViewBehavior) {
                                            if (((ScrollingViewBehavior) behavior).f5104qV != 0) {
                                                obj = 1;
                                            }
                                            if (obj == null) {
                                                return;
                                            }
                                        }
                                    }
                                    if (obj == null) {
                                    }
                                } else {
                                    return;
                                }
                            }
                            appBarLayout.jumpDrawablesToCurrentState();
                            return;
                        }
                        return;
                    }
                }
                z2 = false;
                if (appBarLayout.f2185ms != z2) {
                }
                if (VERSION.SDK_INT >= 11) {
                }
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: bz */
        public final int mo18131bz() {
            return super.mo18130bB() + this.f2167mv;
        }

        /* Access modifiers changed, original: final|synthetic */
        /* renamed from: bA */
        public final /* synthetic */ boolean mo18129bA() {
            if (this.f2166mB != null) {
                return this.f2166mB.mo18135bC();
            }
            if (this.f2165mA != null) {
                View view = (View) this.f2165mA.get();
                if (view == null || !view.isShown() || view.canScrollVertically(-1)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        /* renamed from: mI */
        int f2175mI = 1;
        /* renamed from: mJ */
        Interpolator f2176mJ;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37096a.AppBarLayout_Layout);
            this.f2175mI = obtainStyledAttributes.getInt(0, 0);
            if (obtainStyledAttributes.hasValue(1)) {
                this.f2176mJ = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(1, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.widget.LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: android.support.design.widget.AppBarLayout$a */
    public interface C8325a {
        /* renamed from: H */
        void mo18157H(int i);
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        /* renamed from: G */
        public final /* bridge */ /* synthetic */ boolean mo18118G(int i) {
            return super.mo18118G(i);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo18125a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.mo18125a(coordinatorLayout, view, i, i2, i3, i4);
        }

        /* renamed from: bB */
        public final /* bridge */ /* synthetic */ int mo18130bB() {
            return super.mo18130bB();
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37096a.ScrollingViewBehavior_Layout);
            this.f5104qV = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: e */
        public final boolean mo18160e(View view) {
            return view instanceof AppBarLayout;
        }

        /* renamed from: a */
        public final boolean mo18158a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout e = m14670e(coordinatorLayout.mo66198p(view));
            if (e != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f5101qS;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    boolean z2;
                    if (z) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    e.mo18139d(false, z2, true);
                    return true;
                }
            }
            return false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: f */
        public final float mo18161f(View view) {
            if (view instanceof AppBarLayout) {
                int bz;
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                android.support.design.widget.CoordinatorLayout.Behavior behavior = ((C31839d) appBarLayout.getLayoutParams()).f14560pH;
                if (behavior instanceof Behavior) {
                    bz = ((Behavior) behavior).mo18131bz();
                } else {
                    bz = 0;
                }
                if (downNestedPreScrollRange != 0 && totalScrollRange + bz <= downNestedPreScrollRange) {
                    return 0.0f;
                }
                totalScrollRange -= downNestedPreScrollRange;
                if (totalScrollRange != 0) {
                    return (((float) bz) / ((float) totalScrollRange)) + 1.0f;
                }
            }
            return 0.0f;
        }

        /* renamed from: e */
        private static AppBarLayout m14670e(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: g */
        public final int mo18163g(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.mo18163g(view);
        }

        /* renamed from: a */
        public final boolean mo18159a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            android.support.design.widget.CoordinatorLayout.Behavior behavior = ((C31839d) view2.getLayoutParams()).f14560pH;
            if (behavior instanceof Behavior) {
                int bottom = view2.getBottom() - view.getTop();
                C0477s.m951q(view, ((((Behavior) behavior).f2167mv + bottom) + this.f5103qU) - mo42244r(view2));
            }
            return false;
        }
    }

    /* renamed from: android.support.design.widget.AppBarLayout$1 */
    class C83261 implements C0472o {
        C83261() {
        }

        /* renamed from: a */
        public final C0451aa mo1083a(View view, C0451aa c0451aa) {
            AppBarLayout appBarLayout = AppBarLayout.this;
            Object obj = null;
            if (C0477s.m920al(appBarLayout)) {
                obj = c0451aa;
            }
            if (!C37121i.equals(appBarLayout.f2182mp, obj)) {
                appBarLayout.f2182mp = obj;
                appBarLayout.mo18137by();
            }
            return c0451aa;
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        C41488o.m72457G(context);
        if (VERSION.SDK_INT >= 21) {
            C41491r.m72464v(this);
            C41491r.m72462a(this, attributeSet);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37096a.AppBarLayout, 0, C25738R.style.f11376yk);
        C0477s.m904a((View) this, obtainStyledAttributes.getDrawable(0));
        if (obtainStyledAttributes.hasValue(4)) {
            mo18139d(obtainStyledAttributes.getBoolean(4, false), false, false);
        }
        if (VERSION.SDK_INT >= 21 && obtainStyledAttributes.hasValue(3)) {
            C41491r.m72463b(this, (float) obtainStyledAttributes.getDimensionPixelSize(3, 0));
        }
        if (VERSION.SDK_INT >= 26) {
            if (obtainStyledAttributes.hasValue(2)) {
                setKeyboardNavigationCluster(obtainStyledAttributes.getBoolean(2, false));
            }
            if (obtainStyledAttributes.hasValue(1)) {
                setTouchscreenBlocksFocus(obtainStyledAttributes.getBoolean(1, false));
            }
        }
        obtainStyledAttributes.recycle();
        C0477s.m906a((View) this, new C83261());
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        mo18137by();
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean z2;
        super.onLayout(z, i, i2, i3, i4);
        mo18137by();
        this.f2180mn = false;
        int childCount = getChildCount();
        for (i5 = 0; i5 < childCount; i5++) {
            if (((LayoutParams) getChildAt(i5).getLayoutParams()).f2176mJ != null) {
                this.f2180mn = true;
                break;
            }
        }
        childCount = getChildCount();
        for (i5 = 0; i5 < childCount; i5++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
            if ((layoutParams.f2175mI & 1) != 1 || (layoutParams.f2175mI & 10) == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        if (this.f2184mr != z2) {
            this.f2184mr = z2;
            refreshDrawableState();
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: by */
    public final void mo18137by() {
        this.f2177mk = -1;
        this.f2178ml = -1;
        this.f2179mm = -1;
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setExpanded(boolean z) {
        mo18139d(z, C0477s.m927as(this), true);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final void mo18139d(boolean z, boolean z2, boolean z3) {
        int i = 0;
        int i2 = (z2 ? 4 : 0) | (z ? 1 : 2);
        if (z3) {
            i = 8;
        }
        this.f2181mo = i | i2;
        requestLayout();
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* renamed from: c */
    private LayoutParams m14665c(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* renamed from: a */
    private static LayoutParams m14664a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (VERSION.SDK_INT >= 19 && (layoutParams instanceof android.widget.LinearLayout.LayoutParams)) {
            return new LayoutParams((android.widget.LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final int getTotalScrollRange() {
        if (this.f2177mk != -1) {
            return this.f2177mk;
        }
        int aa;
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.f2175mI;
            if ((i3 & 1) == 0) {
                break;
            }
            i += layoutParams.bottomMargin + (measuredHeight + layoutParams.topMargin);
            if ((i3 & 2) != 0) {
                aa = i - C0477s.m909aa(childAt);
                break;
            }
        }
        aa = i;
        aa = Math.max(0, aa - getTopInset());
        this.f2177mk = aa;
        return aa;
    }

    /* Access modifiers changed, original: 0000 */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* Access modifiers changed, original: 0000 */
    public int getDownNestedPreScrollRange() {
        if (this.f2178ml != -1) {
            return this.f2178ml;
        }
        int i;
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.f2175mI;
            if ((i3 & 5) != 5) {
                if (i2 > 0) {
                    break;
                }
                i = i2;
            } else {
                i = (layoutParams.bottomMargin + layoutParams.topMargin) + i2;
                if ((i3 & 8) != 0) {
                    i += C0477s.m909aa(childAt);
                } else if ((i3 & 2) != 0) {
                    i += measuredHeight - C0477s.m909aa(childAt);
                } else {
                    i += measuredHeight - getTopInset();
                }
            }
            childCount--;
            i2 = i;
        }
        i = Math.max(0, i2);
        this.f2178ml = i;
        return i;
    }

    /* Access modifiers changed, original: 0000 */
    public int getDownNestedScrollRange() {
        if (this.f2179mm != -1) {
            return this.f2179mm;
        }
        int i;
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (layoutParams.topMargin + layoutParams.bottomMargin);
            i = layoutParams.f2175mI;
            if ((i & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i & 2) != 0) {
                i = i2 - (C0477s.m909aa(childAt) + getTopInset());
                break;
            }
        }
        i = i2;
        i = Math.max(0, i);
        this.f2179mm = i;
        return i;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: F */
    public final void mo18136F(int i) {
        if (this.f2183mq != null) {
            int size = this.f2183mq.size();
            for (int i2 = 0; i2 < size; i2++) {
                C8325a c8325a = (C8325a) this.f2183mq.get(i2);
                if (c8325a != null) {
                    c8325a.mo18157H(i);
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int aa = C0477s.m909aa(this);
        if (aa != 0) {
            return (aa * 2) + topInset;
        }
        aa = getChildCount();
        aa = aa > 0 ? C0477s.m909aa(getChildAt(aa - 1)) : 0;
        if (aa != 0) {
            return (aa * 2) + topInset;
        }
        return getHeight() / 3;
    }

    /* Access modifiers changed, original: protected */
    public int[] onCreateDrawableState(int i) {
        if (this.f2186mt == null) {
            this.f2186mt = new int[2];
        }
        int[] iArr = this.f2186mt;
        int[] onCreateDrawableState = super.onCreateDrawableState(iArr.length + i);
        iArr[0] = this.f2184mr ? C25738R.attr.f5582cy : -2130772103;
        int i2 = (this.f2184mr && this.f2185ms) ? C25738R.attr.f5581cx : -2130772102;
        iArr[1] = i2;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (VERSION.SDK_INT >= 21) {
            C41491r.m72463b(this, f);
        }
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    /* Access modifiers changed, original: 0000 */
    public int getPendingAction() {
        return this.f2181mo;
    }

    /* Access modifiers changed, original: final */
    public final int getTopInset() {
        return this.f2182mp != null ? this.f2182mp.getSystemWindowInsetTop() : 0;
    }
}
