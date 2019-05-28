package com.tencent.p177mm.plugin.sns.p520ui.previewimageview;

import android.content.Context;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.WrappingGridView */
public class WrappingGridView extends GridView {
    public WrappingGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WrappingGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(40413);
        if (getLayoutParams().height == -2) {
            i2 = MeasureSpec.makeMeasureSpec(536870911, C8415j.INVALID_ID);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(40413);
    }
}
