package com.tencent.mm.ui;

import android.content.Context;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ListViewInScrollView extends ListView {
    public ListViewInScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ListViewInScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(105983);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, j.INVALID_ID));
        AppMethodBeat.o(105983);
    }
}
