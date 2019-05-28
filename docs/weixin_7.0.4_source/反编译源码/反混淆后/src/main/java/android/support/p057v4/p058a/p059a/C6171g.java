package android.support.p057v4.p058a.p059a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

/* renamed from: android.support.v4.a.a.g */
class C6171g extends Drawable implements Callback, C0281e, C0282f {
    /* renamed from: uK */
    static final Mode f1731uK = Mode.SRC_IN;
    /* renamed from: HD */
    private int f1732HD;
    /* renamed from: HE */
    private Mode f1733HE;
    /* renamed from: HF */
    private boolean f1734HF;
    /* renamed from: HG */
    C0283a f1735HG;
    Drawable mDrawable;
    /* renamed from: uO */
    private boolean f1736uO;

    /* renamed from: android.support.v4.a.a.g$a */
    protected static abstract class C0283a extends ConstantState {
        /* renamed from: HH */
        ConstantState f199HH;
        int mChangingConfigurations;
        /* renamed from: vH */
        ColorStateList f200vH = null;
        /* renamed from: vI */
        Mode f201vI = C6171g.f1731uK;

        public abstract Drawable newDrawable(Resources resources);

        C0283a(C0283a c0283a) {
            if (c0283a != null) {
                this.mChangingConfigurations = c0283a.mChangingConfigurations;
                this.f199HH = c0283a.f199HH;
                this.f200vH = c0283a.f200vH;
                this.f201vI = c0283a.f201vI;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            return (this.f199HH != null ? this.f199HH.getChangingConfigurations() : 0) | this.mChangingConfigurations;
        }
    }

    /* renamed from: android.support.v4.a.a.g$b */
    static class C6170b extends C0283a {
        C6170b(C0283a c0283a) {
            super(c0283a);
        }

        public final Drawable newDrawable(Resources resources) {
            return new C6171g(this, resources);
        }
    }

    C6171g(C0283a c0283a, Resources resources) {
        this.f1735HG = c0283a;
        if (this.f1735HG != null && this.f1735HG.f199HH != null) {
            mo460h(this.f1735HG.f199HH.newDrawable(resources));
        }
    }

    C6171g(Drawable drawable) {
        this.f1735HG = mo13723dD();
        mo460h(drawable);
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    /* Access modifiers changed, original: protected */
    public void onBoundsChange(Rect rect) {
        if (this.mDrawable != null) {
            this.mDrawable.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        this.mDrawable.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return ((this.f1735HG != null ? this.f1735HG.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.mDrawable.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.mDrawable.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.mDrawable.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.mDrawable.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawable.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!mo13724dE() || this.f1735HG == null) ? null : this.f1735HG.f200vH;
        return (colorStateList != null && colorStateList.isStateful()) || this.mDrawable.isStateful();
    }

    public boolean setState(int[] iArr) {
        return m9858e(iArr) || this.mDrawable.setState(iArr);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.mDrawable.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.mDrawable.getPadding(rect);
    }

    public ConstantState getConstantState() {
        if (this.f1735HG != null) {
            Object obj;
            if (this.f1735HG.f199HH != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                this.f1735HG.mChangingConfigurations = getChangingConfigurations();
                return this.f1735HG;
            }
        }
        return null;
    }

    public Drawable mutate() {
        if (!this.f1736uO && super.mutate() == this) {
            this.f1735HG = mo13723dD();
            if (this.mDrawable != null) {
                this.mDrawable.mutate();
            }
            if (this.f1735HG != null) {
                this.f1735HG.f199HH = this.mDrawable != null ? this.mDrawable.getConstantState() : null;
            }
            this.f1736uO = true;
        }
        return this;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: dD */
    public C0283a mo13723dD() {
        return new C6170b(this.f1735HG);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* Access modifiers changed, original: protected */
    public boolean onLevelChange(int i) {
        return this.mDrawable.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1735HG.f200vH = colorStateList;
        m9858e(getState());
    }

    public void setTintMode(Mode mode) {
        this.f1735HG.f201vI = mode;
        m9858e(getState());
    }

    /* renamed from: e */
    private boolean m9858e(int[] iArr) {
        if (!mo13724dE()) {
            return false;
        }
        ColorStateList colorStateList = this.f1735HG.f200vH;
        Mode mode = this.f1735HG.f201vI;
        if (colorStateList == null || mode == null) {
            this.f1734HF = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1734HF && colorForState == this.f1732HD && mode == this.f1733HE) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.f1732HD = colorForState;
        this.f1733HE = mode;
        this.f1734HF = true;
        return true;
    }

    /* renamed from: dC */
    public final Drawable mo459dC() {
        return this.mDrawable;
    }

    /* renamed from: h */
    public final void mo460h(Drawable drawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.f1735HG != null) {
                this.f1735HG.f199HH = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: dE */
    public boolean mo13724dE() {
        return true;
    }
}
