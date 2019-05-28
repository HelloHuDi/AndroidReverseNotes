package com.tencent.p177mm.plugin.fav.p410ui.p1260a;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.p177mm.plugin.fav.p407a.C39039w;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.fav.ui.a.a */
public abstract class C34148a extends BaseAdapter implements OnItemClickListener {
    protected long lastUpdateTime;
    protected Set<Integer> mkZ;
    protected C39039w mla;
    protected C20713a mlb;
    protected int type;

    /* renamed from: com.tencent.mm.plugin.fav.ui.a.a$a */
    public interface C20713a {
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

    /* renamed from: a */
    public final void mo54720a(C20713a c20713a) {
        this.mlb = c20713a;
    }

    public final void bvW() {
        if (this.mlb != null) {
            this.mlb.bvU();
        }
    }

    /* renamed from: f */
    public final void mo54725f(Set<Integer> set) {
        this.mkZ = set;
    }

    /* renamed from: a */
    public final void mo54719a(C39039w c39039w) {
        this.mla = c39039w;
    }
}
