package android.support.p069v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.view.C0477s;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* renamed from: android.support.v7.widget.m */
final class C6259m extends C0722l {
    final SeekBar afU;
    Drawable afV;
    private ColorStateList afW = null;
    private Mode afX = null;
    private boolean afY = false;
    private boolean afZ = false;

    C6259m(SeekBar seekBar) {
        super(seekBar);
        this.afU = seekBar;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo2096a(AttributeSet attributeSet, int i) {
        super.mo2096a(attributeSet, i);
        C0699bc a = C0699bc.m1555a(this.afU.getContext(), attributeSet, C0554a.AppCompatSeekBar, i, 0);
        Drawable cW = a.mo2029cW(0);
        if (cW != null) {
            this.afU.setThumb(cW);
        }
        cW = a.getDrawable(1);
        if (this.afV != null) {
            this.afV.setCallback(null);
        }
        this.afV = cW;
        if (cW != null) {
            cW.setCallback(this.afU);
            C0280a.m463b(cW, C0477s.m893T(this.afU));
            if (cW.isStateful()) {
                cW.setState(this.afU.getDrawableState());
            }
            m10212hG();
        }
        this.afU.invalidate();
        if (a.hasValue(3)) {
            this.afX = C0679aa.m1528d(a.getInt(3, -1), this.afX);
            this.afZ = true;
        }
        if (a.hasValue(2)) {
            this.afW = a.getColorStateList(2);
            this.afY = true;
        }
        a.atG.recycle();
        m10212hG();
    }

    /* renamed from: hG */
    private void m10212hG() {
        if (this.afV == null) {
            return;
        }
        if (this.afY || this.afZ) {
            this.afV = C0280a.m467f(this.afV.mutate());
            if (this.afY) {
                C0280a.m457a(this.afV, this.afW);
            }
            if (this.afZ) {
                C0280a.m460a(this.afV, this.afX);
            }
            if (this.afV.isStateful()) {
                this.afV.setState(this.afU.getDrawableState());
            }
        }
    }
}
