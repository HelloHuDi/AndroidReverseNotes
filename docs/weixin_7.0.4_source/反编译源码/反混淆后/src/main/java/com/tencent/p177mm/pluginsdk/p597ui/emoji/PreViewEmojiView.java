package com.tencent.p177mm.pluginsdk.p597ui.emoji;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView */
public class PreViewEmojiView extends MMEmojiView {
    private int mSize = 0;

    public PreViewEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PreViewEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setSize(int i) {
        this.mSize = i;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(62488);
        super.onMeasure(i, i2);
        if (this.mSize > 0) {
            setMeasuredDimension(this.mSize, this.mSize);
        }
        AppMethodBeat.m2505o(62488);
    }
}
