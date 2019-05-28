package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.c.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public abstract class a extends android.support.v7.widget.RecyclerView.a implements g {
    static b kuW;
    protected List<com.tencent.mm.plugin.choosemsgfile.b.b.a> iJL;
    private com.tencent.mm.plugin.choosemsgfile.ui.a kuT;
    private boolean kuU = g.RP().isSDCardAvailable();
    com.tencent.mm.plugin.choosemsgfile.b.c.g.a kuV;

    public final com.tencent.mm.plugin.choosemsgfile.ui.a bfy() {
        return this.kuT;
    }

    public a(com.tencent.mm.plugin.choosemsgfile.ui.a aVar, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> list) {
        this.kuT = aVar;
        this.iJL = list;
    }

    public final int getItemViewType(int i) {
        return ts(i).getType();
    }

    public final void a(v vVar, int i, List list) {
        ts(i);
        super.a(vVar, i, list);
    }

    public final void a(v vVar, int i) {
        if (this.kuU) {
            ts(i).a(vVar, i);
            return;
        }
        ab.e("MicroMsg.BaseChooseFileAdapter", "[onBindViewHolder] isSDCardAvailable:%b", Boolean.valueOf(this.kuU));
    }

    public final int getItemCount() {
        return this.iJL.size();
    }

    public final com.tencent.mm.plugin.choosemsgfile.b.b.a ts(int i) {
        if (this.iJL == null || this.iJL.size() <= i) {
            return null;
        }
        return (com.tencent.mm.plugin.choosemsgfile.b.b.a) this.iJL.get(i);
    }

    public final void a(boolean z, com.tencent.mm.plugin.choosemsgfile.b.b.a aVar, v vVar) {
        if (this.kuV != null) {
            this.kuV.a(z, aVar, vVar);
        }
    }

    public boolean bfz() {
        return false;
    }
}
