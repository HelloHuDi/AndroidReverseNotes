package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.design.widget.h.AnonymousClass2;
import android.support.v4.view.s;
import android.support.v4.widget.j;
import android.support.v4.widget.u;
import android.support.v7.widget.k;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.mm.R;
import java.util.List;

@android.support.design.widget.CoordinatorLayout.b(Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton {
    private int mSize;
    private ColorStateList qa;
    private Mode qb;
    private int qc;
    private int qd;
    private int qe;
    int qf;
    private int qg;
    boolean qh;
    final Rect qi;
    private final Rect qj;
    private k qk;
    private h ql;

    public static abstract class a {
    }

    class b implements k {
        b() {
        }

        public final float getRadius() {
            return ((float) FloatingActionButton.this.getSizeDimension()) / 2.0f;
        }

        public final void e(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.qi.set(i, i2, i3, i4);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(floatingActionButton.qf + i, FloatingActionButton.this.qf + i2, FloatingActionButton.this.qf + i3, FloatingActionButton.this.qf + i4);
        }

        public final void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public final boolean cd() {
            return FloatingActionButton.this.qh;
        }
    }

    public static class Behavior extends android.support.design.widget.CoordinatorLayout.Behavior<FloatingActionButton> {
        private Rect oT;
        private a qo;
        private boolean qp;

        public Behavior() {
            this.qp = true;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.a.FloatingActionButton_Behavior_Layout);
            this.qp = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }

        public final void a(d dVar) {
            if (dVar.pM == 0) {
                dVar.pM = 80;
            }
        }

        private static boolean q(View view) {
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof d) {
                return ((d) layoutParams).pH instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            d dVar = (d) floatingActionButton.getLayoutParams();
            if (!this.qp) {
                return false;
            }
            if (dVar.pK != view.getId()) {
                return false;
            }
            if (floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            return true;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a((View) appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.oT == null) {
                this.oT = new Rect();
            }
            Rect rect = this.oT;
            u.a((ViewGroup) coordinatorLayout, (View) appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.b(this.qo);
            } else {
                floatingActionButton.a(this.qo);
            }
            return true;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < ((d) floatingActionButton.getLayoutParams()).topMargin + (floatingActionButton.getHeight() / 2)) {
                floatingActionButton.b(this.qo);
            } else {
                floatingActionButton.a(this.qo);
            }
            return true;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            int i2;
            int i3 = 0;
            List p = coordinatorLayout.p(floatingActionButton);
            int size = p.size();
            for (i2 = 0; i2 < size; i2++) {
                View view = (View) p.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (q(view) && b(view, floatingActionButton)) {
                        break;
                    }
                } else if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.e(floatingActionButton, i);
            Rect rect = floatingActionButton.qi;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                d dVar = (d) floatingActionButton.getLayoutParams();
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - dVar.rightMargin) {
                    i2 = rect.right;
                } else if (floatingActionButton.getLeft() <= dVar.leftMargin) {
                    i2 = -rect.left;
                } else {
                    i2 = 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - dVar.bottomMargin) {
                    i3 = rect.bottom;
                } else if (floatingActionButton.getTop() <= dVar.topMargin) {
                    i3 = -rect.top;
                }
                if (i3 != 0) {
                    s.q(floatingActionButton, i3);
                }
                if (i2 != 0) {
                    s.r(floatingActionButton, i2);
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
        this.qi = new Rect();
        this.qj = new Rect();
        o.G(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.a.FloatingActionButton, i, R.style.yp);
        this.qa = obtainStyledAttributes.getColorStateList(7);
        this.qb = q.al(obtainStyledAttributes.getInt(8, -1));
        this.qd = obtainStyledAttributes.getColor(1, 0);
        this.mSize = obtainStyledAttributes.getInt(2, -1);
        this.qe = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.qc = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        float dimension = obtainStyledAttributes.getDimension(0, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        this.qh = obtainStyledAttributes.getBoolean(6, false);
        obtainStyledAttributes.recycle();
        this.qk = new k(this);
        this.qk.a(attributeSet, i);
        this.qg = (int) getResources().getDimension(R.dimen.yv);
        getImpl().a(this.qa, this.qb, this.qd, this.qc);
        getImpl().setElevation(dimension);
        h impl = getImpl();
        if (impl.qA != dimension2) {
            impl.qA = dimension2;
            impl.o(impl.qz, dimension2);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.qf = (sizeDimension - this.qg) / 2;
        getImpl().cg();
        sizeDimension = Math.min(resolveAdjustedSize(sizeDimension, i), resolveAdjustedSize(sizeDimension, i2));
        setMeasuredDimension((this.qi.left + sizeDimension) + this.qi.right, (sizeDimension + this.qi.top) + this.qi.bottom);
    }

    public int getRippleColor() {
        return this.qd;
    }

    public void setRippleColor(int i) {
        if (this.qd != i) {
            this.qd = i;
            getImpl().setRippleColor(i);
        }
    }

    public ColorStateList getBackgroundTintList() {
        return this.qa;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.qa != colorStateList) {
            this.qa = colorStateList;
            h impl = getImpl();
            if (impl.qv != null) {
                android.support.v4.a.a.a.a(impl.qv, colorStateList);
            }
            if (impl.qx != null) {
                impl.qx.a(colorStateList);
            }
        }
    }

    public Mode getBackgroundTintMode() {
        return this.qb;
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.qb != mode) {
            this.qb = mode;
            h impl = getImpl();
            if (impl.qv != null) {
                android.support.v4.a.a.a.a(impl.qv, mode);
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
        this.qk.setImageResource(i);
    }

    /* Access modifiers changed, original: final */
    public final void a(a aVar) {
        int i = 1;
        h impl = getImpl();
        c c = c(aVar);
        if (impl.qC.getVisibility() != 0) {
            if (impl.qs != 2) {
                i = 0;
            }
        } else if (impl.qs == 1) {
            i = 0;
        }
        if (i == 0) {
            impl.qC.animate().cancel();
            if (impl.cl()) {
                impl.qs = 2;
                if (impl.qC.getVisibility() != 0) {
                    impl.qC.setAlpha(0.0f);
                    impl.qC.setScaleY(0.0f);
                    impl.qC.setScaleX(0.0f);
                }
                impl.qC.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(a.mi).setListener(new AnonymousClass2(c));
                return;
            }
            impl.qC.j(0, false);
            impl.qC.setAlpha(1.0f);
            impl.qC.setScaleY(1.0f);
            impl.qC.setScaleX(1.0f);
        }
    }

    /* Access modifiers changed, original: final */
    public final void b(a aVar) {
        int i;
        h impl = getImpl();
        c c = c(aVar);
        boolean i2;
        if (impl.qC.getVisibility() == 0) {
            if (impl.qs == 1) {
                i2 = 1;
            } else {
                i2 = false;
            }
        } else if (impl.qs != 2) {
            i2 = 1;
        } else {
            i2 = false;
        }
        if (i2 == 0) {
            impl.qC.animate().cancel();
            if (impl.cl()) {
                impl.qs = 1;
                impl.qC.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(a.mh).setListener(new android.support.design.widget.h.AnonymousClass1(c));
                return;
            }
            impl.qC.j(4, false);
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.qh != z) {
            this.qh = z;
            getImpl().cf();
        }
    }

    public boolean getUseCompatPadding() {
        return this.qh;
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

    private c c(final a aVar) {
        if (aVar == null) {
            return null;
        }
        return new c() {
        };
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size should be non-negative.");
        }
        this.qe = i;
    }

    public int getCustomSize() {
        return this.qe;
    }

    /* Access modifiers changed, original: 0000 */
    public int getSizeDimension() {
        int i = this.mSize;
        while (true) {
            Resources resources = getResources();
            if (this.qe != 0) {
                return this.qe;
            }
            switch (i) {
                case -1:
                    if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                case 1:
                    return resources.getDimensionPixelSize(R.dimen.yw);
                default:
                    return resources.getDimensionPixelSize(R.dimen.yx);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h impl = getImpl();
        if (impl.ch()) {
            if (impl.qE == null) {
                impl.qE = new OnPreDrawListener() {
                    public final boolean onPreDraw() {
                        h hVar = h.this;
                        float rotation = hVar.qC.getRotation();
                        if (hVar.nR != rotation) {
                            hVar.nR = rotation;
                            if (VERSION.SDK_INT == 19) {
                                if (hVar.nR % 90.0f != 0.0f) {
                                    if (hVar.qC.getLayerType() != 1) {
                                        hVar.qC.setLayerType(1, null);
                                    }
                                } else if (hVar.qC.getLayerType() != 0) {
                                    hVar.qC.setLayerType(0, null);
                                }
                            }
                            if (hVar.qu != null) {
                                j jVar = hVar.qu;
                                float f = -hVar.nR;
                                if (jVar.nR != f) {
                                    jVar.nR = f;
                                    jVar.invalidateSelf();
                                }
                            }
                            if (hVar.qx != null) {
                                d dVar = hVar.qx;
                                float f2 = -hVar.nR;
                                if (f2 != dVar.nR) {
                                    dVar.nR = f2;
                                    dVar.invalidateSelf();
                                }
                            }
                        }
                        return true;
                    }
                };
            }
            impl.qC.getViewTreeObserver().addOnPreDrawListener(impl.qE);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h impl = getImpl();
        if (impl.qE != null) {
            impl.qC.getViewTreeObserver().removeOnPreDrawListener(impl.qE);
            impl.qE = null;
        }
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().c(getDrawableState());
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().ce();
    }

    public Drawable getContentBackground() {
        return getImpl().qy;
    }

    private static int resolveAdjustedSize(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case j.INVALID_ID /*-2147483648*/:
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
                Rect rect = this.qj;
                if (s.as(this)) {
                    rect.set(0, 0, getWidth(), getHeight());
                    rect.left += this.qi.left;
                    rect.top += this.qi.top;
                    rect.right -= this.qi.right;
                    rect.bottom -= this.qi.bottom;
                    z = true;
                } else {
                    z = false;
                }
                if (z && !this.qj.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
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

    private h getImpl() {
        if (this.ql == null) {
            h iVar;
            if (VERSION.SDK_INT >= 21) {
                iVar = new i(this, new b());
            } else {
                iVar = new h(this, new b());
            }
            this.ql = iVar;
        }
        return this.ql;
    }
}
