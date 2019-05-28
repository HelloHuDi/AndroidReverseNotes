package com.tencent.p177mm.plugin.story.p536ui.album;

import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C41530m;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "()V", "onLoadMore", "", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.album.e */
public abstract class C46924e extends C41530m {
    /* renamed from: KB */
    public abstract void mo17280KB();

    /* renamed from: c */
    public final void mo6643c(RecyclerView recyclerView, int i) {
        super.mo6643c(recyclerView, i);
        if (recyclerView == null) {
            C25052j.dWJ();
        }
        C17480i layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            throw new C44941v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (i == 0 && linearLayoutManager.mo1783iT() == linearLayoutManager.getItemCount() - 1) {
            mo17280KB();
        }
    }
}
