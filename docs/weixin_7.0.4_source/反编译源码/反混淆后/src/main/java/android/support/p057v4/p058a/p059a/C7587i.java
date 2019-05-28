package android.support.p057v4.p058a.p059a;

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
import android.support.p057v4.p058a.p059a.C6171g.C0283a;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.a.a.i */
final class C7587i extends C7446h {
    /* renamed from: HI */
    private static Method f2116HI;

    /* renamed from: android.support.v4.a.a.i$a */
    static class C6173a extends C0283a {
        C6173a(C0283a c0283a) {
            super(c0283a);
        }

        public final Drawable newDrawable(Resources resources) {
            return new C7587i(this, resources);
        }
    }

    C7587i(Drawable drawable) {
        super(drawable);
        C7587i.m13497dF();
    }

    C7587i(C0283a c0283a, Resources resources) {
        super(c0283a, resources);
        C7587i.m13497dF();
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
        if (mo13724dE()) {
            super.setTintList(colorStateList);
        } else {
            this.mDrawable.setTintList(colorStateList);
        }
    }

    public final void setTint(int i) {
        if (mo13724dE()) {
            super.setTint(i);
        } else {
            this.mDrawable.setTint(i);
        }
    }

    public final void setTintMode(Mode mode) {
        if (mo13724dE()) {
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
    /* renamed from: dE */
    public final boolean mo13724dE() {
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
    /* renamed from: dD */
    public final C0283a mo13723dD() {
        return new C6173a(this.f1735HG);
    }

    /* renamed from: dF */
    private static void m13497dF() {
        if (f2116HI == null) {
            try {
                f2116HI = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
            }
        }
    }
}
