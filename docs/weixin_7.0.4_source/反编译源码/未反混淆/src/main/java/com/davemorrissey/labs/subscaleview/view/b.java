package com.davemorrissey.labs.subscaleview.view;

import android.graphics.PointF;
import java.io.Serializable;

public final class b implements Serializable {
    private float centerX;
    private float centerY;
    int orientation;
    float scale;

    public b(float f, PointF pointF, int i) {
        this.scale = f;
        this.centerX = pointF.x;
        this.centerY = pointF.y;
        this.orientation = i;
    }
}
