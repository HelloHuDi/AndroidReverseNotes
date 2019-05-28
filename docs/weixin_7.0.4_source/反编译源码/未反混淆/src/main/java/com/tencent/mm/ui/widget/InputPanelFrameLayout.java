package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.a;

public class InputPanelFrameLayout extends FrameLayout implements a {
    private b zLU;

    public InputPanelFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputPanelFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107849);
        this.zLU = new b(this, this);
        AppMethodBeat.o(107849);
    }

    public void m(boolean z, int i) {
    }

    public b getInputPanelHelper() {
        return this.zLU;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(107850);
        this.zLU.PR(i2);
        super.onMeasure(i, i2);
        AppMethodBeat.o(107850);
    }
}
