package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class SnsTextView extends TextView {
    private String nNj = "";
    private char rxN = 0;

    public SnsTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTextContextMenuItem(int i) {
        AppMethodBeat.i(39393);
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
        AppMethodBeat.o(39393);
        return onTextContextMenuItem;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(39394);
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.o(39394);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(39395);
        if (q.etn.esi == 1 || q.etn.esi == -1) {
            try {
                super.onMeasure(i, i2);
                this.rxN = 0;
                AppMethodBeat.o(39395);
                return;
            } catch (IndexOutOfBoundsException e) {
                if (this.rxN < 3) {
                    try {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText());
                        MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MetricAffectingSpan.class);
                        if (metricAffectingSpanArr == null || metricAffectingSpanArr.length <= 0) {
                            this.rxN = 'd';
                        } else {
                            spannableStringBuilder.insert(spannableStringBuilder.getSpanStart(metricAffectingSpanArr[0]) - 1, " ");
                            this.rxN = (char) (this.rxN + 1);
                        }
                        setText(spannableStringBuilder);
                        onMeasure(i, i2);
                        AppMethodBeat.o(39395);
                        return;
                    } catch (IndexOutOfBoundsException e2) {
                        ab.i("MicroMsg.SnsTextView", "tryToFix error set origintext " + bo.isNullOrNil(this.nNj));
                        setText(this.nNj);
                        onMeasure(i, i2);
                        this.rxN = (char) (this.rxN + 1);
                        AppMethodBeat.o(39395);
                        return;
                    }
                } else if (this.rxN == 3) {
                    ab.i("MicroMsg.SnsTextView", "fix error set origintext " + bo.isNullOrNil(this.nNj));
                    setText(this.nNj);
                    onMeasure(i, i2);
                    this.rxN = (char) (this.rxN + 1);
                    AppMethodBeat.o(39395);
                    return;
                } else {
                    AppMethodBeat.o(39395);
                    throw e;
                }
            }
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(39395);
    }

    public void setOriginText(String str) {
        this.nNj = str;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(39396);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(39396);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.SnsTextView", th, "", new Object[0]);
            AppMethodBeat.o(39396);
        }
    }

    public int getBaseline() {
        AppMethodBeat.i(39397);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.o(39397);
            return baseline;
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.SnsTextView", th, "", new Object[0]);
            AppMethodBeat.o(39397);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.i(39398);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.o(39398);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.o(39398);
            return true;
        }
    }
}
