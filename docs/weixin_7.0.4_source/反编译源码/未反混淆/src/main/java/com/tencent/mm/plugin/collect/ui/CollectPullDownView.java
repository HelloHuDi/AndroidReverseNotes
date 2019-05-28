package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.ui.base.MMPullDownView;

public class CollectPullDownView extends MMPullDownView {
    public CollectPullDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CollectPullDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void bhG() {
        AppMethodBeat.i(41328);
        View inflate = inflate(this.context, R.layout.ox, null);
        View inflate2 = inflate(this.context, R.layout.ox, null);
        addView(inflate, 0, new LayoutParams(-1, a.fromDPToPix(this.context, 48)));
        addView(inflate2, new LayoutParams(-1, a.fromDPToPix(this.context, 48)));
        AppMethodBeat.o(41328);
    }

    public void setLoadDataEnd(boolean z) {
        this.ywo = z;
    }
}
