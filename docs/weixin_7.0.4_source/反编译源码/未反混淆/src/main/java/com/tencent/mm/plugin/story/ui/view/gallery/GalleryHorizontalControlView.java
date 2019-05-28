package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.ui.a.a;
import com.tencent.mm.plugin.story.ui.b.c;
import com.tencent.mm.ui.ak;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tJ\u0014\u0010\u0015\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "setSelection", "", "position", "update", "items", "", "updateView", "plugin-story_release"})
public final class GalleryHorizontalControlView extends FrameLayout {
    private final RecyclerView exa;
    private final ArrayList<g> rZR;
    private final a snQ;

    public GalleryHorizontalControlView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110722);
        this.rZR = new ArrayList();
        View.inflate(context, R.layout.ayk, this);
        View findViewById = findViewById(R.id.etj);
        j.o(findViewById, "findViewById(R.id.story_gallery_control_recycler)");
        this.exa = (RecyclerView) findViewById;
        this.exa.setLayoutManager(new c(context));
        this.snQ = new a();
        this.exa.setAdapter(this.snQ);
        this.exa.setFocusable(false);
        this.exa.setVisibility(8);
        setPadding(0, 0, 0, ak.fr(context));
        AppMethodBeat.o(110722);
    }

    public GalleryHorizontalControlView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(110723);
        AppMethodBeat.o(110723);
    }

    public final void dI(List<g> list) {
        AppMethodBeat.i(110720);
        j.p(list, "items");
        this.rZR.clear();
        this.rZR.addAll(list);
        a aVar = this.snQ;
        List list2 = this.rZR;
        j.p(list2, "items");
        aVar.rZR.clear();
        aVar.rZR.addAll(list2);
        this.snQ.notifyDataSetChanged();
        if (this.rZR.size() <= 1) {
            this.exa.setVisibility(8);
            AppMethodBeat.o(110720);
            return;
        }
        this.exa.setVisibility(0);
        AppMethodBeat.o(110720);
    }

    public final void setSelection(int i) {
        AppMethodBeat.i(110721);
        a aVar = this.snQ;
        if (aVar.llU != i) {
            aVar.cg(aVar.llU);
            aVar.llU = i;
            aVar.cg(aVar.llU);
        }
        this.exa.bY(i);
        AppMethodBeat.o(110721);
    }
}
