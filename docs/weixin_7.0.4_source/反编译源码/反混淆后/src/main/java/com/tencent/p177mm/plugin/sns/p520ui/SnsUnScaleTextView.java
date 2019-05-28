package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsUnScaleTextView */
public class SnsUnScaleTextView extends TextView {
    public SnsUnScaleTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SnsUnScaleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(39672);
        try {
            super.onMeasure(i, i2);
            AppMethodBeat.m2505o(39672);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(39672);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(39673);
        try {
            super.onDraw(canvas);
            AppMethodBeat.m2505o(39673);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(39673);
        }
    }

    public int getBaseline() {
        AppMethodBeat.m2504i(39674);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.m2505o(39674);
            return baseline;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(39674);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.m2504i(39675);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.m2505o(39675);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(39675);
            return true;
        }
    }
}
