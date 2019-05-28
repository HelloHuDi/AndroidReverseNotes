package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;

@l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fillColor", "p", "Landroid/graphics/Paint;", "radius", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setFillColor", "color", "setRadius", "plugin-card_release"})
public final class CardLabelTextView extends TextView {
    private int fillColor;
    private final Paint kpQ = new Paint();
    private float radius = ((float) a.fromDPToPix(getContext(), 1));

    public CardLabelTextView(Context context) {
        j.p(context, "context");
        super(context);
        AppMethodBeat.i(89281);
        AppMethodBeat.o(89281);
    }

    public CardLabelTextView(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        j.p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.i(89282);
        AppMethodBeat.o(89282);
    }

    public CardLabelTextView(Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        j.p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.i(89283);
        AppMethodBeat.o(89283);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(89280);
        RectF rectF = new RectF();
        rectF.left = 0.0f;
        rectF.right = (float) getWidth();
        rectF.top = 0.0f;
        rectF.bottom = (float) getHeight();
        this.kpQ.setAntiAlias(true);
        this.kpQ.setColor(this.fillColor);
        this.kpQ.setStyle(Style.FILL);
        if (canvas != null) {
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.kpQ);
        }
        super.onDraw(canvas);
        AppMethodBeat.o(89280);
    }

    public final void setFillColor(int i) {
        this.fillColor = i;
    }

    public final void setRadius(float f) {
        this.radius = f;
    }
}
