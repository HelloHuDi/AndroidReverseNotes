package android.support.v4.view;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
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

public final class s {
    static final j Na;

    static class j {
        private static Field Ne;
        private static boolean Nf;
        private static Field Ng;
        private static boolean Nh;
        private static WeakHashMap<View, String> Ni;
        private static final AtomicInteger Nj = new AtomicInteger(1);
        static Field Nl;
        static boolean Nm = false;
        WeakHashMap<View, w> Nk = null;

        j() {
        }

        public static void a(View view, a aVar) {
            view.setAccessibilityDelegate(aVar == null ? null : aVar.getBridge());
        }

        public static boolean P(View view) {
            if (Nm) {
                return false;
            }
            if (Nl == null) {
                try {
                    Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                    Nl = declaredField;
                    declaredField.setAccessible(true);
                } catch (Throwable th) {
                    Nm = true;
                    return false;
                }
            }
            try {
                if (Nl.get(view) != null) {
                    return true;
                }
                return false;
            } catch (Throwable th2) {
                Nm = true;
                return false;
            }
        }

        public boolean Q(View view) {
            return false;
        }

        public void d(View view, boolean z) {
        }

        public void R(View view) {
            view.postInvalidate();
        }

        public void c(View view, int i, int i2, int i3, int i4) {
            view.postInvalidate(i, i2, i3, i4);
        }

        public int S(View view) {
            return 0;
        }

        public void o(View view, int i) {
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return false;
        }

        public void a(View view, Paint paint) {
            view.setLayerType(view.getLayerType(), paint);
            view.invalidate();
        }

        public int T(View view) {
            return 0;
        }

        public ViewParent U(View view) {
            return view.getParent();
        }

        public void V(View view) {
        }

        public int W(View view) {
            return view.getPaddingLeft();
        }

        public int X(View view) {
            return view.getPaddingRight();
        }

        public void d(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public boolean am(View view) {
            return true;
        }

        public int Z(View view) {
            if (!Nf) {
                try {
                    Field declaredField = View.class.getDeclaredField("mMinWidth");
                    Ne = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                }
                Nf = true;
            }
            if (Ne != null) {
                try {
                    return ((Integer) Ne.get(view)).intValue();
                } catch (Exception e2) {
                }
            }
            return 0;
        }

        public int aa(View view) {
            if (!Nh) {
                try {
                    Field declaredField = View.class.getDeclaredField("mMinHeight");
                    Ng = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                }
                Nh = true;
            }
            if (Ng != null) {
                try {
                    return ((Integer) Ng.get(view)).intValue();
                } catch (Exception e2) {
                }
            }
            return 0;
        }

        public void b(View view, String str) {
            if (Ni == null) {
                Ni = new WeakHashMap();
            }
            Ni.put(view, str);
        }

        public String ai(View view) {
            if (Ni == null) {
                return null;
            }
            return (String) Ni.get(view);
        }

        public int aj(View view) {
            return 0;
        }

        public void ak(View view) {
        }

        public void h(View view, float f) {
        }

        public float ag(View view) {
            return 0.0f;
        }

        public void i(View view, float f) {
        }

        public float ah(View view) {
            return 0.0f;
        }

        public void c(View view, Rect rect) {
        }

        public Rect au(View view) {
            return null;
        }

        public boolean al(View view) {
            return false;
        }

        public void a(View view, o oVar) {
        }

        public aa a(View view, aa aaVar) {
            return aaVar;
        }

        public aa b(View view, aa aaVar) {
            return aaVar;
        }

        public boolean an(View view) {
            return false;
        }

        public boolean aq(View view) {
            if (view instanceof i) {
                return ((i) view).isNestedScrollingEnabled();
            }
            return false;
        }

        public void a(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        public ColorStateList ao(View view) {
            return view instanceof r ? ((r) view).getSupportBackgroundTintList() : null;
        }

        public void a(View view, ColorStateList colorStateList) {
            if (view instanceof r) {
                ((r) view).setSupportBackgroundTintList(colorStateList);
            }
        }

        public void a(View view, Mode mode) {
            if (view instanceof r) {
                ((r) view).setSupportBackgroundTintMode(mode);
            }
        }

        public Mode ap(View view) {
            return view instanceof r ? ((r) view).getSupportBackgroundTintMode() : null;
        }

        public void ar(View view) {
            if (view instanceof i) {
                ((i) view).stopNestedScroll();
            }
        }

        public boolean as(View view) {
            return view.getWidth() > 0 && view.getHeight() > 0;
        }

        public float at(View view) {
            return ah(view) + ag(view);
        }

        public boolean av(View view) {
            return view.getWindowToken() != null;
        }

        public boolean aw(View view) {
            return false;
        }

        public void s(View view, int i) {
        }

        public void r(View view, int i) {
            view.offsetLeftAndRight(i);
            if (view.getVisibility() == 0) {
                ay(view);
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    ay((View) parent);
                }
            }
        }

        public void q(View view, int i) {
            view.offsetTopAndBottom(i);
            if (view.getVisibility() == 0) {
                ay(view);
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    ay((View) parent);
                }
            }
        }

