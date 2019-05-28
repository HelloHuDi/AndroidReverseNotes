package com.tencent.mm.ui.widget.progress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cg.a.a;
import com.tencent.mm.ui.aj;
import com.tencent.wxmm.v2helper;

public class RoundProgressBtn extends View {
    private Paint aFY;
    private int htZ;
    private int lAB;
    private int max;
    private int progress;
    private float sFW;
    private float zTA;
    private int zTB = 0;
    private int zTC = 0;
    private int zTD = aj.am(getContext(), R.dimen.fz);
    private int zTz;

    public RoundProgressBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(112959);
        b(context, attributeSet, 0);
        AppMethodBeat.o(112959);
    }

    public RoundProgressBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(112960);
        b(context, attributeSet, i);
        AppMethodBeat.o(112960);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        AppMethodBeat.i(112961);
        this.aFY = new Paint();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.RoundProgressBtn, i, 0);
            this.zTz = obtainStyledAttributes.getColor(3, getContext().getResources().getColor(R.color.ya));
            this.zTA = obtainStyledAttributes.getDimension(4, 0.0f);
            this.htZ = obtainStyledAttributes.getColor(2, getContext().getResources().getColor(R.color.a61));
            this.sFW = obtainStyledAttributes.getDimension(5, this.zTA);
            this.max = obtainStyledAttributes.getInt(1, 100);
            this.progress = obtainStyledAttributes.getInt(0, 0);
            this.lAB = obtainStyledAttributes.getInt(6, -90);
            obtainStyledAttributes.recycle();
        }
        AppMethodBeat.o(112961);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(112962);
        super.onDraw(canvas);
        int width = getWidth() / 2;
        if (this.zTA == 0.0f) {
            this.zTA = (float) ((int) (((double) (getWidth() / 2)) * 0.167d));
        }
        this.sFW = this.zTA;
        this.zTB = (int) this.zTA;
        this.zTC = (int) (((float) width) * 0.667f);
        int i = (int) (((float) width) - (this.zTA / 2.0f));
        this.aFY.setStrokeWidth(this.zTA);
        this.aFY.setColor(this.zTz);
        this.aFY.setAntiAlias(true);
        this.aFY.setStyle(Style.STROKE);
        canvas.drawCircle((float) width, (float) width, (float) i, this.aFY);
        this.aFY.setStrokeWidth(this.sFW);
        this.aFY.setColor(this.htZ);
        Canvas canvas2 = canvas;
        canvas2.drawArc(new RectF((float) (width - i), (float) (width - i), (float) (width + i), (float) (i + width)), (float) this.lAB, (float) ((this.progress * v2helper.VOIP_ENC_HEIGHT_LV1) / this.max), false, this.aFY);
        this.aFY.setStrokeWidth(0.0f);
        this.aFY.setStyle(Style.FILL);
        canvas.drawRect(((float) width) - (this.zTA * 1.5f), (float) (width - (this.zTC / 2)), ((float) width) - (this.zTA * 0.5f), (float) ((this.zTC / 2) + width), this.aFY);
        canvas2 = canvas;
        canvas2.drawRect((((float) this.zTB) * 0.5f) + ((float) width), (float) (width - (this.zTC / 2)), (((float) this.zTB) * 1.5f) + ((float) width), (float) ((this.zTC / 2) + width), this.aFY);
        AppMethodBeat.o(112962);
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int i) {
        AppMethodBeat.i(112963);
        this.progress = Math.max(0, i);
        this.progress = Math.min(i, this.max);
        invalidate();
        AppMethodBeat.o(112963);
    }
}
