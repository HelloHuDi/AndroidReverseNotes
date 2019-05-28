package com.tencent.p177mm.plugin.story.p536ui.view;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.luckymoney.particles.p1280a.C28430b;
import com.tencent.p177mm.pluginsdk.p597ui.C46503b;
import com.tencent.ttpic.util.VideoMaterialUtil;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J@\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0014J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CommentAvatarConfetti;", "Lcom/tencent/mm/plugin/luckymoney/particles/confetti/Confetti;", "avatarDrawable", "Landroid/graphics/drawable/LayerDrawable;", "(Landroid/graphics/drawable/LayerDrawable;)V", "TAG", "", "centerX", "", "centerY", "drawInternal", "", "canvas", "Landroid/graphics/Canvas;", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "x", "", "y", "rotation", "percentAnimated", "getHeight", "getWidth", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.a */
public final class C31441a extends C28430b {
    private final String TAG = "MicroMsg.CommentConfetti";
    private final int centerX = (this.sin.getIntrinsicWidth() / 2);
    private final int centerY = (this.sin.getIntrinsicHeight() / 2);
    private final LayerDrawable sin;

    public C31441a(LayerDrawable layerDrawable) {
        C25052j.m39376p(layerDrawable, "avatarDrawable");
        AppMethodBeat.m2504i(138893);
        this.sin = layerDrawable;
        AppMethodBeat.m2505o(138893);
    }

    public final int getWidth() {
        AppMethodBeat.m2504i(138890);
        int intrinsicWidth = this.sin.getIntrinsicWidth();
        AppMethodBeat.m2505o(138890);
        return intrinsicWidth;
    }

    public final int getHeight() {
        AppMethodBeat.m2504i(138891);
        int intrinsicHeight = this.sin.getIntrinsicHeight();
        AppMethodBeat.m2505o(138891);
        return intrinsicHeight;
    }

    /* renamed from: a */
    public final void mo26034a(Canvas canvas, Matrix matrix, Paint paint, float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(138892);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        C25052j.m39376p(matrix, "matrix");
        C25052j.m39376p(paint, "paint");
        float f5 = 1.0f - f4;
        float f6 = 1.0f - f4;
        paint.setAlpha((int) (f6 * 255.0f));
        canvas.save();
        canvas.translate(f, f2);
        canvas.scale(f5, f5);
        Drawable drawable = this.sin.getDrawable(1);
        if (drawable == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.AvatarRoundDrawable");
            AppMethodBeat.m2505o(138892);
            throw c44941v;
        }
        ((C46503b) drawable).mo74720KK((int) (f6 * 255.0f));
        this.sin.draw(canvas);
        canvas.restore();
        AppMethodBeat.m2505o(138892);
    }
}