        private static void ay(View view) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
        }

        public void a(View view, q qVar) {
        }

        public Display ax(View view) {
            if (av(view)) {
                return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
            }
            return null;
        }

        public static void onInitializeAccessibilityNodeInfo(View view, android.support.v4.view.a.b bVar) {
            view.onInitializeAccessibilityNodeInfo(bVar.NG);
        }

        public void b(View view, Runnable runnable) {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }

        public void a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    static class a extends j {
        a() {
        }

        public final boolean aw(View view) {
            return view.hasOnClickListeners();
        }
    }

    static class b extends a {
        b() {
        }

        public final boolean Q(View view) {
            return view.hasTransientState();
        }

        public final void d(View view, boolean z) {
            view.setHasTransientState(z);
        }

        public final void R(View view) {
            view.postInvalidateOnAnimation();
        }

        public final void c(View view, int i, int i2, int i3, int i4) {
            view.postInvalidateOnAnimation(i, i2, i3, i4);
        }

        public final void b(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public final void a(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        public final int S(View view) {
            return view.getImportantForAccessibility();
        }

        public void o(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return view.performAccessibilityAction(i, bundle);
        }

        public final ViewParent U(View view) {
            return view.getParentForAccessibility();
        }

        public final int Z(View view) {
            return view.getMinimumWidth();
        }

        public final int aa(View view) {
            return view.getMinimumHeight();
        }

        public void ak(View view) {
            view.requestFitSystemWindows();
        }

        public final boolean al(View view) {
            return view.getFitsSystemWindows();
        }

        public final boolean am(View view) {
            return view.hasOverlappingRendering();
        }

        public final void a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }
    }

    static class c extends b {
        c() {
        }

        public final void a(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        public final int T(View view) {
            return view.getLayoutDirection();
        }

        public final int W(View view) {
            return view.getPaddingStart();
        }

        public final int X(View view) {
            return view.getPaddingEnd();
        }

        public final void d(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }

        public final int aj(View view) {
            return view.getWindowSystemUiVisibility();
        }

        public final boolean an(View view) {
            return view.isPaddingRelative();
        }

        public final Display ax(View view) {
            return view.getDisplay();
        }
    }

    static class d extends c {
        d() {
        }

        public final void c(View view, Rect rect) {
            view.setClipBounds(rect);
        }

        public final Rect au(View view) {
            return view.getClipBounds();
        }
    }

    static class e extends d {
        e() {
        }

        public final void V(View view) {
            view.setAccessibilityLiveRegion(1);
        }

        public final void o(View view, int i) {
            view.setImportantForAccessibility(i);
        }

        public final boolean as(View view) {
            return view.isLaidOut();
        }

        public final boolean av(View view) {
            return view.isAttachedToWindow();
        }
    }

    static class f extends e {
        private static ThreadLocal<Rect> Nb;

        f() {
        }

        public final void b(View view, String str) {
            view.setTransitionName(str);
        }

        public final String ai(View view) {
            return view.getTransitionName();
        }

        public final void ak(View view) {
            view.requestApplyInsets();
        }

        public final void h(View view, float f) {
            view.setElevation(f);
        }

        public final float ag(View view) {
            return view.getElevation();
        }

        public final void i(View view, float f) {
            view.setTranslationZ(f);
        }

        public final float ah(View view) {
            return view.getTranslationZ();
        }

        public final void a(View view, final o oVar) {
            if (oVar == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        return (WindowInsets) aa.c(oVar.a(view, aa.G(windowInsets)));
                    }
                });
            }
        }

