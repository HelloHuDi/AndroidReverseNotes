package com.tencent.p177mm.plugin.collect.p368ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.MMPullDownView;

/* renamed from: com.tencent.mm.plugin.collect.ui.CollectPullDownView */
public class CollectPullDownView extends MMPullDownView {
    public CollectPullDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CollectPullDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void bhG() {
        AppMethodBeat.m2504i(41328);
        View inflate = CollectPullDownView.inflate(this.context, 2130969156, null);
        View inflate2 = CollectPullDownView.inflate(this.context, 2130969156, null);
        addView(inflate, 0, new LayoutParams(-1, C1338a.fromDPToPix(this.context, 48)));
        addView(inflate2, new LayoutParams(-1, C1338a.fromDPToPix(this.context, 48)));
        AppMethodBeat.m2505o(41328);
    }

    public void setLoadDataEnd(boolean z) {
        this.ywo = z;
    }
}
