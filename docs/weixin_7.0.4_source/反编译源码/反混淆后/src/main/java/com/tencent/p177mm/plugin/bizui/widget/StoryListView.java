package com.tencent.p177mm.plugin.bizui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.bizui.widget.StoryListView */
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
        AppMethodBeat.m2504i(70048);
        if (!this.jEH) {
            super.layoutChildren();
        }
        AppMethodBeat.m2505o(70048);
    }
}
