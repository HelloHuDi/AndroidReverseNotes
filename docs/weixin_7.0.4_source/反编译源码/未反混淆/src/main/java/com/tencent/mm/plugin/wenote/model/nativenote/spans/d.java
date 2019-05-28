package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d implements LeadingMarginSpan, f<Boolean>, g<Boolean> {
    private static Path uRT = null;
    private final int uRU;
    public boolean uRV;

    public d(int i, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(26937);
        this.uRU = i;
        boolean z4 = z && z3 && !z2;
        this.uRV = z4;
        if (uRT == null) {
            uRT = new Path();
        }
        AppMethodBeat.o(26937);
    }

    private d(int i, boolean z) {
        this.uRU = i;
        this.uRV = z;
    }

    public final int getLeadingMargin(boolean z) {
        return this.uRV ? 0 : this.uRU;
    }

    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        AppMethodBeat.i(26938);
        Spanned spanned = (Spanned) charSequence;
        if (!this.uRV && spanned.getSpanStart(this) == i6) {
            Style style = paint.getStyle();
            paint.setStyle(Style.FILL);
            uRT.reset();
            uRT.addCircle(0.0f, 0.0f, 6.0f, Direction.CW);
            FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i8 = (fontMetricsInt.ascent + ((fontMetricsInt.descent + i4) + i4)) / 2;
            canvas.save();
            canvas.translate((float) ((i2 * 6) + i), (float) i8);
            canvas.drawPath(uRT, paint);
            canvas.restore();
            paint.setStyle(style);
        }
        AppMethodBeat.o(26938);
    }

    public final /* bridge */ /* synthetic */ Object getValue() {
        return Boolean.TRUE;
    }

    public final /* synthetic */ f dfC() {
        AppMethodBeat.i(26939);
        d dVar = new d(this.uRU, this.uRV);
        AppMethodBeat.o(26939);
        return dVar;
    }
}
