package android.support.p057v4.view;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.view.p067a.C0445b;
import android.view.Display;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: android.support.v4.view.s */
public final class C0477s {
    /* renamed from: Na */
    static final C0476j f578Na;

    /* renamed from: android.support.v4.view.s$j */
    static class C0476j {
        /* renamed from: Ne */
        private static Field f569Ne;
        /* renamed from: Nf */
        private static boolean f570Nf;
        /* renamed from: Ng */
        private static Field f571Ng;
        /* renamed from: Nh */
        private static boolean f572Nh;
        /* renamed from: Ni */
        private static WeakHashMap<View, String> f573Ni;
        /* renamed from: Nj */
        private static final AtomicInteger f574Nj = new AtomicInteger(1);
        /* renamed from: Nl */
        static Field f575Nl;
        /* renamed from: Nm */
        static boolean f576Nm = false;
        /* renamed from: Nk */
        WeakHashMap<View, C0497w> f577Nk = null;

        C0476j() {
        }

        /* renamed from: a */
        public static void m837a(View view, C0449a c0449a) {
            view.setAccessibilityDelegate(c0449a == null ? null : c0449a.getBridge());
        }

        /* renamed from: P */
        public static boolean m836P(View view) {
            if (f576Nm) {
                return false;
            }
            if (f575Nl == null) {
                try {
                    Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                    f575Nl = declaredField;
                    declaredField.setAccessible(true);
                } catch (Throwable th) {
                    f576Nm = true;
                    return false;
                }
            }
            try {
                if (f575Nl.get(view) != null) {
                    return true;
                }
                return false;
            } catch (Throwable th2) {
                f576Nm = true;
                return false;
            }
        }

        /* renamed from: Q */
        public boolean mo1089Q(View view) {
            return false;
        }

        /* renamed from: d */
        public void mo1131d(View view, boolean z) {
        }

        /* renamed from: R */
        public void mo1090R(View view) {
            view.postInvalidate();
        }

        /* renamed from: c */
        public void mo1128c(View view, int i, int i2, int i3, int i4) {
            view.postInvalidate(i, i2, i3, i4);
        }

        /* renamed from: S */
        public int mo1091S(View view) {
            return 0;
        }

        /* renamed from: o */
        public void mo1134o(View view, int i) {
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return false;
        }

        /* renamed from: a */
        public void mo1100a(View view, Paint paint) {
            view.setLayerType(view.getLayerType(), paint);
            view.invalidate();
        }

        /* renamed from: T */
        public int mo1092T(View view) {
            return 0;
        }

        /* renamed from: U */
        public ViewParent mo1093U(View view) {
            return view.getParent();
        }

        /* renamed from: V */
        public void mo1094V(View view) {
        }

        /* renamed from: W */
        public int mo1095W(View view) {
            return view.getPaddingLeft();
        }

        /* renamed from: X */
        public int mo1096X(View view) {
            return view.getPaddingRight();
        }

