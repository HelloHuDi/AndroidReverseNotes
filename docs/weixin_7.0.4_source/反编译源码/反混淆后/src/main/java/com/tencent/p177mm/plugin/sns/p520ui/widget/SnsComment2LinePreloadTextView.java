package com.tencent.p177mm.plugin.sns.p520ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kiss.widget.textview.PLTextView;
import com.tencent.p177mm.kiss.widget.textview.p1194a.C42149a;

/* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsComment2LinePreloadTextView */
public class SnsComment2LinePreloadTextView extends PLTextView {
    private static C42149a rMO = null;
    private static int rMP = 0;
    private boolean rMQ = false;

    public SnsComment2LinePreloadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsComment2LinePreloadTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: SQ */
    public final C42149a mo47418SQ() {
        AppMethodBeat.m2504i(40470);
        if (rMO == null) {
            rMO = C39850b.cvx().getTextViewConfig();
        }
        C42149a c42149a = rMO;
        AppMethodBeat.m2505o(40470);
        return c42149a;
    }

    public static C42149a getTextViewConfig() {
        AppMethodBeat.m2504i(40471);
        if (rMO == null) {
            rMO = C39850b.cvx().getTextViewConfig();
        }
        C42149a c42149a = rMO;
        AppMethodBeat.m2505o(40471);
        return c42149a;
    }

    /* renamed from: w */
    public final void mo33774w(CharSequence charSequence) {
        AppMethodBeat.m2504i(40472);
        super.mo33774w(charSequence);
        AppMethodBeat.m2505o(40472);
    }

    /* renamed from: v */
    public final void mo33773v(CharSequence charSequence) {
        AppMethodBeat.m2504i(40473);
        super.mo33773v(charSequence);
        AppMethodBeat.m2505o(40473);
    }

    public static int getViewWidth() {
        AppMethodBeat.m2504i(40474);
        if (rMP == 0) {
            rMP = C39850b.cvx().getViewWidth();
        }
        int i = rMP;
        AppMethodBeat.m2505o(40474);
        return i;
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(40475);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(40475);
    }
}
