package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class FabbyFaceActionCounter extends FaceActionCounter {
    public Map<Integer, PointF> scaleMap = new HashMap();

    public FabbyFaceActionCounter(int i, long j) {
        super(i, j);
        AppMethodBeat.m2504i(83481);
        AppMethodBeat.m2505o(83481);
    }
}
