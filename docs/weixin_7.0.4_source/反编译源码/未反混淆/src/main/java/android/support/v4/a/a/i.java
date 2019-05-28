package android.support.v4.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import java.lang.reflect.Method;

final class i extends h {
    private static Method HI;

    static class a extends a {
        a(a aVar) {
            super(aVar);
        }

        public final Drawable newDrawable(Resources resources) {
            return new i(this, resources);
        }
    }

    i(Drawable drawable) {
        super(drawable);
        dF();
    }

    i(a aVar, Resources resources) {
        super(aVar, resources);
        dF();
    }

    public final void setHotspot(float f, float f2) {
        this.mDrawable.setHotspot(f, f2);
    }

    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.mDrawable.setHotspotBounds(i, i2, i3, i4);
    }

    public final void getOutline(Outline outline) {
        this.mDrawable.getOutline(outline);
    }

    public final Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (dE()) {
            super.setTintList(colorStateList);
        } else {
            this.mDrawable.setTintList(colorStateList);
        }
    }

    public final void setTint(int i) {
        if (dE()) {
            super.setTint(i);
        } else {
            this.mDrawable.setTint(i);
        }
    }

    public final void setTintMode(Mode mode) {
        if (dE()) {
            super.setTintMode(mode);
        } else {
            this.mDrawable.setTintMode(mode);
        }
    }

    public final boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dE() {
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.mDrawable;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    public final a dD() {
        return new a(this.HG);
    }

    private static void dF() {
        if (HI == null) {
            try {
                HI = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
            }
        }
    }
}
