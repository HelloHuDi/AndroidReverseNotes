package android.support.v4.a.a;

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

class g extends Drawable implements Callback, e, f {
    static final Mode uK = Mode.SRC_IN;
    private int HD;
    private Mode HE;
    private boolean HF;
    a HG;
    Drawable mDrawable;
    private boolean uO;

    protected static abstract class a extends ConstantState {
        ConstantState HH;
        int mChangingConfigurations;
        ColorStateList vH = null;
        Mode vI = g.uK;

        public abstract Drawable newDrawable(Resources resources);

        a(a aVar) {
            if (aVar != null) {
                this.mChangingConfigurations = aVar.mChangingConfigurations;
                this.HH = aVar.HH;
                this.vH = aVar.vH;
                this.vI = aVar.vI;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            return (this.HH != null ? this.HH.getChangingConfigurations() : 0) | this.mChangingConfigurations;
        }
    }

    static class b extends a {
        b(a aVar) {
            super(aVar);
        }

        public final Drawable newDrawable(Resources resources) {
            return new g(this, resources);
        }
    }

    g(a aVar, Resources resources) {
        this.HG = aVar;
        if (this.HG != null && this.HG.HH != null) {
            h(this.HG.HH.newDrawable(resources));
        }
    }

    g(Drawable drawable) {
        this.HG = dD();
        h(drawable);
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
        return ((this.HG != null ? this.HG.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.mDrawable.getChangingConfigurations();
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
        ColorStateList colorStateList = (!dE() || this.HG == null) ? null : this.HG.vH;
        return (colorStateList != null && colorStateList.isStateful()) || this.mDrawable.isStateful();
    }

    public boolean setState(int[] iArr) {
        return e(iArr) || this.mDrawable.setState(iArr);
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
        if (this.HG != null) {
            Object obj;
            if (this.HG.HH != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                this.HG.mChangingConfigurations = getChangingConfigurations();
                return this.HG;
            }
        }
        return null;
    }

    public Drawable mutate() {
        if (!this.uO && super.mutate() == this) {
            this.HG = dD();
            if (this.mDrawable != null) {
                this.mDrawable.mutate();
            }
            if (this.HG != null) {
                this.HG.HH = this.mDrawable != null ? this.mDrawable.getConstantState() : null;
            }
            this.uO = true;
        }
        return this;
    }

    /* Access modifiers changed, original: 0000 */
    public a dD() {
        return new b(this.HG);
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
        this.HG.vH = colorStateList;
        e(getState());
    }

    public void setTintMode(Mode mode) {
        this.HG.vI = mode;
        e(getState());
    }

    private boolean e(int[] iArr) {
        if (!dE()) {
            return false;
        }
        ColorStateList colorStateList = this.HG.vH;
        Mode mode = this.HG.vI;
        if (colorStateList == null || mode == null) {
            this.HF = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.HF && colorForState == this.HD && mode == this.HE) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.HD = colorForState;
        this.HE = mode;
        this.HF = true;
        return true;
    }

    public final Drawable dC() {
        return this.mDrawable;
    }

    public final void h(Drawable drawable) {
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
            if (this.HG != null) {
                this.HG.HH = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    /* Access modifiers changed, original: protected */
    public boolean dE() {
        return true;
    }
}
