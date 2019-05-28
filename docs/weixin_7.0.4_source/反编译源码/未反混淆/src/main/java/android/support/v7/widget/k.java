package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.widget.l;
import android.support.v7.a.a.a;
import android.support.v7.c.a.b;
import android.util.AttributeSet;
import android.widget.ImageView;

public final class k {
    private final ImageView afL;
    private ba afM;
    private ba afN;
    private ba afn;

    public k(ImageView imageView) {
        this.afL = imageView;
    }

    public final void a(AttributeSet attributeSet, int i) {
        bc a = bc.a(this.afL.getContext(), attributeSet, a.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.afL.getDrawable();
            if (drawable == null) {
                int resourceId = a.getResourceId(1, -1);
                if (resourceId != -1) {
                    drawable = b.g(this.afL.getContext(), resourceId);
                    if (drawable != null) {
                        this.afL.setImageDrawable(drawable);
                    }
                }
            }
            if (drawable != null) {
                aa.n(drawable);
            }
            if (a.hasValue(2)) {
                l.a(this.afL, a.getColorStateList(2));
            }
            if (a.hasValue(3)) {
                l.a(this.afL, aa.d(a.getInt(3, -1), null));
            }
            a.atG.recycle();
        } catch (Throwable th) {
            a.atG.recycle();
        }
    }

    public final void setImageResource(int i) {
        if (i != 0) {
            Drawable g = b.g(this.afL.getContext(), i);
            if (g != null) {
                aa.n(g);
            }
            this.afL.setImageDrawable(g);
        } else {
            this.afL.setImageDrawable(null);
        }
        hF();
    }

    /* Access modifiers changed, original: final */
    public final boolean hasOverlappingRendering() {
        Drawable background = this.afL.getBackground();
        if (VERSION.SDK_INT < 21 || !(background instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.afN == null) {
            this.afN = new ba();
        }
        this.afN.atC = colorStateList;
        this.afN.atE = true;
        hF();
    }

    /* Access modifiers changed, original: final */
    public final ColorStateList getSupportImageTintList() {
        return this.afN != null ? this.afN.atC : null;
    }

    /* Access modifiers changed, original: final */
    public final void setSupportImageTintMode(Mode mode) {
        if (this.afN == null) {
            this.afN = new ba();
        }
        this.afN.vI = mode;
        this.afN.atD = true;
        hF();
    }

    /* Access modifiers changed, original: final */
    public final Mode getSupportImageTintMode() {
        return this.afN != null ? this.afN.vI : null;
    }

    /* Access modifiers changed, original: final */
    public final void hF() {
        Drawable drawable = this.afL.getDrawable();
        if (drawable != null) {
            aa.n(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!hB() || !j(drawable)) {
            if (this.afN != null) {
                i.a(drawable, this.afN, this.afL.getDrawableState());
            } else if (this.afM != null) {
                i.a(drawable, this.afM, this.afL.getDrawableState());
            }
        }
    }

    private boolean hB() {
        int i = VERSION.SDK_INT;
        if (i > 21) {
            if (this.afM != null) {
                return true;
            }
            return false;
        } else if (i != 21) {
            return false;
        } else {
            return true;
        }
    }

    private boolean j(Drawable drawable) {
        if (this.afn == null) {
            this.afn = new ba();
        }
        ba baVar = this.afn;
        baVar.clear();
        ColorStateList b = l.b(this.afL);
        if (b != null) {
            baVar.atE = true;
            baVar.atC = b;
        }
        Mode c = l.c(this.afL);
        if (c != null) {
            baVar.atD = true;
            baVar.vI = c;
        }
        if (!baVar.atE && !baVar.atD) {
            return false;
        }
        i.a(drawable, baVar, this.afL.getDrawableState());
        return true;
    }
}
