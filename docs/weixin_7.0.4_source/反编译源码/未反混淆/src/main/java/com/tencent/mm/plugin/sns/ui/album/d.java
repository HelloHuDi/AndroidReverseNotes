package com.tencent.mm.plugin.sns.ui.album;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;

public abstract class d extends m {
    public abstract void KB();

    public final void c(RecyclerView recyclerView, int i) {
        super.c(recyclerView, i);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (i == 0 && linearLayoutManager.iT() == linearLayoutManager.getItemCount() - 1) {
            KB();
        }
    }

    public final void a(RecyclerView recyclerView, int i, int i2) {
        super.a(recyclerView, i, i2);
    }
}
