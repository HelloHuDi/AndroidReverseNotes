package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;

final class ag {
    boolean alf;
    int alg;
    int alh;
    int ali;
    int alj;
    int alk;
    boolean all;
    boolean alm;
    int sE;

    /* Access modifiers changed, original: final */
    public final boolean b(s sVar) {
        return this.alh >= 0 && this.alh < sVar.getItemCount();
    }

    /* Access modifiers changed, original: final */
    public final View a(o oVar) {
        View cr = oVar.cr(this.alh);
        this.alh += this.ali;
        return cr;
    }

    public final String toString() {
        return "LayoutState{mAvailable=" + this.alg + ", mCurrentPosition=" + this.alh + ", mItemDirection=" + this.ali + ", mLayoutDirection=" + this.sE + ", mStartLine=" + this.alj + ", mEndLine=" + this.alk + '}';
    }
}
