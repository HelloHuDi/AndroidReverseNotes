package android.support.p069v7.widget;

import android.support.p069v7.widget.RecyclerView.C31879f;
import android.support.p069v7.widget.RecyclerView.C31879f.C17479c;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;

/* renamed from: android.support.v7.widget.av */
public abstract class C17495av extends C31879f {
    public boolean arN = true;

    /* renamed from: a */
    public abstract boolean mo22565a(C41531v c41531v, int i, int i2, int i3, int i4);

    /* renamed from: a */
    public abstract boolean mo22566a(C41531v c41531v, C41531v c41531v2, int i, int i2, int i3, int i4);

    /* renamed from: b */
    public abstract boolean mo22568b(C41531v c41531v);

    /* renamed from: c */
    public abstract boolean mo22569c(C41531v c41531v);

    /* renamed from: kQ */
    public final void mo31921kQ() {
        this.arN = false;
    }

    /* renamed from: o */
    public final boolean mo31922o(C41531v c41531v) {
        return !this.arN || c41531v.mo66461kq();
    }

    /* renamed from: d */
    public boolean mo31918d(C41531v c41531v, C17479c c17479c, C17479c c17479c2) {
        int i = c17479c.left;
        int i2 = c17479c.top;
        View view = c41531v.apJ;
        int left = c17479c2 == null ? view.getLeft() : c17479c2.left;
        int top = c17479c2 == null ? view.getTop() : c17479c2.top;
        if (c41531v.isRemoved() || (i == left && i2 == top)) {
            return mo22568b(c41531v);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return mo22565a(c41531v, i, i2, left, top);
    }

    /* renamed from: e */
    public boolean mo31919e(C41531v c41531v, C17479c c17479c, C17479c c17479c2) {
        if (c17479c == null || (c17479c.left == c17479c2.left && c17479c.top == c17479c2.top)) {
            return mo22569c(c41531v);
        }
        return mo22565a(c41531v, c17479c.left, c17479c.top, c17479c2.left, c17479c2.top);
    }

    /* renamed from: f */
    public boolean mo31920f(C41531v c41531v, C17479c c17479c, C17479c c17479c2) {
        if (c17479c.left == c17479c2.left && c17479c.top == c17479c2.top) {
            mo31913C(c41531v);
            return false;
        }
        return mo22565a(c41531v, c17479c.left, c17479c.top, c17479c2.left, c17479c2.top);
    }

    /* renamed from: a */
    public boolean mo31917a(C41531v c41531v, C41531v c41531v2, C17479c c17479c, C17479c c17479c2) {
        int i;
        int i2;
        int i3 = c17479c.left;
        int i4 = c17479c.top;
        if (c41531v2.mo66452kh()) {
            i = c17479c.left;
            i2 = c17479c.top;
        } else {
            i = c17479c2.left;
            i2 = c17479c2.top;
        }
        return mo22566a(c41531v, c41531v2, i3, i4, i, i2);
    }

    /* renamed from: B */
    public final void mo31912B(C41531v c41531v) {
        mo9155E(c41531v);
        mo51947m(c41531v);
    }

    /* renamed from: C */
    public final void mo31913C(C41531v c41531v) {
        mo31916G(c41531v);
        mo51947m(c41531v);
    }

    /* renamed from: D */
    public void mo31914D(C41531v c41531v) {
    }

    /* renamed from: E */
    public void mo9155E(C41531v c41531v) {
    }

    /* renamed from: F */
    public void mo31915F(C41531v c41531v) {
    }

    /* renamed from: G */
    public void mo31916G(C41531v c41531v) {
    }
}
