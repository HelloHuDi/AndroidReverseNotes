package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p1075a;

import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41530m;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.a.b */
public abstract class C14789b extends C41530m {
    private int uUh;

    public abstract void dfS();

    public abstract void dfT();

    public abstract void dfU();

    public abstract void dfV();

    /* renamed from: a */
    public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
        if ((Math.abs(i2) > this.uUh ? 1 : 0) == 0) {
            return;
        }
        if (!recyclerView.canScrollVertically(-1)) {
            dfU();
        } else if (!recyclerView.canScrollVertically(1)) {
            dfV();
        } else if (i2 < 0) {
            dfS();
        } else if (i2 > 0) {
            dfT();
        }
    }
}
