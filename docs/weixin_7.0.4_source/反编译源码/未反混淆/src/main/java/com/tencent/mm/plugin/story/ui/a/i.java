package com.tencent.mm.plugin.story.ui.a;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.loader.e;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.model.j.a;
import com.tencent.mm.plugin.story.ui.view.StoryCommentView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryPostTip;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.az;

@l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u000fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;)V", "bindItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "storyItemView", "thumbView", "Landroid/widget/ImageView;", "onBind", "", "item", "position", "", "isActive", "", "reBindBitmap", "plugin-story_release"})
public final class i extends v {
    private final ImageView mmB;
    final StoryGalleryItemView sfR;
    final StoryCommentView sfS;
    final StoryGalleryPostTip sfT;
    g sfU;

    public i(StoryGalleryItemView storyGalleryItemView) {
        j.p(storyGalleryItemView, "itemView");
        super(storyGalleryItemView);
        AppMethodBeat.i(110138);
        this.sfR = storyGalleryItemView;
        this.sfS = storyGalleryItemView.getCommentView();
        this.mmB = storyGalleryItemView.getThumbView();
        this.sfT = storyGalleryItemView.getPostTipView();
        AppMethodBeat.o(110138);
    }

    public final void cCi() {
        AppMethodBeat.i(110137);
        g gVar = this.sfU;
        if (gVar == null) {
            AppMethodBeat.o(110137);
            return;
        }
        az Mp = az.dtm().Mp(gVar.rVZ.fDG);
        String str;
        if (!gVar.rVZ.cze()) {
            a aVar = com.tencent.mm.plugin.story.model.j.rST;
            d cyc = a.cyc();
            cek cek = gVar.rVZ.rWj;
            str = gVar.userName;
            j.o(Mp, "fromScene");
            cyc.aO(new com.tencent.mm.plugin.story.model.c.d(cek, str, Mp)).d(this.mmB);
            AppMethodBeat.o(110137);
        } else if (gVar.rVZ.rWl == null) {
            e eVar = e.eOD;
            e.Tb().lR("").d(this.mmB);
            AppMethodBeat.o(110137);
        } else {
            cee cee = gVar.rVZ.rWl;
            if (cee != null) {
                ab.i(h.TAG, "load fake localFile:" + cee.thumbPath + ", position:" + getPosition() + ", videoPath:" + cee.videoPath);
                e eVar2 = e.eOD;
                com.tencent.mm.loader.a Tb = e.Tb();
                str = cee.thumbPath;
                j.o(str, "it.thumbPath");
                Tb.lR(str).d(this.mmB);
                AppMethodBeat.o(110137);
                return;
            }
            AppMethodBeat.o(110137);
        }
    }
}