        /* renamed from: d */
        public void mo1130d(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        /* renamed from: am */
        public boolean mo1113am(View view) {
            return true;
        }

        /* renamed from: Z */
        public int mo1097Z(View view) {
            if (!f570Nf) {
                try {
                    Field declaredField = View.class.getDeclaredField("mMinWidth");
                    f569Ne = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                }
                f570Nf = true;
            }
            if (f569Ne != null) {
                try {
                    return ((Integer) f569Ne.get(view)).intValue();
                } catch (Exception e2) {
                }
            }
            return 0;
        }

        /* renamed from: aa */
        public int mo1106aa(View view) {
            if (!f572Nh) {
                try {
                    Field declaredField = View.class.getDeclaredField("mMinHeight");
                    f571Ng = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                }
                f572Nh = true;
            }
            if (f571Ng != null) {
                try {
                    return ((Integer) f571Ng.get(view)).intValue();
                } catch (Exception e2) {
                }
            }
            return 0;
        }

        /* renamed from: b */
        public void mo1127b(View view, String str) {
            if (f573Ni == null) {
                f573Ni = new WeakHashMap();
            }
            f573Ni.put(view, str);
        }

        /* renamed from: ai */
        public String mo1109ai(View view) {
            if (f573Ni == null) {
                return null;
            }
            return (String) f573Ni.get(view);
        }

        /* renamed from: aj */
        public int mo1110aj(View view) {
            return 0;
        }

        /* renamed from: ak */
        public void mo1111ak(View view) {
        }

        /* renamed from: h */
        public void mo1132h(View view, float f) {
        }

        /* renamed from: ag */
        public float mo1107ag(View view) {
            return 0.0f;
        }

        /* renamed from: i */
        public void mo1133i(View view, float f) {
        }

        /* renamed from: ah */
        public float mo1108ah(View view) {
            return 0.0f;
        }

        /* renamed from: c */
        public void mo1129c(View view, Rect rect) {
        }

        /* renamed from: au */
        public Rect mo1121au(View view) {
            return null;
        }

        /* renamed from: al */
        public boolean mo1112al(View view) {
            return false;
        }

        /* renamed from: a */
        public void mo1103a(View view, C0472o c0472o) {
        }

        /* renamed from: a */
        public C0451aa mo1098a(View view, C0451aa c0451aa) {
            return c0451aa;
        }

        /* renamed from: b */
        public C0451aa mo1125b(View view, C0451aa c0451aa) {
            return c0451aa;
        }

        /* renamed from: an */
        public boolean mo1114an(View view) {
            return false;
        }

        /* renamed from: aq */
        public boolean mo1117aq(View view) {
            if (view instanceof C0468i) {
                return ((C0468i) view).isNestedScrollingEnabled();
            }
            return false;
        }

        /* renamed from: a */
        public void mo1102a(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        /* renamed from: ao */
        public ColorStateList mo1115ao(View view) {
            return view instanceof C0474r ? ((C0474r) view).getSupportBackgroundTintList() : null;
        }

        /* renamed from: a */
        public void mo1099a(View view, ColorStateList colorStateList) {
            if (view instanceof C0474r) {
                ((C0474r) view).setSupportBackgroundTintList(colorStateList);
            }
        }

        /* renamed from: a */
        public void mo1101a(View view, Mode mode) {
            if (view instanceof C0474r) {
                ((C0474r) view).setSupportBackgroundTintMode(mode);
            }
        }

        /* renamed from: ap */
        public Mode mo1116ap(View view) {
            return view instanceof C0474r ? ((C0474r) view).getSupportBackgroundTintMode() : null;
        }

        /* renamed from: ar */
        public void mo1118ar(View view) {
            if (view instanceof C0468i) {
                ((C0468i) view).stopNestedScroll();
            }
        }

        /* renamed from: as */
        public boolean mo1119as(View view) {
            return view.getWidth() > 0 && view.getHeight() > 0;
        }

        /* renamed from: at */
        public float mo1120at(View view) {
            return mo1108ah(view) + mo1107ag(view);
        }

        /* renamed from: av */
        public boolean mo1122av(View view) {
            return view.getWindowToken() != null;
        }

        /* renamed from: aw */
        public boolean mo1123aw(View view) {
            return false;
        }

        /* renamed from: s */
        public void mo1138s(View view, int i) {
        }

        /* renamed from: r */
        public void mo1137r(View view, int i) {
            view.offsetLeftAndRight(i);
            if (view.getVisibility() == 0) {
                C0476j.m838ay(view);
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    C0476j.m838ay((View) parent);
                }
            }
        }

        /* renamed from: q */
        public void mo1136q(View view, int i) {
            view.offsetTopAndBottom(i);
            if (view.getVisibility() == 0) {
                C0476j.m838ay(view);
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    C0476j.m838ay((View) parent);
                }
            }
        }

        /* renamed from: ay */
        private static void m838ay(View view) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
        }

        /* renamed from: a */
        public void mo1104a(View view, C0473q c0473q) {
        }

        /* renamed from: ax */
        public Display mo1124ax(View view) {
            if (mo1122av(view)) {
                return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
            }
            return null;
        }

        public static void onInitializeAccessibilityNodeInfo(View view, C0445b c0445b) {
            view.onInitializeAccessibilityNodeInfo(c0445b.f546NG);
        }

        /* renamed from: b */
        public void mo1126b(View view, Runnable runnable) {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }

        /* renamed from: a */
        public void mo1105a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    /* renamed from: android.support.v4.view.s$a */
    static class C0478a extends C0476j {
        C0478a() {
        }

        /* renamed from: aw */
        public final boolean mo1123aw(View view) {
            return view.hasOnClickListeners();
        }
    }

    /* renamed from: android.support.v4.view.s$b */
    static class C0479b extends C0478a {
        C0479b() {
        }

        /* renamed from: Q */
        public final boolean mo1089Q(View view) {
            return view.hasTransientState();
        }

