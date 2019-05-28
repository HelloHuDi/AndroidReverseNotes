package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
        AppMethodBeat.i(38913);
        super.buildDrawingCache(z);
        AppMethodBeat.o(38913);
    }

    public void destroyDrawingCache() {
        AppMethodBeat.i(38914);
        super.destroyDrawingCache();
        AppMethodBeat.o(38914);
    }
}
