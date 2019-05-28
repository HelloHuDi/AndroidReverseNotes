package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;

public class SnsCommentPreloadTextView extends PLTextView {
    private static a rMO = null;
    private static int rMP = 0;
    private boolean rMQ = false;

    public SnsCommentPreloadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsCommentPreloadTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final a SQ() {
        AppMethodBeat.i(40494);
        if (rMO == null) {
            rMO = c.cvy().getTextViewConfig();
        }
        a aVar = rMO;
        AppMethodBeat.o(40494);
        return aVar;
    }

    public static a getTextViewConfig() {
        AppMethodBeat.i(40495);
        if (rMO == null) {
            rMO = c.cvy().getTextViewConfig();
        }
        a aVar = rMO;
        AppMethodBeat.o(40495);
        return aVar;
    }

    public final void w(CharSequence charSequence) {
        AppMethodBeat.i(40496);
        super.w(charSequence);
        AppMethodBeat.o(40496);
    }

    public final void v(CharSequence charSequence) {
        AppMethodBeat.i(40497);
        super.v(charSequence);
        AppMethodBeat.o(40497);
    }

    public static int getViewWidth() {
        AppMethodBeat.i(40498);
        if (rMP == 0) {
            rMP = c.cvy().getViewWidth();
        }
        int i = rMP;
        AppMethodBeat.o(40498);
        return i;
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(40499);
        super.onMeasure(i, i2);
        AppMethodBeat.o(40499);
    }
}
