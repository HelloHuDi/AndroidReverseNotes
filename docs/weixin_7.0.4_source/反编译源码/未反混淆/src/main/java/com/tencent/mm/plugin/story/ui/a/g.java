package com.tencent.mm.plugin.story.ui.a;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0004H\u0016J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0002H\u0016J\u0014\u0010&\u001a\u00020\u00182\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0(R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011RL\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\f¨\u0006)"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryViewHolder;", "width", "", "height", "(II)V", "flipItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "getHeight", "()I", "isActive", "", "()Z", "setActive", "(Z)V", "onItemLongClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getWidth", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "update", "items", "", "plugin-story_release"})
public final class g extends a<i> {
    public boolean csi;
    private final int height;
    private final ArrayList<com.tencent.mm.plugin.story.model.d.g> sfQ = new ArrayList();
    private final int width;

    public g(int i, int i2) {
        AppMethodBeat.i(110136);
        this.width = i;
        this.height = i2;
        AppMethodBeat.o(110136);
    }

    public final /* synthetic */ void k(v vVar) {
        AppMethodBeat.i(110135);
        i iVar = (i) vVar;
        j.p(iVar, "holder");
        ab.i(h.TAG, "onViewAttachedToWindow ".concat(String.valueOf(this)));
        super.k(iVar);
        iVar.cCi();
        AppMethodBeat.o(110135);
    }

    public final void dI(List<com.tencent.mm.plugin.story.model.d.g> list) {
        AppMethodBeat.i(110131);
        j.p(list, "items");
        this.sfQ.clear();
        this.sfQ.addAll(list);
        AppMethodBeat.o(110131);
    }

    public final int getItemCount() {
        AppMethodBeat.i(110132);
        int size = this.sfQ.size();
        AppMethodBeat.o(110132);
        return size;
    }
}
