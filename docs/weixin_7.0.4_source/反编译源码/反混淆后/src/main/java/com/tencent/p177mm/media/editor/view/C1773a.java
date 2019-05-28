package com.tencent.p177mm.media.editor.view;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.ttpic.util.VideoMaterialUtil;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0012\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/media/editor/view/ActiveFrameDrawable;", "Landroid/graphics/drawable/Drawable;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "basicScale", "", "framePadding", "frameRect", "frameStroke", "paint", "Landroid/graphics/Paint;", "getResources", "()Landroid/content/res/Resources;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.editor.view.a */
public final class C1773a extends Drawable {
    private final Resources aEH;
    private final Paint aFY = new Paint();
    private float eVd = 2.0f;
    private final float eVe;
    private final float eVf;
    private final float eVg;

    public C1773a(Resources resources) {
        C25052j.m39376p(resources, "resources");
        AppMethodBeat.m2504i(12925);
        this.aEH = resources;
        this.aFY.setColor(-1);
        this.aFY.setAntiAlias(true);
        this.aFY.setStrokeWidth(this.aEH.getDimension(C25738R.dimen.f10385zw));
        this.aFY.setStyle(Style.FILL);
        this.eVf = this.aEH.getDimension(C25738R.dimen.f10385zw);
        this.eVg = this.aEH.getDimension(C25738R.dimen.f10383zu);
        this.eVe = this.aEH.getDimension(C25738R.dimen.f10384zv);
        AppMethodBeat.m2505o(12925);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(12924);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        float f = ((float) getBounds().left) - (this.eVg / this.eVd);
        float f2 = ((float) getBounds().top) - (this.eVg / this.eVd);
        float f3 = ((float) getBounds().right) + (this.eVg / this.eVd);
        float f4 = ((float) getBounds().bottom) + (this.eVg / this.eVd);
        float f5 = (this.eVe / 2.0f) / this.eVd;
        this.aFY.setStrokeWidth(this.eVf / this.eVd);
        this.aFY.setAntiAlias(true);
        canvas.drawRect(f - f5, f2 - f5, f + f5, f2 + f5, this.aFY);
        canvas.drawRect(f3 - f5, f2 - f5, f3 + f5, f2 + f5, this.aFY);
        canvas.drawRect(f3 - f5, f4 - f5, f3 + f5, f4 + f5, this.aFY);
        canvas.drawRect(f - f5, f4 - f5, f + f5, f4 + f5, this.aFY);
        canvas.drawLines(new float[]{f, f2, f3, f2, f3, f2, f3, f4, f3, f4, f, f4, f, f4, f, f2}, this.aFY);
        AppMethodBeat.m2505o(12924);
    }

    public final void setAlpha(int i) {
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
