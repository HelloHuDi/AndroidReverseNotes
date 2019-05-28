package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.f.c;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;

public abstract class av extends f {
    public boolean arN = true;

    public abstract boolean a(v vVar, int i, int i2, int i3, int i4);

    public abstract boolean a(v vVar, v vVar2, int i, int i2, int i3, int i4);

    public abstract boolean b(v vVar);

    public abstract boolean c(v vVar);

    public final void kQ() {
        this.arN = false;
    }

    public final boolean o(v vVar) {
        return !this.arN || vVar.kq();
    }

    public boolean d(v vVar, c cVar, c cVar2) {
        int i = cVar.left;
        int i2 = cVar.top;
        View view = vVar.apJ;
        int left = cVar2 == null ? view.getLeft() : cVar2.left;
        int top = cVar2 == null ? view.getTop() : cVar2.top;
        if (vVar.isRemoved() || (i == left && i2 == top)) {
            return b(vVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(vVar, i, i2, left, top);
    }

    public boolean e(v vVar, c cVar, c cVar2) {
        if (cVar == null || (cVar.left == cVar2.left && cVar.top == cVar2.top)) {
            return c(vVar);
        }
        return a(vVar, cVar.left, cVar.top, cVar2.left, cVar2.top);
    }

    public boolean f(v vVar, c cVar, c cVar2) {
        if (cVar.left == cVar2.left && cVar.top == cVar2.top) {
            C(vVar);
            return false;
        }
        return a(vVar, cVar.left, cVar.top, cVar2.left, cVar2.top);
    }

    public boolean a(v vVar, v vVar2, c cVar, c cVar2) {
        int i;
        int i2;
        int i3 = cVar.left;
        int i4 = cVar.top;
        if (vVar2.kh()) {
            i = cVar.left;
            i2 = cVar.top;
        } else {
            i = cVar2.left;
            i2 = cVar2.top;
        }
        return a(vVar, vVar2, i3, i4, i, i2);
    }

    public final void B(v vVar) {
        E(vVar);
        m(vVar);
    }

    public final void C(v vVar) {
        G(vVar);
        m(vVar);
    }

    public void D(v vVar) {
    }

    public void E(v vVar) {
    }

    public void F(v vVar) {
    }

    public void G(v vVar) {
    }
}
