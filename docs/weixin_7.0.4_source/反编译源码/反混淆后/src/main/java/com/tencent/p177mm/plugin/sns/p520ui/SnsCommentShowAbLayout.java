package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentShowAbLayout */
public class SnsCommentShowAbLayout extends AbsoluteLayout {
    public SnsCommentShowAbLayout(Context context) {
        super(context);
    }

    public SnsCommentShowAbLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsCommentShowAbLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void buildDrawingCache(boolean z) {
        AppMethodBeat.m2504i(38913);
        super.buildDrawingCache(z);
        AppMethodBeat.m2505o(38913);
    }

    public void destroyDrawingCache() {
        AppMethodBeat.m2504i(38914);
        super.destroyDrawingCache();
        AppMethodBeat.m2505o(38914);
    }
}
