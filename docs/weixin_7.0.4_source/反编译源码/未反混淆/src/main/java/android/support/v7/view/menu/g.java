package android.support.v7.view.menu;

import android.support.v7.view.menu.p.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import java.util.ArrayList;

public final class g extends BaseAdapter {
    static final int abm = R.layout.a0;
    boolean aaK;
    private final boolean aav;
    private int abk = -1;
    public h abn;
    private final LayoutInflater mInflater;

    public g(h hVar, LayoutInflater layoutInflater, boolean z) {
        this.aav = z;
        this.mInflater = layoutInflater;
        this.abn = hVar;
        gt();
    }

    public final int getCount() {
        ArrayList gD = this.aav ? this.abn.gD() : this.abn.gB();
        if (this.abk < 0) {
            return gD.size();
        }
        return gD.size() - 1;
    }

    /* renamed from: br */
    public final j getItem(int i) {
        ArrayList gD = this.aav ? this.abn.gD() : this.abn.gB();
        if (this.abk >= 0 && i >= this.abk) {
            i++;
        }
        return (j) gD.get(i);
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
        a aVar = (a) inflate;
        if (this.aaK) {
            ((ListMenuItemView) inflate).setForceShowIcon(true);
        }
        aVar.a(getItem(i));
        return inflate;
    }

    private void gt() {
        j jVar = this.abn.abJ;
        if (jVar != null) {
            ArrayList gD = this.abn.gD();
            int size = gD.size();
            for (int i = 0; i < size; i++) {
                if (((j) gD.get(i)) == jVar) {
                    this.abk = i;
                    return;
                }
            }
        }
        this.abk = -1;
    }

    public final void notifyDataSetChanged() {
        gt();
        super.notifyDataSetChanged();
    }
}
