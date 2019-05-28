package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.content.Context;
import android.support.p069v7.widget.C17495av;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31879f;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.story.p536ui.p1037a.C29324g;
import com.tencent.p177mm.plugin.story.p536ui.p1305b.C22262b;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/VerticalViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "width", "", "height", "(Landroid/view/View;II)V", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "horizontalControlView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "getHorizontalControlView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "layoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.s */
public final class C46926s extends C41531v {
    final RecyclerView iJP;
    private final C22262b snT;
    final C29324g srB;
    final GalleryHorizontalControlView srC;

    public C46926s(View view, int i, int i2) {
        C25052j.m39376p(view, "itemView");
        super(view);
        AppMethodBeat.m2504i(111013);
        View findViewById = view.findViewById(2131828156);
        C25052j.m39375o(findViewById, "itemView.findViewById(R.…lery_horizontal_recycler)");
        this.iJP = (RecyclerView) findViewById;
        this.srB = new C29324g(i, i2);
        Context context = view.getContext();
        C25052j.m39375o(context, "itemView.context");
        this.snT = new C22262b(context, 0, (byte) 0);
        findViewById = view.findViewById(2131828157);
        C25052j.m39375o(findViewById, "itemView.findViewById(R.…ory_gallery_page_control)");
        this.srC = (GalleryHorizontalControlView) findViewById;
        this.iJP.setAdapter(this.srB);
        this.iJP.setLayoutManager(this.snT);
        this.iJP.setFocusable(false);
        this.iJP.mo66346b((C25373h) new C35247b(0));
        C31879f itemAnimator = this.iJP.getItemAnimator();
        if (!(itemAnimator instanceof C17495av)) {
            itemAnimator = null;
        }
        C17495av c17495av = (C17495av) itemAnimator;
        if (c17495av != null) {
            c17495av.mo31921kQ();
        }
        this.iJP.setItemViewCacheSize(0);
        AppMethodBeat.m2505o(111013);
    }
}
