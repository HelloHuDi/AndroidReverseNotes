package com.tencent.p177mm.media.editor.p252a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/media/editor/item/BitmapEditorItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "bitmap", "Landroid/graphics/Bitmap;", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;)V", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.editor.a.d */
public final class C26384d extends C9584b {
    private final Matrix aKk;
    private Bitmap bitmap;

    public C26384d(Bitmap bitmap, Matrix matrix) {
        C25052j.m39376p(matrix, "matrix");
        AppMethodBeat.m2504i(12879);
        this.bitmap = bitmap;
        this.aKk = matrix;
        AppMethodBeat.m2505o(12879);
    }

    public final void init() {
    }

    public final void draw(Canvas canvas, Paint paint) {
        AppMethodBeat.m2504i(12878);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        C25052j.m39376p(paint, "paint");
        canvas.save();
        canvas.concat(this.aKk);
        canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, paint);
        canvas.restore();
        AppMethodBeat.m2505o(12878);
    }

    /* renamed from: UH */
    public final long mo20904UH() {
        return Long.MAX_VALUE;
    }

    public final void destroy() {
    }
}
