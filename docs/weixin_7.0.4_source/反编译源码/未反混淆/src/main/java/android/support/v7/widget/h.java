package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.e;
import android.support.v7.a.a.a;
import android.support.v7.c.a.b;
import android.util.AttributeSet;
import android.widget.CompoundButton;

final class h {
    private final CompoundButton afp;
    ColorStateList afq = null;
    Mode afr = null;
    private boolean afs = false;
    private boolean aft = false;
    private boolean afu;

    h(CompoundButton compoundButton) {
        this.afp = compoundButton;
    }

    /* Access modifiers changed, original: final */
    public final void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.afp.getContext().obtainStyledAttributes(attributeSet, a.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(0)) {
                int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                if (resourceId != 0) {
                    this.afp.setButtonDrawable(b.g(this.afp.getContext(), resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(1)) {
                e.a(this.afp, obtainStyledAttributes.getColorStateList(1));
            }
            if (obtainStyledAttributes.hasValue(2)) {
                e.a(this.afp, aa.d(obtainStyledAttributes.getInt(2, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    /* Access modifiers changed, original: final */
    public final void setSupportButtonTintList(ColorStateList colorStateList) {
        this.afq = colorStateList;
        this.afs = true;
        hD();
    }

    /* Access modifiers changed, original: final */
    public final void setSupportButtonTintMode(Mode mode) {
        this.afr = mode;
        this.aft = true;
        hD();
    }

    /* Access modifiers changed, original: final */
    public final void hC() {
        if (this.afu) {
            this.afu = false;
            return;
        }
        this.afu = true;
        hD();
    }

    private void hD() {
        Drawable a = e.a(this.afp);
        if (a == null) {
            return;
        }
        if (this.afs || this.aft) {
            a = android.support.v4.a.a.a.f(a).mutate();
            if (this.afs) {
                android.support.v4.a.a.a.a(a, this.afq);
            }
            if (this.aft) {
                android.support.v4.a.a.a.a(a, this.afr);
            }
            if (a.isStateful()) {
                a.setState(this.afp.getDrawableState());
            }
            this.afp.setButtonDrawable(a);
        }
    }

    /* Access modifiers changed, original: final */
    public final int bE(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = e.a(this.afp);
        if (a != null) {
            return i + a.getIntrinsicWidth();
        }
        return i;
    }
}
