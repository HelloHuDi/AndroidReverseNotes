package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.av;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.ui.a.g;
import com.tencent.mm.plugin.story.ui.b.b;

@l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/VerticalViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "width", "", "height", "(Landroid/view/View;II)V", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "horizontalControlView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "getHorizontalControlView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "layoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "plugin-story_release"})
public final class s extends v {
    final RecyclerView iJP;
    private final b snT;
    final g srB;
    final GalleryHorizontalControlView srC;

    public s(View view, int i, int i2) {
        j.p(view, "itemView");
        super(view);
        AppMethodBeat.i(111013);
        View findViewById = view.findViewById(R.id.etr);
        j.o(findViewById, "itemView.findViewById(R.…lery_horizontal_recycler)");
        this.iJP = (RecyclerView) findViewById;
        this.srB = new g(i, i2);
        Context context = view.getContext();
        j.o(context, "itemView.context");
        this.snT = new b(context, 0, (byte) 0);
        findViewById = view.findViewById(R.id.ets);
        j.o(findViewById, "itemView.findViewById(R.…ory_gallery_page_control)");
        this.srC = (GalleryHorizontalControlView) findViewById;
        this.iJP.setAdapter(this.srB);
        this.iJP.setLayoutManager(this.snT);
        this.iJP.setFocusable(false);
        this.iJP.b((h) new b(0));
        f itemAnimator = this.iJP.getItemAnimator();
        if (!(itemAnimator instanceof av)) {
            itemAnimator = null;
        }
        av avVar = (av) itemAnimator;
        if (avVar != null) {
            avVar.kQ();
        }
        this.iJP.setItemViewCacheSize(0);
        AppMethodBeat.o(111013);
    }
}
