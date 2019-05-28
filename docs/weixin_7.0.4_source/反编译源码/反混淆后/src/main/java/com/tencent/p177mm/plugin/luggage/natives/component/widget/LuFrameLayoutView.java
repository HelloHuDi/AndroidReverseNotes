package com.tencent.p177mm.plugin.luggage.natives.component.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.luggage.natives.component.widget.LuFrameLayoutView */
public class LuFrameLayoutView extends FrameLayout {
    public LuFrameLayoutView(Context context) {
        super(context);
    }

    public LuFrameLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LuFrameLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(116845);
        super.onDraw(canvas);
        AppMethodBeat.m2505o(116845);
    }
}
