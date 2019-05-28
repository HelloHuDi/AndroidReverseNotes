package com.tencent.ttpic.util;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PointWithIndex {
    public int index;
    public PointF point;

    public PointWithIndex(float f, float f2, int i) {
        AppMethodBeat.i(83941);
        this.point = new PointF(f, f2);
        this.index = i;
        AppMethodBeat.o(83941);
    }
}
