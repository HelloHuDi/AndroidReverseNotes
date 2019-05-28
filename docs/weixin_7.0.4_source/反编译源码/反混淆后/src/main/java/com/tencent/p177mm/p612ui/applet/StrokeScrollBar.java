package com.tencent.p177mm.p612ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.VerticalScrollBar;

/* renamed from: com.tencent.mm.ui.applet.StrokeScrollBar */
public class StrokeScrollBar extends VerticalScrollBar {
    /* renamed from: Ky */
    public final void mo24098Ky() {
        AppMethodBeat.m2504i(29979);
        this.nBS = new String[18];
        for (int i = 0; i < this.nBS.length; i++) {
            this.nBS[i] = Integer.toString(i + 3) + "劃";
        }
        this.nBQ = 2.0f;
        this.nBR = 79;
        AppMethodBeat.m2505o(29979);
    }

    public StrokeScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getToastLayoutId() {
        return 2130970676;
    }
}
