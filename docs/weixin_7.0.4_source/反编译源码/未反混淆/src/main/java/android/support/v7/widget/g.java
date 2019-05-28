package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.s;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.view.View;

final class g {
    private final i afj;
    private int afk = -1;
    private ba afl;
    private ba afm;
    private ba afn;
    private final View mView;

    g(View view) {
        this.mView = view;
        this.afj = i.hE();
    }

    /* Access modifiers changed, original: final */
    public final void a(AttributeSet attributeSet, int i) {
        bc a = bc.a(this.mView.getContext(), attributeSet, a.ViewBackgroundHelper, i, 0);
        try {
            if (a.hasValue(0)) {
                this.afk = a.getResourceId(0, -1);
                ColorStateList o = this.afj.o(this.mView.getContext(), this.afk);
                if (o != null) {
                    d(o);
                }
            }
            if (a.hasValue(1)) {
                s.a(this.mView, a.getColorStateList(1));
            }
            if (a.hasValue(2)) {
                s.a(this.mView, aa.d(a.getInt(2, -1), null));
            }
            a.atG.recycle();
        } catch (Throwable th) {
            a.atG.recycle();
        }
    }

    /* Access modifiers changed, original: final */
    public final void bD(int i) {
        this.afk = i;
        d(this.afj != null ? this.afj.o(this.mView.getContext(), i) : null);
        hA();
    }

    /* Access modifiers changed, original: final */
    public final void hz() {
        this.afk = -1;
        d(null);
        hA();
    }

    /* Access modifiers changed, original: final */
    public final void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.afm == null) {
            this.afm = new ba();
        }
        this.afm.atC = colorStateList;
        this.afm.atE = true;
        hA();
    }

    /* Access modifiers changed, original: final */
    public final ColorStateList getSupportBackgroundTintList() {
        return this.afm != null ? this.afm.atC : null;
    }

    /* Access modifiers changed, original: final */
    public final void setSupportBackgroundTintMode(Mode mode) {
        if (this.afm == null) {
            this.afm = new ba();
        }
        this.afm.vI = mode;
        this.afm.atD = true;
        hA();
    }

    /* Access modifiers changed, original: final */
    public final Mode getSupportBackgroundTintMode() {
        return this.afm != null ? this.afm.vI : null;
    }

    /* Access modifiers changed, original: final */
    public final void hA() {
        Drawable background = this.mView.getBackground();
        if (background == null) {
            return;
        }
        if (!hB() || !j(background)) {
            if (this.afm != null) {
                i.a(background, this.afm, this.mView.getDrawableState());
            } else if (this.afl != null) {
                i.a(background, this.afl, this.mView.getDrawableState());
            }
        }
    }

    private void d(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.afl == null) {
                this.afl = new ba();
            }
            this.afl.atC = colorStateList;
            this.afl.atE = true;
        } else {
            this.afl = null;
        }
        hA();
    }

    private boolean hB() {
        int i = VERSION.SDK_INT;
        if (i > 21) {
            if (this.afl != null) {
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
        ColorStateList ao = s.ao(this.mView);
        if (ao != null) {
            baVar.atE = true;
            baVar.atC = ao;
        }
        Mode ap = s.ap(this.mView);
        if (ap != null) {
            baVar.atD = true;
            baVar.vI = ap;
        }
        if (!baVar.atE && !baVar.atD) {
            return false;
        }
        i.a(drawable, baVar, this.mView.getDrawableState());
        return true;
    }
}
