package com.tencent.p177mm.plugin.luckymoney.particles.p1280a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.luckymoney.particles.a.a */
public final class C21210a extends C28430b {
    private final Bitmap bitmap;
    private final float oaw;
    private final float oax;

    public C21210a(Bitmap bitmap) {
        AppMethodBeat.m2504i(42459);
        this.bitmap = bitmap;
        this.oaw = ((float) bitmap.getWidth()) / 2.0f;
        this.oax = ((float) bitmap.getHeight()) / 2.0f;
        AppMethodBeat.m2505o(42459);
    }

    public final int getWidth() {
        AppMethodBeat.m2504i(42460);
        int width = this.bitmap.getWidth();
        AppMethodBeat.m2505o(42460);
        return width;
    }

    public final int getHeight() {
        AppMethodBeat.m2504i(42461);
        int height = this.bitmap.getHeight();
        AppMethodBeat.m2505o(42461);
        return height;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo26034a(Canvas canvas, Matrix matrix, Paint paint, float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(42462);
        matrix.preTranslate(f, f2);
        matrix.preRotate(f3, this.oaw, this.oax);
        canvas.drawBitmap(this.bitmap, matrix, paint);
        AppMethodBeat.m2505o(42462);
    }
}