        /* renamed from: d */
        public final void mo1131d(View view, boolean z) {
            view.setHasTransientState(z);
        }

        /* renamed from: R */
        public final void mo1090R(View view) {
            view.postInvalidateOnAnimation();
        }

        /* renamed from: c */
        public final void mo1128c(View view, int i, int i2, int i3, int i4) {
            view.postInvalidateOnAnimation(i, i2, i3, i4);
        }

        /* renamed from: b */
        public final void mo1126b(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        /* renamed from: a */
        public final void mo1105a(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        /* renamed from: S */
        public final int mo1091S(View view) {
            return view.getImportantForAccessibility();
        }

        /* renamed from: o */
        public void mo1134o(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return view.performAccessibilityAction(i, bundle);
        }

        /* renamed from: U */
        public final ViewParent mo1093U(View view) {
            return view.getParentForAccessibility();
        }

        /* renamed from: Z */
        public final int mo1097Z(View view) {
            return view.getMinimumWidth();
        }

        /* renamed from: aa */
        public final int mo1106aa(View view) {
            return view.getMinimumHeight();
        }

        /* renamed from: ak */
        public void mo1111ak(View view) {
            view.requestFitSystemWindows();
        }

        /* renamed from: al */
        public final boolean mo1112al(View view) {
            return view.getFitsSystemWindows();
        }

        /* renamed from: am */
        public final boolean mo1113am(View view) {
            return view.hasOverlappingRendering();
        }

        /* renamed from: a */
        public final void mo1102a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }
    }

    /* renamed from: android.support.v4.view.s$c */
    static class C0480c extends C0479b {
        C0480c() {
        }

        /* renamed from: a */
        public final void mo1100a(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        /* renamed from: T */
        public final int mo1092T(View view) {
            return view.getLayoutDirection();
        }

        /* renamed from: W */
        public final int mo1095W(View view) {
            return view.getPaddingStart();
        }

        /* renamed from: X */
        public final int mo1096X(View view) {
            return view.getPaddingEnd();
        }

        /* renamed from: d */
        public final void mo1130d(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }

        /* renamed from: aj */
        public final int mo1110aj(View view) {
            return view.getWindowSystemUiVisibility();
        }

        /* renamed from: an */
        public final boolean mo1114an(View view) {
            return view.isPaddingRelative();
        }

        /* renamed from: ax */
        public final Display mo1124ax(View view) {
            return view.getDisplay();
        }
    }

    /* renamed from: android.support.v4.view.s$d */
    static class C0481d extends C0480c {
        C0481d() {
        }

        /* renamed from: c */
        public final void mo1129c(View view, Rect rect) {
            view.setClipBounds(rect);
        }

        /* renamed from: au */
        public final Rect mo1121au(View view) {
            return view.getClipBounds();
        }
    }

    /* renamed from: android.support.v4.view.s$e */
    static class C0482e extends C0481d {
        C0482e() {
        }

        /* renamed from: V */
        public final void mo1094V(View view) {
            view.setAccessibilityLiveRegion(1);
        }

        /* renamed from: o */
        public final void mo1134o(View view, int i) {
            view.setImportantForAccessibility(i);
        }

        /* renamed from: as */
        public final boolean mo1119as(View view) {
            return view.isLaidOut();
        }

        /* renamed from: av */
        public final boolean mo1122av(View view) {
            return view.isAttachedToWindow();
        }
    }

    /* renamed from: android.support.v4.view.s$f */
    static class C0483f extends C0482e {
        /* renamed from: Nb */
        private static ThreadLocal<Rect> f579Nb;

        C0483f() {
        }

        /* renamed from: b */
        public final void mo1127b(View view, String str) {
            view.setTransitionName(str);
        }

        /* renamed from: ai */
        public final String mo1109ai(View view) {
            return view.getTransitionName();
        }

        /* renamed from: ak */
        public final void mo1111ak(View view) {
            view.requestApplyInsets();
        }

        /* renamed from: h */
        public final void mo1132h(View view, float f) {
            view.setElevation(f);
        }

        /* renamed from: ag */
        public final float mo1107ag(View view) {
            return view.getElevation();
        }

        /* renamed from: i */
        public final void mo1133i(View view, float f) {
            view.setTranslationZ(f);
        }

        /* renamed from: ah */
        public final float mo1108ah(View view) {
            return view.getTranslationZ();
        }

