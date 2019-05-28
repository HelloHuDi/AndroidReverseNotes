package com.tencent.mm.y;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;

public final class b implements Cloneable {
    private static Paint eHe;
    public int mColor;
    private float mScale = 1.0f;
    private float uW = ((float) a.bu(5.0f));
    private Path vr;

    static {
        AppMethodBeat.i(116272);
        Paint paint = new Paint();
        eHe = paint;
        paint.setAntiAlias(true);
        eHe.setStyle(Style.STROKE);
        eHe.setStrokeCap(Cap.ROUND);
        AppMethodBeat.o(116272);
    }

    public b(Path path, float f, int i) {
        AppMethodBeat.i(116270);
        this.vr = path;
        this.mScale = f;
        this.mColor = i;
        AppMethodBeat.o(116270);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(116271);
        eHe.setColor(this.mColor);
        eHe.setStrokeWidth(this.uW * this.mScale);
        if (!this.vr.isEmpty()) {
            canvas.drawPath(this.vr, eHe);
        }
        AppMethodBeat.o(116271);
    }
}
