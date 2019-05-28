package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.app.Activity;
import android.content.Context;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallFeedbackScrollView */
public class IPCallFeedbackScrollView extends ScrollView {
    public IPCallFeedbackScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IPCallFeedbackScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(22179);
        try {
            Display defaultDisplay = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            i2 = MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels / 2, C8415j.INVALID_ID);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.IPCallFeedbackScrollView", e, "", new Object[0]);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(22179);
    }
}
