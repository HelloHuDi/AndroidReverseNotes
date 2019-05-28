package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public abstract class AbsStoryMuteView extends RelativeLayout {
    public abstract void cwM();

    public abstract void cwN();

    public AbsStoryMuteView(Context context) {
        super(context);
    }

    public AbsStoryMuteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbsStoryMuteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
