package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.ui.MaskTextView */
public class MaskTextView extends SnsTextView {
    public MaskTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(38321);
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.m2505o(38321);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(38322);
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(38322);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(38323);
        try {
            super.onDraw(canvas);
            AppMethodBeat.m2505o(38323);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.MaskTextView", th, "", new Object[0]);
            AppMethodBeat.m2505o(38323);
        }
    }
}
