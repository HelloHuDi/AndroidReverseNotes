package com.tencent.mm.ui.base;

import android.content.Context;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMGridView extends GridView {
    public MMGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(106652);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, j.INVALID_ID));
        AppMethodBeat.o(106652);
    }
}
