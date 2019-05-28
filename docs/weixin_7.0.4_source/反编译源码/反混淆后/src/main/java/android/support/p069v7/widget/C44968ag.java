package android.support.p069v7.widget;

import android.support.p069v7.widget.RecyclerView.C25374o;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.view.View;

/* renamed from: android.support.v7.widget.ag */
final class C44968ag {
    boolean alf;
    int alg;
    int alh;
    int ali;
    int alj;
    int alk;
    boolean all;
    boolean alm;
    /* renamed from: sE */
    int f17708sE;

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final boolean mo72237b(C31880s c31880s) {
        return this.alh >= 0 && this.alh < c31880s.getItemCount();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final View mo72236a(C25374o c25374o) {
        View cr = c25374o.mo42373cr(this.alh);
        this.alh += this.ali;
        return cr;
    }

    public final String toString() {
        return "LayoutState{mAvailable=" + this.alg + ", mCurrentPosition=" + this.alh + ", mItemDirection=" + this.ali + ", mLayoutDirection=" + this.f17708sE + ", mStartLine=" + this.alj + ", mEndLine=" + this.alk + '}';
    }
}