        public final boolean aq(View view) {
            return view.isNestedScrollingEnabled();
        }

        public final void ar(View view) {
            view.stopNestedScroll();
        }

        public final ColorStateList ao(View view) {
            return view.getBackgroundTintList();
        }

        public final void a(View view, ColorStateList colorStateList) {
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

        public final void a(View view, Mode mode) {
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

        public final Mode ap(View view) {
            return view.getBackgroundTintMode();
        }

        public final aa a(View view, aa aaVar) {
            Object obj = (WindowInsets) aa.c(aaVar);
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(obj);
            if (onApplyWindowInsets != obj) {
                obj = new WindowInsets(onApplyWindowInsets);
            }
            return aa.G(obj);
        }

        public final aa b(View view, aa aaVar) {
            Object obj = (WindowInsets) aa.c(aaVar);
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(obj);
            if (dispatchApplyWindowInsets != obj) {
                obj = new WindowInsets(dispatchApplyWindowInsets);
            }
            return aa.G(obj);
        }

        public final float at(View view) {
            return view.getZ();
        }

        public void r(View view, int i) {
            Object obj;
            Rect eq = eq();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                eq.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                obj = !eq.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
            } else {
                obj = null;
            }
            super.r(view, i);
            if (obj != null && eq.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(eq);
            }
        }

        public void q(View view, int i) {
            Object obj;
            Rect eq = eq();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                eq.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                obj = !eq.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
            } else {
                obj = null;
            }
            super.q(view, i);
            if (obj != null && eq.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(eq);
            }
        }

