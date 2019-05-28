package com.tencent.mm.plugin.bizui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class StoryListView extends ListView {
    private boolean jEH;

    public StoryListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setBlockLayoutChildren(boolean z) {
        this.jEH = z;
    }

    /* Access modifiers changed, original: protected */
    public void layoutChildren() {
        AppMethodBeat.i(70048);
        if (!this.jEH) {
            super.layoutChildren();
        }
        AppMethodBeat.o(70048);
    }
}
