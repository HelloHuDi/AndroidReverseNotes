package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View> extends Behavior<V> {
    private p tX;
    private int tY = 0;
    private int tZ = 0;

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        d(coordinatorLayout, v, i);
        if (this.tX == null) {
            this.tX = new p(v);
        }
        this.tX.cD();
        if (this.tY != 0) {
            this.tX.G(this.tY);
            this.tY = 0;
        }
        if (this.tZ != 0) {
            p pVar = this.tX;
            int i2 = this.tZ;
            if (pVar.ud != i2) {
                pVar.ud = i2;
                pVar.cE();
            }
            this.tZ = 0;
        }
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void d(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.e(v, i);
    }

    public boolean G(int i) {
        if (this.tX != null) {
            return this.tX.G(i);
        }
        this.tY = i;
        return false;
    }

    public int bB() {
        if (this.tX != null) {
            return this.tX.uc;
        }
        return 0;
    }
}
