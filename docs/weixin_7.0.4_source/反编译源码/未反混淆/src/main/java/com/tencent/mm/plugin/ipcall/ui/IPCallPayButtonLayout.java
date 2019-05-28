package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCallPayButtonLayout extends RelativeLayout {
    public IPCallPayButtonLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public IPCallPayButtonLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(22237);
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        super.onMeasure(i, MeasureSpec.makeMeasureSpec((int) (((double) getMeasuredWidth()) * 0.62d), ErrorDialogData.SUPPRESSED));
        AppMethodBeat.o(22237);
    }
}
