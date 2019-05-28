package com.tencent.p177mm.plugin.wallet_core.p561ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.ChangeNumView */
public class ChangeNumView extends TextView {
    private int max = 0;
    private int min = 0;
    private int svV = -1;
    private int tNq = 0;
    private boolean tNr = false;
    private final int tNs = 100;

    public ChangeNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChangeNumView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setInteral(int i) {
        this.svV = i;
    }
}