        private static Rect eq() {
            if (Nb == null) {
                Nb = new ThreadLocal();
            }
            Rect rect = (Rect) Nb.get();
            if (rect == null) {
                rect = new Rect();
                Nb.set(rect);
            }
            rect.setEmpty();
            return rect;
        }
    }

    static class g extends f {
        g() {
        }

        public final void s(View view, int i) {
            view.setScrollIndicators(i, 3);
        }

        public final void r(View view, int i) {
            view.offsetLeftAndRight(i);
        }

        public final void q(View view, int i) {
            view.offsetTopAndBottom(i);
        }
    }

    static class h extends g {
        h() {
        }

        public final void a(View view, q qVar) {
            Object obj;
            if (qVar != null) {
                obj = qVar.MZ;
            } else {
                obj = null;
            }
            view.setPointerIcon((PointerIcon) obj);
        }
    }

    static class i extends h {
        i() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            Na = new i();
        } else if (VERSION.SDK_INT >= 24) {
            Na = new h();
        } else if (VERSION.SDK_INT >= 23) {
            Na = new g();
        } else if (VERSION.SDK_INT >= 21) {
            Na = new f();
        } else if (VERSION.SDK_INT >= 19) {
            Na = new e();
        } else if (VERSION.SDK_INT >= 18) {
            Na = new d();
        } else if (VERSION.SDK_INT >= 17) {
            Na = new c();
        } else if (VERSION.SDK_INT >= 16) {
            Na = new b();
        } else if (VERSION.SDK_INT >= 15) {
            Na = new a();
        } else {
            Na = new j();
        }
    }

    @Deprecated
    public static boolean m(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    @Deprecated
    public static boolean n(View view, int i) {
        return view.canScrollVertically(i);
    }

    @Deprecated
    public static int O(View view) {
        return view.getOverScrollMode();
    }

    public static void onInitializeAccessibilityNodeInfo(View view, android.support.v4.view.a.b bVar) {
        j.onInitializeAccessibilityNodeInfo(view, bVar);
    }

    public static void a(View view, a aVar) {
        j.a(view, aVar);
    }

    public static boolean P(View view) {
        return j.P(view);
    }

    public static boolean Q(View view) {
        return Na.Q(view);
    }

    public static void d(View view, boolean z) {
        Na.d(view, z);
    }

    public static void R(View view) {
        Na.R(view);
    }

    public static void c(View view, int i, int i2, int i3, int i4) {
        Na.c(view, i, i2, i3, i4);
    }

    public static void b(View view, Runnable runnable) {
        Na.b(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        Na.a(view, runnable, j);
    }

    public static int S(View view) {
        return Na.S(view);
    }

    public static void o(View view, int i) {
        Na.o(view, i);
    }

    public static boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return Na.performAccessibilityAction(view, i, bundle);
    }

    @Deprecated
    public static void p(View view, int i) {
        view.setLayerType(i, null);
    }

    public static void a(View view, Paint paint) {
        Na.a(view, paint);
    }

    public static int T(View view) {
        return Na.T(view);
    }

    public static ViewParent U(View view) {
        return Na.U(view);
    }

    public static void V(View view) {
        Na.V(view);
    }

    public static int W(View view) {
        return Na.W(view);
    }

    public static int X(View view) {
        return Na.X(view);
    }

    public static void d(View view, int i, int i2, int i3, int i4) {
        Na.d(view, i, i2, i3, i4);
    }

    @Deprecated
    public static float Y(View view) {
        return view.getTranslationY();
    }

    public static int Z(View view) {
        return Na.Z(view);
    }

    public static int aa(View view) {
        return Na.aa(view);
    }

    public static w ab(View view) {
        j jVar = Na;
        if (jVar.Nk == null) {
            jVar.Nk = new WeakHashMap();
        }
        w wVar = (w) jVar.Nk.get(view);
        if (wVar != null) {
            return wVar;
        }
        wVar = new w(view);
        jVar.Nk.put(view, wVar);
        return wVar;
    }

    @Deprecated
    public static void ac(View view) {
        view.setTranslationX(0.0f);
    }

    @Deprecated
    public static void d(View view, float f) {
        view.setTranslationY(f);
    }

    @Deprecated
    public static void e(View view, float f) {
        view.setAlpha(f);
    }

    @Deprecated
    public static void ad(View view) {
        view.setRotation(0.0f);
    }

    @Deprecated
    public static void ae(View view) {
        view.setRotationX(0.0f);
    }

    @Deprecated
    public static void af(View view) {
        view.setRotationY(0.0f);
    }

    @Deprecated
    public static void f(View view, float f) {
        view.setScaleX(f);
    }

    @Deprecated
    public static void g(View view, float f) {
        view.setScaleY(f);
    }

    public static void h(View view, float f) {
        Na.h(view, f);
    }

    public static float ag(View view) {
        return Na.ag(view);
    }

    public static void i(View view, float f) {
        Na.i(view, f);
    }

    public static float ah(View view) {
        return Na.ah(view);
    }

    public static void b(View view, String str) {
        Na.b(view, str);
    }

    public static String ai(View view) {
        return Na.ai(view);
    }

    public static int aj(View view) {
        return Na.aj(view);
    }

    public static void ak(View view) {
        Na.ak(view);
    }

    public static boolean al(View view) {
        return Na.al(view);
    }

    @Deprecated
    public static void e(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void a(View view, o oVar) {
        Na.a(view, oVar);
    }

    public static aa a(View view, aa aaVar) {
        return Na.a(view, aaVar);
    }

    public static aa b(View view, aa aaVar) {
        return Na.b(view, aaVar);
    }

    public static boolean am(View view) {
        return Na.am(view);
    }

    public static boolean an(View view) {
        return Na.an(view);
    }

    public static void a(View view, Drawable drawable) {
        Na.a(view, drawable);
    }

    public static ColorStateList ao(View view) {
        return Na.ao(view);
    }

    public static void a(View view, ColorStateList colorStateList) {
        Na.a(view, colorStateList);
    }

    public static Mode ap(View view) {
        return Na.ap(view);
    }

    public static void a(View view, Mode mode) {
        Na.a(view, mode);
    }

    public static boolean aq(View view) {
        return Na.aq(view);
    }

    public static void ar(View view) {
        Na.ar(view);
    }

    public static boolean as(View view) {
        return Na.as(view);
    }

    public static float at(View view) {
        return Na.at(view);
    }

    public static void q(View view, int i) {
        Na.q(view, i);
    }

    public static void r(View view, int i) {
        Na.r(view, i);
    }

    public static void c(View view, Rect rect) {
        Na.c(view, rect);
    }

    public static Rect au(View view) {
        return Na.au(view);
    }

    public static boolean av(View view) {
        return Na.av(view);
    }

    public static boolean aw(View view) {
        return Na.aw(view);
    }

    public static void s(View view, int i) {
        Na.s(view, i);
    }

    public static void a(View view, q qVar) {
        Na.a(view, qVar);
    }

    public static Display ax(View view) {
        return Na.ax(view);
    }
}
