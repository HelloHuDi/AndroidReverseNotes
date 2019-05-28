package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C35873d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerTextureView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPlayTextureView;", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handleOnSurfaceTextureUpdated", "", "surface", "Landroid/graphics/SurfaceTexture;", "seekTo", "time", "", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoPlayTextureView */
public final class StoryVideoPlayTextureView extends VideoPlayerTextureView {
    public StoryVideoPlayTextureView(Context context) {
        super(context);
        AppMethodBeat.m2504i(110860);
        setScaleType(C35873d.COVER);
        AppMethodBeat.m2505o(110860);
    }

    public StoryVideoPlayTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(110861);
        setScaleType(C35873d.COVER);
        AppMethodBeat.m2505o(110861);
    }

    public StoryVideoPlayTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110862);
        setScaleType(C35873d.COVER);
        AppMethodBeat.m2505o(110862);
    }

    /* renamed from: B */
    public final void mo9052B(double d) {
        AppMethodBeat.m2504i(110858);
        if (this.f17239VN) {
            super.mo9052B(d);
            AppMethodBeat.m2505o(110858);
            return;
        }
        C4990ab.m7409c("MicroMsg.VideoPlayerTextureView", hashCode() + " error seekTo " + this.f17239VN + ' ', new Object[0]);
        AppMethodBeat.m2505o(110858);
    }

    /* renamed from: i */
    public final void mo9053i(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(110859);
        super.mo9053i(surfaceTexture);
        this.llE.mo8554dG(getCurrentPosition(), getDuration());
        AppMethodBeat.m2505o(110859);
    }
}
