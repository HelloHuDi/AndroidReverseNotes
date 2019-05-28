package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Gallery;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMGallery extends Gallery {
    public MMGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106613);
        setStaticTransformationsEnabled(true);
        AppMethodBeat.o(106613);
    }

    public MMGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106614);
        setStaticTransformationsEnabled(true);
        AppMethodBeat.o(106614);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        AppMethodBeat.i(106615);
        if (f > 0.0f) {
            onKeyDown(21, null);
        } else {
            onKeyDown(22, null);
        }
        AppMethodBeat.o(106615);
        return true;
    }
}
