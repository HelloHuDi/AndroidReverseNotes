package com.tencent.ttpic.util;

import android.graphics.PointF;
import java.util.List;

public class PointsWithTexcoords {
    public List<PointF> points;
    public float[] texCoords;

    public PointsWithTexcoords(List<PointF> list, float[] fArr) {
        this.points = list;
        this.texCoords = fArr;
    }
}
