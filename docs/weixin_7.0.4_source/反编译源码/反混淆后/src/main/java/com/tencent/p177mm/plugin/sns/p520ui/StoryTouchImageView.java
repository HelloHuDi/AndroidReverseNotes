package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.story.api.C29268i;
import com.tencent.p177mm.plugin.story.api.C35168e;

/* renamed from: com.tencent.mm.plugin.sns.ui.StoryTouchImageView */
public class StoryTouchImageView extends TouchImageView {
    C29268i rDe;

    public StoryTouchImageView(Context context) {
        this(context, null);
    }

    public StoryTouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(39835);
        this.rDe = null;
        this.rDe = ((C35168e) C1720g.m3530M(C35168e.class)).getStoryUIFactory().mo69259eW(context);
        this.rDe.mo9014aR(this);
        setLayerType(1, null);
        AppMethodBeat.m2505o(39835);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(39836);
        super.onDraw(canvas);
        this.rDe.mo9013a(canvas, true, 0);
        AppMethodBeat.m2505o(39836);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(39837);
        super.setOnClickListener(this.rDe.cwV());
        this.rDe.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(39837);
    }

    public void setShowStoryHint(boolean z) {
        AppMethodBeat.m2504i(39838);
        this.rDe.setShowStoryHint(z);
        AppMethodBeat.m2505o(39838);
    }

    public final void setUserNameAndPageNumber$505cff1c(String str) {
        AppMethodBeat.m2504i(139044);
        this.rDe.mo9016dk(str, 1);
        AppMethodBeat.m2505o(139044);
    }
}
