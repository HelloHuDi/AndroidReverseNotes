package com.tencent.filter;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MRect {
    int h;
    int w;
    int x;
    int y;

    public MRect(int i, int i2, int i3, int i4) {
        this.x = i;
        this.y = i2;
        this.w = i3;
        this.h = i4;
    }

    public static MRect toMRect(Rect rect) {
        AppMethodBeat.i(86385);
        MRect mRect = new MRect(rect.left, rect.top, rect.width(), rect.height());
        AppMethodBeat.o(86385);
        return mRect;
    }
}
