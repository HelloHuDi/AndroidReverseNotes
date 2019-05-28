package com.tencent.p177mm.p612ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.widget.FoursquareRelativeLayout */
public class FoursquareRelativeLayout extends RelativeLayout {
    public FoursquareRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FoursquareRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(107848);
        super.onMeasure(i, i);
        AppMethodBeat.m2505o(107848);
    }
}
