package com.tencent.p177mm.plugin.appbrand.canvas;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region.Op;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.f */
public final class C19151f extends Canvas {
    public Bitmap mBitmap;

    public C19151f(Bitmap bitmap) {
        super(bitmap);
        this.mBitmap = bitmap;
    }

    /* renamed from: g */
    public final void mo34373g(float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(103170);
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
        AppMethodBeat.m2505o(103170);
    }

    public final void setBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(103171);
        super.setBitmap(bitmap);
        this.mBitmap = bitmap;
        AppMethodBeat.m2505o(103171);
    }
}
