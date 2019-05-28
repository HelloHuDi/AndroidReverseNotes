package com.tencent.p177mm.plugin.appbrand.widget.p916h;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.h.a */
public final class C10981a implements LineHeightSpan {
    private final int gravity = 16;
    public int height;

    /* renamed from: ax */
    public final boolean mo22605ax(float f) {
        AppMethodBeat.m2504i(126817);
        if (this.height != Math.round(f)) {
            AppMethodBeat.m2505o(126817);
            return true;
        }
        AppMethodBeat.m2505o(126817);
        return false;
    }

    public C10981a(float f) {
        AppMethodBeat.m2504i(126818);
        this.height = Math.round(f);
        AppMethodBeat.m2505o(126818);
    }

    public final void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, FontMetricsInt fontMetricsInt) {
        AppMethodBeat.m2504i(126819);
        int i5;
        if ((-fontMetricsInt.ascent) > this.height) {
            i5 = -this.height;
            fontMetricsInt.ascent = i5;
            fontMetricsInt.top = i5;
            fontMetricsInt.descent = 0;
            fontMetricsInt.bottom = 0;
            AppMethodBeat.m2505o(126819);
        } else if ((-fontMetricsInt.ascent) + fontMetricsInt.descent > this.height) {
            fontMetricsInt.descent = fontMetricsInt.bottom;
            i5 = fontMetricsInt.descent - this.height;
            fontMetricsInt.ascent = i5;
            fontMetricsInt.top = i5;
            AppMethodBeat.m2505o(126819);
        } else if ((-fontMetricsInt.ascent) + fontMetricsInt.bottom > this.height) {
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = fontMetricsInt.ascent + this.height;
            AppMethodBeat.m2505o(126819);
        } else if ((-fontMetricsInt.top) + fontMetricsInt.bottom > this.height) {
            fontMetricsInt.top = fontMetricsInt.bottom - this.height;
            AppMethodBeat.m2505o(126819);
        } else {
            i5 = this.height - ((-fontMetricsInt.ascent) + fontMetricsInt.descent);
            if (this.gravity == 48) {
                fontMetricsInt.descent += i5;
                fontMetricsInt.bottom = i5 + fontMetricsInt.bottom;
                AppMethodBeat.m2505o(126819);
            } else if (this.gravity == 80) {
                fontMetricsInt.top -= i5;
                fontMetricsInt.ascent -= i5;
                AppMethodBeat.m2505o(126819);
            } else {
                if (this.gravity == 16) {
                    i5 = Math.round(((float) i5) / 2.0f);
                    fontMetricsInt.top -= i5;
                    fontMetricsInt.ascent -= i5;
                    fontMetricsInt.bottom += i5;
                    fontMetricsInt.descent = i5 + fontMetricsInt.descent;
                }
                AppMethodBeat.m2505o(126819);
            }
        }
    }
}
