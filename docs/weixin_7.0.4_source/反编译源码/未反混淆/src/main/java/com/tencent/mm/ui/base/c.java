package com.tencent.mm.ui.base;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.LineBackgroundSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.textview.b;

public final class c implements LineBackgroundSpan {
    private final int color;
    private int end;
    private Rect rect = new Rect();
    private int start;
    private View ysm;

    public c(View view, int i, int i2, int i3) {
        AppMethodBeat.i(112502);
        this.ysm = view;
        this.color = i;
        this.start = i2;
        this.end = i3;
        AppMethodBeat.o(112502);
    }

    public final void setPosition(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    public final void drawBackground(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, int i8) {
        AppMethodBeat.i(112503);
        if (this.end < i6) {
            AppMethodBeat.o(112503);
        } else if (this.start > i7) {
            AppMethodBeat.o(112503);
        } else {
            Rect rect;
            int color = paint.getColor();
            int ar = b.ar(this.ysm, this.start);
            int ar2 = b.ar(this.ysm, this.end);
            if (ar <= i8 && i8 <= ar2) {
                if (ar == i8) {
                    i = (int) b.as(this.ysm, this.start);
                }
                if (ar2 == i8) {
                    i2 = (int) b.as(this.ysm, this.end);
                } else {
                    i2 = (int) b.av(this.ysm, i8);
                }
            }
            ar = (int) (((float) i4) + paint.descent());
            this.rect.left = i;
            if (this.start == i6) {
                rect = this.rect;
                rect.left -= 4;
            }
            this.rect.right = i2;
            if (this.end == i2) {
                rect = this.rect;
                rect.right += 4;
            }
            this.rect.top = i3;
            this.rect.bottom = ar;
            paint.setColor(this.color);
            canvas.drawRect(this.rect, paint);
            paint.setColor(color);
            AppMethodBeat.o(112503);
        }
    }
}
