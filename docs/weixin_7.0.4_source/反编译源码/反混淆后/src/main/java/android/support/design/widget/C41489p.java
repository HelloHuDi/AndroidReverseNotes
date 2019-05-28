package android.support.design.widget;

import android.support.p057v4.view.C0477s;
import android.view.View;

/* renamed from: android.support.design.widget.p */
final class C41489p {
    private final View mView;
    /* renamed from: ua */
    int f16758ua;
    /* renamed from: ub */
    private int f16759ub;
    /* renamed from: uc */
    int f16760uc;
    /* renamed from: ud */
    int f16761ud;

    public C41489p(View view) {
        this.mView = view;
    }

    /* renamed from: cD */
    public final void mo66229cD() {
        this.f16758ua = this.mView.getTop();
        this.f16759ub = this.mView.getLeft();
        mo66230cE();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cE */
    public final void mo66230cE() {
        C0477s.m951q(this.mView, this.f16760uc - (this.mView.getTop() - this.f16758ua));
        C0477s.m952r(this.mView, this.f16761ud - (this.mView.getLeft() - this.f16759ub));
    }

    /* renamed from: G */
    public final boolean mo66228G(int i) {
        if (this.f16760uc == i) {
            return false;
        }
        this.f16760uc = i;
        mo66230cE();
        return true;
    }
}
