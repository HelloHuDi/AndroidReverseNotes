package android.support.design.widget;

import android.support.v4.view.s;
import android.view.View;

final class p {
    private final View mView;
    int ua;
    private int ub;
    int uc;
    int ud;

    public p(View view) {
        this.mView = view;
    }

    public final void cD() {
        this.ua = this.mView.getTop();
        this.ub = this.mView.getLeft();
        cE();
    }

    /* Access modifiers changed, original: final */
    public final void cE() {
        s.q(this.mView, this.uc - (this.mView.getTop() - this.ua));
        s.r(this.mView, this.ud - (this.mView.getLeft() - this.ub));
    }

    public final boolean G(int i) {
        if (this.uc == i) {
            return false;
        }
        this.uc = i;
        cE();
        return true;
    }
}
