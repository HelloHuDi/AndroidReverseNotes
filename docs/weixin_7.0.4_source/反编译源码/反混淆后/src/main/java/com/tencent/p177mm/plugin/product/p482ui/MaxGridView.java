package com.tencent.p177mm.plugin.product.p482ui;

import android.content.Context;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.product.ui.MaxGridView */
public class MaxGridView extends GridView {
    public MaxGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(44174);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, C8415j.INVALID_ID));
        AppMethodBeat.m2505o(44174);
    }
}
