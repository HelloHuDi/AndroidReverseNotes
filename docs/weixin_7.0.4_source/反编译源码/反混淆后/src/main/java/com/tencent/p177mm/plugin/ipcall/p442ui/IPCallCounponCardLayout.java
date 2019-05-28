package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallCounponCardLayout */
public class IPCallCounponCardLayout extends RelativeLayout {
    public IPCallCounponCardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public IPCallCounponCardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(22097);
        setMeasuredDimension(IPCallCounponCardLayout.getDefaultSize(0, i), IPCallCounponCardLayout.getDefaultSize(0, i2));
        super.onMeasure(i, MeasureSpec.makeMeasureSpec((getMeasuredWidth() * 3) / 5, ErrorDialogData.SUPPRESSED));
        AppMethodBeat.m2505o(22097);
    }
}
