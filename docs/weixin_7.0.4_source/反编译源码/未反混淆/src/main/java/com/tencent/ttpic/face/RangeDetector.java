package com.tencent.ttpic.face;

import android.graphics.PointF;
import java.util.List;

public interface RangeDetector {
    float detectRange(List<PointF> list);
}
