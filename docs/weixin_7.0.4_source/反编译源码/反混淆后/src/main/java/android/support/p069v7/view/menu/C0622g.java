package android.support.p069v7.view.menu;

import android.support.p069v7.view.menu.C0630p.C0629a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.g */
public final class C0622g extends BaseAdapter {
    static final int abm = 2130968602;
    boolean aaK;
    private final boolean aav;
    private int abk = -1;
    public C6236h abn;
    private final LayoutInflater mInflater;

    public C0622g(C6236h c6236h, LayoutInflater layoutInflater, boolean z) {
        this.aav = z;
        this.mInflater = layoutInflater;
        this.abn = c6236h;
        m1337gt();
    }

    public final int getCount() {
        ArrayList gD = this.aav ? this.abn.mo14140gD() : this.abn.mo14138gB();
        if (this.abk < 0) {
            return gD.size();
        }
        return gD.size() - 1;
    }

    /* renamed from: br */
    public final C6239j getItem(int i) {
        ArrayList gD = this.aav ? this.abn.mo14140gD() : this.abn.mo14138gB();
        if (this.abk >= 0 && i >= this.abk) {
            i++;
        }
        return (C6239j) gD.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.mInflater.inflate(abm, viewGroup, false);
        } else {
            inflate = view;
        }
        C0629a c0629a = (C0629a) inflate;
        if (this.aaK) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        c0629a.mo1609a(getItem(i));
        return inflate;
    }

    /* renamed from: gt */
    private void m1337gt() {
        C6239j c6239j = this.abn.abJ;
        if (c6239j != null) {
            ArrayList gD = this.abn.mo14140gD();
            int size = gD.size();
            for (int i = 0; i < size; i++) {
                if (((C6239j) gD.get(i)) == c6239j) {
                    this.abk = i;
                    return;
                }
            }
        }
        this.abk = -1;
    }

    public final void notifyDataSetChanged() {
        m1337gt();
        super.notifyDataSetChanged();
    }
}
