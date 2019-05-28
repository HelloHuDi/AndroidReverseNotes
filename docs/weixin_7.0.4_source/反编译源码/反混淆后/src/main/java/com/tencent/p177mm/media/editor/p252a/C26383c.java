package com.tencent.p177mm.media.editor.p252a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/media/editor/item/BitmapArrayEditorItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "bitmapArray", "", "Landroid/graphics/Bitmap;", "animInterval", "", "matrix", "Landroid/graphics/Matrix;", "([Landroid/graphics/Bitmap;JLandroid/graphics/Matrix;)V", "bitmaps", "", "currIndex", "", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.editor.a.c */
public final class C26383c extends C9584b {
    private final Matrix aKk;
    private final List<Bitmap> bitmaps;
    private int eUk;
    private final long eUl = 100;

    public C26383c(Bitmap[] bitmapArr, Matrix matrix) {
        C25052j.m39376p(matrix, "matrix");
        AppMethodBeat.m2504i(12877);
        this.aKk = matrix;
        this.bitmaps = new ArrayList();
        if (bitmapArr != null) {
            for (Object obj : bitmapArr) {
                if (obj != null) {
                    this.bitmaps.add(obj);
                }
            }
        }
        AppMethodBeat.m2505o(12877);
    }

    public final void init() {
    }

    public final void draw(Canvas canvas, Paint paint) {
        AppMethodBeat.m2504i(12875);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        C25052j.m39376p(paint, "paint");
        if (this.bitmaps.isEmpty()) {
            AppMethodBeat.m2505o(12875);
            return;
        }
        Bitmap bitmap = (Bitmap) this.bitmaps.get(this.eUk);
        canvas.save();
        canvas.concat(this.aKk);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.restore();
        AppMethodBeat.m2505o(12875);
    }

    /* renamed from: UH */
    public final long mo20904UH() {
        AppMethodBeat.m2504i(12876);
        if (this.bitmaps.isEmpty()) {
            AppMethodBeat.m2505o(12876);
            return Long.MAX_VALUE;
        }
        this.eUk++;
        this.eUk %= this.bitmaps.size();
        long j = this.eUl;
        AppMethodBeat.m2505o(12876);
        return j;
    }

    public final void destroy() {
    }
}
