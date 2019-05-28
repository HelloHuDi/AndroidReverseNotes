package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region.Op;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f extends Canvas {
    public Bitmap mBitmap;

    public f(Bitmap bitmap) {
        super(bitmap);
        this.mBitmap = bitmap;
    }

    public final void g(float f, float f2, float f3, float f4) {
        AppMethodBeat.i(103170);
        Bitmap bitmap = this.mBitmap;
        RectF rectF = new RectF(f, f2, f3, f4);
        RectF rectF2 = new RectF(0.0f, 0.0f, (float) this.mBitmap.getWidth(), (float) this.mBitmap.getHeight());
        Op op = Op.XOR;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.clipRect(rectF);
        canvas.clipRect(rectF2, op);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, null);
        if (!(createBitmap == null || createBitmap.isRecycled())) {
            this.mBitmap.eraseColor(0);
            drawBitmap(createBitmap, 0.0f, 0.0f, null);
            createBitmap.recycle();
        }
        AppMethodBeat.o(103170);
    }

    public final void setBitmap(Bitmap bitmap) {
        AppMethodBeat.i(103171);
        super.setBitmap(bitmap);
        this.mBitmap = bitmap;
        AppMethodBeat.o(103171);
    }
}
