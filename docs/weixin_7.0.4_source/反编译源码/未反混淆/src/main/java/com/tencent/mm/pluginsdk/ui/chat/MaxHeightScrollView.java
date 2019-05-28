package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class MaxHeightScrollView extends ScrollView {
    private int dj;

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27951);
        init(context, attributeSet);
        AppMethodBeat.o(27951);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(27952);
        init(context, attributeSet);
        AppMethodBeat.o(27952);
    }

    private void init(Context context, AttributeSet attributeSet) {
        int i = 0;
        AppMethodBeat.i(27953);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.MaxHeightScrollView, 0, 0);
        try {
            int indexCount = obtainStyledAttributes.getIndexCount();
            while (i < indexCount) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                }
                i++;
            }
        } finally {
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(27953);
        }
    }

    public void setMaxHeight(int i) {
        this.dj = i;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(27954);
        if (this.dj > 0) {
            i2 = MeasureSpec.makeMeasureSpec(this.dj, j.INVALID_ID);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(27954);
    }
}
