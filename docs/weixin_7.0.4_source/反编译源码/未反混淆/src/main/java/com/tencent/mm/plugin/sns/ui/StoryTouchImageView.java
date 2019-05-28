package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.i;

public class StoryTouchImageView extends TouchImageView {
    i rDe;

    public StoryTouchImageView(Context context) {
        this(context, null);
    }

    public StoryTouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(39835);
        this.rDe = null;
        this.rDe = ((e) g.M(e.class)).getStoryUIFactory().eW(context);
        this.rDe.aR(this);
        setLayerType(1, null);
        AppMethodBeat.o(39835);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(39836);
        super.onDraw(canvas);
        this.rDe.a(canvas, true, 0);
        AppMethodBeat.o(39836);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(39837);
        super.setOnClickListener(this.rDe.cwV());
        this.rDe.setOnClickListener(onClickListener);
        AppMethodBeat.o(39837);
    }

    public void setShowStoryHint(boolean z) {
        AppMethodBeat.i(39838);
        this.rDe.setShowStoryHint(z);
        AppMethodBeat.o(39838);
    }

    public final void setUserNameAndPageNumber$505cff1c(String str) {
        AppMethodBeat.i(139044);
        this.rDe.dk(str, 1);
        AppMethodBeat.o(139044);
    }
}
