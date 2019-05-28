package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View> extends Behavior<V> {
    /* renamed from: tX */
    private C41489p f4931tX;
    /* renamed from: tY */
    private int f4932tY = 0;
    /* renamed from: tZ */
    private int f4933tZ = 0;

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public boolean mo18124a(CoordinatorLayout coordinatorLayout, V v, int i) {
        mo41473d(coordinatorLayout, v, i);
        if (this.f4931tX == null) {
            this.f4931tX = new C41489p(v);
        }
        this.f4931tX.mo66229cD();
        if (this.f4932tY != 0) {
            this.f4931tX.mo66228G(this.f4932tY);
            this.f4932tY = 0;
        }
        if (this.f4933tZ != 0) {
            C41489p c41489p = this.f4931tX;
            int i2 = this.f4933tZ;
            if (c41489p.f16761ud != i2) {
                c41489p.f16761ud = i2;
                c41489p.mo66230cE();
            }
            this.f4933tZ = 0;
        }
        return true;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: d */
    public void mo41473d(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.mo66179e(v, i);
    }

    /* renamed from: G */
    public boolean mo18118G(int i) {
        if (this.f4931tX != null) {
            return this.f4931tX.mo66228G(i);
        }
        this.f4932tY = i;
        return false;
    }

    /* renamed from: bB */
    public int mo18130bB() {
        if (this.f4931tX != null) {
            return this.f4931tX.f16760uc;
        }
        return 0;
    }
}
