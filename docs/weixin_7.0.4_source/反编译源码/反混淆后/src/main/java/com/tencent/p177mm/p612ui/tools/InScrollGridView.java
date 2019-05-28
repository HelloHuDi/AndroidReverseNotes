package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.tools.InScrollGridView */
public class InScrollGridView extends GridView {
    public InScrollGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InScrollGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(34882);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, C8415j.INVALID_ID));
        AppMethodBeat.m2505o(34882);
    }
}
