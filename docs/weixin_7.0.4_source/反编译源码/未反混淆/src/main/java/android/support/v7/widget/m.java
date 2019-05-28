package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.s;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.SeekBar;

final class m extends l {
    final SeekBar afU;
    Drawable afV;
    private ColorStateList afW = null;
    private Mode afX = null;
    private boolean afY = false;
    private boolean afZ = false;

    m(SeekBar seekBar) {
        super(seekBar);
        this.afU = seekBar;
    }

    /* Access modifiers changed, original: final */
    public final void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        bc a = bc.a(this.afU.getContext(), attributeSet, a.AppCompatSeekBar, i, 0);
        Drawable cW = a.cW(0);
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
            android.support.v4.a.a.a.b(cW, s.T(this.afU));
            if (cW.isStateful()) {
                cW.setState(this.afU.getDrawableState());
            }
            hG();
        }
        this.afU.invalidate();
        if (a.hasValue(3)) {
            this.afX = aa.d(a.getInt(3, -1), this.afX);
            this.afZ = true;
        }
        if (a.hasValue(2)) {
            this.afW = a.getColorStateList(2);
            this.afY = true;
        }
        a.atG.recycle();
        hG();
    }

    private void hG() {
        if (this.afV == null) {
            return;
        }
        if (this.afY || this.afZ) {
            this.afV = android.support.v4.a.a.a.f(this.afV.mutate());
            if (this.afY) {
                android.support.v4.a.a.a.a(this.afV, this.afW);
            }
            if (this.afZ) {
                android.support.v4.a.a.a.a(this.afV, this.afX);
            }
            if (this.afV.isStateful()) {
                this.afV.setState(this.afU.getDrawableState());
            }
        }
    }
}
