package com.tencent.mm.ui.widget;

import android.content.Context;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMScrollGridView extends GridView {
    public MMScrollGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMScrollGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(107913);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, j.INVALID_ID));
        AppMethodBeat.o(107913);
    }
}
