package com.tencent.neattextview.textview.p658b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.layout.C7378d;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.neattextview.textview.b.c */
public class C7376c extends C5781b<ClickableSpan> {
    public boolean ozq;

    public C7376c(int i, int i2, ClickableSpan clickableSpan) {
        super(i, i2, clickableSpan);
    }

    /* renamed from: a */
    public final void mo11829a(Canvas canvas, TextPaint textPaint, List<C7378d> list) {
        AppMethodBeat.m2504i(3242);
        mo11832fz(list);
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
        AppMethodBeat.m2505o(3242);
    }
}
