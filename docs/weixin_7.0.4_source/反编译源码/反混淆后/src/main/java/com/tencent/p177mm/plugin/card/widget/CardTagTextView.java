package com.tencent.p177mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;

/* renamed from: com.tencent.mm.plugin.card.widget.CardTagTextView */
public class CardTagTextView extends TextView {
    private int fillColor = 0;
    private int khJ = 3;
    private Paint kpQ = new Paint();
    private RectF krZ = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    private int ksa = 9;
    private int ksb = 0;

    public CardTagTextView(Context context) {
        super(context);
        AppMethodBeat.m2504i(88951);
        init();
        AppMethodBeat.m2505o(88951);
    }

    public CardTagTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(88952);
        init();
        AppMethodBeat.m2505o(88952);
    }

    public CardTagTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(88953);
        init();
        AppMethodBeat.m2505o(88953);
    }

    private void init() {
        AppMethodBeat.m2504i(88954);
        this.khJ = Math.round(C1338a.getDensity(getContext()) * 0.5f);
        this.ksa = C1338a.fromDPToPix(getContext(), 3);
        this.ksb = getCurrentTextColor();
        AppMethodBeat.m2505o(88954);
    }

    public void setTextColor(int i) {
        AppMethodBeat.m2504i(88955);
        this.ksb = i;
        super.setTextColor(i);
        AppMethodBeat.m2505o(88955);
    }

    public void setFillColor(int i) {
        this.fillColor = i;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(88956);
        this.krZ.left = (float) this.ksa;
        this.krZ.top = (float) this.khJ;
        this.krZ.right = (float) (getWidth() - this.ksa);
        this.krZ.bottom = (float) (getHeight() - this.khJ);
        this.kpQ.setAntiAlias(true);
        if (this.fillColor != 0) {
            this.kpQ.setColor(this.fillColor);
            this.kpQ.setStyle(Style.FILL);
            canvas.drawRoundRect(this.krZ, (float) ((getHeight() / 2) - this.khJ), (float) ((getHeight() / 2) - this.khJ), this.kpQ);
        }
        this.kpQ.setColor(this.ksb);
        this.kpQ.setStrokeWidth((float) this.khJ);
        this.kpQ.setStyle(Style.STROKE);
        canvas.drawRoundRect(this.krZ, (float) ((getHeight() / 2) - this.khJ), (float) ((getHeight() / 2) - this.khJ), this.kpQ);
        super.onDraw(canvas);
        AppMethodBeat.m2505o(88956);
    }
}
