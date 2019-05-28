package com.tencent.mm.plugin.fav.ui.a;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.fav.a.w;
import java.util.Set;

public abstract class a extends BaseAdapter implements OnItemClickListener {
    protected long lastUpdateTime;
    protected Set<Integer> mkZ;
    protected w mla;
    protected a mlb;
    protected int type;

    public interface a {
        void bvU();
    }

    public abstract void bvX();

    public abstract void bvY();

    public abstract boolean isEmpty();

    public final int getType() {
        return this.type;
    }

    public final long bvV() {
        return this.lastUpdateTime;
    }

    public final void a(a aVar) {
        this.mlb = aVar;
    }

    public final void bvW() {
        if (this.mlb != null) {
            this.mlb.bvU();
        }
    }

    public final void f(Set<Integer> set) {
        this.mkZ = set;
    }

    public final void a(w wVar) {
        this.mla = wVar;
    }
}
