package com.tencent.p177mm.plugin.sns.p520ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kiss.widget.textview.PLTextView;
import com.tencent.p177mm.kiss.widget.textview.p1194a.C42149a;

/* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsCommentPreloadTextView */
public class SnsCommentPreloadTextView extends PLTextView {
    private static C42149a rMO = null;
    private static int rMP = 0;
    private boolean rMQ = false;

    public SnsCommentPreloadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsCommentPreloadTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: SQ */
    public final C42149a mo47418SQ() {
        AppMethodBeat.m2504i(40494);
        if (rMO == null) {
            rMO = C35146c.cvy().getTextViewConfig();
        }
        C42149a c42149a = rMO;
        AppMethodBeat.m2505o(40494);
        return c42149a;
    }

    public static C42149a getTextViewConfig() {
        AppMethodBeat.m2504i(40495);
        if (rMO == null) {
            rMO = C35146c.cvy().getTextViewConfig();
        }
        C42149a c42149a = rMO;
        AppMethodBeat.m2505o(40495);
        return c42149a;
    }

    /* renamed from: w */
    public final void mo33774w(CharSequence charSequence) {
        AppMethodBeat.m2504i(40496);
        super.mo33774w(charSequence);
        AppMethodBeat.m2505o(40496);
    }

    /* renamed from: v */
    public final void mo33773v(CharSequence charSequence) {
        AppMethodBeat.m2504i(40497);
        super.mo33773v(charSequence);
        AppMethodBeat.m2505o(40497);
    }

    public static int getViewWidth() {
        AppMethodBeat.m2504i(40498);
        if (rMP == 0) {
            rMP = C35146c.cvy().getViewWidth();
        }
        int i = rMP;
        AppMethodBeat.m2505o(40498);
        return i;
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(40499);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(40499);
    }
}