        /* renamed from: a */
        public final void mo1103a(View view, final C0472o c0472o) {
            if (c0472o == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        return (WindowInsets) C0451aa.m780c(c0472o.mo1083a(view, C0451aa.m779G(windowInsets)));
                    }
                });
            }
        }

        /* renamed from: aq */
        public final boolean mo1117aq(View view) {
            return view.isNestedScrollingEnabled();
        }

        /* renamed from: ar */
        public final void mo1118ar(View view) {
            view.stopNestedScroll();
        }

        /* renamed from: ao */
        public final ColorStateList mo1115ao(View view) {
            return view.getBackgroundTintList();
        }

        /* renamed from: a */
        public final void mo1099a(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? null : 1;
                if (background != null && obj != null) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        /* renamed from: a */
        public final void mo1101a(View view, Mode mode) {
            view.setBackgroundTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? null : 1;
                if (background != null && obj != null) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        /* renamed from: ap */
        public final Mode mo1116ap(View view) {
            return view.getBackgroundTintMode();
        }

        /* renamed from: a */
        public final C0451aa mo1098a(View view, C0451aa c0451aa) {
            Object obj = (WindowInsets) C0451aa.m780c(c0451aa);
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(obj);
            if (onApplyWindowInsets != obj) {
                obj = new WindowInsets(onApplyWindowInsets);
            }
            return C0451aa.m779G(obj);
        }

        /* renamed from: b */
        public final C0451aa mo1125b(View view, C0451aa c0451aa) {
            Object obj = (WindowInsets) C0451aa.m780c(c0451aa);
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(obj);
            if (dispatchApplyWindowInsets != obj) {
                obj = new WindowInsets(dispatchApplyWindowInsets);
            }
            return C0451aa.m779G(obj);
        }

        /* renamed from: at */
        public final float mo1120at(View view) {
            return view.getZ();
        }

        /* renamed from: r */
        public void mo1137r(View view, int i) {
            Object obj;
            Rect eq = C0483f.m984eq();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                eq.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                obj = !eq.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
            } else {
                obj = null;
            }
            super.mo1137r(view, i);
            if (obj != null && eq.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(eq);
            }
        }

        /* renamed from: q */
        public void mo1136q(View view, int i) {
            Object obj;
            Rect eq = C0483f.m984eq();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                eq.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                obj = !eq.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
            } else {
                obj = null;
            }
            super.mo1136q(view, i);
            if (obj != null && eq.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(eq);
            }
        }

