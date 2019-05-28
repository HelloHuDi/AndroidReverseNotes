package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class m implements LeadingMarginSpan, f<Boolean>, g<Boolean> {
    public static float uSe = 0.0f;
    private float mWidth;
    private float nnX = 10.0f;
    private final int uRU;
    public boolean uRV;
    private final int uSd;

    public m(int i, int i2, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(26954);
        this.uSd = i;
        this.uRU = i2;
        boolean z4 = z && z3 && !z2;
        this.uRV = z4;
        AppMethodBeat.o(26954);
    }

    private m(int i, int i2, boolean z) {
        this.uSd = i;
        this.uRU = i2;
        this.uRV = z;
    }

    public int getLeadingMargin(boolean z) {
        AppMethodBeat.i(26955);
        uSe = (float) Math.max(Math.round(this.mWidth + 2.0f > uSe ? this.mWidth + 2.0f : uSe), this.uRU);
        if (this.uRV) {
            AppMethodBeat.o(26955);
            return 0;
        }
        int i = (int) uSe;
        AppMethodBeat.o(26955);
        return i;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        AppMethodBeat.i(26956);
        Spanned spanned = (Spanned) charSequence;
        if (!this.uRV && spanned.getSpanStart(this) == i6) {
            Style style = paint.getStyle();
            float textSize = paint.getTextSize();
            paint.setStyle(Style.FILL);
            this.nnX = (float) (i4 - i3);
            this.mWidth = paint.measureText(this.uSd + ".");
            canvas.drawText(this.uSd + ".", (float) i, (float) i4, paint);
            paint.setStyle(style);
            paint.setTextSize(textSize);
        }
        AppMethodBeat.o(26956);
    }

    public final /* bridge */ /* synthetic */ Object getValue() {
        return Boolean.TRUE;
    }

    public final /* synthetic */ f dfC() {
        AppMethodBeat.i(26957);
        m mVar = new m(this.uSd, this.uRU, this.uRV);
        AppMethodBeat.o(26957);
        return mVar;
    }
}
