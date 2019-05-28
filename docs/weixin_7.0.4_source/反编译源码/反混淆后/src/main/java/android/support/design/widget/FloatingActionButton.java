package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.C37097a.C37096a;
import android.support.design.widget.C41487h.C25310c;
import android.support.design.widget.C41487h.C414842;
import android.support.design.widget.C41487h.C414853;
import android.support.design.widget.C41487h.C83461;
import android.support.design.widget.CoordinatorLayout.C17384b;
import android.support.design.widget.CoordinatorLayout.C31839d;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C31872u;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.widget.C0721k;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.p177mm.C25738R;
import java.util.List;

@C17384b(Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton {
    private int mSize;
    /* renamed from: qa */
    private ColorStateList f2188qa;
    /* renamed from: qb */
    private Mode f2189qb;
    /* renamed from: qc */
    private int f2190qc;
    /* renamed from: qd */
    private int f2191qd;
    /* renamed from: qe */
    private int f2192qe;
    /* renamed from: qf */
    int f2193qf;
    /* renamed from: qg */
    private int f2194qg;
    /* renamed from: qh */
    boolean f2195qh;
    /* renamed from: qi */
    final Rect f2196qi;
    /* renamed from: qj */
    private final Rect f2197qj;
    /* renamed from: qk */
    private C0721k f2198qk;
    /* renamed from: ql */
    private C41487h f2199ql;

    /* renamed from: android.support.design.widget.FloatingActionButton$a */
    public static abstract class C8328a {
    }

    /* renamed from: android.support.design.widget.FloatingActionButton$b */
    class C8329b implements C25312k {
        C8329b() {
        }

        public final float getRadius() {
            return ((float) FloatingActionButton.this.getSizeDimension()) / 2.0f;
        }

        /* renamed from: e */
        public final void mo18193e(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.f2196qi.set(i, i2, i3, i4);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(floatingActionButton.f2193qf + i, FloatingActionButton.this.f2193qf + i2, FloatingActionButton.this.f2193qf + i3, FloatingActionButton.this.f2193qf + i4);
        }

        public final void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        /* renamed from: cd */
        public final boolean mo18192cd() {
            return FloatingActionButton.this.f2195qh;
        }
    }

    public static class Behavior extends android.support.design.widget.CoordinatorLayout.Behavior<FloatingActionButton> {
        /* renamed from: oT */
        private Rect f2203oT;
        /* renamed from: qo */
        private C8328a f2204qo;
        /* renamed from: qp */
        private boolean f2205qp;

        public Behavior() {
            this.f2205qp = true;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37096a.FloatingActionButton_Behavior_Layout);
            this.f2205qp = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        public final void mo18196a(C31839d c31839d) {
            if (c31839d.f14565pM == 0) {
                c31839d.f14565pM = 80;
            }
        }

        /* renamed from: q */
        private static boolean m14692q(View view) {
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof C31839d) {
                return ((C31839d) layoutParams).f14560pH instanceof BottomSheetBehavior;
            }
            return false;
        }

        /* renamed from: a */
        private boolean m14690a(View view, FloatingActionButton floatingActionButton) {
            C31839d c31839d = (C31839d) floatingActionButton.getLayoutParams();
            if (!this.f2205qp) {
                return false;
            }
            if (c31839d.f14563pK != view.getId()) {
                return false;
            }
            if (floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        private boolean m14688a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!m14690a((View) appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f2203oT == null) {
                this.f2203oT = new Rect();
            }
            Rect rect = this.f2203oT;
            C31872u.m51651a((ViewGroup) coordinatorLayout, (View) appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.mo18165b(this.f2204qo);
            } else {
                floatingActionButton.mo18164a(this.f2204qo);
            }
            return true;
        }

        /* renamed from: b */
        private boolean m14691b(View view, FloatingActionButton floatingActionButton) {
            if (!m14690a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < ((C31839d) floatingActionButton.getLayoutParams()).topMargin + (floatingActionButton.getHeight() / 2)) {
                floatingActionButton.mo18165b(this.f2204qo);
            } else {
                floatingActionButton.mo18164a(this.f2204qo);
            }
            return true;
        }

        /* renamed from: a */
        private boolean m14689a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            int i2;
            int i3 = 0;
            List p = coordinatorLayout.mo66198p(floatingActionButton);
            int size = p.size();
            for (i2 = 0; i2 < size; i2++) {
                View view = (View) p.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (m14692q(view) && m14691b(view, floatingActionButton)) {
                        break;
                    }
                } else if (m14688a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.mo66179e(floatingActionButton, i);
            Rect rect = floatingActionButton.f2196qi;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                C31839d c31839d = (C31839d) floatingActionButton.getLayoutParams();
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - c31839d.rightMargin) {
                    i2 = rect.right;
                } else if (floatingActionButton.getLeft() <= c31839d.leftMargin) {
                    i2 = -rect.left;
                } else {
                    i2 = 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - c31839d.bottomMargin) {
                    i3 = rect.bottom;
                } else if (floatingActionButton.getTop() <= c31839d.topMargin) {
                    i3 = -rect.top;
                }
                if (i3 != 0) {
                    C0477s.m951q(floatingActionButton, i3);
                }
                if (i2 != 0) {
                    C0477s.m952r(floatingActionButton, i2);
                }
            }
            return true;
        }
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2196qi = new Rect();
        this.f2197qj = new Rect();
        C41488o.m72457G(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37096a.FloatingActionButton, i, C25738R.style.f11381yp);
        this.f2188qa = obtainStyledAttributes.getColorStateList(7);
        this.f2189qb = C41490q.m72461al(obtainStyledAttributes.getInt(8, -1));
        this.f2191qd = obtainStyledAttributes.getColor(1, 0);
        this.mSize = obtainStyledAttributes.getInt(2, -1);
        this.f2192qe = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.f2190qc = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        float dimension = obtainStyledAttributes.getDimension(0, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        this.f2195qh = obtainStyledAttributes.getBoolean(6, false);
        obtainStyledAttributes.recycle();
        this.f2198qk = new C0721k(this);
        this.f2198qk.mo2088a(attributeSet, i);
        this.f2194qg = (int) getResources().getDimension(C25738R.dimen.f10352yv);
        getImpl().mo66212a(this.f2188qa, this.f2189qb, this.f2191qd, this.f2190qc);
        getImpl().setElevation(dimension);
        C41487h impl = getImpl();
        if (impl.f16745qA != dimension2) {
            impl.f16745qA = dimension2;
            impl.mo66225o(impl.f16756qz, dimension2);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.f2193qf = (sizeDimension - this.f2194qg) / 2;
        getImpl().mo66216cg();
        sizeDimension = Math.min(resolveAdjustedSize(sizeDimension, i), resolveAdjustedSize(sizeDimension, i2));
        setMeasuredDimension((this.f2196qi.left + sizeDimension) + this.f2196qi.right, (sizeDimension + this.f2196qi.top) + this.f2196qi.bottom);
    }

    public int getRippleColor() {
        return this.f2191qd;
    }

    public void setRippleColor(int i) {
        if (this.f2191qd != i) {
            this.f2191qd = i;
            getImpl().setRippleColor(i);
        }
    }

    public ColorStateList getBackgroundTintList() {
        return this.f2188qa;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2188qa != colorStateList) {
            this.f2188qa = colorStateList;
            C41487h impl = getImpl();
            if (impl.f16752qv != null) {
                C0280a.m457a(impl.f16752qv, colorStateList);
            }
            if (impl.f16754qx != null) {
                impl.f16754qx.mo51808a(colorStateList);
            }
        }
    }

    public Mode getBackgroundTintMode() {
        return this.f2189qb;
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.f2189qb != mode) {
            this.f2189qb = mode;
            C41487h impl = getImpl();
            if (impl.f16752qv != null) {
                C0280a.m460a(impl.f16752qv, mode);
            }
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundResource(int i) {
    }

    public void setBackgroundColor(int i) {
    }

    public void setImageResource(int i) {
        this.f2198qk.setImageResource(i);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo18164a(C8328a c8328a) {
        int i = 1;
        C41487h impl = getImpl();
        C25310c c = m14683c(c8328a);
        if (impl.f16746qC.getVisibility() != 0) {
            if (impl.f16749qs != 2) {
                i = 0;
            }
        } else if (impl.f16749qs == 1) {
            i = 0;
        }
        if (i == 0) {
            impl.f16746qC.animate().cancel();
            if (impl.mo66221cl()) {
                impl.f16749qs = 2;
                if (impl.f16746qC.getVisibility() != 0) {
                    impl.f16746qC.setAlpha(0.0f);
                    impl.f16746qC.setScaleY(0.0f);
                    impl.f16746qC.setScaleX(0.0f);
                }
                impl.f16746qC.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(C31841a.f14582mi).setListener(new C414842(c));
                return;
            }
            impl.f16746qC.mo415j(0, false);
            impl.f16746qC.setAlpha(1.0f);
            impl.f16746qC.setScaleY(1.0f);
            impl.f16746qC.setScaleX(1.0f);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo18165b(C8328a c8328a) {
        int i;
        C41487h impl = getImpl();
        C25310c c = m14683c(c8328a);
        boolean i2;
        if (impl.f16746qC.getVisibility() == 0) {
            if (impl.f16749qs == 1) {
                i2 = 1;
            } else {
                i2 = false;
            }
        } else if (impl.f16749qs != 2) {
            i2 = 1;
        } else {
            i2 = false;
        }
        if (i2 == 0) {
            impl.f16746qC.animate().cancel();
            if (impl.mo66221cl()) {
                impl.f16749qs = 1;
                impl.f16746qC.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(C31841a.f14581mh).setListener(new C83461(c));
                return;
            }
            impl.f16746qC.mo415j(4, false);
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f2195qh != z) {
            this.f2195qh = z;
            getImpl().mo66215cf();
        }
    }

    public boolean getUseCompatPadding() {
        return this.f2195qh;
    }

    public void setSize(int i) {
        if (i != this.mSize) {
            this.mSize = i;
            requestLayout();
        }
    }

    public int getSize() {
        return this.mSize;
    }

    /* renamed from: c */
    private C25310c m14683c(final C8328a c8328a) {
        if (c8328a == null) {
            return null;
        }
        return new C25310c() {
        };
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size should be non-negative.");
        }
        this.f2192qe = i;
    }

    public int getCustomSize() {
        return this.f2192qe;
    }

    /* Access modifiers changed, original: 0000 */
    public int getSizeDimension() {
        int i = this.mSize;
        while (true) {
            Resources resources = getResources();
            if (this.f2192qe != 0) {
                return this.f2192qe;
            }
            switch (i) {
                case -1:
                    if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                case 1:
                    return resources.getDimensionPixelSize(C25738R.dimen.f10353yw);
                default:
                    return resources.getDimensionPixelSize(C25738R.dimen.f10354yx);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C41487h impl = getImpl();
        if (impl.mo66217ch()) {
            if (impl.f16748qE == null) {
                impl.f16748qE = new C414853();
            }
            impl.f16746qC.getViewTreeObserver().addOnPreDrawListener(impl.f16748qE);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C41487h impl = getImpl();
        if (impl.f16748qE != null) {
            impl.f16746qC.getViewTreeObserver().removeOnPreDrawListener(impl.f16748qE);
            impl.f16748qE = null;
        }
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mo66213c(getDrawableState());
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().mo66214ce();
    }

    public Drawable getContentBackground() {
        return getImpl().f16755qy;
    }

    private static int resolveAdjustedSize(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case C8415j.INVALID_ID /*-2147483648*/:
                return Math.min(i, size);
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                return size;
            default:
                return i;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                boolean z;
                Rect rect = this.f2197qj;
                if (C0477s.m927as(this)) {
                    rect.set(0, 0, getWidth(), getHeight());
                    rect.left += this.f2196qi.left;
                    rect.top += this.f2196qi.top;
                    rect.right -= this.f2196qi.right;
                    rect.bottom -= this.f2196qi.bottom;
                    z = true;
                } else {
                    z = false;
                }
                if (z && !this.f2197qj.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return false;
                }
        }
        return super.onTouchEvent(motionEvent);
    }

    public float getCompatElevation() {
        return getImpl().getElevation();
    }

    public void setCompatElevation(float f) {
        getImpl().setElevation(f);
    }

    private C41487h getImpl() {
        if (this.f2199ql == null) {
            C41487h c44945i;
            if (VERSION.SDK_INT >= 21) {
                c44945i = new C44945i(this, new C8329b());
            } else {
                c44945i = new C41487h(this, new C8329b());
            }
            this.f2199ql = c44945i;
        }
        return this.f2199ql;
    }
}
