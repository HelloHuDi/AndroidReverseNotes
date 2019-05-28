package com.tencent.p177mm.plugin.story.p536ui.p1037a;

import android.support.p069v7.widget.RecyclerView.C41531v;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.C18532d;
import com.tencent.p177mm.loader.C24669a;
import com.tencent.p177mm.loader.C37881e;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p1304c.C24833d;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g;
import com.tencent.p177mm.plugin.story.p536ui.view.StoryCommentView;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.StoryGalleryItemView;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.StoryGalleryPostTip;
import com.tencent.p177mm.protocal.protobuf.cee;
import com.tencent.p177mm.protocal.protobuf.cek;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C44222az;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u000fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;)V", "bindItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "storyItemView", "thumbView", "Landroid/widget/ImageView;", "onBind", "", "item", "position", "", "isActive", "", "reBindBitmap", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.a.i */
public final class C46923i extends C41531v {
    private final ImageView mmB;
    final StoryGalleryItemView sfR;
    final StoryCommentView sfS;
    final StoryGalleryPostTip sfT;
    C43640g sfU;

    public C46923i(StoryGalleryItemView storyGalleryItemView) {
        C25052j.m39376p(storyGalleryItemView, "itemView");
        super(storyGalleryItemView);
        AppMethodBeat.m2504i(110138);
        this.sfR = storyGalleryItemView;
        this.sfS = storyGalleryItemView.getCommentView();
        this.mmB = storyGalleryItemView.getThumbView();
        this.sfT = storyGalleryItemView.getPostTipView();
        AppMethodBeat.m2505o(110138);
    }

    public final void cCi() {
        AppMethodBeat.m2504i(110137);
        C43640g c43640g = this.sfU;
        if (c43640g == null) {
            AppMethodBeat.m2505o(110137);
            return;
        }
        C44222az Mp = C44222az.dtm().mo69860Mp(c43640g.rVZ.fDG);
        String str;
        if (!c43640g.rVZ.cze()) {
            C4133a c4133a = C43644j.rST;
            C18532d cyc = C4133a.cyc();
            cek cek = c43640g.rVZ.rWj;
            str = c43640g.userName;
            C25052j.m39375o(Mp, "fromScene");
            cyc.mo33785aO(new C24833d(cek, str, Mp)).mo44153d(this.mmB);
            AppMethodBeat.m2505o(110137);
        } else if (c43640g.rVZ.rWl == null) {
            C37881e c37881e = C37881e.eOD;
            C37881e.m63942Tb().mo41564lR("").mo44153d(this.mmB);
            AppMethodBeat.m2505o(110137);
        } else {
            cee cee = c43640g.rVZ.rWl;
            if (cee != null) {
                C4990ab.m7416i(C39917h.TAG, "load fake localFile:" + cee.thumbPath + ", position:" + getPosition() + ", videoPath:" + cee.videoPath);
                C37881e c37881e2 = C37881e.eOD;
                C24669a Tb = C37881e.m63942Tb();
                str = cee.thumbPath;
                C25052j.m39375o(str, "it.thumbPath");
                Tb.mo41564lR(str).mo44153d(this.mmB);
                AppMethodBeat.m2505o(110137);
                return;
            }
            AppMethodBeat.m2505o(110137);
        }
    }
}
