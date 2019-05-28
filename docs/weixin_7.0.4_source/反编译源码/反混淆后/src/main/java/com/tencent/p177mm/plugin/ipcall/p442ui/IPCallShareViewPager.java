package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.CustomViewPager;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareViewPager */
public class IPCallShareViewPager extends CustomViewPager {
    public IPCallShareViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(22359);
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
        AppMethodBeat.m2505o(22359);
    }
}
