package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class IPCallFeedbackScrollView extends ScrollView {
    public IPCallFeedbackScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IPCallFeedbackScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(22179);
        try {
            Display defaultDisplay = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            i2 = MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels / 2, j.INVALID_ID);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.IPCallFeedbackScrollView", e, "", new Object[0]);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(22179);
    }
}
