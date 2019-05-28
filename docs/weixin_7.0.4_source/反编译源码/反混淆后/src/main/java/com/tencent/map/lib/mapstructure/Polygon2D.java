package com.tencent.map.lib.mapstructure;

import android.graphics.Point;
import com.tencent.tencentmap.mapsdk.p666a.C24347di;

public class Polygon2D {
    public static final int GLPOLYGONMODE2D_BORDER = 2;
    public static final int GLPOLYGONMODE2D_FILL = 1;
    public int[] borderColor;
    public float borderWidth;
    public int borldLineId;
    public int centerX;
    public int centerY;
    public int[] color;
    public int level = C24347di.f4623c;
    public float originalRadius;
    public Point[] points;
    public int pointsCount;
    public int polygonId;
    public int polygonMode;
    public float scale = 1.0f;
    public float zIndex = 0.0f;
}
