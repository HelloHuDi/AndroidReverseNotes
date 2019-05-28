package com.tencent.mm.ui.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a extends ImageSpan {
    public int zLT = 0;

    public a(Drawable drawable) {
        super(drawable, 1);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        AppMethodBeat.i(107846);
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = bounds.bottom - bounds.top;
            int i4 = fontMetricsInt2.ascent + ((fontMetricsInt2.descent - fontMetricsInt2.ascent) / 2);
            fontMetricsInt.ascent = i4 - (i3 / 2);
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = i4 + (i3 / 2);
            fontMetricsInt.descent = fontMetricsInt.bottom;
        }
        int i5 = bounds.right;
        AppMethodBeat.o(107846);
        return i5;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        AppMethodBeat.i(107847);
        Drawable drawable = getDrawable();
        canvas.save();
        FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.translate(f, (float) (((fontMetricsInt.descent + i4) - ((fontMetricsInt.descent - fontMetricsInt.ascent) / 2)) - ((drawable.getBounds().bottom - drawable.getBounds().top) / 2)));
        drawable.draw(canvas);
        canvas.restore();
        AppMethodBeat.o(107847);
    }
}
