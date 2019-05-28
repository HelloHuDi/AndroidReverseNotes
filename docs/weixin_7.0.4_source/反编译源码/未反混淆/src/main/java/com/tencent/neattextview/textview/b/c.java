package com.tencent.neattextview.textview.b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.layout.d;
import java.util.Iterator;
import java.util.List;

public class c extends b<ClickableSpan> {
    public boolean ozq;

    public c(int i, int i2, ClickableSpan clickableSpan) {
        super(i, i2, clickableSpan);
    }

    public final void a(Canvas canvas, TextPaint textPaint, List<d> list) {
        AppMethodBeat.i(3242);
        fz(list);
        if (this.ozq) {
            int color = textPaint.getColor();
            int i = textPaint.bgColor;
            boolean isUnderlineText = textPaint.isUnderlineText();
            ((ClickableSpan) this.AjW).updateDrawState(textPaint);
            textPaint.setColor(textPaint.bgColor);
            Iterator it = this.AjV.iterator();
            while (it.hasNext()) {
                canvas.drawRect((RectF) it.next(), textPaint);
            }
            textPaint.setColor(color);
            textPaint.setUnderlineText(isUnderlineText);
            textPaint.bgColor = i;
            this.ozq = false;
        }
        AppMethodBeat.o(3242);
    }
}
