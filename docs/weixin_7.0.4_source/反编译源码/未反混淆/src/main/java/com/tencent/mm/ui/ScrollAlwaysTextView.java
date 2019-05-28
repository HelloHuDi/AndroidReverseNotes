package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScrollAlwaysTextView extends TextView {
    public ScrollAlwaysTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public ScrollAlwaysTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        AppMethodBeat.i(106125);
        if (z) {
            super.onFocusChanged(z, i, rect);
        }
        AppMethodBeat.o(106125);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(106126);
        if (z) {
            super.onWindowFocusChanged(z);
        }
        AppMethodBeat.o(106126);
    }

    public boolean isFocused() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(106127);
        try {
            super.onMeasure(i, i2);
            AppMethodBeat.o(106127);
        } catch (Throwable th) {
            AppMethodBeat.o(106127);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(106128);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(106128);
        } catch (Throwable th) {
            AppMethodBeat.o(106128);
        }
    }

    public int getBaseline() {
        AppMethodBeat.i(106129);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.o(106129);
            return baseline;
        } catch (Throwable th) {
            AppMethodBeat.o(106129);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.i(106130);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.o(106130);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.o(106130);
            return true;
        }
    }
}
