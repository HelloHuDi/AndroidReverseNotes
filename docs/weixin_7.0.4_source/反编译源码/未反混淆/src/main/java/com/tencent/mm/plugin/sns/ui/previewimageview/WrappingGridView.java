package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WrappingGridView extends GridView {
    public WrappingGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WrappingGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(40413);
        if (getLayoutParams().height == -2) {
            i2 = MeasureSpec.makeMeasureSpec(536870911, j.INVALID_ID);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(40413);
    }
}
