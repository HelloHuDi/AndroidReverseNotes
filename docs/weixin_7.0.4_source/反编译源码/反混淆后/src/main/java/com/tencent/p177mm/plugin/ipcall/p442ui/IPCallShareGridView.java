package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Context;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallShareGridView */
public class IPCallShareGridView extends GridView {
    public IPCallShareGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IPCallShareGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(22357);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, C8415j.INVALID_ID));
        AppMethodBeat.m2505o(22357);
    }
}
