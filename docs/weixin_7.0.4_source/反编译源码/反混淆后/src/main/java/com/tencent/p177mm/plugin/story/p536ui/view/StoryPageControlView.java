package com.tencent.p177mm.plugin.story.p536ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMPageControlView;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\tR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/StoryPageControlView;", "Lcom/tencent/mm/ui/base/MMPageControlView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mPageIndicatorStatusInterface", "Lcom/tencent/mm/plugin/story/ui/view/StoryPageControlView$IPageIndicatorStatusInterface;", "generatePageControl", "", "currentIndex", "", "setPageIndicatorStatusInterface", "pageControlInterface", "IPageIndicatorStatusInterface", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.StoryPageControlView */
public final class StoryPageControlView extends MMPageControlView {
    private C13861a sjZ;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/StoryPageControlView$IPageIndicatorStatusInterface;", "", "isUnread", "", "index", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.StoryPageControlView$a */
    public interface C13861a {
    }

    public StoryPageControlView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.m2504i(110450);
        AppMethodBeat.m2505o(110450);
    }

    public final void setPageIndicatorStatusInterface(C13861a c13861a) {
        this.sjZ = c13861a;
    }

    /* renamed from: Dr */
    public final void mo26032Dr(int i) {
        AppMethodBeat.m2504i(110449);
        super.mo26032Dr(i);
        int i2 = this.count;
        int i3 = 0;
        while (i3 < i2) {
            this.cAw = (ImageView) this.map.get(Integer.valueOf(i3));
            ImageView imageView = this.cAw;
            C25052j.m39375o(imageView, "imageView");
            imageView.setSelected(i == i3);
            i3++;
        }
        AppMethodBeat.m2505o(110449);
    }
}
