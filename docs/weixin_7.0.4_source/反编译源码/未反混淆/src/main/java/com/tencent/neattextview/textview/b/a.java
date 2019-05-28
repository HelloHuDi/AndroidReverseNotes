package com.tencent.neattextview.textview.b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.layout.d;
import java.util.Iterator;
import java.util.List;

public final class a extends b<BackgroundColorSpan> {
    public a(int i, int i2, CharacterStyle characterStyle) {
        super(i, i2, characterStyle);
    }

    public final void a(Canvas canvas, TextPaint textPaint, List<d> list) {
        AppMethodBeat.i(3241);
        fz(list);
        int color = textPaint.getColor();
        textPaint.setColor(((BackgroundColorSpan) this.AjW).getBackgroundColor());
        Iterator it = this.AjV.iterator();
        while (it.hasNext()) {
            canvas.drawRect((RectF) it.next(), textPaint);
        }
        textPaint.setColor(color);
        AppMethodBeat.o(3241);
    }
}
