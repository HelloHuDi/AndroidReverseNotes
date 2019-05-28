package com.tencent.mm.plugin.luckymoney.particles.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends b {
    private final Bitmap bitmap;
    private final float oaw;
    private final float oax;

    public a(Bitmap bitmap) {
        AppMethodBeat.i(42459);
        this.bitmap = bitmap;
        this.oaw = ((float) bitmap.getWidth()) / 2.0f;
        this.oax = ((float) bitmap.getHeight()) / 2.0f;
        AppMethodBeat.o(42459);
    }

    public final int getWidth() {
        AppMethodBeat.i(42460);
        int width = this.bitmap.getWidth();
        AppMethodBeat.o(42460);
        return width;
    }

    public final int getHeight() {
        AppMethodBeat.i(42461);
        int height = this.bitmap.getHeight();
        AppMethodBeat.o(42461);
        return height;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Canvas canvas, Matrix matrix, Paint paint, float f, float f2, float f3, float f4) {
        AppMethodBeat.i(42462);
        matrix.preTranslate(f, f2);
        matrix.preRotate(f3, this.oaw, this.oax);
        canvas.drawBitmap(this.bitmap, matrix, paint);
        AppMethodBeat.o(42462);
    }
}
