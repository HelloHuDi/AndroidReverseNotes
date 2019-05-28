package com.tencent.mm.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NoDrawingCacheLinearLayout extends LinearLayout {
    @SuppressLint({"NewApi"})
    public NoDrawingCacheLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public NoDrawingCacheLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Bitmap getDrawingCache() {
        return null;
    }

    public Bitmap getDrawingCache(boolean z) {
        return null;
    }

    public void buildDrawingCache(boolean z) {
    }

    public void buildDrawingCache() {
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(29830);
        super.onMeasure(i, i2);
        AppMethodBeat.o(29830);
    }
}
