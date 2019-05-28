package com.davemorrissey.labs.subscaleview.view;

import android.graphics.PointF;
import java.io.Serializable;

/* renamed from: com.davemorrissey.labs.subscaleview.view.b */
public final class C0802b implements Serializable {
    private float centerX;
    private float centerY;
    int orientation;
    float scale;

    public C0802b(float f, PointF pointF, int i) {
        this.scale = f;
        this.centerX = pointF.x;
        this.centerY = pointF.y;
        this.orientation = i;
    }
}
