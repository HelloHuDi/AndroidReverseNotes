package com.tencent.mm.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.VerticalScrollBar;

public class StrokeScrollBar extends VerticalScrollBar {
    public final void Ky() {
        AppMethodBeat.i(29979);
        this.nBS = new String[18];
        for (int i = 0; i < this.nBS.length; i++) {
            this.nBS[i] = Integer.toString(i + 3) + "劃";
        }
        this.nBQ = 2.0f;
        this.nBR = 79;
        AppMethodBeat.o(29979);
    }

    public StrokeScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getToastLayoutId() {
        return R.layout.asx;
    }
}
