package android.support.p069v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.widget.C0524e;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.p071c.p072a.C0589b;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* renamed from: android.support.v7.widget.h */
final class C0714h {
    private final CompoundButton afp;
    ColorStateList afq = null;
    Mode afr = null;
    private boolean afs = false;
    private boolean aft = false;
    private boolean afu;

    C0714h(CompoundButton compoundButton) {
        this.afp = compoundButton;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo2076a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.afp.getContext().obtainStyledAttributes(attributeSet, C0554a.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(0)) {
                int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                if (resourceId != 0) {
                    this.afp.setButtonDrawable(C0589b.m1275g(this.afp.getContext(), resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(1)) {
                C0524e.m1127a(this.afp, obtainStyledAttributes.getColorStateList(1));
            }
            if (obtainStyledAttributes.hasValue(2)) {
                C0524e.m1128a(this.afp, C0679aa.m1528d(obtainStyledAttributes.getInt(2, -1), null));
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
        m1586hD();
    }

    /* Access modifiers changed, original: final */
    public final void setSupportButtonTintMode(Mode mode) {
        this.afr = mode;
        this.aft = true;
        m1586hD();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hC */
    public final void mo2078hC() {
        if (this.afu) {
            this.afu = false;
            return;
        }
        this.afu = true;
        m1586hD();
    }

    /* renamed from: hD */
    private void m1586hD() {
        Drawable a = C0524e.m1126a(this.afp);
        if (a == null) {
            return;
        }
        if (this.afs || this.aft) {
            a = C0280a.m467f(a).mutate();
            if (this.afs) {
                C0280a.m457a(a, this.afq);
            }
            if (this.aft) {
                C0280a.m460a(a, this.afr);
            }
            if (a.isStateful()) {
                a.setState(this.afp.getDrawableState());
            }
            this.afp.setButtonDrawable(a);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bE */
    public final int mo2077bE(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = C0524e.m1126a(this.afp);
        if (a != null) {
            return i + a.getIntrinsicWidth();
        }
        return i;
    }
}
