package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;

public class SnsComment2LinePreloadTextView extends PLTextView {
    private static a rMO = null;
    private static int rMP = 0;
    private boolean rMQ = false;

    public SnsComment2LinePreloadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsComment2LinePreloadTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final a SQ() {
        AppMethodBeat.i(40470);
        if (rMO == null) {
            rMO = b.cvx().getTextViewConfig();
        }
        a aVar = rMO;
        AppMethodBeat.o(40470);
        return aVar;
    }

    public static a getTextViewConfig() {
        AppMethodBeat.i(40471);
        if (rMO == null) {
            rMO = b.cvx().getTextViewConfig();
        }
        a aVar = rMO;
        AppMethodBeat.o(40471);
        return aVar;
    }

    public final void w(CharSequence charSequence) {
        AppMethodBeat.i(40472);
        super.w(charSequence);
        AppMethodBeat.o(40472);
    }

    public final void v(CharSequence charSequence) {
        AppMethodBeat.i(40473);
        super.v(charSequence);
        AppMethodBeat.o(40473);
    }

    public static int getViewWidth() {
        AppMethodBeat.i(40474);
        if (rMP == 0) {
            rMP = b.cvx().getViewWidth();
        }
        int i = rMP;
        AppMethodBeat.o(40474);
        return i;
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(40475);
        super.onMeasure(i, i2);
        AppMethodBeat.o(40475);
    }
}
