package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMFrameLayout;

public class AdFrameLayout extends MMFrameLayout {
    public AdFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void addView(View view) {
        AppMethodBeat.i(38046);
        super.addView(view);
        AppMethodBeat.o(38046);
    }

    public void removeView(View view) {
        AppMethodBeat.i(38047);
        super.removeView(view);
        AppMethodBeat.o(38047);
    }

    public void requestLayout() {
        AppMethodBeat.i(38048);
        super.requestLayout();
        AppMethodBeat.o(38048);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(38049);
        super.onDetachedFromWindow();
        AppMethodBeat.o(38049);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(38050);
        System.currentTimeMillis();
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.o(38050);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(38051);
        super.onMeasure(i, i2);
        AppMethodBeat.o(38051);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(38052);
        super.draw(canvas);
        AppMethodBeat.o(38052);
    }
}
