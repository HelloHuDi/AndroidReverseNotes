package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class MaskTextView extends SnsTextView {
    public MaskTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(38321);
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.o(38321);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(38322);
        super.onMeasure(i, i2);
        AppMethodBeat.o(38322);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(38323);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(38323);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.MaskTextView", th, "", new Object[0]);
            AppMethodBeat.o(38323);
        }
    }
}
