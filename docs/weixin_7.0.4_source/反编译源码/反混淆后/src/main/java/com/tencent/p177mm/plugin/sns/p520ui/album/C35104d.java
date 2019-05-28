package com.tencent.p177mm.plugin.sns.p520ui.album;

import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41530m;

/* renamed from: com.tencent.mm.plugin.sns.ui.album.d */
public abstract class C35104d extends C41530m {
    /* renamed from: KB */
    public abstract void mo55727KB();

    /* renamed from: c */
    public final void mo6643c(RecyclerView recyclerView, int i) {
        super.mo6643c(recyclerView, i);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (i == 0 && linearLayoutManager.mo1783iT() == linearLayoutManager.getItemCount() - 1) {
            mo55727KB();
        }
    }

    /* renamed from: a */
    public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
        super.mo6642a(recyclerView, i, i2);
    }
}
