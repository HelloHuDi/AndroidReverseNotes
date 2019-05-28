package com.tencent.mm.media.editor.a;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/media/editor/item/BitmapEditorItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "bitmap", "Landroid/graphics/Bitmap;", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;)V", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "", "plugin-mediaeditor_release"})
public final class d extends b {
    private final Matrix aKk;
    private Bitmap bitmap;

    public d(Bitmap bitmap, Matrix matrix) {
        j.p(matrix, "matrix");
        AppMethodBeat.i(12879);
        this.bitmap = bitmap;
        this.aKk = matrix;
        AppMethodBeat.o(12879);
    }

    public final void init() {
    }

    public final void draw(Canvas canvas, Paint paint) {
        AppMethodBeat.i(12878);
        j.p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        j.p(paint, "paint");
        canvas.save();
        canvas.concat(this.aKk);
        canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, paint);
        canvas.restore();
        AppMethodBeat.o(12878);
    }

    public final long UH() {
        return Long.MAX_VALUE;
    }

    public final void destroy() {
    }
}
