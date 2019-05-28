package android.support.p069v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.p057v4.widget.C0531l;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.p071c.p072a.C0589b;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: android.support.v7.widget.k */
public final class C0721k {
    private final ImageView afL;
    private C0698ba afM;
    private C0698ba afN;
    private C0698ba afn;

    public C0721k(ImageView imageView) {
        this.afL = imageView;
    }

    /* renamed from: a */
    public final void mo2088a(AttributeSet attributeSet, int i) {
        C0699bc a = C0699bc.m1555a(this.afL.getContext(), attributeSet, C0554a.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.afL.getDrawable();
            if (drawable == null) {
                int resourceId = a.getResourceId(1, -1);
                if (resourceId != -1) {
                    drawable = C0589b.m1275g(this.afL.getContext(), resourceId);
                    if (drawable != null) {
                        this.afL.setImageDrawable(drawable);
                    }
                }
            }
            if (drawable != null) {
                C0679aa.m1530n(drawable);
            }
            if (a.hasValue(2)) {
                C0531l.m1142a(this.afL, a.getColorStateList(2));
            }
            if (a.hasValue(3)) {
                C0531l.m1143a(this.afL, C0679aa.m1528d(a.getInt(3, -1), null));
            }
            a.atG.recycle();
        } catch (Throwable th) {
            a.atG.recycle();
        }
    }

    public final void setImageResource(int i) {
        if (i != 0) {
            Drawable g = C0589b.m1275g(this.afL.getContext(), i);
            if (g != null) {
                C0679aa.m1530n(g);
            }
            this.afL.setImageDrawable(g);
        } else {
            this.afL.setImageDrawable(null);
        }
        mo2091hF();
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
            this.afN = new C0698ba();
        }
        this.afN.atC = colorStateList;
        this.afN.atE = true;
        mo2091hF();
    }

    /* Access modifiers changed, original: final */
    public final ColorStateList getSupportImageTintList() {
        return this.afN != null ? this.afN.atC : null;
    }

    /* Access modifiers changed, original: final */
    public final void setSupportImageTintMode(Mode mode) {
        if (this.afN == null) {
            this.afN = new C0698ba();
        }
        this.afN.f1019vI = mode;
        this.afN.atD = true;
        mo2091hF();
    }

    /* Access modifiers changed, original: final */
    public final Mode getSupportImageTintMode() {
        return this.afN != null ? this.afN.f1019vI : null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hF */
    public final void mo2091hF() {
        Drawable drawable = this.afL.getDrawable();
        if (drawable != null) {
            C0679aa.m1530n(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!m1621hB() || !m1622j(drawable)) {
            if (this.afN != null) {
                C0716i.m1598a(drawable, this.afN, this.afL.getDrawableState());
            } else if (this.afM != null) {
                C0716i.m1598a(drawable, this.afM, this.afL.getDrawableState());
            }
        }
    }

    /* renamed from: hB */
    private boolean m1621hB() {
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

    /* renamed from: j */
    private boolean m1622j(Drawable drawable) {
        if (this.afn == null) {
            this.afn = new C0698ba();
        }
        C0698ba c0698ba = this.afn;
        c0698ba.clear();
        ColorStateList b = C0531l.m1144b(this.afL);
        if (b != null) {
            c0698ba.atE = true;
            c0698ba.atC = b;
        }
        Mode c = C0531l.m1145c(this.afL);
        if (c != null) {
            c0698ba.atD = true;
            c0698ba.f1019vI = c;
        }
        if (!c0698ba.atE && !c0698ba.atD) {
            return false;
        }
        C0716i.m1598a(drawable, c0698ba, this.afL.getDrawableState());
        return true;
    }
}
