package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;
import com.tencent.ttpic.util.VideoMaterialUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/editor/PhotoEditText;", "Landroid/support/v7/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mBgColor", "", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "radius", "", "rectF", "Landroid/graphics/RectF;", "drawBg", "", "canvas", "Landroid/graphics/Canvas;", "onDraw", "setTextBackground", "color", "plugin-story_release"})
public final class PhotoEditText extends AppCompatEditText {
    private final Paint aFY;
    private final Path eAv;
    private int eHE;
    private final RectF kPM;
    private final float radius;

    public PhotoEditText(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        super(context, attributeSet);
        AppMethodBeat.i(110617);
        this.eAv = new Path();
        this.aFY = new Paint();
        this.kPM = new RectF();
        this.radius = (float) a.fromDPToPix(context, 12);
        this.aFY.setStyle(Style.FILL);
        this.aFY.setAntiAlias(true);
        AppMethodBeat.o(110617);
    }

    public PhotoEditText(Context context) {
        j.p(context, "context");
        this(context, null);
        AppMethodBeat.i(110618);
        AppMethodBeat.o(110618);
    }

    public final void setTextBackground(int i) {
        AppMethodBeat.i(110615);
        this.eHE = i;
        invalidate();
        AppMethodBeat.o(110615);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(110616);
        j.p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        if (this.eHE != 0) {
            int i;
            CharSequence text = getText();
            if (text == null || text.length() == 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                this.aFY.setColor(this.eHE);
                float f = this.radius * 2.0f;
                this.eAv.reset();
                if (getLineCount() != 0) {
                    float lineBottom = (((float) getLayout().getLineBottom(getLineCount() - 1)) + ((float) getPaddingTop())) + ((float) getPaddingBottom());
                    if (getLineCount() == 1) {
                        this.kPM.set(0.0f, 0.0f, (getLayout().getLineWidth(0) + ((float) getPaddingLeft())) + ((float) getPaddingRight()), lineBottom);
                        this.eAv.addRoundRect(this.kPM, this.radius, this.radius, Direction.CW);
                    } else {
                        float measuredWidth = (float) getMeasuredWidth();
                        float lineWidth = getLayout().getLineWidth(getLineCount() - 1);
                        if (lineWidth >= ((measuredWidth - f) - ((float) getPaddingLeft())) - ((float) getPaddingRight())) {
                            this.kPM.set(0.0f, 0.0f, measuredWidth, lineBottom);
                            this.eAv.addRoundRect(this.kPM, this.radius, this.radius, Direction.CW);
                        } else {
                            float lineTop = (((float) getLayout().getLineTop(getLineCount() - 1)) + ((float) getPaddingTop())) + ((float) getPaddingBottom());
                            lineWidth = (lineWidth + ((float) getPaddingRight())) + ((float) getPaddingLeft());
                            this.eAv.moveTo(0.0f, this.radius);
                            this.kPM.set(0.0f, 0.0f, f, f);
                            this.eAv.arcTo(this.kPM, 180.0f, 90.0f);
                            this.eAv.lineTo(measuredWidth - f, 0.0f);
                            this.kPM.set(measuredWidth - f, 0.0f, measuredWidth, f);
                            this.eAv.arcTo(this.kPM, 270.0f, 90.0f);
                            this.eAv.lineTo(measuredWidth, lineTop - this.radius);
                            this.kPM.set(measuredWidth - f, lineTop - f, measuredWidth, lineTop);
                            this.eAv.arcTo(this.kPM, 0.0f, 90.0f);
                            this.eAv.lineTo(this.radius + lineWidth, lineTop);
                            this.kPM.set(lineWidth, lineTop, lineWidth + f, lineTop + f);
                            this.eAv.arcTo(this.kPM, 270.0f, -90.0f);
                            this.eAv.lineTo(lineWidth, lineBottom - this.radius);
                            this.kPM.set(lineWidth - f, lineBottom - f, lineWidth, lineBottom);
                            this.eAv.arcTo(this.kPM, 0.0f, 90.0f);
                            this.eAv.lineTo(this.radius, lineBottom);
                            this.kPM.set(0.0f, lineBottom - f, f, lineBottom);
                            this.eAv.arcTo(this.kPM, 90.0f, 90.0f);
                            this.eAv.lineTo(0.0f, this.radius);
                        }
                    }
                    this.eAv.close();
                    canvas.drawPath(this.eAv, this.aFY);
                }
            }
        }
        super.onDraw(canvas);
        AppMethodBeat.o(110616);
    }
}