        /* renamed from: eq */
        private static Rect m984eq() {
            if (f579Nb == null) {
                f579Nb = new ThreadLocal();
            }
            Rect rect = (Rect) f579Nb.get();
            if (rect == null) {
                rect = new Rect();
                f579Nb.set(rect);
            }
            rect.setEmpty();
            return rect;
        }
    }

    /* renamed from: android.support.v4.view.s$g */
    static class C0484g extends C0483f {
        C0484g() {
        }

        /* renamed from: s */
        public final void mo1138s(View view, int i) {
            view.setScrollIndicators(i, 3);
        }

        /* renamed from: r */
        public final void mo1137r(View view, int i) {
            view.offsetLeftAndRight(i);
        }

        /* renamed from: q */
        public final void mo1136q(View view, int i) {
            view.offsetTopAndBottom(i);
        }
    }

    /* renamed from: android.support.v4.view.s$h */
    static class C0485h extends C0484g {
        C0485h() {
        }

        /* renamed from: a */
        public final void mo1104a(View view, C0473q c0473q) {
            Object obj;
            if (c0473q != null) {
                obj = c0473q.f566MZ;
            } else {
                obj = null;
            }
            view.setPointerIcon((PointerIcon) obj);
        }
    }

    /* renamed from: android.support.v4.view.s$i */
    static class C0486i extends C0485h {
        C0486i() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f578Na = new C0486i();
        } else if (VERSION.SDK_INT >= 24) {
            f578Na = new C0485h();
        } else if (VERSION.SDK_INT >= 23) {
            f578Na = new C0484g();
        } else if (VERSION.SDK_INT >= 21) {
            f578Na = new C0483f();
        } else if (VERSION.SDK_INT >= 19) {
            f578Na = new C0482e();
        } else if (VERSION.SDK_INT >= 18) {
            f578Na = new C0481d();
        } else if (VERSION.SDK_INT >= 17) {
            f578Na = new C0480c();
        } else if (VERSION.SDK_INT >= 16) {
            f578Na = new C0479b();
        } else if (VERSION.SDK_INT >= 15) {
            f578Na = new C0478a();
        } else {
            f578Na = new C0476j();
        }
    }

    @Deprecated
    /* renamed from: m */
    public static boolean m947m(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    @Deprecated
    /* renamed from: n */
    public static boolean m948n(View view, int i) {
        return view.canScrollVertically(i);
    }

    @Deprecated
    /* renamed from: O */
    public static int m888O(View view) {
        return view.getOverScrollMode();
    }

    public static void onInitializeAccessibilityNodeInfo(View view, C0445b c0445b) {
        C0476j.onInitializeAccessibilityNodeInfo(view, c0445b);
    }

    /* renamed from: a */
    public static void m905a(View view, C0449a c0449a) {
        C0476j.m837a(view, c0449a);
    }

    /* renamed from: P */
    public static boolean m889P(View view) {
        return C0476j.m836P(view);
    }

    /* renamed from: Q */
    public static boolean m890Q(View view) {
        return f578Na.mo1089Q(view);
    }

    /* renamed from: d */
    public static void m940d(View view, boolean z) {
        f578Na.mo1131d(view, z);
    }

    /* renamed from: R */
    public static void m891R(View view) {
        f578Na.mo1090R(view);
    }

    /* renamed from: c */
    public static void m936c(View view, int i, int i2, int i3, int i4) {
        f578Na.mo1128c(view, i, i2, i3, i4);
    }

    /* renamed from: b */
    public static void m934b(View view, Runnable runnable) {
        f578Na.mo1126b(view, runnable);
    }

    /* renamed from: a */
    public static void m908a(View view, Runnable runnable, long j) {
        f578Na.mo1105a(view, runnable, j);
    }

    /* renamed from: S */
    public static int m892S(View view) {
        return f578Na.mo1091S(view);
    }

    /* renamed from: o */
    public static void m949o(View view, int i) {
        f578Na.mo1134o(view, i);
    }

    public static boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return f578Na.performAccessibilityAction(view, i, bundle);
    }

    @Deprecated
    /* renamed from: p */
    public static void m950p(View view, int i) {
        view.setLayerType(i, null);
    }

    /* renamed from: a */
    public static void m902a(View view, Paint paint) {
        f578Na.mo1100a(view, paint);
    }

    /* renamed from: T */
    public static int m893T(View view) {
        return f578Na.mo1092T(view);
    }

    /* renamed from: U */
    public static ViewParent m894U(View view) {
        return f578Na.mo1093U(view);
    }

    /* renamed from: V */
    public static void m895V(View view) {
        f578Na.mo1094V(view);
    }

    /* renamed from: W */
    public static int m896W(View view) {
        return f578Na.mo1095W(view);
    }

    /* renamed from: X */
    public static int m897X(View view) {
        return f578Na.mo1096X(view);
    }

    /* renamed from: d */
    public static void m939d(View view, int i, int i2, int i3, int i4) {
        f578Na.mo1130d(view, i, i2, i3, i4);
    }

    @Deprecated
    /* renamed from: Y */
    public static float m898Y(View view) {
        return view.getTranslationY();
    }

    /* renamed from: Z */
    public static int m899Z(View view) {
        return f578Na.mo1097Z(view);
    }

    /* renamed from: aa */
    public static int m909aa(View view) {
        return f578Na.mo1106aa(view);
    }

    /* renamed from: ab */
    public static C0497w m910ab(View view) {
        C0476j c0476j = f578Na;
        if (c0476j.f577Nk == null) {
            c0476j.f577Nk = new WeakHashMap();
        }
        C0497w c0497w = (C0497w) c0476j.f577Nk.get(view);
        if (c0497w != null) {
            return c0497w;
        }
        c0497w = new C0497w(view);
        c0476j.f577Nk.put(view, c0497w);
        return c0497w;
    }

    @Deprecated
    /* renamed from: ac */
    public static void m911ac(View view) {
        view.setTranslationX(0.0f);
    }

    @Deprecated
    /* renamed from: d */
    public static void m938d(View view, float f) {
        view.setTranslationY(f);
    }

    @Deprecated
    /* renamed from: e */
    public static void m941e(View view, float f) {
        view.setAlpha(f);
    }

    @Deprecated
    /* renamed from: ad */
    public static void m912ad(View view) {
        view.setRotation(0.0f);
    }

    @Deprecated
    /* renamed from: ae */
    public static void m913ae(View view) {
        view.setRotationX(0.0f);
    }

    @Deprecated
    /* renamed from: af */
    public static void m914af(View view) {
        view.setRotationY(0.0f);
    }

    @Deprecated
    /* renamed from: f */
    public static void m943f(View view, float f) {
        view.setScaleX(f);
    }

    @Deprecated
    /* renamed from: g */
    public static void m944g(View view, float f) {
        view.setScaleY(f);
    }

    /* renamed from: h */
    public static void m945h(View view, float f) {
        f578Na.mo1132h(view, f);
    }

    /* renamed from: ag */
    public static float m915ag(View view) {
        return f578Na.mo1107ag(view);
    }

    /* renamed from: i */
    public static void m946i(View view, float f) {
        f578Na.mo1133i(view, f);
    }

    /* renamed from: ah */
    public static float m916ah(View view) {
        return f578Na.mo1108ah(view);
    }

    /* renamed from: b */
    public static void m935b(View view, String str) {
        f578Na.mo1127b(view, str);
    }

    /* renamed from: ai */
    public static String m917ai(View view) {
        return f578Na.mo1109ai(view);
    }

    /* renamed from: aj */
    public static int m918aj(View view) {
        return f578Na.mo1110aj(view);
    }

    /* renamed from: ak */
    public static void m919ak(View view) {
        f578Na.mo1111ak(view);
    }

    /* renamed from: al */
    public static boolean m920al(View view) {
        return f578Na.mo1112al(view);
    }

    @Deprecated
    /* renamed from: e */
    public static void m942e(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    /* renamed from: a */
    public static void m906a(View view, C0472o c0472o) {
        f578Na.mo1103a(view, c0472o);
    }

    /* renamed from: a */
    public static C0451aa m900a(View view, C0451aa c0451aa) {
        return f578Na.mo1098a(view, c0451aa);
    }

    /* renamed from: b */
    public static C0451aa m933b(View view, C0451aa c0451aa) {
        return f578Na.mo1125b(view, c0451aa);
    }

    /* renamed from: am */
    public static boolean m921am(View view) {
        return f578Na.mo1113am(view);
    }

    /* renamed from: an */
    public static boolean m922an(View view) {
        return f578Na.mo1114an(view);
    }

    /* renamed from: a */
    public static void m904a(View view, Drawable drawable) {
        f578Na.mo1102a(view, drawable);
    }

    /* renamed from: ao */
    public static ColorStateList m923ao(View view) {
        return f578Na.mo1115ao(view);
    }

    /* renamed from: a */
    public static void m901a(View view, ColorStateList colorStateList) {
        f578Na.mo1099a(view, colorStateList);
    }

    /* renamed from: ap */
    public static Mode m924ap(View view) {
        return f578Na.mo1116ap(view);
    }

    /* renamed from: a */
    public static void m903a(View view, Mode mode) {
        f578Na.mo1101a(view, mode);
    }

    /* renamed from: aq */
    public static boolean m925aq(View view) {
        return f578Na.mo1117aq(view);
    }

    /* renamed from: ar */
    public static void m926ar(View view) {
        f578Na.mo1118ar(view);
    }

    /* renamed from: as */
    public static boolean m927as(View view) {
        return f578Na.mo1119as(view);
    }

    /* renamed from: at */
    public static float m928at(View view) {
        return f578Na.mo1120at(view);
    }

    /* renamed from: q */
    public static void m951q(View view, int i) {
        f578Na.mo1136q(view, i);
    }

    /* renamed from: r */
    public static void m952r(View view, int i) {
        f578Na.mo1137r(view, i);
    }

    /* renamed from: c */
    public static void m937c(View view, Rect rect) {
        f578Na.mo1129c(view, rect);
    }

    /* renamed from: au */
    public static Rect m929au(View view) {
        return f578Na.mo1121au(view);
    }

    /* renamed from: av */
    public static boolean m930av(View view) {
        return f578Na.mo1122av(view);
    }

    /* renamed from: aw */
    public static boolean m931aw(View view) {
        return f578Na.mo1123aw(view);
    }

    /* renamed from: s */
    public static void m953s(View view, int i) {
        f578Na.mo1138s(view, i);
    }

    /* renamed from: a */
    public static void m907a(View view, C0473q c0473q) {
        f578Na.mo1104a(view, c0473q);
    }

    /* renamed from: ax */
    public static Display m932ax(View view) {
        return f578Na.mo1124ax(view);
    }
}
