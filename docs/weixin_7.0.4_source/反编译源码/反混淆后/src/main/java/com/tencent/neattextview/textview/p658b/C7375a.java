package com.tencent.neattextview.textview.p658b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.layout.C7378d;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.neattextview.textview.b.a */
public final class C7375a extends C5781b<BackgroundColorSpan> {
    public C7375a(int i, int i2, CharacterStyle characterStyle) {
        super(i, i2, characterStyle);
    }

    /* renamed from: a */
    public final void mo11829a(Canvas canvas, TextPaint textPaint, List<C7378d> list) {
        AppMethodBeat.m2504i(3241);
        mo11832fz(list);
        int color = textPaint.getColor();
        textPaint.setColor(((BackgroundColorSpan) this.AjW).getBackgroundColor());
        Iterator it = this.AjV.iterator();
        while (it.hasNext()) {
            canvas.drawRect((RectF) it.next(), textPaint);
        }
        textPaint.setColor(color);
        AppMethodBeat.m2505o(3241);
    }
}
