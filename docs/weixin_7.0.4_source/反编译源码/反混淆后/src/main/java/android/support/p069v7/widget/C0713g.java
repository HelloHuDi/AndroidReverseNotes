package android.support.p069v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p057v4.view.C0477s;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.v7.widget.g */
final class C0713g {
    private final C0716i afj;
    private int afk = -1;
    private C0698ba afl;
    private C0698ba afm;
    private C0698ba afn;
    private final View mView;

    C0713g(View view) {
        this.mView = view;
        this.afj = C0716i.m1606hE();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo2068a(AttributeSet attributeSet, int i) {
        C0699bc a = C0699bc.m1555a(this.mView.getContext(), attributeSet, C0554a.ViewBackgroundHelper, i, 0);
        try {
            if (a.hasValue(0)) {
                this.afk = a.getResourceId(0, -1);
                ColorStateList o = this.afj.mo2085o(this.mView.getContext(), this.afk);
                if (o != null) {
                    m1579d(o);
                }
            }
            if (a.hasValue(1)) {
                C0477s.m901a(this.mView, a.getColorStateList(1));
            }
            if (a.hasValue(2)) {
                C0477s.m903a(this.mView, C0679aa.m1528d(a.getInt(2, -1), null));
            }
            a.atG.recycle();
        } catch (Throwable th) {
            a.atG.recycle();
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bD */
    public final void mo2069bD(int i) {
        this.afk = i;
        m1579d(this.afj != null ? this.afj.mo2085o(this.mView.getContext(), i) : null);
        mo2072hA();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hz */
    public final void mo2073hz() {
        this.afk = -1;
        m1579d(null);
        mo2072hA();
    }

    /* Access modifiers changed, original: final */
    public final void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.afm == null) {
            this.afm = new C0698ba();
        }
        this.afm.atC = colorStateList;
        this.afm.atE = true;
        mo2072hA();
    }

    /* Access modifiers changed, original: final */
    public final ColorStateList getSupportBackgroundTintList() {
        return this.afm != null ? this.afm.atC : null;
    }

    /* Access modifiers changed, original: final */
    public final void setSupportBackgroundTintMode(Mode mode) {
        if (this.afm == null) {
            this.afm = new C0698ba();
        }
        this.afm.f1019vI = mode;
        this.afm.atD = true;
        mo2072hA();
    }

    /* Access modifiers changed, original: final */
    public final Mode getSupportBackgroundTintMode() {
        return this.afm != null ? this.afm.f1019vI : null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hA */
    public final void mo2072hA() {
        Drawable background = this.mView.getBackground();
        if (background == null) {
            return;
        }
        if (!m1580hB() || !m1581j(background)) {
            if (this.afm != null) {
                C0716i.m1598a(background, this.afm, this.mView.getDrawableState());
            } else if (this.afl != null) {
                C0716i.m1598a(background, this.afl, this.mView.getDrawableState());
            }
        }
    }

    /* renamed from: d */
    private void m1579d(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.afl == null) {
                this.afl = new C0698ba();
            }
            this.afl.atC = colorStateList;
            this.afl.atE = true;
        } else {
            this.afl = null;
        }
        mo2072hA();
    }

    /* renamed from: hB */
    private boolean m1580hB() {
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

    /* renamed from: j */
    private boolean m1581j(Drawable drawable) {
        if (this.afn == null) {
            this.afn = new C0698ba();
        }
        C0698ba c0698ba = this.afn;
        c0698ba.clear();
        ColorStateList ao = C0477s.m923ao(this.mView);
        if (ao != null) {
            c0698ba.atE = true;
            c0698ba.atC = ao;
        }
        Mode ap = C0477s.m924ap(this.mView);
        if (ap != null) {
            c0698ba.atD = true;
            c0698ba.f1019vI = ap;
        }
        if (!c0698ba.atE && !c0698ba.atD) {
            return false;
        }
        C0716i.m1598a(drawable, c0698ba, this.mView.getDrawableState());
        return true;
    }
}
