package com.tencent.mm.wallet_core.ui.formview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends ReplacementSpan {
    private int Aig;

    public d(int i) {
        this.Aig = i;
    }

    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        AppMethodBeat.i(138103);
        int measureText = (int) c(paint).measureText(charSequence.subSequence(i, i2).toString());
        AppMethodBeat.o(138103);
        return measureText;
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        AppMethodBeat.i(138104);
        CharSequence subSequence = charSequence.subSequence(i, i2);
        TextPaint c = c(paint);
        FontMetricsInt fontMetricsInt = c.getFontMetricsInt();
        canvas.drawText(subSequence.toString(), f, (float) (i4 - (((fontMetricsInt.ascent + ((fontMetricsInt.descent + i4) + i4)) / 2) - ((i5 + i3) / 2))), c);
        AppMethodBeat.o(138104);
    }

    private TextPaint c(Paint paint) {
        AppMethodBeat.i(138105);
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setTextSize((float) this.Aig);
        AppMethodBeat.o(138105);
        return textPaint;
    }
}
