package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.content.Context;
import android.support.p069v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g;
import com.tencent.p177mm.plugin.story.p536ui.p1037a.C39916a;
import com.tencent.p177mm.plugin.story.p536ui.p1305b.C22264c;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tJ\u0014\u0010\u0015\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "setSelection", "", "position", "update", "items", "", "updateView", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.GalleryHorizontalControlView */
public final class GalleryHorizontalControlView extends FrameLayout {
    private final RecyclerView exa;
    private final ArrayList<C43640g> rZR;
    private final C39916a snQ;

    public GalleryHorizontalControlView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110722);
        this.rZR = new ArrayList();
        View.inflate(context, 2130970884, this);
        View findViewById = findViewById(2131828148);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_gallery_control_recycler)");
        this.exa = (RecyclerView) findViewById;
        this.exa.setLayoutManager(new C22264c(context));
        this.snQ = new C39916a();
        this.exa.setAdapter(this.snQ);
        this.exa.setFocusable(false);
        this.exa.setVisibility(8);
        setPadding(0, 0, 0, C5230ak.m7988fr(context));
        AppMethodBeat.m2505o(110722);
    }

    public GalleryHorizontalControlView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110723);
        AppMethodBeat.m2505o(110723);
    }

    /* renamed from: dI */
    public final void mo55908dI(List<C43640g> list) {
        AppMethodBeat.m2504i(110720);
        C25052j.m39376p(list, "items");
        this.rZR.clear();
        this.rZR.addAll(list);
        C39916a c39916a = this.snQ;
        List list2 = this.rZR;
        C25052j.m39376p(list2, "items");
        c39916a.rZR.clear();
        c39916a.rZR.addAll(list2);
        this.snQ.notifyDataSetChanged();
        if (this.rZR.size() <= 1) {
            this.exa.setVisibility(8);
            AppMethodBeat.m2505o(110720);
            return;
        }
        this.exa.setVisibility(0);
        AppMethodBeat.m2505o(110720);
    }

    public final void setSelection(int i) {
        AppMethodBeat.m2504i(110721);
        C39916a c39916a = this.snQ;
        if (c39916a.llU != i) {
            c39916a.mo66316cg(c39916a.llU);
            c39916a.llU = i;
            c39916a.mo66316cg(c39916a.llU);
        }
        this.exa.mo61465bY(i);
        AppMethodBeat.m2505o(110721);
    }
}
