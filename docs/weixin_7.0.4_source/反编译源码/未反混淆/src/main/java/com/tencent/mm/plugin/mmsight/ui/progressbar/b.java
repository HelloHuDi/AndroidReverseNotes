package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    ValueAnimator jcQ;
    a oDU;
    a oDV;
    boolean oDW = false;
    public a oDX;
    PointF oDY;
    PointF oDZ;
    PointF oEa;
    PointF oEb;
    PointF oEc;
    PointF oEd;
    float oEe = 0.0f;
    float oEf = 0.0f;
    float oEg = 0.0f;
    float oEh = 0.0f;
    Path oEi;
    private Paint oEj = null;
    float progress = 0.0f;

    public interface a {
        void a(a aVar);

        void bQN();
    }

    public b(a aVar, a aVar2, a aVar3) {
        AppMethodBeat.i(55343);
        this.oDU = aVar;
        this.oDV = aVar2;
        this.oDX = aVar3;
        this.oEf = ((float) MMSightProgressBar.lEk) * 2.0f;
        this.oEg = ((float) (-MMSightProgressBar.lEk)) * 0.5f;
        this.oEi = new Path();
        this.oEj = new Paint();
        this.oEj.setAntiAlias(true);
        this.oEj.setStyle(Style.FILL);
        AppMethodBeat.o(55343);
    }
}
