package com.tencent.p177mm.plugin.story.p536ui.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.luckymoney.particles.p1280a.C28430b;
import com.tencent.ttpic.util.VideoMaterialUtil;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J@\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0014J\b\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentTipSmallConfetti;", "Lcom/tencent/mm/plugin/luckymoney/particles/confetti/Confetti;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "TAG", "", "getBitmap", "()Landroid/graphics/Bitmap;", "centerX", "", "centerY", "drawInternal", "", "canvas", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "x", "", "y", "rotation", "percentAnimated", "getHeight", "getWidth", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.e */
public final class C46288e extends C28430b {
    private final String TAG = "MicroMsg.CommentTipSmallConfetti";
    private final Bitmap bitmap;
    private final int centerX = (this.bitmap.getWidth() / 2);
    private final int centerY = (this.bitmap.getHeight() / 2);

    public C46288e(Bitmap bitmap) {
        C25052j.m39376p(bitmap, "bitmap");
        AppMethodBeat.m2504i(110365);
        this.bitmap = bitmap;
        AppMethodBeat.m2505o(110365);
    }

    public final int getWidth() {
        AppMethodBeat.m2504i(110362);
        int width = this.bitmap.getWidth();
        AppMethodBeat.m2505o(110362);
        return width;
    }

    public final int getHeight() {
        AppMethodBeat.m2504i(110363);
        int height = this.bitmap.getHeight();
        AppMethodBeat.m2505o(110363);
        return height;
    }

    /* renamed from: a */
    public final void mo26034a(Canvas canvas, Matrix matrix, Paint paint, float f, float f2, float f3, float f4) {
        float f5 = 1.0f;
        AppMethodBeat.m2504i(110364);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        C25052j.m39376p(matrix, "matrix");
        C25052j.m39376p(paint, "paint");
        float max = Math.max(1.0f - f4, 0.5f);
        if (f4 < 0.3f) {
            f5 = f4 / 0.3f;
        } else if (((double) f4) > 0.7d) {
            f5 = (1.0f - f4) / 0.3f;
        }
        int alpha = paint.getAlpha();
        matrix.preTranslate(f, f2);
        matrix.preScale(max, max, (float) this.centerX, (float) this.centerY);
        paint.setAlpha((int) (f5 * 255.0f));
        canvas.drawBitmap(this.bitmap, matrix, paint);
        paint.setAlpha(alpha);
        AppMethodBeat.m2505o(110364);
    }
}
