package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview;

import android.content.Context;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.ChartGridView */
public abstract class ChartGridView extends View {
    public abstract int cpg();

    public abstract int cph();

    public ChartGridView(Context context) {
        super(context);
    }

    public ChartGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChartGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        MeasureSpec.getMode(i);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case C8415j.INVALID_ID /*-2147483648*/:
                size = getSuggestedMinimumWidth();
                break;
            case 0:
                size = cph();
                break;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        switch (mode2) {
            case C8415j.INVALID_ID /*-2147483648*/:
                mode = getSuggestedMinimumHeight();
                break;
            case 0:
                mode = cpg();
                break;
        }
        setMeasuredDimension(size, mode);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }
}
