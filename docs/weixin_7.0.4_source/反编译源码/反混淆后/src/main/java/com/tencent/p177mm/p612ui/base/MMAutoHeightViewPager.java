package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.support.p057v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.base.MMAutoHeightViewPager */
public class MMAutoHeightViewPager extends ViewPager {
    private static final String TAG = "MicoMsg.MMAutoHeightViewPager";

    public MMAutoHeightViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
    }

    public MMAutoHeightViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMAutoHeightViewPager(Context context) {
        super(context);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(106483);
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            childAt.measure(i, MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i3) {
                i3 = measuredHeight;
            }
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(i3, ErrorDialogData.SUPPRESSED));
        AppMethodBeat.m2505o(106483);
    }
}
