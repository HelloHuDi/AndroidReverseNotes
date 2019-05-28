package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;

public abstract class b extends m {
    private int uUh;

    public abstract void dfS();

    public abstract void dfT();

    public abstract void dfU();

    public abstract void dfV();

    public final void a(RecyclerView recyclerView, int i, int i2) {
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
