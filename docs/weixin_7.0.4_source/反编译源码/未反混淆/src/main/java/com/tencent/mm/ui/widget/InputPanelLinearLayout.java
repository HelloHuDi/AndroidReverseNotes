package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.a;

public class InputPanelLinearLayout extends LinearLayout implements a {
    private b zLU;

    public InputPanelLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputPanelLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107859);
        this.zLU = new b(this, this);
        AppMethodBeat.o(107859);
    }

    public b getInputPanelHelper() {
        return this.zLU;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(107860);
        this.zLU.PR(i2);
        super.onMeasure(i, i2);
        AppMethodBeat.o(107860);
    }

    public void m(boolean z, int i) {
    }
}
