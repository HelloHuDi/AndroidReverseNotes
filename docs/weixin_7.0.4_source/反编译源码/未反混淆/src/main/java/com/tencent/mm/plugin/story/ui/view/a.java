package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.l;
import a.v;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import com.tencent.ttpic.util.VideoMaterialUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J@\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0014J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarConfetti;", "Lcom/tencent/mm/plugin/luckymoney/particles/confetti/Confetti;", "avatarDrawable", "Landroid/graphics/drawable/LayerDrawable;", "(Landroid/graphics/drawable/LayerDrawable;)V", "TAG", "", "centerX", "", "centerY", "drawInternal", "", "canvas", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "x", "", "y", "rotation", "percentAnimated", "getHeight", "getWidth", "plugin-story_release"})
public final class a extends b {
    private final String TAG = "MicroMsg.CommentConfetti";
    private final int centerX = (this.sin.getIntrinsicWidth() / 2);
    private final int centerY = (this.sin.getIntrinsicHeight() / 2);
    private final LayerDrawable sin;

    public a(LayerDrawable layerDrawable) {
        j.p(layerDrawable, "avatarDrawable");
        AppMethodBeat.i(138893);
        this.sin = layerDrawable;
        AppMethodBeat.o(138893);
    }

    public final int getWidth() {
        AppMethodBeat.i(138890);
        int intrinsicWidth = this.sin.getIntrinsicWidth();
        AppMethodBeat.o(138890);
        return intrinsicWidth;
    }

    public final int getHeight() {
        AppMethodBeat.i(138891);
        int intrinsicHeight = this.sin.getIntrinsicHeight();
        AppMethodBeat.o(138891);
        return intrinsicHeight;
    }

    public final void a(Canvas canvas, Matrix matrix, Paint paint, float f, float f2, float f3, float f4) {
        AppMethodBeat.i(138892);
        j.p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        j.p(matrix, "matrix");
        j.p(paint, "paint");
        float f5 = 1.0f - f4;
        float f6 = 1.0f - f4;
        paint.setAlpha((int) (f6 * 255.0f));
        canvas.save();
        canvas.translate(f, f2);
        canvas.scale(f5, f5);
        Drawable drawable = this.sin.getDrawable(1);
        if (drawable == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.AvatarRoundDrawable");
            AppMethodBeat.o(138892);
            throw vVar;
        }
        ((com.tencent.mm.pluginsdk.ui.b) drawable).KK((int) (f6 * 255.0f));
        this.sin.draw(canvas);
        canvas.restore();
        AppMethodBeat.o(138892);
    }
}
